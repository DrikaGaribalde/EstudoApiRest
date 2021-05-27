package org.serratec.backend.controller;

import java.util.List;

import org.serratec.backend.entity.TodoEntity;
import org.serratec.backend.service.TodoService;
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
@RequestMapping("/Todo")
public class TodoController {

	@Autowired
	TodoService service;

	@PostMapping("/criarTarefas")
	public String criarTarefas(@RequestBody TodoEntity tarefa) {
		return service.criarTarefas(tarefa);
	}

	@GetMapping("/listar")
	public List<TodoEntity> lista() {
		return service.listaTarefas();
	}

	@GetMapping("/procurar/{id}")
	public TodoEntity procurar(@PathVariable Integer id) {
		return service.procurarTarefas(id);
	}
	//atualizarTarefas
	@PutMapping("/atualizar/{id}/{nome}/{descricao}")
	public TodoEntity atualizar(@PathVariable Integer id, @PathVariable String nome, @PathVariable String descricao) {
		return service.atualizarTarefas(id,nome,descricao);
	}
	
	//deletarTarefas
	@DeleteMapping("/deletar/{id}")
	public String deletar(@PathVariable Integer id) {
		return service.deletarTarefas(id);
	}
	
}