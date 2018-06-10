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
import mvc.bean.Administrador;
import mvc.bean.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hdolz
 */
@Repository
public class CategoriaDAO {
    private final Connection connection;

    @Autowired
    public CategoriaDAO(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean adicionaCategoria(Categoria cat) {
        String sql = "insert into categoria(catdescricao) values(?)";

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
    
    public List<Categoria> listarCategorias(){
        List<Categoria> listaCategorias = new ArrayList<Categoria>();
        String sql = "select * from categoria";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Categoria cat = new Categoria();
                cat.setCatid(rs.getLong("catid"));
                cat.setCatdes(rs.getString("catdes"));
                listaCategorias.add(cat);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return listaCategorias;
        
    }
    
    public boolean removerCategoria(int id){
        String sql = "delete from categoria where catid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1,id);
            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }
    
    public Categoria buscaCategoria(Long id){
        String sql = "select * from categoria where catid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            Categoria cat = new Categoria();
            
            if(rs.next()){
                cat.setCatid(rs.getLong("catid"));
                cat.setCatdes(rs.getString("catdescricao"));
            }
            return cat;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        } 
    }
    
    public boolean alterarCategoria(Categoria cat){
        String sql = "update categoria set catdescricao = ? where catid = ?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,cat.getCatdes());
            ps.setLong(2,cat.getCatid());
            ps.execute();
            
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }
    
    
    
    
}
