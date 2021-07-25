<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="form-group">
    <form:label path="email"><spring:message code="user.email"/>:</form:label>
    <form:input path="email" cssClass="form-control" maxlength="60"/>
    <form:errors path="email" element="div" cssClass="alert alert-danger"/>
</div>