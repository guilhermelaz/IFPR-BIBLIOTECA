package com.example.ifprbiblioteca.connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionFactory {

    private static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("ifpr_biblioteca");
    }

    public static EntityManager getConnection(){
        return entityManagerFactory.createEntityManager();
    }

}
