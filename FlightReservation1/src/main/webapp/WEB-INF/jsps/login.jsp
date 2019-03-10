<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="https://www.gstatic.com/firebasejs/5.8.6/firebase.js"></script>
<script>
  // Initialize Firebase
  var config = {
    apiKey: "AIzaSyBjtQW8i-LX52nKlTo6NErNv1H3sqieCI0",
    authDomain: "flightreservation-eb903.firebaseapp.com",
    databaseURL: "https://flightreservation-eb903.firebaseio.com",
    projectId: "flightreservation-eb903",
    storageBucket: "flightreservation-eb903.appspot.com",
    messagingSenderId: "39940303828"
  };
  firebase.initializeApp(config);
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Login :</h2>

	<form action="login" method="post">
		<pre>
User Name : <input type="text" name="${user.email}"/>
Password : <input type="password" name="user.password"/>

<input type="submit" value="Register" />
</pre>
	</form>
</body>
</html>