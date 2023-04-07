package com.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@RequestMapping("/cliente")
	public String cliente() {
		return "cliente";
	}
	
	@RequestMapping("/server")
	public String server() {
		return "server";
	}

}
