package unq.tpi.persistencia.performanceEj.servicios;

import java.text.SimpleDateFormat;
import java.util.Date;

import unq.tpi.persistencia.performanceEj.daos.EmployeeDAO;
import unq.tpi.persistencia.performanceEj.model.Employee;
import unq.tpi.persistencia.performanceEj.model.Salary;

public class ListadoDetalleEmpleado extends AbstractListado {

	private int num;
	
	public ListadoDetalleEmpleado(int num) {
		super();
		this.num = num;
	}

	@Override
	protected String getFilename() {
		return "./target/DetalleEmpleado-" + num +  ".csv";
	}

	@Override
	protected void doListado() throws Exception {
		Employee e = new EmployeeDAO().getByCode(num);
		
		addColumn("Codigo").addColumn(e.getId()).newLine();
		addColumn("Nombre").addColumn(e.getFirstName()).newLine();
		addColumn("Departamento").addColumn(e.getDepartment().getName()).newLine();
		addColumn("Manager").addColumn(e.getDepartment().getManager().getFullName()).newLine();
		addColumn("Salario Actual").addColumn(e.getSalary()).newLine();
		addColumn("Cargo").addColumn(e.getTitle()).newLine();
		newLine();
		
		addColumn("Salario Historico").newLine();
		
		addColumn("Salario").addColumn("Desde").addColumn("Hasta").newLine();
		for(Salary s:e.getSalaries()){
			addColumn(s.getAmount());
			addColumn(s.getFrom());
			addColumn(s.getTo());
			newLine();
		}
	}

	private void addColumn(Date date) {
		try {
			this.addColumn(new SimpleDateFormat("dd-MM-yyyy").format(date));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
