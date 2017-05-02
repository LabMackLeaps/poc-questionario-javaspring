<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<title>Questão</title>
</head>
<body>
    <form action="ControllerQuestao.do" method="post">
        <fieldset>
            <div>
                <label for="idQuestao">Questão ID</label> <input type="text"
                    name="idQuestao" value="<c:out value="${questao.idQuestao}" />"
                    readonly="readonly" placeholder="Questão ID" />
            </div>
            <div>
                <label for="pergunta">Título</label> <input type="text"
                    name="pergunta" value="<c:out value="${questao.pergunta}" />"
                    placeholder="Pergunta" />
            </div>
            <div>
                <label for="idCategoria">Categoria ID</label> <input type="text"
                    name="idCategoria" value="<c:out value="${questao.idCategoria}" />"
                    placeholder="Categoria ID" />
            </div>
            <div>
                <input type="submit" value="Submit" />
            </div> 
        </fieldset>
    </form>

</body>
</html>