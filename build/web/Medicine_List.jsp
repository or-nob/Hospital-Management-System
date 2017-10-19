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
        <form method="post" action="Medicine_Control1.do">
        <h1>Medicine List:</h1>
        <br/>
        <%!String m;%>
        <%
            ArrayList<MedicineInfo> MedicineList = (ArrayList<MedicineInfo> ) session.getAttribute("medicineList");
            for(int i = 0; i < MedicineList.size(); i++){
                m = Integer.toString(i);
                %>
                <
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
        <input type="submit" value="Ok" name="Done"/>
        </form>
    </body>
</html>
