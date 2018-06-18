<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <link rel="stylesheet" href=" <c:url value="/resources/css/bootstrap.min.css" />" />
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>NERDEX - Mensagens - ADM</title>
  </head>
  <body>
    <!-- CORPO -->
    <div class="container">
      <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6"> <!-- Corpo da mensagem aqui -->

          <h2>Exibir mensagem - ${mens.menid}</h2>
          <div class="alert alert-success" role="alert">
            <div class="form-group">
              <label for="exampleInputEmail1">Nome</label>
              <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="${mens.mennome}">
            </div>
          </div>
          <div class="alert alert-info" role="alert">
            <label for="exampleFormControlTextarea1">Mensagem</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3">${mens.mendesc}</textarea>
          </div>
          <div class="row">
            <div class="col-md-12"><a class="btn btn-info" href="<c:url value='/crudMensagem'/>">Voltar</a></div>
          </div>

        </div>
        <div class="col-md-3"></div>
      </div>
    </div>
        <!-- Aqui v�o configura��o de js e css -->
    <script src="<c:url value="/resources/js/jquery-3.3.1.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
  </body>
</html>
