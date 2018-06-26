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
import mvc.bean.Carrinho;
import mvc.bean.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class CarrinhoDAO {
    
     private final Connection connection;

    @Autowired
    public CarrinhoDAO(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
//    INSERT
    
  public void addCarrinho(Venda v){
      String sql = "insert into venda (venid, vencliid, venproid,venforid,venqtde,venpreco)  values (?,?,?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, v.getVenid());
            ps.setLong(2, v.getCliid());
            ps.setLong(3, v.getVenproid());
            ps.setLong(4, v.getVenforid());
            ps.setInt(5, v.getVenqtde());
            ps.setDouble(6, v.getVenpreco());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
      
  }   
    
    
//    SELECT
 public int sizeVendas(){
        String sql = "select  max(venid)'qtde' from venda";
        int quantidade = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            
            quantidade = rs.getInt("qtde");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return quantidade;
    
   }
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////
  public List<Carrinho> listVendas(Long cliid){
        List<Carrinho> vendas = new ArrayList<>();
        String sql = "select venid,venproid, pronome, count(venqtde) 'qtde' " + "from venda "+
                "inner join produto on venproid = proid "+"group by vencliid ,venproid" + " having vencliid = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, cliid);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Carrinho c = new Carrinho(rs.getLong("venid"),rs.getLong("venproid"),rs.getString("pronome"),
                        rs.getInt("qtde"));
                vendas.add(c);
            }
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return vendas;
   }
}
