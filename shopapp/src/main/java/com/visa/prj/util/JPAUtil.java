package com.visa.prj.util;

import java.rmi.server.UnicastRemoteObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sound.midi.MidiDevice.Info;
import javax.sql.PooledConnection;

import org.hibernate.cfg.CreateKeySecondPass;
import org.mockito.exceptions.misusing.UnfinishedStubbingException;
import org.mockito.internal.matchers.Find;

public class JPAUtil {
	private static final EntityManagerFactory emFactory;
	static {
		
		/*
		 * Readable META-INF/Persistence.xml and find persistence-unit="PU"
		 * CreateKeySecondPass EntityManagerFactory UnfinishedStubbingException these details
		 * Internally EntityManagerFactor creates a pool of database connections
		 * using the info provided
		 */
		
		   emFactory = Persistence.createEntityManagerFactory("PU");
	}
	public static EntityManager getEntityManager(){
		return emFactory.createEntityManager();
	}
	public static void close(){
		emFactory.close();
	}
}
