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

		// Where
		LOG.info("********** JOIN WHERE **********");
		List<Hotel> listaHoteles = this.hotelService.buscarHotelWhereJoin("Matrimonial");
		for (Hotel h : listaHoteles) {
			LOG.info(h);
		}

		// Inner Join Eager/ Lazy
		LOG.info("********** INNER JOIN EAGER/LAZY **********");
		List<Hotel> listaHoteles2 = this.hotelService.buscarHotelFetchJoin("Familiar");
		for (Hotel h : listaHoteles2) {
			LOG.info(h);
			LOG.info("Habitaciones: "+h.getHabitaciones());
		}

	}
}
