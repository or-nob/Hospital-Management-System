<%-- 
    Document   : Create_an_test
    Created on : Dec 16, 2016, 9:51:18 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test:</title>
    </head>
    <body>
        <form method="post" action="Create_New_Test.do">
        <h1>Test:</h1>
        <%!String pname, eid;%>
        <%
            pname = (String) session.getAttribute("pname");
            eid = (String) session.getAttribute("aid");
        %>
        <b>Patient Name: &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;Admission ID:</b><br/>
        <input  value=<%=pname%> name="pname"/>
        <input  value=<%=eid%> name="aid"/><br/>
        <br/>
        <br/>
        Enter Test name: <input type="text" name="testname" /> <br/>
        <br/>
        Enter Test Type: <input type="text" name="test_type" /> <br/>
        <br/>
        Enter Test Price: <input type="text" name="test_price" /> <br/>
        <br/>
        Enter Reduced Cost: <input type="text" name="reduced_cost" /> <br/>
        <br/>
        Enter Test Date: <input type="text" name="date" /> <br/>
        <br/>
        <input type="submit" value="Ok" name="Create_Test"/>
        </form>
    </body>
</html>
