package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IHotelRepository;
import com.uce.edu.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private IHotelRepository hotelRepository;

	@Override
	public void insertar(Hotel hotel) {
		this.hotelRepository.insertar(hotel);
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		return this.hotelRepository.buscarHotelInnerJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		return this.hotelRepository.buscarHotelInnerJoin();
	}

	@Override
	public List<Hotel> buscarHotelOuterRightJoin(String tipoHabitacion) {
		return this.hotelRepository.buscarHotelOuterRightJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelOuterLeftJoin(String tipoHabitacion) {
		return this.hotelRepository.buscarHotelOuterLeftJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelOuterLeftJoin() {
		return this.hotelRepository.buscarHotelOuterLeftJoin();
	}

	@Override
	public List<Hotel> buscarHotelWhereJoin(String tipoHabitacion) {
		return this.hotelRepository.buscarHotelWhereJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelFetchJoin(String tipoHabitacion) {
		return this.hotelRepository.buscarHotelFetchJoin(tipoHabitacion);
	}

}
