package com.example.ifprbiblioteca.repositories;

import com.example.ifprbiblioteca.connection.ConnectionFactory;
import com.example.ifprbiblioteca.models.Autor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class AutorRepository {

    private EntityManager entityManager;
    private EntityTransaction transaction;

    public AutorRepository(){
        this.entityManager = ConnectionFactory.getConnection();
        this.transaction = this.entityManager.getTransaction();
    }

    public Autor create(Autor autor){

        transaction.begin();
        entityManager.persist(autor);
        transaction.commit();

        return autor;
    }

    public Autor findById(Long id){

        Autor autor = entityManager.find(Autor.class, id);

        return autor;
    }

    public Autor update(Autor autor){

        transaction.begin();

        autor = entityManager.merge(autor);

        transaction.commit();

        return autor;

    }

    public Autor remove(Autor autor){

        if(autor == null){
            throw new RuntimeException("O autor não deve ser nulo.");
        }

        transaction.begin();

        autor = entityManager.find(Autor.class, autor.getId());

        entityManager.remove(autor);

        transaction.commit();

        return autor;
    }

    public Autor findByName(String nome){
        return (Autor) entityManager.createQuery("SELECT a FROM autores a WHERE a.nome = :nome").setParameter("nome", nome).getSingleResult();
    }

    public List<Autor> findAll(){
        return entityManager.createQuery("SELECT a FROM autores a").getResultList();
    }
}
