package sistema;


import java.util.ArrayList;


public class Tutor extends Aluno{
	private ArrayList<Disciplina> disciplinas = new ArrayList<>();
	private int nota, dinheiro;
	
	public Tutor(String nome, String matricula, int codigoCurso, String telefone, String email, String disciplina, int proficiencia) {
		super(nome, matricula, codigoCurso, telefone, email);
		addDisciplina(disciplina, proficiencia);
		this.nota = 4;
		this.dinheiro = 0;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public int getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(int dinheiro) {
		this.dinheiro = dinheiro;
	}

	public boolean verificaDisciplina(String disciplina) {
		for(Disciplina d: disciplinas) {
			if(d.getNomeDisciplina().equals(disciplina)) {
				return true;
			}
		}
		return false;
	}

	public void addDisciplina(String disciplina, int proficiencia) {
		Disciplina d = new Disciplina(disciplina, proficiencia);
		disciplinas.add(d);
	}
	
	

	
	
		

}
