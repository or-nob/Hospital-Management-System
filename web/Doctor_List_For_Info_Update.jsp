<%-- 
    Document   : Doctor_List_For_Info_Update
    Created on : Dec 20, 2016, 9:32:48 AM
    Author     : user
--%>

<%@page import="Models.DoctorInfo"%>
<%@page import="java.util.ArrayList"%>
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
        <form method="post" action="Update_Doc_Info.do">
        <h1>Doctor List:</h1>
        <br/>
        <%!String m;%>
        <%
            ArrayList<DoctorInfo> DoctorList = (ArrayList<DoctorInfo> ) session.getAttribute("DocList");
            for(int i = 0; i < DoctorList.size(); i++){
                m = Integer.toString(i);
                %>
                <input type="radio" value=<%=m%> name="Select"/>
        <b>Name:</b>
                <%
                out.println(DoctorList.get(i).getdname());
                %>
                <b>&nbsp;&nbsp;Degree:</b>
                <%
                out.println(DoctorList.get(i).getddegree());
        %>
        <br/>
        <br/>
        <%
            }
        %>
        <input type="submit" value="Update" name="Selected_Doctor"/>
        </form>
    </body>
</html>
