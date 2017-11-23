<%-- 
    Document   : SignUp
    Created on : 4 Sep, 2014, 3:18:02 AM
    Author     : Aryaman
--%>

<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>
    <script type="text/javascript" src="formValidation.js">
        
    </script>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Dark Login Form</title>
  <link rel="stylesheet" href="css/style2.css">
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
    
    <div id="headimg">
        <img src="img/header.jpg" alt="Header" width="1366">
        
    </div>
    
    <form method="post" name="registration" action="signUpServlet" class="login" onsubmit="return formValidation();">
    
      <p>
      <label for="login">Name:</label>
      <input type="text" name="name1" id="login" placeholder="Player 1">
      </p>
      
      <div id="lname">
          <input type="text" name="name2" id="login" placeholder="Player 2">
      </div>
       
      <br>        
       
      
      <p>
      <label for="login">Team:</label>
      <input type="text" name="uname" id="login" placeholder="Team Name">
    </p>
      
      <p>
      <label for="login">Email:</label>
      <input type="text" name="email" id="login" placeholder="name@example.com">
    </p>
    <p>
      <label for="login">Phone:</label>
      <input type="text" name="phone" id="login" placeholder="6969696969">
    </p>
    <br>

    <p>
      <label for="password">Password:</label>
      <input type="password" name="pword" id="password" placeholder="New Password">
    </p>
    
    <div id="lname">
      <label for="password"></label>
      <input type="password" name="cpword" id="password" placeholder="Confirm Password">
    </div>

    <p class="login-submit">
      <button type="submit" class="login-button">Login</button>
    </p>


</body>
</html>

