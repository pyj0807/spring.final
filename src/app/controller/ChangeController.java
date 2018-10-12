package app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import app.model.ChangeDao;

@Controller
public class ChangeController {

	@Autowired
	ChangeDao cdao;

	@GetMapping("/change.do")
	public String changeHandle(@RequestParam Map map, WebRequest wr) {
		
		System.out.println(map);
		return "";
	}
}

