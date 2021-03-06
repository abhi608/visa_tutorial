package com.visa.prj.client;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.visa.prj.dao.IssueDao;
import com.visa.prj.dao.IssueDaoJpaImpl;
import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Issue;
import com.visa.prj.util.JPAUtil;

public class IssueClient {
	public static void main(String[] args) {
		while(true) {
			printOptions();
			int choice = KeyboardUtil.getInt("Select Option:");
			if(choice == 1) {
				String email = KeyboardUtil.getString("Enter employee's mail id:");
				try {
					EntityManager em = JPAUtil.getEntityManager();
					Employee issueRaisedBy = em.find(Employee.class, email);
					String description = KeyboardUtil.getString("Enter issue description:");
					IssueDao dao = new IssueDaoJpaImpl();
					Issue issue = new Issue(0, description, new Date(), issueRaisedBy, 0);
					try {
						dao.raiseIssue(issue);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			} else if(choice == 2) {
				IssueDao dao = new IssueDaoJpaImpl();
				try {
					List<Issue> openIssues = dao.getUnresolvedIssues();
					for(Issue issue : openIssues) {
						System.out.println(issue);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if(choice == 3) {
				IssueDao dao = new IssueDaoJpaImpl();
				EntityManager em = JPAUtil.getEntityManager();
				em.getTransaction().begin();
				int issueId = KeyboardUtil.getInt("Enter issue id:");
				try {
					Issue issue = em.find(Issue.class, issueId);
					String email = KeyboardUtil.getString("Enter employee's mail id:");
					try {
						Employee issueResolvedBy = em.find(Employee.class, email);
						String solution = KeyboardUtil.getString("Enter solution:");
						issue.setIssueResolvedBy(issueResolvedBy);
						issue.setResolvedDate(new Date());
						issue.setSolution(solution);
						issue.setStatus(1);
						em.getTransaction().commit();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if(choice == 4) {
				System.exit(0);
			}
		}
	}
	
	private static void printOptions() {
		System.out.println("1. Raise an issue");
		System.out.println("2. List open issues");
		System.out.println("3. Resolve an open issue");
		System.out.println("4. Exit");
		System.out.println("Select [1/2/3/4]");
	}
}
