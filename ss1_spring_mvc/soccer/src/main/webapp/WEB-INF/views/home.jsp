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
<div class="container-fluid">
<h3 class="text-center text-danger">PlaySoccer Management</h3>
<table class="table table-striped able-bordered table-hover align-content-center">
    <thead>
    <tr>
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
    <c:forEach items="${playList}" var="play">
    <tr>
        <td>${play.code}</td>
        <td>${play.name}</td>
        <td>${play.dateOfBirth}</td>
        <td>${play.experience}</td>
        <td>${play.position}</td>
        <td><img src=" ${play.urlImg}" width="120px" alt="Error Loading.."></td>
        <td><!-- Button trigger modal -->
            <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#delete">
                Delete
            </button>
            </td>
        <td><!-- Button trigger modal -->
            <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#detail">
                Details
            </button>

           </td>
    </tr>
   </c:forEach>
    </tbody>
</table>
</div>
<!-- Modal - Delete-->
<div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="modelTitleId"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Action Delete Box</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Do you want to delete this <span id="nameId" class="text-danger"></span> ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Delete</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal - Detail -->
<div class="modal fade" id="detail" tabindex="-1" role="dialog" aria-labelledby="modelTitleId"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Detail more box</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="card" style="background-color:cadetblue; border-color:darkblue;">
                    <img class="card-img-top" src="" alt="">
                    <div class="card-body">
                        <h4 class="card-title">Title</h4>
                        <p class="card-text">Text</p>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
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