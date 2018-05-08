/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.common.service;

import br.senac.tads4.dsw.tadsstore.common.entity.PapelSistema;
import br.senac.tads4.dsw.tadsstore.common.entity.UsuarioSistema;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author fernando.tsuda
 */
@Service
public class UsuarioService implements UserDetailsService {

  private static final Map<String, UsuarioSistema> USUARIOS = new LinkedHashMap<>();

  static {
    USUARIOS.put("fulano", new UsuarioSistema("fulano",
	    "Fulano da Silva", "abcd1234",
	    Arrays.asList(new PapelSistema("ROLE_NORMAL"))));
    USUARIOS.put("ciclano", new UsuarioSistema("ciclano", 
	    "Ciclano de Souza", "abcd1234", 
	    Arrays.asList(new PapelSistema("ROLE_ADMIN"))));
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return USUARIOS.get(username);
  }

}
