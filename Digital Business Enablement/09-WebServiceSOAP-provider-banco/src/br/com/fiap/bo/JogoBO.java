package br.com.fiap.bo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.axis2.AxisFault;
import org.apache.axis2.engine.AxisError;

import br.com.fiap.dao.JogoDAO;
import br.com.fiap.dao.impl.JogoDAOImpl;
import br.com.fiap.entity.Jogo;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class JogoBO {
	
	private EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
	
	public void cadastrar(Jogo jogo) throws AxisFault{
		EntityManager em = fabrica.createEntityManager();
		JogoDAO dao = new JogoDAOImpl(em);
		
		dao.cadastrar(jogo);
		try {
			dao.salvar(); //commit
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new AxisFault("Cadastro nao realizado.");
		}
		finally {
			em.close();
		}
	}
	
	public Jogo buscar(int id) {
		EntityManager em = fabrica.createEntityManager();
		JogoDAO dao = new JogoDAOImpl(em);
		Jogo jogo = dao.pesquisar(id);
		em.close();
		return jogo;
	}
	
	public void atualizar(Jogo jogo) throws AxisFault {
		EntityManager em = fabrica.createEntityManager();
		JogoDAO dao = new JogoDAOImpl(em);
		
		dao.alterar(jogo);
		
		try {
			dao.salvar();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new AxisError("Erro ao atualizar.");
		}
		finally {
			em.close();
		}
	}
	
	public void remover(int codigo) throws AxisFault {
		EntityManager em = fabrica.createEntityManager();
		JogoDAO dao = new JogoDAOImpl(em);
		
		try {
			dao.remover(codigo);
			dao.salvar();

		}
		catch(Exception e) {
			e.printStackTrace();
			throw new AxisError("Erro ao remover.");
		}
		finally {
			em.close();
		}
	}
}
