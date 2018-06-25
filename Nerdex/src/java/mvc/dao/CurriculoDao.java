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
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import mvc.bean.Cliente;
import mvc.bean.Curriculo;
import mvc.bean.Mensagem;
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
    public List<Curriculo> listarCurriculos(){
        List<Curriculo> listaCurriculos = new ArrayList<>();
        String sql = "select * from curriculo";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Curriculo curriculo = new Curriculo();
                curriculo.setCurid(rs.getLong("curid"));
                curriculo.setCurnome(rs.getString("curnome"));
                curriculo.setCuremail(rs.getString("curemail"));
                listaCurriculos.add(curriculo);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return listaCurriculos;
        
    }
    
    public boolean removerCurriculo(long id) {
        String sql = "delete from curriculo where curid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ps.execute();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return true;
        
    }
    
    public Curriculo getCurriculo(long id){
        String sql = "select * from curriculo where curid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            Curriculo curriculo = new Curriculo();
            while(rs.next()){
                curriculo.setCurid(rs.getLong("curid"));
                curriculo.setCurnome(rs.getString("curnome"));
                curriculo.setCuremail(rs.getString("curemail"));
                curriculo.setCurcaminho(rs.getString("curcaminho"));
            }
            return curriculo;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
}
