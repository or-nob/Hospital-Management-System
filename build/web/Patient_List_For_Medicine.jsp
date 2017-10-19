<%-- 
    Document   : Patient_List_For_Medicine
    Created on : Dec 17, 2016, 8:05:19 PM
    Author     : user
--%>

<%@page import="Models.PatientInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>Patient List:</title>
    </head>
    <body>
        <jsp:include page="Navigation_Admin.jsp" /> 
        <form method="post" action="Medicine_Control.do">
        <h1>Select Patient:</h1>
        <br/>
        <%!String m;%>
        <%
            ArrayList<PatientInfo> PatientList = (ArrayList<PatientInfo> ) session.getAttribute("PatientList");
            for(int i = 0; i < PatientList.size(); i++){
                m = Integer.toString(i);
                %>
                <input type="radio" value=<%=m%> name="Select"/>
        <b>Patient Name:</b>
        <%
            out.println(PatientList.get(i).getpname());
        %>
        <b>&nbsp;&nbsp;Patient ID:</b>
        <%
            out.println(PatientList.get(i).getpid());
        %>
        <b>&nbsp;&nbsp;Admission ID:</b>
        <%
            out.println(PatientList.get(i).getaid());
        %>
        <br/>
        <br/>
        <br/>
        <%
            }
        %>
        <input type="submit" value="Medicine List" name="Selected_Medicine"/>
        <input type="submit" value="Allocate Medicine" name="Selected_Medicine"/>
        </form>
    </body>
</html>
