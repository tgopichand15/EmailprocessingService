package com.example.client;

import com.example.entities.Issues;
import com.example.util.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Component;


@Component
public class SaveDataClient {

	private static final Logger logger = LogManager.getLogger(SaveDataClient.class);


	private static void createNewIssue(HistoricalIssue h){

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



	}
	
	private static Issue getIssue(){
		Issues issues=new Issues();
		issues.setIssuename("CPU 10.20.30.238");
		issues.setIsProcessed(1);
		return issues;
	}


	private static void updateEmployeeById(int id) {

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


	private static HistoricalIssues addIssue(HashMap<String,integer> h) {


		logger.info("inserting issues to Db from addIssue() method");

		Iterator hmIterator = h.entrySet().iterator();

		HistoricalIssues hissue=new HistoricalIssues();

		while (hmIterator.hasNext()) {
			Map.Entry mapElement = (Map.Entry)hmIterator.next();
			int count = (int)mapElement.getValue();
			System.out.println(mapElement.getKey() + " : " + count);

			String[] a=mapElement.getKey().split(" ");
			String issue=a[0];
			String hostname=a[1];
			String issuecount=count;

			hissue.setIssue(issue);
			hissues.setHostname(hostname);
			hissue.setCount(issueCount);

			createNeIssue(hissue);
			looger.info("valuess to historicalIssues inserted from addIssue method");
			//flushing  alues in object
			hissue=null;


		}

	}

	//insert unresolved issues after action service
	public static void insertUnresovedIsseus(List<UnresolvedIssues> l){
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

	}

	//inserting data to DB
	public static IssuesToBeProcessedforSolutions createIssueforProcessingintoDB(HashMap<String,String> issue) {


		logger.info("creating historical issues into DB");
		Iterator i = issue.entrySet().iterator();

		Issues i = new Issues();
		while (i.hasNext()) {
			String key = issues.getNext();
			i.setIssuename(key);
			i.setHostname(i.get(key));
			i.setIsProcessed(false);
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				createHistoricalIssue(i);
				logger.info("historicalissue creation succeded");
			} catch (HibernateException e) {
				logger.error("insertion of Historical issues failed with exception " + e.printStackTrace());
				e.printStackTrace();
			}


		}
	}


	private static void insertIssuestobeProcessedBysolutionService(HashMap<String,String> issues){
		logger.info("inserting issues to be processed by solutionservice");
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {

			createHistoricalIssue(session);
			looger.info("insertion onto SolutionService Db succeded");
		} catch (HibernateException e) {
			logger.error("insertion into Solutonservice Db failed");
			e.printStackTrace();
		}
	}




}