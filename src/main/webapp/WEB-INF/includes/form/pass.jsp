<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="form-group">
    <form:label path="password"><spring:message code="user.password"/>:</form:label>
    <form:password path="password" cssClass="form-control"/>
    <form:errors path="password" element="div" cssClass="alert alert-danger"/>
</div>
<div class="form-group">
    <form:label path="confirmPassword"><spring:message code="user.confirm-password"/>:</form:label>
    <form:password path="confirmPassword" cssClass="form-control"/>
    <form:errors path="confirmPassword" element="div" cssClass="alert alert-danger"/>
</div>