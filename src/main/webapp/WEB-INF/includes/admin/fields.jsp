<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="form-group">
    <form:label path="firstname"><spring:message code="admin.firstname"/>:</form:label>
    <form:input path="firstname" maxlength="20" cssClass="form-control"/>
    <form:errors path="firstname" element="div" class="alert alert-danger"/>
</div>
<div class="form-group">
    <form:label path="lastname"><spring:message code="admin.lastname"/>:</form:label>
    <form:input path="lastname" maxlength="30" cssClass="form-control"/>
    <form:errors path="lastname" element="div" cssClass="alert alert-danger"/>
</div>