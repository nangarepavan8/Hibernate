package utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class hibernateUtils {

	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry StandardServiceRegistry;

	static {

		System.out.println("inside static init bloock");

		try {
			// create std servic reg instance from its builder
			if (sessionFactory == null) {

				StandardServiceRegistry reg = new StandardServiceRegistryBuilder().configure().build();
				sessionFactory = new MetadataSources(reg).buildMetadata().buildSessionFactory();
		/*	
				StandardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
				MetadataSources metadatasources = new MetadataSources(StandardServiceRegistry);
				Metadata metadata = metadatasources.getMetadataBuilder().build();
				sessionFactory = metadata.getSessionFactoryBuilder().build();
*/
				System.out.println("sf is created");

			}

		} catch (Exception e) {
			e.printStackTrace();
			/*
			if(StandardServiceRegistry != null)
			{
				StandardServiceRegistryBuilder.destroy(StandardServiceRegistry);			
				}
				*/
		}
	}

	public static SessionFactory getsf() {
		return sessionFactory;
	}
}
