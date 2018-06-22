package Projeto.LocadoraFilmes.persistencia;

import java.io.Serializable;
import java.util.List;

import Projeto.LocadoraFilmes.util.LocadoraFilmesException;

/**
 * Interface que define as operacoes da camada de persistencia generica
 * @author Cecília
 *
 */
public interface GenericoDAO<T, ID extends Serializable> {
	
	/**
	 * Retorna a classe a ser persistida
	 * @return
	 */
	public Class<T> getObjectClass();
	
	/**
	 * Inclui um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws LocadoraFilmesException
	 */
	public T incluir(T object) throws LocadoraFilmesException;
	
	/**
	 * Altera um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws LocadoraFilmesException
	 */
	public T alterar(T object) throws LocadoraFilmesException;
	
	/**
	 * Consulta um objeto T da base de dados
	 * @param id
	 * @return
	 * @throws LocadoraFilmesException
	 */
	public T consultar(Integer id) throws LocadoraFilmesException;
	
	/**
	 * Exclui um objeto T  da base de dados
	 * @param id
	 * @throws LocadoraFilmesException
	 */
	
	public void excluir(Integer id) throws LocadoraFilmesException;
	
	/**
	 * Lista os objetos T da base de dados
	 * @return
	 * @throws LocadoraFilmesException
	 */
	public List<T> listar() throws LocadoraFilmesException;
}
