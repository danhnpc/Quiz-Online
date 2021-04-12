<%-- 
    Document   : createQuestion
    Created on : Mar 11, 2021, 10:42:13 PM
    Author     : visug
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
        <h1>Create a new question</h1>
        <form action="createQuestion">
            <c:set var="error" value="${requestScope.QUESTIONERROR}" />
            ID : <input type="text" name="txtQuestionID" value="${param.txtQuestionID}" /><br/>
            <c:if test="${not empty error.idLengthErr}">
                <font color="red">${error.idLengthErr}</font><br/>
            </c:if>
            <c:if test="${not empty error.idNumberErr}">
                <font color="red">${error.idNumberErr}</font><br/>
            </c:if>
            Question : <input type="text" name="txtQuestion" value="${param.txtQuestion}" /><br/>
            <c:if test="${not empty error.nameLengthErr}">
                <font color="red">${error.nameLengthErr}</font><br/>
            </c:if>
            Answer A: <input type="text" name="txtAnswerA" value="${param.txtAnswerA}" /><br/>
            <c:if test="${not empty error.answerALengthErr}">
                <font color="red">${error.answerALengthErr}</font><br/>
            </c:if>
            Answer B: <input type="text" name="txtAnswerB" value="${param.txtAnswerB}" /><br/>
            <c:if test="${not empty error.answerBLengthErr}">
                <font color="red">${error.answerBLengthErr}</font><br/>
            </c:if>
            Answer C: <input type="text" name="txtAnswerC" value="${param.txtAnswerC}" /><br/>
            <c:if test="${not empty error.answerCLengthErr}">
                <font color="red">${error.answerCLengthErr}</font><br/>
            </c:if>
            Answer D: <input type="text" name="txtAnswerD" value="${param.txtAnswerD}" /><br/>
            <c:if test="${not empty error.answerDLengthErr}">
                <font color="red">${error.answerDLengthErr}</font><br/>
            </c:if>
            Answer correct : <input type="text" name="txtAnswerCorrect" value="${param.txtAnswerCorrect}" /><br/>
            <c:if test="${not empty error.answerCorrectLengthErr}">
                <font color="red">${error.answerCorrectLengthErr}</font><br/>
            </c:if>
            Subject: <select name="txtSubject">
                <c:forEach var="subject" items="${sessionScope.SUBJECT}" >
                    <option value="${subject.subjectID}" 
                            <c:if test="${(param.txtSubject) == (subject.subjectID)}" >selected=""</c:if>
                            >${subject.subjectName}</option>
                </c:forEach>
            </select>
            <a href="createSubject.jsp">Add new subject</a><br/>
            <input class="btn btn-outline-danger" type="submit" value="Create question" name="btAction" />
            <input class="btn btn-outline-danger" type="reset" value="Reset" />
        </form>
        <c:if test="${not empty error.idDuplicateErr}">
            <font color="red">${error.idDuplicateErr}</font><br/>
        </c:if>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
    </body>
</html>
