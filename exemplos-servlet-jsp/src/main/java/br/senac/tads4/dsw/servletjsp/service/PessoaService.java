/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.servletjsp.service;

import br.senac.tads4.dsw.servletjsp.modelo.Pessoa;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Fernando
 */
public class PessoaService {

  private static final Map<Long, Pessoa> MOCK_DATA = new ConcurrentHashMap<Long, Pessoa>();

  private static long proximoId = 13L;

  static {
    MOCK_DATA.put(1L, new Pessoa(1L, "Fulano da Silva", 25, 1));
    MOCK_DATA.put(2L, new Pessoa(2L, "Ciclano de Souza", 28, 1));
    MOCK_DATA.put(3L, new Pessoa(3L, "Beltrana dos Santos", 23, 0));
    MOCK_DATA.put(4L, new Pessoa(4L, "Jose Lucca da Costa", 30, 1));
    MOCK_DATA.put(5L, new Pessoa(5L, "Alice Oliveira Dias", 21, 0));
    MOCK_DATA.put(6L, new Pessoa(6L, "Miguel Pereira Lima", 24, 1));
    MOCK_DATA.put(7L, new Pessoa(7L, "Laura Almeida Freitas", 21, 0));
    MOCK_DATA.put(8L, new Pessoa(8L, "Roberto Nascimento", 31, 1));
    MOCK_DATA.put(9L, new Pessoa(9L, "Helena Fernandes Castro", 35, 0));
    MOCK_DATA.put(10L, new Pessoa(10L, "Pedro Carvalho Barbosa", 19, 1));
    MOCK_DATA.put(11L, new Pessoa(11L, "Luiza Rocha Ribeiro", 21, 0));
    MOCK_DATA.put(12L, new Pessoa(12L, "Joaquim Mendes Barros", 39, 1));
  }

  public List<Pessoa> listar() {
    return new ArrayList<Pessoa>(MOCK_DATA.values());
  }

  public Pessoa obter(long id) {
    if (MOCK_DATA.containsKey(id)) {
      return (Pessoa) MOCK_DATA.get(id);
    }
    return null;
  }

  public synchronized void salvar(Pessoa pessoa) {
    if (pessoa.getId() == null) {
      pessoa.setId(proximoId);
      proximoId++;
      MOCK_DATA.put(pessoa.getId(), pessoa);
    } else {
      if (MOCK_DATA.containsKey(pessoa.getId())) {
	MOCK_DATA.put(pessoa.getId(), pessoa);
      }
    }
  }
}
