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
                <th>Acao</th>
            </tr>
            <c:forEach items="${listaMensagem}" var="mensagem">
            <tr>
                <td>${mensagem.menid}</td>               
                <td>${mensagem.mennome}</td>
                <td>
                    <a href="exibirMensagem?id=${mensagem.menid}">Exibir</a>
                    <a href="excluirMensagem?id=${mensagem.menid}"
                       onclick="confirm('Deseja alterar categoria?')">Excluir</a>
                </td>
            </tr>
            </c:forEach>
        </table>
        <br>
        <a href="<c:url value='/admin-principal'/>">Voltar</a>
    </body>
</html>