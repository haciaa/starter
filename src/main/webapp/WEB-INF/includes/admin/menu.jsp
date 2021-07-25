<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div id="menuC" class="row justify-content-between mb-4">
    <div class="col text-left">
        <a href="<c:url value="/admin/admins"/>" class="btn btn-outline-secondary"><spring:message code="menu.admins"/></a>
        <a href="" class="btn btn-outline-secondary"><spring:message code="menu.configuration"/></a>
    </div>
    <div class="col text-right">
        <spring:message code="current-admin.welcome"/> ${currentUser.user.username}
        <a href="<c:url value="/logout"/>" class="btn btn-outline-warning"><spring:message code="app.logout"/></a>
    </div>
</div>
