<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form"%>

<%--
  Created by IntelliJ IDEA.
  User: Test
  Date: 04/29/2023
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <title>Sandwich Condiments</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h4>Sandwich Condiments</h4>
<div class="form-check">
  <form action="sandwich-condiments" method="post">
  <label class="form-check-label p-4">
    <input type="checkbox" class="form-check-input" name="condiments" value="Lettuce" >
    Lettuce
  </label>
  <label class="form-check-label p-4">
    <input type="checkbox" class="form-check-input" name="condiments" value="Tomato" >
    Tomato
  </label>
  <label class="form-check-label p-4">
    <input type="checkbox" class="form-check-input" name="condiments" value="Mustard" >
    Mustard
  </label>
  <label class="form-check-label p-4">
    <input type="checkbox" class="form-check-input" name="condiments" value="Sprouts" >
    Sprouts
  </label>
    <button type="submit" class="btn btn-primary">Saves</button>
  </form>
</div>
<h4>Condiments Picked</h4>
<c:forEach var="condiment" items="${condiments}">
  <p style="color: darkblue; font-size: larger; font-weight: bolder">_______${condiment}_______</p></c:forEach>
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
