<%-- 
<%
	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1 
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0 
	response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%> --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html lang="us">
<head>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SABR Homepage</title>

<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />

<link rel="stylesheet" href="js/jquery.mobile-1.3.2.css" />
<script src="js/jquery-1.10.2.js"></script>
<script src="js/jquery.mobile-1.3.2.js"></script>
<script type="text/javascript">
	
</script>
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
		<form name="backButton" action="initial" method="post">
			<div data-role="header">
				<!-- <h1>SABR Homepage</h1>
				 --><input type="submit" data-icon="arrow-l"
					value="Back">

			</div>
		</form>

		<!-- /header -->
		<br />

		<form name="cityDropdownInput" action="TeamDropdown" method="post">
			<div data-role="fieldcontain">
				<table style="width: 100%; font: bold;">
					<tr>
						<td></td>
					</tr>
					<tr>
						<td />
					</tr>
					<tr>
						<td />
					</tr>
					<tr>
						<td />
					</tr>
					<tr>
						<td />
					</tr>
					<tr>
						<td />
					</tr>
					<tr>
						<td />
					</tr>
					<tr>
						<td />
					</tr>
					<tr>
						<td />
					</tr>
					<tr>
						<td />
					</tr>
					<tr>
						<td />
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr align="center">
						<td><label for="cityBean" class="select"
							style="color: white;">Choose a MLB City</label></td>
					</tr>
					<tr align="center">
						<td><select name="cityBean.selectedCity" id="cityDropdown"
							onchange="this.form.submit()">
								<option>${cityBean.selectedCity}</option>
								<s:iterator value="cityArrayString">
									<option value="<s:property />"
										${cityBean.selectedCity == 'selectedCit' ? 'selected="selected"' : ''}><s:property /></option>
								</s:iterator>
						</select></td>
					</tr>

				</table>

			</div>
		</form>
		<br />
		<form name="teamDropdownInput" action="SecondPage" method="post">
			<table style="width: 100%; font: bold;">
				<tr align="center">
					<td><input type="hidden" value="${cityBean.selectedCity}"
						style="display: none" name="cityBean.selectedCity" /></td>
				</tr>
			</table>
			<div data-role="fieldcontain" data-theme="b">
				<table style="width: 100%">
					<tr align="center">
						<td><label for="teamBean" style="color: white;">Filter
								by MLB Team</label></td>
					</tr>
					<tr align="center">
						<td><select name="teamBean.team" id="teamDropdown">
								<option value="" data-placeholder="true">Optional</option>
								<s:iterator value="teamArrayString">
									<option value="<s:property />"><s:property /></option>
								</s:iterator>
						</select></td>
					</tr>
				</table>
			</div>
			<table style="width: 50%; margin-left: 25%">
				<tr align="center">
					<td align="center"><br /> <input type="submit"
						id="SecondPageSubmitButton" value="Explore"></td>
				</tr>

			</table>

		</form>
	</div>
	<!-- /page -->

</body>
</html>