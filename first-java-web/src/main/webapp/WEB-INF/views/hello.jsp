
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%
    String name = (String)request.getAttribute("namaSet")
    String age = (String)request.getAttribute("ageSet")
    String color = (String)request.getAttribute("colorSet")
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hello From Hello.jsp</title>
    <style>
        *{
        padding: 0;
        margin: 0;
        box-sizing: border-box;
        font-family: poppins, sans-serif;
        }
        body{
            background-color:<% color %>;
            padding: 24px;
            color: white;
        }
    </style>
</head>
<body>
    <h1>Hai <% name  %></h1>
    <p> ini umur saya <%= age %> </p>
</body>
</html>