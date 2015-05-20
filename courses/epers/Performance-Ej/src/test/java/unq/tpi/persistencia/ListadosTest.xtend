package unq.tpi.persistencia;

import org.junit.Test
import unq.tpi.persistencia.performanceEj.servicios.ListadoDeptos
import unq.tpi.persistencia.performanceEj.servicios.ListadoDetalleEmpleado
import unq.tpi.persistencia.performanceEj.servicios.ListadoMaximosSalarios
import unq.tpi.persistencia.performanceEj.servicios.ListadoPagosPorDepto

class ListadosTest {
	
	@Test
	def void testListadoPagosPorDepto() {
		new ListadoPagosPorDepto("d007").listado();
	}
	
	@Test
	def void testListadoDeptos(){
		new ListadoDeptos().listado();
	}
	
	@Test
	def void testListadoMaximosSalarios() {
		new ListadoMaximosSalarios().listado();
	}
	
	@Test
	def void testDetalleEmpleado() {
		new ListadoDetalleEmpleado(10010).listado();
		new ListadoDetalleEmpleado(10019).listado();
	}
}
