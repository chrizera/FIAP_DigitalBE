package br.com.fiap.view;

import br.com.fiap.bo.DisciplinaBOStub;
import br.com.fiap.bo.DisciplinaBOStub.CalcularPs;
import br.com.fiap.bo.DisciplinaBOStub.CalcularPsResponse;

public class ConsultarPS {

	public static void main(String[] args) throws Exception{
		//Chamar o servico de calcular nota de ps necessaria
		DisciplinaBOStub bo = new DisciplinaBOStub();
		CalcularPs valores = new CalcularPs();
		
		valores.setAm(5);
		valores.setNac(6);
		
		CalcularPsResponse response = bo.calcularPs(valores);
		double ps = response.get_return();
		
		System.out.println("Nota necessaria na PS: " + ps);

	}

}
