<%-- 
    Document   : register
    Created on : Feb 1, 2023, 12:03:54 AM
    Author     : Phuong-Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./assets/css/header_footer.css">
        <!-- <link rel="stylesheet" href="./assets/css/profile_info.css"> -->
        <link rel="stylesheet" href="./assets/css/login.css">
        <script type="text/javascript" language="javascript" src="./main.js"></script>
        <link rel="stylesheet" href="./assets/font/fontawesome-free-6.1.1/css/all.min.css">
        <link rel="icon" href="./assets/img/small_logo1.png">
        <title>PERFUME STORE</title>
        <style>
            #email-error{
                color: red;
                font-family: serif
            }
            #username-error{
                color: red;
                font-family: serif
            }
            #password-error{
                color: red;
                font-family: serif
            }
            #repassword-error{
                color: red;
                font-family: serif
            }
        </style>
    </head>
    <!-- body -->
    <body id="body">
        <div class="body_container">
            <div class="body_left">
                <a href="home" class="body_left-linkhome">
                    <img src="./assets/img/small_logo1.png" alt="">
                    <img src="./assets/img/Logo.png" alt="Ảnh Logo" class="body_left-imgLogo">
                </a>
            </div>
            <div class="body_right">
                <% if(request.getAttribute("name") == null){ %>
                <form action="register" method="post" id="form_register" novalidate="novalidate">

                    <div>
                        <input type="text" placeholder="Email" class="body_right-inputlogin" name="email" id="email">

                        <input type="text" placeholder="Tên đăng nhập" class="body_right-inputlogin" name="username" id="username">

                        <input type="password" placeholder="Mật Khẩu" class="body_right-inputlogin" name="password" id="password">
                        <input type="password" placeholder="Nhập Lại Mật Khẩu" class="body_right-inputlogin" name="repassword" id="repassword">
                        <div class="body_right-login" id="login">
                            <button class="body_right-btnlogin" type="submit">Đăng ký</button> <br>

                        </div>
                    </div>
                </form>

                <%  }
                else{ %>
                <form action="register" method="post" id="form_register" novalidate="novalidate">
                    <div>
                        <input type="text" placeholder="Email" class="body_right-inputlogin" name="email" id="email" value="${requestScope.emaill}">
                        <input type="text"  name="email1" id="email1" value="" style="display: none">

                        <input type="text" placeholder="Tên đăng nhập" class="body_right-inputlogin" name="username" id="username" value="${requestScope.name}">

                        <input type="password" placeholder="Mật Khẩu" class="body_right-inputlogin" name="password" id="password">
                        <input type="password" placeholder="Nhập Lại Mật Khẩu" class="body_right-inputlogin" name="repassword" id="repassword">
                        <div class="body_right-login" id="login">
                            <button class="body_right-btnlogin" type="submit">Đăng ký</button> <br>
                        </div>
                        <p style="color: red; font-family: serif">${requestScope.ms1}<p>
                        <p style="color: red; font-family: serif">${requestScope.ms}<p>
                    </div>
                </form>


                <%  }
                %>



            </div>

            <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>


            <script>
                $(function () {
                    $("#form_register").validate({
                        rules: {
                            "username": {
                                required: true,
                                minlength: 6

                            },
                            "password": {
                                required: true,
                                minlength: 6,
                                maxlength: 20
                            },
                            "repassword": {
                                required: true,
                                minlength: 6,
                                maxlength: 20,
                                equalTo: password
                            },

                            "email": {
                                required: true,
                                maxlength: 200,
                                email: true

                            }

                        },
                        messages: {
                            "username": {
                                required: "Vui lòng điền tên đăng nhập",
                                minlength: "Vui lòng nhập ít nhất {0} ký tự"

                            },
                            "password": {
                                required: "Vui lòng điền mật khẩu",
                                minlength: "Vui lòng nhập ít nhất {0} ký tự",
                                maxlength: "Vui lòng nhập tối đa {0} ký tự"
                            },
                            "repassword": {
                                required: "Vui lòng điền xác nhận mật khẩu",
                                minlength: "Vui lòng nhập ít nhất {0} ký tự",
                                maxlength: "Vui lòng nhập tối đa {0} ký tự",
                                equalTo: "Mật khẩu xác nhận phải trùng khớp với mật khẩu"
                            },
                            "email": {
                                required: "Vui lòng điền email",
                                maxlength: "Vui lòng nhập tối đa {0} ký tự",
                                email: "Vui lòng điền email hợp lệ, ví dụ: example@mailinator.com",
                                equalTo: "Email đã được sử dụng"
                            }

                        }

                    });
                });

            </script>
        </div>
    </body>   
</html>    