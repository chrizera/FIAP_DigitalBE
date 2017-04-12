package br.com.fiap.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ImcBean {

	private float peso;
	private float altura;
	private float imc;
	
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	public float getImc() {
		return imc;
	}
	public void setImc(float imc) {
		this.imc = imc;
	}
	public void calcular() {
		imc = peso/(altura*altura);
	}
	
}