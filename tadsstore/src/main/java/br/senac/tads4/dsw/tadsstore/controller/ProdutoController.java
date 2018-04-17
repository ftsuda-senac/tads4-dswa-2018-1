/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.controller;

import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
import br.senac.tads4.dsw.tadsstore.common.service.ProdutoService;
import br.senac.tads4.dsw.tadsstore.common.service.fakeimpl.ProdutoServiceFakeImpl;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class ProdutoController {

  private ProdutoService service = new ProdutoServiceFakeImpl();

  @GetMapping
  public ModelAndView listar() {
    List<Produto> lista = service.listar(0, 100);
    return new ModelAndView("lista-bs4").addObject("resultado", lista);
  }

  @GetMapping("/{id}")
  public ModelAndView mostrarDetalhe(@PathVariable("id") Long id) {
    Produto p = service.obter(id);
    return new ModelAndView("detalhe-bs4").addObject("prod", p);
  }
 
  @GetMapping("/form")
  public ModelAndView mostrarForm() {
    Produto p = new Produto();
    return new ModelAndView("formulario").addObject("prod", p);
  }
  
  @PostMapping("/salvar")
  public ModelAndView salvar(@ModelAttribute("prod") @Valid Produto p, 
	  BindingResult bindingResult,
	  RedirectAttributes redirectAttributes) {
    
    if (bindingResult.hasErrors()) {
      return new ModelAndView("formulario");
    }
    
    // Sucesso
    redirectAttributes.addFlashAttribute("msg", "Produto " + p.getNome() + " cadastrado com sucesso");
    return new ModelAndView("redirect:/form");
  }

}
