package unq.tpi.persistencia.performanceEj.servicios

import unq.tpi.persistencia.performanceEj.daos.DepartmentDAO
import unq.tpi.persistencia.performanceEj.model.Department

class ListadoPagosPorDepto extends AbstractListado {

	String num
	Department depto = null

	new(String num) {
		this.num = num
	}

	override def doListado() throws Exception {
		depto = new DepartmentDAO().getByCode(num)

		newLine()
		addColumn("Total").addColumn(depto.totalSalaries).newLine()
		newLine()
		
		addColumn("Nombre")
		addColumn("Titulo")
		addColumn("Monto")
		newLine()

		depto.employees.forEach[
			addColumn(it.fullName)
			addColumn(it.title)
			addColumn(it.salary)
			newLine()
		]
	}

	override def getFilename() {
		"./target/PagosPorDepto.csv"
	}
}
