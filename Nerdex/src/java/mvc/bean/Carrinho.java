/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.SessionScoped;
import org.springframework.stereotype.Component;

/**
 *
 * @author Aluno
 */
@Component
@SessionScoped
public class Carrinho {
    public List <ItemCarrinho> produtos = new ArrayList<>();
    
    private Double total = 0.0;
    public void adiciona(ItemCarrinho item) {
        produtos.add(item);
        total += item.getProduto().getPreco() * item.getQuantidade();
    }

    public List<ItemCarrinho> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ItemCarrinho> produtos) {
        this.produtos = produtos;
    }

    public Carrinho() {
    }


    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    

    
}
