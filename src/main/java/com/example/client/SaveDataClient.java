package com.example.client;

import com.example.entities.HistoricalIssue;
import com.example.entities.Issue;
import com.example.entities.UnprocesedIssue;
import com.example.entities.UnresolvedIssue;
import com.example.util.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


@Component
public class SaveDataClient {

	//private static final Logger logger = LogManager.getLogger(SaveDataClient.class);


	/*public static void main(String[] args){
	    createIssue();

    }*/


    private static void createIssue(){

        //logger.info("creating new Issues type to be inserted to db");

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();
            Integer id =(Integer)session.save(getIssue());
            System.out.println("Issue is created  with Id::"+id);
            //logger.info("Issue creation in DB succeded with following id "+id);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            //logger.error("creating Historical issue failed with exception"+e.printStackTrace());
            e.printStackTrace();
        }
    }





    /*private static void createNewIssue(HistoricalIssue h){

		logger.info("creating new Issues type to be inserted to db");

	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	
	    	createHistoricalIssue(session,h);
	    	logger.info("created issues which was inserted into dattabase");
		} catch (HibernateException e) {
	    	logger.error("creating Historical issue failed with exception"+e.printStackTrace());
			e.printStackTrace();
		}
	  }



	private static void createEmployee() {
		logger.info("creating employee which is to be inserted into DB");
		session.beginTransaction();
		Integer id =(Integer)session.save(getIssue());
		System.out.println("Employee is created  with Id::"+id);
		logger.info("Employee creation in DB succeded with following id "+id);
		session.getTransaction().commit();
		
	}


	private static void createHistoricalIssue(HistoricalIssue h) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {

			session.beginTransaction();
			Integer id = (Integer) session.save(h);
			System.out.println("HistoricalIssue is created  with Id::" + id);
			logger.info("HistoricalIssue creation is successful with id " + id);
			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			logger.error("creating Historical issue failed with exception"+e.printStackTrace());
			e.printStackTrace();
		}

	}



	private static void updateCount(Session session){



	}*/
	
	private static Issue getIssue(){
		Issue issue=new Issue();
		issue.setIssuename("WindowsCPU");
		issue.setHostname("10.20.230.45");
		issue.setIsProcessed(1);
		return issue;
	}


	/*private static void updateEmployeeById(int id) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {


			logger.info("getting data of employee with id "+id);

			Employee e = session.get(Employee.class, id);

			if (e == null) {
				System.out.println("employed with provided id does not exist");
			} else {
				e.setSalary(50000);
				session.beginTransaction();

				session.update(e);

				logger.info("updated data of record with id" + id);

				session.getTransaction().commit();
				System.out.println(e);
			}
		} catch (HibernateException e) {
			logger.error("updating employeebyid issue failed with exception" + e.printStackTrace());
			e.printStackTrace();
		}
	}


	private static HistoricalIssue addIssue(HashMap<String,Integer> h) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {


			logger.info("inserting issues to Db from addIssue() method");

			Iterator hmIterator = h.entrySet().iterator();

			HistoricalIssue hissue = new HistoricalIssue();

			while (hmIterator.hasNext()) {
				Map.Entry mapElement = (Map.Entry) hmIterator.next();
				int count = (int) mapElement.getValue();
				System.out.println(mapElement.getKey() + " : " + count);

				String[] a = mapElement.getKey().split(" ");
				String issue = a[0];
				String hostname = a[1];
				int issuecount = count;

				hissue.setIssue(issue);
				hissue.setHostname(hostname);

				createNeIssue(hissue);
				logger.info("valuess to historicalIssues inserted from addIssue method");
				//flushing  alues in object
				hissue = null;


			}
		}

		catch (HibernateException e) {
			logger.error(" adding issue failed with exception" + e.printStackTrace());
			e.printStackTrace();
		}


	}

	//insert unresolved issues after action service
	/*public static void insertUnresovedIsseus(List<UnresolvedIssue> l){
		logger.info("inserting unreolved issues into DB table");
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			for(UnresolvedIssue u : l){
				session.beginTransaction();
				Integer id = (Integer) session.save(u);
				System.out.println("unresolvedIssues is created  with Id::" + id);
				logger.info("insertion succedded with id "+id);
				session.getTransaction().commit();
			}
		}
		catch (HibernateException e) {
			logger.error("insertion into unresolvedIssues failed with Exception "+e.printStackTrace());
			e.printStackTrace();
		}

	}*/

	public static boolean updateUnprocessedIssue(String issueName,String hostname) {

		int id = 2;
		String newemailid = "gopi@test.com";
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			String HQL = "from UnprocesedIssue where issueName=:issueName and hostname=:hostname";

			Query q = session.createQuery(HQL);
			q.setParameter("issueName", issueName);
			q.setParameter("hostname", hostname);


			UnprocesedIssue i = (UnprocesedIssue) q.uniqueResult();
			int frequency = i.frequency;

			int newFrequncy = frequency + 1;

			if (i != null) {
				String HQl1 = "Update UnprocesedIssue set frequency=:newFrequency where issueName=:issueName and hostname=:hostname";

				Query query = session.createQuery(HQl1);
				query.setParameter("newFrequency", newFrequncy);
				query.setParameter("issueName", issueName);
				query.setParameter("hostname", hostname);
				session.beginTransaction();
				int executeupdate = query.executeUpdate();

				int flag = 0;
				if (executeupdate > 0) {
					System.out.println(executeupdate + "updation succeded");
					flag = 1;
				}

				session.getTransaction().commit();

				if (flag == 1) {
					return true;
				}
			} else {
				return false;
			}

		}
		return false;
	}

	//inserting data to DB
	public static void createIssueforProcessingintoDB(HashMap<String,Integer> h) {


		//logger.info("creating historical issues into DB");
		Iterator i = h.entrySet().iterator();

		UnprocesedIssue u = new UnprocesedIssue();
		for (String entry : h.keySet()) {

			String key = entry;
			u.setIssueName(key.split(" ")[1]);
			u.setDescription(key);
			u.setHostname(key.split(" ")[0]);
			u.setFrequency(h.get(key));

			boolean a = updateUnprocessedIssue(u.issueName, u.hostname);

			if (a == false) {
				try (Session session = HibernateUtil.getSessionFactory().openSession()) {
					session.beginTransaction();

					//check if entry exist update the count or else create the entry in DB


					Integer id = (Integer) session.save(u);
					System.out.println("Unprocessed issue  is created  with Id::" + id);
					//logger.info("Issue creation in DB succeded with following id "+id);
					session.getTransaction().commit();

				} catch (HibernateException e) {
					//logger.error("insertion of Historical issues failed with exception " + e.printStackTrace());
					e.printStackTrace();
				}


			}
		}
	}


	/*private static void insertIssuestobeProcessedBysolutionService(HashMap<String,String> issues){
		logger.info("inserting issues to be processed by solutionservice");
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {

			HistoricalIssue h=new HistoricalIssue();
			createHistoricalIssue(h);
			logger.info("insertion onto SolutionService Db succeded");
		} catch (HibernateException e) {
			logger.error("insertion into Solutonservice Db failed");
			e.printStackTrace();
		}
	}*/




}