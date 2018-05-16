<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta content="text/html; charset=gb2312" http-equiv="Content-Type">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@include file="/common/pre/references.jsp" %>
<title>淘宝网</title>
</head>

<body>
	<!-- 顶部标题开始 -->
	<%@include file="/common/pre/header.jsp" %>
	<!-- 顶部标题结束 -->


	<!--End Header End-->
	<!--Begin Menu Begin-->
	<div class="menu_bg">
		<%--<!-- 全部商品分类开始 -->--%>
		<%@include file="/common/pre/category.jsp" %>
		<%--<!-- 全部商品分类结束 -->--%>
		<%--<!--限时特卖开始-->--%>
		<%--<%@include file="/common/pre/sale.jsp" %>--%>
		<%--<!--限时特卖结束-->--%>
		</div>
	</div>
	<%@ include file="/common/pre/footer.jsp"%>
</body>
</html>
