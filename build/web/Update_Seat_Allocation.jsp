<%-- 
    Document   : Update_Seat_Allocation
    Created on : Dec 19, 2016, 8:35:04 AM
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
        <form method="post" action="Room_Update_Management.do">
        <h1>Edit the Seat Allocation for:</h1>
        <%!String sday, a_id, t_name, eday, cost, u_s_no, u_r_no; %> 
        <%
            a_id = (String) session.getAttribute("a_id");
            sday = (String) session.getAttribute("sday");
            cost = (String) session.getAttribute("cost");
            eday = (String) session.getAttribute("eday");
            u_s_no = (String) session.getAttribute("u_s_no");
            u_r_no = (String) session.getAttribute("u_r_no");
            //out.println(a_id);
        %>
        <b>AID:</b><input value = <%=a_id%> name="a_id" /><br/>
        <br/>
        <br/>
        <b>New Seat No:</b><input name="u_s_no" value = <%=u_s_no%> /><br/>
        <b>New Room No:</b><input name="u_r_no" value = <%=u_r_no%>  /><br/>
        <br/>
        <b>Change Start Date:</b><input name="sday" value = <%=sday%> /><br/>
        <b>Change Cost:</b><input name="cost" value = <%=cost%> /><br/>
        <b>Change End Date:</b><input name="eday" value = <%=eday%> /><br/>
        <input type="submit" value="Update" name="Updated_Seat_Info"/><br/>
        </form>
    </body>
</html>
