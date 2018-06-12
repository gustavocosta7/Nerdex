/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import javax.annotation.Resource;
import javax.ws.rs.POST;
import mvc.bean.Carrinho;
import mvc.bean.ItemCarrinho;
import mvc.dao.ProdutoDAO;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author Aluno
 */

@Resource
public class CarrinhoController {
    private final Carrinho carrinho;
    private final ProdutoDAO dao;
    
    @Autowired
    public CarrinhoController(Carrinho carrinho, ProdutoDAO dao) {
        this.carrinho = carrinho;
        this.dao = dao;
    }
    
    
    
    @POST("/carrinho")
    public void adiciona(ItemCarrinho item) {
        
        carrinho.adiciona(item);
  }
    


}
