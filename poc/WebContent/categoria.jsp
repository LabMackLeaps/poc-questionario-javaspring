<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<title>Categoria</title>
</head>
<body>
    <form action="ControllerCategoria.do" method="post">
        <fieldset>
            <div>
                <label for="idCategoria">Categoria ID</label> <input type="text"
                    name="idCategoria" value="<c:out value="${categoria.idCategoria}" />"
                    readonly="readonly" placeholder="Categoria ID" />
            </div>
            <div>
                <label for="tituloCategoria">T�tulo</label> <input type="text"
                    name="tituloCategoria" value="<c:out value="${categoria.tituloCategoria}" />"
                    placeholder="T�tulo" />
            </div>
            <div>
                <label for="descricaoCategoria">Descri��o</label> <input type="text"
                    name="descricaoCategoria" value="<c:out value="${categoria.descricaoCategoria}" />"
                    placeholder="Descri��o" />
            </div>             
            <div>
                <label for="idQuestionario">Questionario ID</label> <input type="text"
                    name="idQuestionario" value="<c:out value="${categoria.idQuestionario}" />"
                    placeholder="Questionario ID" />
            </div>
            <div>
                <input type="submit" value="Submit" />
            </div>
        </fieldset>
    </form>
</body>
</html>