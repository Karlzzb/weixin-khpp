<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<script src="/js/jquery.form.min.js"></script>
<script type="text/javascript">

</script>
<style type="text/css">
    .bs-body{
    	margin: 20px;
    }
</style>
</head>
<body>
<div class="bs-body">
	<ul class="nav nav-tabs">
        <li><a href="${pageContext.request.contextPath}/wxredirect/selfOfferList">我发布的停车券</a></li>
        <li class="active"><a href="${pageContext.request.contextPath}/wxredirect/selfOrderList">我购买的券</a></li>
	</ul>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>成交时间</th>
                <th>停车场</th>
                <th>状态</th>
                <th>价格(元)</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${orderList}" var="parkingOrder">  
	            <tr class="info">
	                <td>
	                <fmt:formatDate value='${parkingOrder.createTime}' type='date' pattern='yyyy-MM-dd HH:mm:SS'/>
	                </td>
	                <td>${parkingOffer.parkingName}</td>
	                <td>
	            	<c:choose>  
						<c:when test="${parkingOrder.orderStatus == 0}">已提交（未支付）</c:when>
						<c:when test="${parkingOrder.orderStatus == 1}">已支付</c:when>
						<c:when test="${parkingOrder.orderStatus == 3}">交易成功</c:when>
						<c:when test="${parkingOrder.orderStatus == 4}">交易失败</c:when>   
					</c:choose> 	                
	                </td>
	                <td>${parkingOrder.paidAmount}(元)</td>
	            </tr>
            </c:forEach>  
        </tbody>
    </table>
</div>
</body>
</html>                                		
