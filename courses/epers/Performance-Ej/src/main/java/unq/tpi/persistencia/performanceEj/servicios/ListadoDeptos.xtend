package unq.tpi.persistencia.performanceEj.servicios

import unq.tpi.persistencia.performanceEj.daos.DepartmentDAO

class ListadoDeptos extends AbstractListado {

	override String getFilename() {
		return "./target/Deptos.csv"
	}

	override doListado() throws Exception {
		val deptos = new DepartmentDAO().getAll()
		this.addColumn("Codigo").addColumn("Nombre").addColumn("Manager").newLine()
		deptos.forEach[
			addColumn(it.number)
			addColumn(it.name)
			addColumn(it.manager.fullName)
			newLine()
		]
	}

}
