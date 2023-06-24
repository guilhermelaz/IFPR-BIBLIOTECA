package com.example.ifprbiblioteca.service;

import com.example.ifprbiblioteca.models.Usuario;
import com.example.ifprbiblioteca.repositories.UsuarioRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class UserService {

    public void create_user(String nome, String email, String senha, String tipo) throws Exception {
        UsuarioRepository usuarioRepository = new UsuarioRepository();

        Usuario seekUser = usuarioRepository.findByEmail(email);
        if (seekUser != null) {
            throw new Exception("Email já cadastrado.");
        }

        if (nome == null || nome.isEmpty()) {
            throw new Exception("Campo nome vazio.");
        }

        if (email == null || email.isEmpty()) {
            throw new Exception("Campo email vazio.");
        }

        if (senha == null || senha.isEmpty()) {
            throw new Exception("Campo senha vazio.");
        }

        if (tipo == null || tipo.isEmpty()) {
            throw new Exception("Campo tipo vazio.");
        }

        try {
            Usuario novoUsuario = new Usuario();

            novoUsuario.setNome(nome);
            novoUsuario.setEmail(email);
            novoUsuario.setSenha(senha);
            novoUsuario.setTipo(tipo);

            usuarioRepository.create(novoUsuario);
        } catch (Exception e) {
            throw new Exception("Erro ao criar usuário.");
        }
    }

    public void edit_user(String id, String nome, String email, String tipo, String senha, String novaSenha, String confirmarNovaSenha, HttpServletRequest request) throws Exception {
        UsuarioRepository usuarioRepository = new UsuarioRepository();

        Usuario usuarioSelecionado = usuarioRepository.findById(Integer.parseInt(id));

        if (usuarioSelecionado == null) {
            throw new Exception("Usuário não encontrado.");
        }

        if (nome == null || nome.isEmpty()) {
            throw new Exception("Campo nome vazio.");
        }

        if (email == null || email.isEmpty()) {
            throw new Exception("Campo email vazio.");
        }

        if (tipo == null || tipo.isEmpty()) {
            throw new Exception("Campo tipo vazio.");
        }

        if (senha == null || senha.isEmpty()) {
            throw new Exception("Campo senha vazio.");
        }

        if (novaSenha == null || novaSenha.isEmpty()) {
            throw new Exception("Campo nova senha vazio.");
        }

        if (confirmarNovaSenha == null || confirmarNovaSenha.isEmpty()) {
            throw new Exception("Campo confirmar nova senha vazio.");
        }

        if (!senha.equals(usuarioSelecionado.getSenha())) {
            throw new Exception("Senha incorreta.");
        }

        if (!novaSenha.equals(confirmarNovaSenha)) {
            throw new Exception("Nova senha e confirmação não coincidem.");
        }

        if (senha.equals(novaSenha)) {
            throw new Exception("Nova senha igual a senha atual.");
        }

        if (!usuarioSelecionado.getTipo().equals(tipo)) {
            Usuario uAdmCheck = (Usuario) request.getSession().getAttribute("user");
            if (!uAdmCheck.getTipo().equals("ADMINISTRADOR")) {
                throw new Exception("Você não tem permissão para alterar.");
            }
        }

        try{
            usuarioSelecionado.setNome(nome);
            usuarioSelecionado.setEmail(email);
            usuarioSelecionado.setSenha(novaSenha);
            usuarioSelecionado.setTipo(tipo);

            usuarioRepository.update(usuarioSelecionado);
        } catch (Exception e) {
            throw new Exception("Erro ao editar usuário.");
        }
    }

    public void delete_user(String id, HttpSession session) throws Exception {

        Usuario uAdmCheck = (Usuario) session.getAttribute("user");

        if(uAdmCheck.getTipo().equals("ADMINISTRADOR") && uAdmCheck.getId() == Integer.parseInt(id)){
            throw new Exception("Você não pode excluir a si mesmo.");
        }

        if(uAdmCheck.getTipo().equals("ADMINISTRADOR") && uAdmCheck.getId() != Integer.parseInt(id)){
            UsuarioRepository usuarioRepository = new UsuarioRepository();
            Usuario usuarioSelecionado = usuarioRepository.findById(Integer.parseInt(id));
            if(usuarioSelecionado.getTipo().equals("ADMINISTRADOR")){
                throw new Exception("Você não pode excluir outro administrador.");
            }
        }

        if(!uAdmCheck.getTipo().equals("ADMINISTRADOR")){
            throw new Exception("Você não tem permissão para excluir usuários.");
        } else {

            UsuarioRepository usuarioRepository = new UsuarioRepository();

            Usuario usuarioSelecionado = usuarioRepository.findById(Integer.parseInt(id));

            if (usuarioSelecionado == null) {
                throw new Exception("Usuário não existe.");
            }

            if (usuarioSelecionado.getLivrosEmprestados().size() != 0) {
                throw new Exception("Usuário possui livros emprestados.");
            }

            try {
                usuarioRepository.removeById(usuarioSelecionado.getId());
            } catch (Exception e) {
                throw new Exception("Erro ao excluir usuário: " + e.getMessage());
            }
        }
    }

}
