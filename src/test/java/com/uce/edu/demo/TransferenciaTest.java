package com.uce.edu.demo;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransferenciaTest {
	/*
	 * @Autowired private ICuentaBancariaRepository bancariaRepository;
	 * 
	 * @Autowired private ITransferenciaService transferenciaService;
	 * 
	 * @Autowired private ITransferenciaRepository transferenciaRepository;
	 * 
	 * //Comprobar si se puede realizar una transferencia segun el saldo de una
	 * cuenta y el monto asignado
	 * 
	 * @Test void testMontoTransferencia(){ CuentaBancaria ctaOrigen =
	 * this.bancariaRepository.buscarPorNumero("1010"); BigDecimal monto = new
	 * BigDecimal(5); assertTrue(ctaOrigen.getSaldo().doubleValue() >
	 * monto.doubleValue()); }
	 * 
	 * //Comprobar validación de una transferencia
	 * 
	 * @Test void testInsercion() {
	 * this.transferenciaService.realizarTransferencia("12", "1010", "2020", new
	 * BigDecimal(5)); Transferencia transferenciaDB =
	 * this.transferenciaRepository.buscarPorNumero("12");
	 * 
	 * CuentaBancaria ctaOrigen = this.bancariaRepository.buscarPorNumero("1010");
	 * CuentaBancaria ctaDestino = this.bancariaRepository.buscarPorNumero("2020");
	 * 
	 * assertEquals(transferenciaDB.getCuentaOrigen().getNumero(),
	 * ctaOrigen.getNumero());
	 * assertEquals(transferenciaDB.getCuentaDestino().getNumero(),
	 * ctaDestino.getNumero()); }
	 * 
	 * @Test void testInsercionCuentasIguales() { CuentaBancaria ctaOrigen =
	 * this.bancariaRepository.buscarPorNumero("1010"); CuentaBancaria ctaDestino =
	 * this.bancariaRepository.buscarPorNumero("1010");
	 * 
	 * assertNotEquals(ctaOrigen.getNumero(), ctaDestino.getNumero());
	 * 
	 * this.transferenciaService.realizarTransferencia("649", "1010", "2020", new
	 * BigDecimal(5)); }
	 * 
	 * //Comprobar que se realizó la transferencia correctamente
	 * 
	 * @Test void testResultadoTransferencia() { CuentaBancaria ctaDestino =
	 * this.bancariaRepository.buscarPorNumero("2020"); BigDecimal saldoDestino =
	 * ctaDestino.getSaldo(); BigDecimal monto = new BigDecimal(5);
	 * this.transferenciaService.realizarTransferencia("25", "1010", "2020", monto);
	 * BigDecimal saldoFinal =
	 * this.bancariaRepository.buscarPorNumero("2020").getSaldo();
	 * 
	 * assertTrue(saldoDestino.compareTo(saldoFinal.subtract(monto))==0);
	 * 
	 * }
	 */
}