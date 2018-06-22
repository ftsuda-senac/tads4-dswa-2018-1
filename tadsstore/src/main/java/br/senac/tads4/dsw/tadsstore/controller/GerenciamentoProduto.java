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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author fernando.tsuda
 */
@Controller
@RequestMapping("/gerenciamento/produto")
public class GerenciamentoProduto {

  @Autowired
  private ProdutoService service;

  @Autowired
  private CategoriaService categoriaService;

  @GetMapping
  public ModelAndView mostrarForm() {
    Produto p = new Produto();
    List<Categoria> categorias = categoriaService.listar();
    return new ModelAndView("formulario")
	    .addObject("prod", p)
	    .addObject("categorias", categorias);
  }

  @GetMapping("/{id}")
  public ModelAndView mostrarFormAlteracao(@PathVariable("id") Long id) {
    Produto p = service.obter(id);
    Set<Integer> idsCategorias = new LinkedHashSet<>();
    for (Categoria c : p.getCategorias()) {
      idsCategorias.add(c.getId());
    }
    p.setIdsCategorias(idsCategorias);

    List<Categoria> categorias = categoriaService.listar();
    return new ModelAndView("formulario")
	    .addObject("prod", p)
	    .addObject("categorias", categorias);
  }

  @PostMapping("/salvar")
  public ModelAndView salvar(@ModelAttribute("prod") @Valid Produto p,
	  BindingResult bindingResult,
	  RedirectAttributes redirectAttributes) {

    if (bindingResult.hasErrors()) {
      return new ModelAndView("formulario");
    }

    p.setDtCadastro(new Date());

    Set<Produto> listaProdutos = new LinkedHashSet<>();
    listaProdutos.add(p);

    Set<Categoria> listaCategorias = new LinkedHashSet<Categoria>();
    for (Integer idCat : p.getIdsCategorias()) {
      Categoria cat = categoriaService.obter(idCat);
      cat.setProdutos(listaProdutos);
      listaCategorias.add(cat);
    }
    p.setCategorias(listaCategorias);

    ImagemProduto img1 = new ImagemProduto("bolo01.jpg", "imagem do bolo 1");
    img1.setProduto(p);
    ImagemProduto img2 = new ImagemProduto("bolo02.jpg", "imagem do bolo 2");
    img2.setProduto(p);
    Set<ImagemProduto> listaImagens = new LinkedHashSet<ImagemProduto>();
    listaImagens.add(img1);
    listaImagens.add(img2);
    p.setImagens(listaImagens);

    if (p.getId() == null) {
      service.incluir(p);
    } else {
      service.alterar(p);
    }

    // Sucesso
    redirectAttributes.addFlashAttribute("msg", "Produto " + p.getNome() + " cadastrado com sucesso");
    return new ModelAndView("redirect:/form");
  }

  @GetMapping("/apagar/{id}")
  public ModelAndView apagarProduto(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
    service.remover(id);

    // Sucesso
    redirectAttributes.addFlashAttribute("msg", "Produto apagado com sucesso");
    return new ModelAndView("redirect:/form");
  }
}
