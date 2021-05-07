<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.pagination {
	justify-content: center;
}
</style>
<ul class="pagination">
	<li class="page-item"><a href="javascript:movePage(${navigation.startRange?1:navigation.startPage-1 })"
			class="page-link">Prev</a></li>
	<c:forEach begin="${navigation.startPage }" end="${navigation.endPage }" var="i">
		<li class="${navigation.currentPage == i ? 'page-item active' : 'page-item'}">
			<a href="javascript:movePage(${i })" class="page-link">${i }</a>
		</li>
	</c:forEach>		
	<li class="page-item"><a href="javascript:movePage( ${navigation.endRange? navigation.endPage:navigation.endPage+1 })"
			class="page-link">Next</a></li>
</ul>