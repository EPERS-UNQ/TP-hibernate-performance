package unq.tpi.persistencia;

import java.text.SimpleDateFormat;

import junit.framework.TestCase;
import unq.tpi.persistencia.performanceEj.daos.DepartmentDAO;
import unq.tpi.persistencia.performanceEj.model.Department;
import unq.tpi.persistencia.util.Operation;
import unq.tpi.persistencia.util.SessionManager;

public class DepartmentTest extends TestCase {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public void testFields() throws Exception {
		SessionManager.runInSession(new Operation<Object>() {
			public Object execute() {
				Department d = new DepartmentDAO().getByName("Finance");		
				
				assertNotNull(d);
				assertEquals("d002", d.getNumber());
				assertEquals(12437, d.getEmployees().size());
				assertEquals(4909, d.getHistoricEmployees().size());
				
				return null;
			}
		});
	}
}
