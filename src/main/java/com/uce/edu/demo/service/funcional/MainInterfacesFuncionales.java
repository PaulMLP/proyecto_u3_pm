package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {

	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();
		// SUPPLIER
		// Clases
		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
		LOG.info("Supplier Clase: " + supplier.getNombre());
		IPersonaSupplier<String> supplierTE = new IPersonaSupplierTEImpl();
		LOG.info("Supplier Clase: " + supplierTE.getNombre());

		// Lambdas
		IPersonaSupplier<String> supplierLambda = () -> "Paúl2";
		LOG.info("Supplier Lambda: " + supplierLambda.getNombre());
		IPersonaSupplier<String> supplierLambdaTE = () -> "Leonardo";
		LOG.info("Supplier Lambda: " + supplierLambdaTE.getNombre());

		// Metodos High Order
		String valorHO = metodosHO.consumirSupplier(() -> "Hola Mundo");
		LOG.info("HO Supplier: " + valorHO);

		// CONSUMER
		// Clases
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer");

		// Lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");

		// Metodos High Order
		metodosHO.consumirConsumer(valor -> System.out.println(valor), 2);

		// PREDICATE
		// Clases
		// Lambdas
		IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("ñ");
		LOG.info("Predicate Lambdas: " + predicateLambda.evaluar("Paul"));

		// Metodos High Order
		boolean respuesta = metodosHO.consumirPredicate(cadena -> cadena.contains("ñ"), "Paul");
		LOG.info("HO Predicate: " + respuesta);

		// FUNCTION
		// Clases
		// Lambdas
		IPersonaFunction<Integer, String> functionLambda = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor - 2;
			return valorFinal;
		};
		LOG.info("Function Lambdas: " + functionLambda.apply("7"));

		// Metodos High Order
		String valorFin = metodosHO.consumirFunction(valor -> {
			String retorno = valor.toString()+"A";
			return retorno;
		}, 1);
		LOG.info("HO Function: " + valorFin);

		
		// UNARY OPERATOR (Function)
		// Clases
		// Lambdas
		IPersonaUnaryOperator<String> unaryLambda = cade -> {
			String valorFinal = cade.concat("s");
			return valorFinal;
		};
		LOG.info("Unary Operator Lambdas: " + unaryLambda.apply("palabra"));

	}

}
