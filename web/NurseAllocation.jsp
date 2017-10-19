<%-- 
    Document   : NurseAllocation
    Created on : Dec 16, 2016, 3:19:37 PM
    Author     : user
--%>

<%@page import="Models.RoomInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nurse Allocation</title>
    </head>
    <body>
        <jsp:include page="Navigation_Admin.jsp" /> 
        <form method="post" action="NurseManagement.do">
        <h1>Room List:</h1>
        <br/>
        <%!String m;%>
        <%
            ArrayList<RoomInfo> RoomList = (ArrayList<RoomInfo> ) session.getAttribute("RoomList");
            for(int i = 0; i < RoomList.size(); i++){
                m = Integer.toString(i);
                %>
                <input type="radio" value=<%=m%> name="Select_Room"/>
        <b>Room No:</b>
        <%
            out.println(RoomList.get(i).getroomNo());
        %>
        <b>&nbsp;&nbsp;Room Fee:</b>
        <%
            out.println(RoomList.get(i).getroomfee());
        %>
        <b>&nbsp;&nbsp;Seat No:</b>
        <%
            out.println(RoomList.get(i).getseatNo());
        %>
        <b>&nbsp;&nbsp;Room Fee:</b>
        <%
            out.println(RoomList.get(i).getseatfee());
        %>
        <br/>
        <br/>
        <br/>
        <%
            }
        %>
        <input type="submit" value="Nurse List" name = "Select"/><br/>
        <input type="submit" value="Allocation Chart" name = "Select"/><br/>
        </form>
    </body>
</html>
