package Projeto.LocadoraFilmes.persistencia;

import org.springframework.stereotype.Repository;

import Projeto.LocadoraFilmes.entidade.Filme;

/**
 * Classe que define as operacoes da camada de persistencia de Filme
 * @author Cecília
 *
 */
@Repository
public class FilmeDAOImpl extends GenericoDAOImpl<Filme, Integer> implements
		FilmeDAO {

}
