<%-- 
    Document   : product
    Created on : Nov 27, 2021, 7:36:24 PM
    Author     : Loki Kun
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading">Product List</div>
                <div class="panel-body">
                    <table class="table table-hover hover-bordered">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th></th>
                                
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="prd" items="${ProductList}">
                                <tr>
                                    <td>${prd.productId}</td>
                                    <td>${prd.productName}</td>
                                    <td>${prd.price}</td>
                                    <td>${prd.quantity}</td>
                                    <td><a href="actions?id=${prd.productId}"><button class="btn btn-warning">Edit</button></a>
                                    <a href="?id_delete=${prd.productId}"><button class="btn btn-danger">Delete</button></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>                 
        </div>
    </body>
</html>
