<%-- 
    Document   : Patient_List_For_Bill
    Created on : Dec 18, 2016, 9:06:32 AM
    Author     : user
--%>

<%@page import="Models.PatientInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient List</title>
    </head>
    <body>
        <jsp:include page="Navigation_Admin.jsp" /> 
        <form method="post" action="Bill_Control.do">
        <h1>Select Patient:</h1>
        <br/>
        <%!String m;%>
        <%
            ArrayList<PatientInfo> PatientList = (ArrayList<PatientInfo> ) session.getAttribute("PatientList");
            for(int i = 0; i < PatientList.size(); i++){
                m = Integer.toString(i);
                %>
                <input type="radio" value=<%=m%> name="Select"/>
        <b>Patient Name:</b>
        <%
            out.println(PatientList.get(i).getpname());
        %>
        <b>&nbsp;&nbsp;Patient ID:</b>
        <%
            out.println(PatientList.get(i).getpid());
        %>
        <b>&nbsp;&nbsp;Admission ID:</b>
        <%
            out.println(PatientList.get(i).getaid());
        %>
        <br/>
        <br/>
        <br/>
        <%
            }
        %>
        <input type="submit" value="See Bill" name="Selected_Bill"/>
        </form>
        </body>
</html>
