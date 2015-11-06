package br.com.lazaro.trabalho.util;

public class Fisica {
	
	public static double velocidadeFinal(double velocidadeInicial, double deslocamentoTotal, double aceleracao) {
		return Math.sqrt((Math.pow(velocidadeInicial, 2) + 2 * aceleracao * deslocamentoTotal));
	}

}
