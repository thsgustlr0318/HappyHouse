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
    <section class="pcoded-main-container">
        <div class="pcoded-wrapper">
            <div class="pcoded-content">
                <div class="pcoded-inner-content">
                    <!-- [ breadcrumb ] start -->
                    <div class="page-header">
                        <div class="page-block">
                            <div class="row align-items-center">
                                <div class="col-md-12">
                                    <div class="page-header-title">
                                        <h5 class="m-b-10">아파트 정보</h5>
                                    </div>
                                    <ul class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="/"><i class="feather icon-home"></i></a></li>
                                        <li class="breadcrumb-item"><a href="#!">apartment</a></li>
                                        <li class="breadcrumb-item"><a href="javascript:">search</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- [ breadcrumb ] end -->
                    <div class="main-body">
                        <div class="page-wrapper">
                            <!-- [ Main Content ] start -->
                            <div class="row">
                                <!-- [ Hover-table ] start -->
                                <div class="col-xl-12">
                                    <div class="card">
                                        <div class="card-header">
                                            <h5>아파트 이름별 검색</h5>
                                            <span class="d-block m-t-5">원하는 아파트의 <code>이름</code>을 검색해보세요!</span>
                                        </div>
										<div class="card-block table-border-style">
											<form method="get" action="/searchByName" id="searchForm">
												<div class="input-group col-md-4 mb-3 ">
													<input type="text" name="name" id="name"
														class="form-control add_task_todo" placeholder="검색어">
													<div class="input-group-append">
														<button class="btn btn-primary btn-icon btn-msg-send"
															id="btnSearch" type="submit">
															<i class="fas fa-search"></i>
														</button>
													</div>
												</div>
											</form>
											<c:if test="${apt.size() != 0}">
												<table class="table table-hover">
                                                    <thead>
                                                        <tr>
                                                            <th>주소</th>
                                                            <th>거래 가격</th>
                                                            <th>설립 년도</th>
                                                            <th>거래 일자</th>
                                                            <th>면적 (m2)</th>
                                                            <th>층 수</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="apt" items="${apt}">
                                                        	<tr>
                                                        		<th scope="row">${apt.dong}</th>
                                                        		<td>${apt.dealAmount}</td>
                                                        		<td>${apt.buildYear}</td>
                                                        		<td>${apt.dealYear}</td>
                                                        		<td>${apt.area}</td>
                                                        		<td>${apt.floor}</td>
                                                        	</tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                                </c:if>
										</div>

									</div>
                                </div>
                                <!-- [ Hover-table ] end -->
                            </div>
                            <!-- [ Main Content ] end -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
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

	<script>

		function setSearchCondition() {
			console.log("${searchCondition}")
			selectOptionByValue("orderBy", "${searchCondition.orderBy}");
			selectOptionByValue("orderByDir", "${searchCondition.orderByDir}");
			selectOptionByValue("key", "${searchCondition.key}");
			document.querySelector("#word").value = "${searchCondition.word}"
			document.querySelector("#currentPage").value = "${searchCondition.currentPage}"
		}

		// 화면 정보를 설정한다.
		setSearchCondition();

		// <select>요소에서 value 기준으로 <option>을 선택한다.
		function selectOptionByValue(selectId, value) {
			let select = document.querySelector("#" + selectId)
			let opts = select.options;
			for (let i = 0; i < opts.length; i++) {
				if (opts[i].value == value) {
					select.selectedIndex = i;
					break;
				}
			}
		}
		function movePage(page) {
			// currentPage에 전달받은 page를 저장한다.
			document.querySelector("#currentPage").value = page;
			// searchForm을 submit 시킨다.
			document.querySelector("#searchForm").submit();
		}

		// btnSearch가 클릭되면 currentPage를 1로 해서 검색 조건으로 검색한다.
		document.querySelector("#btnSearch").addEventListener("click",
			function() {movePage(1);})
	</script>
    <!-- Required Js -->

</body>
</html>
