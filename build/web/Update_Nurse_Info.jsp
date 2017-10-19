<%-- 
    Document   : Update_Doctor_Info
    Created on : Dec 20, 2016, 10:06:31 AM
    Author     : user
--%>

<%@page import="Models.NurseInfo"%>
<%@page import="Models.DoctorInfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="Navigation_Admin.jsp" /> 
        <form method="post" action="Nurse_Info_Update_Control.do">
        <%!String dname, daddress, dsex, dphone, dinstitute, degree, dob, dot, demail, eid;%>
        <%
            NurseInfo obj = (NurseInfo) session.getAttribute("NurseInfo");
            dname = obj.getnname();
            daddress = obj.getnaddress();
            degree = obj.getndegree();
            dob = obj.getndob();
            dot = obj.getndot();
            eid = obj.getnid();
            demail = obj.getnemail();
            dinstitute = obj.getninstitute();
            dsex = obj.getnsex();
            dphone = obj.getnphone();
        %>
        <b>Update Information for Doctor ID:</b><input type="text" name = "eid" value=<%=eid%> readonly><br/>
        <br/>
        Edit Name: <input name = "nname" value=<%=dname%> /><br/>
        Edit Phone: <input name = "nphone" value=<%=dphone%> /><br/>
        Edit Email: <input name = "nemail" value=<%=demail%> /><br/>
        Edit Date of Birth: <input name = "dob" value=<%=dob%> /><br/>
        Edit Date of Join: <input name = "dot" value=<%=dot%> /><br/>
        Edit Degree: <input name = "degree" value=<%=degree%> /><br/>
        Edit Institute: <input name = "ninstitute" value=<%=dinstitute%> /><br/>
        Edit Sex: <input name = "nsex" value=<%=dsex%> /><br/>
        Edit Address: <input name = "naddress" value=<%=daddress%> /><br/>
        <input type="submit" value="Update" name="select"/><br/>
        </form>
    </body>
</html>
