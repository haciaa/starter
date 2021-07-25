<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<jsp:include page="../includes/head.jsp"/>
<body>
<div class="container py-2">
    <jsp:include page="../includes/menu.jsp"/>
    <jsp:include page="../includes/messages.jsp"/>
    <h1><spring:message code="app.title"/></h1>
    Hello :)<br>
</div>
</body>
</html>