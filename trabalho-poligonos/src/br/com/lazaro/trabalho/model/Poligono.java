package br.com.lazaro.trabalho.model;

public class Poligono {
	
	protected double base;
	protected double altura;
	
	public Poligono(double altura) {
		this.altura = altura;
	}
	
	public Poligono(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}
	
	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double calculaArea() {
		return base * altura;
	}

}
