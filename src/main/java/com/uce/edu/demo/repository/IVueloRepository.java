package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.modelo.Vuelo;

public interface IVueloRepository {

	public List<Vuelo> leerPorEstado(String origen, String destino, String fecha);

	public Vuelo leerEstadoPorNumero(String numero);

}
