<%-- 
    Document   : Medicine_List
    Created on : Dec 18, 2016, 7:37:28 AM
    Author     : user
--%>

<%@page import="Models.MedicineInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Medicine List</title>
    </head>
    <body>
        <jsp:include page="Navigation_Admin.jsp" /> 
        <form method="post" action="Editing_Medicine_Info.do">
        <h1>Medicine List:</h1>
        <br/>
        <%!String m, ptname, aid;%>
        <%
            ptname = (String) session.getAttribute("pt_name");
            aid = (String) session.getAttribute("a_id");
            ArrayList<MedicineInfo> MedicineList = (ArrayList<MedicineInfo> ) session.getAttribute("medicineList");
            for(int i = 0; i < MedicineList.size(); i++){
                m = Integer.toString(i);
                %>
                <input type="radio" value=<%=m%> name="Select"/>
                <b>Name:</b>
                <%
                out.println(MedicineList.get(i).getmname());
                %>
                <b>&nbsp;&nbsp;Price:</b>
                <%
                out.println(MedicineList.get(i).getmprice());
                %>
                <b>&nbsp;&nbsp;Quantity:</b>
                <%
                out.println(MedicineList.get(i).getquantity());
                %>
        <br/>
        <br/>
        <%
            }
        %>
        <b>Patient Name & AID</b>
        <input value=<%=ptname%> name="pt_name"/>
        <input value=<%=aid%> name="a_id"/><br/>
        <br/>
        <input type="submit" value="Update" name="Medicine"/>
        </form>
    </body>
</html>
