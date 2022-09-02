package com.uce.edu.demo.hilos.tarea;

import java.util.List;

public class Cocinero {

	private String nombre;
	private List<String> platos;

	public Cocinero(String nombre, List<String> platos) {
		this.platos = platos;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Cocinero [nombre=" + nombre + ", platos=" + platos + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getPlatos() {
		return platos;
	}

	public void setPlatos(List<String> platos) {
		this.platos = platos;
	}

}
