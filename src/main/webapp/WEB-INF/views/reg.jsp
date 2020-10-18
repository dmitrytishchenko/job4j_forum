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
    <script>
        function validate() {
            if ($('#password1').val() != $('#password2').val()) {
                alert('Invalid password');
            }
        }
    </script>
    <title>Форум job4j</title>
</head>
<body>
<form action="/reg" method='POST'>
    <div style="margin: 50px">
        <div class="form-group">
            <label for="login">Login: </label>
            <input type="text" class="form-control" id="login" name="name" aria-describedby="loginHelp">
        </div>
        <div class="form-group">
            <label for="password1">Password: </label>
            <input type="password" class="form-control" id="password1" name="password1">
        </div>
        <div class="form-group">
            <label for="password2">Enter password again: </label>
            <input type="password" class="form-control" id="password2" name="password2">
        </div>
        <div class="form-group">
            <label for="role">Role: </label>
            <input type="text" class="form-control" id="role" name="role" placeholder="User or Admin">
        </div>
        <button style="margin: 20px" type="submit" class="btn btn-primary" onclick="return validate()">Submit</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </div>

</form>
</body>
</html>