<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>   

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 20px;
            }

            h1 {
                color: #333;
            }

            table {
                width: 50%;
                margin-top: 20px;
            }

            td {
                padding: 10px;
                text-align: left;
            }

            input[type="text"] {
                width: 100%;
                padding: 8px;
                box-sizing: border-box;
            }

            input[type="submit"] {
                background-color: #3498db;
                color: #fff;
                padding: 10px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #1e87d3;
            }
        </style>
        
        
    </head>
    
    
    <body>
    
       <h1>Edit Field</h1>
        
         <f:form method="post" action="/editempsave"  modelAttribute="employee">
                         
             <f:hidden  path="id" />
             <table>
                
                <tr>
                    <td>Name</td>
                    <td>
                        <f:input path="name" class="form-control" />
                    </td>
                </tr>
                                
                <tr>
                    <td>Gender</td>
                    <td>
                        <f:radiobutton path="gender" value="Male" label="Male" />
                        <f:radiobutton path="gender" value="Female" label="Female" />
                    </td>
                </tr>
                
                
                <tr>
                    <td>Department</td>
                    <td>
                        <f:select path="department" class="form-control">
                            <f:option value="Java">Java</f:option>
                            <f:option value="C#">C#</f:option>
                            <f:option value="Wdpf">Wdpf</f:option>
                            <f:option value="Nt">Nt</f:option>
                        </f:select>
                    </td>
                </tr>
               

                <tr>
                    <td>Hobby</td>
                    <td>
                        <f:checkbox path="hobby" value="Fishing" /> Fishing<br/>
                        <f:checkbox path="hobby" value="Reading" /> Reading<br/>
                        <f:checkbox path="hobby" value="Gaming" /> Gaming<br/>
                        <f:checkbox path="hobby" value="Sleeping" /> Sleeping<br/>
                    </td>
                </tr>

                
                <tr>
                    <td>Date of Birth</td>
                    <td>
                        <f:input path="dob" class="form-control" type="date" />
                    </td>
                </tr>


                <tr>
                    <td colspan="2"><input type="submit" value="UPDATE"></td>
                </tr>
            </table>
        </f:form> 
        
    </body>
</html>
