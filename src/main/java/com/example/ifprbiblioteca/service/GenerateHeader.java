package com.example.ifprbiblioteca.service;

public class GenerateHeader {
    public static String generateHeader(){
        return "<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n" +
                "    <div class=\"container\">\n" +
                "      <a class=\"navbar-brand\" href=\"#\">\n" +
                "        <img src=\"caminho/do/logo.png\" alt=\"Logo\">\n" +
                "      </a>\n" +
                "      <div class=\"navbar-collapse justify-content-end\">\n" +
                "        <ul class=\"navbar-nav ml-auto\">\n" +
                "          <li class=\"nav-item\">\n" +
                "            <a class=\"nav-link\" href=\"#\">\n" +
                "              <i class=\"fas fa-sign-out-alt\"></i> Sair\n" +
                "            </a>\n" +
                "          </li>\n" +
                "          <li class=\"nav-item\">\n" +
                "            <a class=\"nav-link\" href=\"#\">\n" +
                "              <i class=\"fas fa-cog\"></i> Configuração da conta\n" +
                "            </a>\n" +
                "          </li>\n" +
                "          <% if (user.getEmail().equals(\"admin@admin.com\")) { %>\n" +
                "          <li class=\"nav-item\">\n" +
                "            <a class=\"nav-link\" href=\"#\">\n" +
                "              <i class=\"fas fa-user-plus\"></i> Cadastrar Usuário\n" +
                "            </a>\n" +
                "          </li>\n" +
                "          <% } %>\n" +
                "        </ul>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "  </nav>";
    }
}
