<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<body>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>
        Welcome !!!!: <c:out value="${pageContext.request.remoteUser}"/>

        <!-- Adding CSRF will update the LogoutFilter to only use HTTP POST. -->
        <form name="form" method="post" action="${pageContext.request.contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" value="Logout" />
        </form>
    </h2>
    <p>Your Session id is: "${pageContext.request.session.id}"</p>
</c:if>

</body>
</html>