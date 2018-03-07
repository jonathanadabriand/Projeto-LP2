package sistema;

public class Disciplina {
	private String nomeDisciplina;
	private int proficiencia;

	public Disciplina(String nomeDisciplina, int proficiencia) {
		this.nomeDisciplina = nomeDisciplina;
		this.proficiencia = proficiencia;
	}

	public int getProficiencia() {
		return proficiencia;
	}

	public void setProficiencia(int proficiencia) {
		this.proficiencia = proficiencia;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	
	
	
}
