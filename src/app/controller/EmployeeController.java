package app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.model.EmployeeDao;

@Controller
@RequestMapping("/admin/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeDao edao;
	
	@GetMapping("/add.do")
	public String addGetHandle(ModelMap map) {
		map.put("dep", edao.getDeparments());
		map.put("pos", edao.getPositions());
		
		return "admin.employee.add";
	}
	
	@PostMapping("/add.do")
	public String addPostHandle(@RequestParam Map param, ModelMap map) {
		
		String nid = edao.getNewEmployeeId();
		param.put("id", nid);
		
		try {
			int t = edao.addEmployee(param);
			map.put("employee", param);
			return "admin.employee.addresult";
		} catch (Exception e) {
			e.printStackTrace();
			map.put("err", "on");
			map.put("dep", edao.getDeparments());
			map.put("pos", edao.getPositions());
			return "admin.employee.add";
		}
			
	}
	
	
	/*	
	@GetMapping("/add.do")
	public String addController(ModelMap modelMap) {
		List<Map> li = edao.getDeparments();
		System.out.println("department : "+li);
		modelMap.put("de", li);
		
		
		return "admin.employee.add";
	}
	*/
	
/*	@GetMapping("/add.do")
	public String addPoController(ModelMap modelMap) {
		List<Map> lii = edao.getPositions();
		System.out.println("positions : "+lii);
		modelMap.put("po", lii);
		
		
		return "admin.employee.add";
	}
	*/
}
