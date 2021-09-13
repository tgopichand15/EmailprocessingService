package com.example.client;

import com.example.entities.Issues;
import com.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.example.entities.IssuesToBeProcessedforSolutions;


import java.util.Date;

public class SaveDataClientTest {

	 private static void createNewIssue(HistoricalIssue h){

	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	
	    	createHistoricalIssue(session,h);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	  }



	private static void createEmployee(Session session) {
		session.beginTransaction();
		Integer id =(Integer)session.save(getIssue());
		System.out.println("Employee is created  with Id::"+id);
		session.getTransaction().commit();
		
	}


	private static void createHistoricalIssue(Session session,HistoricalIssue h) {
		session.beginTransaction();
		Integer id =(Integer)session.save(h);
		System.out.println("HistoricalIssue is created  with Id::"+id);
		session.getTransaction().commit();



	}



	private static void updateCount(Session session){



	}
	
	private static Issues getIssue(){
		Issues issues=new Issues();
		issues.setIssuename("CPU 10.20.30.238");
		issues.setIsProcessed(1);
		return issues;
	}


	private static void updateEmployeeById(Session session){
		Employee e=session.get(Employee.class,1);

		if(e==null){
			System.out.println("employed with provided id does not exist");
		}
		else{
			e.setSalary(50000);
			session.beginTransaction();

			session.update(e);

			session.getTransaction().commit();
			System.out.println(e);
		}
	}


	private static HistoricalIssues addIssue(HashMap<String,integer> h) {


		Iterator hmIterator = h.entrySet().iterator();

		HistoricalIssues hissue=new HistoricalIssues();

		while (hmIterator.hasNext()) {
			Map.Entry mapElement = (Map.Entry)hmIterator.next();
			int count = (int)mapElement.getValue()
			System.out.println(mapElement.getKey() + " : " + count);

			String[] a=mapElement.getKey().split(" ");
			String issue=a[0];
			String hostname=a[1];
			String issuecount=count;

			hissue.setIssue(issue);
			hissues.setHostname(hostname);
			hissue.setCount(issueCount);

			createNeIssue(hissue);
			//flushing  alues in object
			hissue=null;


		}

		private static void insertIssuestobeProcessedBysolutionService(HashMap<String,String> issues){
            try(Session session = HibernateUtil.getSessionFactory().openSession()) {

                createHistoricalIssue(session);
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }



		//insert unresolved issues after action service
		public static void insertUnresovedIsseus(List<UnresolvedIssues> l){
			try(Session session = HibernateUtil.getSessionFactory().openSession()) {
				foreach(UnresolvedIssues u:l){
					session.beginTransaction();
					Integer id = (Integer) session.save(u);
					System.out.println("unresolvedIssues is created  with Id::" + id);
					session.getTransaction().commit();
				}
			}
			catch (HibernateException e) {
				e.printStackTrace();
			}

		}

		//inserting data to DB
		public static IssuesToBeProcessedforSolutions createIssueforProcessingintoDB(HashMap<String,String> issue>){
		    Iterator i=issue.entrySet().iterator();

		    Issues i=new Issues();
		    while(i.hasNext()){
		    	String key=issues.getNext();
		    	i.setIssuename(key);
		    	i.setHostname(i.get(key));
		    	i.setIsProcessed(false);
				try(Session session = HibernateUtil.getSessionFactory().openSession()) {

					createHistoricalIssue(i);
				} catch (HibernateException e) {
					e.printStackTrace();
				}


			}
        }

	}

}