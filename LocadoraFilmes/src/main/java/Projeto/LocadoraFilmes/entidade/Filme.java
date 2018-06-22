package Projeto.LocadoraFilmes.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe que representa os dados persistentes de filme
 * @author Cecília
 *
 */
@Entity
@Table(name="filme")
public class Filme implements Serializable{

	private static final long serialVersionUID = 6487849002108370775L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nome")
	private String nome;

	@Column(name="assunto")
	private String assunto;
	
	@Column(name="duracao")
	private int duracao;
	
	@Column(name="datalocacao")
	private Date datalocacao;
	
	@Column(name="dataentrega")
	private Date dataentrega;
	
	@Column(name="precolocacao")
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

	public void setDuracao(int i) {
		this.duracao = i;
	}

	public Date getDatalocacao() {
		return datalocacao;
	}

	public void setDatalocacao(Date date) {
		this.datalocacao = date;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void setPrecolocacao(float f) {
		this.precolocacao = f;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
	
	