
<%@ include file="/WEB-INF/views/layouts/header.jsp" %>

    <div>
        <a href="./books/create">tambah buku</a>
    </div>
    <div>
    <h2>Daftar Product</h2>
        <div>

            <c:if test="${message != null}">
                <p style="color: green; font-weight:bold;">
                    ${message}
                </p>
            </c:if>
            <table border="1" cellpadding="5" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Title</th>
                        <th>ISBN</th>
                        <th>Year</th>
                        <th>Price</th>
                        <th>Stock</th>
                        <th>Category</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listBooks}" var="book" varStatus="loop">
                        <tr>
                            <td>${loop.count}</td>
                            <td>${book.title}</td>
                            <td>${book.isbn}</td>
                            <td>${book.year}</td>

                            <td>
                                <fmt:formatNumber value="${book.price}" type="currency"
                                currencySymbol="Rp" maxFractionDigits="0" />
                            </td>
                            <td>${book.stock}</td>
                            <td>${book.category}</td>
                            <td>
                                <a href="./books/edit/${book.id}">Edit</a>
                                <form action="./books/delete/${book.id}" method="post" style="display:inline;">
                                    <button type="submit" onClick="return confirm('Are you sure you want to delete this book?')" >delete</button>
                                </form>
                            
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
<%@ include file="/WEB-INF/views/layouts/footer.jsp" %>