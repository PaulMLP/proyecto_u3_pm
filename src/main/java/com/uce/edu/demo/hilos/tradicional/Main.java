package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		long tiempoInicial = System.currentTimeMillis();
		
		System.out.println("Nombre Hilo: "+Thread.currentThread().getName());
		Cajero cajero1 = new Cajero("Jorge", Arrays.asList("Pepito", "Jaimito", "Juan"));
		Cajero cajero2 = new Cajero("Luis", Arrays.asList("Pepito", "Jaimito", "Juan"));
		Cajero cajero3 = new Cajero("Paul", Arrays.asList("Pepito", "Jaimito", "Juan"));
		
		PCCajero gestorAtencion = new PCCajero();
		gestorAtencion.procesar(cajero1);
		PCCajero gestorAtencion2 = new PCCajero();
		gestorAtencion2.procesar(cajero2);
		PCCajero gestorAtencion3 = new PCCajero();
		gestorAtencion3.procesar(cajero3);
		
		long tiempoFinal = System.currentTimeMillis();
		
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) /1000;
		
		System.out.println(tiempoTranscurrido + "seg");
	}

}
