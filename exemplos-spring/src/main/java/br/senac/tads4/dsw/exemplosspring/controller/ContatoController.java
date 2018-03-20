/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.exemplosspring.controller;

import br.senac.tads4.dsw.exemplosspring.modelo.Contato;
import java.util.ArrayList;
import java.util.List;
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
@RequestMapping("/contato")
public class ContatoController {
  
  @GetMapping
  public ModelAndView listar() {
    List<Contato> lista = new ArrayList<Contato>();
    lista.add(new Contato(1L, "Fulano da Silva", "fulano@zmail.com", 25, 1));
    lista.add(new Contato(2L, "Ciclana de Souza", "ciclana@zmail.com", 18, 0));
    lista.add(new Contato(3L, "Beltrano Cruz", "beltrano@zmail.com", 30, 1));
    lista.add(new Contato(4L, "João Motta", "joao@zmail.com", 16, 1));
    lista.add(new Contato(5L, "Maria de Souza", "maria@zmail.com", 15, 0));
    
    ModelAndView resposta = new ModelAndView("contato/lista");
    resposta.addObject("lista", lista);
    return resposta;
  }
  
  @GetMapping("/entrada")
  public ModelAndView entrada() {
    return new ModelAndView("contato/entrada")
	    .addObject("contato", new Contato());
  }
  
  @PostMapping("/salvar")
  public ModelAndView salvar(
	  @ModelAttribute("contato") Contato contato) {
    return new ModelAndView("contato/resultado")
	    .addObject("contato", contato);
  }
}
