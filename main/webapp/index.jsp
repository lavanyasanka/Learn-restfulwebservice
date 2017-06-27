<html>
    <head>
        <title>REST with Forms</title>
        <meta http-equiv="Content-Type" content="application/xml"; charset=UTF-8">
    </head>
<body>
<!--     <h2>Jersey RESTful Web Application!</h2>
    <p><a href="webapi/myresource">Jersey resource</a>
    <p>Visit <a href="http://jersey.java.net">Project Jersey web site</a>
    for more information on Jersey! -->
    <h1>Input Student Details</h1>
    <br />
        <form action="webapi/student/createform" method="post">
            Student Name:  <input type="text" name="sname" /><br />
            Student Marks: <input type="number" name="smarks"  /><br />
            Student Id:    <input type="number" name="sid"  /><br />
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
