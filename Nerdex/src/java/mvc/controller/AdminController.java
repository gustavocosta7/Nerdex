/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;


import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import mvc.bean.Administrador;
import mvc.bean.Curriculo;
import mvc.dao.AdminDAO;
import mvc.dao.CurriculoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Aluno
 */
@Controller
public class AdminController {

    private final AdminDAO dao;

    @Autowired
    public AdminController(AdminDAO dao) {
        this.dao = dao;
    }

    @RequestMapping("/admin")
    public String indexAdmin() {
        return "tarefa/admin/form_login_admin";
    }
    
    @RequestMapping("/cadastroAdmin")
    public String cadastroAdmin() {
        return "tarefa/admin/form_cadastro_admin";
    }
    
    @RequestMapping("/crudCategoria")
    public String crudCategoria() {
        return "tarefa/categoria/categoria_principal";
    }
    
    @RequestMapping("/crudProduto")
    public String crudProduto() {
        return "tarefa/produto/produto_principal";
    }
    
    
    @RequestMapping("/cadastro-admin")
    public String cadastrarAdmin(Administrador admin, HttpServletRequest request, Model model){
        admin.setAdmnome(request.getParameter("tfNome"));
        admin.setAdmsenha(request.getParameter("tfSenha"));
        admin.setAdmemail(request.getParameter("tfEmail"));
        model.addAttribute("adicionado",true);
        dao.adicionaAdmin(admin);
        return "tarefa/admin/form_login_admin";
    }
    
    
    
    @RequestMapping("/admin-principal") 
    public String validaLogin(Administrador admin, HttpServletRequest request, Model model){ 
       boolean cadastrado; 

       admin.setAdmemail(request.getParameter("tfEmail")); 
       admin.setAdmsenha(request.getParameter("tfSenha")); 

       cadastrado = dao.validaAdmin(admin); 
       
       if(request.getParameter("tfEmail")!=null) {
            if (cadastrado) {

                String nome = dao.getNomeAdminDAO(admin);

                model.addAttribute("adminNome", nome);

                return "tarefa/admin/admin_principal";

            } else {
                return "tarefa/admin/form_login_admin";
            }
        } else {
            return "tarefa/admin/admin_principal";
        }

        
    } 
    

}
