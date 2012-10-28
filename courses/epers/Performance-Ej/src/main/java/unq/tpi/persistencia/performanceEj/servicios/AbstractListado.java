package unq.tpi.persistencia.performanceEj.servicios;

import java.io.FileWriter;
import java.io.IOException;

import unq.tpi.persistencia.util.Operation;
import unq.tpi.persistencia.util.SessionManager;

public abstract class AbstractListado {

	public AbstractListado() {
		super();
	}

	protected abstract String getFilename();

	protected abstract void doListado() throws Exception;
	protected FileWriter fw;

	protected AbstractListado addColumn(String col) throws Exception {
		fw.append('"').append(col).append('"').append(";");
		return this;
	}

	protected AbstractListado addColumn(Number col) throws Exception {
		fw.append(String.valueOf(col)).append(";");
		return this;
	}
	
	protected AbstractListado newLine() throws Exception{
		fw.append("\n");
		return this;
	}
	
	public void listado() {
		SessionManager.runInSession(new Operation<Object>() {

			public StringBuilder execute() {
				fw = null;
				try {
					fw = new FileWriter(getFilename());
					doListado();
				} catch (Exception e) {
					throw new RuntimeException(e);
				} finally {
					if (fw != null)
						try {
							fw.close();
						} catch (IOException e) {
						}
				}
	
				return null;
			}
		});
	}

}