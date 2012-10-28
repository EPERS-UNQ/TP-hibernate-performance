package unq.tpi.persistencia.performanceEj.daos;

import java.util.List;

import org.hibernate.classic.Session;

import unq.tpi.persistencia.performanceEj.model.Department;
import unq.tpi.persistencia.util.SessionManager;

public class DepartmentDAO {

	public Department getByName(final String name) {
		Session session = SessionManager.getSession();
		return (Department) session
				.createQuery("from Department where name = :name")
				.setParameter("name", name).uniqueResult();
	}

	public Department getByCode(String num) {
		Session session = SessionManager.getSession();
		return (Department) session.get(Department.class, num);
	}

	@SuppressWarnings("unchecked")
	public List<Department> getAll() {
		Session session = SessionManager.getSession();
		return session.createCriteria(Department.class).list();
	}

}
