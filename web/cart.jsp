<%-- 
    Document   : cart
    Created on : Jan 31, 2023, 4:11:44 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./assets/css/header_footer.css">
        <!-- <link rel="stylesheet" href="../assets/css/profile_info.css"> -->
        <link rel="stylesheet" href="./assets/css/cart.css">
        <link rel="stylesheet" href="./assets/css/products.css">
        <script type="text/javascript" language="javascript" src="./main.js"></script>
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

            <div class=${totalQuan>0?"body_container_cart":"empty_cart"}>

                <div class=${totalQuan>0?"body_right_cart":"empty_cart_font_div"}>

                    <c:if test="${totalQuan==0}" ><div><span class="empty_cart_font">Giỏ hàng trống</span></div></c:if>
                    <c:if test="${totalQuan>0}" >
                        <div class="body_right-item">
                            <span class="info_order">Đơn đặt hàng của bạn</span>
                            <div class="body_right-item-buy-products">
                                <div class="oders_info-child details">
                                    <div>
                                        <div class="oders_info-details">
                                            <div style=" width: 480px;">
                                                <span >Tên sản phẩm </span>
                                            </div>
                                            <div>
                                                <span>Đơn giá </span>

                                            </div>
                                            <div>
                                                <span>Số lượng</span>
                                            </div>
                                            <div>
                                                <span>Số tiền</span>

                                            </div>
                                            <div>
                                                <span>Thao tác</span>

                                            </div>
                                        </div>

                                        <c:set var="ldis" value="${ld}"></c:set>
                                        <div class="oders_info-description">
                                            <c:forEach items="${listItem}" var="c">
                                                <div class="oders_info-product">
                                                    <div class="oders_info-product-child">
                                                        <div>
                                                            <img src="${c.product.thumbnail}" alt="" class="product_img">
                                                        </div>
                                                        <div class="product-name">
                                                            <span class="product-name-title">${c.product.title}</span>
                                                        </div>
                                                    </div>
                                                    <div>
                                                        <c:forEach items="${ld}" var="ld">
                                                            <c:if test="${ld.id==c.product.discount_id}"><span><fmt:formatNumber type = "currency" pattern="###,###,###" value="${c.sizeproduct.price_out-(c.sizeproduct.price_out*(ld.value/100))}"  ></fmt:formatNumber>₫</span></c:if>
                                                        </c:forEach>
                                                        </div>

                                                        <form action="process?pid=${c.sizeproduct.pid}&sid=${c.sizeproduct.sid}" method="post">
                                                        <div class="quantity-area clearfix">
                                                            <input name="action" type="submit" value="-" id="minus" class="qty-btn">
                                                            <input readonly type="text" id="quantity"  name="quantity" value="${c.quantity}">
                                                            <input name="action" type="submit" value="+" id="plus" class="qty-btn">
                                                        </div>
                                                    </form>


                                                    <div>
                                                        <c:forEach items="${ld}" var="ld">
                                                        <c:if test="${ld.id==c.product.discount_id}"><span><fmt:formatNumber type = "currency" pattern="###,###,###" value="${(c.sizeproduct.price_out-(c.sizeproduct.price_out*(ld.value/100)))*c.quantity}"  ></fmt:formatNumber>₫</span></c:if>
                                                        </c:forEach>
                                                        </div>
                                                            <form action="deleteItem?pid=${c.sizeproduct.pid}&sid=${c.sizeproduct.sid}" method="post">
                                                        <div>
                                                            <button type="submit" class="delete_item" type="submit">Xóa</button>
                                                        </div>
                                                        </form>
                                                    </div>
                                            </c:forEach>
                                            <!--  -->
                                            <hr>
                                            <div class="oders_info-product">
                                                <div class="oders_info-product-child">
                                                    <div>

                                                    </div>
                                                    <div class="product-name">

                                                    </div>
                                                </div>
                                                <div>

                                                    <span></span>

                                                </div>
                                                <div>
                                                    <span></span>
                                                </div>
                                                <div>
                                                    <span></span>
                                                </div>
                                                <div>
                                                    <span>Tổng tiền tạm thời: </span>
                                                    <span><b>₫<fmt:formatNumber type = "currency" pattern="###,###,###" value="${cart.getTotalMoney(ldis)}"></fmt:formatNumber></b></span>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>



                                <div class="body_right-item">

                                    <div class="button_position">
                                        <form action="${sessionScope.userNow==null?"login":"checkoutitem"}">

                                        <button ${totalQuan==0?"disabled":""} class="place_order">Checkout</button> 
                                    </form>
                                </div>
                            </div>

                            <div class="body_right-item">
                                <div class="body_right-item-products">

                                </div>
                            </div>
                        </div>
                    </c:if>                  
                </div>
            </div>
        </div>
        <!-- end body -->
        <div id="footer">
            <!-- container footer -->
            <div class="container_footer">
                <!-- footer logo / online shop -->
                <div class="footer_contact-logo">
                    <a href="#">
                        <img class="footer_logo-resize" src="./assets/img/Logo.png" alt="logo">
                    </a>
                    <p class="footer_contact-logo-text">
                        Mua các mô hình, lego, trang trí tại của hàng Bot Store.
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
        <script type="text/javascript">


        </script>
    </body>

</html>
