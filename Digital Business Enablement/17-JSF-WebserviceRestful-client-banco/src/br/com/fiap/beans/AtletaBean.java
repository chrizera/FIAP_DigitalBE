package br.com.fiap.beans;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

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
		FacesMessage msg;
		try {
			repository.cadastrar(atleta);
			msg = new FacesMessage("Atleta cadastrado");
		}
		catch(WebServiceException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
}
