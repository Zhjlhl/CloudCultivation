<%--
  Created by IntelliJ IDEA.
  User: Jiejie
  Date: 2023/12/17
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>云养殖系统</title>
    <style>
        .navbar {
            background-color: #4267b2;
            color: #fff;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px;
        }
        .navbar-left {
            display: flex;
            align-items: center;
        }
        .navbar-brand{
            width: 100px;
        }
        .navbar-right {
            display: flex;
            align-items: center;
        }
        .navbar ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            position: relative;
        }

        .navbar ul li {
            display: inline-block;
        }

        .navbar ul li a {
            display: block;
            color: white;
            text-decoration: none;
            padding: 10px;
        }

        .navbar ul li:hover {
            background-color: #4267b2;
        }

        .navbar ul ul {
            display: none;
            position: absolute;
            top: 100%;
            left: 0;
            background-color:  #4267b2;
            padding: 0;
            z-index: 9999;
        }

        .navbar ul li:hover > ul {
            display: inherit;
        }

        .navbar ul ul li {
            width: 200px;
            float: none;
            display: list-item;
            position: relative;
        }

        .navbar ul ul li a {
            padding: 10px 15px;
            color: #333;
        }

        .navbar ul ul li a:hover {
            background-color: #4267b2;
        }
        .navbar-link {
            color: #4267b2;
            text-decoration: none;
            margin: 0 15px;
            padding: 10px;
            border-bottom: 2px solid transparent;
            transition: border-bottom-color 0.3s;
        }
        .navbar-link:hover {
            border-bottom-color: #4267b2;
        }
        .search{
            margin-right: 100px;
        }

        .username {
            margin-right: 10px;
        }
        .login-btn {
            background-color: #fff;
            color: #333;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
        }
        .login-btn:hover {
            background-color: #ccc;
        }

        .content {
            margin-top:10px;
            display: flex;
            padding: 0;
            height: 50vh;
        }
        .center-content {
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .picture {
            max-width: 100%;
            position: relative;
        }
        .slide {
            display: none;
            text-align: center;
        }
        .slide img {
            max-width: 100%;
            display: inline-block;
            vertical-align: middle;
            height:50vh;
        }

        #adv-content {
            width: 100%;
            height:120px;
            background-color: #F5F5F5;
        }
        #adv {
            padding-top: 24px;
            padding-bottom: 24px;
            width: 100%;
            margin: 0 auto;
            display: flex;
        }
        #adv div {
            width: 25%;
            text-align: center;
        }
        #adv div p {
            font-size: 18px;
        }
        #adv div span {
            text-shadow: #d5ecf4 3px 4px 1px;
            font-size: 36px;
            font-weight: bold;
            color: #05a7ff;
        }
        .footer{
            /*margin-top: 100px;*/
            background-color: #eaeaea;
        }
        .top_footer{
            height: 100px;
            border-bottom: 1px solid #ccc;
        }
        .top_footer ul{
            display: flex;
        }
        .top_footer li{
            flex: 1;
            height: 100px;
            line-height: 100px;
            text-align: center;
            font-size: 18px;
            font-weight: 700;
            position: relative;
        }
        .top_footer b{
            width: 36px;
            height: 42px;
            line-height: 42px;
            display: block;
            position: absolute;
            top: 30px;
            left: 25px;
            text-indent: -2000em;
        }
        .top_footer .fast {
            background-position: 0px -42px;
        }
        .top_footer .good {
            background-position: 0px -85px;
        }
        .top_footer .save {
            background-position: 0px bottom;
        }
        .middle_footer {
            height: 220px;
            border-bottom: 1px solid #ccc;
            display: flex;
            justify-content: space-between;
        }

        .middle_footer dl {
            float: left;
            width: 198px;
            margin-top: 28px;
            flex: 1;
            margin-right: 20px; /* 在 dl 元素之间添加间距 */
            margin-left: 5px;
        }
        .middle_footer dt {
            height: 30px;
            font-size: 16px;
            font-weight: 700;
            color: #4267b2;
        }
        .middle_footer dd {
            height: 25px;
            font-size: 13px;
            margin-left: auto;
        }

        .middle_footer .last-dl {
            height: 147px;
        }

        .middle_footer .last-dl dt {
            text-align: center;
        }

        .middle_footer .last-dl p {
            padding: 0 5px;
            line-height: 20px;
        }

        .middle_footer .last-dl a {
            float: right;
            margin-right: 10px;
            margin-top: 5px;
        }
        .bottom_footer {
            height: 150px;
            padding-top: 10px;
            text-align: center;
        }
        .bottom_footer p{
            font-size: 13px;
            text-align: center;
        }
        .bottom_footer p a{
            text-decoration: none;
            color:#4267b2;
        }
        .bottom_footer span {
            margin: 0 10px;
        }
        .bottom_footer .public {
            margin-top: 10px;
        }
        .bottom_footer .public a{
            text-decoration: none;
            color: black;
        }
        .bottom_footer .public span{
            margin: 0 8px;
        }

    </style>
    <script>
        var slides = document.getElementsByClassName("slide");
        var currentSlide = 0;
        var slideInterval = setInterval(nextSlide, 2000);
        function nextSlide() {
            slides[currentSlide].style.display = "none";
            currentSlide = (currentSlide + 1) % slides.length;
            slides[currentSlide].style.display = "block";
        }
    </script>
