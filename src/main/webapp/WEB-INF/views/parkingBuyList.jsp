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
$(document).ready(function(){ 
	$("#offerModal").on('show.bs.modal', function(event){
        var button = $(event.relatedTarget);  // Button that triggered the modal
        $("#pricedesc").html("售价："+button.data('price')+"<br/>有效交易时间：当日"+button.data('stime')+"至"+button.data('etime'));
        $("#selectOfferId").val(button.data('offerid'));
	    $(this).find('.modal-title').text('购买车停车券');
	});

    var options = {
    	beforeSubmit: showRequest,
        success: onBridgeReady
    };	
    $('#prepayform').ajaxForm(options);
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
    $('#offerModal').modal('hide');
    $('#processBarModal').modal('show');
    return true; 
}

function onBridgeReady(data){
   WeixinJSBridge.invoke(
       'getBrandWCPayRequest', {
           "appId":data.datum.appId,
           "timeStamp":data.datum.timeStamp,
           "nonceStr":data.datum.nonceStr,
           "package":data.datum.package,   
           "signType":data.datum.signType,
           "paySign":data.datum.paySign
       },
       function(res){
    	   //alert(JSON.stringify(res));
           if(res.err_msg == "get_brand_wcpay_request:ok" ) {
        	   window.location.href="${pageContext.request.contextPath}/wxredirect/selfOrderList";
           } else {
        	    $('#offerModal').modal('hide');
        	    $('#processBarModal').modal('hide');
           }
       }
   ); 
}
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
						<li class="active"><a href="${pageContext.request.contextPath}/wxredirect/parkingBuyList?selectParking=${dictParking.parkingId}">${dictParking.parkingName}</a></li>
					</c:when>   
					<c:otherwise>  
						<li ><a href="${pageContext.request.contextPath}/wxredirect/parkingBuyList?selectParking=${dictParking.parkingId}">${dictParking.parkingName}</a></li>
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
	                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#offerModal" data-offerid="${parkingOffer.offerId}" data-stime="${parkingOffer.startTime}" data-etime="${parkingOffer.endTime}" data-price="${parkingOffer.price}">购买</button>
	                </td>
	            </tr>
            </c:forEach>  
        </tbody>
    </table>
    <!-- offer detail -->
    <div id="offerModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title">购买车停车券</h4>
                </div>
                <div class="modal-body">
                    <form:form id="prepayform" class="form-horizontal" action="/wxPay/getJSSDKPayInfo" method="post">
                        <div class="form-group">
                            <label id="pricedesc" for="recipient-name" class="control-label"></label>
                            <input type="text" hidden="true" id="selectOfferId" name="selectOfferId">
                            <input type="text" hidden="true" id="token" name="token" value="${token}">
                        </div>
	 			        <div class="form-group">
				            <div class="col-xs-offset-3 col-xs-9">
				                <input type="submit" class="btn btn-primary" value="购买">
				                <input type="reset" class="btn btn-default" data-dismiss="modal" value="取消">
				            </div>
				        </div>
                   </form:form>
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
