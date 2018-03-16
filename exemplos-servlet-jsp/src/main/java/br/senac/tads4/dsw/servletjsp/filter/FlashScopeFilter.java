/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.servletjsp.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author http://smartkey.co.uk/development/implementing-flash-scope-in-java-web-applications/
 */
@WebFilter(filterName = "FlashScopeFilter", urlPatterns = {"/*"})
public class FlashScopeFilter implements Filter {

  private static final String FLASH_SESSION_KEY = "FLASH_SESSION_KEY";

  @Override
  @SuppressWarnings("unchecked")
  public void doFilter(ServletRequest request, ServletResponse response,
	  FilterChain chain) throws IOException, ServletException {

    //reinstate any flash scoped params from the users session 
    //and clear the session
    if (request instanceof HttpServletRequest) {
      HttpServletRequest httpRequest = (HttpServletRequest) request;
      HttpSession session = httpRequest.getSession(false);
      if (session != null) {
	Map<String, Object> flashParams = (Map<String, Object>) session.getAttribute(FLASH_SESSION_KEY);
	if (flashParams != null) {
	  for (Map.Entry<String, Object> flashEntry : flashParams.entrySet()) {
	    request.setAttribute(flashEntry.getKey(), flashEntry.getValue());
	  }
	  session.removeAttribute(FLASH_SESSION_KEY);
	}
      }
    }

    //process the chain
    chain.doFilter(request, response);

    //store any flash scoped params in the user's session for the 
    //next request
    if (request instanceof HttpServletRequest) {
      HttpServletRequest httpRequest = (HttpServletRequest) request;
      Map<String, Object> flashParams = new HashMap();
      Enumeration e = httpRequest.getAttributeNames();
      while (e.hasMoreElements()) {
	String paramName = (String) e.nextElement();
	if (paramName.startsWith("flash.")) {
	  Object value = request.getAttribute(paramName);
	  paramName = paramName.substring(6, paramName.length());
	  flashParams.put(paramName, value);
	}
      }
      if (flashParams.size() > 0) {
	HttpSession session = httpRequest.getSession(false);
	session.setAttribute(FLASH_SESSION_KEY, flashParams);
      }
    }
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    //no-op
  }

  @Override
  public void destroy() {
    //no-op
  }
}
