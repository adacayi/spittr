package com.sanver.trials.spittr.spitter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sanver.trials.spittr.Spitter;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	private SpitterRepository repository;

	@RequestMapping(value = "/register", method = GET)
	public String register() {
		return "registerForm";
	}

	@RequestMapping(value = "/register", method = POST)
	public String register(Spitter spitter) {
		repository.save(spitter);
		return "redirect:/spitter/" + spitter.getUsername();
	}

	@Autowired
	public SpitterController(SpitterRepository repository) {
		this.repository = repository;
	}
}
