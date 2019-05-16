package unq.tpi.persistencia.performance.dao;

import org.hibernate.Session;
import unq.tpi.persistencia.performance.model.Employee;
import unq.tpi.persistencia.performance.service.runner.Runner;

import java.util.List;

public class EmployeeDAO extends BaseDAO<Employee> {

	public EmployeeDAO() {
		super(Employee.class, "Employee");
	}
	
	/**
	 * Gets an employee by name and lastName
	 * @return the employee found, otherwise null
	 */
	public Employee getByName(String name, String lastName) {
		Session session = Runner.getCurrentSession();
		
		String hql = "from Employee where firstName = :name and lastName = :lastName";
		return session.createQuery(hql, Employee.class)
				.setParameter("name", name)
				.setParameter("lastName", lastName)
				.getSingleResult();
	}

	public List<Employee> getAllEmployeesOrdered() {
		Session session = Runner.getCurrentSession();
		String hql = "select s.employee from Salary as s where s.to = '9999-01-01' order by s.amount DESC";
		return session.createQuery ( hql, Employee.class)
				.setMaxResults(10).getResultList();

	}

	
}
