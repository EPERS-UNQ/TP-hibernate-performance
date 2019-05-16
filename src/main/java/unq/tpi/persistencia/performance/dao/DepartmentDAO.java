package unq.tpi.persistencia.performance.dao;

import org.hibernate.Session;
import unq.tpi.persistencia.performance.model.Department;
import unq.tpi.persistencia.performance.service.runner.Runner;

public class DepartmentDAO extends BaseDAO<Department> {

	public DepartmentDAO() {
		super(Department.class, "Department");
	}

	/**
	 * Gets the department by its name
	 * @return the department found, or null
	 */
	public Department getByName(String name) {
		Session session = Runner.getCurrentSession();
		
		String hql = "from Department where name = :name";
		return session.createQuery(hql, Department.class)
				.setParameter("name", name)
				.getSingleResult();
	}

}
