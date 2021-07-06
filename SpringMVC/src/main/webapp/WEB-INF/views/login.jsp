<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="/resources/Component_css_js.jsp"  %> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


 <link rel="stylesheet"  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</head>
<body>




 <div class="container">
	<div class="row">
		<div class="col-md-4">
		</div>
		<div class="col-md-4 border shadow-sm bg-light" style="margin-top:8%;padding:10px;">
			<div class="form-group">
				<label>Enter Username :</label>
				<input type="email" class="form-control" id="user" placeholder="Enter username" autocomplete="off" name="">
				<span id="userMsg"></span>
			</div>

			<div class="form-group">
				<label>Enter Password:</label>
				<input type="password" class="form-control" id="pass" placeholder="Enter password" autocomplete="off" name="">
				<span id="passMsg"></span>
			</div>

			<div class="form-group">
				<input type="button" id="submit"  onclick="loginValidate()" value="Login">
			</div>
			
			<div class="form-group">
				<p><label for="image">Choose Image</label></p>  
				<p><input name="file" id="fileToUpload" type="file" /></p>  
				<p><input type="submit" onclick="savefile()" value="Upload"></p>  
			</div>
		</div>
		<div class="col-md-4">
		</div>
	</div>
</div>
 
 


<script type="text/javascript">

function loginValidate(){
	
	var username =$("#user").val();
	var password = $("#pass").val();
	

 $.ajax({
	type : 'POST',
	url  : 'addUser',
	data : {"username":username,"password":password},
success :function(msg){
	if(msg =="****"){
		
		toastr.success("login success")
	}
	else{
		toastr.error("Error login");
	}
}
}); 


}


function savefile(){
	
	var file = $("#savefile").val();
	
	$ajax({
	type : 'POST',
	url :'savefile',
	data:{"file":file},
	success :function(msg){
		if(msg =="****"){
			
			toastr.success("login success")
		}
		else{
			toastr.error("Error login");
		}
	}
	}); 
	
	
}




</script>
</body>
</html>