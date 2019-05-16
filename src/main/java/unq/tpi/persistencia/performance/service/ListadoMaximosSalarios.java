package unq.tpi.persistencia.performance.service;

import unq.tpi.persistencia.performance.dao.EmployeeDAO;
import unq.tpi.persistencia.performance.model.Employee;

import java.util.List;

public class ListadoMaximosSalarios extends AbstractListado {

	public ListadoMaximosSalarios(String fileName) {
		super(fileName);
	}

	@Override
	public void doListado() {
		List<Employee> empleados = new EmployeeDAO().getAllEmployeesOrdered();

		this.addColumn("Nombre").addColumn("Sueldo").newLine();
		empleados.forEach(employee ->
			this.addColumn(employee.getFullName())
				.addColumn(employee.getSalary())
				.newLine()
		);
	}
	
}
