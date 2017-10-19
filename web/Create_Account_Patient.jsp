<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <jsp:include page="Navigation_Admin.jsp" /> 
            <form method="post" action="Create_An_Account_Patient.do">
            <h1>Patient Admission:</h1>
                Enter Patient name: <input type="text" name="username" /> <br/>
                Enter Patient Phone Number: <input type="text" name="phone_number" /> <br/>
                Enter Patient Email: <input type="text" name="email" /> <br/>
                Enter Patient Sex: <input type="text" name="sex" /> <br/>
                Enter Patient Date of Birth: <input type="text" name="dob" /> <br/>
                Enter Patient Date of Join: <input type="text" name="dot" /> <br/>
                Enter Patient Address: <input type="text" name="address" /> <br/>
                Doctor's Fee: <input type="text" name="fee" /> <br/>
                Allocate Doctor: <input type="submit" value="Select Doctor" name="Select"/> <br/> 
                Allocate Room & Seat: <input type="submit" value="Select Room" name="Select"/> <br/> 
                Seat's Fee: <input type="text" name="sfee" /> <br/>
                <br/>
                <input type="submit" value="Done" />
        </form>
        <br/>
        
    </body>
</html>

