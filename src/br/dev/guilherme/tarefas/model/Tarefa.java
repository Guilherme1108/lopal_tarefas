package br.dev.guilherme.tarefas.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.dev.guilherme.tarefas.utils.Utils;

public class Tarefa {

	private String identificacao;
	private String nome;
	private String descricao;
	private Funcionario responsavel;
	private LocalDate dataInicio;
	private int prazo;
	private LocalDate dataEntrega;
	private Status status;

	private String dataInicioFormatada;
	private String dataEntregaFormatada;

	// construtor
    public Tarefa() {
        this.identificacao = Utils.gerarUUID8();
    }
	
	public Tarefa(Funcionario funcionario) {
		setResponsavel(funcionario);
		this.identificacao = Utils.gerarUUID8();
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Funcionario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataFormatada) {
		this.dataInicio = LocalDate.parse(dataFormatada, DateTimeFormatter.ofPattern("dd/MM/yyyy"));  //converte para LocalDate
		dataInicioFormatada = dataInicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")); //converte do LocalDate para formato de texto novamente
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	public LocalDate getDataPrevistaEntrega() {
		return dataInicio.plusDays(prazo);
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataFormatada) {
		this.dataEntrega = LocalDate.parse(dataFormatada, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		dataEntregaFormatada = dataEntrega.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public Status getStatus() {
		LocalDate hoje = LocalDate.now();
		if (hoje.isBefore(dataInicio)) {
			status = Status.NAO_INICIADO;

		} else if (!hoje.isAfter(dataEntrega)) {
			status = Status.EM_ANDAMENTO;

		} else {
			status = Status.EM_ATRASO;
		}

		return status;
	}

	
	@Override
	public String toString() {
		return identificacao + "," + nome + "," + descricao + "," + responsavel + "," + dataInicioFormatada + "," + dataEntregaFormatada + "," + status + "\n";
	}

}
