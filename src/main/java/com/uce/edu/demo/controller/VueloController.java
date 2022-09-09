package com.uce.edu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.modelo.Cliente;
import com.uce.edu.demo.modelo.CompraPasaje;
import com.uce.edu.demo.modelo.Vuelo;
import com.uce.edu.demo.service.IVueloService;

@Controller
@RequestMapping("/vuelos")
public class VueloController {
	
	@Autowired
	private IVueloService vueloService;
	
	// Métodos de redireccionamiento a páginas
	@GetMapping("/buscarVuelo")
	public String buscarVuelo(Vuelo vuelo) {
		return "vistaBusquedaVuelos";
	}
	
	@GetMapping("/buscarNumeroVuelo")
	public String buscarNumeroVuelo(Vuelo vuelo) {
		return "vistaBusquedaNumeroVuelo";
	}
	
	// GET
	@GetMapping("/vuelosDisponibles")
	public String vuelosDisponibles(Vuelo vuelo, Model modelo) {
		List<Vuelo> vuelos = this.vueloService.buscarPorDisponibilidad(vuelo.getOrigen(), vuelo.getDestino(), vuelo.getFechaVuelo());
		modelo.addAttribute("vuelos", vuelos);
		return "vistaVuelosEncontrados";
	}
	
	@GetMapping("/vueloEncontrado")
	public String vueloEncontrado(Vuelo v,  Model modelo) {
		Vuelo vuelo = this.vueloService.buscarDisponibilidadPorNumero(v.getNumero());
		modelo.addAttribute("vuelo", vuelo);
		return "vistaVueloDisponible";
	}
	
//	// POST
//	@PostMapping("/insertarDatos")
//	public String insertarDatos(Cliente cliente, CompraPasaje compraPasaje) {
//		
//	}

}
