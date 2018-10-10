package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/employee")
public class EmployeeController {
	
	@RequestMapping("add.do")
	public String addController() {
		return "admin.employee.add";
	}
	
	
	
	
}
