package com.uce.edu.demo.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "vuelo")

@NamedQuery(name = "Vuelo.buscarPorDisponibilidad", query = "SELECT v FROM Vuelo v WHERE v.estado = 'DIS' AND v.origen = :origen AND v.destino = :destino AND v.fechaVuelo = :fecha")
public class Vuelo {

	@Id
	@Column(name = "vuel_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vuel_id_seq")
	@SequenceGenerator(name = "vuel_id_seq", sequenceName = "vuel_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "vuel_numero")
	private String numero;

	@Column(name = "vuel_fecha_vuelo")
	private String fechaVuelo;

	@Column(name = "vuel_asientos_disponibles")
	private Integer asientosDisponibles;

	@Column(name = "vuel_asientos_ocupados")
	private Integer asientosOcupados;

	@Column(name = "vuel_valor_asiento")
	private BigDecimal valorAsiento;

	@Column(name = "vuel_estado")
	private String estado;

	@Column(name = "vuel_origen")
	private String origen;

	@Column(name = "vuel_destino")
	private String destino;

	@OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL)
	private List<CompraPasaje> comprasPasajes;

	@ManyToOne
	@JoinColumn(name = "vuel_avio_id")
	private Avion avion;

	@Override
	public String toString() {
		return "Vuelo [id=" + id + ", numero=" + numero + ", fechaVuelo=" + fechaVuelo + ", asientosDisponibles="
				+ asientosDisponibles + ", asientosOcupados=" + asientosOcupados + ", valorAsiento=" + valorAsiento
				+ ", estado=" + estado + ", origen=" + origen + ", destino=" + destino + "]";
	}

	// Set y Get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getFechaVuelo() {
		return fechaVuelo;
	}

	public void setFechaVuelo(String fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}

	public Integer getAsientosDisponibles() {
		return asientosDisponibles;
	}

	public void setAsientosDisponibles(Integer asientosDisponibles) {
		this.asientosDisponibles = asientosDisponibles;
	}

	public BigDecimal getValorAsiento() {
		return valorAsiento;
	}

	public void setValorAsiento(BigDecimal valorAsiento) {
		this.valorAsiento = valorAsiento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<CompraPasaje> getComprasPasajes() {
		return comprasPasajes;
	}

	public void setComprasPasajes(List<CompraPasaje> comprasPasajes) {
		this.comprasPasajes = comprasPasajes;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Integer getAsientosOcupados() {
		return asientosOcupados;
	}

	public void setAsientosOcupados(Integer asientosOcupados) {
		this.asientosOcupados = asientosOcupados;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

}
