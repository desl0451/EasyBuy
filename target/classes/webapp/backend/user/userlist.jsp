<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta content="text/html; charset=gb2312" http-equiv="Content-Type">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="/common/backend/references.jsp" %>
    <title>淘宝网</title>
</head>

<body>
<!-- 顶部标题开始 -->
<%@include file="/common/backend/header.jsp" %>
<!-- 顶部标题结束 -->
<div class="i_bg bg_color">
    <!--Begin 用户中心 Begin -->
    <div class="m_content">
        <%@include file="/common/backend/left.jsp" %>
        <div class="m_right">
            <p></p>
            <div class="mem_tit">
                <span class="fr" style="font-size:12px; color:#55555; font-family:'宋体'; margin-top:5px;">后台管理</span>
            </div>
            <table border="0" class="ma_tab" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0">
                <tr>
                    <td>编号</td>
                    <td>登录名称</td>
                    <td>用户名</td>
                    <td>性别</td>
                    <td>身份证号</td>
                    <td>电子邮件</td>
                    <td>电话</td>
                    <td>用户类型</td>
                </tr>
                <c:forEach items="${userList}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.loginName}</td>
                        <td>${user.userName}</td>
                        <td>${user.sex}</td>
                        <td>${user.identityCode}</td>
                        <td>${user.email}</td>
                        <td>${user.mobile}</td>
                        <td>
                            <c:if test="${user.type==1}">
                                系统管理员
                            </c:if>
                            <c:if test="${user.type==0}">
                                普通会员
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <%@include file="/common/backend/pagerBar.jsp" %>
        </div>
    </div>
</div>

<%@ include file="/common/backend/footer.jsp"%>
</body>
</html>
