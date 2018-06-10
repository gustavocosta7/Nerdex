<%-- 
    Document   : formAdicionaTarefa
    Created on : 14/05/2018, 15:17:56
    Author     : Aluno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adiciona Tarefa</title>
    </head>
    <body>
        <h1>Adicionar usuário</h1>
        <form action="<c:url value="/adicionaUsuario"/>" method="post">
            Nome
            <br>
            <input type="text" name="tfNome"/>
            <br>
            Login
            <br>
            <input type="text" name="tfLogin"/>
            <br>
            Senha
            <br>
            <input type="text" name="tfSenha"/>
            <br>
           
            <input type="submit" value="Adcionar">
        
        </form>
    </body>
</html>
