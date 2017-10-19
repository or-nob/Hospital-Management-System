<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Test</title>
    </head>
    <body>
        <jsp:include page="Navigation_Admin.jsp" /> 
        <form method="post" action="Test_Update_Management.do">
        <h1>Edit the  for:</h1>
        <%!String pt_name, a_id, t_name, tt_id, t_day, t_id, t_fee, t_red_fee; %> 
        <%
            pt_name = (String) session.getAttribute("pt_name");
            a_id = (String) session.getAttribute("a_id");
            t_id = (String) session.getAttribute("d_test_ID");
            t_name = (String) session.getAttribute("test_name");
            t_day = (String) session.getAttribute("test_day");
            t_fee = (String) session.getAttribute("test_fee");
            t_red_fee = (String) session.getAttribute("d_test_fee");
            tt_id = (String) session.getAttribute("tt_id");
            //ts_fee = Integer.toString(t_fee);
        %>
        <b>Patient Name: &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;Admission ID:</b><br/>
        <input  value=<%=pt_name%> name="pname"/>
        <input  value=<%=a_id%> name="aid"/><br/>
        <br/>
        <br/>
        <b>Test ID:&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;Test Type Id:</b><br/>
        <input  value=<%=t_id%> name="tid"/>
        <input  value=<%=tt_id%> name="ttid"/><br/>
        <br/>
        <br/>
        Edit Name:<input  value=<%=t_name%> name="ttname"/><br/>
        <br/>
        <br/>
        Edit Date:<input  value=<%=t_day%> name="tday"/><br/>
        <br/>
        <br/>
        Edit Original Fee:<input  value=<%=t_fee%> name="tfee"/><br/>
        <br/>
        <br/>
        Edit Reduced Fee:<input  value=<%=t_red_fee%> name="tredfee"/><br/>
        <br/>
        <br/>
        <input type="submit" value="Update" name="Updated_Info"/><br/>
        </form>
    </body>
</html>