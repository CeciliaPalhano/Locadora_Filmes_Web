package Projeto.LocadoraFilmes.negocio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import Projeto.LocadoraFilmes.entidade.Filme;
import Projeto.LocadoraFilmes.persistencia.FilmeDAO;
import Projeto.LocadoraFilmes.util.LocadoraFilmesException;

/**
 * Classe que define as operacoes da camada de negocio de Filme
 * @author Cecília
 *
 */
@Service
@Transactional
public class FilmeServiceImpl implements FilmeService {

	//Interface da persistencia
	private FilmeDAO filmeDAO;

	public FilmeDAO getFilmeDAO() {
		return filmeDAO;
	}

	@Autowired
	public void setFilmeDAO(FilmeDAO filmeDAO) {
		this.filmeDAO = filmeDAO;
	}

	/**
	 * Inclui um filme
	 * @param filme
	 * @return
	 * @throws LocadoraFilmesException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Filme incluir(Filme filme) throws LocadoraFilmesException {
		return getFilmeDAO().incluir(filme);
	}

	/**
	 * Altera um filme
	 * @param filme
	 * @return
	 * @throws LocadoraFilmesException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Filme alterar(Filme filme) throws LocadoraFilmesException {
		
		//exclui os itens da base que foram removidos da tela
		Filme filmeExistente = this.consultar(filme.getId());
		
		return getFilmeDAO().alterar(filme);
	}

	/**
	 * Exclui um filme
	 * @param filme
	 * @throws LocadoraFilmesException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void excluir(Integer id) throws LocadoraFilmesException {
		
		//exclui todos os itens antes de excluir o filme
		Filme filmeExistente = this.consultar(id);

		getFilmeDAO().excluir(id);
	}

	/**
	 * Consulta um filme pelo identificador
	 * @param id
	 * @return
	 * @throws LocadoraFilmesException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public Filme consultar(Integer id) throws LocadoraFilmesException {
		Filme filme = getFilmeDAO().consultar(id);
		
		return filme;
	}
	/**
	 * Lista todos os filmes cadastrados
	 * @return
	 * @throws LocadoraFilmesException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public List<Filme> listar() throws LocadoraFilmesException {
		return getFilmeDAO().listar();
	}

}
