package tester;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.*;

import dao.UserDaoImp;
import pojos.Role;
import pojos.User;

import static utils.hibernateUtils.getsf;

public class RegisterUser {

	public static void main(String[] args) {
		
		// parse string -> java.util.date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try(SessionFactory sessionfactory = getsf();
					Scanner sc = new Scanner(System.in ))
			{
				
				UserDaoImp dao = new UserDaoImp();
				System.out.println(" Enter Your details : name,  email,  passwod, reAmount, regDate, userRole");
				
				 //create user instance
				
				User u1 = new User(sc.next(),sc.next(),sc.next(),sc.nextDouble(),sdf.parse(sc.next()), Role.valueOf(sc.next().toUpperCase())); 
			
			 System.out.println(dao.registerUser(u1));
			}
			catch (Exception e) {
				e.printStackTrace();
				}
		
	}

}
