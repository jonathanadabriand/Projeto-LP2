package sistema;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.omg.PortableServer.ThreadPolicyOperations;

public class ControleQMA {
	HashMap<String, Aluno> alunos;
	HashMap<String, Tutor> tutores;

	public ControleQMA() {
		this.alunos = new HashMap<>();
		this.tutores = new HashMap<>();
	}
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		verificaCadastro(matricula, nome, email);
		Aluno a1 = new Aluno(nome, matricula, codigoCurso, telefone, email);
		alunos.put(matricula, a1);
	}
	
	public String recuperaAluno(String matricula) {
		verificaRecuperaAluno(matricula);
		return alunos.get(matricula).toString();
	}
	
	public String listarAlunos() {
		String listagem = "";
		for(Aluno a: alunos.values()) {
			listagem += a.toString() + ", ";
		}
		return listagem;
	}
	
	public String getInfoAluno(String matricula, String atributo) {
		verificaGetInfoAluno(matricula);
		Aluno a2 = alunos.get(matricula);
		if(atributo.toLowerCase().equals("nome")) {
			return a2.getNome();
		}
		else if(atributo.toLowerCase().equals("email")) {
			return a2.getEmail();
		}
		else if(atributo.toLowerCase().equals("telefone")) {
			return a2.getTelefone();
		}
		return "Atributo nao encontrado";
	}

	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
			verificaTornaTutor(matricula, disciplina, proficiencia);
			Aluno a = alunos.get(matricula);
			if (tutores.containsKey(matricula)) {
				tutores.get(matricula).addDisciplina(disciplina, proficiencia);
			}
			else {
			Tutor t = new Tutor(a.getNome(), a.getMatricula(), a.getCodigoCurso(), a.getTelefone(), a.getEmail(), disciplina, proficiencia);
			tutores.put(matricula, t);
			}
	}

	public String recuperaTutor(String matricula) {
		verificaRecuperaTutor(matricula);
		return tutores.get(matricula).toString();
		
	}

	

	public String listarTutores() {
		String listagem = "";
		for(String t: tutores.keySet()) {
			listagem += t.toString() + ", ";
		}
		return listagem;
	}
	
	
	
	
	
	
	
	private void verificaCadastro(String matricula, String nome, String email) {
		Pattern p = Pattern.compile("\\w+@\\w+");
		Matcher m = p.matcher(email);
		if(!m.find()) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Email invalido");
		}
		if(alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Aluno de mesma matricula ja cadastrado");
		}
		if(nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo");
		}
		
	}
	
	private void verificaRecuperaAluno(String matricula) {
		if(!alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro na busca por aluno: Aluno nao encontrado");
		}
	}
	
	private void verificaGetInfoAluno(String matricula) {
		if(!alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro na obtencao de informacao de aluno: Aluno nao encontrado");
		}
	}
	
	private void verificaTornaTutor(String matricula, String disciplina, int proficiencia) {
		if(!alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro na definicao de papel: Tutor nao encontrado");
		}
		else if(proficiencia < 1 || proficiencia > 5) {
			throw new IllegalArgumentException("Erro na definicao de papel: Proficiencia invalida");
		}
	}
	
	private void verificaRecuperaTutor(String matricula) {
		if(!tutores.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro na busca por tutor: Tutor nao encontrado");
		}
		
	}
}
