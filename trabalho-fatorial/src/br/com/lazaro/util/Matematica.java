package br.com.lazaro.util;

public class Matematica {
	
	public static long calculaFatorial(long numero) {
		if (numero == 0 || numero == 1) {
			return 1;
		} else {
			return numero * calculaFatorial(numero -1);
		}
	}

}
