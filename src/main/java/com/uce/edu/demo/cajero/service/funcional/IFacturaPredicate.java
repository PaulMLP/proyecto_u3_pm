package com.uce.edu.demo.cajero.service.funcional;

@FunctionalInterface
public interface IFacturaPredicate <T> {
	public boolean evaluar(T arg1);

}
