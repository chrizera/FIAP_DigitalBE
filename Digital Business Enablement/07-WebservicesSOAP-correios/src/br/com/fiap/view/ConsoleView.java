package br.com.fiap.view;

import javax.swing.JOptionPane;

import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;

public class ConsoleView {
	public static void main(String[] args) {
		try {
			CalcPrecoPrazoWSStub stub = new CalcPrecoPrazoWSStub();
			CalcPrazo prazo = new CalcPrazo();
			//Parametros pra enviar ao webservice
			prazo.setNCdServico("40010"); //Sedex
			prazo.setSCepDestino(JOptionPane.showInputDialog("CEP de destino: "));
			prazo.setSCepOrigem(JOptionPane.showInputDialog("CEP de origem: "));
			
			//Chama o webservice
			CalcPrazoResponse response = stub.calcPrazo(prazo);
			
			System.out.println("Prazo: " + response.getCalcPrazoResult().getServicos().getCServico()[0].getPrazoEntrega());
			
			System.exit(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
