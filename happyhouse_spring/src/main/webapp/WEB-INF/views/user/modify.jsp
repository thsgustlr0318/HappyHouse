<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Datta Able Free Bootstrap 4 Admin Template</title>
    <!-- HTML5 Shim and Respond.js IE10 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 10]>
		<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>

<body>
    <!-- [ Pre-loader ] start -->
    <div class="loader-bg">
        <div class="loader-track">
            <div class="loader-fill"></div>
        </div>
    </div>
    <!-- [ Pre-loader ] End -->

	<%@ include file="/WEB-INF/views/include/nav.jsp"%>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<div class="auth-wrapper">
        <div class="auth-content">
            <div class="auth-bg">
                <span class="r"></span>
                <span class="r s"></span>
                <span class="r s"></span>
                <span class="r"></span>
            </div>
            <form method="post" action="/user/modify" id="joinForm">
            <div class="card">
                <div class="card-body text-center">
                    <div class="mb-4">
                        <i class="feather icon-user-plus auth-icon"></i>
                    </div>
                    <h3 class="mb-4">회원 정보 수정</h3>
                    <div class="input-group mb-3">
                        <input type="text" name="userid" id="userid" class="form-control" value="${userinfo.userid}" disabled>
                    </div>
                    <div class="input-group mb-3">
                        <input type="email" name="email" id="email" class="form-control" placeholder="E-mail" value="${userinfo.email}">
                    </div>
                    <div class="input-group mb-4">
                        <input type="password" name="userpwd" id="userpwd" class="form-control" placeholder="Password" value="${userinfo.userpwd}">
                    </div>
                    <div class="input-group mb-3">
                        <input type="text" name="username" id="username" class="form-control" placeholder="User Name" value="${userinfo.username}">
                    </div>
                    <div class="input-group mb-3">
                        <input type="text" name="cellphone" id="cellphone" class="form-control" placeholder = "전화번호" value="${userinfo.cellphone}">
                    </div>
                    <div class="input-group mb-3">
                        <input type="text" name="address" id="address" class="form-control" placeholder="Click!" value="${userinfo.address}">
                    </div>
                    <div class="form-group text-left">
                        <div class="checkbox checkbox-fill d-inline">
                            <input type="checkbox" name="checkbox-fill-1" id="checkbox-fill-1" checked="">
                            <label for="checkbox-fill-1" class="cr"> Save Details</label>
                        </div>
                    </div>
                    <div class="form-group text-left">
                        <div class="checkbox checkbox-fill d-inline">
                            <input type="checkbox" name="checkbox-fill-2" id="checkbox-fill-2">
                            <label for="checkbox-fill-2" class="cr">Send me the <a href="#!"> Newsletter</a> weekly.</label>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary shadow-2 mb-4">Sign up</button>
                    <p class="mb-0 text-muted">Allready have an account? <a href="${root}/user/login"> Log in</a></p>
                </div>
            </div>
            </form>
        </div>
    </div>
<script>
function DaumPostcode() {
	new daum.Postcode({
        oncomplete: function(data) {
            var roadAddr = data.roadAddress;
            var extraRoadAddr = '';

            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }

            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }

            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            document.getElementById("address").value = roadAddr+data.jibunAddress;

            if(roadAddr !== ''){
                document.getElementById("address").value = roadAddr+extraRoadAddr;
            } 
        }
    }).open();
}  

$(document).on("click","#address", function(){
	DaumPostcode();
});

</script>
</body>