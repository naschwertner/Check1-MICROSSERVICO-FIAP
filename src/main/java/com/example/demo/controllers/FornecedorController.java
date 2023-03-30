package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Categoria;
import com.example.demo.models.Fornecedor;
import com.example.demo.repositories.FornecedorRepository;

@Controller
@RequestMapping("/paginas") // Mapeia a página que estamos rodando
public class FornecedorController {
	
	
	@Autowired
	private FornecedorRepository fornecedorRepository;

	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("paginas/index");
				
		List<Fornecedor> listaFornecedor = fornecedorRepository.findAll();
		
		model.addObject("fornecedor", listaFornecedor);
		return model;
	}
	

	
	@GetMapping("/create") 
	public String create() {
		
		return "paginas/create";
	}
	
	@PostMapping("/create") // Pega os dados inseridos na página para utilizar no método
	public String create(@ModelAttribute("paginas") Fornecedor objFornecedor) {
	
		
		fornecedorRepository.save(objFornecedor);
		
		return "redirect:/paginas";
	}
	

	
	
}
