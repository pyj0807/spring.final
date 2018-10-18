package app.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.WebRequest;

import app.model.EmployeeDao;

@Controller
@RequestMapping("/chat")
public class MessageController {
	
	@Autowired
	EmployeeDao edao;
	
	@RequestMapping("/message.do")
	public String msgHandle(WebRequest web) {
		System.out.println("message.do에 들어옴");
		if(web.getAttribute("auth", web.SCOPE_SESSION) == null) {
			return "";
		}else {
			return "index";
		}
	}
}
