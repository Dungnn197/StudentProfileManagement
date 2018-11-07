<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile Detail</title>
<meta charset="utf-8"/>
                <meta name="viewport" content="width=device-width, initial-scale=1"/>
                    <link rel="stylesheet" href="./style/css/ClassDetail.css">
                        <link rel="stylesheet"
                            href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
                            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
                            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
            <div class="row">
                <div class="navbar navbar-inverse" role="navigation">
                    <div class="container">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span
                                class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span></button>
                            <a class="navbar-brand" href="#">My Profile</a></div>
                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="#schedule">Schedule</a></li>
                                <li><a href="#course">Course</a></li>
                                <li><a href="#class">Class</a></li>
                                <li><a href="#attendance">Attendance</a></li>
                                <li class="active"><a href="#">My Profile</a></li>
                                <li><a href="#logout">Logout</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div style="margin-left:300px; font-size:30px"><b>Class Detail</b></div>
                
                <div class="div-table">
                    
                    <div class="div-table-body">
                    	<c:forEach items="${classDetails}" var="classDetail">
	                    	<div class="div-table-row">
	                            <div class="div-table-cell">Date:</div>
	                            <div class="div-table-cell">${classDetail.getDate()}</div>
	                        </div>
	                        
	                        <div class="div-table-row">
                            	<div class="div-table-cell">Slot:</div>
                            	<div class="div-table-cell">${classDetail.getSlot()}</div>
                        	</div>
                        	
                        	<div class="div-table-row">
                            	<div class="div-table-cell">Student Group:</div>
                            	<div class="div-table-cell">${classDetail.getGroupName()}</div>
                        	</div>
                        	
                        	<div class="div-table-row">
                           		<div class="div-table-cell">Instructor:</div>
                            	<div class="div-table-cell">${classDetail.getInstructor()}</div>
                        	</div>
                        	
                        	<div class="div-table-row">
                            	<div class="div-table-cell">Course:</div>
                            	<div class="div-table-cell">${classDetail.getCourseName()}</div>
                        	</div>
                        	
                        	<div class="div-table-row">
                            	<div class="div-table-cell">Campus:</div>
                            	<div class="div-table-cell">${classDetail.getCampus()}</div>
                        	</div>
                        	
                        	<div class="div-table-row">
                            	<div class="div-table-cell">Attendence:</div>
                            	<div class="div-table-cell">${classDetail.getPresent()}</div>
                        	</div>
                        	
                    	</c:forEach>
                </div>
              </div>
           </div>
        </body>
</html>