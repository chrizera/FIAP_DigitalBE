package br.com.fiap.dao.impl;

import br.com.fiap.entity.Modalidade;
import javax.persistence.EntityManager;
import br.com.fiap.dao.ModalidadeDAO;

public class ModalidadeDAOImpl extends GenericDAOImpl<Modalidade, Integer> implements ModalidadeDAO{

	public ModalidadeDAOImpl(EntityManager em) {
		super(em);
	}

}
