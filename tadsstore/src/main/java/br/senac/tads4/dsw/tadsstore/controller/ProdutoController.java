/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.controller;

import br.senac.tads4.dsw.tadsstore.common.entity.Categoria;
import br.senac.tads4.dsw.tadsstore.common.entity.ImagemProduto;
import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
import br.senac.tads4.dsw.tadsstore.common.service.CategoriaService;
import br.senac.tads4.dsw.tadsstore.common.service.ProdutoService;
import br.senac.tads4.dsw.tadsstore.common.service.fakeimpl.ProdutoServiceFakeImpl;
import br.senac.tads4.dsw.tadsstore.common.service.jpaimpl.ProdutoServiceJpaImpl;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class ProdutoController {

  @Autowired
  private ProdutoService service;

  @Autowired
  private CategoriaService categoriaService;

  @GetMapping
  public ModelAndView listar(@RequestParam(value = "pag", defaultValue = "0") int pagina,
	  @RequestParam(value = "qt", defaultValue = "6") int quantidade) {
    List<Produto> lista = service.listar(pagina, quantidade);
    return new ModelAndView("lista-bs4").addObject("resultado", lista);
  }

  @GetMapping("/cat/{categoria}")
  public ModelAndView listarPorCategoria(
	  @PathVariable("categoria") String categoria,
	  @RequestParam(value = "pag", defaultValue = "0") int pagina,
	  @RequestParam(value = "qt", defaultValue = "6") int quantidade) {

    List<Produto> lista
	    = service.listarPorCategoria(new Categoria(categoria), pagina, quantidade);
    return new ModelAndView("lista-bs4").addObject("resultado", lista);
  }

  @GetMapping("/{id}")
  public ModelAndView mostrarDetalhe(@PathVariable("id") Long id) {
    Produto p = service.obter(id);
    return new ModelAndView("detalhe-bs4").addObject("prod", p);
  }



}
