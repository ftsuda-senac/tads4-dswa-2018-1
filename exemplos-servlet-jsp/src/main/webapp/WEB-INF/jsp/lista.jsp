<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <c:if test="${not empty mensagemSucesso}">
      <div>
	<p class="text-success"><c:out value="${mensagemSucesso}" /></p>
      </div>
    </c:if>
    <h1>Lista</h1>
    <div>
      <ul>
	<c:forEach items="${listaAtrib}" var="p">
	  <li>
	    <div data-id="${p.id}">
	      <h2><c:out value="${p.nome}" /></h2>
	      <p><a href="${pageContext.request.contextPath}/detalhe-pessoa?id=${p.id}">Ver mais</a></p>
	    </div>
	  </li>
	</c:forEach>
      </ul>
      <%--
      <ul>
	<li>
	  <div data-id="1">
	    <h2>XXXX</h2>
	    <p>Data de nascimento: 99/99/9999</p>
	    <p><a href="#">Ver mais</a></p>
	  </div>
	</li>
	<li>
	  <div data-id="2">
	    <h2>YYYY</h2>
	    <p>Data de nascimento: 99/99/9999</p>
	    <p><a href="#">Ver mais</a></p>
	  </div>
	</li>
	<li>
	  <div data-id="3">
	    <h2>ZZZZ</h2>
	    <p>Data de nascimento: 99/99/9999</p>
	    <p><a href="#">Ver mais</a></p>
	  </div>
	</li>
      </ul>
      --%>
    </div>
  </body>
</html>
