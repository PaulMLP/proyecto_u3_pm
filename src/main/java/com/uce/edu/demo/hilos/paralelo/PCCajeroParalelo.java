package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class PCCajeroParalelo extends Thread {

	CajeroParalelo cajero;
	
	public PCCajeroParalelo(CajeroParalelo cajero) {
		this.cajero = cajero;
	}
	
	// Disparar el metodo a paralelizar
	@Override
	public void run() {
		this.procesar(this.cajero);
	}

	public void procesar(CajeroParalelo cajero) {
		long tiempoInicial = System.currentTimeMillis();
		System.out.println("Nombre Hilo Procesar: " + Thread.currentThread().getName()+" ->"+cajero.getNombre());
		System.out.println("Procesando cajero: " + cajero.getNombre());
		for (String cliente : cajero.getClientes()) {
			this.atenderCliente(cliente);
		}
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		System.out.println("terminó: "+cajero.getNombre()+" en "+tiempoTranscurrido + "seg");
	}

	public void atenderCliente(String cliente) {
		System.out.println("Atendiendo a: " + cliente);
		// Demorar metodo 5s
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
