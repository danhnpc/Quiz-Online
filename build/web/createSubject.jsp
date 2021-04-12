<%-- 
    Document   : createSubject
    Created on : Mar 11, 2021, 11:22:22 PM
    Author     : visug
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Subject</title>
    </head>
    <body>
        <h1>New Subject</h1>
        <form action="createSubject">
            <c:set var="error" value="${requestScope.SUBJECTERROR}" />
        Subject ID : <input type="text" name="txtSubjectID" value="" /><br/>
        <c:if test="${not empty error.idLengthErr}" >
            <font color="red">${error.idLengthErr}</font><br/>
        </c:if>
        Subject name: <input type="text" name="txtSubjectName" value="" /><br/>
        <c:if test="${not empty error.nameLengthErr}" >
            <font color="red">${error.nameLengthErr}</font><br/>
        </c:if>
        <input type="submit" value="Add new subject" name="btAction" />
        </form>
            <c:if test="${not empty error.idDuplicateErr}" >
            <font color="red">${error.idDuplicateErr}</font>
        </c:if>
    </body>
</html>
