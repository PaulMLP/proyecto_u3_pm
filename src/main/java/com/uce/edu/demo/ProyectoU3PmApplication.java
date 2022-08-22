package com.uce.edu.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.cajero.service.IFacturaService;

@SpringBootApplication
public class ProyectoU3PmApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU3PmApplication.class);

	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3PmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<String> listaCodigos = new ArrayList<String>();
		listaCodigos.add("1234");
		listaCodigos.add("1122");
		listaCodigos.add("4321");
		listaCodigos.add("1111");
		
		LOG.info("Se compra los productos");
		this.facturaService.compraProductos("1728189521", "1234", listaCodigos);
	}
}
