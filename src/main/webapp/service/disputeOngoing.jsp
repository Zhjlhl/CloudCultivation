<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>纠纷中订单</title>
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
        .content{
            font-family: Arial, sans-serif;
            display:flex;
            justify-content: center;
            align-items:center;
            height:80vh;
        }
        .center-content{
            text-align:center;
        }
        .scrollable-table {
            display: flex;
            flex-direction: column;
            overflow-y: auto; /* Enable vertical scrolling for the entire table */
        }

        .scrollable-table table {
            width: 100%;
            border-collapse: collapse;
            table-layout: fixed; /* Fix the table layout */
        }

        .scrollable-table th,
        .scrollable-table td {
            border: 1px solid #fff;
            text-align: left;
            padding: 8px;
            white-space: nowrap; /* Prevent text wrapping */
            overflow: hidden;
            text-overflow: ellipsis; /* Show ellipsis for overflowed text */
        }

        .scrollable-column {
            width: 15%; /* Set the width for the specific column */
            white-space: normal; /* Allow text wrapping for the specific column */
        }

        .scrollable-column-content {
            max-height:  120px; /* Maximum height for the specific column content */
            overflow-y: auto; /* Enable vertical scrolling for the specific column content */
        }

        .scrollable-table th.scrollable-column,
        .scrollable-table td.scrollable-column {
            white-space: nowrap; /* Prevent text wrapping for the header */
        }

        .scrollable-table th.scrollable-column .scrollable-column-content,
        .scrollable-table td.scrollable-column .scrollable-column-content {
            white-space: normal; /* Allow text wrapping for the specific column content */
        }

        .scrollable-table th {
            background-color: #4267b2;
            color:#fff;
        }
        .scrollable-table tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        .content a {
            display: inline-block;
            padding: 10px 20px;
            text-decoration: none;
            background-color: #4267b2;
            color: #fff;
            border-radius: 5px;
        }

        .content a:hover {
            background-color: #4267b2;
        }
    </style>
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

                <c:if test="${! empty disputes}">
                    <div class="scrollable-table">
                        <table>
                            <tr>
                                <th style="width: 10%;">订单id</th>
                                <th style="width: 10%;">用户id</th>
                                <th style="width: 10%;">商家id</th>
                                <th style="width: 10%;">涉及金额</th>
                                <th class="scrollable-column">描述</th>
                                <th style="width: 10%;">状态</th>
                                <th style="width: 10%;">纠纷类型</th>
                                <th style="width: 25%;">开始时间</th>
                                <th style="width: 10%;">审核状态</th>
                            </tr>
                            <c:forEach items="${disputes}" var="dispute">
                                <tr>
                                    <td>${dispute.orders.id}</td>
                                    <td>${dispute.orders.user.id}</td>
                                    <td>${dispute.orders.merchant.id}</td>
                                    <td>${dispute.amount}</td>
                                    <td class="scrollable-column"><div class="scrollable-column-content">${dispute.description}</div></td>
                                    <td>${dispute.state}</td>
                                    <td>${dispute.type}</td>
                                    <td>${dispute.date}</td>
                                    <c:if test="${dispute.check == '未审核'}">
                                        <td>
                                            <a href="${pageContext.request.contextPath}/toCheck?disputeId=${dispute.id}&serviceId=${service.id}">去审核</a>
                                        </td>
                                    </c:if>
                                    <c:if test="${dispute.check=='已审核'}">
                                        <td>
                                                ${dispute.check}
                                        </td>
                                    </c:if>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <br><br>
                    <c:forEach items="${indexList}" var="index">
                        <a href="${pageContext.request.contextPath}">${index}</a>
                    </c:forEach><br><br>
                    <a href="${pageContext.request.contextPath}/toServiceUncheck?serviceId=${service.id}">未审核</a>
                </c:if>
            </div>
        </div>
    </div>
</body>
</html>
