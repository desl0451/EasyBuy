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
            <div class="m_right" id="content">
                <div class="mem_tit">
                    添加商品
                </div>

                <br>
                <form action="${ctx}/admin/product?action=addProduct" method="post" enctype="multipart/form-data" id="productAdd" onsubmit="return checkProduct();">
                    <table border="0" class="add_tab" style="width:930px;" cellspacing="0" cellpadding="0">
                        <tr>
                            <td width="135" align="right">一级分类</td>
                            <td colspan="3" style="font-family:'宋体';">
                                <select name="categoryLevel1Id" style="background-color:#f6f6f6;" id="productCategoryLevel1">
                                    <option value="" selected="selected">请选择...</option>
                                    <c:forEach var="first" items="${productCategoryList1}">
                                        <option value="${first.id}" >${first.name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td width="135" align="right">二级分类</td>
                            <td>
                                <select name="categoryLevel2Id" style="background-color:#f6f6f6;"
                                        id="productCategoryLevel2"
                                       >
                                    <option value="0" selected="selected">请选择...</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td width="135" align="right">三级分类</td>
                            <td>
                                <select name="categoryLevel3Id" style="background-color:#f6f6f6;"
                                        id="productCategoryLevel3">
                                    <option value="0" selected="selected">请选择...</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td width="135" align="right">商品名称</td>
                            <td>
                                <input type="text" value="${product.name}" class="add_ipt" name="name" id="name"/>（必填）
                                <input type="hidden" name="id" value="${product.id}" id="id">
                            </td>
                        </tr>
                        <tr>
                            <td width="135" align="right">商品图片</td>
                            <td>

                                <input type="file" class="text" name="photo" /><span></span>
                            </td>
                        </tr>
                        <tr>
                            <td width="135" align="right">单价</td>
                            <td>
                                <input type="text" value="${product.price}" class="add_ipt" name="price" id="price"/>
                            </td>
                        </tr>
                        <tr>
                            <td width="135" align="right">库存</td>
                            <td>
                                <input type="text" value="${product.stock}" class="add_ipt" name="stock" id="stock"/>
                            </td>
                        </tr>
                        <tr>
                            <td width="135" align="right">描述</td>
                            <td>
                                <textarea name="description">${product.description}</textarea>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty product.id}">
                                        <input type="submit" value="商品上架" class="s_btn">
                                    </c:when>
                                    <c:otherwise>
                                        <input type="submit" value="确定修改" class="s_btn">
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
            <%@include file="/common/backend/pagerBar.jsp" %>
        </div>
    </div>
</div>

<%@ include file="/common/backend/footer.jsp"%>
</body>
</html>
