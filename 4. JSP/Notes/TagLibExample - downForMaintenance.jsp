<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="html"	uri="/WEB-INF/struts-html" %> 
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"		uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn"		uri="http://java.sun.com/jsp/jstl/functions" %>

<%--
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
--%>

<fmt:setBundle basename="resources.bundle" scope="request"/>
<c:set var="buildLabel" scope="request"><fmt:message key="build.label.prop"/></c:set>

<html xmlns="http://www.w3.org/1999/xhtml" lang="en-US" xml:lang="en-US">
	<head>
		<link rel="stylesheet" href="<c:url value="/css${buildLabel}/main.css"/>" type="text/css"/>		
    </head>
<body>			
	<div id="maintenance">
		<div class="text">
			<c:out value='A 503 error has occurred:'/>			
			<ul>
				<li>
					<div class="reason">
						My AutoSupport is currently unavailable due to necessary maintenance. We apologize for the inconvenience.<br/>
						<c:if test="${requestScope.reason!=null && requestScope.reason!=''}"><c:out value='${requestScope.reason}'/>.</c:if>
						<c:if test="${requestScope.time!=null && requestScope.reason!='' }"> Expected uptime is :<c:out value='${requestScope.time}'/>.</c:if>
						Please try again later.
					</div>											
				</li>
			</ul>
		</div>		
	</div>
 </body>
</html>