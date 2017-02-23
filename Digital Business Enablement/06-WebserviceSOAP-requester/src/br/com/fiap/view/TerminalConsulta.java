package br.com.fiap.view;

import br.com.fiap.bo.DisciplinaBOStub;
import br.com.fiap.bo.DisciplinaBOStub.CalcularMedia;
import br.com.fiap.bo.DisciplinaBOStub.CalcularMediaResponse;

public class TerminalConsulta {

	public static void main(String[] args) {
		try {
			//Chamar o webservice
			DisciplinaBOStub bo = new DisciplinaBOStub();
			CalcularMedia valores = new CalcularMedia();
			
			//Valores para o webservice
			valores.setAm(10);
			valores.setNac(10);
			valores.setPs(5);
			
			//Chamar o webservice
			CalcularMediaResponse response =  bo.calcularMedia(valores);
			//Recupera o retorno do webservice
			double media = response.get_return();
			
			System.out.println("Media: " + media);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
