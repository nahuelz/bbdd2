package utils;

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

public class Consultas {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		System.out.println("---------- LISTA PASAJEROS ----------");
		Transaction tx = session.beginTransaction();
		Muber muber = (Muber) session.createQuery("from Muber").uniqueResult();
		muber.listarPasajeros();;
		tx.rollback();
		
		System.out.println("---------- LISTA CONDUCTORES ----------");
		tx = session.beginTransaction();
		muber.listarConductores();;
		tx.rollback();
		
		System.out.println("---------- VIAJES ABIERTOS ----------");
		tx = session.beginTransaction();
		muber.listarViajesAbiertos();;
		tx.rollback();
		
		System.out.println("---------- INFO CONDUCTOR ----------");
		tx = session.beginTransaction();
		muber.getInfoConductor(2);
		tx.rollback();
		

	}

}
