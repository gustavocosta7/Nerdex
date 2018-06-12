/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.sql.DataSource;
import mvc.bean.ItemProduto;
import mvc.bean.Produto;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 600109
 */
@Repository
public class CarrinhoDao {
    
    private final Connection connection;

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
//        ----------UPDATE
//        ----------DELETE
}
