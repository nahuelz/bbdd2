package modelo;
import java.util.Date;

public class Usuario {
	
	int idUsuario;
	String nombre;
	String password;
	Date fechaIngreso;
	
	public Usuario (String nombre, String password, Date fecha){
		this.setNombre(nombre);
		this.setPassword(password);
		this.setFechaIngreso(fecha);
	}
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	
	

}
