package com.fausto.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fausto.bookstore.domain.Categoria;
import com.fausto.bookstore.dtos.CategoriaDTO;
import com.fausto.bookstore.exceptions.DataIntegrityViolationException;
import com.fausto.bookstore.exceptions.ObjectNotFoundException;
import com.fausto.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id+", Tipo: "+ Categoria.class.getName()));
	}
	
	public List<Categoria> findAll() {
		return repository.findAll();
	}
	
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria update(Integer id, CategoriaDTO objDto) {
		Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return repository.save(obj);
	}

	public void delete(Integer id){
		Categoria obj = findById(id);
		try {
			repository.deleteById(obj.getId());
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new com.fausto.bookstore.exceptions.DataIntegrityViolationException("Categoria não pode ser deletada, possui livros associados!"); 
		}
		
	}
}
