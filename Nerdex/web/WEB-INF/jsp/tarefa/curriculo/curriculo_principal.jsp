<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <head>
        <link rel="stylesheet" href=" <c:url value="/resources/css/bootstrap.min.css" />" />
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NERDEX - Curriculos - ADM</title>

    </head>
    <body>
        <!-- CORPO -->
        <div class="container">
          <div class="row">
            <div class="col-md-2"></div>
              <div class="col-md-8">
                <h2>Curriculos</h2>
              </div>
              <div class="col-md-2"></div>
          </div>
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <table class="table">
                        <thead>
                            <tr>
                              <th>Id</th>
                              <th>Nome</th>
                              <th>Email</th>
                              <th>Acao</th>
                            </tr>
                        </thead>
                            <c:forEach items="${listaCurriculo}" var="curriculo">
                                <tr>
                                    <td>${curriculo.curid}</td>
                                    <td>${curriculo.curnome}</td>
                                    <td>${curriculo.curemail}</td>
                                    <td>
                                      <a class="btn btn-outline-info" href="visualizarCurriculo?id=${curriculo.curid}"> Visualizar</a>
                                      <a class="btn btn-outline-danger" href="excluirCurriculo?id=${curriculo.curid}">Excluir</a>
                                    </td>
                                </tr>
                            </c:forEach>
                    </table>
                  <div class="row">
                      <div class="col-md-12"><a class="btn btn-outline-info" href="<c:url value='/admin-principal'/>">Voltar</a></div>
                  </div>
                </div>
                <div class="col-md-2"></div>
              </div>
            </div>
            <!-- Aqui v�o configura��o de js e css -->
            <script src="<c:url value="/resources/js/jquery-3.3.1.js"/>"></script>
            <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    </body>
</html>
