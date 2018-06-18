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
                                            <a  class=" btn btn-secondary" style="margin-right: 2%" href="${pageContext.request.contextPath}/logout">Logout</a>
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
            <!-- CORPO -->
            <div class="container">
                <div class="row">
                    <div class="col-sm-12"><br></div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                <c:forEach items="${produtos}" var="produto" end="3">
                    <div class="col-md-3">
                        <div class="card text-center " style="width: 18rem;">
                            <a href="#">
                                <img class="img-responsive" src="data:image/png;base64,${produto.procam}" style="width: 100px; width: 100px" alt="${produto.pronome}">
                            </a>
                            <div class="card-body">
                                <h5 class="card-title">${produto.pronome}</h5>
                                <h6 class="card-subtitle mb-2 text-muted">${produto.procatdescricao}</h6>
                                <h6 class="card-subtitle mb-2 text-muted badge" style="color: green">R$ ${produto.propreco}</h6>
                                <p class="card-text">${produto.prodes}</p>
                                <c:if test="${cliente.clinome != null}">
                                <a href="#" onclick="adicionaCarrinho(${produto.proid},'${produto.pronome}',${produto.propreco});" class="btn btn-primary btn-block">Adicionar Carrinho</a>
                                </c:if>
                                <c:if test="${cliente.clinome == null}">
                                  <button type="button" class="btn btn-primary btn-block" data-toggle="modal"
                                        data-target="#modalLogin">Adicionar Carrinho</button>    
                                </c:if>
                                <a href="#" class="btn btn-outline-success  btn-block">Detalhes</a>
                            
                            </div>
                        </div>

                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <c:forEach items="${produtos}" var="produto" begin="4" end="7">
                    <div class="col-md-3">
                        <div class="card text-center " style="width: 18rem;">
                            <a href="#">
                                <img class="img-responsive" src="data:image/png;base64,${produto.procam}" style="width: 100px; width: 100px" alt="${produto.pronome}">
                            </a>
                            <div class="card-body">
                                <form method="POST" action="<c:url value="/carrinho"/>">
                                    <h5 class="card-title">${produto.pronome}</h5>
                                    <h6 class="card-subtitle mb-2 text-muted">${produto.procatdescricao}</h6>
                                    <h6 class="card-subtitle mb-2 text-muted badge" style="color: green">R$ ${produto.propreco}</h6>
                                    <p class="card-text">${produto.prodes}</p>
                                    <input type="hidden" name="tfId" value="${produto.proid}">
                                <c:if test="${cliente.clinome != null}">
                                    <a href="#" onclick="adicionaCarrinho(${produto.proid},${produto.pronome});" class="btn btn-primary btn-block">Adicionar Carrinho</a>
                                </c:if>
                                <c:if test="${cliente.clinome == null}">
                                  <button type="button" class="btn btn-primary btn-block" data-toggle="modal"
                                        data-target="#modalLogin">Adicionar Carrinho</button>    
                                </c:if>
                                    <a href="#" class="btn btn-outline-success  btn-block">Detalhes</a>
                                </form>

                            </div>
                        </div>

                    </div>
                </c:forEach>

            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="modalLogin" tabindex="-1" role="dialog" aria-labelledby="modalLogin" aria-hidden="true">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title">Entrar no NERDEX</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-body">
                Faça login no NERDEX para continuar suas compras
              </div>
              <div class="modal-footer">
                <a  class="btn btn-danger" href="#" data-dismiss="modal">Fechar</a>
                <a  class="btn btn-primary" href="${pageContext.request.contextPath}/login">Entrar</a>
                <a  class="btn btn-outline-primary" href="${pageContext.request.contextPath}/cadastro-usuario">Cadastrar</a>
              </div>
            </div>
          </div>
        </div>
        <!-- Aqui vão configuração de js e css -->
        <script src="<c:url value="/resources/js/jquery-3.3.1.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/resources/js/log_funcoes.js"/>"></script>
        </body>
</html>
