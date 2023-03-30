package com.example.demo.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.example.demo.models.Cliente;
import com.example.demo.repositories.ClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("cliente/index");
				
		List<Cliente> listaCliente = clienteRepository.findAll();
		
		model.addObject("cliente", listaCliente);
		return model;
	}
	

	
	@GetMapping("/create") 
	public String create() {
		
		return "cliente/create";
	}
	
	@PostMapping("/create") // Pega os dados inseridos na página para utilizar no método
	public String create(@ModelAttribute("cliente") Cliente objCliente) {
	
		
		clienteRepository.save(objCliente);
		
		return "redirect:/cliente";
	}

}
