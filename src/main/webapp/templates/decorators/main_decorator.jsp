<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.05.2018
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="author" content="Roman Bagautdinov">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/./resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/./resources/css/bootstrap.css">

    <title>BoardChat</title>
</head>
<body>
    <header>
        <div class="navbar navbar-dark bg-dark box-shadow">
            <div class="container d-flex justify-content-between">
                <C:url value="/" var="mainPage" />
                <a href="${mainPage}" class="navbar-brand d-flex align-items-center">
                    <strong class="logo">BoardChat</strong>
                </a>
            </div>
        </div>
    </header>

    <!-- Content placed here -->
    <div class="container">
        <div class="wrapper">
            <!-- Content goes here -->
            <decorator:body/>
        </div>
    </div>

    <footer class="footer">
        <div class="container">
            <span class="text-muted">&copy; 2018 ロマン・バガットディノフ</span>
        </div>
    </footer>

    <!-- Optional JavaScript -->
    <script
            src="https://code.jquery.com/jquery-3.2.1.min.js"
            integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
            crossorigin="anonymous">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</body>
</html>
