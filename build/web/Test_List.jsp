<%-- 
    Document   : Test_List
    Created on : Dec 17, 2016, 12:08:23 AM
    Author     : user
--%>

<%@page import="Models.TestInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="Navigation_Admin.jsp" /> 
        <form method="post" action="New_Report.do">
        <h1>Test List:</h1>
        <%!String pname, eid;%>
        <%
            pname = (String) session.getAttribute("pname");
            eid = (String) session.getAttribute("aid");
        %>
        <b>Patient Name: &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;Admission ID:</b><br/>
        <input  value=<%=pname%> name="pname"/>
        <input  value=<%=eid%> name="aid"/><br/>
        <br/>
        <%!String m;%>
        <%
            ArrayList<TestInfo> TestList = (ArrayList<TestInfo> ) session.getAttribute("test");
            for(int i = 0; i < TestList.size(); i++){
                m = Integer.toString(i);
                %>
                <input type="radio" value=<%=m%> name="Select"/>
        <b>Diagnostic Test ID::</b>
        <%
            out.println(TestList.get(i).gettestid());
        %>
        <b>&nbsp;&nbsp;Test Name:</b>
        <%
            out.println(TestList.get(i).gettt_name());
        %>
        <br/>
        <br/>
        <br/>
        <%
            }
        %>
        <input type="submit" value="Ok" name="Selected_Test"/>
        </form>
    </body>
</html>
