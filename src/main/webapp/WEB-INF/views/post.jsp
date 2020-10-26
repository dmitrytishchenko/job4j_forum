<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Форум job4j</title>
</head>
<body>
<div class="container mt-3">
    <div class="row">
        <h4>Название темы: <c:out value="${post.name}"/></h4>
    </div>
    <div class="row">
        <table class="table table-striped">
            <thead class="thead-dark">
            <tr>
                <th scope="col">№</th>
                <th scope="col">Тема</th>
                <th scope="col">Обсуждение</th>
                <th scope="col">Дата создания</th>
                <th scope="col">Редактирование</th>
                <th scope="col">Удалить пост</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row"><c:out value="${post.id}"/></th>
                <td><c:out value="${post.name}"/></td>
                <td><c:out value="${post.desc}"/></td>
                <td><c:out value="${post.created.getTime()}"/></td>
                <td><a href="/edit/${post.id}">Редактирование поста</a></td>
                <td><a href="/delete/${post.id}">Удалить пост</a></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>