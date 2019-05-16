package unq.tpi.persistencia.performance.dao;

import org.hibernate.Session;
import unq.tpi.persistencia.performance.model.Salary;
import unq.tpi.persistencia.performance.service.runner.Runner;

import java.io.Serializable;
import java.util.List;

public class SalaryDAO extends BaseDAO<Salary> {

    public SalaryDAO() {
        super(Salary.class, "Salary");
    }

    public List<Salary> getDepartmentSalaries(Serializable code) {

        Session session = Runner.getCurrentSession();
        String hql = "select s from Salary s join fetch s.employee e join fetch s.employee.titles t left join s.employee.departments as d where d.code = :code and s.to = '9999-01-01'";
        return session.createQuery ( hql, Salary.class).setParameter("code", code).getResultList();

    }
}
