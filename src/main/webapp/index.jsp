<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
<head>

	<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
		<script src="static/main.js"></script>
	<script type="text/javascript">
	
	</script>
</head>
<body>
<a href='<c:url value="/items/queryItems.action"/>'>查询商品</a>
<button id="coalBtn" class="btn btn-default">燃煤</button>
</body>
</html>


