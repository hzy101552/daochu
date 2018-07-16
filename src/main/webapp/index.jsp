<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript" src="js/user.js"></script>
</head>
<body>
	<h2>Hello World!</h2>
	<form id="export" action="t">
		<table width="400px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="160px">学号：</td>
				<td><input type="text" id="name" name="name"
					value="${user.name }"></td>
			</tr>
			<tr>
				<td width="160px">姓名：</td>
				<td><input type="text" id="sex" name="sex" value="${user.sex }"></td>
			</tr>
			<tr>
				<td width="160px">确认密码：</td>
				<td><input type="text" name="age" id="age" value="${user.age }"
					size="22"></td>
			</tr>
		</table>
		<input class="btn" type="submit" id="deviceExport" value="修改">
	</form>
	
	<form id="upavi" action="user/upavi" method="post"
		enctype="multipart/form-data">
		<table border="1" align="center">
			<tr>
				<td width="120px" height="120px">111111111111111111111111111111111111111111111111111111111111111</td>
				<td ><embed src="/file/sample.mp4" width="120px" height="120px" play="false" flashvars="autoplay=false&play=false"></td>
				<td ><img src="/file/sample.mp4" width="120px" height="120px"></td>
				<td >
					<object id="mPlayer1" width="120px" height="120px">
						<param name="URL" value="/file/sample.mp4"/>
						<param name="autoStart" value="0"/>
					</object>
				</td>
			</tr>
			<tr>
				<td width="120px" height="10px">1</td>
				<td width="120px" height="10px">2</td>
				<td width="120px" height="10px">3</td>
				<td width="120px" height="10px">4</td>
			</tr>
		</table>
		<div style="font-size: 12;color: red;">${error1}</div>
		<br>
		<input type="file" name="mFile" /> <input type="submit" value="上传视频" />
	</form>
</body>
</html>
