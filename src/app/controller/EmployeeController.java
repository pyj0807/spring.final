package app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

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
	@GetMapping("/index.do")
	public String GetindexHandle(WebRequest web) {
		System.out.println("index에 들어왔어요");
		
		if(web.getAttribute("auth", web.SCOPE_SESSION) == null) {
			return "index";
		} else {
			return "admin.employee.home";
					
		}
	}
	
	@PostMapping("/login.do")
	public String loginHandle(WebRequest wr, ModelMap map) {
		System.out.println("login.do 들어옴");
		String id = (String)wr.getParameter("id");
		String pass = (String)wr.getParameter("pass");
		
		Map data = new HashMap<>();
		data.put("id", id);
		data.put("pass", pass);
		
		Map log = edao.loginck(data);
		
		if(log != null) {
			wr.setAttribute("auth", true, wr.SCOPE_SESSION);
			wr.setAttribute("id", id, wr.SCOPE_SESSION);
			return "redirect:/admin/employee/index.do";
		} else {
			map.put("err", "on");
			return "index";
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
