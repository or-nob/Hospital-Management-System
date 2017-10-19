<%-- 
    Document   : Patient_Info
    Created on : Dec 7, 2016, 1:31:34 PM
    Author     : user
--%>

<%@page import="Models.PatientInfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Page</title>
    </head>
    <body>
        <form method="post" action="LoginPageP.do">
            <h1>Patient Profile:</h1>
        <br/>
        <b>Name:</b>
        <%
            PatientInfo result = (PatientInfo) session.getAttribute("patientInfo");
            out.println(result.getpname());
        %>
        <br/>
        <br/>
        <b>Phone Number:</b>
        <%
            out.println(result.getpphone());
        %>
        <br/>
        <br/>
        <b>Email:</b>
        <%
            out.println(result.getpemail());
        %>
        <br/>
        <br/>
        <b>Date of Birth:</b>
        <%
            out.println(result.getpdob());
        %>
        <br/>
        <br/>
        <b>Sex:</b>
        <%
            out.println(result.getpsex());
        %>
        <br/>
        <br/>
        <input type="submit" value="Edit" />
        <input type="submit" value="Bill Payment"/>
        </form>
    </body>
</html>
