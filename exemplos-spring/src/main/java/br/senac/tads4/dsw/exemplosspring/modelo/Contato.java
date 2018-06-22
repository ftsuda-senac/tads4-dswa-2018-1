/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.exemplosspring.modelo;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author fernando.tsuda
 */
public class Contato {

  private long id;
  
  @NotNull
  @Size(min = 2, max = 50)
  private String nome;

  @NotNull(message = "E-mail não pode ser nulo")
  @Email(message = "E-mail com formato inválido")
  private String email;
  
  @Max(value = 130, message = "Idade máxima são 130 anos")
  private int idade;
  
  //@Pattern(regexp = "[0|1]", message = "Valor inválido")
  private int sexo; // 0-feminino, 1-masculino
  

  public Contato() {

  }

  public Contato(long id, String nome, String email, int idade, int sexo) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.idade = idade;
    this.sexo = sexo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

}
