<%-- 
    Document   : action
    Created on : Nov 28, 2021, 8:36:32 AM
    Author     : Loki Kun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
        <div class="panel panel-primary">
                    <div class="panel-heading">Add New Product</div>
                    <div class="panel-body">
                        <form method="post">
                            <input type="text" value="${std.productId}" style="display: none;"/>
                            <div class="form-group">
                                <label for="name">Name</label>
                                <input type ="text" name="name" class="form-control" value="${std.productName}" placeholder=" Enter Name" required/>
                            </div>
                            <div class="form-group">
                                <label for="name">Price</label>
                                <input type ="text" name="price" class="form-control" value="${std.price}" placeholder=" Enter price" required/>
                            </div>
                            <div class="form-group">
                                <label for="name">Quantity</label>
                                <input type ="text" name="quantity" class="form-control" value="${std.quantity}" placeholder=" Enter quantity" required/>
                            </div>
                            <button class="btn btn-success">Add Product</button>
                        </form>
                    </div>
                </div>
        </div>
    </body>
</html>
