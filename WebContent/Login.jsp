<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Profile Management</title>
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/style/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./style/css/bootstrap.min.css">
<link rel="stylesheet" href="./style/css/bootstrap.css">
<link rel="stylesheet" href="./style/css/bootstrap-theme.min.css">
<script src="./style/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./style/css/font-awesome.min.css">
<link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./style/css/Login.css">
</head>
<body>
<div class="row">
    <div class="navbar navbar-inverse" role="navigation">
        <div class="container navbar-header" style="margin-left: 8%">
                <div class="navbar-brand">Students Profile Management System</div>        
        </div>
    </div>
</div>
<div class="row">
    <div class="container">
        <div class="card card-container">    
            <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
            <p id="profile-name" class="profile-name-card"></p>
            <form class="form-signin" action="LoginServlet" method="POST">
                <span id="reauth-email" class="reauth-email"></span>
                <input name="email" type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                <div id="remember" class="checkbox">
                    <label>
                        <input name="remember" type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <input class="btn btn-lg btn-primary btn-block btn-signin" type="submit" value="Sign in"/>            
            </form><!-- /form -->
            <a href="#" class="forgot-password">
                Forgot the password?
            </a>
        </div><!-- /card-container -->
    </div><!-- /container -->
    
</div>
</body>
</html>