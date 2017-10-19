<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <jsp:include page="Navigation_Admin.jsp" /> 
            <form method="post" action="Patient_Account_Room.do">
            <h1>Patient Admission:</h1>
            <%!String name, room, seat;%>
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
                Allocate Room & Seat:
                <%
                    room = (String) session.getAttribute("room");
                %>
                <input value = <%=room%> name="RoomName" />
                <%
                    seat = (String) session.getAttribute("seat");
                %>
                <input value = <%=seat%> name="SeatName" />
                <br/>
                Seat's Fee: <input type="text" name="sfee" /> <br/>
                <br/>
                <br/>
                <input type="submit" value="Done" name="done_patient" />
        </form>
        <br/>
        
    </body>
</html>

