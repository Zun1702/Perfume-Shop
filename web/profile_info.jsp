<%-- 
    Document   : profile
    Created on :  Feb 11, 2023, 11:39:29 PM
    Author     : Phuong-Linh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./assets/css/header_footer.css">
        <link rel="stylesheet" href="./assets/css/profile_info.css">
        <script type="text/javascript" language="javascript" src="../main.js"></script>
        <link rel="stylesheet" href="./assets/font/fontawesome-free-6.1.1/css/all.min.css">
        <link rel="icon" href="./assets/img/small_logo1.png">
        <title>BOT STORE</title>

    </head>
    <body>
        <!-- header -->
        <div id="header">
            <!-- header top -->
            <div class="header_top">
                <div class="header_top-intro">
                    <div class="header_top-intro-support">
                        <div class="sp-child hotline">
                            <i class="fa-solid fa-phone icon-sup"></i>
                            <span>+84 787171600</span>
                        </div>
                        <div class="sp-child email">
                            <i class="fa-solid fa-at icon-sup"></i>
                            <span>trungdnse183494@fpt.edu.vn</span>
                        </div>
                        <div class="sp-child question">
                            <i class="fa-solid fa-headset icon-sup"></i>
                            <span>Hỗ trợ trực tuyến 24/7</span>
                        </div>
                    </div>
                    <div class="header_top-intro-language">
                        Language
                        <i class="fa-solid fa-chevron-down icon_arrowdown"></i>
                        <ul class="language-child">
                            <li class="language_item">
                                <img src="./assets/img/flagVN.jpg" class="language-item_child flag">
                                <span class="language-item_child ">VietNam</span>
                            </li>
                            <li class="language_item">
                                <img src="./assets/img/la-co-vuong-quoc-anh.jpg" class="language-item_child flag">
                                <span class="language-item_child ">English</span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- end header top -->
            <!-- header mid -->
            <div class="header_mid">
                <!-- header mid top -->
                <div class="mid-top">
                    <div class="logo">
                        <a href="home">
                            <img src="./assets/img/Logo.png" alt="Logo" id="img_logo">
                        </a>
                    </div>
                    <div class="search">
                        <input type="text" placeholder="Tìm Kiếm..." class="input_search">
                        <div class="search-item">
                            <i class="fa-solid fa-magnifying-glass icon-search"></i>
                        </div>
                    </div>
                    <div class="login-cart">
                        <c:if test="${sessionScope.userNow.role_id==null}">

                            <a href="login" class="login_cart-item-link">
                                <div class="login-cart_item">
                                    <i class="fa-solid fa-key"></i>
                                </div>
                            </a>      

                        </c:if>
                        <c:if test="${sessionScope.userNow.role_id!=null}">
                            <a href="profile" class="login_cart-item-link" >
                                <div class="login-cart_item">
                                    <i class="fa-solid fa-user"></i>
                                </div>
                            </a>    

                        </c:if>

                        <a href="cart" class="login_cart-item-link">
                            <div class="login-cart_item">
                                <i class="fa-solid fa-bag-shopping"></i>
                            </div>
                        </a>
                        <c:if test="${sessionScope.userNow.role_id!=null}">
                            <a href="logout" class="login_cart-item-link">
                                <div class="login-cart_item">
                                    <i class="fa-solid fa-right-from-bracket"></i>
                                </div>
                            </a>    

                        </c:if>
                    </div>
                </div>
                <!-- end header mid top -->
                <!-- header mid bot -->
                <div class="mid-bot">
                    <!-- menu left -->
                    <button class="menu_left">
                        <i class="fa-solid fa-bars icon_list"></i>
                        Danh mục sản phẩm
                        <div class="menu_left-child">
                            <ul>
                                <li class="menu_left-item">
                                </li>
                                <li class="menu_left-item">
                                </li>
                                <li class="menu_left-item">
                                    <div class="menu_left-item-title">
                                        <div class="menu_left-item-title-child"></div>
                                        <i class="fa-solid fa-angle-right icon_arrow-menulv2"></i> 
                                    </div>
                                    <div class="menu_left-item-lv2">
                                        <ul>
                                            <li class="menu_left-item-child"></li>
                                            <li class="menu_left-item-child"></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="menu_left-item">
                                </li>
                                <li class="menu_left-item">
                                    <div class="menu_left-item-title">
                                        <div class="menu_left-item-title-child"></div>
                                        <i class="fa-solid fa-angle-right icon_arrow-menulv2"></i> 
                                    </div>
                                    <div class="menu_left-item-lv2">
                                        <ul>
                                            <li class="menu_left-item-child"></li>
                                            <li class="menu_left-item-child">/li>
                                            <li class="menu_left-item-child"></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="menu_left-item">
                                </li>
                                <li class="menu_left-item">
                                    <div class="menu_left-item-title">
                                        <div class="menu_left-item-title-child"></div>
                                        <i class="fa-solid fa-angle-right icon_arrow-menulv2"></i> 
                                    </div>
                                    <div class="menu_left-item-lv2">
                                        <ul>
                                            <li class="menu_left-item-child"></li>
                                            <li class="menu_left-item-child"></li>
                                            <li class="menu_left-item-child"></li>
                                        </ul>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </button>
                    <!-- end menu left -->
                    <!-- menu right -->
                    <ul class="menu_right">
                        <li class="menu_right-item">
                            <a class="link_decor_remover hover-link" href="home">Trang chủ</a>
                        </li>
                        <li class="menu_right-item">
                            <a class="link_decor_remover hover-link" href="shop">Hàng mới</a>
                        </li>
                        <li class="menu_right-item">
                            <a class="link_decor_remover hover-link" href="shop">Thương hiệu</a>
                        </li>
                        <li class="menu_right-item">
                            <a class="link_decor_remover hover-link" href="myOrder">Đơn hàng</a>
                        </li>
                        <li class="menu_right-item">
                            <a class="link_decor_remover hover-link" href="profile">Trang cá nhân</a>
                        </li>
                    </ul>
                    <!-- end menu right -->
                </div>
                <!-- end header mid bot -->
            </div>
            <!-- end mid -->
        </div>
        <!-- end header -->

        <!-- body -->
        <div id="body">
            <!-- container -->
            <div class="body_container">
                <!-- body left -->
                <div class="body_left">
                    <!-- body left top (dashboard)-->
                    <div class="body_left-dashboard">
                        <div class="body_left-dashboard_title">THÔNG TIN</div>
                        <a href="myOrder" class="body_left-dashboard_child">
                            <div id="hover_icon">
                                <i class="fa-solid fa-cart-shopping  dashboard_icon"></i>
                                Đơn hàng
                            </div>
                            <span>${requestScope.sumOrder}</span>
                        </a>

                    </div>
                    <!-- body left bot (acc setting)-->
                    <div class="body_left-setting">
                        <div class="body_left-dashboard_title">TÀI KHOẢN</div>
                        <a href="profile" class="body_left-dashboard_child" id="current_page">
                            <div id="hover_icon">
                                <i class="fa-solid fa-user dashboard_icon"></i>
                                Trang cá nhân
                            </div>

                        </a>
                        <a href="address" class="body_left-dashboard_child">
                            <div id="hover_icon">
                                <i class="fa-solid fa-location-arrow dashboard_icon"></i>
                                Địa chỉ
                            </div>
                            <span>${requestScope.sumAddress}</span>
                        </a>

                    </div>
                </div>
                <!-- body right -->
                <div class="body_right">
                    <div>
                        <!-- title -->
                        <div class="body_right-title">
                            <div class="body_right-title-1">
                                <i class="fa-solid fa-user body_right-title_icon"></i>
                                <p id="body_right-title">Trang Cá Nhân</p>
                            </div>
                            <a class="body_right-edit_button" href="changeProfile">
                                Sửa thông tin cá nhân
                            </a>
                        </div>
                        <!-- tên và trang thái -->
                        <div class="body_right-status">
                            <!-- avatar -->
                            <c:set var="a" value="${sessionScope.userNow}"/>
                            <div class="body_right-status_avatar">
                                <img src="${a.avatar}" alt="con ech" id="body_right-status_avatar">
                            </div>
                            <!-- name and crown -->
                            <div class="body_right-status_right">
                                <!-- name -->

                                <div class="body_right-status_name">
                                    <div id="body_right-status_name">${a.username}</div>
                                    <div class="body_right-status_name-money">
                                        Đã chi tiêu:
                                        <span id="body_right-status_name-money"><fmt:formatNumber type = "currency" pattern="###,###,###" value="${requestScope.sumMoney}"></fmt:formatNumber>đ</span>
                                        </div>

                                    <c:choose>
                                        <c:when test="${requestScope.sumMoney < 1000000}">
                                            <c:set var="lack" value="${1000000 - requestScope.sumMoney}"></c:set>
                                                <div class="body_right-status_name-level">
                                                    Thành viên mới
                                                </div>

                                        </c:when>
                                        <c:when test="${requestScope.sumMoney >= 1000000 && requestScope.sumMoney < 5000000}">
                                            <c:set var="lack" value="${5000000 - requestScope.sumMoney}"></c:set>
                                                <div class="body_right-status_name-level">
                                                    Thành viên bạc
                                                </div>
                                        </c:when>
                                        <c:when test="${requestScope.sumMoney >= 5000000 && requestScope.sumMoney < 10000000}">
                                            <c:set var="lack" value="${10000000 - requestScope.sumMoney}"></c:set>
                                                <div class="body_right-status_name-level">
                                                    Thành viên vàng
                                                </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="body_right-status_name-level" style="width: 160px">
                                                Thành viên kim cương
                                            </div>
                                        </c:otherwise>
                                    </c:choose>

                                </div>
                                <!-- crown -->
                                <div class="body_right-status_crown">
                                    <div class="body_right-status_crown-child">
                                        <c:choose>
                                            <c:when test="${requestScope.sumMoney < 1000000}">
                                                <p id="body_right-status_crown-child">
                                                    Hãy mua thêm <fmt:formatNumber type = "currency" pattern="###,###,###" value="${lack}"></fmt:formatNumber>đ để lên thành viên bạc
                                                    </p>
                                                    <div>
                                                        <progress style="width: 290px" min="0" max="1000000" value="${requestScope.sumMoney}">
                                                    </progress>
                                                </div>
                                            </c:when>
                                            <c:when test="${requestScope.sumMoney >= 1000000 && requestScope.sumMoney < 5000000}">
                                                <p id="body_right-status_crown-child">
                                                    Hãy mua thêm <fmt:formatNumber type = "currency" pattern="###,###,###" value="${lack}"></fmt:formatNumber>đ để lên thành viên vàng
                                                    </p>

                                                    <div>
                                                        <progress style="width: 290px" min="1000000" max="5000000" value="${requestScope.sumMoney}">
                                                    </progress>
                                                </div>
                                            </c:when>
                                            <c:when test="${requestScope.sumMoney >= 5000000 && requestScope.sumMoney < 10000000}">
                                                <p id="body_right-status_crown-child">
                                                    Hãy mua thêm <fmt:formatNumber type = "currency" pattern="###,###,###" value="${lack}"></fmt:formatNumber>đ để lên thành viên kim cương
                                                    </p>

                                                    <div>
                                                        <progress style="width: 290px" min="5000000" max="10000000" value="${requestScope.sumMoney}">
                                                    </progress>
                                                </div>
                                            </c:when>
                                            <c:otherwise>

                                            </c:otherwise>
                                        </c:choose>


                                    </div>
                                    <i class="fa-solid fa-crown" id="body_right-status_crown"></i>
                                </div>
                            </div>
                        </div>
                        <!-- lịch sử các đơn hàng -->

                        <!-- thông tin cá nhân -->
                        <div class="body_right-info">
                            <div class="body_right-info_child">
                                <div class="body_right-info_child-title">
                                    Họ
                                </div>

                                <c:choose>
                                    <c:when test = "${a.firstname == null}">
                                        <div class="body_right-info_child-text">
                                            <a href="changeProfile" style="text-decoration: none">Thêm thông tin</a>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        ${a.firstname}
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="body_right-info_child">

                                <div class="body_right-info_child-title">
                                    <a>Tên</a>
                                </div>

                                <c:choose>
                                    <c:when test = "${a.lastname == null}">
                                        <div class="body_right-info_child-text">
                                            <a href="changeProfile" style="text-decoration: none">Thêm thông tin</a>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="body_right-info_child-text">
                                            ${a.lastname}
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="body_right-info_child">
                                <div class="body_right-info_child-title">
                                    Email
                                </div>
                                <div class="body_right-info_child-text">
                                    ${a.email}
                                </div>
                            </div>
                            <div class="body_right-info_child">
                                <div class="body_right-info_child-title">
                                    Điện thoại
                                </div>

                                <c:choose>
                                    <c:when test="${a.phone_number == null}">
                                        <div class="body_right-info_child-text">
                                            <a href="changeProfile" style="text-decoration: none">Thêm thông tin</a>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="body_right-info_child-text">
                                            ${a.phone_number}
                                        </div>
                                    </c:otherwise>
                                </c:choose>

                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- end body -->

        <!-- footer -->
        <div id="footer">
            <!-- container footer -->
            <div class="container_footer">
                <!-- footer logo / online shop -->
                <div class="footer_contact-logo">
                    <a href="#">
                        <img class="footer_logo-resize" src="./assets/img/Logo.png" alt="logo">
                    </a>
                    <p class="footer_contact-logo-text">
                    </p>
                    <div class="footer_contact-logo-onlineshop">
                        <a href="#" id="onlineshop">
                            <div class="online-shop">
                                <!-- logo shopee -->
                                <div class="shopee-tiki">
                                    <img class="online-shop-logo" src="./assets/img/shopee.png" alt="shopee logo">
                                </div>
                                <!-- chữ bên cạnh logo -->
                                <div>
                                    <span class="online-shop-text-top">Shopping on</span>
                                    <p class="online-shop-text-bot">Shopee</p>
                                </div>
                            </div>
                        </a>
                        <a href="#" id="onlineshop">
                            <div class="online-shop">
                                <!-- logo tiki -->
                                <div class="shopee-tiki">
                                    <img class="online-shop-logo" src="./assets/img/tiki.png" alt="tiki logo">
                                </div>
                                <!-- chữ bên cạnh logo -->
                                <div>
                                    <span class="online-shop-text-top">Shopping on</span>
                                    <p class="online-shop-text-bot">Tiki</p>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>
                <!-- về chúng tôi -->
                <div class="footer_contact-about">
                    <!-- title -->
                    <div class="footer_contact-title">Về chúng tôi</div>
                    <!-- about us link -->
                    <div class="footer_contact-about-link">
                        <a class="about-link" href="#">Careers</a>
                        <a class="about-link" href="#">Của hàng của chúng tôi</a>
                        <a class="about-link" href="#">Chính sách giao hàng</a>
                        <a class="about-link" href="#">Điều khoản dịch vụ</a>
                        <a class="about-link" href="#">Chính sách quyền riêng tư</a>
                    </div>
                </div>
                <!-- dịch vụ chăm sóc khách hàng -->
                <div class="footer_contact-customer">
                    <!-- title -->
                    <div class="footer_contact-title">Hỗ trợ khách hàng</div>
                    <!-- customer care link -->
                    <div class="footer_contact-about-link">
                        <a class="about-link" href="#">Trung tâm hỗ trợ</a>
                        <a class="about-link" href="#">Cách để mua hàng</a>
                        <a class="about-link" href="#">Truy cứu đơn hàng</a>
                        <a class="about-link" href="#">Hợp tác</a>
                        <a class="about-link" href="#">Hoàn trả và hoàn tiền</a>
                    </div>
                </div>
                <!-- liên hệ -->
                <div class="footer_contact-contact">
                    <!-- title -->
                    <div class="footer_contact-title">Liên hệ chúng tôi</div>
                    <!-- địa chỉ -->
                    <p class="footer_contact-text">S.903 Vinhome grand park - Q9 - TPHCM</p>
                    <p class="footer_contact-text">Email: trungdnse183494@fpt.edu.vn</p>
                    <p class="footer_contact-text">Số điện thoại: +84 787171600</p>
                    <div class="footer_contact-icon">
                        <a class="about-link" href="#">
                            <div class="footer_contact-icon-child">
                                <i class="fa-brands fa-facebook-f"></i>
                            </div>
                        </a>
                        <a class="about-link" href="#">
                            <div class="footer_contact-icon-child">
                                <i class="fa-brands fa-instagram"></i>
                            </div>
                        </a>
                        <a class="about-link" href="#">
                            <div class="footer_contact-icon-child">
                                <i class="fa-brands fa-twitter"></i>
                            </div>
                        </a>
                        <a class="about-link" href="#">
                            <div class="footer_contact-icon-child">
                                <i class="fa-brands fa-youtube"></i>
                            </div>
                        </a>
                        <a class="about-link" href="#">
                            <div class="footer_contact-icon-child">
                                <i class="fa-brands fa-github"></i>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <!-- end footer -->
    </body>
</html>
