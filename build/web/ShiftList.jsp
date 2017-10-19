<%-- 
    Document   : Shift_List
    Created on : Dec 16, 2016, 6:23:41 PM
    Author     : user
--%>

<%@page import="Models.ShiftInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shift</title>
    </head>
    <body>
        <body><jsp:include page="Navigation_Admin.jsp" /> 
        <form method="post" action="Allocating_Nurse.do">
        <%!String RoomNo, SeatNo, NurseName, NurseID;%>
        <%
            RoomNo = (String) session.getAttribute("room_No");
            SeatNo = (String) session.getAttribute("seat_No");
            NurseName = (String) session.getAttribute("NurseName");
            NurseID = (String) session.getAttribute("NurseID");
        %>
        <h1>Room No:  Seat No:</h1>
        <input value = <%=RoomNo%> name="RoomNo" />
        <input value = <%=SeatNo%> name="SeatNo" />
        <br/>
        <br/>
        <br/>
        <h1>Nurse Name: NID:</h1>
        <input value = <%=NurseName%> name="NurseName" />
        <input value = <%=NurseID%> name="NurseID" />
        <br/>
        <br/>
        <br/>
        Allocation Date: <input type = "text" name="All_date" />
        Release Date: <input type = "text" name="Rel_date" />
        <h1>Shift List:</h1>
        <br/>
        <%!String m;%>
        <%
            ArrayList<ShiftInfo> ShiftList = (ArrayList<ShiftInfo> ) session.getAttribute("ShiftList");
            for(int i = 0; i < ShiftList.size(); i++){
                m = Integer.toString(i);
                %>
                <input type="radio" value=<%=m%> name="Select"/>
        <b>Shift Day:</b>
        <%
            out.println(ShiftList.get(i).getshiftday());
        %>
        <b>&nbsp;&nbsp;Shift Fee:</b>
        <%
            out.println(ShiftList.get(i).getshiftfee());
        %>
        <b>&nbsp;&nbsp;Time Line:</b>
        <%
            out.println(ShiftList.get(i).gettimeline());
        %>
        <br/>
        <br/>
        <br/>
        <%
            }
        %>
        <input type="submit" value="Ok" name="Selected_Shift"/>
        </form>
    </body>
</html>
