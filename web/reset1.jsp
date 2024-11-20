<%-- 
    Document   : reset
    Created on : Feb 4, 2023, 3:17:44 PM
    Author     : canduykhanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Reset password</title>

    </head>

    <body>
        <div class="log-form">
            <h2>Reset password</h2>
            <c:set var="f" value="${requestScope.resetFail}"></c:set>
            <div>
                <h2 style="color:red;">${f}</h2>
            </div>
            <form action="reset" method="post">
                <table border="0">

                    <tbody>
                        <tr>
                             <td>New password</td>

                             <td><input name="newpass" type="password" placeholder="New password" />
                            </td>
                        </tr>
                        <tr>
                             <td>Confirm new password</td>
                             <td><input name="confpass" type="password" placeholder="Confirm new password" /></td>
                            
                        </tr>
                        <tr><td><button type="submit" class="btn">Reset</button></td></tr>
                    </tbody>
                </table>
            </form>
        </div><!--end log form -->
    </body>

</html>
