<%--
    Document   : admin_principal
    Created on : 28/05/2018, 05:01:56
    Author     : hdolz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href=" <c:url value="/resources/css/bootstrap.min.css" />" />
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NERDEX - Area Administrador</title>
    </head>
    <body>

        <div class="container">
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <h3>Categoria</h3>
                    <a href="${pageContext.request.contextPath}/form-adicionar-categoria"><button type="button" class="btn btn-primary btn-lg btn-block">Inserir</button></a><br>
                    <a href="${pageContext.request.contextPath}/listarCategoria"><button type="button" class="btn btn-primary btn-lg btn-block"> Listar </button></a><br>
                    <a href="${pageContext.request.contextPath}/admin-principal"> <button type="button" class="btn btn-outline-info">Voltar</button></a>
                </div>
                <div class="col-md-4"></div>
            </div>
        </div>

        <!-- Aqui vão configuração de js e css -->
        <script src="<c:url value="/resources/js/jquery-3.3.1.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    </body>
</html>
