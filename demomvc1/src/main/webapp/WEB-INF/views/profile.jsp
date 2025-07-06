<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome To Profile</title>
    <style>
		/* style.css */
		body {
		    font-family: sans-serif;
		    margin: 0;
		    padding: 0;
		    background-color: #f4f4f4;
		}

		header {
		    background-color: #333;
		    color: white;
		    padding: 10px 0;
		    text-align: center;
		}

		nav {
		    display: flex;
		    justify-content: space-between;
		    align-items: center;
		    padding: 0 20px;
		}

		.logo {
		    font-size: 1.5em;
		    font-weight: bold;
		}

		.nav-links {
		    list-style: none;
		    margin: 0;
		    padding: 0;
		    display: flex;
		}

		.nav-links li {
		    margin-left: 20px;
		}

		.nav-links a {
		    color: white;
		    text-decoration: none;
		}

		.hero {
		    text-align: center;
		    padding: 50px;
		    background-color: #fff;
		}

		.hero-content {
		    max-width: 600px;
		    margin: 0 auto;
		}

		.hero h1 {
		    font-size: 2.5em;
		    margin-bottom: 10px;
		}

		.hero p {
		    font-size: 1.2em;
		    margin-bottom: 20px;
		}

		.btn {
		    background-color: #007bff;
		    color: white;
		    padding: 10px 20px;
		    border: none;
		    border-radius: 5px;
		    cursor: pointer;
		    font-size: 1em;
		    text-decoration: none;
		}

		footer {
		    background-color: #333;
		    color: white;
		    text-align: center;
		    padding: 10px;
		    position: fixed;
		    bottom: 0;
		    width: 100%;
		}
	</style>
	<script>
		// script.js
		document.querySelector('.btn').addEventListener('click', function() {
		    alert('Learn More button clicked!');
		});
	</script>
</head>
<body>

    <header>
        <nav>
            <div class="logo">My Profile</div>
            <ul class="nav-links">
                <li><a href="#">Home</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Services</a></li>
                <li><a href="#">Contact</a></li>
            </ul>
        </nav>
    </header>

	<h1>${student}</h1>
	<h1>${name}</h1>
	<h1>${age}</h1>
    <section class="hero">
        <div class="hero-content">
            <h1>Welcome to My Profile</h1>
            <p>Welcome to our platform, where innovation meets professionalism! We connect talented individuals with leading companies, fostering collaboration and growth. Whether you're seeking new opportunities or striving for excellence in your field, we're here to support your journey. Explore our services, engage with experts, and take your career or business to the next level. Your success starts here!</p>
            <button class="btn">Learn More</button>
        </div>
    </section>

    <footer>
        <p>&copy; 2024 My Website. All rights reserved.</p>
    </footer>

    
</body>
</html>