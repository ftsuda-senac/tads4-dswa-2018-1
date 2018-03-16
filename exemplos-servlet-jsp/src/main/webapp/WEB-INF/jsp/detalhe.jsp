<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>JSP Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css" />
    <script src="${pageContext.request.contextPath}/resources/js/funcoes.js"></script>
  </head>
  <body>
    <div class="conteudo">
      <h1>Detalhe</h1>
      <div>
	<h2>Nome: <c:out value="${pessoaAtrib.nome}" /></h2>
	<h3>Bio: <c:out value="${pessoaAtrib.bio}" /></h3>
	<p>Data nascimento: <fmt:formatDate value="${pessoaAtrib.dtNascimento}" pattern="dd/MM/yyyy" /></p>
	<c:choose>
	  <c:when test="${pessoaAtrib.sexo == 1}">
	    <c:set var="sexoTexto" value="Masculino" />
	  </c:when>
	  <c:otherwise>
	    <c:set var="sexoTexto" value="Feminino" />
	  </c:otherwise>
	</c:choose>
	<p>Sexo: <c:out value="${sexoTexto}" /></p>
	<p>Interesses:</p>
	<ul>
	  <li>Interesse 1</li>
	  <li>Interesse 2</li>
	</ul>
      </div>
    </div>
  </body>
</html>
