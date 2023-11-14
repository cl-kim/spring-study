<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공!
<!--((Member)request.getAttribute("member")).getId() -->
<ul>
    <li> id = ${member.id}</li>
    <li> username = ${member.username}</li>
    <li> age = ${member.age}</li>
</ul>
</body>
</html>
