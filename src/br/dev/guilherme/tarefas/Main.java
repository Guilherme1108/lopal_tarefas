package br.dev.guilherme.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

import br.dev.guilherme.tarefas.dao.FuncionarioDAO;
import br.dev.guilherme.tarefas.model.Funcionario;
import br.dev.guilherme.tarefas.model.Status;
import br.dev.guilherme.tarefas.model.Tarefa;
import br.dev.guilherme.tarefas.ui.FuncionarioFrame;
import br.dev.guilherme.tarefas.ui.FuncionarioListaFrame;
import br.dev.guilherme.tarefas.utils.Utils;

public class Main {

	public static void main(String[] args) {
		
		FuncionarioDAO dao = new FuncionarioDAO(null);
		dao.getFuncionarios();
		//new FuncionarioListaFrame();
		//new FuncionarioFrame();
		
//		Funcionario funcionario = new Funcionario("Guilherme", "Programador");
//		funcionario.setSetor("Técnologia da Informação");
//		funcionario.setSalario(8489.98);
//		
//		FuncionarioDAO dao = new FuncionarioDAO(funcionario);
//		dao.gravar();
		
		
		
		//   NÃO SERÁ MAIS UTILZIADO
//		System.out.println(funcionario.toString());
//		
//		
//		Tarefa tarefa = new Tarefa(funcionario); //o construtor do tarefa precisa de um funcionario
//		tarefa.setNome("Lavar a louça");
//		tarefa.setDescricao("lavar a louça antes da mãe chegar.");
//		tarefa.setDataInicio(LocalDate.of(2025, 5, 21));
//		tarefa.setPrazo(1);
//		tarefa.setStatus(Status.EM_ANDAMENTO);
//		
//		
//		System.out.println(Utils.gerarUUID8());
		
		
		//testarLeituraEscritaArquivo();

	}

	private static void testarLeituraEscritaArquivo() {
		String so = System.getProperty("os.name"); //mostra o sistema operacional da pessoa
		System.out.println(so);
		
		String caminho = "/Users/25133025/projetoTarefas/tarefas"; // passando o caminho(path) do arquivo que queremos
		
    FileReader fr = null; //declarei a variavel fora para poder usar em outros lugares
    BufferedReader br = null;
    
    FileWriter fw = null;
    BufferedWriter bw = null;
    		
		try {
			fr = new FileReader(caminho); // o file reader precisa estar dentro de um try catch, para nós podermos descobrir o erro que está tendo e funcionar
			br = new BufferedReader(fr); // tem acesso ao arquivo
			
			fw = new FileWriter(caminho, true); //colocando o true ele não vai apagar, porque ele pede um append
			bw = new BufferedWriter(fw);
			
			bw.append("Ionia precisa de nós\n"); // precisa do \n para ip para a proxima linha para não ficar tudo junto
			bw.flush(); //por padrão o flush remove todo o arquivo e substitui
			
			String linha = br.readLine(); // comando para ver uma linha no arquivo
			
			while (linha != null) { // ele basicamente fala, a linha não é igual nulo se for verdade ele entra e mostra as linhsa, se for falso ele sai
				System.out.println(linha);
				linha = br.readLine();
			}
			
		} catch (FileNotFoundException erro) {
			System.out.println("Arquivo não encontrado");
		} catch (IOException erro) {
			System.out.println("O arquivo está protegido para leitura");
		} catch (Exception erro) {
			System.out.println(erro.toString()); //pega a mensagem de erro que aparece e mostra para o usuario
		}
	}

}
