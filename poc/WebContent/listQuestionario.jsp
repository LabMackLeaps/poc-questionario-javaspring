<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Question�rios</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Question�rio ID</th>
                <th>T�tulo</th>
                <th>Descri��o</th>
                <th colspan="2">A��es</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${questionarios}" var="questionario">
                <tr>
                    <td><c:out value="${questionario.idQuestionario}" /></td>
                    <td><c:out value="${questionario.tituloQuestionario}" /></td>
                    <td><c:out value="${questionario.descricaoQuestionario}" /></td>
                    <td><a
                        href="ControllerQuestionario.do?action=edit&idQuestionario=<c:out value="${questionario.idQuestionario }"/>">Update</a></td>
                    <td><a
                        href="ControllerQuestionario.do?action=delete&idQuestionario=<c:out value="${questionario.idQuestionario }"/>">Deletar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p>
        <a href="ControllerQuestionario.do?action=insert">Adicionar Questionario</a>
    </p>
</body>
</html>