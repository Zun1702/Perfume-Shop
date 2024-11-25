<%-- 
    Document   : thanh_toan
    Created on : Jan 31, 2023, 4:24:01 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../assets/css/header_footer.css">
    <link rel="stylesheet" href="../assets/css/profile_info.css">
    <link rel="stylesheet" href="../assets/css/thanh_toan.css">
    <script type="text/javascript" language="javascript" src="../main.js"></script>
    <link rel="stylesheet" href="../assets/font/fontawesome-free-6.1.1/css/all.min.css">
    <link rel="icon" href="../assets/img/small_logo1.png">
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
                            <img src="../assets/img/flagVN.jpg" class="language-item_child flag">
                            <span class="language-item_child ">VietNam</span>
                        </li>
                        <li class="language_item">
                            <img src="../assets/img/la-co-vuong-quoc-anh.jpg" class="language-item_child flag">
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
                    <a href="../index.html">
                    <img src="../assets/img/Logo.png" alt="Logo" id="img_logo">
                    </a>
                </div>
                <div class="search">
                    <input type="text" placeholder="Tìm Kiếm..." class="input_search">
                    <div class="search-item">
                        <i class="fa-solid fa-magnifying-glass icon-search"></i>
                    </div>
                </div>
                <div class="login-cart">
                    <a href="../src/login.html" class="login_cart-item-link">
                        <div class="login-cart_item">
                            <i class="fa-solid fa-user"></i>
                        </div>
                    </a>
                    <a href="../src/cart.html" class="login_cart-item-link">
                        <div class="login-cart_item">
                            <i class="fa-solid fa-bag-shopping"></i>
                        </div>
                    </a>
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
                                        <li class="menu_left-item-child"></li>
                                        <li class="menu_left-item-child"></li>
                                    </ul>
                                </div>
                            </li>
                            <li class="menu_left-item">
                            </li>
                            <li class="menu_left-item">
                                <div class="menu_left-item-title">
                                    <div class="menu_left-item-title-child">Mô hình khác</div>
                                    <i class="fa-solid fa-angle-right icon_arrow-menulv2"></i> 
                                </div>
                                <div class="menu_left-item-lv2">
                                    <ul>
                                        <li class="menu_left-item-child">Mô hình cây mini</li>
                                        <li class="menu_left-item-child">Mô hình trang trí</li>
                                        <li class="menu_left-item-child">Mô hình PC</li>
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
                    <a href="./oder.html" class="body_left-dashboard_child">
                        <div id="hover_icon">
                            <i class="fa-solid fa-cart-shopping  dashboard_icon"></i>
                            Đơn hàng
                        </div>
                        <span>69</span>
                    </a>
                    <a href="./favorite.html" class="body_left-dashboard_child">
                        <div id="hover_icon">
                            <i class="fa-solid fa-heart  dashboard_icon"></i>
                            Yêu thích
                        </div>
                        <span>420</span>
                    </a>
                    <a href="./support.html" class="body_left-dashboard_child">
                        <div id="hover_icon">
                            <i class="fa-solid fa-headset  dashboard_icon"></i>
                            Hỗ trợ
                        </div>
                        <span>1</span>
                    </a>
                </div>
                <!-- body left bot (acc setting)-->
                <div class="body_left-setting">
                    <div class="body_left-dashboard_title">TÀI KHOẢN</div>
                    <a href="../src/profile_info.html" class="body_left-dashboard_child">
                        <div id="hover_icon">
                            <i class="fa-solid fa-user  dashboard_icon"></i>
                            Trang cá nhân
                        </div>
                        <span>1</span>
                    </a>
                    <a href="../src/address.html" class="body_left-dashboard_child">
                        <div id="hover_icon">
                            <i class="fa-solid fa-location-arrow  dashboard_icon"></i>
                            Địa chỉ
                        </div>
                        <span>2</span>
                    </a>
                    <a href="../src/thanh_toan.html" class="body_left-dashboard_child" id="current_page">
                        <div id="hover_icon">
                            <i class="fa-solid fa-credit-card  dashboard_icon"></i>
                            Phương thức thanh toán
                        </div>
                        <span>3</span>
                    </a>
                </div>
            </div>
            <!-- body right -->
            <div class="body_right">
                <div>
                    <!-- title -->
                    <div class="body_right-title">
                        <div class="body_right-title-1">
                            <i class="fa-solid fa-credit-card body_right-title_icon"></i>
                            <p id="body_right-title">Phương Thức Thanh Toán</p>
                        </div>
                        <a class="body_right-edit_button" href="#">
                            Thêm phương thức thanh toán mới
                        </a>
                    </div>
                </div>
                <!-- payment content -->
                <div class="body_right-payment">
                    <div class="body_right-payment-item">
                        <div id="body_right-payment-item">
                            <div class="body_right-payment-item_child">
                                <img src="../assets/img/BIDV.jpg" alt="bidv bank" class="payment_logo">
                            </div>
                            <div class="body_right-payment-item_child">
                                <span class="payment_name">Do Tu Linh</span>
                            </div>
                        </div>
                        <div id="body_right-payment-item" class="body_right-payment-item-number">
                            <span>1234 **** **** ****</span>
                        </div>
                        <div id="body_right-payment-item">
                            <span>12 / 2026</span>
                        </div>
                        <div id="body_right-payment-item" class="body_right-payment-item-date">
                            <i class="fa-solid fa-pen icon_editaddress"></i>
                            <i class="fa-solid fa-trash-can icon_editaddress"></i>
                        </div>
                    </div>
                    <div class="body_right-payment-item">
                        <div id="body_right-payment-item">
                            <div class="body_right-payment-item_child">
                                <img src="../assets/img/vietcombank.jpg" alt="bank" class="payment_logo">
                            </div>
                            <div class="body_right-payment-item_child">
                                <span class="payment_name">Bui Ha Long</span>
                            </div>
                        </div>
                        <div id="body_right-payment-item" class="body_right-payment-item-number">
                            <span>6543 **** **** ****</span>
                        </div>
                        <div id="body_right-payment-item">
                            <span>02 / 2028</span>
                        </div>
                        <div id="body_right-payment-item" class="body_right-payment-item-date">
                            <i class="fa-solid fa-pen icon_editaddress"></i>
                            <i class="fa-solid fa-trash-can icon_editaddress"></i>
                        </div>
                    </div>
                    <div class="body_right-payment-item">
                        <div id="body_right-payment-item">
                            <div class="body_right-payment-item_child">
                                <img src="../assets/img/visa-logo-800x450.jpg" alt="bank" class="payment_logo">
                            </div>
                            <div class="body_right-payment-item_child">
                                <span class="payment_name">Do Tu Linh</span>
                            </div>
                        </div>
                        <div id="body_right-payment-item" class="body_right-payment-item-number">
                            <span>2313 **** **** ****</span>
                        </div>
                        <div id="body_right-payment-item">
                            <span>02 / 2030</span>
                        </div>
                        <div id="body_right-payment-item" class="body_right-payment-item-date">
                            <i class="fa-solid fa-pen icon_editaddress"></i>
                            <i class="fa-solid fa-trash-can icon_editaddress"></i>
                        </div>
                    </div>
                    <div class="body_right-payment-item">
                        <div id="body_right-payment-item">
                            <div class="body_right-payment-item_child">
                                <img src="../assets/img/momo.jpg" alt="bank" class="payment_logo payment_momo">
                            </div>
                            <div class="body_right-payment-item_child">
                                <span class="payment_name">Bui Ha Long</span>
                            </div>
                        </div>
                        <div id="body_right-payment-item" class="body_right-payment-item-number">
                            <span>2313 **** **** ****</span>
                        </div>
                        <div id="body_right-payment-item">
                            <span>02 / 2030</span>
                        </div>
                        <div id="body_right-payment-item" class="body_right-payment-item-date">
                            <i class="fa-solid fa-pen icon_editaddress"></i>
                            <i class="fa-solid fa-trash-can icon_editaddress"></i>
                        </div>
                    </div>
                    <div class="body_right-payment-item">
                        <div id="body_right-payment-item">
                            <div class="body_right-payment-item_child">
                                <img src="../assets/img/MBBANK.jpg" alt="bank" class="payment_logo">
                            </div>
                            <div class="body_right-payment-item_child">
                                <span class="payment_name">Bui Ha Linh</span>
                            </div>
                        </div>
                        <div id="body_right-payment-item" class="body_right-payment-item-number">
                            <span>1111 **** **** ****</span>
                        </div>
                        <div id="body_right-payment-item">
                            <span>10 / 2023</span>
                        </div>
                        <div id="body_right-payment-item" class="body_right-payment-item-date">
                            <i class="fa-solid fa-pen icon_editaddress"></i>
                            <i class="fa-solid fa-trash-can icon_editaddress"></i>
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
                    <img class="footer_logo-resize" src="../assets/img/Logo.png" alt="logo">
                </a>
                <p class="footer_contact-logo-text">
                </p>
                <div class="footer_contact-logo-onlineshop">
                    <a href="#" id="onlineshop">
                        <div class="online-shop">
                            <!-- logo shopee -->
                            <div class="shopee-tiki">
                                <img class="online-shop-logo" src="../assets/img/shopee.png" alt="shopee logo">
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
                                <img class="online-shop-logo" src="../assets/img/tiki.png" alt="tiki logo">
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
