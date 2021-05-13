package com.lucena.contatos.controller;

import java.util.List;

import com.lucena.contatos.model.Contato;
import com.lucena.contatos.repository.Contatos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContatosController {
	
	@Autowired
	private Contatos contatos;
	
	@RequestMapping("/")
	public ModelAndView listar() {
		List<Contato> lista = contatos.findAll();
		
		ModelAndView modelAndView = new ModelAndView("contatos");		
		modelAndView.addObject("contatos", lista);
		
		return modelAndView;
	}

	@RequestMapping(value="/contato/{id}", method=RequestMethod.GET)
	public ModelAndView detalhesContato(@PathVariable("id") long id){
		Contato contato = contatos.findById(id).get();

		ModelAndView modelAndView = new ModelAndView("detalhesContato");
		modelAndView.addObject("contato", contato);
		
		return modelAndView;
	}

}