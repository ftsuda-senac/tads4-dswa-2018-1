/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.common.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author fernando.tsuda
 */
public class PapelSistema implements GrantedAuthority {
  
  private String nome;

  public PapelSistema() {
  }

  public PapelSistema(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  @Override
  public String getAuthority() {
    return nome;
  }
  
}
