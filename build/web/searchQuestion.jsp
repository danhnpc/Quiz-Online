<%-- 
    Document   : searchQuestion
    Created on : Mar 10, 2021, 11:08:06 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#keywords').dataTable({
                    "ordering": false,
                    "searching": false,
                    "aLengthMenu": [[5], [5]], // danh sách số trang trên 1 lần hiển thị bảng
                });

            });
        </script>  
        <title>Search Question Page</title>
    </head>
    <body>
        Welcome <font color="red">${sessionScope.FULLNAME}</font>
        
        <a href="logOut">Log out</a>
        <h1 style="font-weight: bolder">Search question</h1>
        <form action="searchQuestion">
            Search question <input type="text" name="txtSearchQuestion" value="${param.txtSearchQuestion}" />
            <select name="txtStatus">
                <option value="true">Active</option>
                <option value="false">Inactive</option>
            </select>
            <select name="txtSubject">
                <option value="0">All</option>
                <c:forEach var="subject" items="${sessionScope.SUBJECT}" >
                    <option value="${subject.subjectID}" 
                            <c:if test="${(param.txtSubject) == (subject.subjectID)}" >selected=""</c:if>
                            >${subject.subjectName}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Search" name="btAction" />
            <a href="createQuestion.jsp">Create a new question</a>
        </form>
        <c:set var="result" value="${requestScope.SEARCHQUESTION}" />
        <c:if test="${not empty result}" >
            <table border="1" id="keywords" class="table">
                <thead>
                    <tr class="table-danger">
                        <th>No.</th>
                        <th>Question</th>
                        <th>Answer Content</th>
                        <th>Answer Correct</th>
                        <th>Create date</th>
                        <th>Subject</th>
                        <th>Status</th>
                        <th>Delete</th>
                        <th>Update</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${result}" varStatus="counter">
                        <tr class="table-light">
                            <td>${counter.count}.</td>

                            <td>${dto.question}</td>

                            <td>
                                <c:forEach var="ac" items="${requestScope.ANSWERCONTENTSEARCH}" >
                                    <c:if test="${(dto.answerContentID) == (ac.answerContentID)}" >
                                        A. ${ac.a}<br/>
                                        <input type="hidden" name="txtA" value="${ac.a}" />
                                        B. ${ac.b}<br/>
                                        <input type="hidden" name="txtB" value="${ac.b}" />
                                        C. ${ac.c}<br/>
                                        <input type="hidden" name="txtC" value="${ac.c}" />
                                        D. ${ac.d}
                                        <input type="hidden" name="txtD" value="${ac.d}" />
                                    </c:if>
                                </c:forEach>

                            </td>

                            <td>${dto.answerCorrect}</td>

                            <td>${dto.createDate}</td>

                            <td>${dto.subject}</td>

                            <td>${dto.status}</td>
                            <c:url var="Delete" value="deleteQuestion" >
                                <c:param name="btAction" value="Delete" />
                                <c:param name="pk" value="${dto.id}" />
                                <c:param name="txtSearchValue" value="${param.txtSearchQuestion}"/>
                                <c:param name="txtStatus" value="${param.txtStatus}" />
                                <c:param name="txtSubject" value="${param.txtSubject}" />
                            </c:url>
                            <td>
                                <c:if test="${(param.txtStatus) != false}" >
                                    <a href="${Delete}">Delete</a>
                                </c:if>
                            </td>
                            <c:url var="Update" value="updateQuestion">
                                <c:param name="btAction" value="Update" />
                                <c:param name="id" value="${dto.id}" />
                            </c:url>
                            <td>
                                <a href="${Update}">Update</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </c:if>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
    </body>
</html>
