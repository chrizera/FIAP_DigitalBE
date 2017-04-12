package br.com.fiap.beans;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.AtletaRepository;
import br.com.fiap.to.Atleta;

@ManagedBean
public class AtletaBean {
	
	private Atleta atleta;
	private AtletaRepository repository;
	
	@PostConstruct
	public void init() {
		atleta = new Atleta();
		repository = new AtletaRepository();
	}

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}
	
	public void cadastrar(){		
		try {
			repository.cadastrar(atleta);
		}
		catch(WebServiceException e) {
			e.printStackTrace();
		}
	}
	
}
