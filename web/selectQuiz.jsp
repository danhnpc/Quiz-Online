<%-- 
    Document   : selectQuiz
    Created on : Feb 19, 2021, 4:47:37 PM
    Author     : visug
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <title>Quiz Page</title>
    </head>
    <body>
        Welcome, <font color="red">${sessionScope.FULLNAME}</font>
        
        <a href="logOut">Log out</a>
        <h1 style="font-weight: bolder; text-align: center; color: black">Quiz Online</h1>
        <c:set var="subject" value="${sessionScope.SUBJECT}" />
        <div style="height: 100px;">
            <form action="takeQuiz" style="text-align: center">
                <label style="font-size: 1.2em">Select a subject</label>
                <select name="txtSubject" style="font-size: 1.2em;">
                    <c:forEach var="dto" items="${subject}" >
                        <option value="${dto.subjectID}">${dto.subjectName}</option>
                    </c:forEach>
                </select><br/>
                <c:set var="error" value="${requestScope.TAKEQUIZERROR}" />
                <c:if test="${not empty error}" >
                    <h1 class="btn btn-danger" style="font-weight: bolder; font-size: 20px">${error}</h1> <br/>
                </c:if>
                <input class="btn btn-outline-danger" type="submit" value="Take a quiz" style="width:50%; font-size: 1.7em; "/>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
    </body>
</html>
