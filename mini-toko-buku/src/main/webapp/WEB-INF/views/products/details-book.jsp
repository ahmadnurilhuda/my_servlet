
<%@ include file="/WEB-INF/views/layouts/header.jsp" %>

    <div>
        <a href="./books/create">tambah buku</a>
    </div>
    <div>
    <h2>Daftar Product</h2>
        <div>
            <ul>
            <c:forEach items="${books}" var="book">
                <li>
                    <h2>${book.title}</h2>
                    <h3>${book.isbn}</h3>
                    <h4>${book.year}</h4>
                    <p>${book.price}</p>
                    <p>${book.stock}</p>
                </li>
               </c:forEach> 
            </ul>
        </div>
    </div>
<%@ include file="/WEB-INF/views/layouts/footer.jsp" %>