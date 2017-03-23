package br.com.fiap.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class ClienteBO {
	
	public void cadastrarCliente(Cliente cliente) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		ClienteDAO dao = new ClienteDAOImpl(em);
		
		dao.cadastrar(cliente);
		
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
	
	public Cliente buscar(int id) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		ClienteDAO dao = new ClienteDAOImpl(em);
		
		Cliente cliente = dao.pesquisar(id);
		em.close();
		
		return cliente;
	}
	
	public List<Cliente> listar() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		ClienteDAO dao = new ClienteDAOImpl(em);
		
		List<Cliente> lista = dao.listar();
		
		em.close();
		
		return lista;
		
	}
}