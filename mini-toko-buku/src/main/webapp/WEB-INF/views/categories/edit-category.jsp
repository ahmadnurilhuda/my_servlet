<%@ include file="/WEB-INF/views/layouts/header.jsp" %>

<h2>Form Edit Category</h2>
     <form action="" method="POST">
    <table>
        <tr>
            <td><label for="name">Name</label></td>
            <td>:</td>
            <td><input type="text" name="name" required value="${category.name}"></td>
        </tr>
        <tr>
            <td><label for="description">Description</label></td>
            <td>:</td>
            <td><textarea name="description" id="" required>${category.description}</textarea></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Add</button>
            </td>
        </tr>
    </table>
    </form>

<%@ include file="/WEB-INF/views/layouts/footer.jsp" %>