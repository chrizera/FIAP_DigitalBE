package br.com.fiap.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AtletaDAO;
import br.com.fiap.dao.impl.AtletaDAOImpl;
import br.com.fiap.entity.Atleta;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class AtletaBO {

	private EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private AtletaDAO dao = new AtletaDAOImpl(em);
	
	public Atleta buscar(int codigo) {
		return dao.pesquisar(codigo);
	}
	
	public void cadastrar(Atleta atleta) {
		dao.cadastrar(atleta);
		try {
			dao.salvar();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	
	public void atualizar(Atleta atleta) {
		dao.alterar(atleta);
		try {
			dao.salvar();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	
	public void remover(int codigo) {
		try {
			dao.remover(codigo);
			dao.salvar();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	
	public List<Atleta> listar() {
		return dao.listar();
	}
	
	
}
