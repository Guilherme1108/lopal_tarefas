package br.dev.guilherme.tarefas.factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoFuncionarioFactory {

	private String caminho = "/Users/25133025/projetoTarefas/funcionarios.csv"; // criando um caminho para o arquivo
	private FileWriter fw;
	private BufferedWriter bw;
	private FileReader fr;
	private BufferedReader br;

	public BufferedWriter getBw() throws IOException { //esse throws IOExpeption faz a execao (erro) ir para quem chamou ele
		
		fw = new FileWriter(caminho, true);
		bw = new BufferedWriter(fw);
		
		return bw;
	}
	
	public BufferedReader getBr() throws IOException {
		fr = new FileReader(caminho);
		br = new BufferedReader(fr);
		return br;
	}
	

}
