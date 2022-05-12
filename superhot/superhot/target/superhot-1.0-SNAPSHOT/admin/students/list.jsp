<%@ page import="java.util.List" %>
<%@ page import="com.t2010a.hellot2010aagain.entity.Student" %>
<%@ page import="static com.t2010a.hellot2010aagain.demo.ConsoleApplication.studentModel" %><%--
  Created by IntelliJ IDEA.
  User: diepminhtuan
  Date: 5/12/2022
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Student> listStudent = (List<Student>)request.getAttribute("listStudent");
%>
<html>
<head>
    <title>List</title>
</head>
<body>
<h1>List Student</h1>
<ul>
    <% for (Student st : listStudent){%>
    <li><%=st.getRollNumber()%>-<%=st.getFullName()%></li>
    <%}%>
</ul>
</body>
</html>
