<%-- 
    Document   : emplist
    Created on : 31 Dec 2023, 12:29:50
    Author     : user
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!--<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>-->
<div class="mx-4 py-3">
        <h1 class="text-center">Employee List</h1>
        <a href="/saveform" class="mb-3 btn btn-success">Employee Entry</a>
        <div class="col-12 container">
            <table class="table table-striped text-center">
                <thead>
                <tr>
<!--                    <th>Serial</th>-->
                    <th>Id</th>
                    <th>Name</th>                    
                    <th>Department</th>
                    <th>Salary</th>
                    <th>Gender</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="emp" items="${empList}" varStatus="loop">
                <tr>
<!--                    <td>${loop.count}</td>-->
                    <td>${emp.id}</td>
                    
                    <td>${emp.ename}</td>
                    
                    <td>${emp.department}</td>
                    <td>${emp.salary}</td>
                    <td>${emp.gender}</td>
                    <td>
                        <a href="/delete/${emp.id}" class="btn btn-danger">Delete</a>
                        <a href="/editemp/${emp.id}" class="btn btn-warning">Update</a>
                    </td>
                     
                </tr>
                </c:forEach>
            </tbody>
            </table>
        </div>
        
        </div>
        <%@include file="footer.jsp" %>
