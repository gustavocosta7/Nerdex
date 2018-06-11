<%-- 
    Document   : trabalhe_conosco
    Created on : 10/06/2018, 15:14:49
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
        <title>Trabalhe Conosco - NERDEX</title>
    </head>
    <body>  
   
    <!-- NAVBAR -->
    <!-- NAVBAR -->
      <div class="container">
        <div class="row">

          <div class="col-md-12">
            <div class="container">
              <div class="row">
                <div class="col-md-12">
                  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                    <a class="navbar-brand" href="#">NERDEX</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                      <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                      <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                          <a class="nav-link" href="${pageContext.request.contextPath}/">Home <span class="sr-only">(current)</span></a>
                        </li>
                        
                        <li class="nav-item dropdown">
                          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Categorias
                          </a>
                          <div id="categorias" class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <c:forEach items="${listaCategorias}" var="categoria">
                              <a class="dropdown-item" href="href="mostrarCategoria?id=${categoria.catid}"">${categoria.catdes}</a>
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
                          <input class="form-control mr-sm-2" type="search" placeholder="Digite seu produto..." aria-label="Search">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><img src="<c:url value='/resources/img/magnifier.png'></c:url>"/></button>
                          </form>
                        </ul>



                        <c:if test="${clienteNome == null}">
                          <a  class=" btn btn-primary" style="margin-right: 2%" href="${pageContext.request.contextPath}/login">Login</a>
                      </c:if>
                      <c:if test="${clienteNome != null}">
                        <a  class=" btn badge badge-success" style="margin-right: 2%" href="${pageContext.request.contextPath}/exibe-usuario">Ola, ${clienteNome}</a>
                      </c:if>

                      <button type="button" class="btn btn-sm btn-info">
                        <img src="<c:url value='/resources/img/cart.png'></c:url>" style="max-width: 60%"/><span id="" class="badge badge-light">0</span>
                      </button>
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
                <div class="col-sm-12">
                    <h2  class="text-center">Trabalhe Conosco</h2>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4 ">
                    <form action="<c:url value='/adicionaCurriculo'/>" enctype="multipart/form-data" method="post">
                                                
                        
                        <div class="form-group">
                            <label class="form-control">Identifique-se</label>
                        </div>                        
                        <div class="form-group">
                            <label>Nome</label>
                            <input class="form-control" type="text" name="tfNome" required>
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input class="form-control" type="email" name="tfEmail" required>
                        </div>
                        <div class="form-group">
                            <label>Seu currículo</label>
                            <input class="form-control" type="file" name="tfCur" required>
                        </div>
                        
                        <input type="submit" class=" btn  btn-outline-primary" name="btnEnviar" value="Enviar">
                    </form> 
                   
                </div>
                <div class="col-md-4"></div>
            </div>
        </div>



        <!-- Modal -->
        <div class="modal fade" id="modaluser" tabindex="-1" role="dialog" aria-labelledby="modal-user" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">

                <form method="post" action="${pageContext.request.contextPath}/valida-login">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">Login</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <div class="modal-body">
                        <div class="form-group">
                            <label >E-mail</label>
                            <input type="email" class="form-control" name="tfEmail" required/>
                        </div>
                        <div class="form-group">
                            <label>Senha</label>
                            <input type="password" class="form-control" name="tfSenha" required>
                        </div>
                        <div class="form-check">
                            <input type="checkbox" class="form-check-input">
                            <label class="form-check-label">
                                Lembre-me
                            </label>
                        </div>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item"  href="${pageContext.request.contextPath}/cadastro-usuario">Novo por aqui? Registre-se</a>
                        <a class="dropdown-item" href="#">Esqueceu a senha?</a>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Sair</button>
                        <input type="submit" class="btn btn-primary" value="Logar">
                    </div>
            </form>
        </div>

    </div>
</div>   
                        <!-- Aqui vão configuração de js e css -->
<script src="<c:url value="/resources/js/jquery-3.3.1.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>


</html>