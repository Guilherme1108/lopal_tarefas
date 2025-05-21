package br.dev.guilherme.tarefas.model;

public class Funcionario {

	private String nome;
	private String cargo;
	private String setor;
	
	//método construtor
	public Funcionario() {
		System.out.println("Criando um funcionario");
	}

	public Funcionario(String nome, String cargo) {
		System.out.printf("criando um funcionario com nome %s e cargo %s.", nome, cargo);
		setNome(nome);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

}
