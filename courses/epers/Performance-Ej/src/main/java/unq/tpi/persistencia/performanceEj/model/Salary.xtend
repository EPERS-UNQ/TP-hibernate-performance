package unq.tpi.persistencia.performanceEj.model

import java.io.Serializable
import java.util.Date
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
public class Salary implements Serializable{
	Employee employee
	Double amount
	Date from
	Date to
}
