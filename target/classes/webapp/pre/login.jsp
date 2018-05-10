<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta content="text/html; charset=gb2312" http-equiv="Content-Type">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@include file="/common/pre/references.jsp" %>
<script type="text/javascript" src="${ctx}/statics/js/login/login.js"></script>
<title>淘宝网</title>
</head>
<body>  
<!--Begin Header Begin-->
<div class="soubg">
	<div class="sou">
        <span class="fr">
        	<span class="zuo">
             <c:if test="${loginUser!=null}">
                 <a href="">${loginUser.userName}</a>
                 <a href="${ctx}/Login?action=logout">注销</a>

             </c:if>
                <c:if test="${loginUser!=null && loginUser.type==1}">
                    | <a href="${ctx}/BackendHome?action=login">后台管理</a>
                </c:if>

                <c:if test="${loginUser==null}">
                    <a href="${ctx}/Login?action=toLogin" style="color:#ff4e00;">亲，请登录</a>&nbsp;
                    <a href="${ctx}/Register?action=toRegister">免费注册</a>&nbsp;|&nbsp;
                </c:if>
                <a href="#">手机逛淘宝</a>&nbsp;|
            </span>
        </span>
    </div>
</div>
<!--End Header End--> 
<!--Begin Login Begin-->
<div class="log_bg">	
    <div class="top">
        <div class="logo"><a href="${ctx}/Home?action=index"><img src="${ctx}/statics/images/logo.png" /></a></div>
    </div>
	<div class="login">
    	<div class="log_img"><img src="${ctx}/statics/images/l_img.png" width="500" height="425" /></div>
		<div class="log_c">
        	<form>
            <table border="0" style="width:370px; font-size:14px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr height="50" valign="top">
              	<td width="55">&nbsp;</td>
                <td>
                	<span class="fl" style="font-size:24px;">登录</span>
                    <span class="fr">还没有商城账号，<a href="${ctx}/Register?action=toRegister" style="color:#ff4e00;">立即注册</a></span>
                </td>
              </tr>
              <tr height="70">
                <td>用户名</td>
                <td><input type="text" value="" class="l_user" name="username" id="username"/></td>
              </tr>
              <tr height="70">
                <td>密&nbsp; &nbsp; 码</td>
                <td><input type="password" value="" class="l_pwd" name="password" id="password"/></td>
              </tr>
              <tr>
              	<td>&nbsp;</td>
                <td style="font-size:12px; padding-top:20px;">
                	<span style="font-family:'宋体';" class="fl">
                    	<label class="r_rad"><input type="checkbox" name="ck" id="ck"/></label><label class="r_txt">请保存我这次的登录信息</label>
                    </span>
                    <span class="fr"><a href="${ctx}/Register?action=toRegister" style="color:#ff4e00;">忘记密码</a></span>
                </td>
              </tr>
              <tr height="60">
              	<td>&nbsp;</td>
                <td><input type="button" value="登录" class="log_btn" onclick="login()"/></td>
              </tr>
            </table>
            </form>
        </div>
    </div>
</div>
<!--End Login End--> 
<!--Begin Footer Begin-->
<%@include file="/common/pre/footer.jsp" %>
<!--End Footer End -->    

</body>
</html>
