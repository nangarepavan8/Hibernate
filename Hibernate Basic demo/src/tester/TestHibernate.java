package tester;

import org.hibernate.*;  //our package file
import static utils.hibernateUtils.getsf;

public class TestHibernate {

	public static void main(String[] args) {
		
		
		try(SessionFactory sessionFactory = getsf())
		{
			System.out.println("hibernate booted");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
