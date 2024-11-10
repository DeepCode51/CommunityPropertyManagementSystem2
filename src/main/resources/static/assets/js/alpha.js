/*alphaAdmin.js
* ================
* @Author  XiaoQJ
* @website <http://www.idevst.com>
* @QQ:1075095689
* @Email   <idevst@163.com>
* @version 1.0.0
*/

if (typeof jQuery === "undefined") {
	throw new Error("AlphaAdmin需要引用JQuery");
}

/**
 * [Collapse 折叠] 
 * @param  {[type]} $ [description]
 * @return {[type]}   [description]
 * @Usage: $('.box').collapse(options)
 */
~function ($) {
	'use strict'
    var DataKey = "Tools.collapse"
    /**
     * [Default 默认参数]
     * @type {Object}
     */
    var Default = {
	    animationSpeed: 500,
	    collapseTrigger: '[data-toggle="collapse"]',
	    collapseIcon: 'icon-minus',
	    expandIcon: 'icon-plus',
	}
    /**
     * [Selector 元素]
     * @type {Object}
     */
	var Selector = {
    	wrapper: '.box',
    	collapsed: '.collapsed',
    	body: '.box-body',
    	tools: '.box-tools'
  	}
  	var ClassName = {
    	collapsed: 'collapsed'
  	}
  	var Event = {
    	collapsed: 'collapsed',
    	expanded: 'expanded'    
  	}

  	var Collapse = function(element, options) {
  		this.element = element
  		this.options = options
  	}
  	Collapse.prototype.toggle = function(argument){
        var parent = argument.offsetParent()
        //是否折叠
		var isOpen = $(parent).is(Selector.collapsed)
        if(!isOpen) {
            this.collapse(parent)
        }else {
            this.expand(parent)
        }
  	}
    /**
     * [expaned 打开]
     * @param  {[type]} argument [description]
     * @return {[type]}          [description]
     */
    Collapse.prototype.expand = function(argument){
        var collapseEvent = $.Event(Event.expanded)
        var collapseIcon = this.options.collapseIcon
        var expandIcon = this.options.expandIcon
        $(argument).removeClass(ClassName.collapsed)
        $(argument).find('.' + expandIcon).removeClass(expandIcon).addClass(collapseIcon)
        $(argument).find(Selector.body).slideDown(this.options.animationSpeed, function(){
            $(argument).removeClass(ClassName.collapsed)
        })
        
    };
    /**
     * [collapse 折叠]
     * @return {[type]} [description]
     */
  	Collapse.prototype.collapse = function(argument) {
  		var collapseEvent = $.Event(Event.collapsed)
  		var collapseIcon = this.options.collapseIcon
  		var expandIcon = this.options.expandIcon
        $(argument).find('.' + collapseIcon).removeClass(collapseIcon).addClass(expandIcon)
        $(argument).find(Selector.body).slideUp(this.options.animationSpeed, function(){
            $(argument).addClass(ClassName.collapsed)
        })
    }
    /**
     * [Plugin 定义插件]
     * @param {[type]} option [参数]
     */
  	function Plugin(option) {
  		return this.each(function() {
  			var that = $(this)  
            var data = $(this).data(DataKey)
            if(!data) {
                var options = $.extend({}, Default, that.data(), typeof option == 'object' && option )
                that.data(DataKey, data = new Collapse(that, options))
            }
            option == "toggle" &&  data.toggle(that)
  		})
  	}
  	$.fn.collapse = Plugin
  	$(document).on("click", Default.collapseTrigger, function(event){  
        Plugin.call($(this), "toggle")
  	})
}(jQuery)
/**
 * [PushMenu导航]
 * @param  {[type]} $ [description]
 * @return {[type]}   [description]
 */
