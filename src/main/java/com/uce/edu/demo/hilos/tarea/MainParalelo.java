package com.uce.edu.demo.hilos.tarea;

import java.util.Arrays;

public class MainParalelo {

	public static void main(String[] args) {
		long tiempoInicial = System.currentTimeMillis();

		Cocinero cocinero1 = new Cocinero("Paul", Arrays.asList("Plato1", "Plato2", "Plato3", "Plato4", "Plato5"));
		Cocinero cocinero2 = new Cocinero("Juan", Arrays.asList("Plato6", "Plato5", "Plato6", "Plato7"));
		Cocinero cocinero3 = new Cocinero("Pedro", Arrays.asList("Plato8", "Plato9", "Plato10", "Plato11", "Plato12"));
		Cocinero cocinero4 = new Cocinero("Ana", Arrays.asList("Plato13", "Plato14", "Plato15", "Plato16", "Plato17"));
		Cocinero cocinero5 = new Cocinero("Maria", Arrays.asList("Plato18", "Plato19", "Plato20", "Plato21"));

		GCocinero gestorCocinero = new GCocinero(cocinero1);
		gestorCocinero.start();

		GCocinero gestorCocinero2 = new GCocinero(cocinero2);
		gestorCocinero2.start();

		GCocinero gestorCocinero3 = new GCocinero(cocinero3);
		gestorCocinero3.start();
		
		GCocinero gestorCocinero4 = new GCocinero(cocinero4);
		gestorCocinero4.start();

		GCocinero gestorCocinero5 = new GCocinero(cocinero5);
		gestorCocinero5.start();

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println(tiempoTranscurrido + "seg");
	}

}
