package br.dev.guilherme.tarefas.utils;

import java.util.UUID;

public class Utils {
	
	public static String gerarUUID8() {//gera um numero aleatorio
		UUID uuid = UUID.randomUUID(); //criando o uuid
		String uuid8 = uuid.toString().substring(0, 8); //pegando só os 8 primeiros caracteres do UUID
		return uuid8;
	}

}
