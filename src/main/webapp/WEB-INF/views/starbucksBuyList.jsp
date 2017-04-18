<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" href="favicon.ico">
	<title>星巴克优惠券</title>
	<link rel="stylesheet" href="/static/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="/static/css/test.css">
</head>
<body>
	<!-- offer detail -->
	<div id="offerModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title">星巴克优惠券</h4>
				</div>
				<div class="modal-body">
					<form:form id="prepayform" class="form-horizontal" modelAttribute="couponOrderModel"
						action="/wxPayCoupon/getJSSDKPayInfo" method="post">
						<div class="form-group">
							<label class="control-label col-xs-6" id="pricedesc" for="recipient-name"></label>
							<input type="text" hidden="true" id="couponType"
								name="couponType">
							<input type="text" hidden="true" id="couponBrand"
								name="couponBrand" value="${thisbrand}">
							<input type="text" hidden="true"
								id="token" name="token" value="${token}">
						</div>
						<div class="form-group">
							<div class="col-xs-offset-3 col-xs-9">
								<input type="submit" class="btn btn-primary" value="购买">
								<input type="reset" class="btn btn-default"
									data-dismiss="modal" value="取消">
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<!-- Navbar -->
    <div id="navbar1" class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <span class="navbar-brand" style="color: #fff">星巴克券</span>
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
<div id="container"></div>
<div id="videoPlayer"></div>
<script src="/static/js/jquery.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/js/jquery.form.min.js"></script>
<script type="text/javascript">
function resizeContainer() {
	var navbarHeight = $('#navbar1').height() + 1;
	$('#container')
		.css('top', navbarHeight + 'px')
		.height($(window).height() - navbarHeight);
}

function centerModal() {
    $(this).css('display', 'block');
    var $dialog = $(this).find(".modal-dialog");
    var offset = ($(window).height() - $dialog.height()) / 2;
    $dialog.css("margin-top", offset);
}

function createThumbnail(item) {
	var colors = ["8EB5CF","FFD478","F89D57","D9531E"];
	var bgColor = colors[Math.floor(Math.random() * colors.length)];
	return "<div id='"+item.id+"' data-toggle='modal' data-target='#offerModal' data-coupontype='"+item.id+"' data-couponname='"+item.name+"' style='background-image: url(/static/images/test.jpg)'><span class='label label-primary'>"+item.name+"</span></div>";
}

function updateContainer(containerItems, prepend) {
	prepend ? $('#container').prepend(containerItems) : $('#container').append(containerItems);
	
	$('#container div span').mouseenter(function(){
		var $this = $(this);
		if(this.offsetWidth < this.scrollWidth && !$this.attr('title')){
			$this.attr('title', $this.text());
		}
	});
}

function getData() {
  var newGridViewItems = "";
  newGridViewItems += createThumbnail({id:1001,name:"中杯券"});
  newGridViewItems += createThumbnail({id:1002,name:"大杯券"});
  updateContainer(newGridViewItems, true);
}

$(function() {

	// Resize the thumbnail container
		resizeContainer();
	
	// Center all dialogs on show event
		$('.modal').on('show.bs.modal', centerModal);
	
	// Resize the Thumbnail Container and center dialogs on Window resize event
		$(window).resize(function() {
			resizeContainer();
			$('.modal:visible').each(centerModal);
		});

	// Query the server for new videos and prepend them to the container
		getData();
	
});

$(document).ready(function(){
	$("#offerModal").on('show.bs.modal', function(event){
        var button = $(event.relatedTarget);  // Button that triggered the modal
        $("#pricedesc").html("售价：14元");
        $("#couponType").val(button.data('coupontype'));
	    $(this).find('.modal-title').text("星巴克"+button.data('couponname'));
	});

    var options = {
    	beforeSubmit: showRequest,
        success: onBridgeReady
    };	
    $('#prepayform').ajaxForm(options);


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
   if(!data.result) {
	   alert(data.reason);
	   return false;
   }
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
       	   if(res.err_msg = "get_brand_wcpay_request:ok") {
  	            window.location.href="${pageContext.request.contextPath}/wxredirect/selfCouponList";
       	   }
        }
   ); 
}
});
</script>
</body>
</html>


