package app.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.WebRequest;

import app.model.EmployeeDao;

@Controller
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	EmployeeDao edao;
	
	
	@RequestMapping("/send.do")
	public String sendHandle() {
		return "guest.send";
	}
	/*
	@PostMapping("/send.do")
	public void msgHandle(WebRequest wr, HttpSession session,@RequestParam Map map) {
		
		Map one = edao.setMessage();
	}
	*/
	//저장
	@RequestMapping("/message.do")
	public String sendmsgHandle(@RequestParam Map map, WebRequest wr) {
		System.out.println(map);
		String sender = (String)wr.getAttribute("id",wr.SCOPE_SESSION);
		map.put("sender", sender);
		int t = edao.setMessage(map);
		if(t == 1) {
			return "guest.messagebox";
		}else {
			return "guest.send";
		}
	}
	
	@RequestMapping("/box.do")
	public String boxHandle(WebRequest wr, ModelMap map) {
		List<Map> li = edao.getMessage((String)wr.getAttribute("id", wr.SCOPE_SESSION));
		map.put("remsg", li);
		return "guest.messagebox";
	}
	
	
	@RequestMapping("/view.do")
	public String viewHandle(WebRequest wr, ModelMap map) {
		
		int no= Integer.parseInt(wr.getParameter("no").toString());
		System.out.println(no);
		
		edao.upcho(no);
		
		
		
		return "guest.content";
	}
	
	
	
}
