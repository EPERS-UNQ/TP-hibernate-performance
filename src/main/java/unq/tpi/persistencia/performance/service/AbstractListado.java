package unq.tpi.persistencia.performance.service;

import org.omg.SendingContext.RunTime;
import unq.tpi.persistencia.performance.service.runner.Runner;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase base para la generacion de reportes.
 * 
 * Las clases concretas extenderan AbstractListado y proveeran una
 * implementacion al metodo "doListado".
 */
public abstract class AbstractListado {

	public static final String COLUMN_SEPARATOR = "\t";
	public static final String LINE_SEPARATOR = "\n";

	private String filename;
	private FileWriter fw;

	public AbstractListado(String filename) {
		this.filename = filename;
	}

	/**
	 * Los clientes invocaran este metodo para generar un listado nuevo.
	 * Este metodo no es thread-safe.
	 */
	public void generarListado() {
		Runner.runInSession(() -> {
			try {
				this.openFileWriter();
				this.doListado();
				return null;
			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				this.closeFileWriter();
			}
		});
	}

	/**
	 * Este metodo sera invocado por generarListado (tempateMethod) en el
	 * contexto de una session de hibernate.
	 * 
	 * Las implementaciones de este metodo deberan interactuar con los metodos
	 * addColumn y newLine para generar el reporte de forma correcta.
	 */
	protected abstract void doListado() ;

	private void openFileWriter() {
		try {
			this.fw = new FileWriter(this.filename);
		} catch (IOException e) {
			throw  new RuntimeException(e);
		}
	}

	private void closeFileWriter() {
		if (this.fw != null) {
			try {
				this.fw.close();
			} catch (IOException e) {
				throw new RuntimeException("Problemas al cerrar el archivo", e);
			}
		}
	}

	protected AbstractListado addColumn(String col) {
		try {
			this.fw.append('"').append(col).append('"').append(COLUMN_SEPARATOR);
			return this;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected AbstractListado addColumn(Number col) {
		try {
			this.fw.append(String.valueOf(col)).append(COLUMN_SEPARATOR);
			return this;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected AbstractListado addColumn(Date date) {
		try {
			this.addColumn(new SimpleDateFormat("dd-MM-yyyy").format(date));
			return this;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected AbstractListado newLine() {
		try {
			this.fw.append(LINE_SEPARATOR);
			return this;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}



}