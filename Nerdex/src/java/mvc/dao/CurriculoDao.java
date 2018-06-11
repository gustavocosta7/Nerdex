/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import mvc.bean.Curriculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gustav0
 */

@Repository
public class CurriculoDao {
    
    
    private Connection connection;
    
    
    @Autowired
    public CurriculoDao(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
//    -----------------------INSERT
        public boolean adicionaCurriculo(Curriculo curriculo) {
        String sql = "insert into curriculo(curnome,curemail,curcaminho) values(?,?,?)";

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, curriculo.getCurnome());
            ps.setString(2, curriculo.getCuremail());
            ps.setString(3, curriculo.getCurcaminho());
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return true;

    }
    
//    -----------------------UPDATE
//    -----------------------DELETE
//    -----------------------SELECT
    
    
    
    
}
