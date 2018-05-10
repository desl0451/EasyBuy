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
<!--引入jQuery-->
<script src="${ctx}/statics/js/common/jquery-1.11.1.min.js"></script>
<!--引入整个网页样式-->
<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/style.css">
<!--引入bxslider插件-->
<script type="text/javascript" src="${ctx}/statics/js/common/soChange/jquery.soChange-min.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/bxslider/jquery.bxslider.css"/>
<script src="${ctx}/statics/js/common/bxslider/jquery.bxslider.js"></script>
<!--左侧菜单样式-->
<script type="text/javascript" src="${ctx}/statics/js/common/menu.js"></script>

<!---->
<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/soChange/soChange.css"/>
<!---->


<%--<script type="text/javascript" src="${ctx}/statics/js/common/select.js"></script>--%>

<%--<script type="text/javascript" src="${ctx}/statics/js/common/lrscroll.js"></script>--%>

<%--<script type="text/javascript" src="${ctx}/statics/js/common/iban.js"></script>--%>
<%--<script type="text/javascript" src="${ctx}/statics/js/common/fban.js"></script>--%>
<%--<script type="text/javascript" src="${ctx}/statics/js/common/f_ban.js"></script>--%>
<%--<script type="text/javascript" src="${ctx}/statics/js/common/mban.js"></script>--%>
<%--<script type="text/javascript" src="${ctx}/statics/js/common/bban.js"></script>--%>
<%--<script type="text/javascript" src="${ctx}/statics/js/common/hban.js"></script>--%>
<%--<script type="text/javascript" src="${ctx}/statics/js/common/tban.js"></script>--%>
<%--<script type="text/javascript" src="${ctx}/statics/js/common/lrscroll_1.js"></script>--%>
<%--<!--banner广告样式-->--%>
<%--<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/ShopShow.css" />--%>
<%--<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/MagicZoom.css" />--%>
<%--<script type="text/javascript" src="${ctx}/statics/js/common/MagicZoom.js"></script>--%>
<%--<script type="text/javascript" src="${ctx}/statics/js/common/num.js"></script>--%>
<%--<script type="text/javascript" src="${ctx}/statics/js/common/p_tab.js"></script>--%>
<%--<script type="text/javascript" src="${ctx}/statics/js/common/shade.js"></script>--%>