<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-grid.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-reboot.css"/>"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NERDEX - SUA LOJA NERD</title>
    </head>

    <body>
        <a href="index.jsp"></a>
        <!-- NAVBAR -->
        <div class="container">
            <div class="row">

                <div class="col-md-12">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                                    <a class="navbar-brand" href="${pageContext.request.contextPath}/">NERDEX</a>
                                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                        <span class="navbar-toggler-icon"></span>
                                    </button>

                                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                        <ul class="navbar-nav mr-auto">
                                            <li class="nav-item active">
                                            </li>

                                            <li class="nav-item dropdown">
                                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    Categorias
                                                </a>
                                                <div id="categorias" class="dropdown-menu" aria-labelledby="navbarDropdown">
                                                    <c:forEach items="${listaCategorias}" var="categoria">
                                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/mostrarCategoria?id=${categoria.catid}">${categoria.catdes}</a>
                                                        <div class="dropdown-divider"></div>
                                                    </c:forEach>
                                                </div>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="${pageContext.request.contextPath}/fale_conosco">Fale Conosco <span class="sr-only">(current)</span></a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="${pageContext.request.contextPath}/trabalhe_conosco">Trabalhe conosco <span class="sr-only">(current)</span></a>
                                            </li>
                                            <form class="form-inline my-2 my-lg-0">
                                                <input class="form-control mr-sm-2" type="search" placeholder="Busca produto..." size="10" aria-label="Search">
                                                <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><img src="<c:url value='/resources/img/magnifier.png'></c:url>"/></button>
                                                </form>
                                            </ul>

                                        <c:if test="${cliente.clinome == null}">
                                            <a  class=" btn btn-primary" style="margin-right: 2%" href="${pageContext.request.contextPath}/login">Login</a>
                                        </c:if>
                                        <c:if test="${cliente.clinome != null}">
                                            <a  class=" btn badge badge-success" style="margin-right: 2%" href="${pageContext.request.contextPath}/exibe-usuario">Bem vindo!, ${cliente.clinome}</a>
                                            <a  class=" btn btn-secondary" style="margin-right: 2%" href="${pageContext.request.contextPath}/">Logout</a>
                                        </c:if>

                                        <a class="btn btn-sm btn-info" href="${pageContext.request.contextPath}/carrinho" >
                                            <img src="<c:url value='/resources/img/cart.png'></c:url>" style="max-width: 60%"/><span id="qtde" class="badge badge-light"></span>
                                        </a>
                                        </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

        <!--CORPO -->
        <div class="container">
            <div class="row">
                <div class="col-md-12"></div>
                <div class="col-md-12">
                    <div class="jumbotron">
                      <h1 class="display-4">Oh não, você está de saída</h1>
                      <p class="lead">Agradecemos sua visita na NERDEX!</p>
                      <hr class="my-4">Aproveite para voltar sempre que achar necessário</p>
                      <p class="lead">
                        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/" role="button">Página inicial</a>
                      </p>
                    </div>
                </div>
                <div class="col-md-12"></div>
             </div>
        </div>

        <!-- Aqui vão configuração de js e css -->
        <script src="<c:url value="/resources/js/jquery-3.3.1.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/resources/js/funcoes_logout.js"/>"></script>
        </body>
</html>
