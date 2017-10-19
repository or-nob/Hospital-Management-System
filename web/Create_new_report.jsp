<%-- 
    Document   : Create_new_report
    Created on : Dec 17, 2016, 7:12:43 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="Navigation_Admin.jsp" /> 
        <form method="post" action="Report_Management.do">
        <h1>Create a report for:</h1>
        <%!String pt_name, a_id, t_name, t_id;%> 
        <%
            pt_name = (String) session.getAttribute("pt_name");
            a_id = (String) session.getAttribute("a_id");
            t_name = (String) session.getAttribute("test_name");
            t_id = (String) session.getAttribute("d_test_ID");
        %>
        <b>Patient Name: &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;Admission ID:</b><br/>
        <input  value=<%=pt_name%> name="pname"/>
        <input  value=<%=a_id%> name="aid"/><br/>
        <br/>
        <br/>
        <b>Test Type Name: &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;Test ID:</b><br/>
        <input  value=<%=t_name%> name="ttname"/>
        <input  value=<%=t_id%> name="tid"/><br/>
        <br/>
        Enter Report Description: <textarea name="paragraph_text" cols="50" rows="10"></textarea> <br/>
        <br/>
        <input type="submit" value="Ok" name="Create_Report"/>
        </form>
    </body>
</html>
