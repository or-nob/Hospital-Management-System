<%@page import="Models.NurseInfo"%>
<%@page import="Models.DoctorInfo"%>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form method="post" action="LoginPageN.do">
            <h1>Nurse Profile:</h1>
        <br/>
        <b>Name:</b>
        <%
            NurseInfo result = (NurseInfo) session.getAttribute("nurseInfo");
            out.println(result.getnname());
        %>
        <br/>
        <br/>
        <b>Phone Number:</b>
        <%
            out.println(result.getnphone());
        %>
        <br/>
        <br/>
        <b>Address:</b>
        <%
            out.println(result.getnaddress());
        %>
        <br/>
        <br/>
        <b>Email:</b>
        <%
            out.println(result.getnemail());
        %>
        <br/>
        <br/>
        <b>Institution:</b>
        <%
            out.println(result.getninstitute());
        %>
        <br/>
        <br/>
        <b>Date of Birth:</b>
        <%
            out.println(result.getndob());
        %>
        <br/>
        <br/>
        <b>Date of Join:</b>
        <%
            out.println(result.getndot());
        %>
        <br/>
        <br/>
        <b>Sex:</b>
        <%
            out.println(result.getnsex());
        %>
        <br/>
        <br/>
        <input type="submit" value="Edit" />
        <input type="submit" value="See Allocation For Nurse"/>
        </form>
    </body>
</html>

