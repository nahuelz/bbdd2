package modelo;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class Viaje {
	int idViaje;
	String origen;
	String destino;
	int costoTotal;
	Date fecha;
	int cantidadMaximaPasajeros;
	Conductor conductor;
	Collection<Pasajero> pasajeros;
	Collection<Comentario> comentarios;
	boolean finalizado;

	public Viaje() {
		this.pasajeros = new HashSet<Pasajero>();
		this.comentarios = new HashSet<Comentario>();
		this.finalizado = false;
	}
	
	public Viaje(String origen, String destino, int costoTotal, int pasajeros, Date fecha, Conductor conductor){
		this();
		this.setOrigen(origen);
		this.setDestino(destino);
		this.setCantidadMaximaPasajeros(pasajeros);
		this.setFecha(fecha);
		this.setCostoTotal(costoTotal);
		this.setConductor(conductor);
	}
	
	public int getIdViaje() {
		return idViaje;
	}
	public void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
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
	public int getCostoTotal() {
		return costoTotal;
	}
	public void setCostoTotal(int costoTotal) {
		this.costoTotal = costoTotal;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getCantidadMaximaPasajeros() {
		return cantidadMaximaPasajeros;
	}
	public void setCantidadMaximaPasajeros(int cantidadMaximaPasajeros) {
		this.cantidadMaximaPasajeros = cantidadMaximaPasajeros;
	}
	
	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}
	
	public Collection<Pasajero> getPasajeros() {
		return pasajeros;
	}
 
	public void setPasajeros(Collection<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}
	
	public Collection<Comentario> getComentarios() {
		return comentarios;
	}
 
	public void setComentarios(Collection<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	public void addPasajero (Pasajero pasajero) {
		if((pasajeros.size() < this.getCantidadMaximaPasajeros()) && 
				(this.puedeViajar(pasajero))) {
			this.pasajeros.add(pasajero);
		}
	}
	
	public boolean getFinalizado() {
		return finalizado;
	}
	
	private void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	
	public float costoPorPasajero() {
		return (this.costoTotal / this.pasajeros.size());
	}
	
	private boolean puedeViajar(Pasajero pasajero) {
		return (pasajero.getCreditos() >= this.costoTotal / (this.pasajeros.size() + 1));
	}
	
	public void finalizar() {
		this.setFinalizado(true);
	}
	
	public void addComentario(Comentario comentario) {
		this.comentarios.add(comentario);
	}
	
	
}
