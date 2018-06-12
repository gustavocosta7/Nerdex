/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import mvc.bean.ItemProduto;
import mvc.bean.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 600109
 */
@Repository
public class CarrinhoDao {
    
    private final Connection connection;
    @Autowired
        public CarrinhoDao(DataSource dataSource) {
          try {
            this.connection = dataSource.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
//    --------------INSERT
        public boolean adicionarItem(ItemProduto p) {
        String sql = "insert into itemproduto (iteproid, itecliid, iteqtde)  values (?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, p.getIteproid());
            ps.setLong(2, p.getItecliid());
            ps.setLong(3, p.getIteqtde());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
        
//        ----------SELECT
        
        public ItemProduto existeItem(Integer proid, Integer cliid) {
        String sql = "select *from itemproduto; iteproid, itecliid, iteqtde while iteproid = ? itecliid = ?";
         
            ItemProduto produto = new ItemProduto();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, proid);
            ps.setLong(2, cliid);
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            
            produto.setIteproid(rs.getLong("iteproid"));
            produto.setItecliid(rs.getLong("itecliid"));
            produto.setIteqtde(rs.getInt("iteqtde"));
          
            
            return produto;
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         return produto;
    }
        
//        ----------UPDATE
        
        
        
//        ----------DELETE

//    public void updateItem(ItemProduto item) {
//        String sql = "update itemcarrinho set iteqtde = ? where iteproid = ? itecliid = ?";
//
//        try {
//            PreparedStatement ps = connection.prepareStatement(sql);
//
//            ps.setString(1, item.getIteqtde());
//            ps.setString(2, item.getIteproid());
//            ps.setString(3, item.getIteproid());
//            ps.setString(4, cliente.getClifone());
//            ps.setLong(5, cliente.getCliid());
//
//            ps.execute();
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return true;
//        
//    }
//}
