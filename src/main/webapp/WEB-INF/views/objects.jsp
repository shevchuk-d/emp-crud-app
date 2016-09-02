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
<%--<h1>--%>
	<%--Add an Object--%>
<%--</h1>--%>

<%--<c:url var="addAction" value="/object/add" ></c:url>--%>

<%--<form:form action="${addAction}" commandName="object">--%>
<%--<table>--%>
	<%--<c:if test="${!empty object.name}">--%>
	<%--<tr>--%>
		<%--<td>--%>
			<%--<form:label path="objectId">--%>
				<%--<spring:message text="objectId"/>--%>
			<%--</form:label>--%>
		<%--</td>--%>
		<%--<td>--%>
			<%--<form:input path="objectId" readonly="true" size="8"  disabled="true" />--%>
			<%--<form:hidden path="objectId" />--%>
		<%--</td>--%>
	<%--</tr>--%>
	<%--</c:if>--%>
	<%--<tr>--%>
		<%--<td>--%>
			<%--<form:label path="name">--%>
				<%--<spring:message text="Name"/>--%>
			<%--</form:label>--%>
		<%--</td>--%>
		<%--<td>--%>
			<%--<form:input path="name" />--%>
		<%--</td>--%>
	<%--</tr>--%>

	<%--<tr>--%>
		<%--<td>--%>
			<%--<form:label path="objectTypeId">--%>
				<%--<spring:message text="objectTypeId"/>--%>
			<%--</form:label>--%>
		<%--</td>--%>
		<%--<td>--%>
			<%--<form:input path="objectTypeId" />--%>
		<%--</td>--%>
	<%--</tr>--%>

	<%--<tr>--%>
		<%--<td>--%>
			<%--<form:label path="oldObjectId">--%>
				<%--<spring:message text="oldObjectId"/>--%>
			<%--</form:label>--%>
		<%--</td>--%>
		<%--<td>--%>
			<%--<form:input path="oldObjectId" />--%>
		<%--</td>--%>
	<%--</tr>--%>

	<%--<tr>--%>
		<%--<td colspan="2">--%>
			<%--<c:if test="${!empty object.name}">--%>
				<%--<input type="submit"--%>
					<%--value="<spring:message text="Edit Object"/>" />--%>
			<%--</c:if>--%>
			<%--<c:if test="${empty object.name}">--%>
				<%--<input type="submit"--%>
					<%--value="<spring:message text="Add Object"/>" />--%>
			<%--</c:if>--%>
		<%--</td>--%>
	<%--</tr>--%>
<%--</table>--%>
<%--</form:form>--%>


<form:form action="${updv}" modelAttribute="upd" method="POST">
	<table>
		<tr>
			<td>
				<form:label path="limit">
					<spring:message text="lim"/>
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
	</table>
</form:form>


<br>
<h3>Objects List</h3>


<%--<form:form action="${changeQuantity}" commandName="object">--%>
	<%--<table>--%>
		<%--<tr>--%>
			<%--<td>--%>
				<%--<form:label >--%>
					<%--<spring:message text="Name"/>--%>
				<%--</form:label>--%>
			<%--</td>--%>
			<%--<td>--%>
				<%--<input type="submit"--%>
							<%--value="<spring:message text="Edit view"/>" />--%>
			<%--</td>--%>
		<%--</tr>--%>
	<%--</table>--%>
<%--</form:form>--%>


<c:if test="${!empty listExtendedDBObjects}">
	<table class="tg">
	<tr>
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
			<%--<td>${object[0].objectId}</td>--%>
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
