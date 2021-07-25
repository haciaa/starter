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
        <div class="row justify-content-center mt-5">
            <div class="col-6">
                <form method="post" action="<c:url value="/login"/>">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="form-group">
                        <label for="email"><spring:message code="user.email"/>:</label>
                        <input type="text" name="username" id="email" class="form-control" maxlength="60"/>
                    </div>
                    <div class="form-group">
                        <label for="password"><spring:message code="user.password"/>:</label>
                        <input type="password" name="password" id="password" class="form-control"/>
                    </div>
                    <a href="<c:url value="/"/>"
                       class="btn btn-outline-danger float-left"><spring:message code="app.cancel"/></a>
                    <input type="submit" value="<spring:message code="app.login"/>"
                           class="btn btn-outline-success float-right">
                </form>
            </div>
        </div>
</div>
</body>
</html>

