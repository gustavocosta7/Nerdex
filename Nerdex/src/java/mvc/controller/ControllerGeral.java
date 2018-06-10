/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import mvc.bean.Cliente;
import mvc.bean.Mensagem;
import mvc.dao.CategoriaDAO;
import mvc.dao.ClienteDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.HttpServletBean;

/**
 *
 * @author Aluno
 */
@Controller
public class ControllerGeral {

    private final ClienteDAO dao;
    private final CategoriaDAO catdao;
    
    
    @Autowired
    public ControllerGeral(ClienteDAO dao, CategoriaDAO catdao){
        this.dao = dao;
        this.catdao = catdao;
    }
    
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("listaCategorias",catdao.listarCategorias());
        return "index";
    }
    @RequestMapping("/index")
    public String retornaIndex(){
        return "/index";
    }
    
    @RequestMapping("/cadastro-usuario")
   public String form(){
        return "tarefa/form_usuario_cadastro";
    }
   
    @RequestMapping("/exibe-usuario")
    public String exibeUsuario(){
        return "tarefa/usuario_perfil";
    }
    
    
   @RequestMapping("/menu")
    public String menu(){
        return "tarefa/menu";
    }
    
    @RequestMapping("/fale_conosco")
    public String faleConosco(){
        return "tarefa/fale_conosco";
    }
    
    
    @RequestMapping("/cadastro-cliente")
    public String cadastroCliente(Cliente cliente, HttpServletRequest request, Model model){
        cliente.setClinome(request.getParameter("tfNome"));
        cliente.setClisenha(request.getParameter("tfSenha"));
        cliente.setCliemail(request.getParameter("tfEmail"));
        cliente.setClifone(request.getParameter("tfFone"));
        model.addAttribute("adicionado",true);
        dao.adicionaCliente(cliente);
        
        return "tarefa/form_usuario_cadastro";
        
    }
    
    @RequestMapping("/valida-login") 

    public String validaLogin(Cliente cliente, HttpServletRequest request, Model model){ 
       boolean cadastrado; 

       cliente.setCliemail(request.getParameter("tfEmail")); 
       cliente.setClisenha(request.getParameter("tfSenha")); 

       cadastrado = dao.validaCliente(cliente); 

        if(cadastrado){ 

            String nome = dao.getNomeClienteDAO(cliente);
            model.addAttribute("clienteNome", nome);
            model.addAttribute("cliente",dao.getCliente(cliente));
            return "tarefa/usuario_perfil";
        }else{ 

            return "/index"; 

        } 

    } 
    
    @RequestMapping("/alteraCliente")
    public String altera(HttpServletRequest request, Model model){
        Cliente cliente = new Cliente();
        
        cliente.setCliid(Long.parseLong(request.getParameter("tfId")));
        cliente.setClinome(request.getParameter("tfNome"));
        cliente.setClisenha(request.getParameter("tfSenha"));
        cliente.setCliemail(request.getParameter("tfEmail"));
        cliente.setClifone(request.getParameter("tfFone"));
        

        dao.alteraCliente(cliente);
        model.addAttribute("cliente",dao.getCliente(cliente));
        return "tarefa/usuario_perfil";
    }
    
    @RequestMapping("/removeCliente")
    public String removeCliente(long id){
        dao.removerCliente(id);
        return "redirect:/index";
    }
    

    ///////////////MENSAGENS//////////////////////
    
    @RequestMapping("/adicionaMensagem")
    public String addMensagem(HttpServletRequest request){
        Mensagem m = new Mensagem();
        m.setMennome(request.getParameter("tfNome"));
        m.setMendesc(request.getParameter("tfMensagem"));
        dao.adicionaMensagem(m);
        
        return "tarefa/fale_conosco";
    }
    
    
    @RequestMapping("/trabalhe_conosco")
    public String trabalheConosco(){        
        return "tarefa/trabalhe_conosco";
    }
    
    
   @RequestMapping(value="/adicionaCurriculo")
    public String adiciona(HttpServletRequest request, Model model){
        /*
        Configuracoes necessárias
        Fonte: http://www.pablocantero.com/blog/2010/09/29/upload-com-spring-mvc/
        */
        try {
             MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile multipartFile = multipartRequest.getFile("tfCur");
            
            
            String destinyPath = "C:\\Fotos\\";
            if(!(new File(destinyPath)).exists()){
                (new File(destinyPath)).mkdir();
            }
            
            String photoName = multipartFile.getOriginalFilename();
            String photoPath = destinyPath + photoName;
                       
            File photoFile = new File(photoPath);
            multipartFile.transferTo(photoFile);
            
            //backup
            //File destinationDir = new File(applicationPath);
            //FileUtils.copyFileToDirectory(photoFile, destinationDir);
            
//            Usuario user = new Usuario();
//            user.setLogin(request.getParameter("login"));
//            user.setSenha(request.getParameter("senha"));
//            user.setPhoto(photoPath);           
//            
//            dao.adicionaUsuario(user);            
            return "tarefa/trabalhe_conosco";
            
        } catch (IOException ex) {
//            model.addAttribute("erro", ex.toString());
//            return "usuario/usuario-erro-adicao";
        } 
        return "tarefa/trabalhe_conosco";
    }
//    
//    @RequestMapping("/listaTarefa")
//    public String lista(Model model){
//        model.addAttribute("listaUsuarios",usuarioDAO.listaUsuarios());
//        return "tarefa/listagem-usuarios";
//    }
//    

    
}
