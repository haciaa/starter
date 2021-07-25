<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<jsp:include page="../../includes/head.jsp"/>
<body>
<div class="container py-2">
    <jsp:include page="../../includes/admin/menu.jsp"/>
    <jsp:include page="../../includes/messages.jsp"/>
    <div class="row mb-3">
        <div class="col">
            <a href="<c:url value="/admin/office"/>" class="btn btn-outline-success"><spring:message code="button.add-office"/></a>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <table class="table">
                <thead class="thead-dark">
                <th scope="col"><spring:message code="office.name"/></th>
                <th scope="col"><spring:message code="user.email"/></th>
                <th scope="col"><spring:message code="office.phone"/></th>
                <th scope="col"><spring:message code="admin.firstname"/></th>
                <th scope="col"><spring:message code="admin.lastname"/></th>
                <th scope="col"></th>
                <th scope="col" class="w-25"></th>
                </thead>
                <c:forEach var="office" items="${offices}">
                    <tr>
                        <td>${office.name}</td>
                        <td>${office.email}</td>
                        <td>${office.phone}</td>
                        <td>${office.firstname}</td>
                        <td>${office.lastname}</td>
                        <td>
                            <c:choose>
                                <c:when test="${office.enabled == 1}">
                                    <span class="badge badge-pill badge-success"><spring:message code="app.active"/></span>
                                </c:when>
                                <c:otherwise>
                                    <span class="badge badge-pill badge-warning"><spring:message code="app.inactive"/></span>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td class="text-right">
                            <c:choose>
                                <c:when test="${office.enabled == 1}">
                                    <a href="<c:url value="/admin/office/deactivate/${office.id}"/>" class="badge badge-pill badge-danger"><spring:message code="app.deactivate"/></a>
                                </c:when>
                                <c:otherwise>
                                    <a href="<c:url value="/admin/office/resend/${office.id}"/>" class="badge badge-pill badge-primary"><spring:message code="app.resend"/></a>
                                </c:otherwise>
                            </c:choose>
                            <c:if test="${office.enabled != 1}">
                            </c:if>
                            <a href="<c:url value="/admin/office/${office.id}"/>" class="badge badge-pill badge-primary"><spring:message code="app.edit"/></a>
                            <a href="<c:url value="/admin/office/pass/${office.id}"/>" class="badge badge-pill badge-warning"><spring:message code="app.password"/></a>
                            <a href="<c:url value="/admin/office/delete/${office.id}"/>" class="badge badge-pill badge-danger"><spring:message code="app.delete"/></a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
