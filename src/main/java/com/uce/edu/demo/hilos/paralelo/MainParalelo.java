package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

public class MainParalelo {
	public static void main(String[] args) {

		long tiempoInicial = System.currentTimeMillis();

		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
		CajeroParalelo cajero1 = new CajeroParalelo("Paul", Arrays.asList("Pepito1", "Jaimito1", "Juan","Daniel"));
		CajeroParalelo cajero2 = new CajeroParalelo("Juan", Arrays.asList("Pepito2", "Jaimito2", "Juan2"));
		CajeroParalelo cajero3 = new CajeroParalelo("Pedro", Arrays.asList("Pepito3", "Jaimito3"));

		PCCajeroParalelo gestorAtencion = new PCCajeroParalelo(cajero1);
		gestorAtencion.start();
		
		PCCajeroParalelo gestorAtencion2 = new PCCajeroParalelo(cajero2);
		gestorAtencion2.start();
		
		PCCajeroParalelo gestorAtencion3 = new PCCajeroParalelo(cajero3);
		gestorAtencion3.start();

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println(tiempoTranscurrido + "seg");
	}
}
