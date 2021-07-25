<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<jsp:include page="../../includes/head.jsp"/>
<body>
<div class="container py-2">
    <jsp:include page="../../includes/admin/menu.jsp"/>
    <div class="row justify-content-center mt-5">
        <div class="col-6">
        <form:form method="post" modelAttribute="office">
            <jsp:include page="../forms/office.jsp"/>
            <a href="<c:url value="/admin/offices"/>"
               class="btn btn-outline-danger float-left"><spring:message code="app.cancel"/></a>
            <input type="submit" value="<spring:message code="app.save"/>"
                   class="btn btn-outline-success float-right">
        </form:form>
        </div>
    </div>
</div>
</body>
</html>
