package demo.springboot.swagger.employee;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service(value="employeeService")
public class EmployeeService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static LinkedList<EmployeeDto> employeeList;
	
	static {
		
		employeeList = new LinkedList<EmployeeDto>();
		
		employeeList.add(new EmployeeDto(1L, "Lorem1", "Ipsum1", "email1.email.com"));
		employeeList.add(new EmployeeDto(2L, "Lorem2", "Ipsum2", "email2.email.com"));
		employeeList.add(new EmployeeDto(3L, "Lorem3", "Ipsum3", "email3.email.com"));
		
	}
	 
	 
	public List<EmployeeDto> employees() {
		return employeeList;
	}
		
	public EmployeeDto get(Long id) {
		
		EmployeeDto empToreturn = null;
		Optional<EmployeeDto> employee = 
			employeeList.stream().filter((emp) -> emp.getId().equals(id)).findFirst();
		
		if(employee.isPresent()) {
			empToreturn = employee.get();
		}
		
		return empToreturn;
	}
	
	public Integer create(EmployeeDto employeeDto) {
		employeeList.add(employeeDto);
		return 1;
	}
	
	public Integer delete(Long id) {
		
		Optional<EmployeeDto> employee = 
			employeeList.stream().filter((emp) -> emp.getId().equals(id)).findFirst();
		
		if(employee.isPresent()) {
			employeeList.remove(employee.get());
			return 1;
		}
		
		return 0;
	}

}