</head>
<body>

<div class="navbar">
    <div class="navbar-left">
        <span class="navbar-brand">云养殖系统</span>
        <ul>
            <li>
                <a class="navbar-link" href="${pageContext.request.contextPath}/toBuy?userId=${user.id}">购买</a>
            </li>
        </ul>
        <ul>
            <li>
                <a class="navbar-link" href="${pageContext.request.contextPath}/toUserFeedOngoing?userId=${user.id}">饲养</a>
            </li>
        </ul>
        <ul>
            <li>
                <a class="navbar-link" href="#">收获</a>
                <ul>
                    <a class="navbar-link" href="${pageContext.request.contextPath}/toWaitingPaid?userId=${user.id}">支付</a>
                    <a class="navbar-link" href="${pageContext.request.contextPath}/toUserHarvestInformation?userId=${user.id}">收获</a>
                </ul>
            </li>
        </ul>
        <ul>
            <li>
                <a class="navbar-link" href="#">售后</a>
                <ul>
                    <a class="navbar-link" href="${pageContext.request.contextPath}/toUserFinished?userId=${user.id}">完成</a>
                    <a class="navbar-link" href="${pageContext.request.contextPath}/toDisputeOngoing?userId=${user.id}">售后</a>
                    <a class="navbar-link" href="${pageContext.request.contextPath}/toWaitingEvaluate">评价</a>
                </ul>
            </li>
        </ul>
        <ul>
            <li>
                <a class="navbar-link" href="#">客服</a>
            </li>
        </ul>
    </div>

    <div class="navbar-right">
        <div class="search">
            <form action="/search" method="get">
                <input type="text" name="query" placeholder="搜索" style="height: 30px;width: 200px;margin-top:10px">
                <input type="submit" class="button" value="搜索" style="height: 30px;width:50px;margin-top:10px">
            </form>
        </div>
        <span class="username" >未登录</span>
        <a href="${pageContext.request.contextPath}/toLogin" class="login-btn"style="text-decoration: none">去登录</a>
    </div>
</div>
<div>
    <div class="content">
        <div class="center-content">
            <div class="picture">
                <div class="slide">
                    <img src="img/product1.jpg" alt="图片1">
                </div>
                <div class="slide">
                    <img src="img/product2.jpg" alt="图片2">
                </div>
                <div class="slide">
                    <img src="img/product3.jpg" alt="图片3">
                </div>
            </div>
        </div>
    </div>
</div>
<div id="adv-content">
    <div id="adv">
        <div>
            <span> 1,000+</span>家
            <br> 服务客户
        </div>
        <div>
            <span>500+</span>个
            <br> 交付项目
        </div>
        <div>
            <span> 10,000+</span>个
            <br> 管理数字孪生体
        </div>
        <div>
            <span>6,000+</span>个
            <br> 从事数字孪生行业
        </div>
    </div>
