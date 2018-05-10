<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h2>Welcome to Board Chat, stranger!</h2>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <c:url value="/admin/all_users" var="adminPage" />
    <form action="${adminPage}">
        <button type="submit" class="btn btn-danger">ADMINKA</button>
    </form>
</sec:authorize>

<h4>Select your path:</h4>
    <c:forEach items="${boards}" var="board">
        <div class="jumbotron">
        <div class="box" style="text-align: center">
            <c:url value="/${board.link}" var="toBoard" />
            <a href="${toBoard}" style="color: #122b40">${board.name} </a>
        </div>
        </div>
        <br>
    </c:forEach>