package utils;


import java.util.Date;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import modelo.Comentario;
import modelo.Conductor;
import modelo.Muber;
import modelo.Pasajero;
import modelo.Viaje;

public class Main {

	public static void main(String[] args) {
		System.out.println("----------------------- Setting up Hibernate -----------------------");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		System.out.println("Droping schema.........");
		new SchemaExport(cfg).drop(true, true);
		System.out.println("DONE.");
		
		System.out.println("Generating schema.........");
		new SchemaExport(cfg).create(true, true);
		System.out.println("DONE.");

		System.out.println("Building sessions.........");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Conductor conductor = new Conductor();
		conductor.setNombre("Roberto");
		conductor.setPassword("123456");
		conductor.setFechaIngreso(new Date());
		conductor.setFechaVencimientoLic(new Date());
		
		Viaje viaje = new Viaje();
		viaje.setCantidadMaximaPasajeros(10);
		viaje.setConductor(conductor);
		viaje.setCostoTotal(900);
		viaje.setDestino("Tres arroyos");
		viaje.setOrigen("La plata");
		viaje.setFecha(new Date());

		Pasajero pasajero1 = new Pasajero();
		pasajero1.setNombre("Germán");
		pasajero1.setPassword("123456");
		pasajero1.setFechaIngreso(new Date());
		pasajero1.setCreditos(1500);
		
		Pasajero pasajero2 = new Pasajero();
		pasajero2.setNombre("Alicia");
		pasajero2.setPassword("Margarita");
		pasajero2.setFechaIngreso(new Date());
		pasajero2.setCreditos(1500);
		
		Pasajero pasajero3 = new Pasajero();
		pasajero3.setNombre("Margarita");
		pasajero3.setPassword("123456");
		pasajero3.setFechaIngreso(new Date());
		pasajero3.setCreditos(1500);
		
		viaje.addPasajero(pasajero1);
		viaje.addPasajero(pasajero2);
		viaje.addPasajero(pasajero3);
		
		viaje.setFinalizado(true);
		
		Comentario comentario = new Comentario();
		comentario.setCalificacion(5);
		comentario.setComentario("Muy buen conductor");
		comentario.setPasajero(pasajero1);
		comentario.setViaje(viaje);
		
		Comentario comentario2 = new Comentario();
		comentario2.setCalificacion(4);
		comentario2.setComentario("Buen conductor");
		comentario2.setPasajero(pasajero2);
		comentario2.setViaje(viaje);
		
		Comentario comentario3 = new Comentario();
		comentario3.setCalificacion(4);
		comentario3.setComentario("Buen conductor");
		comentario3.setPasajero(pasajero3);
		comentario3.setViaje(viaje);
		
		Muber muber = new Muber();
		muber.addViaje(viaje);
		muber.addUser(conductor);
		muber.addUser(pasajero1);
		muber.addUser(pasajero2);
		muber.addUser(pasajero3);
		
		Session session = sf.openSession();
		
		

		Transaction tx = session.beginTransaction();
		session.persist(muber);
		session.persist(comentario);
		tx.commit();
		 	
		 	
	}

	
	

}
