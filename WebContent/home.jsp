<!DOCTYPE>
<%@page import="java.util.Map"%>
<%@page import="com.bomman.house.bean.Commodity"%>
<%@page import="java.util.List"%>
<html>
<head>
<!-- <link href="media/jquery-ui.css" rel="stylesheet"
	type="text/css" media="all" /> -->
<!-- <script src="scripts/jquery.js" type="text/javascript"></script> -->
<!-- <script src="scripts/jquery.dataTables.min.js" type="text/javascript"></script> -->
<!-- <link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css" /> -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/r/ju-1.11.4/jqc-1.11.3,dt-1.10.8/datatables.min.css" />
<script src="https://code.jquery.com/jquery-1.11.3.min.js"
	type="text/javascript"></script>
<script
	src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"
	type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#myDataTable").dataTable({
			"sPaginationType" : "full_numbers",
			"bJQueryUI" : true
		});
	});
	$(document).ready(function() {
		 	if(session.getAttribute("username")==null){
				window.location("./login.jsp");
			} 
	});
</script>
<title>Bomman House Hold</title>
</head>
<body style="align: center">
	<h1>Bomman House Hold</h1>
	<%=session.getAttribute("username")%>|
	<a href="./logout">Log Out</a>
	<form action="./addRecord" method="post">
		<table>
			<tr>
				<td>List of Items</td>
				<td><textarea rows="3" cols="10" name="items"></textarea>
			</tr>
			<tr>
				<td>Total Cost</td>
				<td><input type="text" name="cost" required="required" /></td>
			</tr>
			<tr>
				<td>Buyer</td>
				<td><select name="buyer">
						<option value="">Select Buyer</option>
						<option value="Venkatesh">Venkatesh</option>
						<option value="Sandeep">Sandeep</option>
				</select></td>
			</tr>
			<tr>
				<td>Date</td>
				<td><input type="date" name="date" required="required" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="submit" /></td>
			</tr>

		</table>
	</form>
	<hr>
	<div id="sandeep" style="display: table-cell">
		<%
			Map<String, Double> map = (Map<String, Double>) session
					.getAttribute("individual");
		%>
		<table>
			<tr>
				<td><img alt="sandeep" src="./sandeep.jpg" height="100px"
					width="100px" title="Sandeep" /></td>
			</tr>
			<tr>
				<td>Investment : <%=map.get("Sandeep")%></td>
			</tr>
			<tr>
				<td>Liability: <%=session.getAttribute("sLiability")%></td>
			</tr>
		</table>
	</div>
	<div id="container" style="display: table-cell">
		<table id="myDataTable" class="display" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>ID</th>
					<th>ITEMS</th>
					<th>COST</th>
					<th>BUYER</th>
					<th>DATE</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<Commodity> commodities = (List<Commodity>) session
							.getAttribute("commodity");
					if (commodities != null) {
						for (Commodity commodity : commodities) {
				%>
				<tr>
					<td><%=commodity.getId()%></td>
					<td><%=commodity.getItems()%></td>
					<td><%=commodity.getCost()%></td>
					<td><%=commodity.getBuyer()%></td>
					<td><%=commodity.getDate()%></td>
				</tr>
				<%
					}
					}
				%>
			</tbody>
		</table>
	</div>
	<div id="venkatesh" style="display: table-cell">
		<table>
			<tr>
				<td><img alt="venkatesh" src="./venkatesh.jpg" height="100px"
					width="100px" title="Venkatesh" /></td>
			</tr>
			<tr>
				<td>Investment : <%=map.get("Venkatesh")%></td>
			</tr>
			<tr>
				<td>Liability: <%=session.getAttribute("vLiability")%></td>
			</tr>
		</table>
	</div>
</body>
</html>