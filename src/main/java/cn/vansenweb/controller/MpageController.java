package cn.vansenweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MpageController {

	@RequestMapping("/mpage")
	public String mpage() {
		return "mpage";
	}
		
}
