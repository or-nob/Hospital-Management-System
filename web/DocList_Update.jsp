<%-- 
    Document   : DocList
    Created on : Dec 15, 2016, 2:52:59 PM
    Author     : user
--%>

<%@page import="Models.DoctorInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctor List</title>
    </head>
    <body>
        <jsp:include page="Navigation_Admin.jsp" /> 
        <form method="post" action="Update_Patient_Doctor.do">
        <h1>Doctor List:</h1>
        <br/>
        <%!String m, doc_id, doc_name, pid, aid;%>
        <%
            aid = (String) session.getAttribute("aid");
            pid = (String) session.getAttribute("pid");
            doc_id = (String) session.getAttribute("docid");
            doc_name = (String) session.getAttribute("doc_name");
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
        Patient's ID & Admission ID = <input value=<%=pid%> name="pid"/><input value=<%=aid%> name="aid"/><br/>
        <input type="hidden" value=<%=doc_name%> name="Prev_Doctor"/><input type="hidden" value=<%=doc_id%> name="Prev_Doctor_Id"/><br/>
        <input type="submit" value="Update" name="Selected_Doctor"/>
        <input type="submit" value="Add" name="Selected_Doctor"/>
        </form>
    </body>
</html>
