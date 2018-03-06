package sistema;

public class Ajuda {
	private String matAluno, disciplina, matTutor;
	
	public Ajuda(String matAluno, String disciplina) {
		this.matAluno = matAluno;
		this.disciplina = disciplina;
		
	}
	
	public String getMatAluno() {return matAluno;}

	public void setMatAluno(String matAluno) {this.matAluno = matAluno;}
	
	public String getDisciplina() {return disciplina;}

	public void setDisciplina(String disciplina) {this.disciplina = disciplina;}
	
	public void setMatTutor(String matTutor) {this.matTutor = matTutor;}

	public String getMatTutor() {return matTutor;}
	
	@Override
	public String toString() {
		return "Tutor - " + getMatTutor() + ", disciplina - " +  getDisciplina();
	}
}
