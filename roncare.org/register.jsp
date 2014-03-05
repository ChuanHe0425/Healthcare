<!DOCTYPE html>
<html class="no-js">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">

        <link rel="stylesheet" href="css/normalize.min.css">
        <link rel="stylesheet" href="css/main.css">

        <script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    </head>
    <body>

        <div class="header-container">
            <header class="wrapper clearfix">
                <h1 class="title">RonCare</h1>
                <nav>
                	<ul id="utilitynav">
                		 <li><a href="#">Log in</a></li>
                        <li><a href="#">Sign up</a></li>
                	</ul>
                    <ul id="mainnav">
                        <li><a href="#">About</a></li>
                        <li><a href="#">Plans</a></li>
                        <li><a href="#">FAQs</a></li>
                        <li><a href="#">Contact Us</a></li>
                    </ul>
                </nav>
            </header>
        </div>

        <div class="main-container">
            <div class="main wrapper clearfix">

          	<h1>RonCare Registration</h1>

	<div>
		<form action="http://localhost:8080/roncare.org/Register" method="post">
			
			User Name: <input type="text" name="username" > 
			<br>
			<br>
			Password: <input type="password" name="password" >
			<br>
			Confirm Password: <input type="password" name="confirmPassword" >
			<br>
			<br>
			First Name: <input type="text" name="firstName" >
			<br>
			Last Name: <input type="text" name="lastName" >
			<br>
			Date of Birth Name: <input type="date" name="dateOfBirth" >
			<br>
			<input type="submit" value="Register">
		</form>
	</div>

            </div> <!-- #main -->
        </div> <!-- #main-container -->

        <div class="footer-container">
            <footer class="wrapper">
                <h3>footer</h3>
            </footer>
        </div>

        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.10.1.min.js"><\/script>')</script>

        <script src="js/main.js"></script>
    </body>
</html>