<%-- 
    Document   : order
    Created on : Jan 31, 2023, 4:19:28 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link rel="stylesheet" href="./assets/css/orders.css">
        <script type="text/javascript" language="javascript" src="./main.js"></script>
        <link rel="stylesheet" href="./assets/font/fontawesome-free-6.1.1/css/all.min.css">
        <link rel="icon" href="./assets/img/small_logo1.png">
        <title>BOT STORE</title>

        <script type="text/javascript">
            function doDelete(id) {
                if (confirm("Bạn chắc chắn muốn hủy đơn hàng id=" + id + "?")) {
                    window.location = "cancelOrder?id=" + id;
                }
            }
        </script>
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
                        <input type="text" placeholder="Tìm Kiếm.." class="input_search">
                        <div class="search-item">
                            <i class="fa-solid fa-magnifying-glass icon-search"></i>
                        </div>
                    </div>
                    <div class="login-cart">
                        <div class="login-cart_item">
                            <!-- test -->
                            <a href="profile" class="login_cart-item-link">
                                <i class="fa-solid fa-user"></i>
                            </a>
                        </div>
                        <div class="login-cart_item">
                            <a href="cart" class="login_cart-item-link">
                                <i class="fa-solid fa-bag-shopping"></i>
                            </a>
                        </div>
                    </div>
                </div>
                <!-- end header mid top -->
                <!-- header mid bot -->
                <div class="mid-bot">
                    <!-- menu left -->
                    <div></div>
                    <!-- end menu left -->
                    <!-- menu right -->
                    <ul class="menu_right">
                        <li class="menu_right-item">
                            <a class="link_decor_remover hover-link" href="home">Trang chủ</a>
                        </li>
                        <li class="menu_right-item">
                            <a class="link_decor_remover hover-link" href="#">Hàng mới</a>
                        </li>
                        <li class="menu_right-item">
                            <a class="link_decor_remover hover-link" href="#">Thương hiệu</a>
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
                        <a href="myOrder" class="body_left-dashboard_child" id="current_page">
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
                        <a href="profile" class="body_left-dashboard_child">
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
                                <i class="fa-solid fa-cart-shopping  body_right-title_icon"></i>
                                <p id="body_right-title">Đơn hàng</p>
                            </div>
                        </div>
                        <!-- content -->
                        <div class="body_right-oders">
                            <!-- title -->
                            <div class="body_right-oders-title">
                                <div class="oders-title-child">Đơn hàng</div>
                                <div class="oders-title-child">Trạng thái</div>
                                <div class="oders-title-child">Ngày thanh toán</div>
                                <div class="oders-title-child">Tổng tiền</div>
                            </div>
                            <!-- content -->

                            <div>
                                <c:forEach var="order" items="${requestScope.listOrder}">

                                    <div class="body_right-oders_child">
                                        <div class="oders_items">
                                            <div class="oders_items-child">${order.id}</div>
                                            <div class="oders_items-child ">
                                                <c:if test="${order.status.id == 1}"><span class="status-gray">${order.status.name}</span></c:if>
                                                <c:if test="${order.status.id == 2}"><span class="status-yellow">${order.status.name}</span></c:if>
                                                <c:if test="${order.status.id == 3}"><span class="status-green">${order.status.name}</span></c:if>
                                                <c:if test="${order.status.id == 4}"><span class="status-red">${order.status.name}</span></c:if>
                                                </div>
                                                <div class="oders_items-child">${order.order_date}</div>
                                            <div class="oders_items-child money_margin"><fmt:formatNumber type = "currency" pattern="###,###,###" value="${order.total_money}"></fmt:formatNumber>đ</div>
                                            </div>
                                        <c:if test="${order.status_id == 1}">
                                            <div class="order_items_icon">
                                                <a  onclick="doDelete('${order.id}')" class="order_items_icon-link"> 
                                                    Hủy
                                                </a>
                                            </div>
                                        </c:if>
                                        <div class="order_items_icon">
                                            <a href="myOrderDetail?id=${order.id}" class="order_items_icon-link"> 
                                                <i class="fa-solid fa-arrow-right"></i>
                                            </a>
                                        </div>
                                    </div>

                                </c:forEach>
                            </div>

                            <!-- page button -->
                            <div class="page_button">
                                <c:if test="${maxPage>1}">
                                <ul class="page_button_container">
                                    <c:if test="${backPage>0}">
                                    <li class="page_button-child">
                                        <a href="myOrder?pageIndex=${backPage}"><i class="fa-solid fa-angle-left"></i></a>
                                    </li>
                                    </c:if>
                                    <c:forEach begin="1" end="${maxPage}" step="1" var="i">
                                    <li class="page_button-child"><a  href="myOrder?pageIndex=${i}">${i}</a></li>
                                    </c:forEach>
                                    <c:if test="${nextPage<maxPage+1}">
                                    <li class="page_button-child">
                                        <a href="myOrder?pageIndex=${nextPage}"> <i class="fa-solid fa-angle-right"></i></a>
                                      
                                    </li>
                                    </c:if>
                                </ul>
                                </c:if>
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
                        <a class="about-link" href="https://github.com/EmLongDauLung/WebDoChoi">
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
