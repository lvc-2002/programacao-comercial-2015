package br.com.lazaro.trabalho.util;

public class Matematica {
	
	public static int calculaAnPG(int a1, int q, int n) {
		return a1 * potencia(q, n-1);
	}
	
	private static int potencia(int base, int expoente) {
		int total = 1;
		for(int i=0; i<expoente; i++) {
			total = total * base;
		}
		return total;
	}

}
