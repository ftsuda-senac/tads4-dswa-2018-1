/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.controller;

import br.senac.tads4.dsw.tadsstore.common.entity.Categoria;
import br.senac.tads4.dsw.tadsstore.common.entity.ImagemProduto;
import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
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

  @GetMapping
  public ModelAndView listar() {
    List<Produto> lista = service.listar(0, 100);
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

    p.setDtCadastro(new Date());

    Set<Produto> listaProdutos = new LinkedHashSet<>();
    listaProdutos.add(p);

    Categoria c1 = new Categoria("chocolate");
    c1.setProdutos(listaProdutos);
    Categoria c2 = new Categoria("light");
    c2.setProdutos(listaProdutos);
    Categoria c3 = new Categoria("crocante");
    c3.setProdutos(listaProdutos);
    Set<Categoria> listaCategorias = new LinkedHashSet<Categoria>();
    listaCategorias.add(c1);
    listaCategorias.add(c2);
    listaCategorias.add(c3);
    p.setCategorias(listaCategorias);

    ImagemProduto img1 = new ImagemProduto("bolo01.jpg", "imagem do bolo 1");
    img1.setProduto(p);
    ImagemProduto img2 = new ImagemProduto("bolo02.jpg", "imagem do bolo 2");
    img2.setProduto(p);
    Set<ImagemProduto> listaImagens = new LinkedHashSet<ImagemProduto>();
    listaImagens.add(img1);
    listaImagens.add(img2);
    p.setImagens(listaImagens);

    service.incluir(p);
    // Sucesso
    redirectAttributes.addFlashAttribute("msg", "Produto " + p.getNome() + " cadastrado com sucesso");
    return new ModelAndView("redirect:/form");
  }

}
