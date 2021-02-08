package com.fausto.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fausto.bookstore.domain.Categoria;
import com.fausto.bookstore.domain.Livro;
import com.fausto.bookstore.repositories.CategoriaRepository;
import com.fausto.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {
		
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Ficção Ciêntifica", "Ficção");
		Categoria cat3 = new Categoria(null, "Auto Ajuda", "Auto Ajuda");
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipsum", cat1);
		Livro l2 = new Livro(null, "Java Como Programar", "Robert Martin", "Lorem Ipsum", cat1);
		Livro l3 = new Livro(null, "48 Leis do Poder", "Robert Martin", "Lorem Ipsum", cat3);
		Livro l4 = new Livro(null, "Viagem ao Centro da Terra", "Robert Martin", "Lorem Ipsum", cat2);
		Livro l5 = new Livro(null, "SQL Gua Prático", "Jonh Robins", "Lorem Ipsum", cat1);
	
		livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5));
	}
}
