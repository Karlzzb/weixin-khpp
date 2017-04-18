<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>我的星巴克券</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/bootstrap-theme.min.css">
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery.form.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){ 
	$("#messageModal").on('show.bs.modal', function(event){
        var button = $(event.relatedTarget);  // Button that triggered the modal
        $("#qrimg").attr("src","${pageContext.request.contextPath}/wxredirect/couponqrpage?orderId="+button.data('couponid'));
	    $(this).find('.modal-title').text('二维码');
	});
});
</script>
<style type="text/css">
.bs-body {
	margin: 20px;
}
</style>
</head>
<body>
	<div class="bs-body">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>成交时间</th>
					<th>状态</th>
					<th>价格(元)</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${couponOrderList}" var="couponOrder">
					<c:choose>
						<c:when test="${couponOrder.orderStatus == 0}">
							<tr class="danger">
								<td><fmt:formatDate value='${couponOrder.createTime}'
										type='date' pattern='yyyy-MM-dd HH:mm:SS' /></td>
								<td>支付失败</td>
								<td>${couponOrder.paidAmount}(元)</td>
								<td>
								</td>
							</tr>						
						</c:when>
						<c:when test="${couponOrder.orderStatus == 3}">
							<tr class="active">
								<td><fmt:formatDate value='${couponOrder.createTime}'
										type='date' pattern='yyyy-MM-dd HH:mm:SS' /></td>
								<td>已支付</td>
								<td>${couponOrder.paidAmount}(元)</td>
								<td>
									<button type="button" class="btn btn-info btn-sm"
										data-toggle="modal" data-target="#messageModal"
										data-couponid="${couponOrder.couponOrderId}">获取二维码</button>
								</td>
							</tr>						
						</c:when>
						<c:when test="${couponOrder.orderStatus == 4}">
							<tr class="warning">
								<td><fmt:formatDate value='${couponOrder.createTime}'
										type='date' pattern='yyyy-MM-dd HH:mm:SS' /></td>
								<td>交易失败</td>
								<td>${couponOrder.paidAmount}(元)</td>
								<td>
								</td>
							</tr>						
						</c:when>
					</c:choose>					
				</c:forEach>
			</tbody>
		</table>
		<!-- Modal HTML -->
		<div id="messageModal" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title">您的优惠券</h4>
						</div>
						<div class="modal-body">
						<div class="thumbnail">
							<img id="qrimg" name="qrimg" class="img-rounded" alt="Rounded Image" src="">
						</div>
						</div>
				</div>
			</div>
		</div>
		<!-- process bar -->
		<div id="processBarModal" class="modal fade">
			<div class="modal-dialog">
				<div class="progress progress-striped active">
					<div class="progress-bar" style="width: 80%;">
						<span class="sr-only">80% Complete</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
