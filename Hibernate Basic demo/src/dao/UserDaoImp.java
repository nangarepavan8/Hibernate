package dao;

import org.hibernate.*;

import pojos.User;
import static utils.hibernateUtils.getsf;

public class UserDaoImp implements IUserDao {

	@Override
	public String registerUser(User newUser) {

		String msg = "user registration failds............";
		//get hibernate session from session factory
		
		Session hibSession = getsf().openSession();
	
				
		//transaction
		
		Transaction tx = hibSession.beginTransaction();
		
		try {
			// commmit tranasction
			
			hibSession.save(newUser);
			tx.commit();
			
			msg = "user registration success";
			
			
		}catch (HibernateException e) {
			// Troll back transaction
			
			if(tx != null )
			{
				tx.rollback();
			}
			
			throw e;
		}
		finally {
			if(hibSession != null)
			{
				hibSession.close();
			}
		}
		
		return msg;
	}

}
