package desafio3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Teste {
	
	@RequestMapping("/teste")
	public String ola(){
		return "Ola, de novo mundo!";
	}
}
