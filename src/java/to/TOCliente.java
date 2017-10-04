/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to;

import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 *
 * @author usuario
 */
public class TOCliente {

    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private Timestamp cadastro;

    public TOCliente(ResultSet rs) throws Exception {
        this.id = rs.getInt("id");
        this.nome = rs.getString("nome");
        this.email = rs.getString("email");
        this.telefone = rs.getString("telefone");
        this.senha = rs.getString("senha");
        this.cadastro = rs.getTimestamp("cadastro ");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Timestamp getCadastro() {
        return cadastro;
    }

    public void setCadastro(Timestamp cadastro) {
        this.cadastro = cadastro;
    }

}
