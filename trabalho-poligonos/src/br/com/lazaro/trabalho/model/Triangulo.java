package br.com.lazaro.trabalho.model;

public class Triangulo extends Poligono {
	
	public Triangulo(double base, double altura) {
		super(base, altura);
	}

	@Override
	public double calculaArea() {
		return super.calculaArea() / 2;
	}
}
