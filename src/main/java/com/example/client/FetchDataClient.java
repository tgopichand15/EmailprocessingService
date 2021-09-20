package com.example.client;

import com.example.entities.Issues;
import com.example.util.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class FetchDataClient {

	private static final Logger logger = LogManager.getLogger(FetchDataClient.class);

	public static void main(String[] args) {
		Issues issues = null;
		logger.info("getting  issue with id 1 from DB");
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	issues = session.get(Issues.class, 1);
	    	logger.infoe("fetched value is "+issues);
	    	System.out.println(issues);
		} catch (HibernateException e) {
	    	logger.error("Exception while fetching value from Issues table "+e.printStackTrace());
			e.printStackTrace();
		}

       /* public static Issues getCount(String Hostname){
            Query query = session.createQuery("SELECT count FROM Issues i WHERE i.host=:Hostname");
            query.setParameter("Hostname", Hostname);
            return query.uniqueResult();
	    }

	    Issues s=getCount("10.20.200.190");
	    System.out.println(s);





        /*private static void fetchUpdateIssueByHostname(Session session){

         logger.info("updating salary value of record in Issues with id 1");
			Employee e=session.get(Employee.class,1);

			if(e==null){
				System.out.println("employed with provided id does not exist");
			}
			else{
				e.setSalary(50000);
				session.beginTransaction();

				session.update(e);

				session.getTransaction().commit();
				logger.info("updated salary value successfully");
				System.out.println(e);
			}
		}*/
	    
	  }
}
