package com.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private Livro livro;
    private Autor autor;
    private Editora editora;
    private LivroEstoque estoque;

    @Before
    public void setUp() {
        biblioteca = new Biblioteca();
        autor = new Autor("Nome do Autor", "Sobrenome do Autor");
        editora = new Editora("Nome da Editora");
        livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);
        estoque = new LivroEstoque(livro, 5, 45.0); 
    }

    @Test
    public void testAdicionarLivro() {
        biblioteca.AdicionarLivro(livro);
        assertTrue(biblioteca.getLivros().contains(livro));
    }

    @Test
    public void testRemoverLivro() {
        biblioteca.AdicionarLivro(livro);
        biblioteca.RemoverLivro(livro);
        assertFalse(biblioteca.getLivros().contains(livro));
    }
    
    @Test
    public void testRemoverLivroFailed() {
        biblioteca.AdicionarLivro(livro);
        biblioteca.RemoverLivro(livro);
        assertTrue(biblioteca.getLivros().contains(livro));
    }

    @Test
    public void testAdicionarAutor() {
        biblioteca.AdicionarAutor(autor);
        assertTrue(biblioteca.getAutores().contains(autor));
    }

    @Test
    public void testRemoverAutor() {
        biblioteca.AdicionarAutor(autor);
        biblioteca.RemoverAutor(autor);
        assertFalse(biblioteca.getAutores().contains(autor));
    }

    @Test
    public void testAdicionarEditora() {
        biblioteca.AdicionarEditora(editora);
        assertTrue(biblioteca.getEditoras().contains(editora));
    }

    @Test
    public void testRemoverEditora() {
        biblioteca.AdicionarEditora(editora);
        biblioteca.RemoverEditora(editora);
        assertFalse(biblioteca.getEditoras().contains(editora));
    }

    @Test
    public void testAdicionarEstoque() {
        biblioteca.AdicionarEstoque(estoque);
        assertTrue(biblioteca.getEstoque().contains(estoque));
    }

    @Test
    public void testRemoverEstoque() {
        biblioteca.AdicionarEstoque(estoque);
        biblioteca.RemoverEstoque(estoque);
        assertFalse(biblioteca.getEstoque().contains(estoque));
    }
}