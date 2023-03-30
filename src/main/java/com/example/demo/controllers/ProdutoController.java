package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.example.demo.models.Produto;
import com.example.demo.repositories.ProdutoRepository;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("produto/index");
				
		List<Produto> listaProduto = produtoRepository.findAll();
		
		model.addObject("produto", listaProduto);
		return model;
	}
	
	
	@GetMapping("/create") 
	public String create() {
		
		return "produto/create";
	}
	
	@PostMapping("/create") // Pega os dados inseridos na página para utilizar no método
	public String create(@ModelAttribute("produto") Produto objProduto) {
	
		
		produtoRepository.save(objProduto);
		
		return "redirect:/produto";
		
	}
	
	

}
