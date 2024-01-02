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

        <h1>Product Information</h1>

        <f:form method="post" action="/empsave" modelAttribute="employee">

            <table>

                <tr>
                    <td>Name</td>
                    <td>
                        <f:input path="name" class="form-control" />
                    </td>
                </tr>
                
                  <tr>
                    <td>Price</td>
                    <td>
                        <f:input path="price" class="form-control" />
                    </td>
                </tr>
                
                
                   <tr>
                    <td>Quantity</td>
                    <td>
                        <f:input path="quantity" class="form-control" />
                    </td>
                </tr>

                


                <tr>
                    <td>Brand</td>
                    <td>
                        <f:select path="brand" class="form-control">
                           
                            <f:option value="">>>>Select One<<<</f:option>
                            <f:option value="HP">HP</f:option>
                            <f:option value="ASUS">ASUS</f:option>
                            <f:option value="APPLE">APPLE</f:option>
                            <f:option value="DELL">DELL</f:option>
                            <f:option value="SAMSUNG">SAMSUNG</f:option>
                            <f:option value="NOKIA">NOKIA</f:option>
                            
                        </f:select>
                    </td>
                </tr>


                <tr>
                    <td colspan="2"><input type="submit" value="Save"></td>
                </tr>
            </table>                    
        </f:form>

    </body>
</html>
