package sistema;

public class Ajuda {
	private String matAluno, disciplina, matTutor;
	private boolean ajudaAvaliada;
	
	public Ajuda(String matAluno, String disciplina) {
		this.matAluno = matAluno;
		this.disciplina = disciplina;
		this.ajudaAvaliada = false;
	}
	
	public String getMatAluno() {return matAluno;}

	public void setMatAluno(String matAluno) {this.matAluno = matAluno;}
	
	public String getDisciplina() {return disciplina;}

	public void setDisciplina(String disciplina) {this.disciplina = disciplina;}
	
	public void setMatTutor(String matTutor) {this.matTutor = matTutor;}

	public String getMatTutor() {return matTutor;}
	
	public String avaliarAgenda() {
		if (ajudaAvaliada ==  true) {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: Ajuda ja avaliada");
		}
		ajudaAvaliada = true;
		return matTutor;
	}
	
	@Override
	public String toString() {
		return "Tutor - " + getMatTutor() + ", disciplina - " +  getDisciplina();
	}
}
