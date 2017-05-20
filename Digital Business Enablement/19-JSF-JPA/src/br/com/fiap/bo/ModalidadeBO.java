package br.com.fiap.bo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.AtletaDAO;
import br.com.fiap.dao.ModalidadeDAO;
import br.com.fiap.dao.impl.AtletaDAOImpl;
import br.com.fiap.dao.impl.ModalidadeDAOImpl;
import br.com.fiap.entity.Atleta;
import br.com.fiap.entity.Modalidade;
import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class ModalidadeBO {

	private EntityManagerFactory fabrica = 
			EntityManagerFactorySingleton.getInstance();
	
	public void cadastrar(Modalidade atleta) throws DBException {
		EntityManager em = fabrica.createEntityManager();
		ModalidadeDAO dao = new ModalidadeDAOImpl(em);
		dao.cadastrar(atleta);
		dao.salvar();
		em.close();
	}
	
	public void atualizar(Modalidade atleta) throws DBException{
		EntityManager em = fabrica.createEntityManager();
		ModalidadeDAO dao = new ModalidadeDAOImpl(em);
		dao.alterar(atleta);
		dao.salvar();
		em.close();
	}
	
	public void remover(int codigo) throws DBException, IdNotFoundException{
		EntityManager em = fabrica.createEntityManager();
		ModalidadeDAO dao = new ModalidadeDAOImpl(em);
		dao.remover(codigo);
		dao.salvar();
		em.close();
	}
	
	public Modalidade buscar(int codigo){
		EntityManager em = fabrica.createEntityManager();
		ModalidadeDAO dao = new ModalidadeDAOImpl(em);
		Modalidade atleta = dao.pesquisar(codigo);
		em.close();
		return atleta;
	}
	
	public List<Modalidade> listar(){
		EntityManager em = fabrica.createEntityManager();
		ModalidadeDAO dao = new ModalidadeDAOImpl(em);
		List<Modalidade> lista = dao.listar();
		em.close();
		return lista;
	}
	
}
