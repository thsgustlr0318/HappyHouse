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
                                        <h5 class="m-b-10">공지사항</h5>
                                    </div>
                                    <ul class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="/"><i class="feather icon-home"></i></a></li>
                                        <li class="breadcrumb-item"><a href="#!">notice</a></li>
                                        <li class="breadcrumb-item"><a href="javascript:">list</a></li>
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
                                            <h5>공지사항</h5>
                                            <span class="d-block m-t-5">우리 동네 공지사항 페이지 입니다. <code>꼭!</code> 읽어보세요</span>
                                        </div>
                                        <div class="card-block table-border-style">
                                            <div class="table-responsive">
                                            	<c:if test="${notice.size() != 0}">
												<form method="get" action="${root}/notice/list" id="searchForm" class="navbar mx-sm-2">
													<input type="hidden" name="currentPage" id="currentPage">
                                        			<ul class="nav">
                                            			<li class="nav-item f-text active">
                                                			<a class="nav-link text-secondary" href="#">Filter: <span class="sr-only">(current)</span></a>
                                            			</li>
                                            			<li class="nav-item dropdown mx-sm-2">
                                                			<select name="key" id="key" class="mb-3 form-control">
                                                				<option selected disabled hidden>검색 컬럼</option>
                                                				<option value="userid">글쓴이</option>
                                                				<option value="subject">제목</option>
                                                			</select>
                                            			</li>
                                            			<li class="nav-item dropdown mx-sm-2">
                                               	 			<select name="orderBy" id="orderBy" class="mb-3 form-control">
                                                				<option selected disabled hidden>정렬 컬럼</option>
                                                				<option value="userid">글쓴이</option>
                                                				<option value="subject">제목</option>
                                                				<option value="no">글번호</option>
                                                				<option value="date">작성일</option>
                                                				<option value="hit">조회수</option>
                                                			</select>
                                            			</li>
                                            			<li class="nav-item dropdown mx-sm-2">
                                                			<select name="orderByDir" id="orderByDir" class="mb-3 form-control">
                                                				<option selected disabled hidden>정렬 방향</option>
                                                				<option value="asc">오름차순</option>
                                                				<option value="desc">내림차순</option>
                                                			</select>
                                            			</li>
                                        			</ul>
                                        		<div class="nav-item nav-grid f-view">
                                        			<div class="input-group mb-3">
                                            			<input type="text" name="word" id="word" class="form-control add_task_todo" placeholder="검색어">
                                                		<div class="input-group-append">
                                                    	<button class="btn btn-primary btn-icon btn-msg-send" id="btnSearch" type="button"><i class="fas fa-search"></i></button>
                                                		</div>
                                        			</div>
                                        		</div>
                                    		</form>

												<table class="table table-hover">
                                                    <thead>
                                                        <tr>
                                                            <th>no</th>
                                                            <th>제목</th>
                                                            <th>글쓴이</th>
                                                            <th>조회수</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="notice" items="${notice}">
                                                        	<tr>
                                                        		<th scope="row">${notice.no}</th>
                                                        		<td>${notice.subject}</td>
                                                        		<td>${notice.userid}</td>
                                                        		<td>${notice.hit}</td>
                                                        	</tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                                </c:if>
                                                
                                                <div class="container">
                                        			<div class="row">
                                        				<div class="col-4 col-sm-4 col-md-4"></div>
                                        				<div class="col-4 col-sm-4 col-md-4">
                                        					<%@ include file="/WEB-INF/views/include/paging.jsp"%>
                                        				</div>
                                       					<div class="col-2 col-sm-2 col-md-2"></div>
                                        				<div class="col-1 col-sm-1 col-md-1">
                                        					<button type="button" class="btn btn-primary">글쓰기</button>
                                    					</div>
                                    				</div>
                                    			</div>
                                            </div>

                                            
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
