<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Datta Able Free Bootstrap 4 Admin Template</title>
<!-- HTML5 Shim and Respond.js IE11 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 11]>
		<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
<!-- Meta -->
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


	<!-- [ Main Content ] start -->
	<div class="pcoded-main-container">
		<div class="pcoded-wrapper">
			<div class="pcoded-content">
				<div class="pcoded-inner-content">
					<!-- [ breadcrumb ] start -->

					<!-- [ breadcrumb ] end -->
					<div class="main-body">
						<div class="page-wrapper">
							<!-- [ Main Content ] start -->
							<div class="row">

								<!--[ Recent Users ] start-->
								<div class="col-xl-8 col-md-12">
									<div class="card Recent-Users">
										<div class="card-header">
											<h5>지역별 아파트 거래 정보 검색</h5>
										</div>
										<div class="card-block">
											<div class="d-flex justify-content-center bg-light p-3">
												<div class="row">
													<select id="sido" class="col mr-1 custom-select">
														<option value="">선택</option>
													</select>
													<select id="gugun" class="col mr-1 custom-select">
														<option value="">선택</option>
													</select>
													<select id="dong" class="col custom-select">
														<option value="">선택</option>
													</select>
												</div>
											</div>
											<div id="map" style="width: 100%; height: 500px; margin: auto;"></div>
										</div>
									</div>
								</div>
								<!--[ Recent Users ] end-->

								<!-- [ statistics year chart ] start -->
								<div class="col-xl-4 col-md-6">
									<div class="card card-event">
										<div class="card-block">
											<div class="row align-items-center justify-content-center">
												<div class="col">
													<h5 class="m-0">코로나 확진자 수</h5>
												</div>
												<div class="col-auto">
													<label class="label theme-bg2 text-white f-14 f-w-400 float-right">34%</label>
												</div>
											</div>
											<h2 class="mt-3 f-w-300">
												45<sub class="text-muted f-14">Competitors</sub>
											</h2>
											<h6 class="text-muted mt-4 mb-0">You can participate in event</h6>
											<i class="fab fa-angellist text-c-purple f-50"></i>
										</div>
									</div>
									<div class="card">
										<div class="card-block border-bottom">
											<div class="row d-flex align-items-center">
												<div class="col-auto">
													<i class="feather icon-map-pin f-30 text-c-green"></i>
												</div>
												<div class="col">
													<h3 class="f-w-300">주변 상권 정보</h3>
													<span class="d-block text-uppercase">보러가기</span>
												</div>
											</div>
										</div>
										<div class="card-block">
											<div class="row d-flex align-items-center">
												<div class="col-auto">
													<i class="feather icon-sun f-30 text-c-blue"></i>
												</div>
												<div class="col">
													<h3 class="f-w-300">환경 정보</h3>
													<span class="d-block text-uppercase">보러가기</span>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- [ statistics year chart ] end -->
								<!--[social-media section] start-->

								</div>
								<div id="showHouse" class="row"></div>
								<div class="row">
								<!-- [ rating list ] end-->
								<div class="col-xl-8 col-md-12 m-b-30">
									<ul class="nav nav-tabs" id="myTab" role="tablist">
										<li class="nav-item"><a class="nav-link" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="false">Today</a></li>
										<li class="nav-item"><a class="nav-link active show" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="true">This Week</a></li>
										<li class="nav-item"><a class="nav-link" id="contact-tab" data-toggle="tab" href="#contact" role="tab" aria-controls="contact" aria-selected="false">All</a></li>
									</ul>
									<div class="tab-content" id="myTabContent">
										<div class="tab-pane fade" id="home" role="tabpanel" aria-labelledby="home-tab">
											<table class="table table-hover">
												<thead>
													<tr>
														<th>User</th>
														<th>Activity</th>
														<th>Time</th>
														<th>Status</th>
														<th class="text-right"></th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td>
															<h6 class="m-0">
																<img class="rounded-circle m-r-10" style="width: 40px;" src="images/user/avatar-1.jpg" alt="activity-user">Ida Jorgensen
															</h6>
														</td>
														<td>
															<h6 class="m-0">The quick brown fox</h6>
														</td>
														<td>
															<h6 class="m-0">3:28 PM</h6>
														</td>
														<td>
															<h6 class="m-0 text-c-green">Done</h6>
														</td>
														<td class="text-right">
															<i class="fas fa-circle text-c-green f-10"></i>
														</td>
													</tr>

													<tr>
														<td>
															<h6 class="m-0">
																<img class="rounded-circle  m-r-10" style="width: 40px;" src="images/user/avatar-2.jpg" alt="activity-user">Albert Andersen
															</h6>
														</td>
														<td>
															<h6 class="m-0">Jumps over the lazy</h6>
														</td>
														<td>
															<h6 class="m-0">2:37 PM</h6>
														</td>
														<td>
															<h6 class="m-0 text-c-red">Missed</h6>
														</td>
														<td class="text-right">
															<i class="fas fa-circle text-c-red f-10"></i>
														</td>
													</tr>

													<tr>
														<td>
															<h6 class="m-0">
																<img class="rounded-circle  m-r-10" style="width: 40px;" src="images/user/avatar-3.jpg" alt="activity-user">Silje Larsen
															</h6>
														</td>
														<td>
															<h6 class="m-0">Dog the quick brown</h6>
														</td>
														<td>
															<h6 class="m-0">10:23 AM</h6>
														</td>
														<td>
															<h6 class="m-0 text-c-purple">Delayed</h6>
														</td>
														<td class="text-right">
															<i class="fas fa-circle text-c-purple f-10"></i>
														</td>
													</tr>
													<tr>
														<td>
															<h6 class="m-0">
																<img class="rounded-circle  m-r-10" style="width: 40px;" src="images/user/avatar-1.jpg" alt="activity-user">Ida Jorgensen
															</h6>
														</td>
														<td>
															<h6 class="m-0">The quick brown fox</h6>
														</td>
														<td>
															<h6 class="m-0">4:28 PM</h6>
														</td>
														<td>
															<h6 class="m-0 text-c-green">Done</h6>
														</td>
														<td class="text-right">
															<i class="fas fa-circle text-c-green f-10"></i>
														</td>
													</tr>
												</tbody>
											</table>

										</div>
										<div class="tab-pane fade active show" id="profile" role="tabpanel" aria-labelledby="profile-tab">
											<table class="table table-hover">
												<thead>
													<tr>
														<th>User</th>
														<th>Activity</th>
														<th>Time</th>
														<th>Status</th>
														<th class="text-right"></th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td>
															<h6 class="m-0">
																<img class="rounded-circle  m-r-10" style="width: 40px;" src="images/user/avatar-2.jpg" alt="activity-user">Albert Andersen
															</h6>
														</td>
														<td>
															<h6 class="m-0">Jumps over the lazy</h6>
														</td>
														<td>
															<h6 class="m-0">2:37 PM</h6>
														</td>
														<td>
															<h6 class="m-0 text-c-red">Missed</h6>
														</td>
														<td class="text-right">
															<i class="fas fa-circle text-c-red f-10"></i>
														</td>
													</tr>
													<tr>
														<td>
															<h6 class="m-0">
																<img class="rounded-circle m-r-10" style="width: 40px;" src="images/user/avatar-1.jpg" alt="activity-user">Ida Jorgensen
															</h6>
														</td>
														<td>
															<h6 class="m-0">The quick brown fox</h6>
														</td>
														<td>
															<h6 class="m-0">3:28 PM</h6>
														</td>
														<td>
															<h6 class="m-0 text-c-green">Done</h6>
														</td>
														<td class="text-right">
															<i class="fas fa-circle text-c-green f-10"></i>
														</td>
													</tr>
													<tr>
														<td>
															<h6 class="m-0">
																<img class="rounded-circle  m-r-10" style="width: 40px;" src="images/user/avatar-1.jpg" alt="activity-user">Ida Jorgensen
															</h6>
														</td>
														<td>
															<h6 class="m-0">The quick brown fox</h6>
														</td>
														<td>
															<h6 class="m-0">4:28 PM</h6>
														</td>
														<td>
															<h6 class="m-0 text-c-green">Done</h6>
														</td>
														<td class="text-right">
															<i class="fas fa-circle text-c-green f-10"></i>
														</td>
													</tr>
													<tr>
														<td>
															<h6 class="m-0">
																<img class="rounded-circle  m-r-10" style="width: 40px;" src="images/user/avatar-3.jpg" alt="activity-user">Silje Larsen
															</h6>
														</td>
														<td>
															<h6 class="m-0">Dog the quick brown</h6>
														</td>
														<td>
															<h6 class="m-0">10:23 AM</h6>
														</td>
														<td>
															<h6 class="m-0 text-c-purple">Delayed</h6>
														</td>
														<td class="text-right">
															<i class="fas fa-circle text-c-purple f-10"></i>
														</td>
													</tr>
												</tbody>
											</table>

										</div>
										<div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
											<table class="table table-hover">
												<thead>
													<tr>
														<th>User</th>
														<th>Activity</th>
														<th>Time</th>
														<th>Status</th>
														<th class="text-right"></th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td>
															<h6 class="m-0">
																<img class="rounded-circle  m-r-10" style="width: 40px;" src="images/user/avatar-3.jpg" alt="activity-user">Silje Larsen
															</h6>
														</td>
														<td>
															<h6 class="m-0">Dog the quick brown</h6>
														</td>
														<td>
															<h6 class="m-0">10:23 AM</h6>
														</td>
														<td>
															<h6 class="m-0 text-c-purple">Delayed</h6>
														</td>
														<td class="text-right">
															<i class="fas fa-circle text-c-purple f-10"></i>
														</td>
													</tr>
													<tr>
														<td>
															<h6 class="m-0">
																<img class="rounded-circle m-r-10" style="width: 40px;" src="images/user/avatar-1.jpg" alt="activity-user">Ida Jorgensen
															</h6>
														</td>
														<td>
															<h6 class="m-0">The quick brown fox</h6>
														</td>
														<td>
															<h6 class="m-0">3:28 PM</h6>
														</td>
														<td>
															<h6 class="m-0 text-c-green">Done</h6>
														</td>
														<td class="text-right">
															<i class="fas fa-circle text-c-green f-10"></i>
														</td>
													</tr>
													<tr>
														<td>
															<h6 class="m-0">
																<img class="rounded-circle  m-r-10" style="width: 40px;" src="images/user/avatar-2.jpg" alt="activity-user">Albert Andersen
															</h6>
														</td>
														<td>
															<h6 class="m-0">Jumps over the lazy</h6>
														</td>
														<td>
															<h6 class="m-0">2:37 PM</h6>
														</td>
														<td>
															<h6 class="m-0 text-c-red">Missed</h6>
														</td>
														<td class="text-right">
															<i class="fas fa-circle text-c-red f-10"></i>
														</td>
													</tr>
													<tr>
														<td>
															<h6 class="m-0">
																<img class="rounded-circle  m-r-10" style="width: 40px;" src="images/user/avatar-1.jpg" alt="activity-user">Ida Jorgensen
															</h6>
														</td>
														<td>
															<h6 class="m-0">The quick brown fox</h6>
														</td>
														<td>
															<h6 class="m-0">4:28 PM</h6>
														</td>
														<td>
															<h6 class="m-0 text-c-green">Done</h6>
														</td>
														<td class="text-right">
															<i class="fas fa-circle text-c-green f-10"></i>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>

							</div>
							<!-- [ Main Content ] end -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- [ Main Content ] end -->

	<!-- Warning Section Starts -->
	<!-- Older IE warning message -->
	<!--[if lt IE 11]>
        <div class="ie-warning">
            <h1>Warning!!</h1>
            <p>You are using an outdated version of Internet Explorer, please upgrade
               <br/>to any of the following web browsers to access this website.
            </p>
            <div class="iew-container">
                <ul class="iew-download">
                    <li>
                        <a href="http://www.google.com/chrome/">
                            <img src="assets/images/browser/chrome.png" alt="Chrome">
                            <div>Chrome</div>
                        </a>
                    </li>
                    <li>
                        <a href="https://www.mozilla.org/en-US/firefox/new/">
                            <img src="assets/images/browser/firefox.png" alt="Firefox">
                            <div>Firefox</div>
                        </a>
                    </li>
                    <li>
                        <a href="http://www.opera.com">
                            <img src="assets/images/browser/opera.png" alt="Opera">
                            <div>Opera</div>
                        </a>
                    </li>
                    <li>
                        <a href="https://www.apple.com/safari/">
                            <img src="assets/images/browser/safari.png" alt="Safari">
                            <div>Safari</div>
                        </a>
                    </li>
                    <li>
                        <a href="http://windows.microsoft.com/en-us/internet-explorer/download-ie">
                            <img src="assets/images/browser/ie.png" alt="">
                            <div>IE (11 & above)</div>
                        </a>
                    </li>
                </ul>
            </div>
            <p>Sorry for the inconvenience!</p>
        </div>
    <![endif]-->
	<!-- Warning Section Ends -->

	<!-- Required Js -->
	
	<script src="https://unpkg.com/@google/markerclustererplus@4.0.1/dist/markerclustererplus.min.js"></script>
	<script defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCI7ZXYUQYZUXlo26vMCQtYIzTEGrbRb_c&callback=initMap"></script>
	<script>
		var multi = {
			lat : 37.5665734,
			lng : 126.978179
		};
		var map;
		function initMap() {
			map = new google.maps.Map(document.getElementById('map'), {
				center : multi,
				zoom : 12
			});
			var marker = new google.maps.Marker({
				position : multi,
				map : map
			});
		}
		function addMarker(tmpLat, tmpLng, aptName) {
			var marker = new google.maps.Marker({
				position : new google.maps.LatLng(parseFloat(tmpLat),
						parseFloat(tmpLng)),
				label : aptName,
				title : aptName
			});
			marker.addListener('click', function() {
				map.setZoom(17);
				map.setCenter(marker.getPosition());
				callHouseDealInfo(aptName);
			});
			marker.setMap(map);
		}

        $(document).ready(function(){
          $.get("/map/sido"
            ,function(data, status){
              $.each(data, function(index, vo) {
                $("#sido").append("<option value='"+vo.sidoCode+"'>"+vo.sidoName+"</option>");
              });//each
            }//function
            , "json"
          );//get
        });//ready
        $(document).ready(function(){
          $("#sido").change(function() {
            $.get("/map/gugun"
                ,{sido:$("#sido").val()}
                ,function(data, status){
                  $("#gugun").empty();
                  $("#gugun").append('<option value="0">선택</option>');
                  $.each(data, function(index, vo) {
                    $("#gugun").append("<option value='"+vo.gugunCode+"'>"+vo.gugunName+"</option>");
                  });//each
                }//function
                , "json"
            );//get
          });//change
          $("#gugun").change(function() {
            $.get("/map/dong"
                ,{gugun:$("#gugun").val()}
                ,function(data, status){
                  $("#dong").empty();
                  $("#dong").append('<option value="0">선택</option>');
                  $.each(data, function(index, vo) {
                    $("#dong").append("<option value='"+vo.dong+"'>"+vo.dong+"</option>");
                  });//each
                }//function
                , "json"
            );//get
          });//change
          $("#dong").change(function() {
            $.get("/map/apt"
                ,{dong:$("#dong").val()}
                ,function(data, status){
                  $("#searchResult").empty();
                  $("#showHouse").empty();
                  $.each(data, function(index, vo) {
					let str =  '<div class="col-md-12 col-xl-4">'
					+ '<div class="card card-social">'
					+ '<div class="card-block border-bottom">'
					+ '<div class="row align-items-center justify-content-center">'
					+ '<div class="col text-left">'
					+ '<h5>'+vo.aptName+'</h5></div>'
					+ '<div class="col text-right">'
					+ '<h5>'+vo.dong+'</h5>'
					+ '<h5 class="text-c-green mb-0">'
					+ '<span class="text-muted">'+vo.jibun+'</span>'
					+ ' 번지</h5></div></div></div>'
                    + '<div class="card-block">'
					+ '<div class="row align-items-center justify-content-center card-active">'
					+ '<div class="col-6">'						
					+ '<h6 class="text-center m-b-10">'
					+ ' <span class="text-muted m-r-5">면적:</span>'+vo.area+' m2</h6>'
					+ '<div class="progress"><div class="progress-bar progress-c-theme" role="progressbar" style="width: 60%; height: 6px;" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"></div>'
					+ '</div>'
					+ '</div><div class="col-6"><h6 class="text-center  m-b-10">'
					+ '<span class="text-muted m-r-5">금액:</span>'+vo.dealAmount + ' 만원'
					+ '</h6><div class="progress">'
					+ '<div class="progress-bar progress-c-theme2" role="progressbar" style="width: 45%; height: 6px;" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100"></div>'
					+ '</div></div></div></div></div></div>'
                                        
                    $("#showHouse").append(str);
					$("#searchResult").append(vo.dong+" "+vo.aptName+" "+vo.jibun+"<br>");
                  });//each
                  geocode(data);
                }//function
                , "json"
            );//get
          });//change
          
        });//ready
        
        function geocode(jsonData) {
          let idx = 0;
          $.each(jsonData, function(index, vo) {
            let tmpLat;
            let tmpLng;
            $.get("https://maps.googleapis.com/maps/api/geocode/json"
                ,{  key:'AIzaSyCI7ZXYUQYZUXlo26vMCQtYIzTEGrbRb_c'
                  , address:vo.dong+"+"+vo.aptName+"+"+vo.jibun
                }
                , function(data, status) {
                  console.log(vo.dong+"+"+vo.aptName+"+"+vo.jibun);
                  console.log(data);
                  alert(data.results[0].geometry.location.lat);
                  tmpLat = data.results[0].geometry.location.lat;
                  tmpLng = data.results[0].geometry.location.lng;
                  $("#lat_"+index).text(tmpLat);
                  $("#lng_"+index).text(tmpLng);
                  addMarker(tmpLat, tmpLng, vo.aptName);
                  
                }
                , "json"
            );//get
          });//each
        }
        </script>
</body>
</html>
