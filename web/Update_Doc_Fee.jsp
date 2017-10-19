<%-- 
    Document   : Update_Doc_Fee
    Created on : Dec 19, 2016, 11:25:37 AM
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
        <form method="post" action="Update_Doctor_Control.do">
        <h1>Edit Doctor's Fee
        <%!String update ,p_id,a_id, p_doc_name, n_doc_name,p_doc_id,n_doc_id,p_doc_fee;%>
        <%
            update = (String) session.getAttribute("Update");
            p_id = (String) session.getAttribute("pid");
            a_id = (String) session.getAttribute("aid");
            p_doc_name = (String) session.getAttribute("p_doc_name");
            n_doc_name = (String) session.getAttribute("n_doc_name");
            p_doc_id = (String) session.getAttribute("p_doc_id");
            n_doc_id = (String) session.getAttribute("n_doc_id");
            p_doc_fee = (String) session.getAttribute("p_doc_fee");
        %>
        <input type = "hidden" value=<%=update%> name="Update1"/>
        For Patient ID & Admission ID:</h1>
        <input value=<%=p_id%> name="pid"/><input value=<%=a_id%> name="aid"/><br/>
        <input type="hidden" value=<%=p_doc_name%> name="p_doc_name"/><br/>
        <input type="hidden" value=<%=p_doc_id%> name="p_doc_id"/><br/>
        <b>New Doctor's Name:</b><br/>
        <input value=<%=n_doc_name%> name="n_doc_name"/><br/>
        <b>New Doctor's ID:</b><br/>
        <input value=<%=n_doc_id%> name="n_doc_id"/><br/>
        <b>Change Fee:</b>
        <input value=<%=p_doc_fee%> name="p_doc_fee"/><br/>
        <br/>
        <input type = "submit" value="Update" name="Update"/>
        </form>
    </body>
</html>
