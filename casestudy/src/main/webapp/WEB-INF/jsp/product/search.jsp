<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<section>
    <section class="product-card-container">
        <ul class="listing">
            <c:choose>
                <c:when test="${not empty products}">
                    <c:forEach items="${products}" var="product">
                        <li class="product">
                            <a class="img-wrapper" href="/product/detail/${product.id}">
                                <img src="${product.imageUrl}" alt="product image" />
                            </a>

                            <div class="info">
                                <div class="title">${product.productName}</div>
                                <div class="price">$${product.productMSRP}</div>
                            </div>
                        </li>

                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <p>No products found for "${productSearch}"</p>
                </c:otherwise>
            </c:choose>
        </ul>
    </section>

</section>


<jsp:include page="../include/footer.jsp"/>