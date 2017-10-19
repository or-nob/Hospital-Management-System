<%-- 
    Document   : Update_Medicine
    Created on : Dec 19, 2016, 1:10:54 PM
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
        <form method="post" action="Patient_Medicine_Update.do">
            <%!String gname, gmid, mname, mprice, quantity, pname, aid;%>
            <%
                gname = (String) session.getAttribute("gname");
                gmid = (String) session.getAttribute("gmid");
                mname = (String) session.getAttribute("mname");
                mprice = (String) session.getAttribute("mprice");
                quantity = (String) session.getAttribute("quantity");
                pname = (String) session.getAttribute("pname");
                aid = (String) session.getAttribute("aid");
            %>
            <h1>Update Medicine Info For Patient Name & AID:</h1>
            <input value=<%=pname%> name="pname"/>
            <input value=<%=aid%> name="aid"/>
            <br/>
            <br/>
            <b>Medicine ID:</b><input value=<%=gmid%> name="gmid"/><br/>
            <br/>
            Edit Generic Name: <input value=<%=gname%> name="gname"/><br/>
            Edit Medicine Name: <input value=<%=mname%> name="mname"/><br/>
            Edit Price: <input value=<%=mprice%> name="mprice"/><br/>
            Edit Quantity: <input value=<%=quantity%> name="quantity"/><br/>
            <input type="submit" value="Update" name="Updated_Medicine"/>
        </form>
    </body>
</html>
