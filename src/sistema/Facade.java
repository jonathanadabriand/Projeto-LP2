package sistema;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import easyaccept.EasyAccept;

public class Facade implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		args = new String[] { "sistema.Facade", "Testes_aceitacao/us1_test.txt", "Testes_aceitacao/us2_test.txt", "Testes_aceitacao/us3_test.txt", 
				"Testes_aceitacao/us4_test.txt", "Testes_aceitacao/us5_test.txt", "Testes_aceitacao/us6_test.txt"};
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
	
	public int pedirAjudaPresencial (String matAluno, String disciplina, String horario, String dia, String localInteresse){
		return c.pedirAjudaPresencial(matAluno, disciplina, horario, dia, localInteresse);
	}
	
	public int pedirAjudaOnline (String matAluno, String disciplina) {
		return c.pedirAjudaOnline(matAluno, disciplina);
	}
	
	public String getInfoAjuda(int idAjuda, String atributo) {
		return c.getInfoAjuda(idAjuda, atributo);
	}
	
	public String pegarTutor(int idAjuda) {
		return c.pegarTutor(idAjuda);
	}
	
	public String avaliarTutor (int idAjuda, int nota) {
		return c.avaliarTutor(idAjuda, nota);
	}
	public String pegarNota(String matriculaTutor) {
		return c.pegarNota(matriculaTutor);
	}
	public String pegarNivel(String matriculaTutor) {
		return c.pegarNivel(matriculaTutor);
	}
	
	//us6
	
   public void doar(String matriculaTutor, int totalCentavos) {
	   c.doar( matriculaTutor, totalCentavos);
   }
    public int totalDinheiroTutor(String emailTutor) {
    	return c.totalDinheiroTutor(emailTutor);
    }
    public int totalDinheiroSistema() {
    	return c.totalDinheiroSistema();
    }
    
    //us7
    public void configurarOrdem(String atributo) {
    	c.configurarOrdem(atributo);
    }
    
    //us8
    public void salvar(){
    	try {
    		this.limpar();
    		ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("dados.bin"));
    		save.writeObject(c);
    		save.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
    }
    
    public void carregar() {
    	try {
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("dados.bin"));
			ControleQMA c = (ControleQMA) in.readObject();
			this.c = c;
			in.close();
			
		} catch (Exception e) {
			e.getStackTrace();
		}
    }
    
    public void limpar() {
    	try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("dados.bin"));
			out.reset();
			out.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
    }
	
}

