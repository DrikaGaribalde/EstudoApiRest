package org.serratec.backend.service;

import java.util.List;

import org.serratec.backend.entity.LivroEntity;
import org.serratec.backend.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
	
	@Autowired
	LivroRepository repository;
	
	public List<LivroEntity> getAll() {
		 return repository.findAll();
	}
	
	public LivroEntity getById(Long id) {
		return repository.getById(id);
	}
	
	public LivroEntity create(LivroEntity livro) {
		return repository.save(livro);
	}

	public LivroEntity update(LivroEntity livro) {
		
		LivroEntity livros = repository.getById(livro.getId());
		livros.setAutor(livro.getAutor());
		livros.setTipo(livro.getTipo());
		livros.setTitulo(livro.getTitulo());
		livros.setData(livro.getData());
		
		return repository.saveAndFlush(livros);
	}
	
	public String delete(Long id) {
		repository.deleteById(id);
		return "Registro deletado com sucesso";
	}
	
//	public List<LivroEntity> buscar(String nome){
//		return repository.buscarLivro(nome);
//	}
}
