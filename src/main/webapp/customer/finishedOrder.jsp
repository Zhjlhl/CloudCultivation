<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/12/19
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset=UTF-8>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--这里引入的是矢量图标签库-->
    <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
    <title>售后评价</title>
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
            color: #5558c9;
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
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            text-align: center;
            border-bottom: 1px solid #ccc;
        }
        th {
            background-color: #4267b2;
            color: #fff;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        form {
            display: inline-block;
        }
        label {
            margin-right: 5px;
        }
        input[type="text"],
        input[type="submit"] {
            padding: 5px 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        input[type="submit"] {
            background-color: #4267b2;
            color: #fff;
            cursor: pointer;
        }
        .pagination {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }

        .pagination button {
            background-color: #4267b2;
            color: white;
            padding: 10px 15px;
            border-radius: 5px;
            margin: 0 5px;
            border: none;
            cursor: pointer;
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
    <script>
        var currentPage = 1;
        var rowsPerPage = 5;

        function showPage(pageNumber) {
            var rows = document.querySelectorAll("table tbody tr");
            var totalRows = rows.length;
            var totalPages = Math.ceil(totalRows / rowsPerPage);

            if (pageNumber < 1) {
                pageNumber = 1;
            } else if (pageNumber > totalPages) {
                pageNumber = totalPages;
            }

            var startIndex = (pageNumber - 1) * rowsPerPage;
            var endIndex = startIndex + rowsPerPage;

            for (var i = 0; i < totalRows; i++) {
                if (i >= startIndex && i < endIndex) {
                    rows[i].style.display = "table-row";
                } else {
                    rows[i].style.display = "none";
                }
            }

            currentPage = pageNumber;
        }

        function showPreviousPage() {
            if (currentPage > 1) {
                showPage(currentPage - 1);
            }
        }

        function showNextPage() {
            var totalRows = document.querySelectorAll("table tbody tr").length;
            var totalPages = Math.ceil(totalRows / rowsPerPage);

            if (currentPage < totalPages) {
                showPage(currentPage + 1);
            }
        }
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
                    <p class="name">${user.name}</p>
                    <span>
                            欢迎您！
                    </span>
                </div>
            </div>

            <ul class="siderbar_menu">
                <li class="active">
                    <a href="${pageContext.request.contextPath}/toUserHome">
                        <div class="icon">
                            <i class="fas fa-home"></i>
                        </div>
                        <div class="active" >主页</div>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/toBuy?userId=${user.id}">
                        <div class="icon">
                            <i class="fa fa-cart-arrow-down"></i>
                        </div>
                        <div class="title">购买</div>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/toUserFeedOngoing?userId=${user.id}">
                        <div class="icon">
                            <i class="fa fa-heartbeat"></i>
                        </div>
                        <div class="title">饲养</div>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <div class="icon">
                            <i class="fa fa-paper-plane"></i>
                        </div>
                        <div class="title">收获</div>
                        <div class="arrow">
                            <i class="fas fa-chevron-down"></i>
                        </div>
                    </a>
                    <ul class="accordion">
                        <%--<li><a href="${pageContext.request.contextPath}/toWaitingPaid?userId=${user.id}" class="active">支付</a></li>--%>
                        <li><a href="${pageContext.request.contextPath}/toUserHarvestInformation?userId=${user.id}" >收获</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <div class="icon">
                            <i class="fa fa-handshake-o"></i>
                        </div>
                        <div class="title">售后</div>
                        <div class="arrow">
                            <i class="fas fa-chevron-down"></i>
                        </div>
                    </a>
                    <ul class="accordion">
                        <li><a href="${pageContext.request.contextPath}/toDispute?userId=${user.id}" >售后</a></li>
                        <li><a href="${pageContext.request.contextPath}/toUserFinished?userId=${user.id}" >评价</a></li>
                    </ul>
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
    <table>
        <tr>
            <th>订单号</th>
            <th>宠物姓名</th>
            <th>宠物种类</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>最终收益</th>
            <th>评价状态</th>
        </tr>
        <c:if test="${!empty orders}">
            <c:forEach items="${orders}" var="order" varStatus="st">
                <tr>
                    <td align="center">${order.id}</td>
                    <td align="center">${order.nickname}</td>
                    <td align="center">${order.goods.type}</td>
                    <td align="center">
                        <fmt:formatDate value="${order.date}" pattern="yyyy-MM-dd" />
                    </td>
                    <td align="center">
                        <fmt:formatDate value="${order.endTime}" pattern="yyyy-MM-dd" />
                    </td>
                    <td align="center">${order.endYield}</td>
                    <td align="center">
                        <c:choose>
                            <c:when test="${order.remark eq null}">
                                <form action="${pageContext.request.contextPath}/submitEvaluation?orderId=${order.id}" method="post">
                                    <label for="evaluateState">评价等级</label>
                                    <input type="text" name="evaluateState" id ="evaluateState">
                                    <input type="submit" value="提交">
                                </form>
                            </c:when>
                            <c:otherwise>
                                ${order.remark}
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    <div class="pagination">
        <button onclick="showPreviousPage()">上一页</button>
        <button onclick="showNextPage()">下一页</button>
    </div>
    <script>
        // Show the first page by default
        showPage(1);
    </script>
    </div>
    </div>
    </div>
</div>
</body>
</html>