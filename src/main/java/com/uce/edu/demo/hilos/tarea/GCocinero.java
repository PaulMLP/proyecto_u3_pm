package com.uce.edu.demo.hilos.tarea;

import java.util.concurrent.TimeUnit;

public class GCocinero extends Thread {

	Cocinero cocinero;

	public GCocinero(Cocinero cocinero) {
		this.cocinero = cocinero;
	}

	@Override
	public void run() {
		this.procesar(this.cocinero);
	}

	public void procesar(Cocinero cocinero) {
		long tiempoInicial = System.currentTimeMillis();
		System.out.println("Nombre Hilo Procesar: " + Thread.currentThread().getName() + " ->" + cocinero.getNombre());
		System.out.println("Pedidos tomados por Cocinero: " + cocinero.getNombre());
		for (String plato : cocinero.getPlatos()) {
			this.cocinarPlato(plato);
		}
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		System.out.println("\nTerminó: " + cocinero.getNombre() + " en " + tiempoTranscurrido + "seg");
	}

	public void cocinarPlato(String plato) {
		System.out.print("Cocinando: " + plato+" ");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
