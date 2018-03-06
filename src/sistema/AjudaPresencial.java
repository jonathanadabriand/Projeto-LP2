package sistema;

public class AjudaPresencial extends Ajuda {
	private String horario, dia, localInteresse;
	
	public AjudaPresencial(String matAluno, String disciplina, String horario, String dia, String localInteresse) {
		super(matAluno, disciplina);
		this.horario = horario;
		this.dia = dia;
		this.localInteresse = localInteresse;
	}

	//getters e setters
	public String getHorario() {return horario;}

	public void setHorario(String horario) {this.horario = horario;}

	public String getDia() {return dia;}

	public void setDia(String dia) {this.dia = dia;	}

	public String getLocalInteresse() {return localInteresse;}

	public void setLocalInteresse(String localInteresse) {this.localInteresse = localInteresse;}
	
	@Override
	public String toString(){
		return "Tutor - " + getMatTutor() + ", horario - " + getHorario() + ", dia - " + getDia() + ", local - " + getLocalInteresse() + ", disciplina - " + getDisciplina();
	}

}
