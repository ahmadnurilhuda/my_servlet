<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style/main.css">
    <title>Form BioData</title>
</head>
<body>
<h2>Isi Data Berikut</h2>
    <form action="/first-java-web/results" method="get">
        <label for= "name">Nama:</label>
        <input type="text" name="name" required><br><br>

        <label for="age">Umur:</label>
        <input type="number" name="age" required><br><br>

        <label for="color">Warna Favorit:</label>
        <input type="color" name="color"><br><br>

        <button type="submit">Kirim</button>
    </form>
</body>
</html>