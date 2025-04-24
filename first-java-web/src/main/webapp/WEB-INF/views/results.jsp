
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%-- <%
    String name = (String)
    String age = (String)
    String color = (String)
%> --%>
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
            background-color: ${colorSet};
            padding: 24px;
            color: white;
        }
    </style>
</head>
<body>
    <h1>Hai ${nameSet} <h1>
    <p> ini umur saya ${ageSet} </p>
</body>
</html>