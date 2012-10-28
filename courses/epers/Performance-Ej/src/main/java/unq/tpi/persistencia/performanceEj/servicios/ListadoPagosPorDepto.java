package unq.tpi.persistencia.performanceEj.servicios;

import unq.tpi.persistencia.performanceEj.daos.DepartmentDAO;
import unq.tpi.persistencia.performanceEj.model.Department;
import unq.tpi.persistencia.performanceEj.model.Employee;

public class ListadoPagosPorDepto extends AbstractListado {

	private String num;
	private Department depto = null;

	public ListadoPagosPorDepto(String num) {
		this.num = num;
	}

	@Override
	protected void doListado() throws Exception {
		depto = new DepartmentDAO().getByCode(num);

		this.newLine();
		this.addColumn("Total").addColumn(depto.getTotalSalaries()).newLine();
		this.newLine();
		
		this.addColumn("Nombre");
		this.addColumn("Titulo");
		this.addColumn("Monto");
		this.newLine();

		for (Employee e : depto.getEmployees()) {
			this.addColumn(e.getFullName());
			this.addColumn(e.getTitle());
			this.addColumn(e.getSalary());
			this.newLine();
		}
	}

	@Override
	public String getFilename() {
		return "./target/PagosPorDepto.csv";
	}
}
