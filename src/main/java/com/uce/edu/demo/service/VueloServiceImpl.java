package com.uce.edu.demo.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Vuelo;
import com.uce.edu.demo.repository.IVueloRepository;

@Service
public class VueloServiceImpl implements IVueloService {

	@Autowired
	private IVueloRepository vueloRepository;

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Vuelo> buscarPorDisponibilidad(String origen, String destino, String fecha) {
		return this.vueloRepository.leerPorEstado(origen, destino, fecha);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Vuelo buscarDisponibilidadPorNumero(String numero) {
		return this.vueloRepository.leerEstadoPorNumero(numero);
	}

}
