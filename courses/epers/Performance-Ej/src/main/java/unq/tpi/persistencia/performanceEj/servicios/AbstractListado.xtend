package unq.tpi.persistencia.performanceEj.servicios

import java.io.FileWriter
import java.io.IOException

import unq.tpi.persistencia.util.Operation
import unq.tpi.persistencia.util.SessionManager
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
abstract class AbstractListado {
	protected FileWriter fw

	new () {
		super()
	}

	protected def String getFilename()

	protected abstract def void doListado() throws Exception

	def addColumn(String col) throws Exception {
		fw.append('"').append(col).append('"').append("")
		this
	}

	def addColumn(Number col) throws Exception {
		fw.append(String.valueOf(col)).append("")
		this
	}
	
	def newLine() throws Exception{
		fw.append("\n")
		this
	}
	
	def void listado() {
		SessionManager.runInSession(new Operation<Object>() {

			override def StringBuilder execute() {
				fw = null
				try {
					fw = new FileWriter(getFilename())
					doListado()
				} catch (Exception e) {
					throw new RuntimeException(e)
				} finally {
					if (fw != null)
						try {
							fw.close()
						} catch (IOException e) {
						}
				}
	
				return null
			}
		})
	}

}