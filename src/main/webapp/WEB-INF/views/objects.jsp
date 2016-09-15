<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Objects</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>

<form:form method="post" modelAttribute="upd">
	<table>
		<tr>
			<td>
				<form:label path="limit">
					<spring:message text="Show Items on Page:"/>
				</form:label>
			</td>
			<td>
				<form:input path="limit" />
			</td>
		</tr>

		<tr>
			<td >
				<%--<c:if test="${!empty upd.limit}">--%>
					<input type="submit" value="Submit" />
				<%--</c:if>--%>
			</td>
		</tr>
		<tr>
			<td>
				<button>
					<a href="./add">New</a>
				</button>
			</td>
		</tr>
	</table>
</form:form>

<br>
<h3>Objects List</h3>

<c:if test="${!empty listExtendedDBObjects}">
	<table class="tg">
	<tr>
		<th width="80">Object ID</th>
		<th width="80">Object Name</th>
		<th width="80">First Name</th>
		<th width="120">Last Name</th>
		<th width="60">Gender</th>
		<th width="120">Department</th>
		<th width="120">Hire Date</th>
		<th width="60">Is Manager</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listExtendedDBObjects}" var="object">
		<tr>
			<td>${object[0].objectId}</td>
			<td>${object[0].name}</td>
			<td>${object[1]}</td>
			<td>${object[2]}</td>
			<td>${object[3]}</td>
			<td>${object[4]}</td>
			<td>${object[5]}</td>
			<td>${object[6]}</td>
			<%--<td>${object[5]}</td>--%>
			<td><a href="<c:url value='/edit/${object[0].objectId}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${object[0].objectId}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>