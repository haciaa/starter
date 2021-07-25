<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div id="menuC" class="row justify-content-between mb-4">
    <div class="col text-left">

    </div>
    <div class="col text-right">
        <a href="<c:url value="/login"/>" class="btn btn-outline-success"><spring:message code="app.login"/></a>
    </div>
</div>
