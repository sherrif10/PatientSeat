<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ taglib prefix="springform" uri="resources/spring-form.tld"%>

<openmrs:require privilege="seat" otherwise="/login.htm"
	redirect="/module/patientseat/seat.form" />

<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="localHeader.jsp"%>


<h2><spring:message code="patientseat.admin.title" /></h2>
<a
	href="${pageContext.request.contextPath}/module/patientseat/editFlag.form"><spring:message
	code="patientseat.seat.addSeat" /></a>
<br />
<br />

<!--  display the filter box -->
<c:if test="${!empty tags}">
<div><b class="boxHeader"><spring:message
	<table cellpadding="2" cellspacing="0" class="box">
		<tr>
			<td><springform:select path="addSeat" multiple="true">
				<springform:options items="${addSeat}" itemValue="seatId" itemLabel="name" />
			</springform:select></td>
			<td width="100%">&nbsp;</td>
		</tr>
		<tr>
			<td><input type="submit"
				value="<spring:message code='patientflags.save'/>" /></td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
	</table>
</springform:form></div>
<br />
</c:if>

<!--  display the flags -->
<div><b class="boxHeader"><spring:message
	code="patientflags.flags" /></b>
<table cellpadding="2" cellspacing="0" class="box">
	<tr>
		<th><spring:message code="patientseat.name" /></th>
		<th><spring:message code="patientseat.actions" /></th>
		<th>&nbsp;</th>
	</tr>
	<c:set var="i" value="0" />
	<c:forEach items="${seats}" var="seat">
		<tr class="${i % 2 == 0 ? 'evenRow' : 'oddRow'}">
			<td><a
				href="${pageContext.request.contextPath}/module/patientseat/editFlag.form?seatId=${seat.seatId}">${seat.name}</a></td>
			<td><c:forEach items="${seat.seats}" var="seat">
					${seat.name};
				</c:forEach></td>
			<c:choose>
				<c:when test="${flag.enabled}">
					<td><spring:message code="patientseat.enabled" /></td>
				</c:when>
				<c:otherwise>
					<td><spring:message code="patientseat.disabled" /></td>
				</c:otherwise>
			</c:choose>

			<td>
				<a href="${pageContext.request.contextPath}/module/patientflags/findFlaggedPatients.form?flagId=${flag.flagId}">
				   <spring:message code="patientflags.preview" />
				</a>
				&nbsp;|&nbsp;
				<a href="${pageContext.request.contextPath}/module/patientseat/deleteSeat.form?seatId=${seat.seatId}"
				   onclick="return confirm('<spring:message code="patientseat.seat.deleteSeatConfirm"/>');">
				   <spring:message code="patientseat.seat.deleteSeat" />
				</a>
			</td>
		</tr>
		<c:set var="i" value="${i + 1}" />
	</c:forEach>
</table>
</div>

<%@ include file="/WEB-INF/template/footer.jsp"%>