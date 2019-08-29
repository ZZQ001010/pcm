/*var wiz;
$(function() {
	// 初始化
	wiz = $('#wizard_verticle').smartWizard({
		selected: 0,	// Selected Step, 0 = first step
		keyNavigation: true,	// Enable/Disable key navigation(left and right keys are used if enabled)
		enableAllSteps: false,	// Enable/Disable all steps on first load
		
		// TODO 加了动画效果会导致高度修正有延缓效果，体验不好，所以强烈推荐使用none
		transitionEffect: 'none',	// Effect on navigation, none/fade/slide/slideleft
		contentURL: null,	// content url, Enables Ajax content loading
		contentCache: true,	// cache step contents, if false content is fetched always from ajax url
		cycleSteps: false,	// cycle step navigation
		enableFinishButton: false,	// make finish button enabled always
		hideButtonsOnDisabled: false,	// when the previous/next/finish buttons are disabled, hide them instead?
		errorSteps: [],	// Array Steps with errors
		labelNext: '下一步', // Next
		labelPrevious: '上一步',	// Previous
		labelFinish: '完成',	// Finish
		noForwardJumping: false,
		onLeaveStep: function($step, fromTo) {
			// triggers when leaving a step
			//return _leaveStepCallback($step, fromTo);
			return true;
		},
		onShowStep: _onShowStep, // triggers when showing a step
		onFinish: null,	// triggers when Finish button is clicked
		
		// 自定义拓展属性
	    btnSize: 'sm',	// xs sm md lg
	    onShownStep: _onShownStep// 展示步骤后shown的回调
	});
	// 添加按钮样式
	$('.buttonNext').addClass('btn btn-default');
	$('.buttonPrevious').addClass('btn btn-default');
	$('.buttonFinish').addClass('btn btn-default');
})

// 跳转回调
var _leaveStepCallback = function($step, context) {
	// 检验基本信息表单
	if (context.fromStep == 1 && !$("#productStepCommon").valid()) {
		return false;
	}
	// 返回true才会跳转到下一步
	return true;
}
// 展示步骤中showing
var _onShowStep = function($step, context) {
//	debugger
}
// 展示步骤后shown
var _onShownStep = function($step, context) {
//	debugger
	$K.frame.autoHeight();
}

// 步骤一：
$("#productStepCommon").validate();
*/

/**
 * 产品组装显示界面构建
 */
