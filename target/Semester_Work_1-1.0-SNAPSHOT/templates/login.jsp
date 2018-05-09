
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:url value="/login/process" var="logIn" />
<form action="${logIn}" method="post">
    <label for="loginUsername">Username: </label>
    <input id="loginUsername" type="text" class="form-control" placeholder="type your username" name="username">
    <label for="loginPassword">Password: </label>
    <input id="loginPassword" type="password" class="form-control" placeholder="****, hehe" name="password">
    <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
</form>