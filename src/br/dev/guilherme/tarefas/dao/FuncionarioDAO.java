package br.dev.guilherme.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.guilherme.tarefas.factory.ArquivoFuncionarioFactory;
import br.dev.guilherme.tarefas.model.Funcionario;

public class FuncionarioDAO {

	private Funcionario funcionario;
	private ArquivoFuncionarioFactory aff = new ArquivoFuncionarioFactory(); // isso aqui é uma injeçao de dependencia

	public FuncionarioDAO(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public boolean gravar() { // colocamos o gravar como booleano para retornar falso ou verdadeiro

		try {
			BufferedWriter bw = aff.getBw();
			bw.write(funcionario.toString());
			bw.flush();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public List<Funcionario> getFuncionarios() {

		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		try {
			BufferedReader br = aff.getBr();

			String linha = "";

			while (linha != null) {
				linha = br.readLine();
				if (linha != null) {
					String[] funcionarioVetor = linha.split(",");
					Funcionario funcionario = new Funcionario(null);
					funcionario.setMatricula(funcionarioVetor[0]);
					funcionario.setNome(funcionarioVetor[1]);
					funcionario.setCargo(funcionarioVetor[2]);
					funcionario.setSetor(funcionarioVetor[3]);
					funcionario.setSalario(Double.parseDouble(funcionarioVetor[4]));
					funcionarios.add(funcionario);
				}

			}

			return funcionarios;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//método criado para buscar funcionarios por nomes
	public Funcionario buscarFuncionarioPorNome(String nome) {
	    List<Funcionario> funcionarios = getFuncionarios();

	    if (funcionarios != null) {  // Verifica se a lista existe
	        for (Funcionario f : funcionarios) { // Percorre cada funcionário da lista
	            if (f.getNome().equalsIgnoreCase(nome)) { // Compara o nome do funcionário atual com o nome passado,
	                return f;
	            }
	        }
	    }

	    return null;
	}
	
	public String[] getNomesFuncionariosArray() {
	    List<Funcionario> funcionarios = getFuncionarios();
	    if (funcionarios != null) {
	        String[] nomes = new String[funcionarios.size()];// Cria um array de String com o tamanho igual ao número de funcionários na lista
	        for (int i = 0; i < funcionarios.size(); i++) {// Percorre a lista e para cada funcionário, pega o nome 
	            nomes[i] = funcionarios.get(i).getNome();  // e coloca na posição correspondente do array
	        }
	        return nomes;
	    }
	    return new String[0]; //Se a lista for nula não irá retornar nada
	}

}
