package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.JogoDAO;
import br.com.fiap.entity.Jogo;

public class JogoDAOImpl extends GenericDAOImpl<Jogo, Integer> implements JogoDAO{

	public JogoDAOImpl(EntityManager em) {
		super(em);
		
	}

}
