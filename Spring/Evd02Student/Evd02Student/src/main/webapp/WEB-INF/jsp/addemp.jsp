<%-- 
    Document   : addemp
    Created on : 31 Dec 2023, 12:32:01
    Author     : user
--%>

<%@taglib prefix="f"  uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<div class="mx-4 py-3">
    <h1 class="text-center">Employee Entry Form</h1>

    <div class="container py-3">

        <f:form method="post" action="/save" modelAttribute="employee">
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
                    <f:option value="JEE">JEE</f:option>
                    <f:option value="PHP">PHP</f:option>
                    <f:option value="GAVE">GAVE</f:option>
                    <f:option value="NT">NT</f:option>
                </f:select>
            </div>  

            <div class="form-group  mb-3">
                <label>Salary</label>
                <f:input path="salary" cssClass="form-control"></f:input>
                </div>

                <div class="form-group  mb-3">
                    <input  type="submit" value="Submit" class="btn btn-success"/>
                </div>

        </f:form>
    </div>

</div>
<%@include file="footer.jsp" %>
