<%@ include file="/WEB-INF/views/layouts/header.jsp" %>
<h2>Form Edit Book</h2>
    <form action="" method="POST">
    <table>
        <tr>
            <td><label for="title">Title</label></td>
            <td>:</td>
            <td><input type="text" name="title" value="${book.title}" required></td>
        </tr>
        <tr>
            <td><label for="isbn">ISBN Number</label></td>
            <td>:</td>
            <td><input type="text" name="isbn" value="${book.isbn}" required></td>
        </tr>
        <tr>
            <td><label for="year">Date Release</label></td>
            <td>:</td>
            <td><input type="date" name="year" value="${book.year}" required></td>
        </tr>
        <tr>
            <td><label for="price">Price</label></td>
            <td>:</td>
            <td><input type="number" name="price" value="<fmt:formatNumber value="${book.price}" groupingUsed="false" maxFractionDigits="0" />" required></td>
        </tr>
        <tr>
            <td><label for="stock">Stock</label></td>
            <td>:</td>
            <td><input type="number" name="stock" value="${book.stock}" required></td>
        </tr>
        <tr>
            <td><label for="description">description</label></td>
            <td>:</td>
            <td>
                <textarea name="description" id=""> ${book.description} </textarea>
            </td>
        </tr>
        <tr>
            <td><label for="category">Category</label></td>
            <td>:</td>
            <td><input type="text" name="category" value="${book.category}" required></td>
        </tr>

        <tr>
            <td colspan="2">
                <button type="submit">Add</button>
            </td>
        </tr>
    </table>
    </form>

    <%-- <h3>${message}</h3>
    <p>Nama: <c:out value="${message}" /></p>

    <c:if test="${age < 18}">
    <p>[ini yang if] Kamu masih di bawah umur.</p>
    </c:if>

    <c:choose>
        <c:when test="${age < 13}">
            <p>[ini yang choose] Anak-anak</p>
        </c:when>
            <c:when test="${age < 18}">
                <p>[ini yang choose] Remaja</p>
            </c:when>
        <c:otherwise>
            <p>[ini yang choose] Dewasa</p>
        </c:otherwise>
    </c:choose> --%>


<%@ include file="/WEB-INF/views/layouts/footer.jsp" %>