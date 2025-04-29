<%@ include file="/WEB-INF/views/layouts/header.jsp" %>

<div>
        <a href="./categories/create">tambah category</a>
    </div>
    <div>
    <h2>Daftar Category</h2>
        <div>

            <%-- <c:if test="${message != null}">
                <p style="color: green; font-weight:bold;">
                    ${message}
                </p>
            </c:if> --%>
            <table border="1" cellpadding="5" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Name Category</th>
                        <th>Description</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listCategories}" var="category" varStatus="loop">
                        <tr>
                            <td>${loop.count}</td>
                            <td>${category.name}</td>
                            <td>${category.description}</td>
                            <td>
                                <a href="./categories/edit/${category.id}">Edit</a>
                                <form action="./categories/delete/${category.id}" method="post" style="display:inline;">
                                    <button type="submit" onClick="return confirm('Are you sure you want to delete this category?')" >delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>


<%@ include file="/WEB-INF/views/layouts/footer.jsp" %>