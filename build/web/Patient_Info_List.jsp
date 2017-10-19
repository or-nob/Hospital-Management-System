<%-- 
    Document   : PatientList
    Created on : Dec 18, 2016, 8:41:42 PM
    Author     : user
--%>

<%@page import="Models.PatientInfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="Navigation_Admin.jsp" /> 
        <form method="post" action="Update_Patient_Info.do">
        <h1>Edit Patient Info:</h1>
        <%!String aid, docid, pid, name, seat_no, doc_name, ph_no, mail, sex, dob, doj, address;%>
        <%
            PatientInfo obj = (PatientInfo) session.getAttribute("patientInfo");
            pid = obj.getpid();
            name = obj.getpname();
            ph_no = obj.getpphone();
            mail = obj.getpemail();
            sex = obj.getpsex();
            dob = obj.getpdob();
            aid = obj.getaid();
            seat_no = (String) session.getAttribute("SeatNo");
            doc_name = (String) session.getAttribute("DocName");
            docid = (String) session.getAttribute("DocID");
        %>
        <b>Information Update for Patient ID & Admission ID</b>
        <input value = <%=pid%> name="pid" />:<br/>
        <input value = <%=aid%> name="aid" />:<br/>
        Patient Name: <input value = <%=name%> name="name" /><br/>
        Patient Phone No: <input value = <%=ph_no%> name="phone_no" /><br/>
        Patient Email: <input value = <%=mail%> name="mail" /><br/>
        Patient Sex:<input value = <%=sex%> name="sex" /><br/>
        Patient Date of Birth:<input value = <%=dob%> name="dob" /><br/>
        Change Doctor: <input value = <%=doc_name%> name="doc_name" /> <input value = <%=docid%> name="doc_eid" /><input type="submit" value="Change Doc" name="Select"/> <br/> 
        Change Seat: <input value = <%=seat_no%> name="seat_no" /><input type="submit" value="Change Seat" name="Select"/> <br/>
        <input type="submit" value="Ok" name="Select"/><br/>
        </form>
    </body>
</html>