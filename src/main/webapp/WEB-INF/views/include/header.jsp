<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!-- [ Header ] start -->
    <header class="navbar pcoded-header navbar-expand-lg navbar-light">
        <div class="m-header">
            <a class="mobile-menu" id="mobile-collapse1" href="javascript:"><span></span></a>
            <a href="/" class="b-brand">
                   <div class="b-bg">
                       <i class="feather icon-trending-up"></i>
                   </div>
                   <span class="b-title">Datta Able</span>
               </a>
        </div>
        <a class="mobile-menu" id="mobile-header" href="javascript:">
            <i class="feather icon-more-horizontal"></i>
        </a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav mr-auto">
                <li><a href="javascript:" class="full-screen" onclick="javascript:toggleFullScreen()"><i class="feather icon-maximize"></i></a></li>
                <li class="nav-item dropdown">
                    <a class="dropdown-toggle" href="javascript:" data-toggle="dropdown">Dropdown</a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="javascript:">Action</a></li>
                        <li><a class="dropdown-item" href="javascript:">Another action</a></li>
                        <li><a class="dropdown-item" href="javascript:">Something else here</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <div class="main-search">
                        <div class="input-group">
                            <input type="text" id="m-search" class="form-control" placeholder="Search . . .">
                            <a href="javascript:" class="input-group-append search-close">
                                <i class="feather icon-x input-group-text"></i>
                            </a>
                            <span class="input-group-append search-btn btn btn-primary">
                                <i class="feather icon-search input-group-text"></i>
                            </span>
                        </div>
                    </div>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <li>
                	<c:if test="${userinfo != null}">
                    <div class="dropdown">
                        <a class="dropdown-toggle" href="javascript:" data-toggle="dropdown"><i class="icon feather icon-bell"></i></a>
                        <div class="dropdown-menu dropdown-menu-right notification">
                            <div class="noti-head">
                                <h6 class="d-inline-block m-b-0">Notifications</h6>
                                <div class="float-right">
                                    <a href="javascript:" class="m-r-10">mark as read</a>
                                    <a href="javascript:">clear all</a>
                                </div>
                            </div>
                            <ul class="noti-body">
                                <li class="n-title">
                                    <p class="m-b-0">NEW</p>
                                </li>
                                <li class="notification">
                                    <div class="media">
                                        <img class="img-radius" src="${root}/resources/images/user/avatar-1.jpg" alt="Generic placeholder image">
                                        <div class="media-body">
                                            <p><strong>John Doe</strong><span class="n-time text-muted"><i class="icon feather icon-clock m-r-10"></i>30 min</span></p>
                                            <p>New ticket Added</p>
                                        </div>
                                    </div>
                                </li>
                                <li class="n-title">
                                    <p class="m-b-0">EARLIER</p>
                                </li>
                                <li class="notification">
                                    <div class="media">
                                        <img class="img-radius" src="${root}/resources/images/user/avatar-2.jpg" alt="Generic placeholder image">
                                        <div class="media-body">
                                            <p><strong>Joseph William</strong><span class="n-time text-muted"><i class="icon feather icon-clock m-r-10"></i>30 min</span></p>
                                            <p>Prchace New Theme and make payment</p>
                                        </div>
                                    </div>
                                </li>
                                <li class="notification">
                                    <div class="media">
                                        <img class="img-radius" src="${root}/resources/images/user/avatar-3.jpg" alt="Generic placeholder image">
                                        <div class="media-body">
                                            <p><strong>Sara Soudein</strong><span class="n-time text-muted"><i class="icon feather icon-clock m-r-10"></i>30 min</span></p>
                                            <p>currently login</p>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                            <div class="noti-footer">
                                <a href="javascript:">show all</a>
                            </div>
                        </div>
                    </div>
                    </c:if>
                </li>
                <li>
                    <div class="dropdown drp-user">
                        <a href="javascript:" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon feather icon-settings"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right profile-notification">
                        	<c:if test="${userinfo == null}">
                        	<div class="pro-head">
                                <span>로그인 해주세요</span>
                            </div>
                            <ul class="pro-body">
                                <li><a href="${root}/user/login" class="dropdown-item"><i class="feather icon-user"></i>Login</a></li>
                                <li><a href="${root}/user/join" class="dropdown-item"><i class="feather icon-users"></i> Join</a></li>
                                <li><a href="auth-signin.html" class="dropdown-item"><i class="feather icon-lock"></i>Forget Password?</a></li>
                            </ul>
                        	</c:if>
                        	<c:if test="${userinfo != null}">
                            <div class="pro-head">
                                <img src="${root}/resources/images/user/avatar-1.jpg" class="img-radius" alt="User-Profile-Image">
                                <span>${userinfo.userid}</span>
                                <a href="auth-signin.html" class="dud-logout" title="Logout">
                                    <i class="feather icon-log-out"></i>
                                </a>
                            </div>
                            <ul class="pro-body">
                                <li><a href="javascript:" class="dropdown-item"><i class="feather icon-settings"></i> Settings</a></li>
                                <li><a href="javascript:" class="dropdown-item"><i class="feather icon-user"></i> Profile</a></li>
                                <li><a href="${root}/user/logout" class="dropdown-item"><i class="feather icon-slash"></i> Logout</a></li>
                            </ul>
                            </c:if>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </header>

	<script src="${root}/resources/js/vendor-all.min.js"></script>
	<script src="${root}/resources/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="${root}/resources/js/pcoded.min.js"></script>
    <!-- [ Header ] end -->