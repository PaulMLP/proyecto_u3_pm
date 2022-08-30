package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		long tiempoInicial = System.currentTimeMillis();
		
		Cajero cajero1 = new Cajero("Paul", Arrays.asList("Pepito", "Jaimito", "Juan"));
		Cajero cajero2 = new Cajero("Paul", Arrays.asList("Pepito", "Jaimito", "Juan"));
		Cajero cajero3 = new Cajero("Paul", Arrays.asList("Pepito", "Jaimito", "Juan"));
		
		
		PCCajero gestorAtencion = new PCCajero();
		gestorAtencion.procesar(cajero1);
		gestorAtencion.procesar(cajero2);
		gestorAtencion.procesar(cajero3);
		
		long tiempoFinal = System.currentTimeMillis();
		
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) /1000;
		
		System.out.println(tiempoTranscurrido + "seg");
	}

}
