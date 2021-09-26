package com.ent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = { "", "cinema" })
public class CinemaWebController {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "index";
	}

}