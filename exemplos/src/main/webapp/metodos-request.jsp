<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <style>
      .scheme { color: #2980b9 }
      .server-name { color: #16a085 }
      .server-port { color: #f39c12 }
      .context-path { color: #c0392b}
      .servlet-path { color: #8e44ad }
      .query-string { color: #95a5a6 }
    </style>
  </head>
  <body>
    <h1>Métodos/Expressões HttpServletRequest</h1>

    <%--
    <h2>URL chamada: <code>${pageContext.request.requestURL}<c:if 
	  test="${not empty pageContext.request.parameterMap}">?${pageContext.request.queryString}</c:if>
	</code></h2>
    --%>
    <h3>URL chamada:<br/><code><span class="scheme">${pageContext.request.scheme}</span>://<span class="server-name">${pageContext.request.serverName}</span>:<span class="server-port">${pageContext.request.serverPort}</span><span class="context-path">${pageContext.request.contextPath}</span><span class="servlet-path">${pageContext.request.servletPath}</span><c:if test="${not empty pageContext.request.queryString}">?<span class="query-string">${pageContext.request.queryString}</span></c:if></h3>
      <table class="table">
	<thead>
	  <tr>
	    <th>&nbsp;</th>
	    <th>Método Servlet</th>
	    <th>EL</th>
	    <th>Valor</th>
	  </tr>
	</thead>
	<tbody>
	  <tr>
	    <th>method</th>
	    <td><code>request.getMethod()</code></td>
	    <td><code>${'${pageContext.request.method}'}</code></td>
	  <td>${pageContext.request.method}</td>
	</tr>
	<tr>
	  <th>protocol</th>
	  <td><code>request.getProtocol()</code></td>
	  <td><code>${'${pageContext.request.protocol}'}</code></td>
	  <td>${pageContext.request.protocol}</td>
	</tr>
	<tr>
	  <th>scheme</th>
	  <td><code>request.getScheme()</code></td>
	  <td><code>${'${pageContext.request.scheme}'}</code></td>
	  <td class="scheme">${pageContext.request.scheme}</td>
	</tr>
	<tr>
	  <th>server name</th>
	  <td><code>request.getServerName()</code></td>
	  <td><code>${'${pageContext.request.serverName}'}</code></td>
	  <td class="server-name">${pageContext.request.serverName}</td>
	</tr>
	<tr>
	  <th>server port</th>
	  <td><code>request.getServerPort()</code></td>
	  <td><code>${'${pageContext.request.serverPort}'}</code></td>
	  <td class="server-port">${pageContext.request.serverPort}</td>
	</tr>
	<tr>
	  <th>context path</th>
	  <td><code>request.getContextPath()</code></td>
	  <td><code>${'${pageContext.request.contextPath}'}</code></td>
	  <td class="context-path">${pageContext.request.contextPath}</td>
	</tr>
	<tr>
	  <th>servlet path</th>
	  <td><code>request.getServletPath()</code></td>
	  <td><code>${'${pageContext.request.servletPath}'}</code></td>
	  <td class="servlet-path">${pageContext.request.servletPath}</td>
	</tr>
	<tr>
	  <th>query string</th>
	  <td><code>request.getQueryString()</code></td>
	  <td><code>${'${pageContext.request.queryString}'}</code></td>
	  <td class="query-string">${pageContext.request.queryString}</td>
	</tr>
      </tbody>
    </table>


    <p>Remote addr <code>${pageContext.request.remoteAddr}</code></p>
    <p>Remote host: <code>${pageContext.request.remoteHost}</code></p>
    <p>Remote port: <code>${pageContext.request.remotePort}</code></p>
    <p>Local addr: <code>${pageContext.request.localAddr}</code></p>
    <p>Local name: <code>${pageContext.request.localName}</code></p>
    <p>Local port: <code>${pageContext.request.localPort}</code></p>
    <p>Path info: <code>${pageContext.request.pathInfo}</code></p>
  </body>
</html>
