/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.servletjsp.servlet;

import br.senac.tads4.dsw.servletjsp.modelo.Pessoa;
import br.senac.tads4.dsw.servletjsp.service.PessoaService;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fernando
 */
@WebServlet(name = "CadastrarPessoaServlet", urlPatterns = {"/cadastrar-pessoa"})
public class CadastrarPessoaServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    PessoaService service = new PessoaService();

    String idStr = request.getParameter("id");
    if (idStr != null && idStr.trim().length() > 0) {
      // Recupera uma pessoa
      Pessoa pessoa = service.obter(Long.parseLong(idStr));
      request.setAttribute("pessoaAtrib", pessoa);
    }
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/formulario.jsp");
    dispatcher.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    Pessoa pessoa = new Pessoa();

    String idStr = request.getParameter("id");
    if (idStr != null) {
      long id = Long.parseLong(idStr);
      pessoa.setId(id);
    }
    String nome = request.getParameter("nome");
    pessoa.setNome(nome);

    String idadeStr = request.getParameter("idade");
    int idade = Integer.parseInt(idadeStr);
    pessoa.setIdade(idade);

    if (pessoa.isValido()) {
      PessoaService service = new PessoaService();
      service.salvar(pessoa);
    } else {
      // ERRO

    }
    // POST-REDIRECT-GET
    request.setAttribute("flash.mensagem-sucesso", "Usuario adicionado com sucesso");
    response.sendRedirect(request.getContextPath() + "/lista-pessoas");

  }

}
