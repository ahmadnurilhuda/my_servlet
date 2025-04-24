<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="">
    <title>Form Add Book</title>
</head>
<body>
<h2>Form Add Book</h2>
    <form action="" method="post">
    <table>
        <tr>
            <td><label for="title">Title</label></td>
            <td>:</td>
            <td><input type="text" name="title" required></td>
        </tr>
        <tr>
            <td><label for="isbn">ISBN Number</label></td>
            <td>:</td>
            <td><input type="text" name="isbn" required></td>
        </tr>
        <tr>
            <td><label for="year">Date Release</label></td>
            <td>:</td>
            <td><input type="date" name="year" required></td>
        </tr>
        <tr>
            <td><label for="price">Price</label></td>
            <td>:</td>
            <td><input type="number" name="price" required></td>
        </tr>
        <tr>
            <td><label for="stock">Stock</label></td>
            <td>:</td>
            <td><input type="number" name="stock" required></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Add</button>
            </td>
        </tr>
    </table>
    </form>
</body>
</html>