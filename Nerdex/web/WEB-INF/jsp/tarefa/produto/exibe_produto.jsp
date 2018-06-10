<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
    <body>
        <h3>Alterar produto - ${produto.proid}</h3>
        <form action="<c:url value='/alterarProduto'/>" method="post">
            <input type="hidden" name="proid" value="${produto.proid}" />
            
            <br>Nome<br>
            <input type="text" name="pronome" value="${produto.pronome}"/>
            <br>Preco<br>
            <input type="text" name="propreco" value="${produto.propreco}"/>
            <br>Categoria<br>
            
            <select name="procatid" class="custom-select" id="idCategorias" required>
                <c:forEach items="${listaCategorias}" var="categoria">
                    <c:if test="${categoria.catid == produto.procatid}">
                        <option selected value="${categoria.catid}">
                            ${categoria.catdes}
                        </option>
                    </c:if>
                    <option value="${categoria.catid}">${categoria.catdes}</option>
                </c:forEach> 
            </select>


            <br>Descricao<br>
            <input type="text" name="prodes" value="${produto.prodes}"/>
            <input type="submit" value="Alterar"/>
            <br><br>            
        </form>
        <br>
        <a href="<c:url value='/listarProduto'/>">Voltar</a>
    </body>
</html>