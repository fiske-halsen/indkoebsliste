<%--
  Created by IntelliJ IDEA.
  User: phill
  Date: 02-03-2020
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Opret bruger</title>
</head>
<body>

Her kan du registrere dig som bruger på huskelisten
<br>
<br>
<br>
${requestScope.besked}
<br>
<br>

<form action="OpretServlet" method="post">
    <label for="fname">First name:</label><br>
    <input type="text" id="fname" name="navn" ><br>
    <label for="lname">Last name:</label><br>
    <input type="text" id="lname" name="kodeord"><br><br>
    <input type="submit" value="Opret">
</form>



</body>
</html>
