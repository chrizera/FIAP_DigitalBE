package com.fiap;

import com.fiap.loja.bo.EstoqueBOCallbackHandler;
import com.fiap.loja.bo.EstoqueBOStub;
import com.fiap.loja.bo.EstoqueBOStub.ConsultarProduto;
import com.fiap.loja.bo.EstoqueBOStub.ConsultarProdutoResponse;
import com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;

public class TerminalBuscaPreco {

	public static void main(String[] args) {
		try{
			EstoqueBOStub stub = new EstoqueBOStub();
			ConsultarProduto consultarProduto = new ConsultarProduto();
			consultarProduto.setCodigo(401);
			
			//Chamar o webservice
			ConsultarProdutoResponse response = stub.consultarProduto(consultarProduto);
			//Recupera a resposta
			ProdutoTO produto = response.get_return();
			
			System.out.println("Descricao: " + produto.getDescricao() + "\nQuantidade em estoque: " + produto.getQuantidade() + "\nPreco: " + produto.getPreco());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
