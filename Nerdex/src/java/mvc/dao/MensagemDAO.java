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
import mvc.bean.Categoria;
import mvc.bean.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hdolz
 */
@Repository
public class MensagemDAO {
    private final Connection connection;

    @Autowired
    public MensagemDAO(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public List<Mensagem> listarMensagem(){
        List<Mensagem> listaMensagens = new ArrayList<Mensagem>();
        String sql = "select * from mensagem";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Mensagem men = new Mensagem();
                men.setMenid(rs.getLong("menid"));
                men.setMendesc(rs.getString("mendesc"));
                men.setMennome(rs.getString("mennome"));
                listaMensagens.add(men);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return listaMensagens;
        
    }
    
    
    
    public boolean removerMensagem(int id){
        String sql = "delete from mensagem where menid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1,id);
            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }
    
   public Mensagem retornaMensagem(Long id){
        String sql = "select * from mensagem where menid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            Mensagem men = new Mensagem();
            
            if(rs.next()){
                men.setMenid(rs.getLong("menid"));
                men.setMendesc(rs.getString("mendesc"));
                men.setMennome(rs.getString("mennome"));
                
            }
            return men;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        } 
    }
    
    
}
