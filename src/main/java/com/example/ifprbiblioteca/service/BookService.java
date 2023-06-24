package com.example.ifprbiblioteca.service;

import com.example.ifprbiblioteca.models.Autor;
import com.example.ifprbiblioteca.models.Livro;
import com.example.ifprbiblioteca.models.StatusLivro;
import com.example.ifprbiblioteca.repositories.AutorRepository;
import com.example.ifprbiblioteca.repositories.LivroRepository;

import java.time.LocalDate;

public class BookService {

    private LivroRepository livroRepository = new LivroRepository();
    private AutorRepository autorRepository = new AutorRepository();


    public void create_book(String nome, String autorNome, String statusSelecionado) {

        if(nome == null || nome.isEmpty()) {
            throw new RuntimeException("Nome do livro não pode ser vazio");
        }

        if(autorNome == null || autorNome.isEmpty()) {
            throw new RuntimeException("Nome do autor não pode ser vazio");
        }

        if(statusSelecionado == null || statusSelecionado.isEmpty()) {
            throw new RuntimeException("Status do livro não pode ser vazio");
        }

        Autor autorSelecionado = autorRepository.findByName(autorNome);
        StatusLivro status = StatusLivro.valueOf(statusSelecionado);

        if(autorSelecionado == null) {
            throw new RuntimeException("Autor não encontrado na base de dados.");
        }

        if(status == null) {
            throw new RuntimeException("Status não compativel com a base de dados.");
        }

        try {
            Livro novoLivro = new Livro();
            novoLivro.setNome(nome);
            novoLivro.setAutor(autorSelecionado);
            novoLivro.setStatus(status);
            novoLivro.setDataDeCriacao(LocalDate.now());

            livroRepository.create(novoLivro);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar livro.");
        }

    }

}
