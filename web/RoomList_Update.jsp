<%-- 
    Document   : DocList
    Created on : Dec 15, 2016, 2:52:59 PM
    Author     : user
--%>

<%@page import="Models.RoomInfo"%>
<%@page import="Models.DoctorInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Room List</title>
    </head>
    <body>
        <jsp:include page="Navigation_Admin.jsp" /> 
        <form method="post" action="Update_Patient_Seat.do">
        <h1>Room List:</h1>
        <br/>
        <%!String m, s_no, aid;%>
        <%
            ArrayList<RoomInfo> RoomList = (ArrayList<RoomInfo> ) session.getAttribute("RoomList");
            s_no = (String) session.getAttribute("seat_no");
            aid = (String) session.getAttribute("a_id");
            for(int i = 0; i < RoomList.size(); i++){
                m = Integer.toString(i);
                %>
                <input type="radio" value=<%=m%> name="Select"/>
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
        <b>Your previous room:</b> 
        <input type="hidden" name="a_id" value= <%=aid%> /><br/>
        <input name="seat_no" value = <%=s_no%> /><br/>
        <input type="submit" value="Update" name="Selected_Room"/>
        </form>
    </body>
</html>
