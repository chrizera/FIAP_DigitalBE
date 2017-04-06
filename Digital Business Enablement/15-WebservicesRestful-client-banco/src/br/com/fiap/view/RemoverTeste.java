package br.com.fiap.view;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.AtletaRepository;

public class RemoverTeste {

	public static void main(String[] args) {

		AtletaRepository repository = new AtletaRepository();
		
		try {
			repository.remover(2);
			System.out.println("Removido");
		}
		catch(WebServiceException e) {
			e.printStackTrace();
		}
		
	}

}
