package demo.springboot.swagger.employee;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/employees")
public class EmployeeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	@Autowired
	EmployeeService employeeService;
	 
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<EmployeeDto>> employees() {
		
		List<EmployeeDto> dtoList = employeeService.employees();
		
		return new ResponseEntity<>(dtoList, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<EmployeeDto> get(@PathVariable String id) {
		
		EmployeeDto dto = employeeService.get(Long.parseLong(id));
		
		return new ResponseEntity<EmployeeDto>(dto, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody EmployeeDto employeeDto) {
		
		employeeService.create(employeeDto);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		
		employeeService.delete(Long.parseLong(id));
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}

}

