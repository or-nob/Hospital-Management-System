<%@page import="Models.DoctorInfo"%>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <jsp:include page="Navigation_Admin.jsp" /> 
        <form method="post" action="LoginPageD.do">
            <h1>Doctor Profile:</h1>
        <br/>
        <b>Name:</b>
        <%
            DoctorInfo result = (DoctorInfo) session.getAttribute("doctorInfo");
            out.println(result.getdname());
        %>
        <br/>
        <br/>
        <b>Phone Number:</b>
        <%
            out.println(result.getdphone());
        %>
        <br/>
        <br/>
        <b>Address:</b>
        <%
            out.println(result.getdaddress());
        %>
        <br/>
        <br/>
        <b>Email:</b>
        <%
            out.println(result.getdemail());
        %>
        <br/>
        <br/>
        <b>Institution:</b>
        <%
            out.println(result.getdinstitute());
        %>
        <br/>
        <br/>
        <b>Date of Birth:</b>
        <%
            out.println(result.getddob());
        %>
        <br/>
        <br/>
        <b>Date of Join:</b>
        <%
            out.println(result.getddot());
        %>
        <br/>
        <br/>
        <b>Sex:</b>
        <%
            out.println(result.getdsex());
        %>
        <br/>
        <br/>
        <input type="submit" value="Edit" />
        <input type="submit" value="See Assignment"/>
        </form>
    </body>
</html>

