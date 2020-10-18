<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Форум job4j</title>
</head>
<body>
<c:if test="${not empty errorMessge}">
    <div style="color:red; font-weight: bold; margin: 30px 0px;">
            ${errorMessge}
    </div>
</c:if>
<div style="margin: 20px; text-align: right">
    <a id="reg" href="reg">Create new user</a>
</div>
</hr>
<div style="text-align: center">
    <h3>Input login and password</h3>
</div>
<form name='login' action="<c:url value='/login'/>" method='POST'>
    <div style="padding: 50px 100px 50px 100px">
        <div class="form-group">
            <label for="login">Login</label>
            <input type="text" class="form-control" id="login" name="username" aria-describedby="loginHelp">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1" name="password">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </div>
</form>
</body>
</html>