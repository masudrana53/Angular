<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    </head>


    <!--    <style>
            body {
                font-family: Arial, sans-serif;
                margin: 20px;
            }
    
            h1 {
                color: #333;
            }
    
            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }
    
            th, td {
                padding: 12px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }
    
            th {
                background-color: #f2f2f2;
            }
    
            td a {
                display: inline-block;
                margin-right: 10px;
                text-decoration: none;
                color: #3498db;
            }
    
            td a:hover {
                color: #1e87d3;
            }
    
    
            .back {
                display: inline-block;
                margin-bottom: 10px;
                margin-right: 10px;
                padding: 8px 16px;
                text-decoration: none;
                color: #fff;
                background-color: #3498db;
                border-radius: 4px;
                transition: background-color 0.3s;
            }
    
            .back:hover {
                background-color: #1e87d3;
            }
        </style>-->

    <div class="mx-4 py-3">
        <h1 class="text-center">Product List</h1>
         
        <div class="col-12 container">

            <table class="table table-striped text-center">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Brand</th>                       
                        <th>Action</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="emp" items="${empList}">
                        <tr>
                            <td>${emp.id}</td> 
                            <td>${emp.name}</td>  
                            <td>${emp.price}</td>
                            <td>${emp.quantity}</td>  
                            <td>${emp.brand}</td>                           

                            <td>
                                <a href="/empeditform/${emp.id}" class="btn btn-warning">Edit</a> 
                                <a href="/deleteemp/${emp.id}" class="btn btn-danger">Delete</a>
                            </td>

                        </tr>                  
                    </c:forEach>      
                </tbody>        
            </table>

        </div>

    </div>
    <a class="mb-3 btn btn-success" href="/prosaveform">Add Product</a>

   

</html>
