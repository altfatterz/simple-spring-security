<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<body>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>
        Welcome : <c:out value="${pageContext.request.remoteUser}"/>
        <a href="<c:url value="/logout" />">Logout</a>
    </h2>
    <p>Your Session id is: "${pageContext.request.session.id}"</p>
</c:if>

</body>
</html>