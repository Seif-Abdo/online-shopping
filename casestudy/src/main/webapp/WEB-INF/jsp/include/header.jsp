<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>LJ's Guitars</title>
                                <%--Icons--%>
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />
                                <%--CSS--%>
    <link rel="stylesheet" href="/pub/css/styles.css"/>

                                <%--Fonts--%>
    <link href="https://fonts.googleapis.com/css?family=Bentham|Playfair+Display|Raleway:400,500|Suranna|Trocchi" rel="stylesheet">
</head>
</head>
<body>
<div id="header-main">
    <a href="/" id="logo"><img src="/pub/images/logo.jpg" alt="logo" /></a>
    <div class="wrap">
        <div class="search">
            <form id="search-form" method="get" action="/product/search">
                <input
                        type="text"
                        class="searchTerm"
                        placeholder="What are you looking for?"
                        id="productName"
                        name="productName"
                />
                <button type="submit" class="searchButton">
                    <i class="fa fa-search"></i>
                </button>
            </form>
        </div>
    </div>

    <sec:authorize access="!isAuthenticated()">
        <a href="/auth/login">Login</a>
    </sec:authorize>

    <sec:authorize access="hasAnyAuthority('ADMIN')">
        <a href="/product/create">Create Product</a>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
        <a href="/user/account">Account</a>

        <a href="/auth/logout">Logout</a>

        <a href="/cart/viewCart"
        ><i class="fa fa-shopping-cart" style="font-size: 36px"></i>
        </a>
    </sec:authorize>

</div>
<div id="header-sub">
    <ul>
        <li><a href="/product/search?productName=guitar">Guitars</a></li>
        <li><a href="/product/search?productName=acoustic">Acoustics</a></li>
        <li><a href="/product/search?productName=bass">Basses</a></li>
        <li><a href="/product/search?productName=amp">Amps & Audio</a></li>
        <li><a href="/product/search?productName=pedal">Effects Pedals</a></li>
        <li><a href="/product/search?productName=accessory">Accessories</a></li>
    </ul>
</div>