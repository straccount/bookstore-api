package com.fausto.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fausto.bookstore.domain.Livro;
import com.fausto.bookstore.exceptions.ObjectNotFoundException;
import com.fausto.bookstore.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado  Id: "+ id +" , Tipo: "+Livro.class.getName()));
	}


	public List<Livro> findAllByCategoria(Integer id_cat) {
		return repository.findAllByCategoria(id_cat);
	}


}
