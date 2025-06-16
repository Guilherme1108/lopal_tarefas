//package br.dev.guilherme.tarefas.dao;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import br.dev.guilherme.tarefas.factory.ArquivoTarefasFactory;
//import br.dev.guilherme.tarefas.model.Tarefa;
//
//
//public class TarefaDAO {
//	
//	private Tarefa tarefa;
//	private ArquivoTarefasFactory atf = new ArquivoTarefasFactory(); // isso aqui é uma injeçao de dependencia
//
//	public TarefaDAO(Tarefa tarefa) {
//		this.tarefa = tarefa;
//	}
//
//	public boolean gravar() { // colocamos o gravar como booleano para retornar falso ou verdadeiro
//
//		try {
//			BufferedWriter bw = atf.getBw();
//			bw.write(tarefa.toString());
//			bw.flush();
//			return true;
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			return false;
//		}
//
//	}
//
//	public List<Tarefa> getTarefas() {
//
//		List<Tarefa> tarefas = new ArrayList<Tarefa>();
//
//		try {
//			BufferedReader br = atf.getBr();
//
//			String linha = "";
//
//			while (linha != null) {
//				linha = br.readLine();
//				if (linha != null) {
//					String[] tarefaVetor = linha.split(",");
//					Tarefa tarefa = new Tarefa(null);
//					tarefa.setIdentificacao(tarefaVetor[0]);
//					tarefa.setNome(tarefaVetor[1]);
//					tarefa.setDescricao(tarefaVetor[2]);
//					tarefa.setResponsavel(tarefaVetor[3]);
//					tarefas.add(tarefa);
//				}
//
//			}
//
//			return tarefas;
//
//		} catch (IOException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//
//}
