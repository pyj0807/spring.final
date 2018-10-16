package app.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.WebRequest;

import app.model.EmployeeDao;
import app.service.SocketService;

@Controller
public class IndexController {
	Map<String, HttpSession> sessions;
	
	public IndexController() {
		sessions = new HashMap<>();
	}
	
	
	
	@Autowired
	EmployeeDao edao;
	
	@Autowired
	SocketService socketService;
	
	@GetMapping("/index.do")
	public String getindexHandle(WebRequest web) {
		System.out.println("index 들어옴");
		
		if(web.getAttribute("auth", web.SCOPE_SESSION) == null) {
			return "index";
		} else {
			return "guest.home";		// /WEB-INF/tiles 에있는 xml 의 name
					
		}
	}
	
	@PostMapping("/login.do")
	public String loginHandle(WebRequest wr, ModelMap map, HttpSession session) {
		System.out.println("login.do 들어옴");
		String id = (String)wr.getParameter("id");
		String pass = (String)wr.getParameter("pass");
		
		Map data = new HashMap<>();
		data.put("id", id);
		data.put("pass", pass);
		
		Map log = edao.loginck(data);
		
		if(log != null) {
			// 중복로그인=========================================
			if(sessions.containsKey(id)) {
				sessions.get(id).invalidate();
				Map mg = new HashMap<>();
				mg.put("mode", "relogin");
				socketService.sendAll(mg);
			}
			
			sessions.put(id, session);
			
			//============================================================
			Map one = edao.getEmployee(id);
			wr.setAttribute("auth", true, wr.SCOPE_SESSION);
			wr.setAttribute("id", id, wr.SCOPE_SESSION);
			wr.setAttribute("user", one, wr.SCOPE_SESSION);
			
			Map msg = new HashMap<>();
			msg.put("mode", "login");
			msg.put("actor", one);
			
			socketService.sendAll(msg);
			socketService.sendAll(one);
			System.out.println("one : " +one);
			System.out.println("msg : " +msg);
			//socketService.sendOne(msg, "em1004");
			
			return "redirect:/index.do";
		} else {
			map.put("err", "on");
			return "index";
		}
	}
	
	/*
	@RequestMapping("/login.do")
	public String loginHandle(WebRequest webRequest, @RequestParam Map p, HttpSession session) {
		int cnt = edao.loginck(p);
		if(cnt > 0) {
			// 중복로그인 막기 =======================================
			String id =(String)p.get("id");
			if(sessions.containsKey(id)) {
				sessions.get(id).invalidate();
			}
			
			sessions.put(id, session);
			//========================================================
			Map one = edao.getEmployee(id);
			webRequest.setAttribute("userId", id, WebRequest.SCOPE_SESSION);
			
			webRequest.setAttribute("user", one, WebRequest.SCOPE_SESSION);
			webRequest.setAttribute("auth", "on", WebRequest.SCOPE_SESSION);
			
			
			Map msg = new HashMap<>();
				msg.put("mode", "login");
				msg.put("actor", one);
			socketService.sendAll(msg);
			// socketService.sendOne(msg, "em1000");
		}
		return "redirect:/";		// redirect:/index.do	
	}
	*/
	@RequestMapping("logout.do")
	public String logoutHandle(@SessionAttribute String id,  HttpSession hs) {
		
		sessions.remove(id);
		hs.invalidate();
		return "redirect:/index.do";
	}

}
