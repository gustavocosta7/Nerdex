<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <head>
        <meta charset="utf-8"/>
        <script type="text/javascript" src="resources/js/jquery.js"></script>
        <script type="text/javascript" src="resources/js/default.js"></script>
        <link rel="stylesheet" href="<c:url value='/resources/css/default.css'/>" 
    </head>
    <body>
        <table>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Preco</th>
                <th>Descricao</th>
                <th>Categoria</th>
                <th>Acao</th>
            </tr>
            <c:forEach items="${listaProd}" var="produto">
            <tr>
                <td>${produto.proid}</td>               
                <td>${produto.pronome}</td>
                <td>${produto.propreco}</td>
                <td>${produto.prodes}</td>
                <td>
                    <c:forEach items="${listaCat}" var="cat">
                        <c:if test="${produto.procatid == cat.catid}" > ${cat.catdes} </c:if>
                    </c:forEach>
                </td>               
                
                <td>
                    <a href="removeProduto?id=${produto.proid}"
                       onclick="confirm('Deseja excluir categoria?')">Remover</a>
                    <a href="exibeProduto?id=${produto.proid}"
                       onclick="confirm('Deseja alterar categoria?')">Alterar</a>
                </td>
            </tr>
            </c:forEach>
        </table>
        <br>
        <a href="<c:url value='/produtoPrincipal'/>">Voltar</a>
    </body>
</html>