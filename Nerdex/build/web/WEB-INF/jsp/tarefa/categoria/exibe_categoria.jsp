<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
    <body>
        <h3>Alterar categoria - ${categoria.catid}</h3>
        <form action="<c:url value='/alterarCategoria'/>" method="post">
            <input type="hidden" name="catid" value="${categoria.catid}" />
            
            <br>Descricao<br>
            <input type="text" name="catdes" value="${categoria.catdes}"/>
           
            <input type="submit" value="Alterar"/>
            <br><br>            
        </form>
        <br>
        <a href="<c:url value='/listarCategoria'/>">Voltar</a>
    </body>
</html>