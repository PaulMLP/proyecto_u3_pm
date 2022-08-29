package com.uce.edu.demo.cajero.service.funcional;

public class ConsumoMetodosHighOrder {

	public String consumirSupplier(IFacturaSupplier<String> funcion) {
		return funcion.getNombre() + " Se proceso el dato";
	}

	public void consumirConsumer(IFacturaConsumer<Integer> funcion, Integer valor) {
		funcion.accept(valor);
	}

	public boolean consumirPredicate(IFacturaPredicate<String> funcion, String valor) {
		return funcion.evaluar(valor);
	}

	public String consumirFunction(IFacturaFunction<String, Integer> funcion, Integer valor) {
		return funcion.apply(valor);
	}
	
	public Integer consumirFunctionUnaryOperator(IFacturaFunctionUnaryOperator<Integer> funcion, Integer valor) {
		return funcion.apply(valor);
	}

}
