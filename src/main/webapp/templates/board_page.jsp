<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<div class="content">
    <c:forEach items="${themes}" var="theme">
        <div class="box" style="text-align: center">
            <c:url value="/${board.link}/theme/${theme.id}" var="toTheme" />
            <a href="${toTheme}" style="color: #122b40">${theme.name} </a>
        </div>
        <br>
    </c:forEach>
</div>