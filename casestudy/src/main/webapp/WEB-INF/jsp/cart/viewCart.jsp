<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<section id="cart-container">
    <div id="cart-main">
        <form method="get" action="/cart/checkout">
            <c:choose>
                <c:when test="${not empty orderDetails}">
                    <c:forEach items="${orderDetails}" var="orderDetail">
                        <div class="cart-item">
                            <div class="cart-item-img">
                                <img src="${orderDetail.getProduct().getImageUrl()}" alt="item">
                            </div>
                            <div class="cart-item-name">
                                <a href="/product/detail/${orderDetail.getProduct().getId()}">${orderDetail.getProduct().getProductName()}</a>
                            </div>
                            <div class="cart-item-price">
                                <span>$${orderDetail.getProduct().getProductMSRP()}</span>
                            </div>
                            <div class="cart-item-quantity">
                                <span>Quantity: ${orderDetail.getQuantity()}</span>
                            </div>
                            <div class="cart-item-remove">
                                <a href="/cart/removeItem/${orderDetail.getProduct().getId()}">Remove</a>
                            </div>
                        </div>
                    </c:forEach>
                    <hr>

                    <div class="total-amount">
                        <span>Total: $${totalPrice}</span>
                        <div class="checkout-btn">
                            <button type="submit" >Checkout</button>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <h1>No items in cart!</h1>
                </c:otherwise>
            </c:choose>
        </form>
    </div>

</section>

<jsp:include page="../include/footer.jsp"/>