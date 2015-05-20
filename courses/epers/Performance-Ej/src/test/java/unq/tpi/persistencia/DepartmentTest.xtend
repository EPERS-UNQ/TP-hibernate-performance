package unq.tpi.persistencia;

import org.junit.Assert
import org.junit.Test
import unq.tpi.persistencia.performanceEj.daos.DepartmentDAO
import unq.tpi.persistencia.util.Operation
import unq.tpi.persistencia.util.SessionManager

class DepartmentTest {

	@Test
	def void testFields() throws Exception {
		SessionManager.runInSession(new Operation<Object>() {
			override def execute() {
				val d = new DepartmentDAO().getByName("Finance");		
				Assert.assertNotNull(d);
				Assert.assertEquals("d002", d.number);
				Assert.assertEquals(12437, d.employees.length);
				Assert.assertEquals(4909, d.historicEmployees.length);
				return null;
			}
		});
	}
}
