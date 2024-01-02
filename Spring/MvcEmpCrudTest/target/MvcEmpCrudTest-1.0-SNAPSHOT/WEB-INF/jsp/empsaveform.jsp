<%@taglib prefix="f"  uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">   


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

        <h1>Employee Form</h1>

        <f:form method="post" action="/empsave" modelAttribute="employee">

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
                            <f:option value="">>>>Select One<<<</f:option>
                            <f:option value="JEE">JEE</f:option>
                            <f:option value="WDPF">Wdpf</f:option>
                            <f:option value="NT">NT</f:option>
                            <f:option value="GAVE">GAVE</f:option>
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
                    <td colspan="2"><input type="submit" value="Save"></td>
                </tr>
            </table>                    
        </f:form>

    </body>
</html>
