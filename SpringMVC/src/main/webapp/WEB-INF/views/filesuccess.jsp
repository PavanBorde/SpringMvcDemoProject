<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
  <%@ page isELIgnored="false" %>  <!-- enable message -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>File Uploaded Result</title>
</head>
<body>
	<h1>${message}</h1>
	<h3 style="color:red">${filename}</h3>
	<!--to show uploaded image  -->
	<img alt="profile image" src="${filename}" >
</body>
</html>