package com.uce.edu.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uce.edu.demo.banco.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.banco.repository.modelo.CuentaBancaria;


@SpringBootTest
class CuentaBancariaTest {

	@Autowired
	private ICuentaBancariaRepository bancariaRepository;

	private static Logger LOG = Logger.getLogger(ICuentaBancariaRepository.class);

	//Comprobar que una cuenta bancaria exista en la base de datos
	@Test
	void test() throws SQLException {
		CuentaBancaria cuenta = null;
		try {
			cuenta = this.bancariaRepository.buscarPorNumero("1010");
		} catch (Exception e) {
			LOG.error(e.getMessage());
			LOG.info("No existe la cuenta");
		}
		assertNotNull(cuenta);
	}

}
