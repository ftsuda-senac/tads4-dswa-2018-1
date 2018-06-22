/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.exemplos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MetodosServlet", urlPatterns = {"/metodos-request-servlet"})
public class MetodosRequestServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    request.getRequestDispatcher("/metodos-request.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
     request.getRequestDispatcher("/metodos-request.jsp").forward(request, response);
  }

}
