<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <link rel="stylesheet" href=" <c:url value="/resources/css/bootstrap.min.css" />" />
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>NERDEX - Categorias - ADM</title>
  </head>
  <body>
    <!-- CORPO -->
    <div class="container">
      <div class="row">
        <div class="col-md-2"></div>
          <div class="col-md-8">
            <h2>Categorias</h2>
          </div>
          <div class="col-md-2"></div>
      </div>
      <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
          <table class="table">
            <tr>
              <th>Id</th>
              <th>Descricao</th>
              <th>Acao</th>
            </tr>
            <c:forEach items="${listaCategoria}" var="categoria">
              <tr>
                <td>${categoria.catid}</td>
                <td>${categoria.catdes}</td>
                <td>
                  <a class="btn btn-outline-danger" href="removerCategoria?id=${categoria.catid}">Remover</a>
                  <a class="btn btn-outline-warning" href="exibeCategoria?id=${categoria.catid}">Alterar</a>
                </td>
              </tr>
            </c:forEach>
          </table>
          <div class="row">
            <a href="${pageContext.request.contextPath}/categoriaPrincipal"> <button type="button" class="btn btn-outline-info">Voltar</button></a>
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
