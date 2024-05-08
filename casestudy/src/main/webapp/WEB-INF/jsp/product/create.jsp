<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<section id="product-create-container">
    <div class="container">
        <!-- the action attribute on the form tag is the URL that the form will submit to when then user clicks the submit button -->
        <form method="get" action="/product/createSubmit">
            <input type="hidden" name="id" value="${form.id}">

            <div class="mt-3">
                <label for="productName" class="form-label">Product Name</label>
                <input type="text" class="form-control" id="productName" name="productName" value="${form.productName}">
            </div>

            <c:if test="${errors.hasFieldErrors('productName')}">
                <div style="color:red">
                    <c:forEach items="${errors.getFieldErrors('productName')}" var="error">
                        ${error.defaultMessage}<br>
                    </c:forEach>
                </div>
            </c:if>

            <div class="mt-3">
                <label for="productDescription" class="form-label">Product Description</label>
                <input type="text" class="form-control" id="productDescription" name="productDescription" value="${form.productDescription}">
            </div>

            <c:if test="${errors.hasFieldErrors('productDescription')}">
                <div style="color:red">
                    <c:forEach items="${errors.getFieldErrors('productDescription')}" var="error">
                        ${error.defaultMessage}<br>
                    </c:forEach>
                </div>
            </c:if>

            <div class="mt-3">
                <label for="productMSRP" class="form-label">Product MSRP</label>
                <input type="text" class="form-control" id="productMSRP" name="productMSRP" value="${form.productMSRP}">
            </div>

            <c:if test="${errors.hasFieldErrors('productMSRP')}">
                <div style="color:red">
                    <c:forEach items="${errors.getFieldErrors('productMSRP')}" var="error">
                        ${error.defaultMessage}<br>
                    </c:forEach>
                </div>
            </c:if>

            <div class="mt-3">
                <label for="imageUrl" class="form-label">Image Url</label>
                <input type="text" class="form-control" id="imageUrl" name="imageUrl" value="${form.imageUrl}">
            </div>

            <c:if test="${errors.hasFieldErrors('imageUrl')}">
                <div style="color:red">
                    <c:forEach items="${errors.getFieldErrors('imageUrl')}" var="error">
                        ${error.defaultMessage}<br>
                    </c:forEach>
                </div>
            </c:if>

            <div class="mt-3">
                <label for="productCategory" class="form-label">Product Category</label>
                <input type="text" class="form-control" id="productCategory" name="productCategory" value="${form.productCategory}">
            </div>

            <c:if test="${errors.hasFieldErrors('productCategory')}">
                <div style="color:red">
                    <c:forEach items="${errors.getFieldErrors('productCategory')}" var="error">
                        ${error.defaultMessage}<br>
                    </c:forEach>
                </div>
            </c:if>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</section>


<jsp:include page="../include/footer.jsp"/>