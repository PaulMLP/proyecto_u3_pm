package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.cajero.repository.modelo.Factura;
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

		// Where
		LOG.info("********** JOIN WHERE **********");
		List<Factura> lista = this.facturaService.buscarFacturaWhereJoin(2);
		for (Factura f : lista) {
			LOG.info(f);
		}

		// Inner Join Eager/ Lazy
		LOG.info("********** INNER JOIN EAGER/LAZY **********");
		List<Factura> lista2 = this.facturaService.buscarFacturaFetchJoin(2);
		for (Factura f : lista2) {
			LOG.info(f);
			LOG.info("Facturas: " + f.getDetalles());
		}

	}
}
