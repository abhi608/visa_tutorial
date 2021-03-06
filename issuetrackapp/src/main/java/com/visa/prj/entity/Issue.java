package com.visa.prj.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="issues")
public class Issue {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="des", nullable=false)
	private String description;
	
	@Column(name="raised_date", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date raisedDate;
	
	@Column(name="resolved_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date resolvedDate;
	
	@Column(name="sol")
	private String solution;
	
	@ManyToOne
	@JoinColumn(name="issue_raised_by_fk", nullable=false) 
	private Employee issueRaisedBy; //ManytoOne means bi-directional relationship while OnetoMany means uni-directional reln.
	// For bi-directional, write JoinColumn in ManyToOne side
	
	@ManyToOne
	@JoinColumn(name="issue_resolved_by_fk")
	private Employee issueResolvedBy;
	
	@Column(name="status", nullable=false)
	private int status;

	@Override
	public String toString() {
		return "Issue [id=" + id + ", description=" + description + ", raisedDate=" + raisedDate + ", resolvedDate="
				+ resolvedDate + ", solution=" + solution + ", issueRaisedBy=" + issueRaisedBy + ", issueResolvedBy="
				+ issueResolvedBy + ", status=" + status + "]";
	}

	public Issue() {
	}

	public Issue(int id, String description, Date raisedDate, Employee issueRaisedBy, int status) {
		this.id = id;
		this.description = description;
		this.raisedDate = raisedDate;
		this.issueRaisedBy = issueRaisedBy;
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRaisedDate() {
		return raisedDate;
	}

	public void setRaisedDate(Date raisedDate) {
		this.raisedDate = raisedDate;
	}

	public Date getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(Date resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public Employee getIssueRaisedBy() {
		return issueRaisedBy;
	}

	public void setIssueRaisedBy(Employee issueRaisedBy) {
		this.issueRaisedBy = issueRaisedBy;
	}

	public Employee getIssueResolvedBy() {
		return issueResolvedBy;
	}

	public void setIssueResolvedBy(Employee issueResolvedBy) {
		this.issueResolvedBy = issueResolvedBy;
	}
	
	
}
