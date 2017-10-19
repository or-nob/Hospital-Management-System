<%-- 
    Document   : Update_Doctor_Info
    Created on : Dec 20, 2016, 10:06:31 AM
    Author     : user
--%>

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
        <form method="post" action="Doctor_Info_Update_Control.do">
        <%!String dname, daddress, dsex, dphone, dinstitute, degree, dob, dot, demail, eid;%>
        <%
            DoctorInfo obj = (DoctorInfo) session.getAttribute("DocInfo");
            dname = obj.getdname();
            daddress = obj.getdaddress();
            degree = obj.getddegree();
            dob = obj.getddob();
            dot = obj.getddot();
            eid = obj.getdeid();
            demail = obj.getdemail();
            dinstitute = obj.getdinstitute();
            dsex = obj.getdsex();
            dphone = obj.getdphone();
        %>
        <b>Update Information for Nurse ID:</b><input type="text" name = "eid" value=<%=eid%> readonly><br/>
        <br/>
        Edit Name: <input name = "dname" value=<%=dname%> /><br/>
        Edit Phone: <input name = "dphone" value=<%=dphone%> /><br/>
        Edit Email: <input name = "demail" value=<%=demail%> /><br/>
        Edit Date of Birth: <input name = "dob" value=<%=dob%> /><br/>
        Edit Date of Join: <input name = "dot" value=<%=dot%> /><br/>
        Edit Degree: <input name = "degree" value=<%=degree%> /><br/>
        Edit Institute: <input name = "dinstitute" value=<%=dinstitute%> /><br/>
        Edit Sex: <input name = "dsex" value=<%=dsex%> /><br/>
        Edit Address: <input name = "daddress" value=<%=daddress%> /><br/>
        <input type="submit" value="Update" name="select"/><br/>
        </form>
    </body>
</html>
