// JavaScript Document
//category.jsp页面设置菜单是否显示主题市场下面左侧菜单
//顶端菜单
// var jq = jQuery.noConflict();
$(function(){
	$(".leftNav ul li").hover(
		function(){
            $(this).find(".fj").addClass("nuw");
            $(this).find(".zj").show();
		}
		,
		function(){
            $(this).find(".fj").removeClass("nuw");
            $(this).find(".zj").hide();
		}
	)
})
