/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.servletjsp.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author fernando.tsuda
 */
public class Produto implements Serializable {

  private long id = 0;
  private String nome;
  private String descricao;
  private BigDecimal preco;
  private List<Categoria> categorias;

  public Produto() {

  }

  public Produto(String nome, String descricao, BigDecimal preco) {
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
  }

  public Produto(long id, String nome, String descricao, BigDecimal preco) {
    this(nome, descricao, preco);
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public BigDecimal getPreco() {
    return preco;
  }

  public void setPreco(BigDecimal preco) {
    this.preco = preco;
  }

  public List<Categoria> getCategorias() {
    return categorias;
  }

  public void setCategorias(List<Categoria> categorias) {
    this.categorias = categorias;
  }

}
