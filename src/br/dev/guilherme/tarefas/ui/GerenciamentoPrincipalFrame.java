package br.dev.guilherme.tarefas.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GerenciamentoPrincipalFrame {
	
	private JLabel labelTitulo;
	private JButton btnFuncionario;
	private JButton btnTarefas;
	
	public GerenciamentoPrincipalFrame(){
		criarTela();
	}
	
	
	private void criarTela() {
		JFrame telaPrincipal = new JFrame(); //o JDialog foi a soluão para quando clicar em fechar não fechar tudo
		telaPrincipal.setSize(500, 210);
		telaPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		telaPrincipal.setLayout(null);
		telaPrincipal.setResizable(false);
		telaPrincipal.setLocationRelativeTo(null); //faz referencia para a tela aparecer em algum lugar da tela, como é null, ela irá aparecer no meio
		
		Container painel = telaPrincipal.getContentPane();
		
		labelTitulo = new JLabel("Gerenciamento Principal");
		labelTitulo.setBounds(50, 20, 400, 40);
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 32));
		labelTitulo.setForeground(Color.RED);
		
		
		btnFuncionario = new JButton("Funcionários");
		btnFuncionario.setBounds(10, 90, 200, 50);
		btnFuncionario.setFont(new Font("Arial", Font.BOLD, 16));
		
		btnTarefas = new JButton("Tarefas");
		btnTarefas.setBounds(250, 90, 200, 50);
		btnTarefas.setFont(new Font("Arial", Font.BOLD, 16));
		
		
		//Painel do conteudo
		painel.add(btnFuncionario);
		painel.add(labelTitulo);
		painel.add(btnTarefas);
		
		
		btnFuncionario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FuncionarioListaFrame(telaPrincipal);
				
			}
		});
		
		btnTarefas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TarefaListaFrame(telaPrincipal);
				
			}
		});
		
		telaPrincipal.setVisible(true);
	}

	
}
