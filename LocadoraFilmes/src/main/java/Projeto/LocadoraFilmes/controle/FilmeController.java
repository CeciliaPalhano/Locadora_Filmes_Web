package Projeto.LocadoraFilmes.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import Projeto.LocadoraFilmes.entidade.Filme;
import Projeto.LocadoraFilmes.negocio.FilmeService;
import Projeto.LocadoraFilmes.util.LocadoraFilmesException;

/**
 * Classe que controla as requisicoes do cliente web
 * @author Cecília
 *
 */
@ManagedBean(name="filmeController")
@RequestScoped
@Controller
public class FilmeController {
	
	@Autowired
	private FilmeBean filmeBean;
	@Autowired
	private List<FilmeBean> listaFilmeBean;
	@Autowired
	private FilmeService filmeService;

	/**
	 * Construtor da classe de filme
	 */
	@SuppressWarnings("unchecked")
	public FilmeController(){
		filmeBean = new FilmeBean();
	}
	
	/**
	 * Inclui um filme na base de dados
	 * @return
	 */
	public String incluir() {
		try{

			Filme filme = new Filme();

			//preenche os dados da tela no objeto persistente
			filme.setId(filmeBean.getId());
			filme.setNome(filmeBean.getNome());
			filme.setAssunto(filmeBean.getAssunto());
			filme.setDuracao(filmeBean.getDuracao());
			filme.setDatalocacao(filmeBean.getDatalocacao());
			filme.setDataentrega(filmeBean.getDataentrega());
			filme.setPrecolocacao(filmeBean.getPrecolocacao());

			getFilmeService().incluir(filme);
			
			return "sucesso";
		}
		catch (Exception e) {
			String msg = "Inclusao nao realizada. Motivo: "  + e.getMessage();
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}

	/**
	 * Lista os filmes cadastradas
	 * @return
	 */
	public String listar() {
		try{
			listaFilmeBean = new ArrayList<FilmeBean>();
			List<Filme> listaFilme = getFilmeService().listar();

			if(listaFilme==null || listaFilme.size()==0){
				FacesMessage message = new FacesMessage("Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
			}

			//preeche a lista de filmes da tela
			listaFilmeBean = new ArrayList<FilmeBean>();
			for (Filme filme : listaFilme) {
				FilmeBean filmeBean = new FilmeBean();
				filmeBean.setId(filme.getId());
				filmeBean.setNome(filme.getNome());
				filmeBean.setAssunto(filme.getAssunto());
				filmeBean.setDuracao(filme.getDuracao());
				filmeBean.setDatalocacao(filme.getDatalocacao());
				filmeBean.setDataentrega(filme.getDataentrega());
				filmeBean.setPrecolocacao(filme.getPrecolocacao());
				
				listaFilmeBean.add(filmeBean);		
				
			}
		
			return "listar";
		}
		catch (Exception e) {
			e.printStackTrace();
			String msg = "Listagem nao realizada. Motivo: " + ((e instanceof LocadoraFilmesException ? ((LocadoraFilmesException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}

	/**
	 * Consulta um filme cadastrado
	 * @return
	 */
	public String consultar() {
		try{

			String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
			
			Filme filme = getFilmeService().consultar(Integer.parseInt(id));

			if(filme==null || filme.getId()==null){
				FacesMessage message = new FacesMessage("Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
				return "listar";
			}

			//preenche os dados do bean da tela
			filmeBean.setId(filme.getId());
			filmeBean.setNome(filme.getNome());
			filmeBean.setAssunto(filme.getAssunto());
			filmeBean.setDuracao(filme.getDuracao());
			filmeBean.setDatalocacao(filme.getDatalocacao());
			filmeBean.setDataentrega(filme.getDataentrega());
			filmeBean.setPrecolocacao(filme.getPrecolocacao());
			
			
			return "editar";
			
		}
		
		catch (Exception e) {
			String msg = "Consulta nao realizada. Motivo: " + e.getMessage();
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
		
	}
	

	/**
	 * Cria um novo filme
	 * @return
	 */
	public String criar() {
		try{

			filmeBean = new FilmeBean();
			
			return "criar";
		}
		catch (Exception e) {
			String msg = "Criacao nao realizada. Motivo: " + e.getMessage();
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}

	/**
	 * Exclui um filme cadastrado
	 * @return
	 */
	public String excluir() {
		try{
			String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
			//HtmlInputHidden id = (HtmlInputHidden) this.getFacesContext().getViewRoot().findComponent("formulario:id");
			
			//Filme filme = getFilmeService().consultar((Integer)id.getValue());
			Filme filme = getFilmeService().consultar(Integer.valueOf(id));
			if(filme==null || filme.getId()==null){
				FacesMessage message = new FacesMessage("Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
				return "listar";
			}

			getFilmeService().excluir(filme.getId());
			
			return "sucesso";
		}
		catch (Exception e) {
			e.printStackTrace();
			String msg = "Exclusao nao realizada. Motivo: " + ((e instanceof LocadoraFilmesException ? ((LocadoraFilmesException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}
	
	/**
	 * Altera um filme cadastrado
	 * @return
	 */
	public String alterar() {
		try{

			Filme filme = getFilmeService().consultar(filmeBean.getId());

			if(filme==null || filme.getId()==null){
				FacesMessage message = new FacesMessage("Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
				return "listar";
			}

			//preenche os dados da tela no objeto persistente
			filme.setNome(filmeBean.getNome());
			filme.setAssunto(filmeBean.getAssunto());
			filme.setDuracao(filmeBean.getDuracao());
			filme.setDatalocacao(filmeBean.getDatalocacao());
			filme.setDataentrega(filmeBean.getDataentrega());
			filme.setPrecolocacao(filmeBean.getPrecolocacao());
			

			getFilmeService().alterar(filme);
			return "sucesso";
			
		}
		catch (Exception e) {
			String msg = "Alteracao nao realizada. Motivo: " + ((e instanceof LocadoraFilmesException ? ((LocadoraFilmesException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}
	
	public FilmeService getFilmeService() {
		return filmeService;
	}

	public void setPessoaService(FilmeService filmeService) {
		this.filmeService = filmeService;
	}
	
	private FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}
	
	private Object getSession(String variavel){
		return this.getFacesContext().getExternalContext().getSessionMap().get(variavel);
	}
	
	private void setSession(String variavel, Object objeto){
		this.getFacesContext().getExternalContext().getSessionMap().put(variavel, objeto);
	}
	
	public FilmeBean getFilmeBean() {
		return filmeBean;
	}

	public void setFilmeBean(FilmeBean filmeBean) {
		this.filmeBean = filmeBean;
	}

	public List<FilmeBean> getListaFilmeBean() {
		return listaFilmeBean;
	}

	public void setListaFilmeBean(List<FilmeBean> listaFilmeBean) {
		this.listaFilmeBean = listaFilmeBean;
	}

}
