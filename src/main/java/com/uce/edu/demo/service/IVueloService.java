package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.modelo.Vuelo;

public interface IVueloService {

	public List<Vuelo> buscarPorDisponibilidad(String origen, String destino, String fecha);

	public Vuelo buscarDisponibilidadPorNumero(String numero);

}
