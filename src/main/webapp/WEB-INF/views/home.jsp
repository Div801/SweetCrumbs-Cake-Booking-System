
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sweet Crumbs | Bakery</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<header class="navbar">
    <a href="${pageContext.request.contextPath}/" class="logo">
        Sweet Crumbs<span>.</span>
    </a>

    <nav>
        <a href="${pageContext.request.contextPath}/">Home</a>
        <a href="${pageContext.request.contextPath}/customers">Customers</a>
        <a href="${pageContext.request.contextPath}/customers/new" class="nav-button">
            Register
        </a>
    </nav>
</header>

<main>
    <section class="hero">
        <div class="hero-content">
            <p class="eyebrow">BAKED WITH LOVE ♡</p>

            <h1>Every celebration deserves a little sweetness.</h1>

            <p class="description">
                Discover delightful cakes and create something special
                for your next celebration with Sweet Crumbs.
            </p>

            <div class="hero-buttons">
                <a href="${pageContext.request.contextPath}/customers/new"
                   class="primary-button">
                    Get Started
                </a>

                <a href="${pageContext.request.contextPath}/customers"
                   class="secondary-button">
                    View Customers
                </a>
            </div>
        </div>

        <div class="cake-art" aria-label="Illustration of a celebration cake">
            <div class="cake-emoji">🎂</div>
            <p>Made fresh, just for you</p>
        </div>
    </section>

    <section class="features">
        <article class="feature-card">
            <div class="feature-icon">🍰</div>
            <h2>Delicious Cakes</h2>
            <p>Sweet treats for every special moment.</p>
        </article>

        <article class="feature-card">
            <div class="feature-icon">🎨</div>
            <h2>Custom Creations</h2>
            <p>Make your celebration uniquely yours.</p>
        </article>

        <article class="feature-card">
            <div class="feature-icon">🎉</div>
            <h2>Easy Booking</h2>
            <p>Plan your next celebration with ease.</p>
        </article>
    </section>
</main>

<footer>
    <p>© 2026 Sweet Crumbs Bakery. Made with love ♡</p>
</footer>

</body>
</html>