~function ($) {
    "use strict"
    var DataKey = "Tools.pushmenu"
     /**
     * [Default 默认参数]
     * @type {Object}
     */
    var Default = {
        screenSize: 767,
        collapsed: 'collapsed',
        expanded: 'expanded',
        collapseTrigger: '[data-toggle="push-menu"]',
        min: 'sidebar-min'
    }
    var Selector = {
        body: 'body',
        collapsed: '.collapsed',
        expaned: '.expanded'    
    }
    var ClassName = {
        collapsed: 'sidebar-collapsed',
        expanded: 'sidebar-expanded',
    }
    var Event = {
        expanded: 'expaned',
        collapsed: 'collapsed'
    }

    var PushMenu = function(element, options) {
        this.element = element
        this.options = options
        this.init()
    }
    PushMenu.prototype.init = function() {
        var width = $(window).width()
        if(width <= Default.screenSize) {
            $(Selector.body).addClass(Default.min).addClass(ClassName.collapsed)
        }else {
            $(Selector.body).addClass(ClassName.expanded)
        }
    }
    PushMenu.prototype.toggle = function() {
        var isOpen = $(Selector.body).is('.' + ClassName.expanded)
        var isMin = $(Selector.body).is('.' + Default.min)
        if(isMin && !isOpen) {
            this.expand()
        }else {
            this.collapse()
        }
    }
    PushMenu.prototype.expand = function(argument){
        var start = $(Selector.body).is(Selector.expaned)
        if(start) {
            $(Selector.body).removeClass(Default.expanded)
        }else {
            $(Selector.body).addClass(Default.expanded)
        }
        
    };
    PushMenu.prototype.collapse = function(argument){
        var start = $(Selector.body).is(Selector.collapsed)
        if(start) {
            $(Selector.body).removeClass(Default.collapsed)
        }else {
            $(Selector.body).addClass(Default.collapsed)
        }
    };
    function Plugin(option) {
        var that = $(this)
        var data = that.data(DataKey)
        if(!data) {
            var options = $.extend({}, Default, that.data(), "object" == typeof option && option)
            that.data(DataKey, data = new PushMenu(that, options))
        }
        option == "toggle" && data.toggle()
    }
    $(document).on('click', Default.collapseTrigger, function(event) {
        Plugin.call($(this), "toggle")
    })
    $(window).on('load', function(){
        Plugin.call(Default.collapseTrigger)
    })
}(jQuery)
/**
 * [多级导航]
 * @param  {[type]} $ [description]
 * @return {[type]}   [description]
 */
~function($) {
    "use strict"
    var DataKey = "Tools.tree"
    var Default = {
        animationSpeed: 500,
        data: '[data-widget="tree"]',
        navigatorTrigger: '.treeview a'
    }
    var Selector = {
        treeview: '.treeview',
        subTreeMenu: '.treeview-menu',
        open: '.open, .active',
        active: '.active'
    }
    var ClassName = {
        tree: 'tree',
        active: 'active',
        open: 'open'
    }

    var TreeMenu = function(element, options) {
        this.element = element
        this.options = options
        this.init()
    }
    TreeMenu.prototype.init = function(argument){
        var self = this
        $(Selector.treeview + Selector.active, this.element).addClass(ClassName.open)
        $(this.element).on('click', this.options.navigatorTrigger, function(event) {
            self.listener($(this), event)
        }).addClass(ClassName.tree)
    };
    TreeMenu.prototype.listener = function(element, event) {
        var subMenu = element.next(Selector.subTreeMenu)
        var parent = element.parent()
        var isOpen = parent.hasClass(ClassName.open)
        var isActive = parent.hasClass(ClassName.active)
        if(element.attr('href') == '#') {
            event.preventDefault()
        }
        isOpen ? this.close(parent, subMenu) : this.open(parent, subMenu)
        //isOpen ? this.close(parent, subMenu): isActive?this.close(parent, subMenu):this.open(parent, subMenu)
    }
    TreeMenu.prototype.open = function(parent, sub){
        /**
         * [sibling 同级 兄弟元素]
         * @type {[type]}
         */
        var sibling = parent.siblings(Selector.treeview)
        var openSibling = parent.siblings(Selector.open)
        var span = parent.children('a').children('span')
        span.css({
            transition: 'transform .5s',
            transform: 'rotate(-90deg)'
        })
        var siblingChildren = sibling.children(Selector.subTreeMenu)
        var openSiblingChildren = openSibling.children(Selector.subTreeMenu)
        //this.close(sibling, siblingChildren)
        this.close(openSibling, openSiblingChildren)
        parent.addClass(ClassName.open)
        sub.slideDown(this.options.animationSpeed)
    }
    TreeMenu.prototype.close = function(parent, sub){
        var span = parent.children('a').children('span')
        span.css({
            transition: 'transform .5s',
            transform: 'rotate(0deg)'
        })
        // parent.find(Selector.open).removeClass(ClassName.open)
        parent.removeClass(ClassName.open)
        sub.slideUp(this.options.animationSpeed)
    };
    var Plugin = function(option) {
        return this.each(function() {
            var that = $(this)
            var data = that.data(DataKey)
            if(!data) {
                var options = $.extend({}, Default, that.data(), "object" == option && option)
                that.data(DataKey, new TreeMenu(that, options))
            }
        })
    }
    $.fn.tree = Plugin
    $(window).on('load', function(){
        Plugin.call($(Default.data))
    })
}(jQuery)