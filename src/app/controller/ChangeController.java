package app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.WebRequest;

import com.google.gson.Gson;

import app.model.ChangeDao;
import app.model.EmployeeDao;
import app.service.SocketService;

@Controller
public class ChangeController {

	@Autowired
	ChangeDao cdao;
	
	@Autowired
	EmployeeDao edao;
	
	@Autowired
	SocketService service;
	
	
	@GetMapping("/change.do")
	public String changeGetHandle(WebRequest wr) {
		System.out.println("change옴");
		String id = (String)wr.getParameter("id");
		String pass = (String)wr.getParameter("pass");
		if(wr.getAttribute("auth",wr.SCOPE_REQUEST)==id) {
			return "change.home";
		}else {
			return "guest.home";
		}
	}
	
	/*
	@PostMapping("/change.do")
	public String changPostHandle(WebRequest wr) {
		String id = (String)wr.getParameter("id");
		String pass = (String)wr.getParameter("pass");
		Map one = edao.getEmployee(id);
		
		System.out.println(one);
		

		if(wr.getAttribute("auth",wr.SCOPE_REQUEST) == id ) {
			
		}
			
		return "";
		
	}
	*/
	@PostMapping("/change.do")
	public String modifyPostHandle(@SessionAttribute Map user, @RequestParam Map map, ModelMap model) {
		String id = (String)user.get("pass");
		String pa = (String)map.get("opass");
		if(pa.equals(id)) {
			map.put("id", user.get("ID"));
			int r = cdao.setPass(map);
			if(r>0) {
				return "redirect:/index.do";
			}
		}
		model.put("err", "on");
		return "guest.change";
	}
	
}
