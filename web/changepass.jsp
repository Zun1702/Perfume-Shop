<%-- 
    Document   : changepass
    Created on : Feb 12, 2023, 11:04:09 PM
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

            #password-error{
                color: red;
                font-family: serif
            }

            #newpassword-error{
                color: red;
                font-family: serif
            }

            #renewpassword-error{
                color: red;
                font-family: serif
            }

            .back{
                width: 90px;
                height: 30px;
                background-color: white;
                text-align: center;
                border-radius: 5px;
                display: flex;
            }

            .back i{
                margin-top: 7px;
                margin-left: 5px
            }
            .back a{
                text-decoration: none;
                margin-left: 5px;
                margin-top: 2px
            }
            .back:hover {
                background: #45a049;
            }

            .body_right-login label{
                color: #04AA6D;
            }
        </style>
    </head>
    <!-- body -->
    <body id="body">
        <div class="body_container">
            <div class="back">
                <i class="fa fa-angle-double-left"></i>
                <a href="changeProfile"><h4>Quay về</h4></a>
            </div>
            <div class="body_right" style="margin-left: 270px">

                <form action="changepassword" method="post" id="form_register" novalidate="novalidate">

                    <div>
                        <input type="password" placeholder="Mật Khẩu Hiện Tại" class="body_right-inputlogin" name="password" id="password">
                        <input type="password" placeholder="Mật Khẩu Mới" class="body_right-inputlogin" name="newpassword" id="newpassword">
                        <input type="password" placeholder="Xác Nhận Mật Khẩu" class="body_right-inputlogin" name="renewpassword" id="renewpassword">
                        <div class="body_right-login" id="login">
                            <button class="body_right-btnlogin" type="submit">Lưu thay đổi</button> <br>
                            <label>${requestScope.updatepass}</label>
                        </div>
                    </div>
                </form>
            </div>

            <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>


            <script>
                $(function () {
                    $("#form_register").validate({
                        rules: {

                            "password": {
                                required: true,
                                minlength: 6,
                                maxlength: 20
                            },
                            "newpassword": {
                                required: true,
                                minlength: 6,
                                maxlength: 20
                            },
                            "renewpassword": {
                                required: true,
                                minlength: 6,
                                maxlength: 20,
                                equalTo: newpassword
                            },
                        },
                        messages: {

                            "password": {
                                required: "Vui lòng điền mật khẩu hiện tại",
                                minlength: "Vui lòng nhập ít nhất {0} ký tự",
                                maxlength: "Vui lòng nhập tối đa {0} ký tự"
                            },
                            "newpassword": {
                                required: "Vui lòng điền mật khẩu mới",
                                minlength: "Vui lòng nhập ít nhất {0} ký tự",
                                maxlength: "Vui lòng nhập tối đa {0} ký tự"
                            },
                            "renewpassword": {
                                required: "Vui lòng điền xác nhận mật khẩu",
                                minlength: "Vui lòng nhập ít nhất {0} ký tự",
                                maxlength: "Vui lòng nhập tối đa {0} ký tự",
                                equalTo: "Mật khẩu xác nhận phải trùng khớp với mật khẩu mới"
                            }
                        }

                    });
                });

            </script>
        </div>
    </body>   
</html>    