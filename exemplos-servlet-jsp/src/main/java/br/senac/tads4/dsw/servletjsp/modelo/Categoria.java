/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.servletjsp.modelo;

import java.io.Serializable;

/**
 *
 * @author fernando.tsuda
 */
public class Categoria implements Serializable {

  private int id = 0;
  private String nome;

  public Categoria() {

  }

  public Categoria(String nome) {
    this.nome = nome;
  }

  public Categoria(int id, String nome) {
    this(nome);
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

}
