
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register | Sweet Crumbs</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<header class="navbar">
    <a class="logo" href="${pageContext.request.contextPath}/">
        Sweet Crumbs<span>.</span>
    </a>
    <nav>
        <a href="${pageContext.request.contextPath}/">Home</a>
        <a href="${pageContext.request.contextPath}/customers">Customers</a>
    </nav>
</header>

<main class="form-section">
    <div class="form-card">
        <p class="eyebrow">WELCOME TO SWEET CRUMBS</p>
        <h1>Create Your Customer Profile</h1>
        <p class="form-description">
            Enter your details to get started with your cake booking.
        </p>

        <form action="${pageContext.request.contextPath}/customers/save"
              method="post">

            <label for="name">Full Name</label>

            <input type="text" id="name" name="name"
                   placeholder="Enter your full name"
                   required maxlength="100">

            <label for="email">Email Address</label>

            <input type="email" id="email" name="email"
                   placeholder="you@example.com"
                   required maxlength="150">

            <label for="phone">Phone Number</label>

            <input type="tel" id="phone" name="phone"
                   placeholder="Enter your phone number"
                   required maxlength="20">

            <button type="submit" class="primary-button form-submit">
                Register Customer
            </button>
        </form>

        <a class="back-link"
           href="${pageContext.request.contextPath}/">
            ← Back to Home
        </a>
    </div>
</main>

<footer>
    <p>© 2026 Sweet Crumbs Bakery</p>
</footer>

</body>
</html>
