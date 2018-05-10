<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
    var contextPath = "${ctx}";
</script>
<div class="menu">
    <!--Begin 商品分类详情 Begin-->
    <div class="nav">
        <div class="nav_t">主题市场</div>
        <div class="leftNav">
            <div class="div1"></div>
            <ul>
                <c:forEach items="${productCategory}" var="first">
                    <li>
                        <div class="fj">
                            <span class="fl">${first.productCategory.name}</span>
                        </div>
                        <div class="zj">
                            <div class="zj_l">
                                <div class="zj_l_c">
                                    <c:forEach var="second" items="${first.productCategorySecondList}">
                                        <h2>${second.productCategory.name}</h2>
                                        <c:forEach var="three" items="${second.productCategoryList}" varStatus="i">
                                            <a href="#">${three.name}</a>
                                            <c:if test="${(i.index+1)%8==0}">
                                                <br/>
                                            </c:if>
                                        </c:forEach>
                                    </c:forEach>
                                </div>

                                <%/**广告*/%>
                                <div class="zj_r">
                                    <a href="#"><img src="${ctx}/statics/images/n_img1.jpg" width="236"
                                                     height="200"/></a>
                                    <a href="#"><img src="${ctx}/statics/images/n_img2.jpg" width="236"
                                                     height="200"/></a>
                                </div>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <!--End 商品分类详情 End-->
    <ul class="menu_r">
        <li><a href="Home?action=index">天猫</a></li>
        <li><a href="Food.html">聚划算</a></li>
        <li><a href="Fresh.html">天猫超市</a></li>
        <li class="shu">|</li>
        <li><a href="HomeDecoration.html">淘抢购</a></li>
        <li><a href="SuitDress.html">电器城</a></li>
        <li><a href="MakeUp.html">司法拍卖</a></li>
        <li><a href="Digital.html">中国质造</a></li>
        <li><a href="GroupBuying.html">兴农扶贫</a></li>
    </ul>
</div>
</div>
<div class="i_bg bg_color">
    <div class="i_ban_bg">
        <!--Begin Banner Begin-->
        <div class="banner">
            <div class="top_slide_wrap">
                <ul class="slide_box bxslider">
                    <li><img src="${ctx}/statics/images/index/banner/1.jpg" width="520" height="230"/></li>
                    <li><img src="${ctx}/statics/images/index/banner/2.jpg" width="520" height="230"/></li>
                    <li><img src="${ctx}/statics/images/index/banner/3.jpg" width="520" height="230"/></li>
                    <li><img src="${ctx}/statics/images/index/banner/4.jpg" width="520" height="230"/></li>
                    <li><img src="${ctx}/statics/images/index/banner/5.jpg" width="520" height="230"/></li>
                </ul>
            </div>
            <div class="tmall">
                <div class="tmall-hd">
                    <div class="inner">
                        <span class="hd-bg" style="background-image: url(${ctx}/statics/images/index/banner/tianmao.png);"></span>
                        <em>理想生活上天猫</em>
                    </div>
                </div>
                <div class="tmall-bd" style="width: 520px; overflow: hidden; height: 300px;">
                    <div class="changeBox_a1" id="change_1">
                        <a href="#1" class="a_bigImg"><img src="${ctx}/statics/images/index/banner/1.jpg" width="520" height="300" alt="" /></a>
                        <a href="#2" class="a_bigImg"><img src="${ctx}/statics/images/index/banner/2.jpg" width="520" height="300" alt="" /></a>
                        <a href="#3" class="a_bigImg"><img src="${ctx}/statics/images/index/banner/3.jpg" width="520" height="300" alt="" /></a>
                        <a href="#4" class="a_bigImg"><img src="${ctx}/statics/images/index/banner/4.jpg" width="520" height="300" alt="" /></a>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            //var jq = jQuery.noConflict();
            $(function () {
                $(".bxslider").bxSlider({
                    auto: true
                });
                $('#change_1 .a_bigImg').soChange();
            });
        </script>

        <!--End Banner End-->
        <div class="inews">
            <div class="tbh-member J_Module" data-name="member" style="background-image: url(${ctx}/statics/images/index/register/registerbg.png);">
                <div class="member">
                <div class="member-bd" data-spm-ab="1">
                    <div class="avatar-wrapper">
                        <a class="J_MemberHome member-home" href="javascript:;" target="_self">
                            <img class="J_MemberAvatar member-avatar" src="//wwc.alicdn.com/avatar/getAvatar.do?userNick=&amp;width=50&amp;height=50&amp;type=sns&amp;_input_charset=UTF-8" ks_mark="y">
                        </a>
                    </div>
                    <span class="member-nick-info" data-spm-anchor-id="a21bo.2017.201864.i0.5af911d9LXjiFc">
Hi! <strong class="J_MemberNick member-nick">你好</strong>
</span>
                    <p class="member-tjb">
                        <a data-spm="d3" href="//taojinbi.taobao.com/index.htm?auto_take=true" class="J_MemberPunch h">
                            <span class="tbh-icon"></span>领淘金币抵钱
                        </a>
                        <a class="J_MemberClub h club" href="//vip.taobao.com"><span class="tbh-icon"></span>会员俱乐部</a>
                    </p>
                </div>
                <div class="member-ft">
                    <div class="member-logout J_MemberLogout" data-spm-ab="2" data-spm-anchor-id="a21bo.2017.201864.i1.5af911d9LXjiFc">
                        <a href="//login.taobao.com/member/login.jhtml?f=top&amp;redirectURL=http%3A%2F%2Fwww.taobao.com%2F" class="btn-login ml1 tb-bg weight" data-spm-click="gostr=/tbindex;locaid=d1;name=登录">登录</a>
                        <a href="//reg.taobao.com/member/new_register.jhtml?from=index&amp;ex_info=&amp;ex_sign=" class="ml2 tb-bg weight" data-spm-click="gostr=/tbindex;locaid=d2;name=注册">注册</a>
                        <a href="//openshop.taobao.com/openshop/welcome.htm" class="ml3 tb-bg weight">开店</a>
                    </div>
                    <div class="member-login J_MemberLogin" data-spm-ab="3"></div>
                </div>
            </div>

            </div>




            <div class="news_t">
                <span class="fr"><a href="#">更多 ></a></span>新闻资讯
            </div>
            <ul>
                <c:forEach var="news" items="${news}">
                    <li><span>[ 公告 ]</span><a href="#">${news.title}</a></li>
                </c:forEach>
            </ul>
            <div class="charge_t">
                话费充值
                <div class="ch_t_icon"></div>
            </div>
            <form>
                <table border="0" style="width:205px; margin-top:10px;" cellspacing="0" cellpadding="0">
                    <tr height="35">
                        <td width="33">号码</td>
                        <td><input type="text" value="" class="c_ipt"/></td>
                    </tr>
                    <tr height="35">
                        <td>面值</td>
                        <td>
                            <select class="jj" name="city">
                                <option value="0" selected="selected">100元</option>
                                <option value="1">50元</option>
                                <option value="2">30元</option>
                                <option value="3">20元</option>
                                <option value="4">10元</option>
                            </select>
                            <span style="color:#ff4e00; font-size:14px;">￥99.5</span>
                        </td>
                    </tr>
                    <tr height="35">
                        <td colspan="2"><input type="submit" value="立即充值" class="c_btn"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
