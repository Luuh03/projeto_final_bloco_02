package com.generation.farmacia.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.generation.farmacia.model.Categoria;
import com.generation.farmacia.repository.CategoriaRepository;
import com.generation.farmacia.util.TestBuilder;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CategoriaControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private CategoriaController categoriaController;
	

	private static final String BASE_URL_CATEGORIAS = "/categorias";
	
	@BeforeAll
	void start() {
		categoriaRepository.deleteAll();
		categoriaController.post(TestBuilder.criarCategoriaMedicacao());
	}
	
	@Test
	@DisplayName("✔️ Deve cadastrar nova categoria com sucesso")
	public void deveCadastrarCategoria() {
		
		// Given
		Categoria categoria = TestBuilder.criarCategoria(null, "Cosmético");
		
		// When
		HttpEntity<Categoria> requisicao = new HttpEntity<Categoria>(categoria);
		ResponseEntity<Categoria> resposta = testRestTemplate.exchange(
				BASE_URL_CATEGORIAS, HttpMethod.POST, requisicao, Categoria.class);
		
		// Then
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
		assertEquals("Cosmético", resposta.getBody().getDescricao());
	}
	
	@Test
	@DisplayName("✔️ Deve atualizar uma categoria com sucesso")
	public void deveAtualizarCategoria() {
		
		// Given
		Categoria categoria = TestBuilder.criarCategoria((long) 1, "Skincare");
		
		// When
		HttpEntity<Categoria> requisicao = new HttpEntity<Categoria>(categoria);
		ResponseEntity<Categoria> resposta = testRestTemplate.exchange(
				BASE_URL_CATEGORIAS, HttpMethod.PUT, requisicao, Categoria.class);
		
		// Then
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		assertEquals("Skincare", resposta.getBody().getDescricao());
	}
	
	@Test
	@DisplayName("❌ Deve falhar ao atualizar uma categoria sem ID")
	public void naoDeveAtualizarCategoriaSemId() {
		
		// Given
		Categoria categoria = TestBuilder.criarCategoria(null, "Skincare");
		
		// When
		HttpEntity<Categoria> requisicao = new HttpEntity<Categoria>(categoria);
		ResponseEntity<Categoria> resposta = testRestTemplate.exchange(
				BASE_URL_CATEGORIAS, HttpMethod.PUT, requisicao, Categoria.class);
		
		// Then
		assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
	}
	
	@Test
	@DisplayName("✔️ Deve listar todas as categorias com sucesso ")
	public void deveListarTodasAsCategorias() {
		
		// Given
		categoriaController.post(TestBuilder.criarCategoria(null, "Medicamento controlado"));
		categoriaController.post(TestBuilder.criarCategoria(null, "Higiene Pessoal"));
		
		// When
		ResponseEntity<Categoria[]> resposta = testRestTemplate.exchange(
				BASE_URL_CATEGORIAS, HttpMethod.GET, null, Categoria[].class);
		
		// Then
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		assertNotNull(resposta.getBody());
	}
	
	@Test
	@DisplayName("✔️ Deve consultar uma categoria por id com sucesso ")
	public void deveConsultarCategoriaPorId() {
		
		// Given
		Categoria categoria = TestBuilder.criarCategoria(null, "Sorvete");

		Optional<Categoria> categoriaCadastrada = Optional.ofNullable(categoriaRepository.save(categoria));
		
		// When
		ResponseEntity<Categoria> resposta = testRestTemplate.exchange(
				BASE_URL_CATEGORIAS + "/{id}", HttpMethod.GET, null, Categoria.class, categoriaCadastrada.get().getId());
		
		// Then
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		assertEquals("Sorvete", resposta.getBody().getDescricao());
	}
	
	@Test
	@DisplayName("✔️ Deve consultar uma categoria por descrição com sucesso ")
	public void deveConsultarCategoriaPorDescricao() {
		
		// Given
		Categoria categoria = TestBuilder.criarCategoria(null, "Chiclete");

		Optional<Categoria> categoriaCadastrada = Optional.ofNullable(categoriaRepository.save(categoria));
		
		// When
		ResponseEntity<Categoria[]> resposta = testRestTemplate.exchange(
				BASE_URL_CATEGORIAS + "/descricao/{descricao}", HttpMethod.GET, null, Categoria[].class, categoriaCadastrada.get().getDescricao());
		
		// Then
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		assertNotNull(resposta.getBody());
	}
	
	@Test
	@DisplayName("✔️ Deve deletar uma categoria por id com sucesso ")
	public void deveDeletarCategoriaPorId() {
		
		// Given
		Categoria categoria = TestBuilder.criarCategoria(null, "Primeiros socorros");

		Optional<Categoria> categoriaCadastrada = Optional.ofNullable(categoriaRepository.save(categoria));
		
		// When
		ResponseEntity<Void> resposta = testRestTemplate.exchange(
				BASE_URL_CATEGORIAS + "/{id}", HttpMethod.DELETE, HttpEntity.EMPTY, Void.class, categoriaCadastrada.get().getId());
		
		// Then
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		assertNull(resposta.getBody());
	}
	
}
