<%@ page import="java.util.List" %>
<%@ page import="com.web.jdbc.Student" %><%--
  Created by IntelliJ IDEA.
  User: huylo
  Date: 6/9/2020
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students Tracker App</title>
    <%
        // get the student from the request object (by the servlet)
        List<Student> theStudent =
                (List<Student>) request.getAttribute("STUDENT_LIST");

    %>
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>Foo Bar University</h2>
        </div>
    </div>
    <div id="container">
        <div id="content">
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                </tr>
                <%
                    for (Student tempStudent : theStudent){
                %>
                    <tr>
                        <td><%=tempStudent.getFirstName()%></td>
                        <td><%=tempStudent.getLastName()%></td>
                        <td><%=tempStudent.getEmail()%></td>
                    </tr>
                <%
                    }
                %>
            </table>
        </div>
    </div>

</body>
</html>
