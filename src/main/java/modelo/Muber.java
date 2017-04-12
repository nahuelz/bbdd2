package modelo;

import java.util.Collection;
import java.util.HashSet;

import modelo.Usuario;
import modelo.Viaje;

public class Muber {

	private int idMuber;
	private Collection<Usuario> usuarios;
	private Collection<Viaje> viajes;

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
	
	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void addUser(Usuario usuario){
		this.usuarios.add(usuario);
	}
	
	public Collection<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(Collection<Viaje> viajes) {
		this.viajes = viajes;
	}
	
	public void addViaje(Viaje viaje){
		this.viajes.add(viaje);
	}
	

}
