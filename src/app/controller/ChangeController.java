package app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import app.model.ChangeDao;
import app.service.SocketService;

@Controller
public class ChangeController {

	@Autowired
	ChangeDao cdao;
	
	@Autowired
	SocketService service;
	
	@Autowired
	Gson gson;
	
	@GetMapping("/change.do")
	public String changeHandle(WebRequest wr) {
		System.out.println("change옴");
		String id = (String)wr.getParameter("id");
		if(wr.getAttribute("auth",wr.SCOPE_REQUEST)==id) {
			return "change.home";
		}else {
			return "guest.home";
		}
	}
	
	
	@PostMapping("/change.do")
	public String changPostHandle(WebRequest wr) {
		String id = (String)wr.getParameter("id");
		String pass = (String)wr.getParameter("pass");
		Map data = new HashMap<>();
		data.put("id", id);
		data.put("pass", pass);
		
		if(wr.getAttribute("auth",wr.SCOPE_REQUEST)==id ) {
			int i = cdao.setPass(data);
			
		}
			
		
		return "";
		
				
	}
	

}
