
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Customer | SweetCrumbs</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<div class="container edit-customer-container">
    <h1>Edit Customer</h1>
    <p>Update your customer information below.</p>

    <c:if test="${not empty errorMessage}">
        <p class="error-message">${errorMessage}</p>
    </c:if>

    <form action="${pageContext.request.contextPath}/customers/update"
          method="post">

        <input type="hidden" name="id" value="${customer.id}">

        <label for="name">Full Name</label>
        <input type="text" id="name" name="name"
               value="${customer.name}" required>

        <label for="email">Email Address</label>
        <input type="email" id="email" name="email"
               value="${customer.email}" required>

        <label for="phone">Phone Number</label>
        <input type="text" id="phone" name="phone"
               value="${customer.phone}" required>

        <button type="submit">Save Changes</button>
    </form>

    <a href="${pageContext.request.contextPath}/customers">
        Cancel and Return to Customers
    </a>
</div>

</body>
</html>
