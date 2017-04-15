package modelo;

import java.util.HashSet;
import java.util.Set;

import modelo.Usuario;
import modelo.Viaje;

public class Muber {

	private int idMuber;
	private Set<Usuario> usuarios;
	private Set<Viaje> viajes;

	public Muber(){
		usuarios = new HashSet<Usuario>();
		viajes = new HashSet<Viaje>();
	}
	
	public int getIdMuber() {
		return idMuber;
	}

	public void setIdMuber(int idMuber) {
		this.idMuber = idMuber;
	}
	
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void addUser(Usuario usuario){
		this.usuarios.add(usuario);
	}
	
	public Set<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(Set<Viaje> viajes) {
		this.viajes = viajes;
	}
	
	public void addViaje(Viaje viaje){
		this.viajes.add(viaje);
	}
	
	public void listarPasajeros() {
		System.out.format("%-5s%-14s%-8s%n", "ID", "Nombre", "Créditos");
		for( Usuario user : this.getUsuarios() ) {
			if (user.isPasajero()) {
				Pasajero pasajero = (Pasajero) user;
				System.out.format("%-5s%-14s%-8s%n", pasajero.getIdUsuario(), pasajero.getNombre(), pasajero.getCreditos());
			}
		}
	}
	
	public void listarConductores() {
		System.out.format("%-5s%-14s%-10s%n", "ID", "Nombre", "Venc. licencia");
		for( Usuario user : this.getUsuarios() ) {
			if (user.isConductor()) {
				Conductor conductor = (Conductor) user;
				System.out.format("%-5d%-14s%-10tD%n", conductor.getIdUsuario(), conductor.getNombre(), conductor.getFechaVencimientoLic());
			}
		}
	}
	
	public void listarViajesAbiertos() {
		System.out.format("%-5s%-15s%-15s%-10s%n", "ID", "Origen", "Destino", "Fecha");
		for( Viaje viaje : this.getViajes() ) {
			if (!viaje.getFinalizado()) {
				System.out.format("%-5s%-15s%-15s%-10tc%n", viaje.getIdViaje(), viaje.getOrigen(), viaje.getDestino(), viaje.getFecha());
			}
		}
	}
	
	private void printViajes(Conductor conductor) {
		System.out.println("-----VIAJES-----");
		System.out.format("%-5s%-15s%-15s%-10s%n", "ID", "Origen", "Destino", "Fecha");
		for( Viaje viaje : conductor.getViajes() ) {
			System.out.format("%-5s%-15s%-15s%-10tc%n", viaje.getIdViaje(), viaje.getOrigen(), viaje.getDestino(), viaje.getFecha());
		}
	}
	
	public void getInfoConductor(int idConductor) {
		boolean ok = false;
		for( Usuario usuario : this.getUsuarios() ) {
			if ((usuario.getIdUsuario() == idConductor) && (usuario.isConductor())) {
				ok = true;
				Conductor conductor = (Conductor) usuario;
				System.out.format("%-14s%-13s%-10s%n", "Nombre", "Punt. prom.", "Venc. Licencia");
				System.out.format("%-14s%-13s%-10s%n", conductor.getNombre(), conductor.puntajePromedio(), conductor.getFechaVencimientoLic());
				this.printViajes(conductor);
				break;
			}
		}
		if (!ok) System.out.println("El conductor no existe");
	}
	
}
