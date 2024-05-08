<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="../include/header.jsp"/>

<section id="register-container">
    <h1>Register</h1>
    <div id="register-form-container">
        <!-- the action attribute on the form tag is the URL that the form will submit to when then user clicks the submit button -->
        <form method="get" action="/auth/registerSubmit">
            <input type="hidden" name="id" value="${form.id}">
            <%--     EMAIL   --%>
            <div class="mt-3">
                <label for="email" class="form-label">Email</label>
                <input type="text" class="form-control" id="email" name="email" aria-describedby="emailHelp"
                       value="${form.email}">
            </div>

            <c:if test="${errors.hasFieldErrors('email')}">
                <div style="color:red">
                    <c:forEach items="${errors.getFieldErrors('email')}" var="error">
                        ${error.defaultMessage}<br>
                    </c:forEach>
                </div>
            </c:if>
            <%--     FIRST NAME   --%>
            <div class="mt-3">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName"
                       value="${form.firstName}">
            </div>

            <c:if test="${errors.hasFieldErrors('firstName')}">
                <div style="color:red">
                    <c:forEach items="${errors.getFieldErrors('firstName')}" var="error">
                        ${error.defaultMessage}<br>
                    </c:forEach>
                </div>
            </c:if>

            <%--     LAST NAME   --%>
            <div class="mt-3">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName"
                       value="${form.lastName}">
            </div>

            <c:if test="${errors.hasFieldErrors('lastName')}">
                <div style="color:red">
                    <c:forEach items="${errors.getFieldErrors('lastName')}" var="error">
                        ${error.defaultMessage}<br>
                    </c:forEach>
                </div>
            </c:if>

            <%--     CITY   --%>
            <div class="mt-3">
                <label for="city" class="form-label">City</label>
                <input type="text" class="form-control" id="city" name="city"
                       value="${form.city}">
            </div>

            <c:if test="${errors.hasFieldErrors('city')}">
                <div style="color:red">
                    <c:forEach items="${errors.getFieldErrors('city')}" var="error">
                        ${error.defaultMessage}<br>
                    </c:forEach>
                </div>
            </c:if>

            <%--     STATE   --%>
            <div class="mt-3">
                <label for="state" class="form-label">State</label>
                <input type="text" class="form-control" id="state" name="state"
                       value="${form.state}">
            </div>

            <c:if test="${errors.hasFieldErrors('state')}">
                <div style="color:red">
                    <c:forEach items="${errors.getFieldErrors('state')}" var="error">
                        ${error.defaultMessage}<br>
                    </c:forEach>
                </div>
            </c:if>

            <%--     ADDRESS   --%>
            <div class="mt-3">
                <label for="address" class="form-label">Address</label>
                <input type="text" class="form-control" id="address" name="address"
                       value="${form.address}">
            </div>

            <c:if test="${errors.hasFieldErrors('address')}">
                <div style="color:red">
                    <c:forEach items="${errors.getFieldErrors('address')}" var="error">
                        ${error.defaultMessage}<br>
                    </c:forEach>
                </div>
            </c:if>
            <%--     ZIP CODE   --%>
            <div class="mt-3">
                <label for="zipCode" class="form-label">Zip Code</label>
                <input type="text" class="form-control" id="zipCode" name="zipCode"
                       value="${form.zipCode}">
            </div>

            <c:if test="${errors.hasFieldErrors('zipCode')}">
                <div style="color:red">
                    <c:forEach items="${errors.getFieldErrors('zipCode')}" var="error">
                        ${error.defaultMessage}<br>
                    </c:forEach>
                </div>
            </c:if>
            <%--     PASSWORD   --%>
            <div class="mt-3">
                <label for="password" class="form-label">Password</label>
                <input type="text" class="form-control" id="password" name="password" value="${form.password}">
            </div>

            <c:if test="${errors.hasFieldErrors('password')}">
                <div style="color:red">
                    <c:forEach items="${errors.getFieldErrors('password')}" var="error">
                        ${error.defaultMessage}<br>
                    </c:forEach>
                </div>
            </c:if>
            <%--     CONFIRM PASSWORD   --%>
            <div class="mt-3">
                <label for="confirmPassword" class="form-label">Confirm Password</label>
                <input type="text" class="form-control" id="confirmPassword" name="confirmPassword"
                       value="${form.confirmPassword}">
            </div>

            <c:if test="${errors.hasFieldErrors('confirmPassword')}">
                <div style="color:red">
                    <c:forEach items="${errors.getFieldErrors('confirmPassword')}" var="error">
                        ${error.defaultMessage}<br>
                    </c:forEach>
                </div>
            </c:if>

            <button type="submit" class="btn btn-primary mt-4">Submit</button>
        </form>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>