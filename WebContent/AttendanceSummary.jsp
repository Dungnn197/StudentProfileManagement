<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="style/js/bootstrap.min.js"></script>
<script src="./style/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="./style/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="./style/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="./style/css/bootstrap-theme.min.css" />
<link rel="stylesheet" type="text/css"
	href="./style/css/StyleAttendanceSummary.css" />
</head>
<body>
	<div class="row">
		<div class="navbar navbar-inverse" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Students Profile Management
						System </a>
				</div>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="Timetable.xml">Timetable</a></li>
						<li><a href="#course">Course</a></li>
						<li class="active"><a href="#attendance">Attendance</a></li>
						<li><a href="MyProfile.xml"> <span
								class="glyphicon glyphicon-user"> My Profile</span>
						</a></li>
						<li><a href="#logout"> <span
								class="glyphicon glyphicon-log-in"> Logout</span>
						</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div>
		<form action="AttendanceSummaryServlet" method="GET">
			<select name="courseId">
				<c:forEach items="${courses}" var="course">
					<c:choose>
						<c:when test="${course.getCourseId() == selectedCourse}">
							<option value="${course.getCourseId()}" selected>${course.getCourseName()}</option>
						</c:when>
						<c:otherwise>
							<option value="${course.getCourseId()}">${course.getCourseName()}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>



			<div class="table_info_student">
				<table>
					<tr class="header_table">
						<td>No</td>
						<td>Date</td>
						<td>Slot</td>
						<td>Lecture</td>
						<td>Group Name</td>
						<td>Attendance Status</td>
					</tr>
					<c:forEach items="${allAtt}" var="arr">
						<tr>
							<td class="count">
							<td>${arr.getAttendance_Date_Id()}</td>
							<td>${arr.getAttendance_Slot()}</td>
							<td>${arr.getAttendance_Lecture()}</td>
							<td>${arr.getAttendance_GroupName()}</td>
							<td><c:if test="${arr.getAttendance_Status()==1}">
									<span style="color: green">Present</span>
								</c:if> <c:if test="${arr.getAttendance_Status()==0}">
									<span style="color: red">Absent</span>
								</c:if> <c:if test="${arr.getAttendance_Status()==2}">
									<span>Future</span>
								</c:if></td>
						</tr>
					</c:forEach>
				</table>
				<br />
				<h4>
					ABSENT: <span style="color: red">${percent}%</span> ABSENT SO FAR
					(${absent.size()} ABSENT ON ${total.size()} TOTAL).
				</h4>
			</div>
			</br> <input type="submit" value="Show all" name="btAll"
				onclick="myFunction()" /> <input type="submit" value="Present"
				name="btPresent" onclick="myFunction()" /> <input type="submit"
				value="Absent" name="btAbsent" onclick="myFunction()" />
		</form>
	</div>
</body>
</html>