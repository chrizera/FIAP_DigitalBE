package com.fiap.loja;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fiap.loja.bo.EstoqueBO;
import com.fiap.loja.config.PropertySingleton;
import com.fiap.loja.to.ProdutoTO;

public class TerminalConsulta {
	
	private static Logger log = LoggerFactory.getLogger(TerminalConsulta.class);
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		log.warn("Inicio da aplicacao");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		/*System.out.println("FIAP            " +
					sdf.format(Calendar.getInstance().getTime()));
		System.out.println("********************************");*/
		
		//Ler a configuracao para recuperar o nome da loja
		String loja = PropertySingleton.getInstance().getProperty("nome");
		System.out.println(loja);
		
		System.out.print("Digite o c�digo: ");
		int codigo = scanner.nextInt();
		
		EstoqueBO bo = new EstoqueBO();
		ProdutoTO produto = bo.consultarProduto(codigo);
		log.debug("Produto pesquisado - codigo: " + codigo);
			
		if(produto != null) {
			System.out.println(produto.getDescricao());
			System.out.println(produto.getQuantidade());
			//Formatar o valor monetario
			DecimalFormat format = new DecimalFormat("R$ #,###.00");
			System.out.println(format.format(produto.getPreco()));
		}
		else {
			log.error("Codigo de produto inexistente");
			System.out.println("Produto nao cadastrado");
		}
		
		/*(switch (codigo) {
		case 401:
			System.out.println("Camiseta Masculina Manga Curta Branca");
			break;
		case 402:
			System.out.println("Camiseta Feminina Manga Longa Rosa");
			break;
		default:
			System.out.println("Produto n�o cadastrado!");
			break;
		}*/
		
		scanner.close();
		log.warn("Fim da aplicacao");
	}
	
}
