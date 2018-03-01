package sistema;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;





public class ControleQMA {
	ArrayList<Aluno> alunos;
	ArrayList<Tutor> tutores;

	public ControleQMA() {
		this.alunos = new ArrayList<>();
		this.tutores = new ArrayList<>();
	}
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		verificaCadastro(matricula, nome, email);
		Aluno a1 = new Aluno(nome, matricula, codigoCurso, telefone, email);
		alunos.add(a1);
	}
	
	public String recuperaAluno(String matricula) {
		verificaRecuperaAluno(matricula);
		Aluno a = retornaAluno(matricula);
		return 	a.toString();
	}
	
	public String listarAlunos() {
		String listagem = "";
		Collections.sort(alunos);
		for(Aluno a: alunos) {
			listagem += a.toString() + ", ";
		}
		 listagem = listagem.substring(0, listagem.length() - 2);
		return listagem;
	}
	
	public String getInfoAluno(String matricula, String atributo) {
		verificaGetInfoAluno(matricula);
		Aluno a = retornaAluno(matricula);
		if(atributo.toLowerCase().equals("nome")) {
			return a.getNome();
		}
		else if(atributo.toLowerCase().equals("email")) {
			return a.getEmail();
		}
		else if(atributo.toLowerCase().equals("telefone")) {
			return a.getTelefone();
		}
		return "Atributo nao encontrado";
	}

	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
			verificaTornaTutor(matricula, disciplina, proficiencia);
			Aluno a = retornaAluno(matricula);;
			if (retornaTutor(matricula) == null) {
				Tutor t = new Tutor(a.getNome(), a.getMatricula(), a.getCodigoCurso(), a.getTelefone(), a.getEmail(), disciplina, proficiencia);
				tutores.add(t);
			}	
			else {
				retornaTutor(matricula).addDisciplina(disciplina, proficiencia);
			}
	}
	

	public String recuperaTutor(String matricula) {
		verificaRecuperaTutor(matricula);
		return retornaTutor(matricula).toString();
		
	}

	

	public String listarTutores() {
		String listagem = "";
		for(Tutor t: tutores) {
			listagem += t.toString() + ", ";
		}
		listagem = listagem.substring(0, listagem.length() - 2);
		return listagem;
	}
	
	
	public Aluno retornaAluno(String matricula) {
		Aluno a1 = null;
		for(Aluno a2: alunos) {
			if(a2.getMatricula().equals(matricula)){
				a1 = a2;
			}	
		}	
		return a1;	
	}
	
	public Tutor retornaTutor(String matricula) {
		Tutor t1 = null;
		for(Tutor t2: tutores) {
			if(t2.getMatricula().equals(matricula)){
				t1 = t2;
			}	
		}	
		return t1;	
	}
	
	
	
	private void verificaCadastro(String matricula, String nome, String email) {
		Pattern p = Pattern.compile("\\w+@\\w+");
		Matcher m = p.matcher(email);
		if(!m.find()) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Email invalido");
		}
		for(Aluno a: alunos) {
			if(a.getMatricula().equals(matricula)){
				throw new IllegalArgumentException("Erro no cadastro de aluno: Aluno de mesma matricula ja cadastrado");
			}
		} 
		if(nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo");
		}
		
	}
	
	private void verificaRecuperaAluno(String matricula) {
		if(retornaAluno(matricula)== null) {
			throw new IllegalArgumentException("Erro na busca por aluno: Aluno nao encontrado");
		}
	}
	
	private void verificaGetInfoAluno(String matricula) {
		if(retornaAluno(matricula)== null) {
			throw new IllegalArgumentException("Erro na obtencao de informacao de aluno: Aluno nao encontrado");
		}
	}
	
	private void verificaTornaTutor(String matricula, String disciplina, int proficiencia) {
		if(retornaAluno(matricula)== null) {
			throw new IllegalArgumentException("Erro na definicao de papel: Tutor nao encontrado");
		}
		else if(proficiencia < 1 || proficiencia > 5) {
			throw new IllegalArgumentException("Erro na definicao de papel: Proficiencia invalida");
		}
		else if(retornaTutor(matricula)!= null && retornaTutor(matricula).verificaDisciplina(disciplina)) {
            throw new IllegalArgumentException("Erro na definicao de papel: Ja eh tutor dessa disciplina");
        }
	}
	
	private void verificaRecuperaTutor(String matricula) {
		if(retornaTutor(matricula) == null) {
			throw new IllegalArgumentException("Erro na busca por tutor: Tutor nao encontrado");
		}
		
	}
	
	//us3
	public void cadastrarHorario(String email, String horario, String dia) {
		email = email.trim();
		horario = horario.trim();
		dia = dia.trim();
		if(email.isEmpty() || email.equals(null)) {
			throw new IllegalArgumentException("Erro no cadastrar horario: email nao pode ser vazio ou em branco");
		}
		if(horario.isEmpty() || horario.equals(null)) {
			throw new IllegalArgumentException("Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
		}
		if(dia.isEmpty() || dia.equals(null)) {
			throw new IllegalArgumentException("Erro no cadastrar horario: dia nao pode ser vazio ou em branco");
		}
		boolean existeTutor = false;
		for(Tutor tutor : this.tutores) {
			if(tutor.getEmail().equals(email)) {
				tutor.addHorario(horario, dia);
				existeTutor = true;
				break;
			}
		}
		if(!existeTutor) {
			throw new IllegalArgumentException("Erro no cadastrar horario: tutor nao cadastrado");
		}
	}
		
	public void cadastrarLocalDeAtendimento(String email, String local) {
		email = email.trim();
		local = local.trim();
		if(email.isEmpty() || email.equals(null)) {
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: email nao pode ser vazio ou em branco");
		}
		if(local.isEmpty() || local.equals(null)) {
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		}
		boolean existeTutor = false;
		for(Tutor tutor : this.tutores) {
			if(tutor.getEmail().equals(email)) {
				tutor.addLocalDeAtendimento(local);
				existeTutor = true;
				break;
			}
		}
		if(!existeTutor) {
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: tutor nao cadastrado");
		}
	}
		
	public boolean consultaHorario(String email, String horario, String dia) {
		for(Tutor tutor : this.tutores) {
			if(tutor.getEmail().equals(email)) {
				return tutor.consultaHorario(horario, dia);
			}
		}
		return false;
	}
		
	public boolean consultaLocal(String email, String local) {
		for(Tutor tutor : this.tutores) {
			if(tutor.getEmail().equals(email)) {
				return tutor.consultaLocalDeAtendimento(local);
			}
		}
		return false;
	}
	
}
