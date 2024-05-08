<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<section id="login-container">
    <h1>Login</h1>

    <div id="login-form-container">
        <form method="post" action="/auth/loginSubmit">
            <div>
                <label for="username" class="form-label">Username</label>
                <input type="text" class="form-control" id="username" name="username">
            </div>

            <div>
                <label for="password" class="form-label">Password</label>
                <input type="text" class="form-control" id="password" name="password">
            </div>

            <button type="submit">Submit</button>
        </form>
    </div>

    <p>Don't have an account? <a href="/auth/register">REGISTER</a></p>
</section>


<jsp:include page="../include/footer.jsp"/>