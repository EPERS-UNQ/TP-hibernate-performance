package unq.tpi.persistencia;

import java.text.SimpleDateFormat;

import junit.framework.TestCase;
import unq.tpi.persistencia.performanceEj.daos.EmployeeDAO;
import unq.tpi.persistencia.performanceEj.model.Employee;
import unq.tpi.persistencia.performanceEj.model.Gender;
import unq.tpi.persistencia.util.Operation;
import unq.tpi.persistencia.util.SessionManager;
import org.junit.Test
import org.junit.Assert

class EmployeeTest {

	@Test
	def void testFields() throws Exception {
		SessionManager.runInSession(new Operation<Object>() {
			override def execute() {
				try {
					val e = new EmployeeDAO().getByName("Parto", "Hitomi");
					val sdf = new SimpleDateFormat("yyyy-MM-dd");

					Assert.assertNotNull(e);
					Assert.assertEquals(11052, e.id);
					Assert.assertEquals(sdf.parse("1960-03-16"), e.birthDate);
					Assert.assertEquals(Gender.F, e.gender);
					Assert.assertEquals(sdf.parse("1988-11-11"), e.hireDate);
					Assert.assertEquals(0,e.departments.length);
					Assert.assertNull(e.department);
					Assert.assertEquals(2,e.historicDepartments.length);
					Assert.assertNull(e.title);					
					Assert.assertEquals(1,e.historicTitles.length);	
					Assert.assertEquals(51339.0, e.salary, 0);
					return null;
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});
	}
}
