<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! All Emp</h1>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Salary</th>
                    <th>Designation</th>
                    <th>Action</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="emp" items="${empList}">
                    <tr>
                        <td>${emp.id}</td> 
                        <td>${emp.name}</td> 
                        <td>${emp.gender}</td> 
                        <td>${emp.salary}</td> 
                        <td>${emp.designation}</td> 
                        <td><a href="/empeditform/${emp.id}">Edit</a> 
                            <a href="/deleteemp/${emp.id}">Delete</a></td> 
                    </tr>                  

                </c:forEach>


            </tbody>

        </table>
    </body>
</html>
