<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>我购买的停车券</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/bootstrap-theme.min.css">
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery.form.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){ 
	$("#confirmModal").on('show.bs.modal', function(event){
        var button = $(event.relatedTarget);  // Button that triggered the modal
        $("#pricedesc").html("售价："+button.data('price')+"<br/>有效交易时间：当日"+button.data('stime')+"至"+button.data('etime'));
        $("#selectOrderId").val(button.data('orderid'));
	    $(this).find('.modal-title').text('确认收货');
	});
    var options = {
    	beforeSubmit: showRequest,
        success: orderConfirmCallBack
    };	
    $('#confirmform').ajaxForm(options);
});

//pre-submit callback 
function showRequest(formData, jqForm, options) { 
    // formData is an array; here we use $.param to convert it to a string to display it 
    // but the form plugin does this for you automatically when it submits the data 
    //var queryString = $.param(formData); 
    // jqForm is a jQuery object encapsulating the form element.  To access the 
    // DOM element for the form do this: 
    // var formElement = jqForm[0]; 
    //alert('About to submit: \n\n' + queryString); 
    // here we could return false to prevent the form from being submitted; 
    // returning anything other than false will allow the form submit to continue
    $('#confirmModal').modal('hide');
    $('#processBarModal').modal('show');
    return true; 
}

function orderConfirmCallBack(res){
     if(res.result) {
  	   window.location.href="${pageContext.request.contextPath}/wxredirect/selfOrderList";
     } else {
  	    $('#processBarModal').modal('hide');
  	    alert(res.reason);
     }
}
</script>
<style type="text/css">
.bs-body {
	margin: 20px;
}
</style>
</head>
<body>
	<div class="bs-body">
		<ul class="nav nav-tabs">
			<li><a
				href="${pageContext.request.contextPath}/wxredirect/selfOfferList">我发布的停车券</a></li>
			<li class="active"><a
				href="${pageContext.request.contextPath}/wxredirect/selfOrderList">我购买的停车券</a></li>
		</ul>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>成交时间</th>
					<th>停车场</th>
					<th>状态</th>
					<th>价格(元)</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${orderList}" var="parkingOrder">
					<tr class="info">
						<td><fmt:formatDate value='${parkingOrder.createTime}'
								type='date' pattern='yyyy-MM-dd HH:mm:SS' /></td>
						<td>${parkingOffer.parkingName}</td>
						<td><c:choose>
								<c:when test="${parkingOrder.orderStatus == 0}">未支付</c:when>
								<c:when test="${parkingOrder.orderStatus == 1}">已支付</c:when>
								<c:when test="${parkingOrder.orderStatus == 3}">交易成功</c:when>
								<c:when test="${parkingOrder.orderStatus == 4}">交易失败</c:when>
							</c:choose></td>
						<td>${parkingOrder.paidAmount}(元)</td>
						<td><c:choose>
								<c:when test="${parkingOrder.orderStatus == 1}">
									<button type="button" class="btn btn-primary"
										data-toggle="modal" data-target="#confirmModal"
										data-orderid="${parkingOrder.orderId}">确认收货</button>
								</c:when>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- Modal HTML -->
		<div id="confirmModal" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<form:form id="confirmform" class="form-horizontal"
						action="/innerweb/orderConfirm" method="post">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title">确认交易成功</h4>
						</div>
						<div class="modal-body">
							<p>是否确认交易已完成？</p>
							<p class="text-warning">
								<small>确认后，钱款会自动转给卖家，不可退回</small>
							</p>
							<input type="text" hidden="true" id="selectOrderId"
								name="selectOrderId">
						</div>
						<div class="modal-footer">
							<input type="submit" class="btn btn-primary" value="确认">
							<input type="reset" class="btn btn-default" data-dismiss="modal"
								value="关闭">
						</div>
					</form:form>
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