var ProductStep = function(opt) {
	// 默认选项：对外提供的选项
	var optDef = {
		units: null,// 组件
		unitInfos: null,// 组件信息
		emptyShow: ' -- please choose -- ',// 下拉空值选项
		uuidLen: 32,// UUID的长度
		productCode: null,// 产品代码
		data: null,// 数据
		
		wiz: null// 步骤插件返回对象
	};
	// 合并选项
	var opts = $.extend(true, {}, optDef, opt);
	if (opts.uuidLen < 6) {
		opts.uuidLen = 6;
	}
	
	// 基础定义
	_click = 'click.ps';
	_hover = 'hover.ps';
	
	/**
	 * 初始化
	 * @param op 全部入参
	 */
	_init = function(op) {
		// 初始回显数据复制
		op._echoDatas = $.extend(true, {}, op.data);
		// 组件绘制
		var unitAssembles = $('#wizard_verticle > div.stepContainer > div.content > div.unit-assemble');
		$.each(unitAssembles, function(i, assemble) {
			// 水平滚动条控制
			$(this).css({'overflow-x': 'auto', 'overflow-y': 'hidden'});
			// 构建圆
			_circleBuild($(this), op.units[i], op.unitInfos, op);
		});
		// 初始回显数据删除
		delete op._echoDatas;
	};
	
	/**
	 * 一个系列的圆形绘制
	 * @param target 目标对象
	 * @param unit 当前组件
	 * @param infos 组件信息集合
	 * @param op 全部入参
	 */
	_circleBuild = function(target, unit, infos, op) {
		var tbody = _unionTable(target),
			json = _jsonAssemble(unit);
//		console.log(JSON.stringify(json));
		// 一个系列的绘制
		_circleSeries(tbody, json, infos, op);
		// 允许多选的实现
		_multipleAllow(target, unit, tbody, json, infos, op);
	};
	
	/**
	 * 允许多选的实现
	 * @param target 目标对象
	 * @param unit 当前组件
	 * @param tbody 表格的tbody主体
	 * @param json 组装好的JSON数据
	 * @param infos 组件信息集合
	 * @param op 全部入参
	 */
	_multipleAllow = function(target, unit, tbody, json, infos, op) {
		// 不支持多选
		if (unit.multiple != "Y") {
			return;
		}
		var multiAdd = $('<i class="circle-multiple fa fa-plus-circle"></i>').prependTo(target);
		multiAdd.off(_click).on(_click, function() {
			// 一个系列的绘制
			_circleSeries(tbody, json, infos, op, true);
			// 所有系列的顶级圆circle所在的格子td
			var lefts = tbody.find('> tr.circle-row > td.circle-left[lv="-1"][parent="top"]'),
				circles = lefts.find('> div.circle');
			// 左侧添加修正
			lefts.addClass('del-fix');
			// 删除现有的删除按钮
			circles.find('> i.circle-del').remove();
			// 删除按钮前面的详情、重置按钮位置修正
			circles.find('> i.circle-btn:not(i.circle-del)').addClass('del-fix');
			// 删除一个系列圆的按钮
			circles.append('<i class="circle-btn circle-del fa fa-minus-circle"></i>');
			// 删除动作绑定
			_multipleDel(tbody, circles, op);
			// 高度修正
			_fixHeight(op);
		});
	};
	
	/**
	 * 删除一个圆系列
	 * @param tbody 表格的tbody主体
	 * @param circles 所有圆系列
	 * @param op 全部入参
	 */
	_multipleDel = function(tbody, circles, op) {
		circles.find('> i.circle-del').off(_click).on(_click, function() {
			// 删除本系列
			var delUniq = $(this).closest('tr.circle-row').attr('uniq');
			tbody.find('> tr.circle-row[uniq="' + delUniq + '"]').remove();
			// 当前剩余系列
			var lefts = tbody.find('> tr.circle-row > td.circle-left[lv="-1"][parent="top"]'),
				circles = lefts.find('> div.circle');
			// 只剩一个系列就不要删除按钮了
			if (circles.length === 1) {
				lefts.removeClass('del-fix');
				circles.find('> i.circle-btn:not(i.circle-del)').removeClass('del-fix');
				circles.find('> i.circle-del').remove();
			}
			// 高度修正
			_fixHeight(op);
		});
	};
	
	/**
	 * 步骤、页面的高度修正
	 * @param op 全部入参
	 */
	_fixHeight = function(op) {
		// wizard高度修正
		op.wiz.smartWizard('fixHeight');
		$K.frame.autoHeight();
	};
	
	/**
	 * 一个系列的绘制
	 * @param tbody 表格的tbody主体
	 * @param json 组装好的JSON数据
	 * @param infos 组件信息集合
	 * @param op 全部入参
	 * @param noEcho 不执行数据回显
	 */
	_circleSeries = function(tbody, json, infos, op, noEcho) {
		// 一个系列的tr唯一码标记
		var uniq = $K.genUUID(op.uuidLen);
		// 绘制行
		_cycleRow(tbody, json, infos, "top", uniq, -1, op);
		// 行绘制后处理
		_afterProcess(tbody, uniq);
		// 数据回显
		if (!noEcho) {
			_dataEcho(tbody, json, infos, uniq, op);
		}
	};
	
	/**
	 * 每一个系列的数据回显
	 * @param tbody 表格的tbody主体
	 * @param json 组装好的JSON数据
	 * @param infos 组件信息集合
	 * @param uniq 一个系列的tr唯一码标记
	 * @param op 全部入参
	 */
	_dataEcho = function(tbody, json, infos, uniq, op) {
		if (!op._echoDatas || $.isEmptyObject(op._echoDatas)) {
			return;
		}
		var unitCode = json[0].value,
			datas = op._echoDatas[unitCode];
		var rows = tbody.find('> tr[uniq="' + uniq + '"]');
		// 循环回显
		_cycleEcho(tbody, json, rows, 'top', datas, infos, true, op);
	};
	
	/**
	 * 循环回显
	 * @param tbody 表格的tbody主体
	 * @param json 组装好的JSON数据
	 * @param rows 一个系列的所有行
	 * @param parent td的parent属性值
	 * @param datas 回显数据数组
	 * @param infos 组件信息集合
	 * @param isRoot 是否为起始父级（允许多选时标记是否为起始父级）
	 * @param op 全部入参
	 */
	_cycleEcho = function(tbody, json, rows, parent, datas, infos, isRoot, op) {
		if (!datas || !$.isArray(datas) || datas.length <= 0) {
			return;
		}
		for (var i=0; i<datas.length; i++) {
			// 数据准备data = {unitCode: xxx,productCode: xxx,paramClass: xxx,paramKey: xxx,children: [data...]}
			var data = datas[i],
				info = infos[data.unitCode];
			// 当前是起始父级，且i不为0，则说明是多选的第>=2条数据，此时需要重新构建一个系列
			if (isRoot && i != 0) {
				// 移除前一条数据，否则会造成死循环，已处理数据集合op._echoedDatas = {unitCode: [...], .....}
				// 1、已回显数据存储
				op._echoedDatas = op._echoedDatas || {};
				op._echoedDatas[data.unitCode] = op._echoedDatas[data.unitCode] || [];
				op._echoedDatas[data.unitCode].push(datas[i - 1]);
				// 2、总回显数据缩减（删除第一条，剩下的是未回显数据）
				datas.splice(0, 1);
				i --;
				// 构建新的系列
				_circleSeries(tbody, json, infos, op);
				// 上述方法_circleSeries内会嵌套执行数据回显，故此处不必再执行后续
				continue;
			}
			// 节点准备
			var td = rows.find('td.circle-left[parent="' + parent + '"]');
			if (!td || td.length <= 0) {
				continue;
			}
			for (var j=0; j<td.length; j++) {
				var currTd = td.eq(j),
					center = currTd.find('div.circle-center');
				// 节点存在校验
				if (!center || !center[0]) {
					continue;
				}
				// 匹配校验：当前待回显数据的组件代码 != 节点上的目标组件代码
				if (data.unitCode != center[0]._unitCode) {
//					console.info('跳过数据回显(含子级)，组件不匹配：data=' + data.unitCode + ', find=' + center[0]._unitCode);
					continue;
				}
				// 回显选中标记
				center[0]._paramKey = data.paramKey;
				// 回显概要显示
				_centerShow(center, data.paramKey, ctx + info['unitBaseUrl'] + '?_' + info['unitCode'], null);
				
				// 子级循环
				if (data['children']) {
					var childrenParent = currTd.attr('parent') + '/' + currTd.attr('id');
					_cycleEcho(tbody, json, rows, childrenParent, data['children'], infos, false, op);
				}
			}
			// 当前是起始父级，且数据是最后一个，标记处理完成
			if (isRoot && datas.length === 1) {
				op._echoedDatas = op._echoedDatas || {};
				op._echoedDatas[data.unitCode] = op._echoedDatas[data.unitCode] || [];
				op._echoedDatas[data.unitCode].push(data);
				// 移除最后一条未处理数据
				datas.splice(0, 1);
			}
		}
	};
	
	/**
	 * 行绘制后处理
	 * @param tbody 表格的tbody主体
	 * @param uniq 唯一码
	 */
	_afterProcess = function(tbody, uniq) {
		var uniqTrs = tbody.find('> tr[uniq="' + uniq + '"]'),
			rowspanTds = uniqTrs.find('> td.circle-left[rowspan]');
		// 多出的错行修正
		rowspanTds.each(function(i, td) {
			var currTr = $(this).parent(),
				nextTr = currTr.next();
			// 存在下一个同唯一码的TR
			if (nextTr && nextTr[0] && nextTr[0].nodeName === 'TR' && nextTr.is('[uniq="' + uniq + '"]')) {
				var nextTds = nextTr.find('> td.circle-left');
				currTr.append(nextTds);
				nextTr.remove();
			}
		});
		
		// 各行rowspan占位标记
		rowspanTds.each(function(i, td) {
			var size = parseInt($(this).attr('rowspan')),
				currTr = $(this).parent(),
				path = $(this).attr('path');
			// 行占位统计
			_countRowspan(currTr, size, path);
		});
		// 统计每行最大的TD数量
		var max = 0;
		uniqTrs.each(function(i, tr) {
			var rsc = $(this).attr('rowspancount'),
				num = parseInt(rsc ? rsc : 0) + $(this).find('> td.circle-left:not([rowspan])').length;
			// 最大数量筛选
			max = max > num ? max : num;
			// 当前行数量标记
			$(this).attr('rowspancount', num);
		});
		// 缺失空TD补充
		uniqTrs.each(function(i, tr) {
			var num = parseInt($(this).attr('rowspancount'));
				diff = max - num,
				emptyPath = $(this).attr('emptytdparent') + '/empty';
			if (diff > 0) {
				$(this).append('<td class="circle-empty-td" colspan="' + diff + '" path="' + emptyPath + '"></td>');
			}
			// 清除属性
			$(this).removeAttr('emptytdparent');
			//$(this).removeAttr('rowspancount');
		});
		// 补缺TD的path修正
		tbody.find('> tr[uniq="' + uniq + '"] > td.circle-empty-td').each(function(i, emptyTd) {
			var prevPath = $(this).attr('path').replace('/empty', ''),
				maybeParentTd = tbody.find('td.circle-left[path^="' + prevPath + '"]:not([path="' + prevPath + '"])'),
				realParentPath;
			maybeParentTd.each(function(j, parTd) {
				if (!$(this).is($(emptyTd).prev())) {
					// each里面达到continue效果，直接使用return便可；return false是break效果
					return;
				}
				var currPath = $(this).attr('path');
				realParentPath = realParentPath || currPath;
				if (currPath.length > realParentPath.length && currPath.indexOf(realParentPath) >= 0) {
					realParentPath = currPath;
				}
			});
			// 修正path
			$(this).attr('path', realParentPath + '/empty');
		});
	};
	
	/**
	 * 行占位统计
	 * @param tr 一个TR行
	 * @param size 受行占位影响的总行数（包括TR自身在内）
	 * @param parPath 空TD的父级路径
	 */
	_countRowspan = function(tr, size, parPath) {
		var rsc = tr.attr('rowspancount');
		if (rsc) {
			tr.attr('rowspancount', parseInt(rsc) + 1);
		} else {
			tr.attr('rowspancount', 1);
		}
		// 标记父级路径
		tr.attr('emptytdparent', parPath);
		// 不进行迭代标记
		if (!size) {
			return;
		}
		// 处理后续
		for (var i=1; i<size; i++) {
			tr = tr.next();
			_countRowspan(tr, null, parPath);
		}
	}
	
	/**
	 * 循环绘制行
	 * @param tbody 表格的tbody主体
	 * @return json 组装好的JSON数据
	 * @param infos 组件信息集合
	 * @param parPath 父路径
	 * @param uniq 唯一码
	 * @param lv 层级号
	 * @param op 全部入参
	 */
	_cycleRow = function(tbody, json, infos, parPath, uniq, lv, op) {
		var len = json.length;
		for (var i=0; i < len; i++) {
			var rel = json[i],
				info = infos[rel.value],
				id = $K.genUUID(op.uuidLen),
				path = parPath + '/' + id;
			
			// 行与格
			var tr = (i === 0 && len === 1 && parPath != 'top') 
					? tbody.find('td.circle-left[path="' + parPath + '"]').parent()
					: $('<tr class="circle-row" uniq="' + uniq + '"></tr>').appendTo(tbody),
				td = $('<td class="circle-left" lv="' + lv + '" id="' + id + '" path="' + path + '" parent="' + parPath + '"></td>').appendTo(tr);
			// 画当前的圆
			_circleDraw(td, info, op);
			// 子级
			var children = rel.children;
			if (children && $.isArray(children) && children.length > 0) {
				if (children.length > 1) {
					// 父级跨行修正
					_rowspanIncrease(tbody, td)
					// 跨行预定
					td.attr('rowspan', children.length);
				}
				// 循环处理
				_cycleRow(tbody, children, infos, path, uniq, (lv + 1), op);
			}
			// 动态归属样式实现
			_dynamicStyleAct(tbody, td, path);
		}
	};
	
	/**
	 * 动态归属样式动作实现
	 * @param tbody 表格的tbody主体
	 * @param td 父级TD
	 * @param path 父级TD路径
	 */
	_dynamicStyleAct = function(tbody, td, path) {
		td.hover(function() {
			tbody.find('td[path^="' + path + '"]:not([path="' + path + '"])').css('background-color', 'rgba(0, 0, 0, .05)');
		}, function() {
			tbody.find('td[path^="' + path + '"]:not([path="' + path + '"])').removeAttr('style');
		});
	};
	
	/**
	 * 跨行增长修正
	 * @param td 当前出现的含有rowspan的td
	 * @param tbody 表格的tbody主体
	 */
	_rowspanIncrease = function(tbody, td) {
		var parTd = tbody.find('td.circle-left[path="' + td.attr('parent') + '"]');
		if (parTd && parTd[0]) {
			if (parTd.is('[rowspan]')) {
				parTd.attr('rowspan', parseInt(parTd.attr('rowspan')) + 1);
			}
			_rowspanIncrease(tbody, parTd);
		}
	};
	
	/**
	 * 绘制一个圆
	 * @param tdLeft 圆容器td
	 * @param info 当前组件信息
	 * @param op 全部入参
	 */
	_circleDraw = function(td, info, op) {
		var circle = $('<div class="circle"></div>').appendTo(td),
			blank1 = $('<div class="blank-leaving"></div>').appendTo(circle),
			center = $('<div class="circle-center"></div>').appendTo(circle),
			blank2 = $('<div class="blank-leaving"></div>').appendTo(circle),
			emptyTip = $('<div class="circle-tip"></div>').appendTo(center),
			detailBtn = $('<i class="circle-btn circle-detail fa fa-list-ul"></i>').appendTo(circle),
			refreshBtn = $('<i class="circle-btn circle-delete fa fa-refresh"></i>').appendTo(circle);
		
		// 当前的参数class携带
		center[0]._paramClass = info.unitClass;
		center[0]._unitCode = info.unitCode;
		// 空选择提示内容构建
		_emptyTip(emptyTip, info, op);
		// 添加/选择动作绑定 - 点击中间部分
		// _addAct(center, info, center, op); // 详情与选择交换-郑总
		_addAct(detailBtn, info, center, op);
		// 详情按钮动作绑定
		// _detailAct(detailBtn, info, center); // 详情与选择交换-郑总
		_detailAct(center, info, center);
		// 删除/重置动作实现
		_refreshAct(refreshBtn, center);
	};
	
	/**
	 * 组件重置动作实现
	 * @param btn 动作按钮
	 * @param center 圆内部概要显示区域
	 */
	_refreshAct = function(btn, center) {
		btn.off(_click).on(_click, function() {
			_refreshFunction(center);
		});
	};
	
	/**
	 * 组件重置实现方法
	 * @param center 圆内部概要显示区域
	 */
	_refreshFunction = function(center) {
		center[0]._paramKey = null;
		center.find('div.circle-one').remove();
		center.find('div.circle-tip').show();
		// 重置子级数据
		var currTd = center.closest('td.circle-left'),
			table = currTd.closest('table.table.circle-table'),
			path = currTd.attr('path');
		if (!path) {
			return false;
		}
		$.each(table.find('td[path^="' + path + '"] div.circle-center'), function(i, c) {
			this._paramKey = null;
			$(this).find('div.circle-one').remove();
			$(this).find('div.circle-tip').show();
		});
	};
	
	/**
	 * 组件详情实现
	 * @param btn 动作按钮
	 * @param info 当前组件信息
	 * @param center 圆内部概要显示区域
	 */
	_detailAct = function(btn, info, center) {
		btn.off(_click).on(_click, function() {
			// 没有选中值
			if (!center[0]._paramKey) {
				layer.msg(lang_current === lang_zh_CN ? '请先选择一个组件' : 'Please select a unit first');
				return;
			}
			// 有值的弹窗显示详情
			$K.layerOpen({
				win: window,
				type: 2,
				title: (lang_current === lang_zh_CN ? '组件详情' : 'Unit Details'),
				content: [ctx + info['unitDetailUrl'] + '?code=' + center[0]._paramKey, 'yes'],
				area: ['80%', '80%'],
				btn: []
			});
		});
	};
	
	/**
	 * 组件添加实现
	 * @param btn 动作按钮
	 * @param info 当前组件信息
	 * @param center 圆内部概要显示区域
	 * @param op 全部入参
	 */
	_addAct = function(btn, info, center, op) {
		btn.off(_click).on(_click, function() {
			// 检查父级是否已选数据
			var currTd = center.closest('td.circle-left'),
				table = currTd.closest('table.table.circle-table'),
				parent = currTd.attr('parent');
			if (parent && parent !== 'top') {
				var parTd = table.find('td[path="' + parent + '"]'),
					parCenter = parTd.find('div.circle-center');
				if (!parCenter[0]) {
					return false;
				}
				if (!parCenter[0]._paramKey) {
					layer.msg(lang_current === lang_zh_CN ? '请先选择父级' : 'Please select parent level first');
					return false;
				}
			}
			// 请求下拉选项数据
			$K.ajax({
				url: ctx + info['unitConfigUrl'],
				type: 'post',
//				data: $K.JSON.stringify([selected]),// TODO 已选的需要排除???
				success: function(map) {
					var configArea = $('#config_select_area'),
						select = configArea.find('#config_select');
					// 下拉构建
					select.empty().append('<option value>' + op.emptyShow + '</option>');
					for (var code in map) {
						select.append('<option value="' + code + '">' + (map[code] || code) + '</option>');
					}
					select.data('size', '6').selectpicker('val', center[0]._paramKey || '').selectpicker('refresh');
					// 弹窗选择
					$K.layerOpen({
						win: window,
						type: 1,
						title: (lang_current === lang_zh_CN ? '组件选择' : 'Unit Select'),
						content: configArea,
						btn: [$K.msg.text($K.msg.common.confirm, '确定'), $K.msg.text($K.msg.common.cancel, '取消')],
						yes: function(index, layero) {
							var unitCode = select.selectpicker('val');
//							layer.msg(unitCode);
							// center上面的选中值携带
							center[0]._paramKey = unitCode;
							// 概要显示
							_centerShow(center, unitCode, ctx + info['unitBaseUrl'] + '?_' + info['unitCode'], index);
						},
						end: function() {
							select.empty().append('<option value>' + op.emptyShow + '</option>').selectpicker('refresh');
						}
					});
				}
			});
		});
	};
	
	/**
	 * 圆内部的概要显示
	 * @param center 圆内部概要显示区域
	 * @param unitCode 选中的组件代码
	 * @param baseUrl 概要信息请求地址
	 * @param index 选择弹窗的索引
	 */
	_centerShow = function(center, unitCode, baseUrl, index) {
		// 清除上一次的
		center.find('div.circle-one').remove();
		// 没选值，恢复原样
		if (!unitCode) {
			// center.find('div.circle-tip').show();
			_refreshFunction(center);
			layer.close(index);
			return;
		}
		// 有选值，请求概要数据并回显
		$K.ajax({
			url: baseUrl + '_' + unitCode,
			type: 'post',
			data: {code: unitCode},
			success: function(list) {
				// 隐藏添加提示
				center.find('div.circle-tip').hide();
				// 构建概要
				var height = 100 / list.length;
				for (var i in list) {
					if (parseInt(i) >= 6) {
						console.info('参数省略.circle-one数据(>6)：' + list[i]);
					} else {
						$('<div class="circle-one">' + list[i] + '</div>').css({'height': height + '%'}).appendTo(center);
					}
				}
				if (index) {
					layer.close(index);
				}
			}
		});
	};
	
	/**
	 * 空选择提示内容构建
	 * @param emptyTip 概要内的提示区域
	 * @param op 全部入参
	 */
	_emptyTip = function(emptyTip, info, op) {
		var str = lang_current === lang_zh_CN ? (op.emptyShow.replaceAll('-', '').replaceAll(' ', '').trim() + info.unitNameCn) : info.unitName;
		emptyTip.text(str);
	};
	
	/**
	 * 总的JSON数据组装
	 * @param unit 当前组件
	 * @return json 组装好的JSON数据
	 */
	_jsonAssemble = function(unit) {
		var json = {value: unit.unitModule},
			children;
		if (unit.unitRelations) {
			children = JSON.parse(unit.unitRelations);
		}
		if (children || children.length > 0) {
			json['children'] = children;
		}
		return [json];
	};
	
	/**
	 * 总的联合表格绘制
	 * @param target 目标对象
	 * @return tbody 表格的body部分
	 */
	_unionTable = function(target) {
		var table = $('<table class="table circle-table"></table>').appendTo(target),
			tbody = $('<tbody></tbody>').appendTo(table);
		return tbody;
	};
	
	/*
	 * =================== Method ===================
	 */	
	/**
	 * 获取组装好的有效数据
	 * @return array?[] 组装好的有效数据
	 */
	_getValidAssemble = function() {
		// 获取所有有值的组件集合
		var tds = $('#wizard_verticle > div.stepContainer > div.content > div.unit-assemble td.circle-left'),
			temp = new Array(),
			array = new Array();
		// 获取所有有值的数据
		$.each(tds, function(i, td) {
			var data = _singleData($(this));
			if (data) {
				temp.push(data);
			}
		});
		// 删掉父级为空的无效数据
		$.each(temp, function(i, data) {
			for (var j in temp) {
				if (data.pid === temp[j].id || data.pid === '') {
					array.push(data);
					break;
				}
			}
		});
		// 对象关联关系构建
		$.each(array, function(i, data) {
			for (var j in array) {
				if (data.pid === array[j].id) {
					data.parentParamClass = array[j].paramClass;
					data.parentParamKey = array[j].paramKey;
					break;
				}
			}
		});
		// 删除组装属性
		$.each(array, function(i, data) {
//			delete data.id;
			delete data.pid;
		});
		return array;
	};
	
	/**
	 * 单个数据的组装
	 * @param td 一个TD的jQuery对象
	 * @return object/{} 组装对象
	 */
	_singleData = function(td) {
		var center = td.find('> div.circle > div.circle-center');
		if (!center[0]._paramClass || !center[0]._paramKey || !center[0]._unitCode) {
			return false;
		}
		var parent = td.attr('parent'),
			list = parent.split('/'),
			len = list.length,
			pid = len === 1 ? '' : list[len - 1];
		return {
			// 代码属性
			paramClass: center[0]._paramClass,
			paramKey: center[0]._paramKey,
			unitCode: center[0]._unitCode,
			productCode: opts.productCode,
			parentParamClass: null,
			parentParamKey: null,
			// 组装属性
			id: td.attr('id'),
			pid: pid,
			parentId: pid
		};
	};
	
	/*
	 * =================== init & return ===================
	 */
	// 执行初始化方法
	_init(opts);
	
	// 返回方法
	return {
		getValidAssemble: _getValidAssemble
	}
}