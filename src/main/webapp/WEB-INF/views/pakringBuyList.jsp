<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>停车券列表</title>
<link rel="stylesheet" href="/css/bootstrap.min.css" >
<link rel="stylesheet" href="/css/bootstrap-theme.min.css">
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<style type="text/css">
    .bs-example{
    	margin: 20px;
    }
</style>
</head>
<body>
<div class="bs-example">
    <nav role="navigation" class="navbar navbar-default">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="#" class="navbar-brand">${selectParking.parkingName}</a>
        </div>
        <!-- Collection of nav links and other content for toggling -->
        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
            <c:forEach items="${parkingList}" var="dictParking">  
            	<c:choose>  
					<c:when test="${dictParking.parkingId == selectParking.parkingId}">  
						<li class="active"><a href="${pageContext.request.contextPath}?selectParking=${dictParking.parkingId}">${dictParking.parkingName}</a></li>
					</c:when>   
					<c:otherwise>  
						<li ><a href="${pageContext.request.contextPath}?selectParking=${dictParking.parkingId}">${dictParking.parkingName}</a></li>
					</c:otherwise>  
				</c:choose>  
            </c:forEach>  
            </ul>
        </div>
    </nav>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>创建时间</th>
                <th>卖家描述</th>
                <th>价格</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${offerList}" var="parkingOffer">  
	            <tr>
	                <td><fmt:formatDate value='${parkingOffer.createTime}' type='date' pattern='yyyy-MM-dd HH:mm:SS'/></td>
	                <td>${parkingOffer.detail}</td>
	                <td>${parkingOffer.price}</td>
	            </tr>
            </c:forEach>  
        </tbody>
    </table>
</div>
</body>
</html>                                		
