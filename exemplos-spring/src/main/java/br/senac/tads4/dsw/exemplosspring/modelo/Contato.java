/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.exemplosspring.modelo;

/**
 *
 * @author fernando.tsuda
 */
public class Contato {

  private long id;
  
  private String nome;

  private String email;
  
  private int idade;
  
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
