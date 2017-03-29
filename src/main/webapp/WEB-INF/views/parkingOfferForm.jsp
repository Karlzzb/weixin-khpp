<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>出售停车券</title>
<link rel="stylesheet" href="/static/css/bootstrap.min.css">
<link rel="stylesheet" href="/static/css/bootstrap-theme.min.css">
<script src="/static/js/jquery.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<style type="text/css">
    h1{
        margin: 30px 0;
        padding: 0 200px 15px 0;
        border-bottom: 1px solid #E5E5E5;
    }
	.bs-example{
    	margin: 20px;
    }
</style>
</head>
<body>
<div class="bs-example">
    <h1>Registration Form</h1>
    <form:form  class="form-horizontal" modelAttribute="ParkingOfferModel" action="parkingOfferSubmit">
        <div class="form-group">
            <label class="control-label col-xs-3" for="firstName">选择停车场:</label>
            <div class="col-xs-9">
                <form:select class="form-control"  path="parkingId"  >
                	<form:options  items="${parkingList}"   itemValue="parkingId" itemLabel="parkingName"/>
                </form:select>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3" for="lastName">价格(元):</label>
            <div class="col-xs-9">
                <form:input class="form-control" path="price"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3" for="postalAddress">描述:</label>
            <div class="col-xs-9">
                <form:textarea rows="3" class="form-control" path="detail"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-xs-offset-3 col-xs-9">
                <input type="submit" class="btn btn-primary" value="Submit">
                <input type="reset" class="btn btn-default" value="Reset">
            </div>
        </div>
    </form:form>
</div>
</body>
</html>                              		
