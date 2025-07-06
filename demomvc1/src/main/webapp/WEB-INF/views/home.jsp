<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User HomePage</title>
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
		.container{
			padding: 10px 20px;
		}

		.register-form {
		    max-width: 400px;
		    margin: 0 auto;
		}

		.register-form fieldset {
		    border: 2px solid #007bff;
		    border-radius: 8px;
		    padding: 20px;
		}

		.register-form legend {
		    font-weight: bold;
		    font-size: 1.5em;
		    color: #007bff;
		}

		.register-form label {
		    display: block;
		    margin-top: 10px;
		    font-weight: bold;
		}

		.register-form input {
		    width: 100%;
		    padding: 8px;
		    margin-top: 5px;
		    margin-bottom: 10px;
		    border-radius: 4px;
		    border: 1px solid #ccc;
		}

		.register-form button {
		    width: 100%;
		    padding: 10px;
		    background-color: #007bff;
		    color: white;
		    font-size: 1em;
		    border: none;
		    border-radius: 5px;
		    cursor: pointer;
		}

		
		footer {
		    background-color: #333;
		    color: white;
		    text-align: center;
		    padding: 10px;
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
	
	<h1>${msg}</h1>
	
    <header>
        <nav>
            <div class="logo">My Website</div>
            <ul class="nav-links">
                <li><a href="#">Home</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Services</a></li>
                <li><a href="#">Contact</a></li>
            </ul>
        </nav>
    </header>

    <section class="hero">
        <div class="hero-content">
            <h1>Welcome to User Homepage Website</h1>
            <p>Welcome to our platform, where innovation meets professionalism! We connect talented individuals with leading companies, fostering collaboration and growth. Whether you're seeking new opportunities or striving for excellence in your field, we're here to support your journey. Explore our services, engage with experts, and take your career or business to the next level. Your success starts here!</p>
            <button class="btn">Learn More</button>
        </div>
    </section>

	<div class="container">
	    <form action="submit" method="post" class="register-form">
	        <fieldset>
	            <legend>Register</legend>
	            <label for="id">Id:</label>
	            <input type="number" id="id" name="id" placeholder="Enter the id" required>

	            <label for="name">Name:</label>
	            <input type="text" id="name" name="name" placeholder="Enter the name" required>

	            <label for="age">Age:</label>
	            <input type="number" id="age" name="age" placeholder="Enter your age" required>

	            <label for="gender">Gender:</label>
	            <input type="text" id="gender" name="gender" placeholder="Enter your gender" required>

	            <button type="submit">Submit</button>
	        </fieldset>
	    </form>
	</div>

	
    <footer>
        <p>&copy; 2024 My Website. All rights reserved.</p>
    </footer>
    
</body>
</html>