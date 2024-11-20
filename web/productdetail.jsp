
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- <link rel="stylesheet" href="./assets/css/header_footer.css"> -->
        <link rel="stylesheet" href="./assets/css/main.css">
        <link rel="stylesheet" href="./assets/css/products.css">
        <link rel="stylesheet" href="./assets/css/allproducts.css">
        <script type="text/javascript" language="javascript" src="./main.js"></script>
        <link rel="stylesheet" href="./assets/font/fontawesome-free-6.1.1/css/all.min.css">
        <link rel="icon" href="assets/img/small_logo1.png">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
        <title>BOT STORE</title>
    </head>
    <style>
        /*css ratting review form*/
        .review_box .input-rating {
            margin-bottom: 15px;
        }

        .review_box .input-rating .stars {
            display: inline-block;
            vertical-align: top;
        }

        .review_box .input-rating .stars input[type="radio"] {
            display: none;
        }

        .review_box .input-rating .stars>label {
            float: right;
            cursor: pointer;
            padding: 0px 3px;
            margin: 0px;
        }

        .review_box .input-rating .stars>label:before {
            content: "\f006";
            font-family: FontAwesome;
            color: #E4E7ED;
            -webkit-transition: 0.2s all;
            transition: 0.2s all;
        }

        .review_box .input-rating .stars>label:hover:before,
        .review_box .input-rating .stars>label:hover~label:before {
            color: #fbd600;
        }

        .review_box .input-rating .stars>input:checked label:before,
        .review_box .input-rating .stars>input:checked~label:before {
            content: "\f005";
            color: #fbd600;
        }
        /*css review display*/
        .reviews li {
            position: relative;
            padding-left: 145px;
            margin-bottom: 30px;
        }

        .reviews .review-heading {
            position: absolute;
            width: 130px;
            left: 0;
            top: 0;
            height: 70px;
        }

        .reviews .review-body {
            min-height: 70px;
        }

        .reviews .review-heading .name {
            margin-bottom: 5px;
            margin-top: 0px;
        }

        .reviews .review-heading .date {
            color: #8D99AE;
            font-size: 10px;
            margin: 0;
        }

        .reviews .review-heading .review-rating {
            margin-top: 5px;
        }

        .reviews .review-heading .review-rating>i {
            color: #E4E7ED;
        }

        .reviews .review-heading .review-rating>i.fa-star {
            color: #D10024;
        }
    </style>
    <body >
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
                            <a class="link_decor_remover hover-link" href="#">Giới thiệu</a>
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
        </div>
        <!-- end header -->

        <!-- body -->



        <c:set value="${requestScope.detail}" var="pd"/>
        <c:set value="${requestScope.product}" var="p"/>

        <div id="body">
            <div class="body_container">
                <ul class="breadcrumb">
                    <li><a href="home">Home</a></li>
                    <li><a href="filter-product?cateId=${p.category.id}">${requestScope.cate.name}</a></li>
                    <li>${p.title}</li>
                </ul>

                <div class="body_container-item view_infoproducts">
                    <div class="info_products-left">
                        <div class="info_products-left-top">
                            <img src="${p.thumbnail}" id="img_products_big">
                        </div>
                        <div class="info_products-left-bot">
                            <% int i =1; %>
                            <c:forEach items="${requestScope.listgallery}" var="gl" >

                                <img src="${gl.thumbnail}" class="img_products-small" onclick="img_product<%=i%>()">
                                <%i++;%>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="info_products-right">
                        <div class="info_product-right-child">
                            <div class="info_products-right-item">
                                <span class="info_products-right-title">${p.title}</span>
                            </div>

                            <div class="info_products-right-item">
                                <span>Dung tích : </span>
                                <c:forEach items="${requestScope.size}" var="s">
                                    <button style="padding: 3px 6px;
                                            list-style: none;
                                            border-radius: 6px;
                                            cursor: pointer;
                                            background-color: #eeeeee;"><a style="text-decoration: none; color: #000000;" href="pdetail?id=${param.id}&sid=${s.id}&gid=${p.gender.id}">${s.value}</a></button>
                                    </c:forEach>

                            </div>
                            <c:set value="${requestScope.gender}" var="g"/>
                            
                            






                            <div class="info_products-right-item">
                                <span>Giới tính phù hợp:</span>
                                <span class="info_products-right-brand">${g.name}</span>

                            </div>
                                
                            <div class="info_products-right-item">
                                <span>Số lượng:</span>
                                <span class="info_products-right-brand">${pd.quantity}</span>

                            </div>
                            
                                

                                
                            <div class="info_products-right-item">
                                <c:if test="${p.discount.value == 0}">
                                    <span class="info_products-right-price"><fmt:formatNumber type = "currency" pattern="###,###,###" value="${pd.price_out}"></fmt:formatNumber>đ</span> <br>
                                        </c:if> 
                                        <c:if test="${p.discount.value != 0}">
                                    <span class="info_price"><fmt:formatNumber type = "currency" pattern="###,###,###" value="${pd.price_out * ((100 - p.discount.value) / 100)}"></fmt:formatNumber>₫</span>
                                    <span class="oldprice"><fmt:formatNumber type = "currency" pattern="###,###,###" value="${pd.price_out}"></fmt:formatNumber>₫</span>
                                        </c:if>
                                        <%--<c:set value="${param.quantity}" var="quan"/>--%>
                                <div class="quantity-area clearfix" style="margin-bottom: -25px" >
                                    <input type="button" value="-" id="minus" onclick="minus()" class="qty-btn">
                                    <input type="text" oninput="this.value = this.value.replace(/[^0-9]/g, '');" id="quantity"  name="quantity" value="1" class="quantity-selector">
                                    <input type="button" value="+" id="plus" onclick="plus()" class="qty-btn">
                                </div>
                            </div>



                            <c:if test="${pd.quantity<=0}">
                                <div  style="margin-top: 70px">
                                    <button class="info_producst-right-add info_products-right-item" " >HẾT HÀNG</button>
                                </div>
                            </c:if>
                            <c:if test="${pd.quantity>0 }">
                                <form action="" method="post" name="fo">
                                    <div  style="margin-top: 70px">
                                        <button class="info_producst-right-add info_products-right-item" onclick="add('${param.id}', '${param.sid}')" >Thêm vào giỏ</button>
                                    </div>
                                </form>
                            </c:if>






                        </div>
                        <hr class="decoration_top-right-products">
                        <div class="info_products-right-item view_productsdetails">
                            <span class="info_products-right-title">Mô tả</span>
                            <span>${p.description}</span>
                        </div>
                        <hr class="decoration_top-right-products">
                        <div class="info_products-right-item view_policy">
                            <span class="info_products-right-title">Chính sách hỗ trợ</span>
                            <span>
                                <i class="fa-solid fa-check icon_check-policy"></i>
                                Đổi trả miễn phí nếu có lỗi từ nhà sản xuất
                            </span>
                            <span>
                                <i class="fa-solid fa-check icon_check-policy"></i>
                                Kiểm tra hàng trước khi thanh toán
                            </span>
                            <span>
                                <i class="fa-solid fa-check icon_check-policy"></i>
                                Miễn phí vận chuyển
                            </span>
                        </div>
                    </div>
                </div>
                <!--display  comment-->
                <c:if test="${listF.size()>0}">
                    <div class="body_container-item products_cmt-detail">
                        <div class="products_tab">
                            <button class="products-item" id="products-item-cmt" onclick="op_comment()">
                                Nhận xét
                            </button>
                            <button class="products-item" id="products-item-cmt1" onclick="loadMore()" >
                                Hiển thị thêm
                            </button>
                        </div>
                        <div class="products_contents">
                            <div class="products_cmt row" id="product_contentcomment">
                                <c:forEach items="${listF}" var="f">

                                    <div class="products_cmt-item feedbackok">
                                        <div class="products_cmt-top">
                                            <img src="${f.user.avatar}" class="img_avatar-user">
                                            <div class="user_rated">
                                                <span class="user_rated-name">${f.user.username}</span>
                                                <div>
                                                    <span>
                                                        <c:forEach  begin="1" end="${f.rating}">
                                                            <i class="fa-solid fa-star icon_star"></i>
                                                        </c:forEach>
                                                    </span>
                                                    <span class="user_rated-cmttime">${f.created_at}</span>
                                                </div>
                                            </div>
                                        </div>    
                                        <div class="products_cmt-bot">
                                            <p>${f.note}
                                            </p>
                                        </div>
                                    </div>

                                </c:forEach> 
                            </div>
                        </div>
                    </div>
                </c:if>


                <!--end display comment-->
                <div>
                    <div class="body_container-item user_ratingproducts">
                        <div class="user_ratingproducts-title">
                            Đánh giá của bạn cho sản phẩm này
                        </div>
                        <form action="feedback" method="post">
                            <c:set value="${product}" var="p"></c:set>
                            <input class="myClass" type="hidden" name="id" value="${p.id}">
                            <input type="hidden" name="sid" value="${sid}">
                            <input type="hidden" name="gid" value="${gid}">
                            <div class="user_ratingproducts-content">
                                <div class="review_box">
                                    <div class="input-rating">
                                        <span>Xếp hạng sản phẩm: </span>
                                        <div class="stars">
                                            <input id="star5" name="rating" required="" value="5" type="radio"><label
                                                for="star5"></label>
                                            <input id="star4" name="rating" required="" value="4" type="radio"><label
                                                for="star4"></label>
                                            <input id="star3" name="rating" required="" value="3" type="radio"><label
                                                for="star3"></label>
                                            <input id="star2" name="rating" required="" value="2" type="radio"><label
                                                for="star2"></label>
                                            <input id="star1" name="rating" required="" value="1" type="radio"><label
                                                for="star1"></label>
                                        </div>
                                    </div>
                                </div>
                                <div class="user_ratingproducts-cmt">
                                    <span>Nhận xét của bạn</span> <br>
                                    <textarea name="review" id="editor2" rows="4" cols="50" class="user_ratingproducts-cmt-child input"></textarea>
                                </div>
                                <div class="user_ratingproducts-cmt">
                                    <span style="color: red">${note}</span> <br>
                                </div>
                                <button class="btn_submit">Gửi</button>
                            </div>
                        </form>    
                    </div>
                </div>     
                <div class="body_container-item products_same">
                    <div class="products_same-title">
                        Sản phẩm tương tự
                    </div>
                    <div class="products_same-child">

                        <c:forEach items="${requestScope.relativeproducts}" var="rp">         

                            <div class="products">
                                <a href="pdetail?id=${rp.id}&sid=1&gid=${param.gid}">
                                    <img src="${rp.thumbnail}" alt="" class="img_products">
                                </a>
                                <div class="describe_products">
                                    <div class="ratings_products">
                                        <span>${rp.title}</span>
                                        <span>
