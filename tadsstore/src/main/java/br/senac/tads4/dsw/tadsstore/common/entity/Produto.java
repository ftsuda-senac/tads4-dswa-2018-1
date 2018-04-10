/*
 * The MIT License
 *
 * Copyright 2016 fernando.tsuda.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.senac.tads4.dsw.tadsstore.common.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import java.util.Objects;

public class Produto implements Serializable {

  private Long id;

  private String nome;

  private String descricao;

  private BigDecimal precoCompra;
  
  private BigDecimal precoVenda;
  
  private int quantidade;

  private Date dtCadastro;

  private Set<Categoria> categorias;

  private Set<ImagemProduto> imagens;

  private Set<Integer> idsCategorias;

  private String observacoes;

  public Produto() {

  }

  public Produto(Long id, String nome, String descricao, BigDecimal precoCompra, BigDecimal precoVenda, int quantidade, Date dtCadastro) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.precoCompra = precoCompra;
    this.precoVenda = precoVenda;
    this.quantidade = quantidade;
    this.dtCadastro = dtCadastro;
  }

  public Produto(Long id, String nome, String descricao, BigDecimal precoCompra, BigDecimal precoVenda, int quantidade, Date dtCadastro, Set<ImagemProduto> imagens, Set<Categoria> categorias) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.precoCompra = precoCompra;
    this.precoVenda = precoVenda;
    this.quantidade = quantidade;
    this.dtCadastro = dtCadastro;
    this.imagens = imagens;
    this.categorias = categorias;
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

  public BigDecimal getPrecoCompra() {
    return precoCompra;
  }

  public void setPrecoCompra(BigDecimal precoCompra) {
    this.precoCompra = precoCompra;
  }

  public BigDecimal getPrecoVenda() {
    return precoVenda;
  }

  public void setPrecoVenda(BigDecimal precoVenda) {
    this.precoVenda = precoVenda;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public Date getDtCadastro() {
    return dtCadastro;
  }

  public void setDtCadastro(Date dtCadastro) {
    this.dtCadastro = dtCadastro;
  }

  public Set<Categoria> getCategorias() {
    return categorias;
  }

  public void setCategorias(Set<Categoria> categorias) {
    this.categorias = categorias;
  }

  public Set<ImagemProduto> getImagens() {
    return imagens;
  }

  public void setImagens(Set<ImagemProduto> imagens) {
    this.imagens = imagens;
  }

  public String getObservacoes() {
    return observacoes;
  }

  public void setObservacoes(String observacoes) {
    this.observacoes = observacoes;
  }

  public Set<Integer> getIdsCategorias() {
    return idsCategorias;
  }

  public void setIdsCategorias(Set<Integer> idsCategorias) {
    this.idsCategorias = idsCategorias;
  }

  @Override
  public String toString() {
    return "Produto{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", precoCompra=" + precoCompra + ", precoVenda=" + precoVenda + ", quantidade=" + quantidade + ", dtCadastro=" + dtCadastro + ", categorias=" + categorias + ", imagens=" + imagens + ", idsCategorias=" + idsCategorias + ", observacoes=" + observacoes + '}';
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.id);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Produto other = (Produto) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }

}
