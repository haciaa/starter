<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<c:forEach var="error" items="${bindingResult.getGlobalErrors()}">
    <c:if test="${error.getCode().equals('ConfirmPassword')}">
        <c:set var="confirmPasswordError" value="${error}"/>
    </c:if>
    <c:if test="${error.getCode().equals('UniqueEmail')}">
        <c:set var="uniqueEmailError" value="${error}"/>
    </c:if>
</c:forEach>
<form:hidden path="id"/>
<c:if test="${mode == 'add' || mode == 'edit'}">
    <div class="form-group">
        <form:label path="email"><spring:message code="user.email"/>:</form:label>
        <form:input path="email" cssClass="form-control" maxlength="60"/>
        <form:errors path="email" element="div" cssClass="alert alert-danger"/>
        <c:if test="${not empty uniqueEmailError}">
            <div class="alert alert-danger">${uniqueEmailError.getDefaultMessage()}</div>
        </c:if>
    </div>
</c:if>
<c:if test="${mode == 'my-pass'}">
    <div class="form-group">
        <label for="old-password"><spring:message code="user.old-password"/>:</label>
        <input type="password" name="oldPassword" id="old-password" class="form-control"/>
    </div>
</c:if>
<c:if test="${mode == 'add' || mode == 'pass' || mode == 'my-pass'}">
    <div class="form-group">
        <form:label path="password"><spring:message code="user.password"/>:</form:label>
        <form:password path="password" cssClass="form-control"/>
        <form:errors path="password" element="div" cssClass="alert alert-danger"/>
    </div>
    <div class="form-group">
        <form:label path="confirmPassword"><spring:message code="user.confirm-password"/>:</form:label>
        <form:password path="confirmPassword" cssClass="form-control"/>
        <c:if test="${not empty confirmPasswordError}">
            <div class="alert alert-danger">${confirmPasswordError.getDefaultMessage()}</div>
        </c:if>
    </div>
</c:if>
<c:if test="${mode == 'add' || mode == 'edit'}">
    <div class="form-group">
        <form:label path="name"><spring:message code="office.name"/>:</form:label>
        <form:input path="name" maxlength="20" cssClass="form-control"/>
        <form:errors path="name" element="div" class="alert alert-danger"/>
    </div>
    <div class="form-group">
        <form:label path="phone"><spring:message code="office.phone"/>:</form:label>
        <form:input path="phone" maxlength="10" cssClass="form-control"/>
        <form:errors path="phone" element="div" class="alert alert-danger"/>
    </div>
    <div class="form-group">
        <form:label path="postalCode"><spring:message code="office.postal-code"/>:</form:label>
        <form:input path="postalCode" maxlength="6" cssClass="form-control"/>
        <form:errors path="postalCode" element="div" class="alert alert-danger"/>
    </div>
    <div class="form-group">
        <form:label path="city"><spring:message code="office.city"/>:</form:label>
        <form:input path="city" maxlength="20" cssClass="form-control"/>
        <form:errors path="city" element="div" class="alert alert-danger"/>
    </div>
    <div class="form-group">
        <form:label path="address"><spring:message code="office.address"/>:</form:label>
        <form:input path="address" maxlength="20" cssClass="form-control"/>
        <form:errors path="address" element="div" class="alert alert-danger"/>
    </div>
    <div class="form-group">
        <form:label path="firstname"><spring:message code="office.firstname"/>:</form:label>
        <form:input path="firstname" maxlength="20" cssClass="form-control"/>
        <form:errors path="firstname" element="div" class="alert alert-danger"/>
    </div>
    <div class="form-group">
        <form:label path="lastname"><spring:message code="office.lastname"/>:</form:label>
        <form:input path="lastname" maxlength="30" cssClass="form-control"/>
        <form:errors path="lastname" element="div" class="alert alert-danger"/>
    </div>
</c:if>
