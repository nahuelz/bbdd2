package modelo;
import java.util.Date;

public class Conductor extends Usuario {
	
	int idConductor;
	Date fechaVencimientoLic;
	
	public Conductor(){
		super();
	}
	
	public Conductor(String nombre, String password, Date fechaIngreso, Date fechaVencimiento){
		super(nombre, password, fechaIngreso);
		this.setFechaVencimientoLic(fechaVencimiento);
	}

	public Date getFechaVencimientoLic() {
		return fechaVencimientoLic;
	}

	public void setFechaVencimientoLic(Date fechaVencimientoLic) {
		this.fechaVencimientoLic = fechaVencimientoLic;
	}
	
	public int getIdConductor() {
		return idConductor;
	}

	public void setIdConductor(int idConductor) {
		this.idConductor = idConductor;
	}
	

}
