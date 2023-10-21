package com.biblioteca;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LivroVendaTest {

    private Livro livro;
    private Autor autor;
    private Editora editora;
    private LivroEstoque estoque;

    @Before
    public void setUp() {
        autor = new Autor("Nome do Autor", "Sobrenome do Autor");
        editora = new Editora("Nome da Editora");
        livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);
        estoque = new LivroEstoque(livro, 5, 45.0); 
    }
	
	@Test
	public void testConstrutorPadrao() {
		LivroVenda livroVenda = new LivroVenda();
		assertNull(livroVenda.livroDoEstoque);
		assertEquals(0, livroVenda.quantidade);
	}
	
	@Test
	public void testIncrementarQuantidadeSemParametro() {
		LivroVenda livroVenda = new LivroVenda(new LivroEstoque(livro, 5, 45.0), 10);
		livroVenda.IncrementarQuantidade();
		assertEquals(11, livroVenda.quantidade);
	}

	@Test
	public void testIncrementarQuantidadeComParametro() {
		LivroVenda livroVenda = new LivroVenda(estoque, 10);
		livroVenda.IncrementarQuantidade(5);
		assertEquals(15, livroVenda.quantidade);
	}
	
	@Test
	public void testDecrementarQuantidadeIgualZeroSemParametro() {
		LivroVenda livroVenda = new LivroVenda(estoque, 0);
		boolean retorno = livroVenda.DecrementarQuantidade();
		assertEquals(false, retorno);
	}
	
	@Test
	public void testDecrementarQuantidadeMaiorZeroSemParametro() {
		LivroVenda livroVenda = new LivroVenda(estoque, 20);
		boolean retorno = livroVenda.DecrementarQuantidade();
		assertEquals(true, retorno);
	}
	
	@Test
	public void testDecrementarQuantidadeMaiorComParametro() {
		LivroVenda livroVenda = new LivroVenda(estoque, 10);
		boolean retorno = livroVenda.DecrementarQuantidade(20);
		assertEquals(false, retorno);
	}
	
	@Test
	public void testDecrementarQuantidadeMenorComParametro() {
		LivroVenda livroVenda = new LivroVenda(estoque, 20);
		boolean retorno = livroVenda.DecrementarQuantidade(10);
		assertEquals(true, retorno);
	}
}