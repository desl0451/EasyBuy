<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
  var contextPath = "${ctx}";
</script>
<div id="fade1" class="black_overlay"></div>
<div id="MyDiv1" class="white_content">
    <div class="white_d">
        <div class="notice_t">
            <span class="fr" style="margin-top:10px; cursor:pointer;" onclick="CloseDiv_1('MyDiv1','fade1')"><img src="${ctx}/statics/images/close.gif" /></span>
        </div>
        <div class="notice_c">
            <table border="0" align="center" cellspacing="0" cellpadding="0">
                <tr valign="top">
                    <td width="40"><img src="${ctx}/statics/images/suc.png"></td>
                    <td>
                        <span style="color:#3e3e3e; font-size:18px; font-weight:bold;" id="showMessage">操作成功</span><br />
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<link type="text/css" rel="stylesheet" href="${ctx}/statics/css/style.css"/>
<script type="text/javascript" src="${ctx}/webapp/statics/js/common/old/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${ctx}/webapp/statics/js/common/old/jquery.bxslider.js"></script>

<script type="text/javascript" src="${ctx}/webapp/statics/js/common/old/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="${ctx}/webapp/statics/js/common/menu.js"></script>
       
<script type="text/javascript" src="${ctx}/webapp/statics/js/common/old/select.js"></script>
   
<script type="text/javascript" src="${ctx}/webapp/statics/js/common/old/lrscroll.js"></script>

<script type="text/javascript" src="${ctx}/webapp/statics/js/common/old/iban.js"></script>
<script type="text/javascript" src="${ctx}/webapp/statics/js/common/old/fban.js"></script>
<script type="text/javascript" src="${ctx}/webapp/statics/js/common/old/f_ban.js"></script>
<script type="text/javascript" src="${ctx}/webapp/statics/js/common/old/mban.js"></script>
<script type="text/javascript" src="${ctx}/webapp/statics/js/common/old/bban.js"></script>
<script type="text/javascript" src="${ctx}/webapp/statics/js/common/old/hban.js"></script>
<script type="text/javascript" src="${ctx}/webapp/statics/js/common/old/tban.js"></script>
<script type="text/javascript" src="${ctx}/webapp/statics/js/common/old/lrscroll_1.js"></script>

<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/ShopShow.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/MagicZoom.css" />
<script type="text/javascript" src="${ctx}/webapp/statics/js/common/old/MagicZoom.js"></script>
<script type="text/javascript" src="${ctx}/webapp/statics/js/common/old/num.js"></script>
<script type="text/javascript" src="${ctx}/webapp/statics/js/common/old/p_tab.js"></script>
<script type="text/javascript" src="${ctx}/webapp/statics/js/common/old/shade.js"></script>