/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.servletjsp.servlet;

import br.senac.tads4.dsw.servletjsp.modelo.Pessoa;
import br.senac.tads4.dsw.servletjsp.service.PessoaService;
import java.io.IOException;
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
@WebServlet(name = "DetalhePessoaServlet", urlPatterns = {"/detalhe-pessoa"})
public class DetalhePessoaServlet extends HttpServlet {
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    PessoaService service = new PessoaService();
    
    String idStr = request.getParameter("id");
    if (idStr != null && idStr.trim().length() > 0) {
      long id = Long.parseLong(idStr);
      Pessoa pessoa = service.obter(id);
      if (pessoa != null) {
	// Preparar resposta
	request.setAttribute("pessoaAtrib", pessoa);
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/detalhe.jsp");
	dispatcher.forward(request, response);
      } else {
	response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      }
    }
    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
  }
}
