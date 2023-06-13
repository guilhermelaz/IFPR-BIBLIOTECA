package com.example.ifprbiblioteca.repositories;

import com.example.ifprbiblioteca.connection.ConnectionFactory;
import com.example.ifprbiblioteca.models.Livro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class LivroRepository {

    private EntityManager entityManager;
    private EntityTransaction transaction;

    public LivroRepository(){
        this.entityManager = ConnectionFactory.getConnection();
        this.transaction = this.entityManager.getTransaction();
    }

    public Livro create(Livro livro){

        transaction.begin();
        entityManager.persist(livro);
        transaction.commit();

        return livro;
    }

    public Livro findById(Long id){

        Livro livro = entityManager.find(Livro.class, id);

        return livro;
    }

    public Livro update(Livro livro){

        transaction.begin();

        livro = entityManager.merge(livro);

        transaction.commit();

        return livro;

    }

    public Livro remove(Livro livro){

        if(livro == null){
            throw new RuntimeException("O livro não deve ser nulo.");
        }

        transaction.begin();

        livro = entityManager.find(Livro.class, livro.getId());

        entityManager.remove(livro);

        transaction.commit();

        return livro;
    }

    public List<Livro> findAll(){
        // livros =
        return entityManager.createQuery("SELECT l FROM livros l", Livro.class).getResultList();

    }

}
