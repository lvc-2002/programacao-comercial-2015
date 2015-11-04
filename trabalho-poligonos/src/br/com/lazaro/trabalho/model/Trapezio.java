package br.com.lazaro.trabalho.model;

public class Trapezio extends Poligono {
	
	private double baseMenor;
	private double baseMaior;
	
	public Trapezio(double baseMenor, double baseMaior, double altura) {
		super(altura);
		this.baseMenor = baseMenor;
		this.baseMaior = baseMaior;
	}

	public double getBaseMaior() {
		return baseMaior;
	}

	public void setBaseMaior(double baseMaior) {
		this.baseMaior = baseMaior;
	}

	public double getBaseMenor() {
		return baseMenor;
	}

	public void setBaseMenor(double baseMenor) {
		this.baseMenor = baseMenor;
	}

	@Override
	public double calculaArea() {
		return (altura * (baseMaior + baseMenor)) / 2;
	}
	
}
