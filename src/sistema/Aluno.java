package sistema;

import java.io.Serializable;

public class Aluno implements Comparable<Aluno>, Serializable{

	private static final long serialVersionUID = 20;
	
	private int  nota, codigoCurso;
	private String matricula, nome, email, telefone;
	
	public Aluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.matricula = matricula;
		this.nome = nome;
		this.codigoCurso =  codigoCurso;
		this.email = email;
		this.nota = 5;
		this.telefone = telefone;
	}
	
	//getters
	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public int getCodigoCurso() {
		return codigoCurso;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}
	
	@Override
	public String toString() {
		if (telefone.trim().isEmpty()) {
			return matricula + " - "  + nome + " - "  + codigoCurso + " - " + email;
		}
		return matricula + " - "  + nome + " - "  + codigoCurso  + " - " + telefone + " - " + email;

	}

	@Override
	public int compareTo(Aluno outroAluno) {
		return 	this.getNome().compareTo(outroAluno.getNome());
			
	}



	
	
	
	
}
	
	
	

