<%-- 
    Document   : form_usuario_cadastro
    Created on : 26/05/2018, 11:43:23
    Author     : gustav0
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NERDEX - Area Administrador</title>

    </head>
    <body>

        <div class="container">
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <h3>Cadastrar Categoria</h3>
                    <form method="post"  action="${pageContext.request.contextPath}/adicionarCategoria">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Nome</label>
                            <input name="tfNome" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Digite seu nome">
                        </div>
                        <button type="submit" class="btn btn-primary">Confirmar</button>
                        <a href="${pageContext.request.contextPath}/crudCategoria"> Voltar </a>
                    </form>
                </div>
                <div class="col-md-4"></div>
            </div>
        </div>

        <!-- Aqui vão configuração de js e css -->
        <script src="<c:url value="/resources/js/jquery-3.3.1.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    </body>
</html>