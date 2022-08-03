package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3PmApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU3PmApplication.class);

	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3PmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Inner
		LOG.info("********** INNER JOIN **********");
		List<Hotel> listaHoteles = this.hotelService.buscarHotelInnerJoin("Familiar");
		for (Hotel h : listaHoteles) {
			LOG.info(h);
		}
		
		LOG.info("********** INNER JOIN **********");
		List<Hotel> listaHoteles2 = this.hotelService.buscarHotelInnerJoin();
		for (Hotel h : listaHoteles2) {
			LOG.info(h);
		}
		
		// Right
		LOG.info("********** RIGHT JOIN **********");
		List<Hotel> listaHotelesRight = this.hotelService.buscarHotelOuterRightJoin("Familiar");
		for (Hotel h : listaHotelesRight) {
			LOG.info(h);
		}

		// Left
		LOG.info("********** LEFT JOIN **********");
		List<Hotel> listaHotelesLeft = this.hotelService.buscarHotelOuterLeftJoin("Familiar");
		for (Hotel h : listaHotelesLeft) {
			LOG.info(h);
		}
		
		LOG.info("********** LEFT JOIN **********");
		List<Hotel> listaHotelesLeft2 = this.hotelService.buscarHotelOuterLeftJoin();
		for (Hotel h : listaHotelesLeft2) {
			LOG.info(h);
		}
	}
}
