<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Session Expiry Warning Message - Home Page</title>
	
	<script type="text/javascript">
        function overlay() {
            el = document.getElementById("overlay");
            el.style.visibility = (el.style.visibility == "visible") ? "hidden"
                    : "visible";
            setTimeout(function() {
                window.location = "<%=request.getContextPath()%>/login.html";
            }, 5000);
        }
        var secondsBeforeExpire = ${pageContext.session.maxInactiveInterval};
        setTimeout(function() {
            overlay();
        }, secondsBeforeExpire * 1000);
    </script>
	
	<style type="text/css">
		#overlay {
			visibility: hidden;
			position: absolute;
			left: 0px;
			top: 0px;
			width: 100%;
			height: 100%;
			text-align: center;
			z-index: 1000;
		}
		
		#overlay div {
			width: 300px;
			height: 100px;
			margin: 100px auto;
			background-color: #fff;
			border: 2px solid #000;
			padding: 15px;
			text-align: center;
			font-size: 16px;
			font-weight: bold;
		}
	</style>
</head>
<body>
	<div>
		<p>Welcome ${roy}</p>
		<p><a href="logout">Logout</a></p>
	</div>
	<div id="overlay">
		<div>
			<p>Your session has expired!</p>
			<p>Please <a href="<%=request.getContextPath()%>/login.html">Click Here</a> to go back to Login Page.</p>
			<br />
			<p>You will be automatically redirected after 5 seconds...</p>
		</div>
	</div>
</body>
</html>
