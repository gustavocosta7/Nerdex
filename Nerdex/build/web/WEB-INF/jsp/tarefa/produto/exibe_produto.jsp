<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${produto.pronome} - Nerdex</title>
        
    </head>
    <body>
        <!-- CORPO -->

        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <h2  class="text-center">${produto.pronome}</h2>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4 ">
                    <form action="<c:url value='/alterarProduto'/>" method="post" enctype="multipart/form-data">


                        <div class="form-group">
                            <label>ID</label>
                            <input name="tfId" class="form-control" type="number" value="${produto.proid}" readonly="readonly">
                        </div>                        
                        <div class="form-group">
                            <label>Nome</label>
                            <input class="form-control" type="text" name="tfNome" value="${produto.pronome}">
                        </div>
                        <label>Categoria</label>
                         <select name="tfCategoria" class="custom-select" id="idSelect" required>
                                    <c:forEach items="${listaCategorias}" var="categoria">
                                        <c:if test="${produto.procatid == categoria.catid}">
                                             <option value="${categoria.catid}" selected>${categoria.catdes} </option>
                                        </c:if>
                                        <c:if test="${produto.procatid != categoria.catid}">
                                             <option value="${categoria.catid}">${categoria.catdes}</option>
                                        </c:if>
                                    
                                    </c:forEach> 
                          </select>

                        
                       
                        <div class="form-group">
                            <label>Preço</label>
                            <input class="form-control" type="text" name="tfPreco" value="${produto.propreco}">
                        </div>  <div class="form-group">
                            <span for="idDesc">Descrição</span>
                            <textarea name="tfDesc"  id="idDesc" class="form-control" required>${produto.prodes}</textarea>
                        </div>
                        <div>
                            <img class="photo img-fluid img-responsive" src="data:image/png;base64,${produto.procam}"  />
                            <div class="form-check">
                            <input type="checkbox" name="tfAlteraFoto" class="form-check-input">
                            <label class="form-check-label">Alterar Foto</label>
                            </div>

                            
                            <label>Foto do produto</label>
                            <input name="tfFoto" type="file" class="form-control">    
                        </div>
     
                        <input type="submit" class=" btn  btn-outline-info" name="btnAlterar" value="Alterar">
                        <a href="${pageContext.request.contextPath}/listarProduto" class="btn btn-secondary btn-lg"> Voltar </a>
                    </form> 

                </div>
                <div class="col-md-4"></div>
            </div>
        </div>
    </div>

</div>
</div>        

<!-- Aqui vão configuração de js e css -->
<script src="<c:url value="/resources/js/funcaoAlteraProduto"/>"></script>
<script src="<c:url value="/resources/js/jquery-3.3.1.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>
