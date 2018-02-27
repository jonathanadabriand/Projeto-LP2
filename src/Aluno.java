import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Aluno {
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
	
	
	private void verificaAluno(String nome, String email) {
		
	}
	
}
	
	
	

