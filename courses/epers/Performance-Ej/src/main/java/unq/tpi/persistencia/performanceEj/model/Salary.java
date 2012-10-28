package unq.tpi.persistencia.performanceEj.model;

import java.io.Serializable;
import java.util.Date;

public class Salary implements Serializable{
	private static final long serialVersionUID = 7351499485415777874L;
	private Employee employee;
	private double amount;
	private Date from;
	private Date to;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}
}
