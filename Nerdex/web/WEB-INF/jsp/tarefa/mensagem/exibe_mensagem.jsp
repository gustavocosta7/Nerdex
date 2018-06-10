<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
    <body>
        <h3>Exibir mensagem - ${mens.menid}</h3>

        <br>Nome<br>
        <input type="text" name="catdes" value="${mens.mennome}"/>

        <label>Mensagem</label>
        <textarea class="form-control" name="tfMensagem" value="${mens.mendesc}">${mens.mendesc}</textarea>
        
        <br><br>  
        <br>
        <a href="<c:url value='/crudMensagem'/>">Voltar</a>
    </body>
</html>