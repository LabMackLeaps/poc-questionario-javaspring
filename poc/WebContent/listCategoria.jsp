<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Categorias</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Categoria ID</th>
                <th>Título</th>
                <th>Descrição</th>
                <th>Questões</th>
                <th colspan="2">Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${categorias}" var="categoria">
                <tr>
                    <td><c:out value="${categoria.idCategoria}" /></td>
                    <td><c:out value="${categoria.tituloCategoria}" /></td>
                    <td><c:out value="${categoria.descricaoCategoria}" /></td>
                    <td><a href="ControllerCategoria.do?action=listQuestao&idCategoria=<c:out value="${categoria.idCategoria}"/>">Questões</a></td>
                    <td><a href="ControllerCategoria.do?action=edit&idCategoria=<c:out value="${categoria.idCategoria}"/>">Update</a></td>
                    <td><a href="ControllerCategoria.do?action=delete&idCategoria=<c:out value="${categoria.idCategoria}"/>">Deletar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p>
        <a href="ControllerCategoria.do?action=insert">Adicionar Categoria</a>
    </p>
</body>
</html>