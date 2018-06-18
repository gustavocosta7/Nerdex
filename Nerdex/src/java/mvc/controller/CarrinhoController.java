/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import mvc.bean.Venda;
import mvc.dao.CarrinhoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Aluno
 */
@Controller
public class CarrinhoController {
    private final CarrinhoDAO dao;
    
    @Autowired
    public CarrinhoController(CarrinhoDAO dao) {
        this.dao = dao;
    }
    
    @RequestMapping("/finalizaCompra")
    public String compra(HttpServletRequest request){
        List<Integer> proid = new ArrayList<>();
  
        int quantidade = Integer.parseInt(request.getParameter("tfQtde"));
        int idVenda = dao.sizeVendas();
        int idCliente = Integer.parseInt(request.getParameter("tfCliid"));
        
       for(int i = 0 ; i < quantidade ; i++){
            proid.add(Integer.parseInt(request.getParameter("tfId"+i)));
            Venda v = new Venda(idVenda,idCliente,Integer.parseInt(request.getParameter("tfId"+i)),1,Double.parseDouble(request.getParameter("tfTotal")));
            dao.addCarrinho(v);
        }
        return "tarefa/fale_conosco";
    }
    
    
}