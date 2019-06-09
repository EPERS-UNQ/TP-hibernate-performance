package unq.tpi.persistencia.performance.service;
import unq.tpi.persistencia.performance.dao.SalaryDAO;
import unq.tpi.persistencia.performance.model.Salary;

import java.util.List;

public class ListadoPagosPorDepto extends AbstractListado {

	private final String id;

	public ListadoPagosPorDepto(String fileName, String id) {
		super(fileName);
		this.id = id;
	}

	@Override
	public void doListado()  {

		List<Salary> salaries = new SalaryDAO().getDepartmentSalaries(this.id);

		this.newLine();
		this.addColumn("Total").addColumn((long)salaries.stream().mapToDouble(Salary::getAmount).sum()).newLine();
		this.newLine();

		this.addColumn("Nombre").addColumn("Titulo").addColumn("Monto").newLine();

		salaries.forEach(it -> {
			this.addColumn(it.getEmployee().getFullName())
					.addColumn(it.getEmployee().getTitle())
					.addColumn(it.getAmount())
					.newLine();
		});

	}
	
}
