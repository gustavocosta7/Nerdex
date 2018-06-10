/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import mvc.bean.Administrador;
import mvc.bean.Categoria;
import mvc.bean.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gustav0
 */
@Repository
public class AdminDAO {

    private final Connection connection;

    @Autowired
    public AdminDAO(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean adicionaAdmin(Administrador admin) {
        String sql = "insert into administrador(admnome,admemail, admsenha) values(?,?,?)";

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, admin.getAdmnome());
            ps.setString(2, admin.getAdmemail());
            ps.setString(3, admin.getAdmsenha());
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return true;

    }
    
      public boolean adicionaCategoria(Categoria cat) {
        String sql = "insert into categoria(catnome) values(?)";

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, cat.getCatdes());
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return true;

    }

    public boolean validaAdmin(Administrador admin) {
        String sql = "select * from administrador where admemail = ? and admsenha = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, admin.getAdmemail());
            ps.setString(2, admin.getAdmsenha());
            ResultSet rs = ps.executeQuery();

            Administrador adm = new Administrador();

            if (!rs.next()) {
                System.out.println("não há admins");
                return false;
            } else {
                System.out.println("logado com sucesso");
                return true;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    
    public String getNomeAdminDAO(Administrador admin) {

        String sql = "select * from administrador where admemail = ?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, admin.getAdmemail());

            ResultSet rs = ps.executeQuery();

            String nome = "";

            while (rs.next()) {

                nome = rs.getString("admnome");

            }

            return nome;

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

}
