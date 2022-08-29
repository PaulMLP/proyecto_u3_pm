package com.uce.edu.demo.cajero.service.funcional;

@FunctionalInterface
public interface IFacturaConsumer <T>{

	public void accept(T arg1);

}
