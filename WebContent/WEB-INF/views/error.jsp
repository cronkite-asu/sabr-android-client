<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html lang="us">
<head>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SABR</title>

<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />

<link rel="stylesheet" href="js/jquery.mobile-1.3.2.css" />
<script src="js/jquery-1.10.2.js"></script>
<script src="js/jquery.mobile-1.3.2.js"></script>


<style type="text/css">
.ui-page.ui-body-c {
	background: url(sabrImages/TEST.jpg);
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	background-size: 100% 100%;
}
</style>
</head>
<body>
	<div data-role="page">
	<form name="backButton" action="initial" method="post" >
		<div data-role="header">
			<%-- <h1>${cityBean.selectedCity}</h1>
			 --%>				<input type="submit" id="LibraryButton" data-icon="arrow-l" value="Back">
		</div>
		</form>
		<!-- /header -->
	</div>
	<jsp:include page="/splashscreen.html"></jsp:include>
</body>
</html>