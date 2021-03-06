package br.com.fiap.view;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.AtletaRepository;
import br.com.fiap.to.Atleta;

public class CadastrarTeste {

	public static void main(String[] args) {
		AtletaRepository repository = new AtletaRepository();
		
		Atleta atleta = new Atleta();
		atleta.setModalidade("Corrida");
		atleta.setNome("Aemos");
		atleta.setRanking(1);
		
		try {
			repository.cadastrar(atleta);
			System.out.println("Cadastro feito");
		}
		catch(WebServiceException e) {
			e.printStackTrace();
		}
	}

}
