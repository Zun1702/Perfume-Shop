<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./assets/css/main.css">
        <!-- <link rel="stylesheet" href="./assets/css/main.css"> -->
        <link rel= "stylesheet" href="./main.js">
        <script type="text/javascript" language="javascript" src="./main.js"></script>
        <link rel="stylesheet" href="./assets/font/fontawesome-free-6.1.1/css/all.min.css">
        <link rel="icon" href="./assets/img/small_logo1.png">
        <!-- <link rel="icon" href="./assets/img/small_logo.png"> --> 
        <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy ="no-referrer" /> -->
        <title>Boon Bo</title>
        <script src="//code.jquery.com/jquery-1.12.4.js"></script>
        <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
                    <form action="search" method="get">
                        <div class="search">
                            <input name="txtSearch" type="text" value="${txtSearch}" placeholder="Tìm Kiếm..." class="input_search">
                            <div class="search-item">
                                <i class="fa-solid fa-magnifying-glass icon-search" onclick="submitForm()"></i>
                            </div>
                        </div>
                    </form>
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
                    <div class="menu_right">             
                        <li class="menu_right-item">
                            <a class="link_decor_remover hover-link" href="shop">Cửa hàng</a>
                        </li>
                        <li class="menu_right-item">
                            <a class="link_decor_remover hover-link" href="shop">Nước hoa</a>
                        </li>                        
                        <li class="menu_right-item">
                            <a class="link_decor_remover hover-link" href="shop">Nến thơm và tinh dầu</a>
                        </li>
                        <li class="menu_right-item">
                            <a class="link_decor_remover hover-link" href="shop">Sản phẩm khác</a>
                        </li>
                        <li class="menu_right-item">
                            <a class="link_decor_remover hover-link" href="#" id="about-link">Giới thiệu</a>
                        </li>
                        <c:if test="${userNow.role_id==1}">
                            <li class="menu_right-item">
                                <a class="link_decor_remover hover-link" href="dashboard">Dashboard</a>
                            </li>
                        </c:if>
                        <c:if test="${userNow.role_id==3}">
                            <li class="menu_right-item">
                                <a class="link_decor_remover hover-link" href="orderlist?page=1">Dashboard</a>
                            </li>
                        </c:if>
                        <c:if  test="${userNow.role_id==4}">
                            <li class="menu_right-item">
                                <a class="link_decor_remover hover-link" href="dashboardp">Dashboard</a>
                            </li>
                        </c:if>
                    </div> 
                    <!-- end menu right -->
                </div>
                <!-- end header mid bot -->
            </div>
            <!-- end mid -->
            <!-- bot -->
            <div class="header_bot">
                <div class="header_bot-review">
                    <img src="https://theme.hstatic.net/200000374707/1000984519/14/slideshow_1.jpg?v=51", alt="" id="img__bgreview">
                    <div class="arrow_slide arrow_slide-left">
                        <!-- <i class="fa-solid fa-circle-chevron-left icon_arrow-slide" onclick="prev()"></i> -->
                        <i class="fa-solid fa-chevron-left icon_arrow-slide" onclick="prev()"></i>
                    </div>
                    <div class="arrow_slide arrow_slide-right">
                        <i class="fa-solid fa-chevron-right icon_arrow-slide" onclick="next()"></i>
                    </div>
                </div>
            </div>
            <!-- end bot -->
        </div>
        <!-- end header -->
        <!-- body -->
        <div id="body">
            <!-- body-top -->
            <div class="body_top">
                <!-- DEAL -->
                <div class="body_top-deal">
                    <div class="body_top-title">
                        <div class="body_top-title-left">
                            <i class="fa-solid fa-bolt-lightning icon_top-title"></i>
                            Ưu đãi 
                        </div>
                        <div class="body_top-title-right">
                            <a href="shop" class="body_top-title-right-item">Xem tất cả
                                <i class="fa-solid fa-caret-right icon_arrow-viewall"></i>
                            </a>
                        </div>
                    </div>
                    <div class="body_bot-deal-child">

                        <c:forEach items="${pDiscount}" var="pd">
                            <div class="products">
                                <a href="pdetail?id=${pd.id}&sid=${pd.sizeproduct.sid}&gid=${pd.gender_id}">
                                    <img src="${pd.thumbnail}" alt="" class="img_products">
                                </a>
                                <div class="describe_products">
                                    <div class="ratings_products">
                                        <span>${pd.title}</span>

                                        <span>
                                            <i class="fa-solid fa-star icon_star"></i>
                                            <i class="fa-solid fa-star icon_star"></i>
                                            <i class="fa-solid fa-star icon_star"></i>
                                            <i class="fa-solid fa-star icon_star"></i>
                                            <i class="fa-solid fa-star icon_star"></i>
                                        </span>
                                        <div>

                                            <span class="info_price"><fmt:formatNumber type = "currency" pattern="###,###,###" value="${pd.sizeproduct.price_out * ((100 - pd.discount.value) / 100)}"></fmt:formatNumber>đ</span>
                                            <span class="oldprice"><fmt:formatNumber type = "currency" pattern="###,###,###" value="${pd.sizeproduct.price_out}"></fmt:formatNumber>đ</span>

                                            </div>
                                        </div>
                                        <div class="add_like_products">
                                            <i class="fa-regular fa-heart icon_heart"></i>
                                            <button class="btn_deal-item"><i class="fa-solid fa-plus"></i></button>
                                        </div>
                                    </div>
                                </div>

                        </c:forEach>

                    </div>
                </div>
                <!-- END DEAL -->

                <!-- end top sản phẩm -->
                <!-- sản phẩm mới -->
                <div class="body_top-newarrivals">
                    <div class="body_top-title">
                        <div class="body_top-title-left">
                            <i class="fa-solid fa-medal icon_top-title"></i>
                            Sản phẩm hàng đầu 
                        </div>
                        <div class="body_top-title-right">
                            <a href="shop" class="body_top-title-right-item">Xem tất cả
                                <i class="fa-solid fa-caret-right icon_arrow-viewall"></i>
                            </a>
                        </div>
                    </div>
                    <div class="body_bot-arrivals-info">

                        <c:forEach items="${pBestSeller}" var="pb">
                            <div class="arrivals-info_item">
                                <a href="pdetail?id=${pb.id}&sid=${pb.sizeproduct.sid}&gid=${pb.gender_id}">
                                    <img src="${pb.thumbnail}" class="img_arrivals-item">
                                </a>
                                <div class="arrivals-info_text">
                                    <span>${pb.title}</span>
                                    <c:if test="${pb.discount.id != 1}">
                                        <div>                                    
                                            <span class="info_price"><fmt:formatNumber type = "currency" pattern="###,###,###" value="${pb.sizeproduct.price_out * (100 - pb.discount.value) / 100}"></fmt:formatNumber>đ</span>
                                            <span class="oldprice"><fmt:formatNumber type = "currency" pattern="###,###,###" value="${pb.sizeproduct.price_out}"></fmt:formatNumber>đ</span>
                                            </div>
                                    </c:if>

                                    <c:if test="${pb.discount.id == 1}">
                                        <div>                                    
                                            <span class="info_price"><fmt:formatNumber type = "currency" pattern="###,###,###" value="${pb.sizeproduct.price_out}"></fmt:formatNumber>đ</span>      
                                            </div>
                                    </c:if>
                                </div>
                            </div>   
                        </c:forEach>

                    </div>
                </div>
                <!-- end sản phẩm mới -->
            </div>
            <!-- end body top -->
            <!-- body mid --> 
            <div class="body_mid">

            </div>
            <!-- end body mid -->
            <!-- body bot -->
            <div class="body_bot">
                <div class="body_top-title">
                    <div class="body_top-title-left">
                        <i class="fa-solid fa-burst icon_top-title"></i>
                        Sản phẩm mới
                    </div>
                    <div class="body_top-title-right">
                        <a href="shop" class="body_top-title-right-item">Xem tất cả
                            <i class="fa-solid fa-caret-right icon_arrow-viewall"></i>
                        </a>
                    </div>
                </div>
                <div class="body_bot-recommend">


                    <c:forEach items="${pNew}" var="p">

                        <div class="products products_recommend">
                            <a href="pdetail?id=${p.id}&sid=${p.sizeproduct.sid}&gid=${p.gender_id}">

                                <img src="${p.thumbnail}" alt="" class="img_products">
                            </a>
                            <div class="describe_products">
                                <div class="ratings_products">
                                    <span>${p.title}</span>
                                    <span>
                                        <i class="fa-solid fa-star icon_star"></i>
                                        <i class="fa-solid fa-star icon_star"></i>
                                        <i class="fa-solid fa-star icon_star"></i>
                                        <i class="fa-solid fa-star icon_star"></i>
                                        <i class="fa-solid fa-star icon_star"></i>
                                    </span>

                                    <c:if test="${p.discount.id != 1}">
                                        <div>                                    
                                            <span class="info_price"><fmt:formatNumber type = "currency" pattern="###,###,###" value="${p.sizeproduct.price_out * (100 - p.discount.value) / 100}"></fmt:formatNumber>đ</span>
                                            <span class="oldprice"><fmt:formatNumber type = "currency" pattern="###,###,###" value="${p.sizeproduct.price_out}"></fmt:formatNumber>đ</span>
                                            </div>
                                    </c:if>

                                    <c:if test="${p.discount.id == 1}">
                                        <div>                                    
                                            <span class="info_price"><fmt:formatNumber type = "currency" pattern="###,###,###" value="${p.sizeproduct.price_out}"></fmt:formatNumber>đ</span>      
                                            </div>
                                    </c:if>

                                </div>
                                <div class="add_like_products">
                                    <i class="fa-regular fa-heart icon_heart"></i>
                                    <button class="btn_deal-item"><i class="fa-solid fa-plus"></i></button>
                                </div>
                            </div>
                        </div>
                    </c:forEach>





                </div>
                <div id="boonbo123" class="body_info">
                    <div class="body_info-item">
                        <div style="width: 333px; height: 333px;border-radius: 10px; box-shadow: 0px 2px 20px -8px black; background-image: url(https://theme.hstatic.net/200000374707/1000984519/14/home_box_item_image_1.png?v=51)">
                        </div>
                        <div style="margin-top: 15px">
                            <span class="body_info-item-title">Boon Bo - Eau De Parfum</span>
                            <p class="body_info-item-description">Chào mừng bạn đến với shop nước hoa của Boon Bo, nơi mang đến cho bạn những trải nghiệm hương thơm tuyệt vời và độc đáo. Boon Bo tự hào là địa chỉ tin cậy, cung cấp các sản phẩm nước hoa chính hãng từ những thương hiệu danh tiếng trên thế giới.</p>
                        </div>
                    </div>
                    <div style="margin-left: 100px; margin-right: 100px" class="body_info-item">
                        <div style="width: 333px; height: 333px;border-radius: 10px; box-shadow: 0px 2px 20px -8px black; background-image: url(https://theme.hstatic.net/200000374707/1000984519/14/home_box_item_image_2.png?v=51)">
                        </div>
                        <div style="margin-top: 15px">
                            <span class="body_info-item-title">Pha chế & Đóng gói</span>
                            <p class="body_info-item-description">Boon Bo Lab được trang bị đầy đủ các thiết bị hiện đại, đảm bảo quy trình sản xuất và kiểm tra chất lượng nghiêm ngặt. Mọi thao tác pha chế, đóng gói được đội ngũ Boon Bo thực hiện ngay tại Boon Bo Lab cùng với sự tham gia của bạn.</p>
                        </div>
                    </div>
                    <div class="body_info-item">
                        <div style="width: 333px; height: 333px;border-radius: 10px; box-shadow: 0px 2px 20px -8px black; background-image: url(https://theme.hstatic.net/200000374707/1000984519/14/home_box_item_image_3.png?v=51)">
                        </div>
                        <div style="margin-top: 15px">
                            <span class="body_info-item-title">Tạo dấu ấn riêng</span>
                            <p class="body_info-item-description">Duy nhất tại Boon Bo, chúng tôi giúp bạn khắc tên riêng hay ghi lại tháng năm hoàn toàn miễn phí, và chỉ trong vài phút.
                            </p>
                        </div>
                    </div>
                    <button id="scrollToTopBtn" title="Go to top">
                        <i class="fa-solid fa-arrow-up"></i>
                    </button>

                </div>   
            </div>

            <!-- End body bot -->
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
                        <a class="about-link" href="https://www.facebook.com/trungdoan1702/">
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
        <script>
            function scrollToSection(event) {
                event.preventDefault();
                document.getElementById("boonbo123").scrollIntoView({behavior: "smooth"});
            }
            document.addEventListener("DOMContentLoaded", function () {
                document.getElementById("about-link").addEventListener("click", scrollToSection);
            });
            var mybutton = document.getElementById("scrollToTopBtn");

            window.onscroll = function () {
                scrollFunction();
            };

            function scrollFunction() {
                if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
                    mybutton.style.display = "block";
                } else {
                    mybutton.style.display = "none";
                }
            }

            mybutton.onclick = function () {
                window.scrollTo({top: 0, behavior: 'smooth'});
            };
        </script>
        <!-- end footer -->
    </body>
</html>
