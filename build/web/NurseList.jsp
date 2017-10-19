<%-- 
    Document   : NurseList
    Created on : Dec 16, 2016, 3:10:08 PM
    Author     : user
--%>

<%@page import="Models.NurseInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nurse List</title>
    </head>
    <body>
        <jsp:include page="Navigation_Admin.jsp" /> 
        <form method="post" action="NurseList.do">
        <%!String RoomNo, SeatNo;%>
        <%
            RoomNo = (String) session.getAttribute("RoomNo");
            SeatNo = (String) session.getAttribute("SeatNo");
        %>
        <h1>Room No:  Seat No:</h1>
        <input value = <%=RoomNo%> name="RoomNo" />
        <input value = <%=SeatNo%> name="SeatNo" />
        <h1>Nurse List:</h1>
        <br/>
        <%!String m;%>
        <%
            ArrayList<NurseInfo> NurseList = (ArrayList<NurseInfo> ) session.getAttribute("NurseList");
            for(int i = 0; i < NurseList.size(); i++){
                m = Integer.toString(i);
                %>
                <input type="radio" value=<%=m%> name="Select"/>
        <b>Name:</b>
                <%
                out.println(NurseList.get(i).getnname());
                %>
                <b>&nbsp;&nbsp;Degree:</b>
                <%
                out.println(NurseList.get(i).getndegree());
        %>
        <br/>
        <br/>
        <%
            }
        %>
        <input type="submit" value="Ok" name="Selected_ Nurse"/>
        </form>
    </body>
</html>
