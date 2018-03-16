/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.exemplos;

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

import org.json.JSONObject;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "AjaxServlet", urlPatterns = {"/ajax-servlet"})
public class AjaxServlet extends HttpServlet {

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    Categoria c1 = new Categoria(1, "Bolo");
    Categoria c2 = new Categoria(2, "Chocolate");
    List<Categoria> categorias1 = Arrays.asList(c1, c2);

    Produto p1 = new Produto(1L, "Bolo de chocolate", "O melhor bolo do mundo", 
	    new BigDecimal("50.0"));
    p1.setCategorias(categorias1);

//    Categoria c3 = new Categoria(3, "Torta");
//    Categoria c4 = new Categoria(3, "Torta");
//    List<Categoria> categorias2 = Arrays.asList(c3, c4);
//    Produto p2 = new Produto(2L, "Torta de limão", "Torta boa para saborear após um jantar especial", new BigDecimal("30.5"));
//    p2.setCategorias(categorias2);
//
//    List<Produto> produtos = Arrays.asList(p1, p2);
    JSONObject json = new JSONObject(p1);
    response.setContentType("application/json;charset=UTF-8");
    //response.addHeader("Access-Control-Allow-Origin", "*");
    try (PrintWriter out = response.getWriter()) {
      out.print(json.toString());
    }
  }

}
