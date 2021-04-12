<%-- 
    Document   : createAccount
    Created on : Mar 10, 2021, 9:36:11 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <title>Create Page</title>
    </head>
    <body>
        <h1>Create a new account</h1>
        <form action="createAccount">
            <c:set var="error" value="${requestScope.CREATEERROR}" />
            User ID : <input type="text" name="txtUserID" value="${param.txtUserID}" /><br/>
            <c:if test="${not empty error.userIdLengthErr}" >
                <font color="red"> ${error.userIdLengthErr}</font><br/>
            </c:if>
            Password : <input type="password" name="txtPassword" value="${param.txtPassword}" /><br/>
            <c:if test="${not empty error.passwordLengthErr}" >
                <font color="red"> ${error.passwordLengthErr}</font><br/>
            </c:if>
            Password confirm : <input type="password" name="txtConfirm" value="${param.txtConfirm}" /><br/>
            <c:if test="${not empty error.confirmPasswordErr}" >
                <font color="red"> ${error.confirmPasswordErr}</font><br/>
            </c:if>
            Full name : <input type="text" name="txtFullName" value="${param.txtFullName}" /><br/>
            <c:if test="${not empty error.fullNameLengthErr}" >
                <font color="red"> ${error.fullNameLengthErr}</font><br/>
            </c:if>
            <input class="btn btn-danger" type="submit" value="Create" name="btAction" />
            <input class="btn btn-outline-danger" type="reset" value="Reset" />
        </form>
        <c:if test="${not empty error.duplicateUserIdErr}" >
            <font color="red"> ${error.duplicateUserIdErr}</font><br/>
        </c:if>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
    </body>
</html>
