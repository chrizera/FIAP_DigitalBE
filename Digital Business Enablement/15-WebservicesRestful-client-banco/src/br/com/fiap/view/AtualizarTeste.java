package br.com.fiap.view;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.AtletaRepository;
import br.com.fiap.to.Atleta;

class AtualizarTeste {

	public static void main(String[] args) {
		AtletaRepository repository = new AtletaRepository();
		
		try {
			Atleta atleta = repository.buscar(1);
			atleta.setNome("Marmoto");
			repository.atualizar(atleta);
			System.out.println("Atualizado");
		}
		catch(WebServiceException e) {
			e.printStackTrace();
		}
	}

}
