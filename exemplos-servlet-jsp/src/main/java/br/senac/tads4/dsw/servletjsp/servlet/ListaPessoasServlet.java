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
@WebServlet(name = "ListaPessoasServlet", urlPatterns = {"/lista-pessoas"})
public class ListaPessoasServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    PessoaService service = new PessoaService();

    // Lista todas as pessoas cadastradas
    List<Pessoa> lista = service.listar();
    request.setAttribute("listaAtrib", lista);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/lista.jsp");
    dispatcher.forward(request, response);
  }
}
