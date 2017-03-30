<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>出售停车券</title>
<link rel="stylesheet" href="/static/css/bootstrap.min.css">
<link rel="stylesheet" href="/static/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="/static/css/bootstrap-datetimepicker.min.css">
<script src="/static/js/jquery.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="/static/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript">
$(document).ready(function(){ 
	$('#parkingSelect').change(function(){ 
		var definedPrice = $(this).children('option:selected').attr("price");
		$("#definedPrice").val(definedPrice);
	})
	$("#parkingSelect").trigger("change");
	$("#validStartTimeDiv").datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		forceParse: 0,
        showMeridian: 1,
        startDate: "${parkingOfferModel.validStartTimeFormat}",
	 });
	$("#validEndTimeDiv").datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		forceParse: 0,
        showMeridian: 1,
        startDate: "${parkingOfferModel.validStartTimeFormat}",
     });
})
</script>
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
    <h2>停车券发布</h2>
    <form:form  class="form-horizontal" modelAttribute="parkingOfferModel" action="/innerweb/parkingOfferSubmit">
        <div class="form-group">
            <label class="control-label col-xs-3" for="firstName">选择停车场:</label>
            <div class="col-xs-9">
                <form:select id="parkingSelect" class="form-control"  path="parkingId"  >
		            <c:forEach items="${parkingList}" var="dictParking">
		            	<option price="${dictParking.definedPrice}" value="${dictParking.parkingId}">${dictParking.parkingName}</option>   
		            </c:forEach>  
                </form:select>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3" for="lastName">价格(元):</label>
            <div class="col-xs-9">
                <form:input id="definedPrice" readonly="true" class="form-control" path="price"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-6" for="lastName">交易时间（开始）：</label>
            <div class="col-xs-8">
			    <div id="validStartTimeDiv" class="input-group date form_datetime col-md-1" data-date="" data-date-format="yyyy-mm-dd hh:ii:ss" data-link-field="dtp_input1">
                    <input id="validStartTime" name="validStartTime" class="form-control" size="16" type="text" value="${parkingOfferModel.validStartTimeFormat}" readonly>
					<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                </div>
			</div>
		</div>
		
        <div class="form-group">
            <label class="control-label col-xs-6" for="lastName">交易时间（结束）：</label>
            <div class="col-xs-8">
            
			    <div id="validEndTimeDiv" class="input-group date form_datetime col-md-5" data-date="" data-date-format="yyyy-mm-dd hh:ii:ss" data-link-field="dtp_input1">
                    <input id="validEndTime" name="validEndTime" class="form-control" size="16" type="text" value="${parkingOfferModel.validEndTimeFormat}" readonly>
					<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                </div>
			</div>
		</div>		

		
        <div class="form-group">
            <div class="col-xs-offset-3 col-xs-9">
                <input type="submit" class="btn btn-primary" value="发布">
                <input type="reset" class="btn btn-default" value="充填">
            </div>
        </div>
    </form:form>
</div>
</body>
</html>                              		
