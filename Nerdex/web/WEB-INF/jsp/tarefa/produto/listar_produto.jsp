<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <head>
        <link rel="stylesheet" href=" <c:url value="/resources/css/bootstrap.min.css" />" />
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NERDEX - Produtos - ADM</title>

    </head>
    <body>
        <!-- CORPO -->
        <div class="container">
          <div class="row">
            <div class="col-md-2"></div>
              <div class="col-md-8">
                <h2>Produtos</h2>
              </div>
              <div class="col-md-2"></div>
          </div>
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nome</th>
                                <th>Categoria</th>
                                <th>Preco</th>
                            </tr>
                        </thead>
<<<<<<< HEAD
                            <c:forEach items="${produtos}" var="produtos">
                                <tr>
                                    <td>${produtos.proid}</td>               
                                    <td>${produtos.pronome}</td>
                                    <td>${produtos.procatdescricao}</td>
                                    <td>${produtos.propreco}</td>
                                    <td>
                                        <a class="btn btn-danger"href="${pageContext.request.contextPath}/removeProduto?id=${produtos.proid}"
                                           onclick="confirm('Confirma exclusão desse produto?')">X</a>
                                        <a class="btn btn-outline-secondary"href="${pageContext.request.contextPath}/exibeProduto?id=${produtos.proid}"
                                          >
                                            <img alt="Alterar" src="<c:url value='/resources/img/lapis.png'></c:url>"/></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                        </div>
                        <div class="col-md-2"></div>

=======
                        <c:forEach items="${produtos}" var="produtos">
                          <tr>
                            <td>${produtos.proid}</td>
                            <td>${produtos.pronome}</td>
                            <td>${produtos.procatdescricao}</td>
                            <td>${produtos.propreco}</td>
                            <td>
                              <a class="btn btn-danger"href="${pageContext.request.contextPath}/removeProduto?id=${produtos.proid}"
                                onclick="confirm('Confirma exclusï¿½o desse produto?')">X</a>
                                <a class="btn btn-outline-secondary"href="${pageContext.request.contextPath}/exibeProduto?id=${produtos.proid}"
                                  >
                                  <img alt="Alterar" src="<c:url value='/resources/img/lapis.png'></c:url>"/></a>
                                </td>
                              </tr>
                        </c:forEach>
                      </table>
                      <div class="row">
                        <a href="${pageContext.request.contextPath}/produtoPrincipal"> <button type="button" class="btn btn-outline-info">Voltar</button></a>
                      </div>
                </div>
                <div class="col-md-2"></div>
>>>>>>> c999e37ea05a8de46cf60ca0217f0bbdac874601
                </div>
            </div>


            <!-- Aqui vï¿½o configuraï¿½ï¿½o de js e css -->
            <script src="<c:url value="/resources/js/jquery-3.3.1.js"/>"></script>
            <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    </body>
</html>
