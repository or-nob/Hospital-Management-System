<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <jsp:include page="Navigation_Admin.jsp" /> 
            <form method="post" action="Patient_Account.do">
            <h1>Patient Admission:</h1>
            <%!String name;%>
                Enter Patient name: <input type="text" name="username" /> <br/>
                Enter Patient Phone Number: <input type="text" name="phone_number" /> <br/>
                Enter Patient Email: <input type="text" name="email" /> <br/>
                Enter Patient Sex: <input type="text" name="sex" /> <br/>
                Enter Patient Date of Birth: <input type="text" name="dob" /> <br/>
                Enter Patient Date of Join: <input type="text" name="dot" /> <br/>
                Enter Patient Address: <input type="text" name="address" /> <br/>
                Doctor's Fee: <input type="text" name="fee" /> <br/>
                Allocate Doctor: 
                <%
                    name = (String) session.getAttribute("name");
                    //out.println(name);
                %>
                <input value = <%=name%> name="DocName" />
                <br/>
                Allocate Room & Seat: <input type="submit" value="Select Room" name="Select"/> <br/>
                <br/>
                Seat's Fee: <input type="text" name="sfee" /> <br/>
                <br/>
                <br/>
                <input type="submit" value="Done" name="done_patient" />
        </form>
        <br/>
        
    </body>
</html>

