package unq.tpi.persistencia.performanceEj.servicios

import unq.tpi.persistencia.performanceEj.daos.EmployeeDAO
import java.util.Date
import java.text.SimpleDateFormat

class ListadoDetalleEmpleado extends AbstractListado {

	private int num
	
	new(int num) {
		super()
		this.num = num
	}

	override String getFilename() {
		return "./target/DetalleEmpleado-" + num +  ".csv"
	}

	override doListado() throws Exception {
		val e = new EmployeeDAO().getByCode(num)
		
		addColumn("Codigo").addColumn(e.id).newLine()
		addColumn("Nombre").addColumn(e.firstName).newLine()
		addColumn("Departamento").addColumn(e.department.name).newLine()
		addColumn("Manager").addColumn(e.department.manager.fullName).newLine()
		addColumn("Salario Actual").addColumn(e.salary).newLine()
		addColumn("Cargo").addColumn(e.title).newLine()
		newLine()
		
		addColumn("Salario Historico").newLine()
		
		addColumn("Salario").addColumn("Desde").addColumn("Hasta").newLine()
		e.salaries.forEach[
			addColumn(it.amount)
			addColumn(it.from)
			addColumn(it.to)
			newLine()
		]
	}

	def addColumn(Date date) {
		try {
			this.addColumn(new SimpleDateFormat("dd-MM-yyyy").format(date))
		} catch (Exception e) {
			throw new RuntimeException(e)
		}
	}

}
