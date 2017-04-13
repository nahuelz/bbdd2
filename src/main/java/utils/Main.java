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
		
		Pasajero user = new Pasajero();
		user.setNombre("Nahuel");
		user.setPassword("123456");
		user.setFechaIngreso(new Date());
		user.setCreditos(20);
		
		Pasajero user3 = new Pasajero();
		user3.setNombre("ASDASD");
		user3.setPassword("123456");
		user3.setFechaIngreso(new Date());
		user3.setCreditos(20);
		
		Conductor user2 = new Conductor();
		user2.setNombre("PEPE");
		user2.setPassword("123456");
		user2.setFechaIngreso(new Date());
		user2.setFechaVencimientoLic(new Date());
		
		Viaje viaje = new Viaje();
		viaje.setCantidadMaximaPasajeros(10);
		viaje.setConductor(user2);
		viaje.setCostoTotal(500);
		viaje.setDestino("Olavarria");
		viaje.setOrigen("La plata");
		viaje.setFecha(new Date());
		viaje.addPasajero(user);
		viaje.addPasajero(user3);
		viaje.setFinalizado(true);
		
		Comentario comentario = new Comentario();
		comentario.setCalificacion(10);
		comentario.setComentario("Buen conductor");
		comentario.setPasajero(user);
		comentario.setViaje(viaje);
		
		Muber muber = new Muber();
		muber.addViaje(viaje);
		muber.addUser(user);
		muber.addUser(user2);
		muber.addUser(user3);
		
		Session session = sf.openSession();
		
		

		Transaction tx = session.beginTransaction();
		session.persist(muber);
		session.persist(comentario);
		tx.commit();
		 	
		 	
	}

	
	

}
