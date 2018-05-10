<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="jumbotron">
    <h2 style="color: #2b542c">${user.username}</h2>
    <p>${user.email}</p>
</div>
<div class="jumbotron">
    <c:forEach items="${user.themes}" var="theme">
        <h1>${theme.name}</h1>
        <h4>${theme.createdAt}</h4>
        <br>
    </c:forEach>
</div>