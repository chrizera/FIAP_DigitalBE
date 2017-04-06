package br.com.fiap.view;

import java.util.List;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.AtletaRepository;
import br.com.fiap.to.Atleta;

public class BuscaTeste {

	public static void main(String[] args) {
		AtletaRepository repository = new AtletaRepository();
		
		try {
			List<Atleta> atletas = repository.listar();
			
			for (Atleta atleta : atletas) {
				System.out.println(atleta.getNome());
			}
			
			Atleta atleta = repository.buscar(1);
			System.out.println("\n---Buscar: " + atleta.getNome());
		}
		catch(WebServiceException e) {
			e.printStackTrace();
		}
	}

}
