package sistema;
import easyaccept.EasyAccept;

public class Facade {
	public static void main(String[] args) {
		args = new String[] { "sistema.Facade", "Testes_aceitacao/us1_test.txt", "Testes_aceitacao/us2_test.txt", "Testes_aceitacao/us3_test.txt"};
		EasyAccept.main(args);
	}
	
	private ControleQMA c = new ControleQMA();

	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		c.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}
	
	public String recuperaAluno(String matricula) {
		return c.recuperaAluno(matricula);
	}
	
	public String listarAlunos() {
		return c.listarAlunos();
	}
	public String getInfoAluno(String matricula, String atributo) {
		return c.getInfoAluno(matricula, atributo);
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		c.tornarTutor(matricula, disciplina, proficiencia);
	}
	public String recuperaTutor(String matricula) {
		return c.recuperaTutor(matricula);
	}
	public String listarTutores() {
		return c.listarTutores();
	}

	public void cadastrarHorario(String email, String horario, String dia) {
		c.cadastrarHorario(email, horario, dia);
	}
	
	public void cadastrarLocalDeAtendimento(String email, String local) {
		c.cadastrarLocalDeAtendimento(email, local);
	}
	
	public boolean consultaHorario(String email, String horario, String dia) {
		return c.consultaHorario(email, horario, dia);
	}
	
	public boolean consultaLocal(String email, String local) {
		return c.consultaLocal(email, local);
	}

	
}

