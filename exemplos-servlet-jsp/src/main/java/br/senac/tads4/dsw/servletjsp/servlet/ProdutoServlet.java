package br.senac.tads4.dsw.servletjsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senac.tads4.dsw.servletjsp.modelo.Produto;


/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/exemplo-servlet"})
public class ProdutoServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    Produto p1 = new Produto(1L, "Bolo de chocolate", 
	    "descrição do bolo de chocolate", 
	    new BigDecimal("30.0"));
    Produto p2 = new Produto(1L, "Bolo de cenoura", 
	    "descrição do bolo de cenoura", new BigDecimal("20.0"));
    List<Produto> lista = Arrays.asList(p1, p2);
    
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    try (PrintWriter out = response.getWriter()) {
      /* TODO output your page here. You may use following sample code. */
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet ProdutoServlet</title>");      
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Cake Web - Servlet</h1>");
      out.println("<ul>");
      for (Produto p : lista) {
	out.println("<li><div>");
	out.println("<h3>" + p.getNome() + "</h3>");
	out.println("<p>" + p.getDescricao()+ "</p>");
	out.println("<p>" + p.getPreco().toString() + "</p>");
	out.println("</div></li>");
      }
      out.println("</ul>");
      out.println("</body>");
      out.println("</html>");
    }
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

  }


}