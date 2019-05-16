package unq.tpi.persistencia.performance.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="salaries")
public class Salary implements Serializable {
	private static final long serialVersionUID = 1L;

	@	Id
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="emp_no")
	private Employee employee;
	
	@Id
	@Column(name="from_date")
	private Date from;
	
	@Column(name="salary", columnDefinition="int")
	private double amount;

	@Column(name="to_date")
	private Date to;
	
	public Employee getEmployee() {
		return this.employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public double getAmount() {
		return this.amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Date getFrom() {
		return this.from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return this.to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	
}
