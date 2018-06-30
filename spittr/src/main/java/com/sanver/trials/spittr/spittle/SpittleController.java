package com.sanver.trials.spittr.spittle;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

	private SpittleRepository spittleRepository;

	@Autowired
	public SpittleController(SpittleRepository repository) {
		this.spittleRepository = repository;
	}

	@RequestMapping(method = GET)
	public String spittles(Model model, @RequestParam(value = "max", defaultValue = "" + Long.MAX_VALUE) long max,
			@RequestParam(value = "count", defaultValue = "20") int count) {
		model.addAttribute(spittleRepository.findSpittles(max, count));
		return "spittles";
	}

	@RequestMapping(value = "/{id}", method = GET)
	public String spittle(Model model, @PathVariable long id) {
		model.addAttribute(spittleRepository.findOne(id));
		return "spittle";
	}
}
