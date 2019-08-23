/**
 * -----------------
 * --- 关联选择器 ---
 * -----------------
 * 由一个存在的下拉框开始构建分层选择组件
 * associatedSelector.js
 * 
 * 2018.08.13 - 2018.08.16
 * by: zco
 * usage: var ascSlt = new AssociatedSelector({opt...});
 */
var AssociatedSelector = function(opt) {
	// 默认值
	var optDef = {
		select: null,// 原始下拉select
		units: null,// 原始下拉数据<key, Object>
		target: null,// 生成目标块级元素DIV
		emptyShow: ' -- please choose -- ',// 下拉空值选项
		optionKey: null,// 下拉选项展示值的key值
		rowUuidLen: 32,// 行UUID长度
		readOnly: false,// 只读状态（selectpicke没有readonly属性控制，用disabled加样式修改实现）
		halfReadOnly: false,// 半只读状态：只有原始下拉select是只读，关联下拉select正常，适合用在编辑页面，该属性生效需在readOnly=false的前提下
		data: []// 初始化数据
	};
	// 合并选项
	var opts = $.extend(true, {}, optDef, opt);
	if (opts.rowUuidLen < 6) {
		opts.rowUuidLen = 6;
	}
	
	// 基础定义：关联数据集合，change事件命名，click事件命名
	_relMapCollection = {},
	_changeEvent = 'change.ascslt';
	_click = 'click.ascslt';
	
	/**
	 * target初始化，原始下拉select的change事件绑定
	 * @param tSlt 原始下拉
	 * @param target 初始化目标容器
	 * @param op 全部入参
	 */
	_init = function(tSlt, target, op) {
		// 原始select去样式
		tSlt.removeClass('unit-relation');
		// 目标对象加样式
		target.addClass('unit-relation u-r-div').attr('target', '#' + tSlt.attr('id'));
		// 初始构建第一行0级关联下拉
		var row = _buildRow(target, tSlt, op, 0, /*'top_' + */target.attr('target'), false);
		// 原始下拉select的change事件绑定
		_bindChange(tSlt, op);
		// 初始化数据
		_cycleData(row, op.data, true);
	};
	
	/**
	 * 初始化传入关联数据循环构建 addChild addLevel
	 * @param row 初始化构建的第一行
	 * @param data 初始化数据
	 * @param isInitRow 是否为初始化的第一行
	 */
	_cycleData = function(row, data, isInitRow) {
		// 无初始化数据，或非Array格式，或空数据
		if (!data || !$.isArray(data) || $.isEmptyObject(data)) {
			return;
		}
		for (var i in data) {
			var da = data[i];
				genRow = row;
			if (i != 0 && (isInitRow || data.length > 1)) {
				genRow = row.addLevel();
			}
			// 当前行选中值
			genRow.selectVal(da['value']);
			// 有子级数据，则循环
			if (da['children']) {
				_cycleData(genRow.addChild(), da['children'], false);
			}
		}
	};
	
	/**
	 * 构建行row
	 * @param target 目标对象
	 * @param pSlt 父层级select
	 * @param op 全部入参
	 * @param lv 当前层级
	 * @param parPath 父层级路径
	 * @param isIteration 是否仅自身迭代（从自身层级开始往下层子级迭代处理）
	 * @return row 构建好的行
	 */
	_buildRow = function(target, pSlt, op, lv, parPath, isIteration) {
		var uuid = $K.genUUID(op.rowUuidLen),
			path = parPath + '/' + uuid,
			row = $('<div level="' + lv + '" path="' + path + '" parent="' + parPath + '" id="' + uuid + '"></tr>'),
			left = $('<div class="unit-float-left"></div>').appendTo(row),
			slt = $('<select class="form-control unit-relation unit-float"><option value>' + op.emptyShow + '</select>').appendTo(row),
			actions = $('<div class="unit-actions"></div>').appendTo(row),
			addChild = $('<a href="javascript:;"><i class="fa fa-plus-square"></i></a>').appendTo(actions),
			addLevel = $('<a href="javascript:;"><i class="fa fa-plus-square-o"></i></a>').appendTo(actions),
			del = $('<a href="javascript:;"><i class="fa fa-minus-square-o"></i></a>').appendTo(actions);
		
		// 预处理
		_preDeal(row, slt, actions, op);
		// 计算缩进indent
		_calcIndent(left, slt, lv);
		// 缩进区域的父子连接线构建
		_connectionLine(left, lv);
		// 操作按钮的动作实现
		_actionsAct(row, actions, addChild, addLevel, del, lv, slt, op);
		// 将row追加到target中的正确位置
		_appendRow(target, row, lv, parPath);
		// 下拉选项的构建：初始化
		_optionsBuild(pSlt, slt, true, isIteration, op);
		// 绑定change事件
		_bindChange(slt, op);
		// 缩进区域的父子连接线重新组织
		_connectionReorganize(op);
		// 返回row
		return row;
	};
	
	/**
	 * 预处理
	 * @param slt 当前层级select
	 * @param actions 操作按钮区域
	 * @param op 全部入参
	 */
	_preDeal = function(row, slt, actions, op) {
		// 层级号在行DOM元素上携带
		row[0]._lv = parseInt(row.attr('level'));
		// 下拉框selectpicker初始化值
		slt.data("none-selected-text", op.emptyShow).data('size', '6');
		// 只读处理
		if (op.readOnly) {
			slt.attr("disabled", "true").addClass('sltpicker-readonly');
			actions.css({'display': 'none'});
		}
		// 半只读处理：原始下拉select只读
		if (op.halfReadOnly || op.readOnly) {
			op.select.attr("disabled", "true").addClass('sltpicker-readonly');
		}
	}
	
	/**
	 * 下拉选项构建
	 * @param pSlt 父层级select
	 * @param slt 当前层级select
	 * @param isInit 是否为新增行
	 * @param isIteration 是否仅自身迭代（从自身层级开始往下层子级迭代处理）
	 * @param op 全部入参
	 */
	_optionsBuild = function(pSlt, slt, isInit, isIteration, op) {
		// 思路：从当前层级开始逐级向下构建
		
		var pKeyList = _getPrevs(pSlt, new Array(), op),
			pKey = pSlt.val(),
			isTop = !pSlt.is('select.unit-relation'),
			pRow = pSlt.closest('div[level]'),
			pLv = isTop ? 0 : parseInt(pRow.attr('level')),
			row = slt.closest('div[level]');
		// 下一层级
		var lv = (pLv == 0 && isTop) ? pLv : pLv + 1;
		// 父层级的关联集合
		var units = lv == 0 ? op.units : _relMapCollection[pLv];
		// 当前层级的下拉选项关联map集合
		var relMap = _relMapCollection[lv];
		// 关联集合里面没有该级数据集合或该集合里面存在当前选中的pKeyList值，则需要重新赋值
		if (!relMap || _anyInMap(pKeyList, relMap)) {
			// 构建下一层级的下拉选项map
			var relUnits = $.extend(true, {}, units);
			$.each(pKeyList, function(i, k) {
				delete relUnits[k];
			});
			relMap = _relMapCollection[lv] = relUnits;
		}
		
		// 后裔查询属性构建
		parentPath = '';
		// 入参的父级select是当前层级select
		if (pSlt.is(slt)) {
			// 事件发生在原始select上
			if (slt.is(op.select)) {
				parentPath = '';
			} else {
				parentPath = '[parent="' + pRow.attr('path') + '"]';
			}
		} else {
			parentPath = '[parent="' + row.attr('parent') + '"]';
		}
		// 遍历该层级及该层级下的后裔层级
		var nextLvRows = (isIteration && !slt.is(op.select)) ? row : op.target.find('div[level="' + lv + '"]' + parentPath);
		nextLvRows.each(function(i, nextLvRow) {
			var path = $(this).attr('path'),
				select = $(this).find('select.unit-relation'),
				val = select.val(),
				lang = op.optionKey;
			// 先重新构建下拉
			_clearOpt(select);
			// 传入有选值
			if (pKey) {
				if (isInit && !pKey) {
					// 初始化，不需要构建下拉
				} else {
					for (var k in relMap) {
						select.append('<option value="' + k + '">' + relMap[k][lang] + '</option>');
					}
					select.selectpicker('refresh');
				}
			}
			// 不是初始化，父级选中值不为空，该行原本的选中值不为空，和父级的现值不一样，则恢复原本选中
			if (!isInit && pKeyList && val && pKeyList.indexOf(val) < 0) {
				select.selectpicker('val', val);
			} else {
				select.selectpicker('val', '');
			}
			// 嗅探下一层，嵌套执行（只处理子级，排除孙辈或更后级）
			var moreNextRows = $(this).parent().find('div[level="' + (lv + 1) + '"][path^="' + path + '"]');
			moreNextRows.each(function(j, moreNextRow) {
				// 路径path的分割长度
				var len = $(this).attr('path').split('/').length,
					lev = parseInt($(this).attr('level')),
					mnSlt = $(this).find('select.unit-relation');
				// 判断是子级的标志：len === lev + 2，排除孙辈及更后级
				if (len === (lev + 2)) {
					_optionsBuild(select, mnSlt, isInit, false, op);
				}
			});
		});
	};
	
	/**
	 * 获取前面层级所有的下拉框中选中的非空值
	 * @param pSlt 父级select
	 * @param list 传入空集合
	 * @param op 全部入参
	 * @return list 返回前面层级的所有非空选中值的集合
	 */
	_getPrevs = function(pSlt, list, op) {
		if (op.select.val() && (list.indexOf(op.select.val()) < 0)) {
			list.push(op.select.val());
		}
		if (pSlt.val()) {
			list.push(pSlt.val());
		}
		var parRow = op.target.find('div[level][path="' + pSlt.closest('div[level]').attr('parent') + '"]');
		if (parRow && parRow.length > 0) {
			list = _getPrevs(parRow.find('select.unit-relation'), list, op);
		}
		return list;
	};
	
	/**
	 * list中任何一个值作为key在map中有匹配键值对
	 * @param list 传入key集合
	 * @param map 待判断的map集合
	 * @return boolean 判断结果
	 */
	_anyInMap = function(list, map) {
		var anyIn = false;
		for (var i in list) {
			var val = map[list[i]];
			if (val || val == true || val == false) {
				anyIn = true;
				break;
			}
		}
		return anyIn;
	};
	
	/**
	 * 计算行缩进
	 * @param left 左侧缩进空白区域div
	 * @param slt 右侧select
	 * @param lv 当前层级
	 */
	_calcIndent = function(left, slt, lv) {
		var indent = (lv == 0) ? 0 : (5 * lv);
		left.css({'width': indent + '%'});
		slt.addClass('unit-float unit-float-' + lv);
	};
	
	/**
	 * 缩进区域的父子连接线构建
	 * @param left 当前层级的左侧缩进
	 * @param lv 当前层级
	 */
	_connectionLine = function(left, lv) {
		// 级别为0的无需处理
		if (lv == 0) {
			return;
		}
		// 计算每格宽度百分比
		var width = (100 / lv) + '%';
		for (var i=0; i<lv; i++) {
			var ulc = ' unit-line-' + lv,/* 当前层级标记 */
				ulcg = ulc + '-' + i,/* 当前层级的第几个格子标记 */
				cellNo = ' cell-' + i,/* 当前是第几个格子（没有层级） */
				cls = 'unit-line' + ulc + ulcg + cellNo;/* 格子上的总样式 */
			left.append('<div class="' + cls + '" style="width:' + width + '"></div>');
		}
	};
	
	/**
	 * 缩进区域的父子连接线重新组织
	 * @param op 全部入参
	 */
	_connectionReorganize = function(op) {
		// 先移除所有的T、I线型样式
		op.target.find('div.unit-line.cell-t').removeClass('cell-t');
		op.target.find('div.unit-line.cell-i').removeClass('cell-i');
		// 查找所有行
		var rows = op.target.find('div[level]');
		// 没有数据或只有一条数据，则无需处理
		if (!rows || rows.length <= 1) {
			return;
		}
		// 查找所有0级的
		var zeroRows = op.target.find('div[level="0"]');
		// 父子线型处理线型处理
		_cycleLine(zeroRows, op);
	};
	
	/**
	 * 父子线型处理
	 * @param rows 一个层级的行row集合
	 * @param op 全部入参
	 */
	_cycleLine = function(rows, op) {
		var len = rows.length;
		for (var i=0; i<len; i++) {
			var row = rows[i],
				lv = row._lv;
			// 不是该级最后一行row
			if (i != len - 1) {
				var cell = row.children[0].children[lv - 1];
				// 添加T型线
				if (cell) {
					cell.classList.add('cell-t');
				}
				// 添加I型线：查找parent为row的行（该行的后裔行posterity）
				var path = row.getAttribute('path'),
					posterity = op.target.find('div[level][parent^="' + path + '"]');
				for (var j in posterity) {
					var rowChildren = posterity[j].children;
					if (!rowChildren) {
						continue;
					}
					var left = rowChildren[0];
					if (!left) {
						continue;
					}
					var cel = left.children[lv - 1];
					if (cel) {
						cel.classList.add('cell-i');
					}
				}
			}
			// 循环处理下一级
			var nextLv = lv + 1,
				parPath = row.getAttribute('path'),
				nextRows = op.target.find('div[level="' + nextLv + '"][parent="' + parPath + '"]');
			_cycleLine(nextRows, op);
		}
	};
	
	/**
	 * 三个按钮的操作实现；在行对象row上注册添加子级、添加同级、当前选中值方法
	 * @param row 当前操作行
	 * @param actions 当前操作行的按钮区域
	 * @param addChild 添加子级按钮
	 * @param addLevel 添加同级按钮
	 * @param del 删除当前及后裔按钮
	 * @param lv 当前层级
	 * @param op 全部入参
	 */
	_actionsAct = function(row, actions, addChild, addLevel, del, lv, slt, op) {
//		// 操作按钮区域的显隐
//		row.hover(function() {
//			actions.fadeIn();
//		}, function() {
//			actions.hide();
//		});
		// 三个操作按钮的实现
		addChild.off(_click).on(_click, function() {
			// 构建子级行
			_addChildRow(this, op);
			// 调整高度
			$K.frame.autoHeight();
		});
		addLevel.off(_click).on(_click, function() {
			// 构建同级行
			_addLevelRow(this, op);
			// 调整高度
			$K.frame.autoHeight();
		});
		del.off(_click).on(_click, function() {
			// 删除逻辑
			_deleteRow(this);
		});
		
		// 将三个按钮功能加到行row上，供有初始化数据的时候使用
		row.addChild = function() {return _addChildRow(addChild, op);};
		row.addLevel = function() {return _addLevelRow(addLevel, op);};
		row.selectVal = function(val) {slt.selectpicker('val', val).selectpicker('refresh')};
	}
	
	/**
	 * 添加子级行
	 * @param ele 添加子级小按钮元素
	 * @param op 全部入参
	 * @return 构建的子级行
	 */
	_addChildRow = function(ele, op) {
		var row = $(ele).closest('div[level]'),
			lv = parseInt(row.attr('level')) + 1,
			pSlt = row.find('select.unit-relation'),
			parPath = row.attr('path'),
			childRow = _buildRow(op.target, pSlt, op, lv, parPath, true);
		return childRow;
	};
	
	/**
	 * 添加同级行
	 * @param ele 添加同级小按钮元素
	 * @param op 全部入参
	 * @return 构建的同级行
	 */
	_addLevelRow = function(ele, op) {
		var row = $(ele).closest('div[level]'),
			lv = parseInt(row.attr('level')),
			parPath = row.attr('parent'),
			pSlt = parPath.split('/').length === 1 ? op.select : op.target.find('div[level][path="' + parPath + '"]').find('select.unit-relation'),
			levelRow = _buildRow(op.target, pSlt, op, lv, parPath, true);
		return levelRow;
	};
	
	/**
	 * 删除行row: 删除当前行及后裔，清理无存在行的关联map
	 * @param delEle 删除动作触发元素
	 */
	_deleteRow = function(delEle) {
		// 删除逻辑
		var delRow = $(delEle).closest('div[level][path]'),
			delPath = delRow.attr('path');
		$(delEle).closest('.u-r-div').find('div[level][path^="' + delPath + '"]').each(function(i, row) {
			var lv = parseInt($(this).attr('level'));
			if (lv == 0) {
				// 第0级的要判断除了当前的还有没有其它的0级，有则允许删除，无则不允许删除
				var zeroRows = $(this).closest('.u-r-div').find('div[level="0"][path]');
				if (zeroRows && zeroRows.length > 1 && $(this).is(delRow)) {
					$(this).remove();
				}
			} else {
				// 需要删除行的后裔子级直接删掉
				if ($(this).attr('path').indexOf(delPath) >= 0) {
					$(this).remove();
				}
			}
		});
		// 缩进区域的父子连接线重新组织
		_connectionReorganize(opts);
		// 调整高度
		$K.frame.autoHeight();
		// 清除各级的关联map集合_relMapCollection
		var exist = new Array();
		opts.target.find('div[level]').each(function(i, row) {
			var lv = parseInt($(this).attr('level'));
			if (exist.indexOf(lv) < 0) {
				exist.push(lv);
			}
		});
		for (var lv in _relMapCollection) {
			if (exist.indexOf(parseInt(lv)) < 0) {
				delete _relMapCollection[lv];
			}
		}
	}
	
	/**
	 * 将row追加到target中的正确位置
	 * @param target 目标对象
	 * @param nRow 新的传入row
	 * @param lv 新row行的层级
	 * @param parPath 新row行的父层级路径
	 */
	_appendRow = function(target, nRow, lv, parPath) {
		// 初始化下拉框
		nRow.find('select.unit-relation').selectpicker();
		// 第0级，直接追加到
		if (lv == 0) {
			target.append(nRow);
			return;
		}
		// 其它层级
		var parRow = target.find('div[level="' + (lv - 1) + '"][path="' + parPath + '"]');
		if (parRow && parRow[0]) {
			// 获取该父级的所有后裔(后裔：posterity，[attribute^=value]释义：属性attribute值以value开头的所有对象集合)
			var posterity = target.find('div[level][path^="' + parPath + '"]'),
				appendTarget = (posterity && posterity.length > 0) ? $((posterity[posterity.length - 1])) : target;
			appendTarget.after(nRow);
		} else {
			layer.msg('没有找到父级，无法追加');
		}
	}
	
	/**
	 * 子级下拉改变事件绑定
	 * @param slt 子级下拉select
	 * @param op 全部入参
	 */
	_bindChange = function(slt, op) {
		slt.off(_changeEvent).on(_changeEvent, function() {
			_optionsBuild($(this), $(this), false, false, op);
		});
	};
	
	/**
	 * 将下拉的选项清空，支持传select、row
	 * @param selectOrRow 需要清空选项的select或其父行row
	 */
	_clearOpt = function(selectOrRow) {
		// 判断类型
		if ($(selectOrRow).is('div[level]')) {
			selectOrRow = $(selectOrRow).find('select.unit-relation');
		}
		// 重置
		$(selectOrRow).empty().append('<option value>' + opts.emptyShow + '</option>');
		// 刷新
		$(selectOrRow).selectpicker('refresh');
	};
	
	/*
	 * =================== Method ===================
	 */
	/**
	 * auxiliary method|方法辅助: 行数据构建
	 * @param row 数据行
	 * @return object 行数据对象
	 */
	_RowData = function(row) {
		var parent = row.attr('parent'),
			array = parent.split('/'),
			len = array.length,
			pid = len === 1 ? '' : array[len - 1];
		return {
			// select
			value : row.find('select.unit-relation').val(),
			// row
			id : row.attr('id'),
			pid : pid/*,
			level : parseInt(row.attr('level')),
			path : row.attr('path'),
			parent : parent*/
		}
	};
	
	/**
	 * Method|方法: 获取有效的行数据list集合
	 * @return rows 有效行数据list
	 */
	_getValidDatas = function() {
		var rows = new Array();
		opts.target.find('div[level][path]').each(function(i, row) {
			var data = _RowData($(row));
			if (data && data.value) {
				rows.push(data);
			}
		});
		return rows;
	};
	
	/**
	 * auxiliary method|方法辅助: 组装大对象
	 * @param datas 有效行数据
	 * @param isOrigin 是否为原始数据
	 * @return 组装的大对象
	 */
	_dataAssemble = function(datas, isOrigin) {
		var assemble = [];
		$.each(datas, function(i, data) {
			$.each(datas, function(j, da) {
				if (da.pid == data.id) {
					if (!data['children']) {
						data['children'] = new Array();
					}
					data['children'].push(da);
				}
			});
			if (!data.pid) {
				assemble.push(data);
			}
		});
		if (!isOrigin) {
			$.each(datas, function(i, da) {
				delete da['id'];
				delete da['pid'];
			});
		}
		return assemble;
	}
	
	/**
	 * Method|方法: 获取组装好的有效行数据（不包含id/pid属性）
	 */
	_getValidAssemble = function() {
		return _dataAssemble(_getValidDatas(), false);
	};
	/**
	 * Method|方法: 获取组装好的有效行数据（包含id/pid属性）
	 */
	_getValidOriginAssemble = function() {
		return _dataAssemble(_getValidDatas(), true);
	}
	
	/*
	 * =================== init & return ===================
	 */
	// 执行初始化方法
	_init(opts.select, opts.target, opts);
	
	// 返回方法
	return {
		// 获取有效的行数据list集合
		//getValidDatas: _getValidDatas,
		// 获取组装好的有效行数据（不包含id/pid属性）
		getValidAssemble: _getValidAssemble,
		// 获取组装好的有效行数据（包含id/pid属性）
		//getValidOriginAssemble: _getValidOriginAssemble
	};
};