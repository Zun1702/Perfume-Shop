<%-- 
    Document   : reset
    Created on : Feb 5, 2023, 9:46:46 AM
    Author     : canduykhanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            body {
                font-family: Arial, Helvetica, sans-serif;
            }
            * {
                box-sizing: border-box;
            }

            input[type=password], select, textarea {
                width: 400px;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
                margin-top: 6px;
                margin-bottom: 16px;
                resize: vertical;
            }

            input[type=submit] {
                background-color: #04AA6D;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            input[type=submit]:hover {
                background-color: #45a049;
            }

            .container {
                width: 520px;
                height: auto;
                border-radius: 5px;
                background-color: #f3f3f3;
                padding: 20px 60px;
                margin-left: 480px;
                margin-top: 60px;
            }

            #fname-error{
                color: red;
                font-family: serif;
            }
            #lname-error{
                color: red;
                font-family: serif;
            }

            label{
                margin-left: 5px;
                color: #999;
            }

            h2{
                margin-left: 100px;
                color: #28a745;
            }
        </style>
    </head>
    <body>


        <c:set var="f" value="${requestScope.resetFail}"></c:set>
            <div>
                <h2 style="color:red;">${f}</h2>
        </div>

        <div class="container">
            <h2>Reset Password</h2>
            <form action="reset" method="post" id="form_reset">
                <label for="newpass">New password</label> <br>
                <input type="password" id="fname" name="newpass" placeholder="" class="body_right-inputlogin"> <br><br>

                <label for="confpass">Confirm password</label> <br>
                <input type="password" id="lname" name="confpass" placeholder=""><br><br>
                <input type="submit" value="Reset">
            </form>
        </div>

        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>


        <script>
            $(function () {
                $("#form_reset").validate({
                    rules: {

                        "newpass": {
                            required: true,
                            minlength: 6,
                            maxlength: 20
                        },
                        "confpass": {
                            required: true,
                            minlength: 6,
                            maxlength: 20,
                            equalTo: fname
                        }
                    },
                    messages: {

                        "newpass": {
                            required: "Vui lòng điền mật khẩu",
                            minlength: "Vui lòng nhập ít nhất {0} ký tự",
                            maxlength: "Vui lòng nhập tối đa {0} ký tự"
                        },
                        "confpass": {
                            required: "Vui lòng điền xác nhận mật khẩu",
                            minlength: "Vui lòng nhập ít nhất {0} ký tự",
                            maxlength: "Vui lòng nhập tối đa {0} ký tự",
                            equalTo: "Mật khẩu xác nhận phải trùng khớp với mật khẩu"
                        }
                    }

                });
            });

        </script>
    </body>
</html>