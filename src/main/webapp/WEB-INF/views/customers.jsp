
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customers | Sweet Crumbs</title>

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
        <a class="active" href="${pageContext.request.contextPath}/customers">
            Customers
        </a>
    </nav>
</header>

<main class="customers-page">

    <section class="customers-heading">
        <div>
            <p class="eyebrow">SWEET CRUMBS BAKERY</p>
            <h1>Customer Management</h1>
            <p>Keep all your lovely customers in one place.</p>
        </div>

        <a class="add-customer-button"
           href="${pageContext.request.contextPath}/customers/new">
            + Add Customer
        </a>
    </section>



    <section class="customer-list-card">

        <div class="table-heading">
            <div>
                <h2>Customer List</h2>
                <p>Registered customer details</p>
            </div>
        </div>


<%
    java.util.List<com.sweetcrumbs.model.Customer> customers =
        (java.util.List<com.sweetcrumbs.model.Customer>) request.getAttribute("customers");

    if (customers != null && !customers.isEmpty()) {
%>
    <div class="table-wrapper">
        <table class="customer-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Customer Name</th>
                    <th>Email Address</th>
                    <th>Phone Number</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>

<% for (com.sweetcrumbs.model.Customer customer : customers) { %>
    <tr>
        <td>
            <span class="customer-id">#<%= customer.getId() %></span>
        </td>
        <td class="customer-name"><%= customer.getName() %></td>
        <td><%= customer.getEmail() %></td>
        <td><%= customer.getPhone() %></td>

        <td class="customer-actions">
            <a class="edit-btn"
               href="${pageContext.request.contextPath}/customers/edit?id=<%= customer.getId() %>">
                Edit
            </a>

            <form action="${pageContext.request.contextPath}/customers/delete"
                  method="post"
                  style="display: inline;"
                  onsubmit="return confirm('Are you sure you want to delete this customer?');">

                <input type="hidden"
                       name="id"
                       value="<%= customer.getId() %>">

                <button type="submit" class="delete-btn">
                    Delete
                </button>
            </form>
        </td>
    </tr>
<% } %>

            </tbody>
        </table>
    </div>
<%
    } else {
%>
    <div class="empty-customers">
        <div class="empty-icon">&#9825;</div>
        <h3>No customers yet</h3>
        <p>Your customer list is waiting for its first entry.</p>
        <a class="add-customer-button"
           href="${pageContext.request.contextPath}/customers/new">
            Register First Customer
        </a>
    </div>
<%
    }
%>


    </section>

    <a class="back-link"
       href="${pageContext.request.contextPath}/">
        &#8592; Back to Home
    </a>

</main>

</body>
</html>
