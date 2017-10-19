<%-- 
    Document   : Service_Page
    Created on : Dec 7, 2016, 12:43:03 PM
    Author     : user
--%>

<%@page import="Models.DoctorInfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control</title>
    </head>
    <body>
        <jsp:include page="Navigation_Admin.jsp" /> 
        <form method="post" action="LoginPageA.do">
            <h1>Doctor Profile:</h1>
        <br/>
        <b>Name:</b>
        <%
            DoctorInfo result = (DoctorInfo) session.getAttribute("doctorInfo");
            out.println(result.getdname());
        %>
        <br/>
        <br/>
        <b>Phone Number:</b>
        <%
            out.println(result.getdphone());
        %>
        <br/>
        <br/>
        <b>Address:</b>
        <%
            out.println(result.getdaddress());
        %>
        <br/>
        <br/>
        <b>Email:</b>
        <%
            out.println(result.getdemail());
        %>
        <br/>
        <br/>
        <b>Institution:</b>
        <%
            out.println(result.getdinstitute());
        %>
        <br/>
        <br/>
        <b>Date of Birth:</b>
        <%
            out.println(result.getddob());
        %>
        <br/>
        <br/>
        <b>Date of Join:</b>
        <%
            out.println(result.getddot());
        %>
        <br/>
        <br/>
        <b>Sex:</b>
        <%
            out.println(result.getdsex());
        %>
        <br/>
        <br/>
        <input type="submit" value="Edit" />
        <input type="submit" value="See Assignment"/>
        </form>
    </body>
</html>
