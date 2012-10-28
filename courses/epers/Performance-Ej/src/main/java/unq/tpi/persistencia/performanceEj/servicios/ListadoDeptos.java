package unq.tpi.persistencia.performanceEj.servicios;

import java.util.List;

import unq.tpi.persistencia.performanceEj.daos.DepartmentDAO;
import unq.tpi.persistencia.performanceEj.model.Department;

public class ListadoDeptos extends AbstractListado {

	@Override
	protected String getFilename() {
		return "./target/Deptos.csv";
	}

	@Override
	protected void doListado() throws Exception {
		List<Department> deptos = new DepartmentDAO().getAll();
		this.addColumn("Codigo").addColumn("Nombre").addColumn("Manager").newLine();
		
		for(Department d: deptos){
			addColumn(d.getNumber());
			addColumn(d.getName());
			addColumn(d.getManager().getFullName());
			newLine();
		}
	}

}
