package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {

	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

		// CONSUMER
		// Clases
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer");

		// Lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");
		
		// PREDICATE
		// Clases
		// Lambdas

		// FUNCTION
		// Clases
		// Lambdas

		// UNARY OPERATOR (Function)
		// Clases
		// Lambdas
	}

}
