<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="form-group">
    <form:label path="oldPassword"><spring:message code="user.old-password"/>:</form:label>
    <form:password path="oldPassword" cssClass="form-control"/>
    <form:errors path="oldPassword" element="div" cssClass="alert alert-danger"/>
</div>