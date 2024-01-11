<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客服主页</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--这里引入的是矢量图标签库-->
    <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Montserrat:400,600,700|Trade+Winds&display=swap');
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            list-style: none;
            text-decoration: none;
            /* 引入字体 */
            font-family: 'Montserrat';
        }
        body{
            background: #e7f1ff;
            font-size: 14px;
            /* 字间距 */
            letter-spacing: 1px;
        }

        .wrapper{
            /* 弹性布局 */
            display: flex;
            width: 100%;
        }

        .sidebar{
            /* 相对定位 */
            position: relative;
        }

        .sidebar .bg_shadow{
            width: 100%;
            height: 100%;
            /* 定位 */
            position: fixed;
            top: 0;
            left: 0;
            background: #000;
            z-index: 998;
            opacity: 0;
            visibility: hidden;
            transition: all 0.3s ease;
        }

        .sidebar_inner{
            width: 250px;
            position: fixed;
            top: 0;
            left: 0;
            /* 百分之百的窗口高度 */
            height: 100vh;
            background: #5558c9;
            z-index: 999;
            transition: all 0.3s ease;
        }

        .main_container{
            margin-left: 250px;
            width: calc(100% - 250px);
            transition: all 0.3s ease;
        }

        .sidebar_inner .profile_info{
            padding: 20px;
            text-align: center;
        }

        .sidebar_inner .profile_info .profile_img{
            width: 100px;
            margin: 0 auto 5px;
        }

        .sidebar_inner .profile_info .profile_img img{
            width: 100%;
            border-radius: 50%;
            display: block;
        }

        .sidebar_inner .profile_info .profile_data .name{
            font-size: 18px;
            color: #fff;
            margin-bottom: 5px;
            font-family: 'Trade Winds';
        }

        .sidebar_inner .profile_info .profile_data span{
            color: #C4dCff;
        }
        /* 侧边导航栏开始 */

        .sidebar_inner .siderbar_menu{
            height: 490px;
            overflow: auto;
        }

        .sidebar_inner .siderbar_menu> li > a{
            padding: 12px 20px;
            display: flex;
            align-items: center;
            /* 相对定位 */
            position: relative;
            margin-bottom: 1px;
            color: #C4dCff;
        }

        .sidebar_inner .siderbar_menu> li > a .icon{
            font-size: 25px;
            margin-right: 15px;
        }
        .sidebar_inner .siderbar_menu> li.active > a,
        .sidebar_inner .siderbar_menu> li > a:hover{
            background: #5558c9;
        }


        .sidebar_inner .siderbar_menu> li > a .arrow{
            position: absolute;
            top: 20px;
            right: 20px;
            transition: all 0.3s ease;
        }


        .sidebar .logout_btn a{
            position: absolute;
            bottom: 20px;
            left: 20px;
            width: 210px;
            border: 1px solid #fff;
            color: #fff;
            border-radius: 3px;
            font-weight: 600;
            padding: 10px;
            text-align: center;
            transition: all 0.3s ease;
        }

        .sidebar .logout_btn a:hover{
            background: #fff;
            color: #3d3d79;
        }

        .sidebar_inner .close{
            position: absolute;
            top: 5px;
            right: 15px;
            font-size: 25px;
            color: #fff;
            /* 鼠标放上变小手 */
            cursor: pointer;
            display: none;
        }

        .sidebar_inner .close:hover,
        .navbar .hamburger:hover{
            opacity: 0.7;
        }
        .navbar{
            background: #fff;
            height: 50px;
            width: 100%;
            box-shadow:  0 3px 5px rgba(0, 0, 0, 0.125);
            display: flex;
            align-items: center;
            padding: 0 20px;
        }

        .navbar .hamburger{
            font-size: 25px;
            cursor: pointer;
            margin-right: 20px;
            color: #5558c9;
            display: none;
        }

        .navbar .logo a{
            font-family: 'Trade Winds';
            color: #5558c9;
            font-size: 20px;
        }
        .content{
            padding: 20px;
            display: flex;
            flex-wrap: wrap;
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
        }
        .middle_footer dl {
            float: left;
            text-align: center;
            width: 20%;
            margin-top: 28px;
        }
        .middle_footer dt {
            height: 30px;
            text-align: center;
            font-size: 16px;
            font-weight: 700;
            color: #4267b2;
        }
        .middle_footer dd {
            height: 25px;
            text-align: center;
            font-size: 13px;
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

        .accordion{
            background: #6f6fc7;
            padding-left: 50px;
            height: 0px;
            transition: all 0.3s ease;
            overflow: hidden;
        }
        .accordion li a{
            display: block;
            color: #c4dcff;
            padding: 12px 0;
            padding-left: 10px;
        }
        .accordion li:last-child a{
            border-bottom: 0px;
        }
        .siderbar_menu::-webkit-scrollbar {
            width: 0 !important
        }
        .accordion{
            overflow-y:auto;
        }
        ul::-webkit-scrollbar{
            width: 0 !important
        }
        .accordion li a:hover,
        .accordion li a.active{
            color: #fff;
        }
        .siderbar_menu > li.active .accordion{
            height: 90px;
        }

        .siderbar_menu > li.active .arrow{
            transform: rotate(180deg);
            transition: all 0.3s ease;
        }

        @media (max-width:1024px){
            .sidebar_inner{
                left: -115%;
                transition: all 0.5s ease;
            }
            .main_container{
                width: 100%;
                margin-left: 0;
            }
            .sidebar_inner .close,
            .navbar .hamburger{
                display: block;
            }
            .content .item{
                width: 47%;
            }
            .wrapper.active .sidebar_inner{
                left: 0;
                transition: all 0.5s ease;
            }
            .wrapper.active .sidebar .bg_shadow{
                visibility: visible;
                opacity: 0.7;
            }
        }

        @media (max-width:528px) {
            .content .item{
                width: 100%;
            }
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
    <script>
        $(document).ready(function(){
            $(".siderbar_menu li").click(function(){
                $(".siderbar_menu li").removeClass("active");
                $(this).addClass("active");
            })
            $(".accordion li a").click(function(){
                $(".accordion li a").removeClass("active");
                $(this).addClass("active");
            })
            $(".hamburger").click(function(){
                $(".wrapper").addClass("active");
            })
            $(".bg_shadow,.close").click(function(){
                $(".wrapper").removeClass("active");
            })
        })
    </script>
</head>
<body>

<div class="wrapper">
    <div class="sidebar">
        <div class="bg_shadow"></div>
        <div class="sidebar_inner">
            <div class="close">
                <i class="fas fa-times"></i>
            </div>
            <div class="profile_info">
                <div class="profile_img">
                    <img src="images/logo_logo.png" alt="">
                </div>
                <div class="profile_data">
                    <p class="name">${service.nickname}</p>
                    <span>
                            欢迎您！
                    </span>
                </div>
            </div>
            <ul class="siderbar_menu">
                <li class="active">
                    <a href="${pageContext.request.contextPath}/toServiceHome">
                        <div class="icon">
                            <i class="fas fa-home"></i>
                        </div>
                        <div class="active" >主页</div>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/toServiceDisputeOngoing?serviceId=${service.id}">
                        <div class="icon">
                            <i class="fa fa-gavel"></i>
                        </div>
                        <div class="title">纠纷</div>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <div class="icon">
                            <i class="fa fa-check"></i>
                        </div>
                        <div class="title">审核</div>
                        <div class="arrow">
                            <i class="fas fa-chevron-down"></i>
                        </div>
                    </a>
                    <ul class="accordion">
                        <li><a href="${pageContext.request.contextPath}/toCheckGoods?serviceId=${service.id}">商品</a></li>
                        <li><a href="${pageContext.request.contextPath}/toCheckFeed?serviceId=${service.id}">饲料</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <div class="icon">
                            <i class="fa fa-comment"></i>
                        </div>
                        <div class="title">客服</div>
                    </a>
                </li>
            </ul>
            <div class="logout_btn">
                <a href="${pageContext.request.contextPath}/toLogin" class="logout-btn"style="text-decoration: none">退出登录</a>
            </div>
        </div>
    </div>
    <div class="main_container">
        <div class="navbar">
            <div class="hamburger">
                <i class="fas fa-bars"></i>
            </div>
            <div class="logo">
                <a href="#">云养殖网站</a>
            </div>
        </div>
<div class="content">
    <div class="center-content">
        <div class="picture">
            <div class="slide">
                <img src="${pageContext.request.contextPath}/service/img/product1.jpg" alt="图片1">
            </div>
            <div class="slide">
                <img src="${pageContext.request.contextPath}/service/img/product2.jpg" alt="图片2">
            </div>
            <div class="slide">
                <img src="${pageContext.request.contextPath}/service/img/product3.jpg" alt="图片3">
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
            <a>养殖公益</a>
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
    </div>
</div>
</body>
</html>
