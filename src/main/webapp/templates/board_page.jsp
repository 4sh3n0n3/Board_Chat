<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<div class="jumbotron">
    <c:forEach items="${themes}" var="theme">
        <div class="box" style="text-align: center">
            <c:url value="/${board.link}/theme/${theme.id}" var="toTheme" />
            <a href="${toTheme}" style="color: #122b40">${theme.name} </a>
        </div>
        <br>
    </c:forEach>
</div>

<div class="jumbotron">
    <c:url value="/${board.link}/create_theme" var="addTheme" />
    <sf:form action="${addTheme}" method="post" modelAttribute="theme_form">
        <sf:errors/>
        <spring:bind path="name">
            <label for="newThemeName">Theme Name: </label>
            <sf:input id="newThemeName" type="text" path="name" cssClass="form-control" />
        </spring:bind>
        <spring:bind path="content">
            <label for="newThemeContent">Content: </label>
            <sf:input id="newThemeContent" path="content" type="text" cssClass="text-field" />
        </spring:bind>

        <button type="submit" class="btn">Create Theme</button>
    </sf:form>
</div>