/**
 * create by nasir farhadi email : nasirfarhadi92@gmail.com Github :
 * nasirfarhadi92
 * 
 * modify by zco
 */
var CircleWeb = function() {
	
	var _circileWebOpt = {
    	container: $('div.dotCircle'),
    	fields: $('.itemDot'),
    	ciContent: $('div.contentCircle'),
    	len: 0,
    	numAngle: 360,
    	rotateInterval: null,
    	i: 1
	};
	
	_circileWebOpt.len = _circileWebOpt.fields.length;
	_circileWebOpt.numAngle = 360 / _circileWebOpt.len;
	
    _init = function(op) {
    	// 布局输出
    	_layout(op);
    	// 背景序号显示
    	_sortNum(op);
    	// 点击绑定
    	_dotClick(op);
    	// 初始点击
    	$('.itemDot1').triggerHandler('click');
    	// div.ci-item-one高度调整
    	_ciHeight(op);
    };
    
    _ciHeight = function(op) {
    	op.ciAdjust = setInterval(function() {
    		var all = op.ciContent.find('> div.CirItem'),
    		loaded = all.filter('[ci_loaded]'),
    		loadedSize = loaded.length;
// if (loadedSize < op.len - 1) {
    			loaded.find('div.ci-item-one').each(function() {
    				$(this).css({'line-height': $(this).css('height')});
    			});
// layer.msg('all loaded', {time: 100});
// } else {
// clearInterval(op.ciAdjust);
// delete op.ciAdjust;
// layer.msg('all loaded');
// }
    	}, 200);
    };
    
	// 布局输出
    _layout = function(op) {
    	var radius = 200,
	    	width = op.container.width(),
	    	height = op.container.height(),
	    	angle = 0,
			step = (2 * Math.PI) / op.len;
    	
    	radius = width / 2.5;
    	
    	op.fields.each(function() {
            var x = Math.round(width / 2 + radius * Math.cos(angle) - $(this).width() / 2);
            var y = Math.round(height / 2 + radius * Math.sin(angle) - $(this).height() / 2);
            $(this).css({
                left: x + 'px',
                top: y + 'px'
            });
            angle += step;
        });
    };
	
    // 背景序号显示
    _sortNum = function(op) {
    	var dynamicStyle = $('style#_dot_dynamic_style');
    	// 各个小圆的背景序号
    	$('span.itemDot[data-tab]').each(function(i, dot) {
    		if (!dynamicStyle || dynamicStyle.length <= 0) {
    			dynamicStyle = $('<style id="_dot_dynamic_style">.dotCircle [class*="itemDot"]:before {font-size:50px;opacity:0.3;text-align:center;}</style>');
    			$('head:last').append(dynamicStyle);
    		}
    		var str = dynamicStyle.text(),
    			num = $(this).data('tab');
    		str += '.dotCircle .itemDot' + num + ':before {content:"' + num + '"}';
    		dynamicStyle.text(str);
    	});
    	// 中间大圆的背景序号
    	$('div.CirItem[data-tab]').each(function(i, item) {
    		var str = dynamicStyle.text(),
    			num = $(this).data('tab');
    		str += '.contentCircle .CirItem.CirItem' + num + ':before {content:"' + num + '"}';
    		dynamicStyle.text(str);
    	});
    };
    
    // 点击绑定
    _dotClick = function(op) {
    	$('.itemDot').click(function() {
    		// 执行操作
    		var dataTab = $(this).data("tab");
    		$('.itemDot').removeClass('active');
    		$(this).addClass('active');
    		$('.CirItem').removeClass('active');
    		$('.CirItem' + dataTab).addClass('active');
    		op.i = dataTab;
    		// 旋转动作
    		_doRotate($('.CirItem' + dataTab), dataTab, op.numAngle, op);
// op.i ++;
    	});
    };

	// 旋转动作
    _doRotate = function($CirItem, i, numAngle, op) {
		// 清除当前定时
		clearInterval(op.rotateInterval);
    	// 数据加载
    	if ($CirItem && $CirItem[0] && !$CirItem.is('[ci_loaded]') && i != 1) {
    		$K.ajax({
    			type: 'post',
    			url: $CirItem.data('base') + '?_' + $CirItem.data('tab') + '_' + $CirItem.data('unit') + '_' + $CirItem.data('code'),
    			data: {code: $CirItem.data('code')},
    			success: function(list) {
    				// 值显示处理
    				var maxLen = list.length >= 6 ? 6 : list.length,
    					hgt = (70 / maxLen) + '%';
    				$CirItem.empty();
    				for (var j=0; j<maxLen; j++) {
    					var one = $('<div class="ci-item-one">' + list[j] + '</div>').css({'height': hgt}).appendTo($CirItem);
    					one.css({'line-height': one.css('height')});
    				}
    				// 标记已加载
    				$CirItem.attr('ci_loaded', true);
    			}
    		});
    	}
    	// 重新计算one的高度
    	$CirItem.find('div.ci-item-one').each(function() {
    		$(this).css({'line-height': $(this).css('height')});
    	});
    	
    	var ag = (i - 1) * numAngle;
    	if (ag === 0 && op.len == 1) {
    		var dtAgmatrix = tf = _getStyle($('.dotCircle'), 'transform');
    		if ('none' != dtAgmatrix) {
    			var dtAg = eval('_get' + dtAgmatrix);
    			ag = 180 + dtAg;
    		}
    	}
    	// 旋转
    	$('.dotCircle').css({
            "transform": "rotate(" + (360 - ag) + "deg)",
            "transition": "2s"
        });
        $('.itemDot').css({
            "transform": "rotate(" + ag + "deg)",
            "transition": "1s"
        });
        op.rotateInterval = _timer(op);
    };
    
    // 定时准备
    _timer = function (op) {
        return setInterval(function(op) {
            op = op || _circileWebOpt;
            var dataTab = $('.itemDot.active').data("tab");
            if (dataTab > op.len || op.i > op.len) {
                dataTab = 1;
                op.i = 1;
            }
            $('.itemDot').removeClass('active');
            $('[data-tab="' + op.i + '"]').addClass('active');
            $('.CirItem').removeClass('active');
            $('.CirItem' + op.i).addClass('active');
// if (op.i > op.len && op.len === 1) {
// op.i --;
// }
            _doRotate($('.CirItem' + op.i), op.i, op.numAngle, op);
            op.i ++;
        }, 5000, op);
    };

	// 获取指定样式值
	_getStyle = function(el, styleName) {
		el = $(el);
		return el.css('-webkit-' + styleName) ||
				el.css('-moz-' + styleName) ||
				el.css('-ms-' + styleName) ||
				el.css('-o-' + styleName) ||
				el.css(styleName); 
	};
    
    _init(_circileWebOpt);
};

// 计算矩阵值
function _getmatrix(a, b, c, d, e, f) {
	var aa = Math.round(180 * Math.asin(a) / Math.PI);
	var bb = Math.round(180 * Math.acos(b) / Math.PI);
	var cc = Math.round(180 * Math.asin(c) / Math.PI);
	var dd = Math.round(180 * Math.acos(d) / Math.PI);
	var deg = 0;
	if (aa == bb || -aa == bb) {
	    deg = dd;
	} else if (-aa + bb == 180) {
	    deg = 180 + cc;
	} else if (aa + bb == 180) {
	    deg = 360 - cc || 360 - dd;
	}
	return deg >= 360 ? 0 : deg;
}