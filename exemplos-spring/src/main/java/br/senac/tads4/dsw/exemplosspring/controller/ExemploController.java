/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.exemplosspring.controller;

import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author fernando.tsuda
 */
@Controller
@RequestMapping("/xpto")
public class ExemploController {

  @GetMapping("/ex1")
  public String exemplo1() {
    return "view-exemplo1";
  }

  @GetMapping("/ex2a")
  public String exemplo2a(Model modelo) {
    modelo.addAttribute("texto", "Texto gerado no Controller");
    modelo.addAttribute("dataHora", LocalDateTime.now());
    return "view-exemplo2";
  }

  @GetMapping("/ex2b")
  public ModelAndView exemplo2b() {
    ModelAndView resposta = new ModelAndView("view-exemplo2");
    resposta.addObject("texto", "Texto gerado no Controller v2");
    resposta.addObject("dataHora", LocalDateTime.now());
    return resposta;
  }

  @GetMapping("/ex3")
  public ModelAndView exemplo3(
	  @RequestParam(value = "nome", required = false) String nome,
	  @RequestParam(value = "idade", defaultValue = "99") int idade) {
    ModelAndView resposta = new ModelAndView("exemplo3");
    if (nome == null || nome.trim().length() == 0) {
      nome = "Desconhecido";
    }
    resposta.addObject("nome", nome);
    resposta.addObject("idade", idade);
    return resposta;
  }

  @GetMapping("/ex4/{nomeParam}")
  public ModelAndView exemplo4(@PathVariable("nomeParam") String nome) {
    ModelAndView resposta = new ModelAndView("exemplo4");
    resposta.addObject("nome", nome);
    return resposta;
  }

}
