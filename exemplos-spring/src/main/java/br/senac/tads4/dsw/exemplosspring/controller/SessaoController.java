/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.exemplosspring.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author fernando.tsuda
 */
@Controller
@RequestMapping("/sessao")
@Scope("session")
public class SessaoController implements Serializable {
  
  private List<Integer> numerosDigitados = new ArrayList<>();
  
  private String nomeUsuario = "";
  
  @GetMapping
  public ModelAndView mostrarTela() {
    return new ModelAndView("sessao/entrada");
  }
  
  @PostMapping
  public ModelAndView adicionarNumero(@ModelAttribute("numero") Integer numero, 
	  @ModelAttribute("nome") String nome) {
    this.nomeUsuario = nome;
    numerosDigitados.add(numero);
    return new ModelAndView("sessao/entrada");
  }
  
 

  public List<Integer> getNumerosDigitados() {
    return numerosDigitados;
  }
  
  public String getNomeUsuario() {
    return nomeUsuario;
  }
  
}
