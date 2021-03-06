package br.com.fiap.view;

import br.com.fiap.bo.JogoBOStub;
import br.com.fiap.bo.JogoBOStub.Cadastrar;
import br.com.fiap.bo.JogoBOStub.Jogo;

public class ConsoleView {
	
	public static void main(String args[]) {
		
		try {
			JogoBOStub stub = new JogoBOStub();
			Jogo jogo = new Jogo();
			Cadastrar params = new Cadastrar();
			
			jogo.setNome("Pokemon GO");
			jogo.setProdutora("Niantic");
			jogo.setPreco(0);
			
			params.setJogo(jogo);
			stub.cadastrar(params);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
