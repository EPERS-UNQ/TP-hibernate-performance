package unq.tpi.persistencia;

import java.text.SimpleDateFormat;

import junit.framework.TestCase;
import unq.tpi.persistencia.performanceEj.daos.EmployeeDAO;
import unq.tpi.persistencia.performanceEj.model.Employee;
import unq.tpi.persistencia.performanceEj.model.Gender;
import unq.tpi.persistencia.util.Operation;
import unq.tpi.persistencia.util.SessionManager;

public class EmployeeTest extends TestCase {

	public void testFields() throws Exception {
		SessionManager.runInSession(new Operation<Object>() {
			public Object execute() {
				try {
					Employee e = new EmployeeDAO().getByName("Parto", "Hitomi");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

					assertNotNull(e);
					assertEquals(11052, e.getId());
					assertEquals(sdf.parse("1960-03-16"), e.getBirthDate());
					assertEquals(Gender.F, e.getGender());
					assertEquals(sdf.parse("1988-11-11"), e.getHireDate());
					assertEquals(0,e.getDepartments().size());
					assertNull(e.getDepartment());
					assertEquals(2,e.getHistoricDepartments().size());
					assertNull(e.getTitle());					
					assertEquals(1,e.getHistoricTitles().size());	
					assertEquals(51339.0, e.getSalary());
					return null;
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});
	}
}
