/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import mvc.bean.ProdutoCategoria;
import mvc.bean.Venda;
import mvc.dao.CarrinhoDAO;
import mvc.dao.CategoriaDAO;
import mvc.dao.ProdutoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Aluno
 */
@Controller
public class CarrinhoController {
    private final CarrinhoDAO dao;
    private final CategoriaDAO catdao;
    private final ProdutoDAO prodao;
    @Autowired
    public CarrinhoController(CarrinhoDAO dao,ProdutoDAO prodao,CategoriaDAO catdao) {
        this.dao = dao;
        this.catdao = catdao;
        this.prodao  = prodao;
    }
    
    @RequestMapping("/finalizaCompra")
    public String compra(HttpServletRequest request, Model model){
        List<Integer> proid = new ArrayList<>();
  
        int quantidade = Integer.parseInt(request.getParameter("tfQtde"));
        int idVenda = dao.sizeVendas();
        idVenda++;
        int idCliente = Integer.parseInt(request.getParameter("tfCliid"));
        
       for(int i = 0 ; i < quantidade ; i++){
            proid.add(Integer.parseInt(request.getParameter("tfId"+i)));
        }

        for(int i = 0; i < proid.size(); i++){
            int cont = 0;
            for(int j = 0; j < proid.size(); j++){
                if(Objects.equals(proid.get(i), proid.get(j))){
                    cont++;
                }
            }
            Venda v = new Venda(idVenda,idCliente,proid.get(i),1,cont,Double.parseDouble(request.getParameter("tfPreco"+i).substring(request.getParameter("tfPreco"+i).indexOf("$")+1)));
            dao.addCarrinho(v);
        }
                List<ProdutoCategoria> pc = prodao.listarProdutosComFoto();

        try {
            setImagePath(pc);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        model.addAttribute("produtos",pc);
        model.addAttribute("listaCategorias",catdao.listarCategorias());
        return "index";
    }
    
    
    //////////////////////////////////////////////////////////////////////
     private void setImagePath(List<ProdutoCategoria> listaProdutos) throws IOException{
        
        for (ProdutoCategoria pc : listaProdutos) {
            
            BufferedImage bImage = ImageIO.read(new File(pc.getProcam()));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write( bImage, "png", baos );
            baos.flush();
            byte[] imageInByteArray = baos.toByteArray();
            baos.close();                                   
            String b64 = DatatypeConverter.printBase64Binary(imageInByteArray);
            pc.setProcam(b64);
        }
    }
     
   ///////////////////////////////////////////////////////////////////////////////////////////
     @RequestMapping("/compras")
     private String compras(int id, HttpServletRequest request, Model model){
          
         model.addAttribute("venda",dao.listVendas((long)id));
         return "tarefa/minhas_compras";
     }
    
}