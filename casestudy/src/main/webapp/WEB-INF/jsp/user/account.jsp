<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../include/header.jsp"/>

<section id="account-page-container">
    <sec:authorize access="hasAnyAuthority('ADMIN')">
        <h1><span>ADMIN ACCOUNT</span></h1>
    </sec:authorize>

    <div id="account-page-main">
        <div id="account-page-info">
            <h1>Email: <span>${user.email}</span></h1>
            <h1>First Name: <span>${user.firstName}</span></h1>
            <h1>Last Name: <span>${user.lastName}</span></h1>
            <h1>Address: <span>${user.address} ${user.city}, ${user.state} ${user.zipCode}</span></h1>
        </div>
    </div>

</section>

<jsp:include page="../include/footer.jsp"/>