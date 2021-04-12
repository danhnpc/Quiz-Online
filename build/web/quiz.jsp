<%-- 
    Document   : quiz
    Created on : Feb 13, 2021, 3:18:37 PM
    Author     : visug
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/quiz.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/ff02cdde28.js" crossorigin="anonymous"></script>

        <title>Quiz Page</title>
    </head>
    <body>


        Welcome, <font color="red">${sessionScope.FULLNAME}</font>
        <h1>Quiz progress</h1>

        <c:set var="time" value="${sessionScope.TIME}" />
        <script>
            (function () {
                const second = 1000,
                        minute = second * 60,
                        hour = minute * 60,
                        day = hour * 24;
                let end = "${time}",
                        countDown = new Date(end).getTime();
                setInterval(function () {
                    let now = new Date().getTime(),
                            distance = countDown - now;

                    document.getElementById("minutes").innerText = Math.floor(distance / (minute)),
                            document.getElementById("seconds").innerText = Math.floor((distance % (minute)) / second);

                    if (distance < 1) {
                        var form = document.getElementById("quiz");
                        form.submit();
                        return;
                    }

                }, 0);
            }());
        </script>       

        <c:set var="question" value="${sessionScope.QUESTION}" />
        <c:set var="page" value="${sessionScope.PAGE}" />
        <c:set var="result" value="${sessionScope.ALLANSWER}" />
        <form id="quiz" action="quizProcess">
            <div id="countdown"> 
                <ul>
                    <li><span id="minutes"></span>:</li>
                    <li><span id="seconds"></span></li>
                </ul>
                <input class="btn btn-outline-warning" type="submit" value="Finish" name="btAction" style="width: 28%" /><br/>
                <h1 class="badge rounded-pill bg-light text-dark" style="font-weight: bolder; font-size: 40px">Q${page + 1}. ${question.question}</h1>

                <c:forEach var="answer" items="${sessionScope.ANSWERCONTENT}" varStatus="counter">                    

                    <c:if test="${(answer.answerContentID) == (question.answerContentID)}" >     
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="cbAnswer_${page}" value="A" <c:forEach var="dup" items="${result}" >
                                       <c:if test="${page == (dup.page)}" >
                                           <c:if test="${(dup.answerChosen) == 'A'}" >checked="checked"</c:if>
                                       </c:if>
                                   </c:forEach>/>A. ${answer.a} <br/>
                            <input class="form-check-input" type="radio" name="cbAnswer_${page}" value="B" <c:forEach var="dup" items="${result}" >
                                       <c:if test="${page == (dup.page)}" >
                                           <c:if test="${(dup.answerChosen) == 'B'}" >checked="checked"</c:if>
                                       </c:if>
                                   </c:forEach>/>B. ${answer.b} <br/>
                            <input class="form-check-input" type="radio" name="cbAnswer_${page}" value="C" <c:forEach var="dup" items="${result}" >
                                       <c:if test="${page == (dup.page)}" >
                                           <c:if test="${(dup.answerChosen) == 'C'}" >checked="checked"</c:if>
                                       </c:if>
                                   </c:forEach>/>C. ${answer.c} <br/>
                            <input class="form-check-input" type="radio" name="cbAnswer_${page}" value="D" <c:forEach var="dup" items="${result}" >
                                       <c:if test="${page == (dup.page)}" >
                                           <c:if test="${(dup.answerChosen) == 'D'}" >checked="checked"</c:if>
                                       </c:if>
                                   </c:forEach>/>D. ${answer.d} <br/>    
                        </div>
                    </c:if>

                </c:forEach> <br/>
                
                <input type="hidden" name="txtAnswerCorrect" value="${question.answerCorrect}" />


                <c:if test="${(page > 0) && (page <= 9)}" >
                    <input class="btn btn-success" type="submit" value="Previous" name="btAction" style="margin-right: 200px"/>
                </c:if>

                <c:if test="${(page >= 0) && (page < 9)}" >
                    <input class="btn btn-success" type="submit" value="Next" name="btAction"/>
                </c:if>
            </div>

        </form>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
    </body>
</html>
