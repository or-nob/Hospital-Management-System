<%-- 
    Document   : Create_New_Medicine
    Created on : Dec 17, 2016, 8:22:15 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Medicine</title>
    </head>
    <body>
        <form method="post" action="Allocation_Medicine.do">
        <%! String pname, aid;%>
        <h1>New Medicine </h1>
        <%
            pname = (String) session.getAttribute("Patient_Name");
            aid = (String) session.getAttribute("A_ID");
        %>
        <b>Patient Name: Admission ID:</b><br/>
        <input value = <%=pname%> name="pname" />
        <input value = <%=aid%> name="A_ID" /><br/>
        <br/>
        Enter Medicine name: <input type="text" name="mname" /> <br/>
        <br/>
        Enter Generic Medicine Name: <input type="text" name="gmname" /> <br/>
        <br/>
        Enter Price: <input type="text" name="price" /> <br/>
        <br/>
        Enter Quantity: <input type="text" name="quantity" /> <br/>
        <br/>
        <input type="submit" value="Ok" name="Create_Medicine"/>
        </form>
    </body>
</html>
