<%-- 
    Document   : dashboard
    Created on : Feb 24, 2023, 5:24:11 PM
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html lang="en">

    <!-- Mirrored from templates.g5plus.net/glowing/dashboard/dashboard-product-list.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 24 Feb 2023 07:49:51 GMT -->
    <!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="Glowing Shop Html Template">
        <meta name="author" content="">
        <meta name="generator" content="Jekyll">
        <title>Bảng danh sách sản phẩm - Boon Bo</title>

        <script src="./cdn-cgi/apps/head/2oc_RD5SS6wgN5SiQnSEnWVNHg8.js"></script><link href="https://fonts.googleapis.com/css2?family=Urbanist:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&amp;display=swap" rel="stylesheet">
        <link rel="stylesheet" href="./vendors/fontawesome-pro-5/css/all.css">
        <link rel="stylesheet" href="./vendors/bootstrap-select/css/bootstrap-select.min.css">
        <link rel="stylesheet" href="./vendors/slick/slick.min.css">
        <link rel="stylesheet" href="./vendors/magnific-popup/magnific-popup.min.css">
        <link rel="stylesheet" href="./vendors/jquery-ui/jquery-ui.min.css">
        <link rel="stylesheet" href="./vendors/animate.css">
        <link rel="stylesheet" href="./vendors/mapbox-gl/mapbox-gl.min.css">
        <link rel="stylesheet" href="./vendors/fonts/font-phosphor/css/phosphor.min.css">
        <link rel="stylesheet" href="./vendors/fonts/tuesday-night/stylesheet.min.css">
        <link rel="stylesheet" href="./vendors/fonts/butler/stylesheet.min.css">
        <link rel="stylesheet" href="./vendors/fonts/a-antara-distance/stylesheet.min.css">

        <link rel="stylesheet" href="./css/themes.css">

        <link rel="icon" href="./assets/img/small_logo1.png">

        <meta name="twitter:card" content="summary">
        <meta name="twitter:site" content="@">
        <meta name="twitter:creator" content="@">
        <meta name="twitter:title" content="Dashboard">
        <meta name="twitter:description" content="Glowing Shop Html Template">
        <meta name="twitter:image" content="./img/logo_01.png">

        <meta property="og:url" content="dashboard.html">
        <meta property="og:title" content="Dashboard">
        <meta property="og:description" content="Glowing Shop Html Template">
        <meta property="og:type" content="website">
        <meta property="og:image" content="./img/logo_01.png">
        <meta property="og:image:type" content="image/png">
        <meta property="og:image:width" content="1200">
        <meta property="og:image:height" content="630">

        <script type="text/javascript">
            function doDelete(id) {
                if (confirm("Are you sure to delete discount with id=" + id)) {
                    window.location = "deletediscount?id=" + id;
                }
            }
        </script>


    </head>
    <body>
        <c:set var="a" value="${sessionScope.userNow}"/>
        <div class="wrapper dashboard-wrapper">
            <div class="d-flex flex-wrap flex-xl-nowrap">
                <div class="db-sidebar bg-white">
                    <nav class="navbar navbar-expand-xl navbar-light d-block px-0 header-sticky dashboard-nav py-0">
                        <div class="sticky-area border-right">
                            <div class="d-flex px-3 px-xl-6 w-100 border-bottom py-2">
                                <a class="navbar-brand" href="home">
                                    <img src="./assets/img/Logo.png" alt="Glowing">
                                </a>
                                <div class="ml-auto d-flex align-items-center ">



                                    <button class="navbar-toggler border-0 px-0" type="button" data-toggle="collapse" data-target="#primaryMenuSidebar" aria-controls="primaryMenuSidebar" aria-expanded="false" aria-label="Toggle navigation">
                                        <span class="navbar-toggler-icon"></span>
                                    </button>
                                </div>
                            </div>
                            <div class="collapse navbar-collapse bg-white" id="primaryMenuSidebar">
                                <form class="d-block d-xl-none pt-5 px-3">
                                    <div class="input-group position-relative bg-gray">
                                        <input type="text" class="form-control border-0 bg-transparent pl-4 shadow-none" placeholder="Search Item">
                                        <div class="input-group-append fs-14 px-3 border-left border-2x ">
                                            <button class="bg-transparent border-0 outline-none">
                                                <i class="fal fa-search"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>

                                <ul class="list-group list-group-flush list-group-no-border w-100 p-3">
                                    <c:if test="${a.role_id==1}">
                                        <li class="list-group-item px-0 py-0 sidebar-item mb-1">
                                            <a href="dashboard" class="text-heading lh-1 sidebar-link py-2 px-3 px-xl-4 d-block">
                                                <span class="sidebar-item-icon d-inline-block mr-3 text-muted fs-18">
                                                    <i class="fas fa-home-lg-alt"></i>
                                                </span>
                                                <span class="sidebar-item-text">Trang tổng quát</span>
                                            </a>
                                        </li>
                                    </c:if>
                                    <c:if test="${a.role_id==1 || a.role_id==4}">
                                        <li class="list-group-item px-0 py-0 sidebar-item mb-1 has-children">
                                            <a href="#product" class="text-heading lh-1 sidebar-link d-flex align-items-center py-2 px-3 px-xl-4" data-toggle="collapse" aria-haspopup="true" aria-expanded="false">
                                                <span class="sidebar-item-icon d-inline-block mr-3 text-muted fs-18">
                                                    <i class="fas fa-shopping-bag"></i>
                                                </span>
                                                <span class="sidebar-item-text">Sản phẩm</span>
                                                <span class="d-inline-block ml-auto"><i class="fal fa-angle-down"></i></span>
                                            </a>
                                            <div class="collapse menu-collapse" id="product">
                                                <ul class="sub-menu list-unstyled">
                                                    <li class="sidebar-item">
                                                        <a class="sidebar-link lh-1" href="dashboardp">Danh sách sản phẩm</a>
                                                    </li>
                                                    <li class="sidebar-item">
                                                        <a class="sidebar-link lh-1" href="dashboardc">Danh sách thể loại</a>
                                                    </li>
                                                    <li class="sidebar-item">
                                                        <a class="sidebar-link lh-1" href="dashboardg">Danh sách thư viện</a>
                                                    </li>
                                                    <li class="sidebar-item">
                                                        <a class="sidebar-link lh-1" href="dashboards">Danh sách kích thước</a>
                                                    </li>
                                                    <li class="sidebar-item">
                                                        <a class="sidebar-link lh-1" href="dashboardd">Danh sách mã giảm giá</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li>
                                    </c:if>
                                    <c:if test="${a.role_id==1 || a.role_id==3}">
                                        <li class="list-group-item px-0 py-0 sidebar-item mb-1 has-children">
                                            <a href="#order" class="text-heading lh-1 sidebar-link d-flex align-items-center py-2 px-3 px-xl-4" data-toggle="collapse" aria-haspopup="true" aria-expanded="false">
                                                <span class="sidebar-item-icon d-inline-block mr-3 text-muted fs-18">
                                                    <i class="fas fa-shopping-cart"></i>
                                                </span>
                                                <span class="sidebar-item-text">Đơn hàng</span>
                                                <span class="d-inline-block ml-auto"><i class="fal fa-angle-down"></i></span>
                                            </a>
                                            <div class="collapse menu-collapse" id="order">
                                                <ul class="sub-menu list-unstyled">
                                                    <li class="sidebar-item">
                                                        <a class="sidebar-link lh-1" href="orderlist?page=1">Danh sách đơn hàng</a>
                                                    </li>

                                                </ul>
                                            </div>
                                        </li>
                                    </c:if>
                                    <c:if test="${a.role_id==1}">
                                        <li class="list-group-item px-0 py-0 sidebar-item mb-1 has-children">
                                            <a href="#sellers" class="text-heading lh-1 sidebar-link d-flex align-items-center py-2 px-3 px-xl-4" data-toggle="collapse" aria-haspopup="true" aria-expanded="false">
                                                <span class="sidebar-item-icon d-inline-block mr-3 text-muted fs-18">
                                                    <i class="fas fa-users"></i>
                                                </span>
                                                <span class="sidebar-item-text">Quản lý tài khoản</span>
                                                <span class="d-inline-block ml-auto"><i class="fal fa-angle-down"></i></span>
                                            </a>
                                            <div class="collapse menu-collapse" id="sellers">
                                                <ul class="sub-menu list-unstyled">
                                                    <li class="sidebar-item">
                                                        <a class="sidebar-link lh-1" href="showallstaff">Thẻ thông tin nhân viên</a>
                                                    </li>
                                                    <li class="sidebar-item">
                                                        <a class="sidebar-link lh-1" href="alluser?page=1">Thông tin của người dùng</a>
                                                    </li>

                                                </ul>
                                            </div>
                                        </li>
                                    </c:if>
                                    <c:if test="${a.role_id==1}">
                                        <li class="list-group-item px-0 py-0 sidebar-item mb-1">
                                            <a href="feedbacklist?page=1" class="text-heading lh-1 sidebar-link py-2 px-3 px-xl-4 d-block">
                                                <span class="sidebar-item-icon d-inline-block mr-3 text-muted fs-18">
                                                    <i class="fas fa-comment-alt-lines"></i>
                                                </span>
                                                <span class="sidebar-item-text">Lượt đánh giá</span>
                                            </a>
                                        </li>
                                    </c:if>

                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>
                <div class="page-content">
                    <header class="main-header bg-white position-relative d-none d-xl-block">
                        <div class="container-fluid">
                            <nav class="navbar navbar-light py-0 row no-gutters px-3 px-lg-0">
                                <c:if test="${a!=null}">
                                    <div class="col-md-6 d-flex flex-wrap justify-content-md-end align-items-center order-0 order-md-1">

                                        <div class="dropdown pl-2 py-2">
                                            <a href="#" class="dropdown-toggle text-heading pr-3 pr-sm-6 d-flex align-items-center justify-content-end" data-toggle="dropdown">
                                                <div class="w-40px">
                                                    <img src="${a.avatar}" alt="${a.username}" class="rounded-circle">
                                                </div>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-right w-100">
                                                <a class="dropdown-item" href="showprofile?id=${a.id}">Thông tin cá nhân</a>
                                                <a class="dropdown-item" href="logout">Đăng xuất</a>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                            </nav>
                        </div>
                    </header>
                    <main id="content" class="bg-gray-01 d-flex flex-column main-content">
                        <div class="dashboard-page-content">
                            <form action="delete" method="get">
                                <div class="row mb-6 align-items-center">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <h2 class="fs-24 mb-0">Bảng danh sách mã giảm giá</h2>
                                        <br>
                                        <h2 style="color: red; font-size: medium">${mess}</h2>
                                        <p class="mb-0"></p>
                                    </div>                                  
                                    <div class="col-sm-6 d-flex flex-wrap justify-content-sm-end">

                                        
                                        
                                        <a href="adddiscountjsp" class="btn btn-primary">Tạo mới
                                        </a>
                                    </div>
                                </div>
                                <div class="card mb-4 rounded-xl p-4">
                                    <div class="card-body p-0">
                                        <div class="table-responsive">
                                            <div class="table-responsive">
                                                <table class="table align-middle table-nowrap mb-0">
                                                    <tbody>
                                                        
                                                        <tr>
                                                            <td></td>
                                                            <td class="text-secondary align-middle font-weight-bold">ID</td>
                                                            <td class="text-secondary align-middle font-weight-bold">Name</td>
                                                            <td></td>
                                                        </tr>
                                                        <c:forEach items="${alld}" var="d">
                                                            <tr>

                                                                <td class="text-center align-middle  pt-4 ">
                                                                    
                                                                </td>

                                                                <td class=" pt-6 ">
                                                                    
                                                                        
                                                                        <div class="media-body">
                                                                            <p >${d.id}</p>
                                                                        </div>
                                                                   
                                                                </td>

                                                                <td >${d.value}%</td>
                                                          

                                                                
                                                                <td class="align-middle">
                                                                    <div class="d-flex flex-wrap justify-content-end">
                                                                        <a href="editdiscount?id=${d.id}" class="btn btn-primary btn-sm mr-1 my-1"><i class="fal fa-pen"></i><span class="d-inline-block ml-1">Chỉnh sửa</span></a>
                                                                        <a href="#" onclick="doDelete('${d.id}')" class="btn btn-sm border hover-white bg-hover-primary mr-1 border-primary my-1 text-secondary font-weight-400"><i class="fas fa-trash-alt"></i><span class="d-inline-block ml-1">Xóa</span></a>

                                                                    </div>
                                                                </td>
                                                            </tr> 
                                                        </c:forEach>
                                                            
                                                             

                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form> 
                            <nav aria-label="Page navigation example" class="mt-6 mb-4">
                                <ul class="pagination justify-content-start">
                                    <li class="page-item active mx-1"><a class="page-link" href="#">01</a></li>
                                    <li class="page-item mx-1"><a class="page-link" href="#">02</a></li>
                                    <li class="page-item mx-1"><a class="page-link" href="#">03</a></li>
                                    <li class="page-item mx-1"><a class="page-link dot" href="#">...</a></li>
                                    <li class="page-item mx-1"><a class="page-link" href="#">16</a></li>
                                    <li class="page-item mx-1">
                                        <a class="page-link" href="#"><i class="far fa-chevron-right"></i></a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                        <footer class="pt-3 pb-6 footer-dashboard mt-auto">
                            <div class="row">
                                <div class="col-sm-6">
                                    <script>
                                        document.write(new Date().getFullYear());
                                    </script>
                                    © Boon Bo - Cửa hàng bán nước hoa .
                                </div>
                                <div class="col-sm-6">
                                    <div class="text-sm-right">Đã đăng ký bản quyền</div>
                                </div>
                            </div>
                        </footer>
                    </main>
                </div>
            </div>
        </div>

        <script src="./vendors/jquery.min.js"></script>
        <script src="./vendors/jquery-ui/jquery-ui.min.js"></script>
        <script src="./vendors/bootstrap/bootstrap.bundle.js"></script>
        <script src="./vendors/bootstrap-select/js/bootstrap-select.min.js"></script>
        <script src="./vendors/slick/slick.min.js"></script>
        <script src="./vendors/waypoints/jquery.waypoints.min.js"></script>
        <script src="./vendors/counter/countUp.js"></script>
        <script src="./vendors/magnific-popup/jquery.magnific-popup.min.js"></script>
        <script src="./vendors/hc-sticky/hc-sticky.min.js"></script>
        <script src="./vendors/jparallax/TweenMax.min.js"></script>
        <script src="./vendors/mapbox-gl/mapbox-gl.js"></script>
        <script src="./vendors/isotope/isotope.js"></script>
        <script src="./vendors/chartjs/chart.min.js"></script>

        <script src="./js/theme.js"></script>
        <div class="modal sign-in" id="sign-in" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header border-0 p-6">
                        <nav class="w-100">
                            <div class="nav nav-tabs" id="nav-tab" role="tablist">
                                <a class="nav-link active" id="nav-log-in-tab" data-toggle="tab" href="#nav-log-in" role="tab" aria-controls="nav-log-in" aria-selected="true">Log in</a>
                                <a class="nav-link" id="nav-register-tab" data-toggle="tab" href="#nav-register" role="tab" aria-controls="nav-register" aria-selected="false">Register</a>
                            </div>
                        </nav>
                        <button type="button" class="close opacity-10 fs-32 pt-1 position-absolute" data-dismiss="modal" aria-label="Close" style="right: 30px">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body px-9 pb-8">
                        <div class="tab-content" id="nav-tabContent">
                            <div class="tab-pane fade show active" id="nav-log-in" role="tabpanel" aria-labelledby="nav-log-in-tab">
                                <h4 class="fs-34 text-center mb-6">Sign In</h4>
                                <p class="text-center fs-16 mb-7">Don’t have an account yet? <a href="#" class="text-secondary border-bottom text-decoration-none">Sign up</a> for free</p>
                                <form>
                                    <input name="email" type="email" class="form-control border-0 mb-3" placeholder="Your email" required>
                                    <input name="password" type="password" class="form-control border-0" placeholder="Password" required>
                                    <div class="d-flex align-items-center justify-content-between mt-5 mb-4">
                                        <div class="custom-control custom-checkbox">
                                            <input name="stay-signed-in" type="checkbox" class="custom-control-input" id="staySignedIn">
                                            <label class="custom-control-label text-body" for="staySignedIn">Stay signed in</label>
                                        </div>
                                        <a href="#" class="text-secondary">Forgot your password?</a>
                                    </div>
                                    <button type="submit" value="Login" class="btn btn-secondary btn-block bg-hover-primary border-hover-primary">Log In</button>
                                    <div class="border-bottom mt-6"></div>
                                    <div class="text-center mt-n2 lh-1 mb-4">
                                        <span class="fs-14 bg-white lh-1 mt-n2 px-4">or Log-in with</span>
                                    </div>
                                    <div class="d-flex">
                                        <a href="#" class="btn btn-outline-secondary btn-block border-2x border mr-5 border-hover-secondary"><i class="fab fa-facebook-f mr-2" style="color: #2E58B2"></i>Facebook</a>
                                        <a href="#" class="btn btn-outline-secondary btn-block border-2x border mt-0 border-hover-secondary"><i class="fab fa-google mr-2" style="color: #DD4B39"></i>Google</a>
                                    </div>
                                </form>
                            </div>
                            <div class="tab-pane fade" id="nav-register" role="tabpanel" aria-labelledby="nav-register-tab">
                                <h4 class="fs-34 text-center mb-6">Sign Up</h4>
                                <p class="text-center fs-16 mb-7">Already have an account? <a href="#" class="text-secondary border-bottom text-decoration-none">Log in</a></p>
                                <form>
                                    <input name="first-name" type="text" class="form-control border-0 mb-3" placeholder="First name" required>
                                    <input name="last-name" type="text" class="form-control border-0 mb-3" placeholder="Last name" required>
                                    <input name="email" type="email" class="form-control border-0 mb-3" placeholder="Your email" required>
                                    <input name="password" type="password" class="form-control border-0" placeholder="Password" required>
                                    <div class="custom-control custom-checkbox mt-4 mb-5 mr-xl-6">
                                        <input name="agree" type="checkbox" class="custom-control-input" id="termsOfUse">
                                        <label class="custom-control-label text-body" for="termsOfUse">
                                            Yes, I agree with Grace <a href="#">Privacy Policy</a> and <a href="#">Terms of Use</a>
                                        </label>
                                    </div>
                                    <button type="submit" value="Login" class="btn btn-secondary btn-block bg-hover-primary border-hover-primary">Sign Up</button>
                                    <div class="border-bottom mt-6"></div>
                                    <div class="text-center mt-n2 lh-1 mb-4">
                                        <span class="fs-14 bg-white lh-1 mt-n2 px-4">or Sign Up with</span>
                                    </div>
                                    <div class="d-flex">
                                        <a href="#" class="btn btn-outline-secondary btn-block border-2x border mr-5 border-hover-secondary"><i class="fab fa-facebook-f mr-2" style="color: #2E58B2"></i>Facebook</a>
                                        <a href="#" class="btn btn-outline-secondary btn-block border-2x border mt-0 border-hover-secondary"><i class="fab fa-google mr-2" style="color: #DD4B39"></i>Google</a>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <svg aria-hidden="true" style="position: absolute; width: 0; height: 0; overflow: hidden;" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">       
        </svg>
    </body>

    <!-- Mirrored from templates.g5plus.net/glowing/dashboard/dashboard-product-list.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 24 Feb 2023 07:49:51 GMT -->
</html>
