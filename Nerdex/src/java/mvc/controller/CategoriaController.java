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
import mvc.bean.Administrador;
import mvc.bean.Categoria;
import mvc.dao.AdminDAO;
import mvc.dao.CategoriaDAO;
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
public class CategoriaController {
    
    private final CategoriaDAO dao;

    @Autowired
    public CategoriaController(CategoriaDAO dao) {
        this.dao = dao;
    }
    
    @RequestMapping("/voltarAdmin")
    public String voltarAdminPrincipal() {
        return "tarefa/admin/admin_principal";
    }
    
    @RequestMapping("/categoriaPrincipal")
    public String voltarCategoriaPrincipal() {
        return "tarefa/categoria/categoria_principal";
    }
    
    @RequestMapping("/form-adicionar-categoria")
    public String formAdicionarCategoria() {
        return "tarefa/categoria/form_adicionar_categoria";
    }
    
    @RequestMapping("/adicionarCategoria")
    public String adicionarCategoria(HttpServletRequest request, Model model) {
        Categoria c = new Categoria();
        c.setCatdes(request.getParameter("tfNome"));
        model.addAttribute("adicionado",true);
        dao.adicionaCategoria(c);
        return "tarefa/categoria/categoria_principal";
    }
    
    @RequestMapping("/listarCategoria")
    public String lista(Model model) throws IOException{
        List<Categoria> listaCategorias = dao.listarCategorias();
        model.addAttribute("listaCategoria", listaCategorias);
        return "tarefa/categoria/listar_categoria";
    }
    
    @RequestMapping("/removerCategoria")
    public String remove(int id){
        dao.removerCategoria(id);
        return "redirect:/listarCategoria";
    }
    
    @RequestMapping("/exibeCategoria")
    public String exibe(Long id, Model model){
        model.addAttribute("categoria", dao.buscaCategoria(id));
        return "tarefa/categoria/exibe_categoria";
    }
    
    @RequestMapping("/alterarCategoria")
    public String altera(@Valid Categoria categoria, BindingResult result){
        if(result.hasErrors()){
            return "tarefa/exibeCategoria";
        }
        dao.alterarCategoria(categoria);
        return "redirect:/listarCategoria";
    }
    
    
}
