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
import mvc.bean.Cliente;
import mvc.bean.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gustav0
 */
@Repository
public class ClienteDAO {

    private final Connection connection;

    @Autowired

    public ClienteDAO(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
        
    public boolean adicionaMensagem(Mensagem mensagem) {
        String sql = "insert into mensagem(mennome, mendesc) values(?,?)";

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, mensagem.getMennome());
            ps.setString(2, mensagem.getMendesc());
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return true;

    }


    public boolean adicionaCliente(Cliente cliente) {
        String sql = "insert into cliente(clinome,cliemail, clisenha, clifone) values(?,?,?,?)";

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, cliente.getClinome());
            ps.setString(2, cliente.getCliemail());
            ps.setString(3, cliente.getClisenha());
            ps.setString(4, cliente.getClifone());
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return true;

    }

    
    public boolean validaCliente(Cliente cliente) {
        String sql = "select *from cliente where cliemail = ? and clisenha = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cliente.getCliemail());
            ps.setString(2, cliente.getClisenha());
            ResultSet rs = ps.executeQuery();

            Cliente c = new Cliente();

            if (rs.next() == false) {
                System.out.println("não há usuarios");
                return false;
            } else {
                System.out.println("logado com sucesso");
                return true;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Cliente getCliente(Cliente cliente) {
        String sql = "select *from cliente where cliemail = ? and clisenha = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cliente.getCliemail());
            ps.setString(2, cliente.getClisenha());
            ResultSet rs = ps.executeQuery();

            Cliente c = new Cliente();
            while (rs.next()) {
                c.setCliid(rs.getLong("cliid"));
                c.setClinome(rs.getString("clinome"));
                c.setCliemail(rs.getString("cliemail"));
                c.setClisenha(rs.getString("clisenha"));
                c.setClifone(rs.getString("clifone"));
            }
            return c;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public String getNomeClienteDAO(Cliente cliente) {

        String sql = "select * from cliente where cliemail = ?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, cliente.getCliemail());

            ResultSet rs = ps.executeQuery();

            String nome = "";

            while (rs.next()) {

                nome = rs.getString("clinome");

            }

            return nome;

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    public boolean alteraCliente(Cliente cliente) {
        String sql = "update cliente set clinome = ? , cliemail = ?, clisenha = ?, clifone = ?  where cliid = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, cliente.getClinome());
            ps.setString(2, cliente.getCliemail());
            ps.setString(3, cliente.getClisenha());
            ps.setString(4, cliente.getClifone());
            ps.setLong(5, cliente.getCliid());

            ps.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean removerCliente(Long id) {
        String sql = "delete from cliente where cliid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
