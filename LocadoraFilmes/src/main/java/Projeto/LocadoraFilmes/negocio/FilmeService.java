package Projeto.LocadoraFilmes.negocio;

import java.util.List;

import Projeto.LocadoraFilmes.entidade.Filme;
import Projeto.LocadoraFilmes.util.LocadoraFilmesException;

/**
 * Interface que define as operacoes da camada de negocio de Filme
 * @author Cecília
 *
 */
public interface FilmeService {
	
	/**
	 * Inclui um filme
	 * @param filme
	 * @return
	 * @throws LocadoraFilmesException
	 */
	public Filme incluir(Filme filme) throws LocadoraFilmesException;
	
	/**
	 * Altera um filme
	 * @param filme
	 * @return
	 * @throws LocadoraFilmesException
	 */
	public Filme alterar(Filme filme) throws LocadoraFilmesException;
	
	/**
	 * Exclui um filme
	 * @param id
	 * @throws LocadoraFilmesException
	 */
	public void excluir(Integer id) throws LocadoraFilmesException;
	
	/**
	 * Consulta um filme pelo identificador
	 * @param id
	 * @return
	 * @throws LocadoraFilmesException
	 */
	public Filme consultar(Integer id) throws LocadoraFilmesException;
	
	/**
	 * Lista todas os filmes cadastrados
	 * @return
	 * @throws LocadoraFilmesException
	 */
	
	public List<Filme> listar() throws LocadoraFilmesException;

}
