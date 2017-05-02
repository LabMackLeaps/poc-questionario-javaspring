<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Quest�es</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Quest�o ID</th>
                <th>Pergunta</th>
                <th colspan="2">A��es</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${questoes}" var="questao">
                <tr>
                    <td><c:out value="${questao.idQuestao}" /></td>
                    <td><c:out value="${questao.pergunta}" /></td>
                    <td><a
                        href="ControllerQuestao.do?action=edit&idQuestao=<c:out value="${questao.idQuestao}"/>">Update</a></td>
                    <td><a
                        href="ControllerQuestao.do?action=delete&idQuestao=<c:out value="${questao.idQuestao}"/>">Deletar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p>
        <a href="ControllerQuestao.do?action=insert">Adicionar Quest�o</a>
    </p>
</body>
</html>