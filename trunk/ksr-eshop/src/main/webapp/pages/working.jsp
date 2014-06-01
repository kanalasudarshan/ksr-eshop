<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>woring</title>
</head>
<body>
 
<c:forEach var="userName" items="${message}">
<ol>
<li>${userName.userName}</li>
<li>${userName.firstName}</li>
<li>${userName.lastName}</li>
</ol>
</c:forEach>

</body>
</html>