package com.biblioteca;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class VendaTest {

	@Test
    public void testConstrutorPadrao() {
		Venda vendaPadrao = new Venda();
		Assert.assertNull(vendaPadrao.nomeCliente);
		Assert.assertNull(vendaPadrao.formaPagamento);
		Assert.assertEquals(0.0, vendaPadrao.valorDado, 0.01);
		Assert.assertNull(vendaPadrao.livros);
	}
	
	@Test
	public void testConstrutorComParametros() {
		Autor autor = new Autor("Nome do Autor", "Sobrenome do Autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);
        LivroEstoque estoque = new LivroEstoque(livro, 5, 45.0); 
        
        List<LivroVenda> livros = new ArrayList<>();
        livros.add(new LivroVenda(estoque, 10));
        
        String nomeCliente = "Claudio";
        String formaPagamento = "Dinheiro";
        double valorDado = 100.0;
        
        Venda venda = new Venda(nomeCliente, formaPagamento, valorDado, livros);
        
        Assert.assertEquals("Claudio", venda.nomeCliente);
        Assert.assertEquals("Dinheiro", venda.formaPagamento);
        Assert.assertEquals(100.0, venda.valorDado, 0.01);
        Assert.assertEquals(5, venda.livros.get(0).livroDoEstoque.exemplares);
	}
}
