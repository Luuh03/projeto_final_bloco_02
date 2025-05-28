package com.generation.farmacia.util;

import com.generation.farmacia.model.Categoria;

public class TestBuilder {

	public static Categoria criarCategoria(Long id, String descricao) {
		Categoria categoria = new Categoria();
		
		categoria.setId(id);
		categoria.setDescricao(descricao);
		
		return categoria;
	}
	
	public static Categoria criarCategoriaMedicacao() {
		return criarCategoria(null, "Medicação");
	}
	
}
