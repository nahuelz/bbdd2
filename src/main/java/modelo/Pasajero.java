package modelo;

import java.util.Date;

public class Pasajero extends Usuario {

	int creditos;
	int idPasajero;

	public Pasajero(){
		super();
	}
	
	public Pasajero (String nombre, String password, Date fecha, int creditos){
		super(nombre, password, fecha);
		this.setCreditos(creditos);
	}
	
	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	
	public int getIdPasajero() {
		return idPasajero;
	}

	public void setIdPasajero(int idPasajero) {
		this.idPasajero = idPasajero;
	}
	
}
