<%--
  Created by IntelliJ IDEA.
  User: diepminhtuan
  Date: 5/12/2022
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<h1>Create</h1>
<form action="/admin/students/create" method="post">
    <div>Rollnumber <input type="text" name="rollNumber"></div>
    <div>Fullname <input type="text" name="fullName"></div>
    <div>Email <input type="email" name="email"></div>
    <div>Phone <input type="text" name="phone"></div>
    <div>Birthday <input type="date" name="birthday"></div>
    <div>
        <input type="submit"value="Save">
        <input type="reset"value="Reset">
    </div>
</form>
</body>
</html>
