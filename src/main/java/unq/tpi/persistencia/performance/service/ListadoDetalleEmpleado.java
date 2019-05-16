package unq.tpi.persistencia.performance.service;

import unq.tpi.persistencia.performance.dao.EmployeeDAO;
import unq.tpi.persistencia.performance.model.Employee;

public class ListadoDetalleEmpleado extends AbstractListado {

	private final int num;

	public ListadoDetalleEmpleado(String fileName, int num) {
		super(fileName);
		this.num = num;
	}

	@Override
	public void doListado() {
		Employee e = new EmployeeDAO().getByCode(this.num);
		
		this.addColumn("Codigo").addColumn(e.getId()).newLine();
		this.addColumn("Nombre").addColumn(e.getFirstName()).newLine();
		this.addColumn("Departamento").addColumn(e.getDepartment().getName()).newLine();
		this.addColumn("Manager").addColumn(e.getDepartment().getManager().getFullName()).newLine();
		this.addColumn("Salario Actual").addColumn(e.getSalary()).newLine();
		this.addColumn("Cargo").addColumn(e.getTitle()).newLine();
		this.newLine();
		
		this.addColumn("Salario Historico").newLine();
		
		this.addColumn("Salario").addColumn("Desde").addColumn("Hasta").newLine();
		e.getSalaries().forEach(it -> {
			this.addColumn(it.getAmount())
				.addColumn(it.getFrom())
				.addColumn(it.getTo())
				.newLine();
		});
	}

}
