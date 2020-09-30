<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>Registered User Info | home</title>

<link href="static/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/welcome" class="navbar-brand">Tut-Ocean</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/login">Login</a></li>
					<li><a href="/register">New Registration</a></li>
					<c:if test="${logInUser.username=='pankajnegi113.pn@gmail.com'}">
						<li><a href="/show-users">All Users</a></li>
					</c:if>
					<li>${logInUser.username}</li>
				</ul>
			</div>
		</div>
	</div>

    
	<div class="container" id="homediv">
		<div class="jumbotron text-center">
			<h1>Hello  ${logInUser.firstname} ${logInUser.lastname}</h1> 
		</div>
	</div>
	

	<form class="container" action="save-video" method="POST">
		  <div class="col-xs-4">
		    <label for="exampleInputEmail1">Video Embedded URL</label>
		    <input type="text" class="form-control" name="iFrame" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter URL">
		  </div>
		  <div class="col-xs-4">
		    <label for="exampleInputPassword1">Video Title</label>
		    <input type="text" class="form-control" name="videoName" id="exampleInputPassword1" placeholder="Enter Video Title">
		  </div>
		  <div class="col-xs-4" style="margin-top:2%">
		  	<button type="submit" class="btn btn-primary">Submit</button>
		  </div>
	</form>
	<br>
	<div class="container text-center">
		<c:forEach items="${videoSet}" var="video" >
			<div class="alert alert-success" style="width:60%">
				<h4>${video.videoName}</h4>
			</div>
				${video.iFrame}
			<br>
			<br>
			<br>
			<br>
		</c:forEach>
			
	</div>

<script src="static/js/jquery-1.11.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>