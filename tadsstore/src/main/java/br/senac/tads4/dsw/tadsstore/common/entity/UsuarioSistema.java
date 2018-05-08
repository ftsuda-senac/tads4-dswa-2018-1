/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.common.entity;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author fernando.tsuda
 */
public class UsuarioSistema implements UserDetails {

  private String username;

  private String nomeCompleto;

  private String hashSenha;

  private List<PapelSistema> papeis;

  public UsuarioSistema() {
  }

  public UsuarioSistema(String username, String nomeCompleto, String hashSenha, List<PapelSistema> papeis) {
    this.username = username;
    this.nomeCompleto = nomeCompleto;
    this.hashSenha = hashSenha;
    this.papeis = papeis;
  }

  @Override
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getHashSenha() {
    return hashSenha;
  }

  public void setHashSenha(String hashSenha) {
    this.hashSenha = hashSenha;
  }

  public String getNomeCompleto() {
    return nomeCompleto;
  }

  public void setNomeCompleto(String nomeCompleto) {
    this.nomeCompleto = nomeCompleto;
  }

  public List<PapelSistema> getPapeis() {
    return papeis;
  }

  public void setPapeis(List<PapelSistema> papeis) {
    this.papeis = papeis;
  }

  @Override
  //public Collection<? extends GrantedAuthority> getAuthorities() {
  public List<PapelSistema> getAuthorities() {
    return papeis;
  }
  
  public boolean hasRole(String role) {
    for (PapelSistema papel : papeis) {
      if (papel.getAuthority().equals(role)) {
	return true;
      }
    }
    return false;
  }

  @Override
  public String getPassword() {
    return hashSenha;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
