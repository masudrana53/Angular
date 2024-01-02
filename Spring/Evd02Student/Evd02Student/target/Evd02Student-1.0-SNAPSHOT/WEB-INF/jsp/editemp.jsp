<%-- 
    Document   : editemp
    Created on : 31 Dec 2023, 12:33:42
    Author     : user
--%>

<%@taglib prefix="f"  uri="http://www.springframework.org/tags/form"%>
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
    <h1 class="text-center">Employee Edit Form</h1>
    <div class="container">
        <f:form method="post" action="/edit" modelAttribute="employee">
            <f:hidden path="id"></f:hidden>
            
                <div class="form-group  mb-3">
                    <label>Full Name</label>
                <f:input path="ename" cssClass="form-control"></f:input>
                </div> 

                <div class="form-group  mb-3">
                    <label class="form-check-label">Gender</label><br>
                <%--<f:input path="ename" cssClass="form-control"></f:input>--%>
                <f:radiobutton path="gender" value="Male" label="Male" ></f:radiobutton>
                <f:radiobutton path="gender" value="Female" label="Female" ></f:radiobutton>
                </div>       

                <!--            <div class="form-group  mb-3">
                                    <label>Date of Birth</label>
            <%--<f:input path="dob" cssClass="form-control" type="Date"></f:input>--%>
            </div>       -->

            <div class="form-group  mb-3">
                <label>Department</label>
                <%--<f:input path="department" cssClass="form-control"></f:input>--%>
                <f:select path="department" cssClass="form-control">
                    <f:option value="select one">Select One</f:option>
                    <f:option value="Mk">Marketing</f:option>
                    <f:option value="Sl">Sales</f:option>
                    <f:option value="HR">HR</f:option>
                </f:select>
            </div>  

            <div class="form-group  mb-3">
                <label>Salary</label>
                <f:input path="salary" cssClass="form-control"></f:input>
                </div>

                <div class="form-group  mb-3">
                    <input  type="submit" value="Update" class="btn btn-success"/>
                </div>

        </f:form>
    </div>
</div>

<%@include file="footer.jsp" %>
