<%--
  Created by IntelliJ IDEA.
  User: Test
  Date: 04/27/2023
  Time: 9:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en" >
<head>
    <title>Soccer Player</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h3 class="text-area color-palette">${msg}</h3>
<table class="table">
    <thead>
    <tr>
<%--        String code, String name, String dateOfBirth, String experience,--%>
<%--        String position, String urlImg--%>
        <th>Code</th>
        <th>Name</th>
        <th>Date Of Birth</th>
        <th>Experience</th>
        <th>Position</th>
        <th>Avatar</th>
        <th>Options</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="list">
    <tr>
        <td scope="row">${list.code}</td>
        <td>${list.name}</td>
        <td>${list.dateOfBirth}</td>
        <td>${list.experience}</td>
        <td>${list.position}</td>
        <td><img src=" ${list.urlImg}" width="120px" alt=""></td>
    </tr>
   </c:forEach>
    </tbody>
</table>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>