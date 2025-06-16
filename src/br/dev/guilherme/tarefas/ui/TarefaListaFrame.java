package br.dev.guilherme.tarefas.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.guilherme.tarefas.model.Tarefa;

public class TarefaListaFrame {

	private JLabel labelTitulo;
	private JButton btnNovo;
	private JButton btnSair;
	private DefaultTableModel model; // dados da tabela
	private JTable tabelaFuncionarios; // tabela visualmente
	private JScrollPane scrollFuncionarios; // container da tabela
	String[] colunas = { "CÓDIGO", "STATUS", "DATA DE INICIO", "DATA DE ENTREGA" };

	public TarefaListaFrame(JFrame pai) {
		criarTela(pai);
	}

	private void criarTela(JFrame pai) {
		JDialog telaTarefaLista = new JDialog(pai, true);
		telaTarefaLista.setSize(700, 500);
		telaTarefaLista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		telaTarefaLista.setLayout(null);
		telaTarefaLista.setLocationRelativeTo(null);
		telaTarefaLista.setResizable(false);

		Container painel = telaTarefaLista.getContentPane();

		labelTitulo = new JLabel("Cadastro de Funcionários");
		labelTitulo.setBounds(10, 10, 500, 40);
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 32));
		labelTitulo.setForeground(Color.RED);

		// CRIAR TABELA
		model = new DefaultTableModel(colunas, 100); // adicionando as linhas a tabela
		tabelaFuncionarios = new JTable(model);
		scrollFuncionarios = new JScrollPane(tabelaFuncionarios);
		scrollFuncionarios.setBounds(10, 70, 680, 300);
		carregarDadosTabela();

		btnNovo = new JButton("Cadastrar novo funcionário");
		btnNovo.setBounds(10, 400, 250, 50);

		btnSair = new JButton("Sair");
		btnSair.setBounds(270, 400, 100, 50);

		btnNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new FuncionarioFrame(pai);
				carregarDadosTabela();
			}
		});

		btnSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

					telaTarefaLista.dispose(); // usado só para fechar o tela funcionario do que fechar tudo
				}
				// System.exit(JFrame.EXIT_ON_CLOSE); //essa funcao serve para encerrar o
				// programa, no lugar do exit_on_close poderia ser o numero 0 )

		});

		// container
		painel.add(labelTitulo);
		painel.add(scrollFuncionarios);
		painel.add(btnNovo);
		painel.add(btnSair);

		telaTarefaLista.setVisible(true);
	}

//	private void carregarDadosTabela() {
//
//		List<Tarefa> tarefas = new ArrayList<>();
//		TarefaDAO dao = new TarefaDAO(null);
//		tarefas = dao.getFuncionarios();
//
//		int i = 0;
//
//		Object[][] dados = new Object[funcionarios.size()][3];
//
//		for (Funcionario f : funcionarios) {
//			dados[i][0] = f.getMatricula();
//			dados[i][1] = f.getNome();
//			dados[i][2] = f.getCargo();
//
//			i++;
//
//		}
//		model.setDataVector(dados, colunas);
//	}


}
