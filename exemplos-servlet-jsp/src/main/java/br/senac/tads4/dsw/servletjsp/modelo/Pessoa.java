/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.servletjsp.modelo;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando
 */
public class Pessoa implements Serializable {

  private Long id;

  private String nome;

  private int idade;

  private int sexo; // 1-Feminino 0-Masculino

  public Pessoa() {
  }

  public Pessoa(String nome, int idade, int sexo) {
    this.nome = nome;
    this.idade = idade;
    this.sexo = sexo;
  }

  public Pessoa(Long id, String nome, int idade, int sexo) {
    this.id = id;
    this.nome = nome;
    this.idade = idade;
    this.sexo = sexo;
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

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public int getSexo() {
    return sexo;
  }

  public void setSexo(int sexo) {
    this.sexo = sexo;
  }

  public boolean isValido() {
    boolean nomeValido = nome != null && nome.trim().length() > 0;
    boolean idadeValida = idade > 0;
    return nomeValido && idadeValida;
  }

  // Métodos mocks
  public String getBio() {
    return "Biografia/descrição do perfil de " + nome;
  }

  public Date getDtNascimento() {
    DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    try {
      return dateFormatter.parse("20/03/1999");
    } catch (ParseException ex) {
      return new Date();
    }
  }

}
