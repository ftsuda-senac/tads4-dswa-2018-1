/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.common.service.jpaimpl;

import br.senac.tads4.dsw.tadsstore.common.entity.Categoria;
import br.senac.tads4.dsw.tadsstore.common.entity.ImagemProduto;
import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
import br.senac.tads4.dsw.tadsstore.common.service.ProdutoService;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fernando.tsuda
 */
@Repository
public class ProdutoServiceJpaImpl implements ProdutoService {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<Produto> listar(int offset, int quantidade) {
    Query query = entityManager.createQuery(
	    "SELECT DISTINCT p FROM Produto p "
	    + "LEFT JOIN FETCH p.categorias "
	    + "LEFT JOIN FETCH p.imagens")
	    .setFirstResult(offset)
	    .setMaxResults(quantidade);
    List<Produto> resultados = query.getResultList();
    return resultados;
  }

  @Override
  public List<Produto> listarPorCategoria(Categoria categoria, int offset, int quantidade) {
    Query query = entityManager.createQuery(
	    "SELECT DISTINCT p FROM Produto p "
	    + "LEFT JOIN FETCH p.categorias "
	    + "LEFT JOIN FETCH p.imagens "
	    + "INNER JOIN p.categorias c "
	    + "WHERE c.nome LIKE :nmCat")
	    .setParameter("nmCat", categoria.getNome())
	    .setFirstResult(offset)
	    .setMaxResults(quantidade);
    List<Produto> resultados = query.getResultList();
    return resultados;
  }

  @Override
  public Produto obter(long idProduto) {
    Query query = entityManager.createQuery(
	    "SELECT p FROM Produto p "
	    + "LEFT JOIN FETCH p.categorias "
	    + "LEFT JOIN FETCH p.imagens "
	    + "WHERE p.id = :idProd");
    query.setParameter("idProd", idProduto);
    Produto p = (Produto) query.getSingleResult();
    return p;
  }

  @Override
  @Transactional
  public void incluir(Produto p) {
    for (Categoria c : p.getCategorias()) {
      if (c.getId() == null) {
	entityManager.persist(c);
      } else {
	entityManager.merge(c);
      }
    }
    for (ImagemProduto img : p.getImagens()) {
      if (img.getId() == null) {
	entityManager.persist(img);
      } else {
	entityManager.merge(img);
      }
    }
    entityManager.persist(p);
  }

  @Override
  @Transactional
  public void alterar(Produto p) {
    for (Categoria c : p.getCategorias()) {
      if (c.getId() == null) {
	entityManager.persist(c);
      } else {
	entityManager.merge(c);
      }
    }
    for (ImagemProduto img : p.getImagens()) {
      if (img.getId() == null) {
	entityManager.persist(img);
      } else {
	entityManager.merge(img);
      }
    }
    entityManager.merge(p);
  }

  @Override
  @Transactional
  public void remover(long idProduto) {
    Produto p = entityManager.find(Produto.class, idProduto);
    entityManager.remove(p);
  }

}
