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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.xml.bind.DatatypeConverter;
import mvc.bean.Produto;
import mvc.bean.ProdutoCategoria;
import mvc.dao.CategoriaDAO;
import mvc.dao.ProdutoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author hdolz
 */
@Controller
public class ProdutoController {
    
    private ProdutoDAO dao;
    private CategoriaDAO catdao;

    @Autowired
    public ProdutoController(ProdutoDAO dao, CategoriaDAO catdao) {
        this.dao = dao;
        this.catdao = catdao;
    }
    
    @RequestMapping("/produtoPrincipal")
    public String voltarProdutoPrincipal() {
        return "tarefa/produto/produto_principal";
    }
    
    @RequestMapping("/form-adicionar-produto")
    public String formAdicionarCategoria(Model model) {
        model.addAttribute("listaCategorias",catdao.listarCategorias());
        return "tarefa/produto/form_adicionar_produto";
    }
    
    @RequestMapping("/adicionarProduto")
    public String adicionarProduto(HttpServletRequest request, Model model) {
         MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile multipartFile = multipartRequest.getFile("tfFoto");
            
            
            String destinyPath = "C:\\FotosProduto\\";
            if(!(new File(destinyPath)).exists()){
                (new File(destinyPath)).mkdir();
            }
            
            String photoName = multipartFile.getOriginalFilename();
            String photoPath = destinyPath + photoName;
                       
            File photoFile = new File(photoPath);
        try {
            multipartFile.transferTo(photoFile);
        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        Produto prod = new Produto();
        prod.setPronome(request.getParameter("tfNome"));
        prod.setPropreco(Double.parseDouble(request.getParameter("tfPreco")));
        prod.setProdes(request.getParameter("tfDesc"));
        prod.setProcatid(Long.parseLong(request.getParameter("tfCategoria")));
        prod.setProcam(photoPath);
        model.addAttribute("adicionado",true);
        dao.adicionarProduto(prod);
        return "tarefa/produto/produto_principal";
    }
    
  
    
    private void setImagePath(ProdutoCategoria pc) throws IOException{
        
            BufferedImage bImage = ImageIO.read(new File(pc.getProcam()));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write( bImage, "jpg", baos );
            baos.flush();
            byte[] imageInByteArray = baos.toByteArray();
            baos.close();                                   
            String b64 = DatatypeConverter.printBase64Binary(imageInByteArray);
            pc.setProcam(b64);
            
        }
            
    
    
    @RequestMapping("/listarProduto")
    public String listarProduto(Model model) throws IOException{
       
        model.addAttribute("produtos", dao.listarProdutos());
        model.addAttribute("listaCat",catdao.listarCategorias());
        return "tarefa/produto/listar_produto";
    }
    
    @RequestMapping("/removeProduto")
    public String removerProduto(Long id){
        dao.removerCategoria(id);
        return "redirect:/listarProduto";
    }
    
    @RequestMapping("/exibeProduto")
    public String exibeProduto(Long id, Model model){
        ProdutoCategoria pc = dao.getProduto(id);
        
        try {
            setImagePath(pc);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println(pc.getProcam());
        model.addAttribute("produto",pc);
        model.addAttribute("listaCategorias",catdao.listarCategorias());
        return "tarefa/produto/exibe_produto";
    }
    
    @RequestMapping("/alterarProduto")
    public String altera(@Valid Produto produto, BindingResult result){
        if(result.hasErrors()){
            return "tarefa/exibeProduto";
        }
        dao.alterarProduto(produto);
        return "redirect:/listarProduto";
    }
    
}
