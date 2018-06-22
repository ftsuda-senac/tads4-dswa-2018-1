/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.exemplosspring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author fernando.tsuda
 */
@Configuration
public class WebMvcConfig 
	extends WebMvcConfigurerAdapter 
	implements WebMvcConfigurer {
  
  /**
   * Define uma URL para acessar um diretório contendo as imagens
   * Criar o diretório configurado no sistema.
   * @param registry 
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/estaticos/**")
	    .addResourceLocations("file:C:/desenv/imagens");
  }
  
}
