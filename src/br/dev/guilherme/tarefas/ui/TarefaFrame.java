package br.dev.guilherme.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import br.dev.guilherme.tarefas.dao.FuncionarioDAO;
import br.dev.guilherme.tarefas.dao.TarefaDAO;
import br.dev.guilherme.tarefas.model.Funcionario;
import br.dev.guilherme.tarefas.model.Tarefa;
import br.dev.guilherme.tarefas.utils.Utils;

public class TarefaFrame {
	
	private JLabel labelIdentificacao;
	private JLabel labelNome;
	private JLabel labelDescricao;
	private JLabel labelResponsavel;
	private JLabel labelDataInicio;
	private JLabel labelPrazo;
	private JLabel labelDataEntrega;
	
	private JTextField txtIdentificacao;
	private JTextField txtNome;
	private JTextField txtDataInicio;
	private JTextField txtPrazo;
	private JTextField txtDataEntrega;
	
	private JTextArea txtDescricacao;
	
	private JComboBox<String> boxResponsavel;
	
	private JButton btnSalvar;
	private JButton btnSair;
	
	public TarefaFrame(JFrame pai) { //o JFrame tambem poderia ser criado como um atributo da classe
		criarTela(pai);
	}
	
	private void criarTela(JFrame pai) {
		JDialog telaTarefa = new JDialog(pai, true); //o JDialog foi a soluão para quando clicar em fechar não fechar tudo
		telaTarefa.setSize(500, 630);
		telaTarefa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		telaTarefa.setLayout(null);
		telaTarefa.setResizable(false);
		telaTarefa.setLocationRelativeTo(null); //faz referencia para a tela aparecer em algum lugar da tela, como é null, ela irá aparecer no meio
		
		Container painel = telaTarefa.getContentPane(); //criamos um container com o nome painel que recebe o getContentPane, para facilitar colocar coisas no container

		
		labelIdentificacao = new JLabel("Identificação");
		labelIdentificacao.setBounds(10, 20, 150, 30);
		txtIdentificacao = new JTextField();
		txtIdentificacao.setBounds(10, 50, 150, 30);
		txtIdentificacao.setEnabled(false);
		txtIdentificacao.setText(Utils.gerarUUID8());
		
		labelNome = new JLabel("Nome da tarefa");
		labelNome.setBounds(10, 85, 150, 30);
		txtNome = new JTextField();
		txtNome.setBounds(10, 115, 350, 30);
		
		labelDescricao = new JLabel("Descrição");
		labelDescricao.setBounds(10, 150, 150, 30);
		txtDescricacao = new JTextArea();
		txtDescricacao.setBounds(10, 180, 400, 70);
		txtDescricacao.setLineWrap(true); // Quebra automática de linha
		txtDescricacao.setWrapStyleWord(true); // Quebra em palavras inteiras, não no meio
		txtDescricacao.setBorder(UIManager.getBorder("TextField.border")); //coloca uma borda igual do JtextField nele
		
		labelResponsavel = new JLabel("Responsável");
		labelResponsavel.setBounds(10, 255, 150, 30);
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO(null);
		boxResponsavel = new JComboBox<>(funcionarioDAO.getNomesFuncionariosArray());
		boxResponsavel.setBounds(10, 285, 350, 30);

		labelDataInicio = new JLabel("Data de início");
		labelDataInicio.setBounds(10, 320, 150, 30);
		txtDataInicio = new JTextField();
		txtDataInicio.setBounds(10, 350, 150, 30);
		
		
		labelPrazo = new JLabel("Prazo (em dias)");
		labelPrazo.setBounds(10, 385, 150, 30);
		txtPrazo = new JTextField();
		txtPrazo.setBounds(10, 415, 150, 30);
		
		labelDataEntrega = new JLabel("Data de entrega");
		labelDataEntrega.setBounds(10, 445, 150, 30);
		txtDataEntrega = new JTextField();
		txtDataEntrega.setBounds(10, 475, 150, 30);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 520, 150, 40);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(180, 520, 150, 40);
		
		painel.add(labelIdentificacao);
		painel.add(txtIdentificacao);
		
		painel.add(labelNome);
		painel.add(txtNome);
		
		painel.add(labelDescricao);
		painel.add(txtDescricacao);
		
		painel.add(labelResponsavel);
		painel.add(boxResponsavel);
		
		painel.add(labelDataInicio);
		painel.add(txtDataInicio);
		
		painel.add(labelPrazo);
		painel.add(txtPrazo);
		
		painel.add(labelDataEntrega);
		painel.add(txtDataEntrega);
		
		painel.add(btnSalvar);
		painel.add(btnSair);
		
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Tarefa t = new Tarefa();
				t.setIdentificacao(txtIdentificacao.getText());
				t.setNome(txtNome.getText());
				t.setDescricao(txtDescricacao.getText());

				Funcionario responsavelSelecionado = (Funcionario) boxResponsavel.getSelectedItem();
				t.setResponsavel(responsavelSelecionado);
				
				TarefaDAO dao = new TarefaDAO(t);
				boolean sucesso = dao.gravar();
				
				if (sucesso) {
					JOptionPane.showMessageDialog(telaTarefa, "Tarefa criada com sucesso!");
					limparFormulario(); //chamando o limpar formulario se dar certo
				} else {
					JOptionPane.showMessageDialog(telaTarefa, "ocorreu um erro na gravação. \ntente novamente. \nSe o problema persistir, entre em contato com o suporte.");
				}
				
			}
		});
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(telaTarefa, "Deseja sair da criação de tarefas?", "Atenção", JOptionPane.YES_NO_OPTION);
				
				if (resposta == 0) {
					telaTarefa.dispose(); //usado só para fechar o tela funcionario do que fechar tudo
				}
	//			System.exit(JFrame.EXIT_ON_CLOSE); //essa funcao serve para encerrar o programa, no lugar do exit_on_close poderia ser o numero 0 )
				
			}
		});
		
		telaTarefa.setVisible(true);
	}
	
	
	private void limparFormulario() {
		txtIdentificacao.setText(Utils.gerarUUID8());
		txtNome.setText(null);
		txtDescricacao.setText(null);
		
	}
}
