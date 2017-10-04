/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import fw.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import to.TOCliente;

/**
 *
 * @author usuario
 */
public class DAOCliente {

    public static void inserir(Connection c, TOCliente t) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" insert into cliente (nome, email, telefone, cadastro, senha) ");
        sql.append(" values (?, ?, ?, now(), ?) ");

        Data.executeUpdate(c, sql.toString(),
                t.getNome(), t.getEmail(),
                t.getTelefone(), t.getSenha());
    }

    public static void alterar(Connection c, TOCliente t) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" update cliente ");
        sql.append(" set nome = ?, email = ?, telefone = ?, senha = ? ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(),
                t.getNome(), t.getEmail(),
                t.getTelefone(), t.getSenha(),
                t.getId());
    }

    public static void excluir(Connection c, int id) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" delete from cliente ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(), id);
    }

    public static TOCliente obter(Connection c, int id) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" select id, nome, email, telefone, cadastro, senha from cliente ");
        sql.append(" where id = ? ");

        try (ResultSet rs = Data.executeQuery(c, sql.toString(), id)) {

            if (rs.next()) {
                return new TOCliente(rs);
            } else {
                return null;
            }

        }

    }

    public static List<TOCliente> lista(Connection c, String filtro) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" select id, nome, email, telefone, cadastro, senha from cliente ");
        sql.append(" where nome like concat(concat('%',?),'%') ");
        sql.append(" order by nome ");

        List<TOCliente> l = new ArrayList<>();

        try (ResultSet rs = Data.executeQuery(c, sql.toString(), filtro)) {
            while (rs.next()) {
                l.add(new TOCliente(rs));
            }
        }
        return l;
    }

}
