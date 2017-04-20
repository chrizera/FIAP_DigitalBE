package br.com.fiap.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.AtletaRepository;
import br.com.fiap.to.Atleta;

@ManagedBean
public class ListaAtletaBean {

	private List<Atleta> lista;
	
	private AtletaRepository repository;
	
	@PostConstruct
	private void init() {
		repository = new AtletaRepository();
		try {
			lista = repository.listar();
		}
		catch(WebServiceException e) {
			e.printStackTrace();
		}
	}

	public List<Atleta> getLista() {
		return lista;
	}

	public void setLista(List<Atleta> lista) {
		this.lista = lista;
	}
	
	
}
