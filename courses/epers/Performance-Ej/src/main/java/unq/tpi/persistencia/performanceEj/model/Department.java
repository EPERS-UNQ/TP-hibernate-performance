package unq.tpi.persistencia.performanceEj.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Department {
	private String number;
	private String name;
	private Set<Employee> employees = new HashSet<Employee>();
	private Set<Employee> historicEmployees = new HashSet<Employee>();
	private List<Employee> managers = new ArrayList<Employee>();

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getHistoricEmployees() {
		return historicEmployees;
	}

	public void setHistoricEmployees(Set<Employee> historicEmployees) {
		this.historicEmployees = historicEmployees;
	}

	public Double getTotalSalaries() {
		Double tot = 0D;

		for (Employee e : this.employees) {
			tot += e.getSalary();
		}

		return tot;
	}

	public Employee getManager() {
		return getManagers().get(getManagers().size() -1);
	}

	public List<Employee> getManagers() {
		return managers;
	}

	public void setManagers(List<Employee> managers) {
		this.managers = managers;
	}
}
