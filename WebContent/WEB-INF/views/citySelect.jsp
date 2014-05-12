<%-- <% response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
 response.setHeader("Pragma","no-cache"); //HTTP 1.0 
 response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  --%>
%>
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
	background-size: contain;
	background-size: 100% 100%;
}
</style>


</head>
<body>
	<div data-role="page">
	<form name="backButton" action="initial" method="post" >
		<div data-role="header">
			<%-- <h1>${cityBean.secondPageHeader}</h1>
			 --%>	<input type="submit" id="LibraryButton" data-icon="arrow-l" value="Back">
		</div>
		</form>
		<!-- /header -->
		<br />
		<table style="width: 100%">
			<tr>
				<td align="center">
					<form name="attractionInput" action="ThirdPage" method="post">
						<div data-role="fieldcontain">
							<input type="hidden" value="Attraction/Museum"
								style="display: none" name="venueBean.venueType" /> <input
								type="hidden" value="${teamBean.team}" style="display: none"
								name="teamBean.team" /> <input type="hidden"
								value="${cityBean.selectedCity }" style="display: none"
								name="cityBean.selectedCity" /> <input type="submit"
								id="AttractionButton" value="Attractions / Museums" />
						</div>
					</form>
				</td>
			</tr>
			<tr>
				<td align="center">
					<form name="barInput" action="ThirdPage" method="post">
						<div data-role="fieldcontain">

							<input type="hidden" value="Resturant" style="display: none"
								name="venueBean.venueType" /> <input type="hidden"
								value="${teamBean.team}" style="display: none"
								name="teamBean.team" /> <input type="hidden"
								value="${cityBean.selectedCity }" style="display: none"
								name="cityBean.selectedCity" /> <input type="submit"
								id="ResturantButton" value="Bars / Resturants">
						</div>
					</form>
				</td>
			</tr>
			<tr>
				<td align="center">
					<form name="ballparkInput" action="ThirdPage" method="post">
						<div data-role="fieldcontain">

							<input type="hidden" value="Ballpark" style="display: none"
								name="venueBean.venueType" /> <input type="hidden"
								value="${teamBean.team}" style="display: none"
								name="teamBean.team" /> <input type="hidden"
								value="${cityBean.selectedCity }" style="display: none"
								name="cityBean.selectedCity" /> <input type="submit"
								id="BallparkButton" value="Ballparks">
						</div>
					</form>
				</td>
			</tr>
			<tr>
				<td align="center">
					<form name="libraryInput" action="ThirdPage" method="post">
						<div data-role="fieldcontain">

							<input type="hidden" value="Libraries" style="display: none"
								name="venueBean.venueType" /> <input type="hidden"
								value="${teamBean.team}" style="display: none"
								name="teamBean.team" /> <input type="hidden"
								value="${cityBean.selectedCity }" style="display: none"
								name="cityBean.selectedCity" /> <input type="submit"
								id="LibraryButton" value="Libraries / Research">
						</div>
					</form>
				</td>
			</tr>
		</table>

	</div>
	<!-- /page -->
</body>
</html>