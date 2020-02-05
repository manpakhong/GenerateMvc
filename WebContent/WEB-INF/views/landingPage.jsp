<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    <%-- 
<%@ page import="com.rabbitforever.common.factories.UtilsFactory" %>
<%@ page import="com.rabbitforever.common.utils.DateUtils" %>
<%@ page import="com.rabbitforever.gamblehub.controllers.BaccaratController" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<% UtilsFactory utilsFactory = UtilsFactory.getInstance(); 
DateUtils dateUtils = utilsFactory.getInstanceOfDateUtils();
BaccaratController controller = new BaccaratController();
%>
 --%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 <c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link type="text/css" rel="stylesheet" href="${context}/css/common.css"/>
<link type="text/css" rel="stylesheet" href="${context}/css/landingPage.css"/>

<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/jquery-3.3.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/common.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/landingPage.js"></script>

 
<title>CMS - MVC Code Generator</title>
</head>
<body>
<%-- 	CMS - Outpatient Consultation Landing Page - ${patientChargesProperties.serverName} --%>
<%-- 
	<div class="mainContentDiv">
	<label for="date" class="dateLabel"><%= dateUtils.getTodayDisplayDateString() %></label>
	<input type="hidden" class="dateParamInput" value="<%= dateUtils.getDateParamString() %>" />
	
	${vo.filterInputHtml}
	${vo.tableHtml}
 --%>
<%-- 		<c:out value='${vo.tableHtml}' /> --%>
<%-- 	<%= controller.renderBaccaratTable(request.getParameter("session")) %>  --%>

<%-- 	<table class="baccaratTable">
		<thead>
			<tr>
				<th></th>
				<th>Session</th>
				<th>Round</th>
				<th>Input</th>
				<th>Count</th>
				<th>Odd/Even</th>
			</tr>
		</thead>
		<tbody class="baccaratTableTbody">
			<tr>
				<td><input type="button" value="Add" class="addNewButton" onclick="addNewButton_onclick(event)"/></td>
				<td><input type="text" value="<%= dateUtils.getDateParamString() %>" class="sessionInput"/></td>
				<td><input type="text" value="" class="roundInput" /></td>
				<td><input type="text" value="" class="resultInput" onkeydown="resultInput_onkeydown(event)" onchange="resultInput_onchange(event)" /></td>
				<td><label for="count" class="countLabel"></label></td>
				<td><label for="oddEven" class="oddEvenLabel"></label></td>
			</tr>
		</tbody>
	</table> --%>
	<div>
<!-- 		<a href="doctorWorkbench">Doctor Workbench</a> -->
	   <div style="margin:1px 1px 1px 1px;">
	      <img src="<%=request.getContextPath()%>/image/logo.png" alt="The logo of Hong Kong Baptist Hospital">
	   </div>
	</div>
</body>
</html>