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

		// Inner
		LOG.info("********** INNER JOIN **********");
		List<Factura> listaFacturas = this.facturaService.buscarFacturaInnerJoin(2);
		for (Factura f : listaFacturas) {
			LOG.info(f);
		}

		LOG.info("********** INNER JOIN **********");
		List<Factura> listaFacturas2 = this.facturaService.buscarFacturaInnerJoin(2);
		for (Factura f : listaFacturas2) {
			LOG.info(f);
		}

		// Right
		LOG.info("********** RIGHT JOIN **********");
		List<Factura> listaFacturas3 = this.facturaService.buscarFacturaOuterRightJoin(2);
		for (Factura f : listaFacturas3) {
			LOG.info(f);
		}

		// Left
		LOG.info("********** LEFT JOIN **********");
		List<Factura> listaFacturas4 = this.facturaService.buscarFacturaOuterLeftJoin(2);
		for (Factura f : listaFacturas4) {
			LOG.info(f);
		}

		LOG.info("********** LEFT JOIN **********");
		List<Factura> listaFacturas5 = this.facturaService.buscarFacturaOuterLeftJoin();
		for (Factura f : listaFacturas5) {
			LOG.info(f);
		}

	}
}
