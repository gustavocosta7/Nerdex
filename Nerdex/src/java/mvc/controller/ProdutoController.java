/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import mvc.bean.Categoria;
import mvc.bean.Produto;
import mvc.dao.CategoriaDAO;
import mvc.dao.ProdutoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

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
        Produto prod = new Produto();
        prod.setPronome(request.getParameter("tfNome"));
        prod.setPropreco(Double.parseDouble(request.getParameter("tfPreco")));
        prod.setProdes(request.getParameter("tfDesc"));
        prod.setProcatid(Long.parseLong(request.getParameter("tfCategoria")));
        model.addAttribute("adicionado",true);
        dao.adicionarProduto(prod);
        return "tarefa/produto/produto_principal";
    }
    
    @RequestMapping("/listarProduto")
    public String listarProduto(Model model) throws IOException{
        List<Produto> listaProdutos = dao.listarProdutos();
        model.addAttribute("listaProd", listaProdutos);
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
        model.addAttribute("produto", dao.buscaProduto(id));
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
