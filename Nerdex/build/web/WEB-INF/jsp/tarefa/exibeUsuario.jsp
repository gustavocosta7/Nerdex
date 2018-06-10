<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
    <body>
        <h3>Alterar usuario - ${usuario.usuid}</h3>
        <form action="<c:url value='/alteraUsuario'/>" method="post">
            <input type="hidden" name="usuid" value="${usuario.usuid}" />
            
            <br>Nome<br>
            <input type="text" name="usunome" value="${usuario.usunome}"/>
            <br>Login<br>
            <input type="text" name="usulogin" value="${usuario.usulogin}"/>
            <br>Senha<br>
            <input type="text" name="ususenha" value="${usuario.ususenha}"/><br>
           
            <input type="submit" value="Alterar"/>
            <br><br>            
        </form>
    </body>
</html>