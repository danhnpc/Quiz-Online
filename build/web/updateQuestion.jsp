<%-- 
    Document   : updateQuestion
    Created on : Mar 12, 2021, 2:55:23 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
        <h1>Update Page</h1>
        <c:set var="dto" value="${requestScope.UPDATEQUESTION}" />
        <form action="confirmUpdate">
            <c:set var="error" value="${requestScope.UPDATEERROR}" />
            <input type="hidden" name="txtID" value="${dto.id}${param.txtID}" /><br/>
            Question: <input type="text" name="txtQuestion" value="${dto.question}${param.txtQuestion}" /><br/>
            <c:if test="${not empty error.nameLengthErr}" >
                <font color="red">${error.nameLengthErr}</font><br/>
            </c:if>
            <c:set var="ac" value="${requestScope.UPDATEANSWERCONTENT}"/>
            
            Answer A <input type="text" name="txtA" value="${ac.a}${param.txtA}" /><br/>
                <c:if test="${not empty error.answerALengthErr}" >
                <font color="red">${error.answerALengthErr}</font><br/>
            </c:if>
                Answer B <input type="text" name="txtB" value="${ac.b}${param.txtB}" /><br/>
                <c:if test="${not empty error.answerBLengthErr}" >
                <font color="red">${error.answerBLengthErr}</font><br/>
            </c:if>
                Answer C <input type="text" name="txtC" value="${ac.c}${param.txtC}" /><br/>
                <c:if test="${not empty error.answerCLengthErr}" >
                <font color="red">${error.answerCLengthErr}</font><br/>
            </c:if>
                Answer D <input type="text" name="txtD" value="${ac.d}${param.txtD}" /><br/>
                <c:if test="${not empty error.answerDLengthErr}" >
                <font color="red">${error.answerDLengthErr}</font><br/>
            </c:if>
            
                Answer correct: <input type="text" name="txtAnswerCorrect" value="${dto.answerCorrect}${param.txtAnswerCorrect}" /><br/>
                <c:if test="${not empty error.answerCorrectLengthErr}" >
                <font color="red">${error.answerCorrectLengthErr}</font><br/>
            </c:if>
            Subject<select name="txtSubject">
                <c:forEach var="subject" items="${sessionScope.SUBJECT}" >
                    <option value="${subject.subjectID}" 
                            <c:if test="${((dto.subject) || (param.txtSubject)) == (subject.subjectID)}">selected=""</c:if>
                            >${subject.subjectName}</option>
                </c:forEach>
            </select><br/>
            <input type="submit" value="Confirm update" name="btAction" />
        </form>
    </body>
</html>
