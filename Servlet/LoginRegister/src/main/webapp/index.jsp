<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<body>
<h2>Hello ${user.username}!</h2>
<form action="${pageContext.request.contextPath}/logout" method="post">
    <button type="submit">退出登录</button>
</form>
</body>
</html>
