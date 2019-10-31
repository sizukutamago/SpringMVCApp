<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
		<h2>this is sample page.</h2>
		<p>${msg}</p>

		<form method="post" action="/post">
			<input type="text" name="title">
			<textarea name="content"></textarea><br/>
			<input type="submit">
		</form>
	</body>
</html>
