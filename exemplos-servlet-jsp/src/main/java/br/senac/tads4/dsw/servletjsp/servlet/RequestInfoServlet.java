/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.servletjsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "RequestInfoServlet", urlPatterns = {"/request-info"})
public class RequestInfoServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    try (PrintWriter out = response.getWriter()) {
      response.setContentType("text/plain");

      Enumeration<String> headerNames = request.getHeaderNames();

      while (headerNames.hasMoreElements()) {

	String headerName = headerNames.nextElement();
	out.write(headerName);
	out.write("\n");

	Enumeration<String> headers = request.getHeaders(headerName);
	while (headers.hasMoreElements()) {
	  String headerValue = headers.nextElement();
	  out.write("\t" + headerValue);
	  out.write("\n");
	}

      }
    }
  }

}
