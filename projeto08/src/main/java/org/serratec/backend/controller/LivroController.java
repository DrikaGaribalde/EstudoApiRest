package org.serratec.backend.controller;

import java.util.List;

import org.serratec.backend.entity.LivroEntity;
import org.serratec.backend.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class LivroController {

	@Autowired
	LivroService service;
	
	@GetMapping("/listarLivros")
	public List<LivroEntity> findAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public LivroEntity findById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	@PostMapping("/salvarLivros")
	public LivroEntity create(@RequestBody LivroEntity livro) {
		return service.create(livro);
	}
	
	@PutMapping("/atualizarLivros")
	public LivroEntity update(@RequestBody LivroEntity livro) {
		return service.update(livro);
	}
	
	@DeleteMapping("/deletarLivros/{id}")
	public String delete(@PathVariable Long id) {
		 return service.delete(id);
	}
//	//Bonus
//	@GetMapping("/buscarLivros/{nome}")
//	public List<LivroEntity> buscarLivros(@PathVariable String nome){
//		return service.buscar(nome);
//	}
	
}
