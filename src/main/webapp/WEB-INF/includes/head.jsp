<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <title><spring:message code="app.title"/></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
    <c:choose>
        <c:when test="${not empty currentUser && currentUser.user.role.equals('ROLE_ADMIN')}">
            <link rel="stylesheet" href="<c:url value="/css/admin.css"/>">
        </c:when>
        <c:when test="${not empty currentUser && currentUser.user.role.equals('ROLE_OFFICE')}">
            <link rel="stylesheet" href="<c:url value="/css/office.css"/>">
        </c:when>
    </c:choose>
</head>
