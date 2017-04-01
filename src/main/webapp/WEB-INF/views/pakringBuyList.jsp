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
<script type="text/javascript">
$(document).ready(function(){ 
	$("#myModal").on('show.bs.modal', function(event){
        var button = $(event.relatedTarget);  // Button that triggered the modal
        $("#pricedesc").html("售价："+button.data('price')+"<br/>有效交易时间：当日"+button.data('stime')+"至"+button.data('etime'));
	    $(this).find('.modal-title').text('购买车停车券');
	});	
})
</script>
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
						<li class="active"><a href="${pageContext.request.contextPath}/innerweb/pakringBuyList?selectParking=${dictParking.parkingId}">${dictParking.parkingName}</a></li>
					</c:when>   
					<c:otherwise>  
						<li ><a href="${pageContext.request.contextPath}/innerweb/pakringBuyList?selectParking=${dictParking.parkingId}">${dictParking.parkingName}</a></li>
					</c:otherwise>  
				</c:choose>  
            </c:forEach>  
            </ul>
        </div>
    </nav>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>交易时间（始~末）</th>
                <th>卖家</th>
                <th>价格(元)</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${offerList}" var="parkingOffer">  
	            <tr class="info">
	                <td>
	                <fmt:formatDate value='${parkingOffer.validStartTime}' type='date' pattern='HH:mm:SS'/>
	                                                 至
	                <fmt:formatDate value='${parkingOffer.validEndTime}' type='date' pattern='HH:mm:SS'/>
	                </td>
	                <td>${parkingOffer.wxNickName}</td>
	                <td>${parkingOffer.price}(元)</td>
	                <td>
	                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" data-stime="${parkingOffer.startTime}" data-etime="${parkingOffer.endTime}" data-price="${parkingOffer.price}">购买</button>
	                </td>
	            </tr>
            </c:forEach>  
        </tbody>
    </table>
    <!-- Modal HTML -->
    <div id="myModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title">购买车停车券</h4>
                </div>
                <div class="modal-body">
                    <form role="form">
                        <div class="form-group">
                            <label id="pricedesc" for="recipient-name" class="control-label"></label>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary">购买</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>                                		
