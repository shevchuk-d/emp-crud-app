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
<h1>
	Add an Object
</h1>

<c:url var="addAction" value="/object/add" ></c:url>

<form:form action="${addAction}" modelAttribute="object" commandName="object">
<table>
	<c:if test="${!empty object.name}">
	<tr>
		<td>
			<form:label path="objectId">
				<spring:message text="objectId"/>
			</form:label>
		</td>
		<td>
			<form:input path="objectId" readonly="true" size="8"  disabled="true" />
			<form:hidden path="objectId" />
		</td>
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td>
	</tr>

	<tr>
		<td>
			<form:label path="objectTypeId">
				<spring:message text="Object Type Id"/>
			</form:label>
		</td>
		<td>
			<form:input path="objectTypeId" />
		</td>
	</tr>

	<tr>
		<td colspan="2">
			<c:if test="${!empty object.name}">
				<input type="submit"
					value="<spring:message text="Edit Object"/>" />
			</c:if>
			<c:if test="${empty object.name}">
				<input type="submit"
					value="<spring:message text="Add Object"/>" />
			</c:if>
		</td>
	</tr>
</table>
</form:form>

</body>
</html>
