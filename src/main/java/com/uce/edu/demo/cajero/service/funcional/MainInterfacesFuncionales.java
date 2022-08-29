package com.uce.edu.demo.cajero.service.funcional;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {
	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();
		// SUPPLIER
		// Lambdas
		IFacturaSupplier<String> supplierLambda = () -> "Paúl";
		LOG.info("Supplier Lambda: " + supplierLambda.getNombre());

		// Metodos High Order
		String valorHO = metodosHO.consumirSupplier(() -> "Hola Mundo");
		LOG.info("HO Supplier: " + valorHO);

		// CONSUMER
		// Lambdas
		IFacturaConsumer<String> consumerLambda = cadena -> LOG.info(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");

		// Metodos High Order
		metodosHO.consumirConsumer(valor -> System.out.println(valor), 2);

		// PREDICATE
		// Lambdas
		IFacturaPredicate<String> predicateLambda = cadena -> cadena.contains("ñ");
		LOG.info("Predicate Lambdas: " + predicateLambda.evaluar("Paul"));

		// Metodos High Order
		boolean respuesta = metodosHO.consumirPredicate(cadena -> cadena.contains("ñ"), "Paul");
		LOG.info("HO Predicate: " + respuesta);

		// FUNCTION
		// Lambdas
		IFacturaFunction<Integer, String> functionLambda = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor - 2;
			return valorFinal;
		};
		LOG.info("Function Lambdas: " + functionLambda.apply("100"));

		// Metodos High Order
		String valorFin = metodosHO.consumirFunction(valor -> {
			String retorno = valor.toString() + "Cadena Aumentada";
			return retorno;
		}, 1);
		LOG.info("HO Function: " + valorFin);

		// UNARY OPERATOR (Function)
		// Lambdas
		IFacturaFunctionUnaryOperator<String> unaryLambda = cade -> {
			String valorFinal = cade.concat("s");
			return valorFinal;
		};
		LOG.info("Unary Operator Lambdas: " + unaryLambda.apply("palabra"));

		// Metodos High Order
		metodosHO.consumirFunctionUnaryOperator(valor -> {
			Integer retorno = valor * 100;
			return retorno;
		}, 1);
		LOG.info("HO Function: " + valorFin);

	}

}
