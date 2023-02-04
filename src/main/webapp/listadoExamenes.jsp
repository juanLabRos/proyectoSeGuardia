<%-- 
    Document   : listadoExamenes
    Created on : 04-feb-2023, 11:58:42
    Author     : Jon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${examen}" var="examen">
                <li>${examen.nombreExamen} ${examen.nombreTema} </li>
            </c:forEach>
    </body>
</html>
