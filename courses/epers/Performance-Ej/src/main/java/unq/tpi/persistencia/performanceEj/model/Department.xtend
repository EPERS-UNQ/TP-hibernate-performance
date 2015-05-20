package unq.tpi.persistencia.performanceEj.model

import java.util.ArrayList
import java.util.HashSet
import java.util.List
import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
public class Department {
	String number
	String name
	Set<Employee> employees = new HashSet
	Set<Employee> historicEmployees = new HashSet
	List<Employee> managers = new ArrayList

	def Double getTotalSalaries() {
		employees.fold(0D)[total, employee|total + employee.salary]
	}

	def getManager() {
		managers.last
	}

}
