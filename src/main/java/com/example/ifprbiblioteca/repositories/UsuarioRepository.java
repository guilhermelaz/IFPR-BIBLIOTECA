package com.example.ifprbiblioteca.repositories;

import com.example.ifprbiblioteca.connection.ConnectionFactory;
import com.example.ifprbiblioteca.models.Livro;
import com.example.ifprbiblioteca.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class UsuarioRepository {

    private EntityManager entityManager;
    private EntityTransaction transaction;

    public UsuarioRepository(){
        this.entityManager = ConnectionFactory.getConnection();
        this.transaction = this.entityManager.getTransaction();
    }

    public Usuario create(Usuario usuario){

        transaction.begin();
        entityManager.persist(usuario);
        transaction.commit();

        return usuario;
    }

    public Usuario findById(Integer id){

        Usuario usuario = entityManager.find(Usuario.class, id);

        return usuario;
    }

    public Usuario update(Usuario usuario){

        transaction.begin();

        usuario = entityManager.merge(usuario);

        transaction.commit();

        return usuario;

    }

    public Usuario remove(Usuario usuario){

        if(usuario == null){
            throw new RuntimeException("O usuario não deve ser nulo.");
        }

        transaction.begin();

        usuario = entityManager.find(Usuario.class, usuario.getId());

        entityManager.remove(usuario);

        transaction.commit();

        return usuario;
    }

    public void removeById(Integer id) throws Exception {
        transaction.begin();
        Usuario usuario = this.findById(id);
        entityManager.remove(usuario);
        transaction.commit();
    }

    public Usuario findByEmail(String email){
        try {
            return entityManager.createQuery("SELECT u FROM usuarios u WHERE u.email = :email", Usuario.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Usuario> findAll(){
        return entityManager.createQuery("SELECT u FROM usuarios u", Usuario.class).getResultList();
    }

    public List<Livro> findUserLivros (Integer id){
        return entityManager.createQuery("SELECT l FROM livros l WHERE l.usuario = :id", Livro.class)
                .setParameter("id", id)
                .getResultList();
    }


}