<!--                                            <i class="fa-solid fa-star icon_star"></i>
                                            <i class="fa-solid fa-star icon_star"></i>
                                            <i class="fa-solid fa-star icon_star"></i>
                                            <i class="fa-solid fa-star icon_star"></i>
                                            <i class="fa-solid fa-star icon_star"></i>-->
                                        </span>
                                        <div>
                                            <c:if test="${rp.discount.value == 0}">
                                                <span class="info_price"><fmt:formatNumber type = "currency" pattern="###,###,###" value="${rp.sizeproduct.price_out}"></fmt:formatNumber> đ</span>
                                            </c:if> 
                                            <c:if test="${rp.discount.value != 0}">
                                                <span class="info_price"><fmt:formatNumber type = "currency" pattern="###,###,###" value="${rp.sizeproduct.price_out * ((100 - rp.discount.value) / 100)}"></fmt:formatNumber>₫</span>
                                                <span class="oldprice"><fmt:formatNumber type = "currency" pattern="###,###,###" value="${rp.sizeproduct.price_out}"></fmt:formatNumber>₫</span>
                                            </c:if>


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





            var img_products = [
            <c:forEach items="${requestScope.listgallery}" var="gl">
                "${gl.thumbnail}",
            </c:forEach>
            ];

            var dem = 0;

            function img_product1() {
                dem = 0;
                var img_products_big = document.getElementById("img_products_big");
                img_products_big.src = img_products[dem];
            }

            function img_product2() {
                dem = 1;
                var img_products_big = document.getElementById("img_products_big");
                img_products_big.src = img_products[dem];
            }

            function img_product3() {
                dem = 2;
                var img_products_big = document.getElementById("img_products_big");
                img_products_big.src = img_products[dem];
            }

            function img_product4() {
                dem = 3;
                var img_products_big = document.getElementById("img_products_big");
                img_products_big.src = img_products[dem];
            }

            function img_product5() {
                dem = 4;
                var img_products_big = document.getElementById("img_products_big");
                img_products_big.src = img_products[dem];
            }
            function add(id, size) {
                var q;
                var quan = document.getElementById("quantity").value;
                if (quan <= ${pd.quantity}) {
                    q = quan;
                } else {
                    q = ${pd.quantity};
                }
                document.fo.action = "buy?pid=" + id + "&sid=" + size + "&quantity=" + q;
                document.fo.submit();
            }
            var count = 1;
            var countEl = document.getElementById("quantity");
            function plus() {
                if (count < ${pd.quantity}) {
                    count++;
                    countEl.value = count;
                } else {
                    countEl.value = count;

                }
            }
            function minus() {
                if (count > 1) {
                    count--;
                    countEl.value = count;
                }
            }

            CKEDITOR.replace('editor2');



            function loadMore() {
                var productid = document.querySelector('.myClass');
                var pid = productid.value;
                var amount = document.getElementsByClassName("feedbackok").length;
                $.ajax({
                    url: "/SWP/load",
                    type: "Get", //send it through get method
                    data: {
                        exist: amount,
                        product_id: pid
                    },
                    success: function (data) {
                        var row = document.getElementById("product_contentcomment");
                        row.innerHTML += data;
                    },
                    error: function (xhr) {
                        console.log(xhr);
                    }
                });
            }

        </script>
        <!-- end footer -->
    </body>
</html>