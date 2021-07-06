<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload form</title>

<%@include file="/resources/Component_css_js.jsp"  %> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

	<div class="container">
	
	<h1>File Upload Example</h1>
		
		<h3 style="color:red">${filesuccess}</h3>
		
		<form method="post" action="uploadimage" enctype="multipart/form-data">
		<p><label for ="image">Choose Image</label></p>
		<p><input name ="profile" id="uploadfile" type="file"></p>
		<p><input type ="submit" value ="upload"></p>
		</form>
	
	</div>

</body>
</html>