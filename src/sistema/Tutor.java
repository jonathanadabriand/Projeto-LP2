package sistema;


import java.util.HashMap;

public class Tutor extends Aluno{
	private HashMap<String, Integer> disciplinas = new HashMap<>();
	private int nota, dinheiro;
	
	public Tutor(String nome, String matricula, int codigoCurso, String telefone, String email, String disciplina, int proficiencia) {
		super(nome, matricula, codigoCurso, telefone, email);
		disciplinas.put(disciplina, proficiencia);
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
		return disciplinas.containsKey(disciplina);
	}

	public void addDisciplina(String disciplina, int proficiencia) {
		disciplinas.put(disciplina, proficiencia);
	}
	
	

	
	
		

}