</div>
<div class="footer ">
    <div class="top_footer">
        <div class="w">
            <ul>
                <li>
                    <b>多</b>
                    <span>品类齐全，轻松养殖</span>
                </li>
                <li>
                    <b class="fast">快</b>
                    <span>多仓可选，极速下单</span>
                </li>
                <li>
                    <b class="good">好</b>
                    <span>高端饲料，精致服务</span>
                </li>
                <li>
                    <b class="save">省</b>
                    <span>天天供货，畅选无忧</span>
                </li>
            </ul>
        </div>
    </div>
    <div class="middle_footer  w">
        <dl>
            <dt>养殖指南</dt>
            <dd>养殖流程</dd>
            <dd>养殖介绍</dd>
            <dd>养殖攻略</dd>
            <dd>常见问题</dd>
            <dd>养殖售后</dd>
            <dd>联系客服</dd>
        </dl>
        <dl>
            <dt>配送方式</dt>
            <dd>上门自提</dd>
            <dd>211限时达</dd>
            <dd>商品抵价</dd>
            <dd>配送服务查询</dd>
            <dd>配送费收取标准</dd>
            <dd>海外配送</dd>
        </dl>
        <dl>
            <dt>支付方式</dt>
            <dd>货到付款</dd>
            <dd>在线支付</dd>
            <dd>分期付款</dd>
            <dd>公司转账</dd>
        </dl>
        <dl>
            <dt>售后服务</dt>
            <dd>售后政策</dd>
            <dd>价格保护</dd>
            <dd>退款说明</dd>
            <dd>退换货</dd>
            <dd>取消订单</dd>
        </dl>
        <dl>
            <dt>特色服务</dt>
            <dd>养殖农场</dd>
            <dd>合作养殖</dd>
            <dd>共享养殖</dd>
            <dd>智能养殖</dd>
        </dl>
        <dl class="last-dl">
            <dt>云养殖网站介绍</dt>
            <dd>
                本网站是一个新型智能的云养殖网站，各位网民可以在网站中挑选心仪的养殖对象进行购买，我们将提供场地和饲料保障养殖对象的健康生长。本网站
                提供的服务包括但不限于养殖信息查询、社交互动、在线购买等，期待各位网民的选购。
            </dd>
        </dl>
    </div>
    <div class="bottom_footer">
        <p>
            <a>关于我们</a><span>|</span>
            <a>联系我们</a><span>|</span>
            <a>联系客服</a><span>|</span>
            <a>合作招商</a><span>|</span>
            <a>商家帮助</a><span>|</span>
            <a>营销中心</a><span>|</span>
            <a>友情链接</a><span>|</span>
            <a>销售联盟</a><span>|</span>
            <a>养殖社区</a><span>|</span>
            <a>风险监测</a><span>|</span>
            <a>隐私政策</a><span>|</span>
            <a>养殖公益</a><span>|</span>
        </p>
        <p class="public">
            <a>京公网安备 10000000000001号</a><span>|</span>
            <a>京ICP证000001号</a><span>|</span>
            <a>互联网药品信息服务资格证编号(京)-经营性-2023-0001</a><span>|</span>
            <a>新出发京零 字第大000001号</a>
        </p>
        <p class="public">
            <a>互联网出版许可证编号新出网证(京)字001号</a><span>|</span>
            <a>出版物经营许可证</a><span>|</span>
            <a>网络文化经营许可证京网文[2023]2023-111号</a><span>|</span>
            <a>违法和不良信息举报电话：4006561155</a>
        </p>
        <p class="public">
            <a>Copyright © 2022 - 2024  云养殖公司 版权所有</a><span>|</span>
            <a>消费者维权热线：4000000001</a><span>|</span>
            <a>(京)网械平台备字(2023)第00001号</a><span>|</span>
            <a>营业执照</a>
        </p>
    </div>
</div>
</body>
</html>

