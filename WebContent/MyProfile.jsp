<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Profile Detail</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="style/js/bootstrap.min.js"></script>
<script src="./style/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./style/css/bootstrap.min.css" />
<link rel="stylesheet" href="./style/css/bootstrap.css" />
<link rel="stylesheet" href="./style/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="./style/css/my_profile.css" />
</head>
<body>
    <div class="row">
        <div class="navbar navbar-inverse" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle"
                        data-toggle="collapse"
                        data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation </span>
                        <span class="icon-bar"></span> <span
                            class="icon-bar"></span> <span
                            class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Students
                        Profile Management System </a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="Timetable.xml">Timetable</a></li>
                        <li><a href="#course">Course</a></li>
                        <li><a href="AttendanceSummary.xml">Attendance</a>
                        </li>
                        <li class="active"><a href="#"> <span
                                class="glyphicon glyphicon-user"></span>
                                ${student.getProfileName()}
                        </a></li>
                        <li><a href="#logout"> Logout </a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="container-fluid">
            <div class="col-sm-3 col-md-6 col-lg-4">
                <img class="img-responsive profile-image"
                    src="images/empty_profile_image.png"
                    alt="Profile Image" />
            </div>
            <div class="col-sm-9 col-md-6 col-lg-8">
                <div class="div-table">
                    <div class="div-table-body">
                        <div class="div-table-row">
                            <div
                                class="div-table-cell div-table-cell-heading">
                                Student ID</div>
                            <div class="div-table-cell">${student.getStudentId()}</div>
                        </div>
                        <div class="div-table-row">
                            <div
                                class="div-table-cell div-table-cell-heading">
                                Full name</div>
                            <div class="div-table-cell">${student.getFullName()}</div>
                        </div>
                        <div class="div-table-row">
                            <div
                                class="div-table-cell div-table-cell-heading">
                                Student Email</div>
                            <div class="div-table-cell">${student.getEmail()}</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>