<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<title>Questionário</title>
</head>
<body>
    <form action="ControllerQuestionario.do" method="post">
        <fieldset>
            <div>
                <label for="idQuestionario">Questionário ID</label> <input type="text"
                    name="idQuestionario" value="<c:out value="${questionario.idQuestionario}" />"
                    readonly="readonly" placeholder="Questionario ID" />
            </div>
            <div>
                <label for="tituloQuestionario">Título</label> <input type="text"
                    name="tituloQuestionario" value="<c:out value="${questionario.tituloQuestionario}" />"
                    placeholder="Título" />
            </div>
            <div>
                <label for="descricaoQuestionario">Descrição</label> <input type="text"
                    name="descricaoQuestionario" value="<c:out value="${questionario.descricaoQuestionario}" />"
                    placeholder="Descrição" />
            </div>
            <div>
                <input type="submit" value="Submit" />
            </div> 
        </fieldset>
    </form>

</body>
</html>