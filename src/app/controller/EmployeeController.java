package app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.model.EmployeeDao;

@Controller
@RequestMapping("/admin/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeDao edao;
	
	@GetMapping("/add.do")
	public String addController(ModelMap modelMap) {
		List<Map> li = edao.getDeparments();
		System.out.println("department : "+li);
		modelMap.put("de", li);
		
		
		return "admin.employee.add";
	}
	
	
	
	
}
