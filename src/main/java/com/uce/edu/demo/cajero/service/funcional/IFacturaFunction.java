package com.uce.edu.demo.cajero.service.funcional;

@FunctionalInterface
public interface IFacturaFunction<R, T> {
	public R apply(T arg1);

}
