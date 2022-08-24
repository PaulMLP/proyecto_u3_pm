package com.uce.edu.demo.cajero.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.cajero.repository.IClienteRepository;
import com.uce.edu.demo.cajero.repository.IFacturaRepository;
import com.uce.edu.demo.cajero.repository.IProductoRepository;
import com.uce.edu.demo.cajero.repository.modelo.Cliente;
import com.uce.edu.demo.cajero.repository.modelo.DetalleFactura;
import com.uce.edu.demo.cajero.repository.modelo.Factura;
import com.uce.edu.demo.cajero.repository.modelo.Producto;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository facturaRepository;

	@Autowired
	private IClienteRepository clienteRepository;

	@Autowired
	private IProductoRepository productoRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public BigDecimal procesarFactura(String cedulaCliente, String numeroFactura, List<String> codigos) {
		Cliente cliente = this.clienteRepository.buscar(cedulaCliente);

		Factura factura = new Factura();
		factura.setNumero(numeroFactura);
		factura.setCliente(cliente);
		factura.setFecha(LocalDateTime.now());

		BigDecimal monto = BigDecimal.ZERO;

		DetalleFactura detalle = new DetalleFactura();

		List<DetalleFactura> listaDetalles = new ArrayList<DetalleFactura>();
		List<Producto> listaProductos = new ArrayList<Producto>();

		for (String c : codigos) {
			Producto p = this.productoRepository.buscar(c);
			detalle.setProducto(p);
			detalle.setCantidad(1);
			detalle.setSubtotal(p.getPrecio());
			monto = monto.add(p.getPrecio());
			p.setCantidad(p.getCantidad()-1);
			this.productoRepository.actualizar(p);
			listaDetalles.add(detalle);
			listaProductos.add(p);
		}

		factura.setDetalles(listaDetalles);
		factura.setMonto(monto);

		this.facturaRepository.insertar(factura);
		return monto;
	}

}
