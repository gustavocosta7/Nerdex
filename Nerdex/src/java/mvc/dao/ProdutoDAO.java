/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import mvc.bean.Produto;
import mvc.bean.ProdutoCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gustav0
 */
@Repository
public class ProdutoDAO {

    private final Connection connection;

    @Autowired
    public ProdutoDAO(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

//    -------------INSERT---------
    public boolean adicionarProduto(Produto p) {
        String sql = "insert into produto (procatid, pronome, propreco, prodes,procam)  values (?,?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, p.getProcatid());
            ps.setString(2, p.getPronome());
            ps.setDouble(3, p.getPropreco());
            ps.setString(4, p.getProdes());
            ps.setString(5, p.getProcam());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

//    -------------SELECT---------
 
    // lista produtos com categoria

    public List<ProdutoCategoria> listarProdutos() {
        List<ProdutoCategoria> produtos = new ArrayList<>();
        String sql = "select proid, procatid,pronome, catdes, propreco from produto "
                + "inner join categoria on catid = procatid;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ProdutoCategoria prod = new ProdutoCategoria(rs.getLong("proid"),rs.getLong("procatid"),
                        rs.getString("pronome"),rs.getString("catdes"),rs.getDouble("propreco"));

                produtos.add(prod);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return produtos;
    }
    
//    ---------LISTA SO UM
    
    public ProdutoCategoria getProduto(Long id) {
        ProdutoCategoria pc = new ProdutoCategoria();
        String sql = "select proid, procatid,pronome, catdes, propreco, prodes,procam from produto "
                + "inner join categoria on catid = procatid where proid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            
            pc.setProid(rs.getLong("proid"));
            pc.setProcatid(rs.getLong("procatid"));
            pc.setPronome(rs.getString("pronome"));
            pc.setProcatdescricao(rs.getString("catdes"));
            pc.setPropreco(rs.getDouble("propreco"));
            pc.setProdes(rs.getString("prodes"));
            pc.setProcam(rs.getString("procam"));
            
               

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pc;
    }
    
//    -------------DELETE---------

    public boolean removerCategoria(Long id) {
        String sql = "delete from produto where proid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }
//    -------------UPDATE---------

    public boolean alterarProduto(Produto produto) {
        String sql = "update produto set procatid = ?, pronome = ?, propreco = ? , prodescricao = ? where proid = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setLong(1, produto.getProcatid());
            ps.setString(2, produto.getPronome());
            ps.setDouble(3, produto.getPropreco());
            ps.setString(4, produto.getProdes());
            ps.setLong(5, produto.getProid());
            ps.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    public Produto buscaProduto(Long id) {
        String sql = "select * from produto where proid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            Produto prod = new Produto();

            if (rs.next()) {
                prod.setProid(rs.getLong("proid"));
                prod.setProdes(rs.getString("prodes"));
                prod.setPronome(rs.getString("pronome"));
                prod.setPropreco(rs.getLong("propreco"));
                prod.setProcatid(rs.getLong("procatid"));
                prod.setProcam(rs.getString("procam"));

            }
            return prod;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
