<%-- 
    Document   : Total_Bill
    Created on : Dec 18, 2016, 10:47:18 AM
    Author     : user
--%>

<%@page import="Models.TestInfo"%>
<%@page import="Models.MedicineInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bill</title>
    </head>
    <body>
        <jsp:include page="Navigation_Admin.jsp" /> 
        <form method="post" action="Medicine_Control.do">
        <h1> Bill: </h1>
        <%!String m, n, p;%>
        <%
            n = (String) session.getAttribute("pname");
            p = (String) session.getAttribute("a_id");
        %>
        <b>Patient Name: &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;Admission ID:</b><br/>
        <input  value=<%=n%> name="pname"/>
        <input  value=<%=p%> name="aid"/><br/>
        <br/>
        <b>Room Bill:</b>
        <%
            ArrayList<Integer> R_Bill = (ArrayList<Integer> ) session.getAttribute("R_Bill");
            for(int i = 0; i < R_Bill.size(); i++){
                m = Integer.toString(i);
                %>
        <%if(i!=0){%>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <%}%>
        <%
                    out.println(R_Bill.get(i));
        %>
        <br/>
        <%
            }
        %>
        <%
            if(R_Bill.size()==0){
                out.println(0);
            }
        %>
        <br/>
        <b>Doctor Bill:</b>
        <%
            ArrayList<Integer> D_Bill = (ArrayList<Integer> ) session.getAttribute("D_Bill");
            for(int i = 0; i < D_Bill.size(); i++){
                m = Integer.toString(i);
                %>
        <%if(i!=0){%>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <%}%>
        <%
                    out.println(D_Bill.get(i));
        %>
        <br/>
        <%
            }
        %>
        <%
            if(D_Bill.size()==0){
                out.println(0);
            }
        %>
        <br/>
        <b>Medicine Bill:</b>
        <%
            ArrayList<MedicineInfo> M_Bill = (ArrayList<MedicineInfo> ) session.getAttribute("M_Bill");
            for(int i = 0; i < M_Bill.size(); i++){
                m = Integer.toString(i);
                %>
        <%if(i!=0){%>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <%}%>
        <%
                    int a = M_Bill.get(i).getmprice()*M_Bill.get(i).getquantity();
                    out.println(a);
        %>
        <br/>
        <%
            }
        %>
        <%
            if(M_Bill.size()==0){
                out.println(0);
            }
        %>
        <br/>
        <b>Test Bill:</b>
        <%
            ArrayList<TestInfo> T_Bill = (ArrayList<TestInfo> ) session.getAttribute("T_Bill");
            for(int i = 0; i < T_Bill.size(); i++){
                m = Integer.toString(i);
                %>
        <%if(i!=0){%>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <%}%>
        <%
                    int a = T_Bill.get(i).gettestfee();
                    out.println(a);
        %>
        <br/>
        <%
            }
        %>
        <%
            if(T_Bill.size()==0){
                out.println(0);
            }
        %>
        <br/>
        <br/>
        <b>Total Bill:</b>
        <%
            String bill = (String) session.getAttribute("TotalBill");
            out.println(bill);
        %>
        <br/>
        <br/>
        <input type="submit" value="Ok" name="Done"/>
        </form>
    </body>
</html>
