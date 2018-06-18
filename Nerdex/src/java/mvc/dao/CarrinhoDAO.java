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
import mvc.bean.ProdutoCategoria;
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
      String sql = "insert into venda (venid, vencliid, venproid,venforid,venpreco)  values (?,?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, v.getVenid());
            ps.setLong(2, v.getCliid());
            ps.setLong(3, v.getVenproid());
            ps.setLong(4, v.getVenforid());
            ps.setDouble(5, v.getVenpreco());
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
    
}
