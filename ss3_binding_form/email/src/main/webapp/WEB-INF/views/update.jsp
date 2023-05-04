        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Test
  Date: 05/04/2023
  Time: 5:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Setting</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<form:form action="/update-email" method="post" modelAttribute="newEmails">
    <fieldset>
        <legend>Settings</legend>
        <table class="table table-striped table-inverse table-responsive">
            <tr><form:hidden path="id" value="${email.getId()}"></form:hidden></tr>
            <tr>
                <td>Languages:</td>
                <td>
                    <form:select path="languages">
                        <form:option value="English">English</form:option>
                        <form:option value="Vietnamese">Vietnamese</form:option>
                        <form:option value="Japanese">Japanese</form:option>
                        <form:option value="Chinese">Chinese</form:option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Page size:</td>
                <td>
                    Show
                    <form:select path="pageSize">
                        <form:option value="5">5</form:option>
                        <form:option value="10">10</form:option>
                        <form:option value="15">15</form:option>
                        <form:option value="25">25</form:option>
                        <form:option value="50">50</form:option>
                        <form:option value="100">100</form:option>
                    </form:select>
                    email per page
                </td>
            </tr>
            <tr>
                <td>Spams filter</td>
                <td>
                    <form:radiobutton path="spamsFilter" value="true"></form:radiobutton> Enable spams filter
                </td>
            </tr>
            <tr>
                <td>Signature</td>
                <td>
                    <form:textarea path="signature"></form:textarea>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button type="submit" class="btn btn-outline-primary">Update</button>
                </td>
                <td>
                    <a name="" id="" class="btn btn-danger" href="/email" role="button">Cancel</a>
                </td>
            </tr>
        </table>
    </fieldset>
</form:form>
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
