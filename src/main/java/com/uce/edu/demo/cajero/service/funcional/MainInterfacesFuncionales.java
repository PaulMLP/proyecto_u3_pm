package com.uce.edu.demo.cajero.service.funcional;

import java.util.Random;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {
	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] lista = { "Ana", "Juan", "Pedro", "Luis", "Paul", "Jorge", "Diana", "Carmen", "Rosa", "Maria", "Juana",
				"Isabel", "Marco" };

		Stream<String> streamLista = Stream.of(lista);

		// SUPPLIER
		Stream.generate(new Random()::nextInt).limit(10).forEach(System.out::println);

		// FUNCTION
		Stream<String> listaMinuscula = streamLista.map(palabra -> {
			String minuscula = palabra.toLowerCase();
			return minuscula;
		});

		// CONSUMER
		listaMinuscula.forEach(minuscula -> {
			LOG.info("Nombre: " + minuscula);
		});

		Stream<String> streamLista2 = Stream.of(lista);

		// PREDICATE
		streamLista2.filter(nombre -> nombre.startsWith("J")).forEach(System.out::println);
	}

}
