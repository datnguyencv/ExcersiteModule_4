<%--
  Created by IntelliJ IDEA.
  User: Test
  Date: 04/29/2023
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Calculator</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h3>Calculator</h3>
<form action="/calculator" method="get">
    <div class="form-group">
        <label for="number-one"></label>
        <input type="number"
               class="form-control form-control-sm" name="number-one" id="number-one" aria-describedby="helpId" placeholder="Enter Number First" value="${numberOne}">
    </div>
    <div class="form-group">
        <label for="number-two"></label>
        <input type="number"
               class="form-control form-control-sm" name="number-two" id="number-two" aria-describedby="helpId" placeholder="Enter Number Second" value="${numberTwo}">
    </div>
    <button type="submit" class="btn btn-outline-primary" name="action" value="addition">Additions (+)</button>
    <button type="submit" class="btn btn-outline-primary" name="action" value="subtraction">Subtraction (-)</button>
    <button type="submit" class="btn btn-outline-primary" name="action" value="multiplication">Multiplication (*)</button>
    <button type="submit" class="btn btn-outline-primary" name="action" value="division">Division (/)</button>
    <div>
        <h2 style="font-weight: bolder; color: red" >Result ${action}: ${result}</h2>
    </div>
</form>
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
