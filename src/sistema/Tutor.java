package sistema;


import java.util.ArrayList;


public class Tutor extends Aluno{
	private ArrayList<Disciplina> disciplinas;
	private int nota, dinheiro;
	private ArrayList<Horario> horarios;
	private ArrayList<LocalDeAtendimento> locais;
	
	public Tutor(String nome, String matricula, int codigoCurso, String telefone, String email, String disciplina, int proficiencia) {
		super(nome, matricula, codigoCurso, telefone, email);
		this.disciplinas = new ArrayList<>();
		addDisciplina(disciplina, proficiencia);
		this.nota = 4;
		this.dinheiro = 0;
		this.horarios = new ArrayList<>();
		this.locais = new ArrayList<>();
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
	
	public void addHorario(String hora, String dia) {
		this.horarios.add(new Horario(hora, dia));
	}
	
	public void addLocalDeAtendimento(String local) {
		this.locais.add(new LocalDeAtendimento(local));
	}
	
	public boolean consultaHorario(String hora, String dia) {
		for(Horario horario : this.horarios) {
			if(horario.getHora().equals(hora) && horario.getDia().equals(dia)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean consultaLocalDeAtendimento(String consultaDeLocal) {
		for(LocalDeAtendimento local : this.locais) {
			if(local.getLocalDeAtendimento().equals(consultaDeLocal)) {
				return true;
			}
		}
		return false;
	}	

}
