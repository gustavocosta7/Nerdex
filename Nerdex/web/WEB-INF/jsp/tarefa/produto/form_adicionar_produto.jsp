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
                    <h3>Cadastrar Produto</h3>
                    <form method="post"  enctype="multipart/form-data" action="${pageContext.request.contextPath}/adicionarProduto">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Nome</label>
                            <input name="tfNome" type="text" class="form-control" placeholder="Nome do produto">
                            <label for="exampleInputEmail1">Categoria</label>
                            <select name="tfCategoria" class="custom-select" id="idCategorias" required>
                                <option selected>Escolha uma...</option>
                                <c:forEach items="${listaCategorias}" var="categoria">
                                    <option value="${categoria.catid}">${categoria.catdes}</option>
                                </c:forEach>
                            </select>
                            <label>Preco</label>
                            <input name="tfPreco" type="text" class="form-control" placeholder="Preco do produto">
                            <span for="idDesc">Descrição</span>
                            <textarea name="tfDesc"  id="idDesc" class="form-control" required></textarea>
                            <label>Foto do produto</label>
                            <input name="tfFoto" type="file" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-primary">Confirmar</button>
                        <a href="${pageContext.request.contextPath}/crudProduto"> <button type="button" class="btn btn-outline-info">Voltar</button></a>
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
