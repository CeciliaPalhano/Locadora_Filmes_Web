package Projeto.LocadoraFilmes.controle;

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * Classe que representa o formulario web de Filme
 * @author Cecília
 *
 */
@Component
public class FilmeBean {
	
	private Integer id;
	private String nome;
	private String assunto;
	private int duracao;
	private Date datalocacao;
	private Date dataentrega;
	private float precolocacao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public Date getDatalocacao() {
		return datalocacao;
	}
	public void setDatalocacao(Date datalocacao) {
		this.datalocacao = datalocacao;
	}
	public Date getDataentrega() {
		return dataentrega;
	}
	public void setDataentrega(Date dataentrega) {
		this.dataentrega = dataentrega;
	}
	public float getPrecolocacao() {
		return precolocacao;
	}
	public void setPrecolocacao(float precolocacao) {
		this.precolocacao = precolocacao;
	}
	
}