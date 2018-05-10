<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container jumbotron" style="text-align: center;">
    <c:url value="/users/${theme.owner.id}" var="themeOwner" />
    <h4 style="color: #122b40">${theme.name}</h4>
    <a href="${themeOwner}">${theme.owner.username}</a>
    <p>${theme.content}</p>
    <p>${theme.createdAt}</p>
</div>

<div class="container">
    <c:forEach items="${comments}" var="comment">

        <div class="content jumbotron">
            <c:url value="/users/${comment.writer.id}" var="owner" />
            <a href="${owner}">${comment.writer.username}</a>
            <p>${comment.content}</p>
            
            <c:if test="${not empty comment.answerTo}" >
                <p>To: ${comment.answerTo}</p>
            </c:if>
            
            <p>${comment.createdAt}</p>
            <button onclick="setAnswer(${comment.id})">Answer</button>
        </div>

    </c:forEach>
</div>



<div class="container jumbotron">
    <c:url value="/${board.link}/theme/${theme.id}/add_comment/" var="regUrl" />
    <sf:form action="${regUrl}" modelAttribute="comment_form" method="post">
        <sf:errors/>
        <spring:bind path="content">
            <sf:input type="text" path="content" />
        </spring:bind>
        <spring:bind path="answerTo">
            <sf:input id="answer" path="answerTo" type="text" onkeypress="return false"/>
        </spring:bind>
        <button type="submit" class="btn">Comment</button>
    </sf:form>
</div>

<script>
 function setAnswer(comment_id) {
     document.getElementById("answer").value = comment_id;
 }
</script>