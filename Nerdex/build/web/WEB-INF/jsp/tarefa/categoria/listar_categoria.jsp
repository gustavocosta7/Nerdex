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
                <th>Descricao</th>
                <th>Acao</th>
            </tr>
            <c:forEach items="${listaCategoria}" var="categoria">
            <tr>
                <td>${categoria.catid}</td>               
                <td>${categoria.catdes}</td>
                <td>
                    <a href="removerCategoria?id=${categoria.catid}"
                       onclick="confirm('Deseja excluir categoria?')">Remover</a>
                    <a href="exibeCategoria?id=${categoria.catid}"
                       onclick="confirm('Deseja alterar categoria?')">Alterar</a>
                </td>
            </tr>
            </c:forEach>
        </table>
        <br>
        <a href="<c:url value='/categoriaPrincipal'/>">Voltar</a>
    </body>
</html>