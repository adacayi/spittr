package com.sanver.trials.spittr.home;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping(value = { "", "index", "homepage" }, method = GET)
	public String home() {
		return "home";
	}
}
