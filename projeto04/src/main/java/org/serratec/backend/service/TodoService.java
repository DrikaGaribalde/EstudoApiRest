package org.serratec.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.entity.TodoEntity;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

	List<TodoEntity> lista = new ArrayList<TodoEntity>();

	// GET
	public List<TodoEntity> listaTarefas() {
		return lista;
	}

	// POST
	public String criarTarefas(TodoEntity tarefa) {
		lista.add(tarefa);
		return "ok";
	}

	// PROCURAR
	public TodoEntity procurarTarefas(Integer id) {
		for (TodoEntity todoEntity : lista) {
			if (todoEntity.getId() == id) {
				return todoEntity;
			}
		}
		System.out.println("Id não encontrado");
		return null;
	}

	// UPDATE
	public TodoEntity atualizarTarefas(Integer id, String nome, String descricao) {
		for (TodoEntity todoEntity : lista) {
			if (todoEntity.getId() == id) {
				todoEntity.setNome(nome);
				todoEntity.setDescricao(descricao);
				return todoEntity;
			}
		}
		System.out.println("Id não encontrado");
		return null;
	}
	
	// DELETE
	public String deletarTarefas(Integer id) {
		for (TodoEntity todoEntity : lista) {
			if (todoEntity.getId() == id) {
				lista.remove(todoEntity);
				return "id excluído";
			}
		}
		System.out.println("Id não encontrado");
		return null;
	}
}
