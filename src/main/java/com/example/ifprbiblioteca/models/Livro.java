package com.example.ifprbiblioteca.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity(name="livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 60, nullable = false)
    private String nome;
    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate dataDeCriacao;

    @Column(columnDefinition = "ENUM('DISPONIVEL', 'EMPRESTADO', 'INDISPONIVEL')", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private StatusLivro status;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public LocalDate getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(LocalDate dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public StatusLivro getStatus() {
        return status;
    }

    public void setStatus(StatusLivro status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return id == livro.id && Objects.equals(nome, livro.nome) && Objects.equals(autor, livro.autor) && Objects.equals(dataDeCriacao, livro.dataDeCriacao) && status == livro.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, autor, dataDeCriacao, status);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", autor=" + autor +
                ", dataDeCriacao=" + dataDeCriacao +
                ", status=" + status +
                '}';
    }
}
