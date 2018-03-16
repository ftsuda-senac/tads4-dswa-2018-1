<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Cake Web MVC</h1>
    <c:if test="${not empty mensagemPost}">
      <p style="background-color: red; color: white"><c:out value="${mensagemPost}" /></p>
    </c:if>

    <p>Acessos: <c:out value="${sessionScope.contador}" /></p>

    <ul>
      <c:forEach items="${listaProd}" var="prod">
        <li>
          <div>
            <h3>${prod.nome}</h3>
            <p>${prod.descricao}</p>
            <p>${prod.preco.toString()}</p>
          </div>
        </li>
      </c:forEach>
    </ul>
  </body>
</html>