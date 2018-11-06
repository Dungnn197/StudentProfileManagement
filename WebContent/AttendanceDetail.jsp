<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Profile Management</title>
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/style/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./style/css/bootstrap.min.css">
<link rel="stylesheet" href="./style/css/bootstrap.css">
<link rel="stylesheet" href="./style/css/bootstrap-theme.min.css">
<script src="./style/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./style/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./style/css/attendanceDetail.css">
    
</head>
<body>
	<nav class="navbar navbar-inverse">
	    <div class="container-fluid">
	        <div class="navbar-header">
	            <a class="navbar-brand" href="#">Students Profile Management System</a>
	        </div>
	        
	        <ul class="nav navbar-nav navbar-right">
	            <li><a href="#">Schedule</a></li>
	            <li><a href="#">Course</a></li>
	            <li class="active"><a href="#">Class</a></li>
	            <li><a href="#">Attendance</a></li>
	            <li><a href="#"><span class="glyphicon glyphicon-user"></span> SonNVSE04793</a></li>
	            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
	        </ul>
	    </div>
	</nav>
	
	<div class="row">
		<div class="col-md-8 col-md-offset-1">
	         <ul class="nav navbar-nav w-100">
	         	<form action="CourseServlet" method="GET">
		         	<div class="form-group">
		         		<select class="form-control w-13" name="campus">
		         			<option>FU-HL</option>
		         		</select>
		         		
		         		<select class="form-control w-13" name="semester">
		         			<option>Fall2018</option>
		         		</select>
		         		
		         		<select class="form-control w-13" name="courseId">
		         			<c:forEach items="${courses}" var="course">
		         				<c:choose>
		         					<c:when test="${course.getCourseId() == filteredCourse}">
		         						<option selected>${course.getCourseId()}</option>
		         					</c:when>
		         					<c:otherwise>
		         						<option>${course.getCourseId()}</option>
		         					</c:otherwise>
		         				</c:choose>
							</c:forEach>	                			
		         		</select>
				         		
		         		<select class="form-control w-13" name="groupId">
		         			<c:forEach items="${groups}" var="group">
		         				<c:choose>
		         					<c:when test="${group.getGroupId() == filteredGroup}">
		         						<option selected>${group.getGroupId()}</option>
		         					</c:when>
		         					<c:otherwise>
		         						<option>${group.getGroupId()}</option>
		         					</c:otherwise>
		         				</c:choose>
							</c:forEach>	                			
		         		</select>
		         		
		         		<input class="btn btn-primary" type="submit" value="Show" />
		         	</div>	         	
	         	</form>
	         </ul>
	   </div>
	</div>
	
	<div class="row">
	    <div class="col-md-10 col-md-offset-1">
	        <table class="table table-hover">
	            <thead>
	                <tr>
	                    <th>Student ID</th>
	                    <th>Fullname</th>
	                    <th>Email</th>
	                    <th>Attendance</th>
	                </tr>
	            </thead>
	            <tbody>
	            	<c:forEach items="${studentAttendances}" var="studentAttendance">
		            	<tr>
		            		<td>${studentAttendance.getStudentId()}</td>
		            		<td>${studentAttendance.getFullName()}</td>
		            		<td>${studentAttendance.getEmail()}</td>
		            		<td>
			            		<c:choose>
			            			<c:when test="${studentAttendance.getPresent() == 1}">
			            				<span class="label label-success">Present</span>
			            			</c:when>
			            			<c:otherwise>
			            				<span class="label label-danger">Absent</span>
			            			</c:otherwise>
			            		</c:choose>		            			
	            			</td>
		            	</tr>	            	
	            	</c:forEach>
	            </tbody>
	        </table>
	    </div>
	</div>
</body>
</html>
