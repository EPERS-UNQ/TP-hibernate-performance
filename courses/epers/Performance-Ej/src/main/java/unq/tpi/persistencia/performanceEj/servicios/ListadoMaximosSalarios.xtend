package unq.tpi.persistencia.performanceEj.servicios

import java.util.Comparator
import unq.tpi.persistencia.performanceEj.daos.EmployeeDAO
import unq.tpi.persistencia.performanceEj.model.Employee

class ListadoMaximosSalarios extends AbstractListado{

	override def getFilename() {
		"./target/MaximosSalarios.csv"
	}

	override def doListado() throws Exception {
		val empleados = new EmployeeDAO().getAll()
		empleados.sort(new Comparator<Employee>() {
			override def compare(Employee o1, Employee o2) {
				o2.salary.compareTo(o1.salary)
			}
		})
		
		addColumn("Nombre").addColumn("Sueldo").newLine()
		
		(0..10).forEach[
			val e = empleados.get(it)
			addColumn(e.fullName).addColumn(e.salary).newLine()
		]
	}
}
