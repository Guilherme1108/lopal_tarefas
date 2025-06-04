package br.dev.guilherme.tarefas.model;

import br.dev.guilherme.tarefas.utils.Utils;

public class Funcionario {

	private String matricula;
	private String nome;
	private String cargo;
	private String setor;
	private Double salario;
	
	//métodos construtores

	public Funcionario(String nome) { // o método construtor faz com que personalizamos como pedimos para criar um obejto
//		System.out.printf("criando um funcionario %s como %s.", nome, cargo);
		setNome(nome);
		setMatricula(Utils.gerarUUID8());
	}
	
	public Funcionario(String nome, String cargo) {
		this.matricula = Utils.gerarUUID8();
		this.nome = nome;
		this.cargo = cargo;
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
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	@Override
	public String toString() { //sobreescrevendo o método toString
		
		return matricula + "," + nome + "," + cargo + "," + setor + "," + salario + "\n"; //quando tem o super eu estou me referindo a classe mãe (objetic)
		// neste caso nos vamos fazer aparecer os dados + as virgulas
	}

}
