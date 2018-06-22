package Projeto.LocadoraFilmes.util;

/**
 * Classe que encapsula as excecoes da aplicacao LocadoraFilmes
 * @author Cec�lia
 *
 */
public class LocadoraFilmesException extends Exception {
	
	private static final long serialVersionUID = 1189188521388183949L;
	private Exception ex;
	private String msg;

	public LocadoraFilmesException(Exception e){
		ex = e;
		msg = e.getMessage();
	}

	public LocadoraFilmesException(Exception e, String mensagem){
		e.printStackTrace();
		ex = e;
		msg = mensagem;
	}

	public Exception getEx() {
		return ex;
	}

	public String getMsg() {
		return msg;
	}
	
}
