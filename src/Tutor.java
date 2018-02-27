
public class Tutor extends Aluno{
	private String disciplina;
	private int proficiencia;

	public Tutor(String nome, String matricula, int codigoCurso, String telefone, String email, String disciplina, int proficiencia) {
		super(nome, matricula, codigoCurso, telefone, email);
		this.disciplina = disciplina;
		this.setProficiencia(proficiencia);
	}

	public String getDisciplina() {
		return disciplina;
	}

	public int getProficiencia() {
		return proficiencia;
	}

	public void setProficiencia(int proficiencia) {
		this.proficiencia = proficiencia;
	}
		

}
