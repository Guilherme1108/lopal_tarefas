package br.dev.guilherme.tarefas.factory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoFuncionarioFactory {

	private String caminho = "/Users/25133025/projetoTarefas/funcionarios.csv"; // criando um caminho para o arquivo
	private FileWriter fw;
	private BufferedWriter bw;

	public BufferedWriter getBw() throws IOException { //esse throws IOExpeption faz a execao (erro) ir para quem chamou ele
		
		fw = new FileWriter(caminho, true);
		bw = new BufferedWriter(fw);
		
		return bw;
	}

}
