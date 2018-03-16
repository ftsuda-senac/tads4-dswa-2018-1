<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
      <h1>Formulário</h1>
      <div>
	<form action="${pageContext.request.contextPath}/cadastro-pessoa" method="post">
	  <div>
	    <label>Nome</label>
	    <input type="text" name="nome" placeholder="Digite o nome completo" />
	  </div>
	  <div>
	    <label>Descrição</label>
	    <textarea name="descricao" placeholder="Digite uma breve descrição da pessoa"></textarea>
	  </div>
	  <div>
	    <label>Data nascimento</label>
	    <input type="text" name="dtnascimento" placeholder="Digite a data de nascimento no formato dd/MM/yyyy" />
	  </div>
	  <fieldset>
	    <legend>Sexo</legend>
	    <input type="radio" name="sexo" value="0" checked /><label>Feminino</label>
	    <input type="radio" name="sexo" value="1" /><label>Masculino</label>
	  </fieldset>
	  <fieldset>
	    <legend>Interesses</legend>
	    <input type="checkbox" name="categorias" value="tecnologia" /><label>Tecnologia</label>
	    <input type="checkbox" name="categorias" value="carreira" /><label>Carreira</label>
	    <input type="checkbox" name="categorias" value="lazer" /><label>Lazer</label>
	    <input type="checkbox" name="categorias" value="estilo" /><label>Estilo de vida</label>
	  </fieldset>
	  <div>
	    <button type="submit">Salvar</button>
	    <button type="reset">Limpar</button>
	  </div>
	</form>

      </div>
    </div>
  </body>
</html>
