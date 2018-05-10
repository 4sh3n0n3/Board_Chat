<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<h2>Welcome, dear admin!</h2>
<c:forEach items="${userList}" var="user">
    <div class="jumbotron">
        <c:url value="/users/${user.username}" var="user_acc" />
        <a href="${user_acc}">${user.username}</a>

            <c:if test="${not empty user.banList}">
                <c:url value="/admin/ban_user/${user.username}" var="mercy" />
                <form action="${mercy}" method="post">
                    <button type="submit" class="btn btn-primary">MERCY HIM!</button>
                </form>
            </c:if>
            <c:if test="${empty user.banList}">
                <c:url value="/admin/ban_user/${user.username}" var="banhammer" />
                <form action="${banhammer}" method="post">
                    <button type="submit" class="btn btn-danger">BAN HIM!</button>
                </form>
            </c:if>
    </div>
</c:forEach>