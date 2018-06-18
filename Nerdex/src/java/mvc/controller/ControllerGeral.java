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
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.xml.bind.DatatypeConverter;
import mvc.bean.Cliente;
import mvc.bean.Curriculo;
import mvc.bean.ItemProduto;
import mvc.bean.Mensagem;
import mvc.bean.ProdutoCategoria;
import mvc.dao.CarrinhoDao;
import mvc.dao.CategoriaDAO;
import mvc.dao.ClienteDAO;
import mvc.dao.CurriculoDao;
import mvc.dao.ProdutoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author Aluno
 */
@Controller
public class ControllerGeral {

    private final ClienteDAO dao;
    private final CategoriaDAO catdao;
    private final ProdutoDAO prodao;
    private final CurriculoDao curdao;
    private final CarrinhoDao carrinhoDao;
    
    
    @Autowired
    public ControllerGeral(ClienteDAO dao, CategoriaDAO catdao, CurriculoDao curdao,ProdutoDAO prodao, CarrinhoDao carrinhoDao){
        this.dao = dao;
        this.catdao = catdao;
        this.curdao = curdao;
        this.prodao = prodao;
        this.carrinhoDao = carrinhoDao;
    }
    
    @RequestMapping("/")
    public String index(Model model){
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
    

    
    @RequestMapping("/index")
    public String retornaIndex(){
        return "/index";
    }
    
    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("listaCategorias",catdao.listarCategorias());
        return "tarefa/login";
        
    }
    
   @RequestMapping("/cadastro-usuario")
   public String form(Model model){
        model.addAttribute("listaCategorias",catdao.listarCategorias());
        return "tarefa/form_usuario_cadastro";
    }
    
   @RequestMapping("/logout")
   public String logout(Model model, HttpSession session){
       session.removeAttribute("cliente");
       model.addAttribute("listaCategorias",catdao.listarCategorias());
       return "tarefa/logout";
    }
   

    @RequestMapping("/exibe-usuario")
    public String exibeUsuario(Model model){
        model.addAttribute("listaCategorias",catdao.listarCategorias());
        return "tarefa/usuario_perfil";
    }
    
    @RequestMapping("/fale_conosco")
    public String faleConosco(Model model){
        model.addAttribute("listaCategorias",catdao.listarCategorias());
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
        model.addAttribute("listaCategorias",catdao.listarCategorias());
        return "tarefa/form_usuario_cadastro";
        
    }

    @RequestMapping("/mostrarCategoria")
    public String mostrarCategoria(int id,Model model){
      
            List<ProdutoCategoria> pc = prodao.listarProdutosComFotoSelecionado(id);
            try{
                setImagePath(pc);
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            
            model.addAttribute("produtos",pc);
            model.addAttribute("listaCategorias",catdao.listarCategorias());
            switch(id){
                case 1:
                    return  "tarefa/pages/cat_livro";
                case 2:
                    return "tarefa/pages/cat_camisa";
                case 3:
                    return "tarefa/pages/cat_caneca";
                case 4:
                    return "tarefa/pages/cat_pelucia";
            }
        return "/";            
    }
    
    @RequestMapping("/valida-login") 
    public String validaLogin(HttpServletRequest request, Model model, HttpSession httpSession){ 
       httpSession = request.getSession();
       Cliente cliente = new Cliente();
       cliente.setCliemail(request.getParameter("tfEmail")); 
       cliente.setClisenha(request.getParameter("tfSenha")); 
       
       if( dao.validaCliente(cliente)){
            Cliente c1 =  dao.getCliente(cliente);
            try{
                httpSession.setAttribute("cliente",c1);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            return "tarefa/usuario_perfil";
       }else{
            return "/index"; 
       }
            
       
    } 
    
    
//    ///////////////////////////////////////////ADICIONA CARRINHO////////////////////////////////////////////
    @RequestMapping("/adicionaCarrinho")
    public String adicionaCarrinho(Integer proid,Integer cliid,Model model){
        
         List<ProdutoCategoria> pc = prodao.listarProdutosComFoto();
            
        try {
            setImagePath(pc);
        } catch (IOException ex) {
            Logger.getLogger(ControllerGeral.class.getName()).log(Level.SEVERE, null, ex);
        }
        ItemProduto ip = new ItemProduto();
        ItemProduto item = carrinhoDao.existeItem(1, 1);
        if(item.getIteproid() !=null){
            int quantidade = item.getIteqtde() + 1;
            item.setIteqtde(quantidade);
            carrinhoDao.updateItemQtde(item);
            System.out.println("PASSOU EXISTENTE");
        }else{
//            Adiciona no carrinho;
            ip.setIteproid((long)1);
            ip.setItecliid((long)1);
            ip.setIteqtde(1);
           
            System.out.println("PASSOU ADICIONADO");
            carrinhoDao.adicionarItem(item);
        }
//        
        model.addAttribute("produtos",pc);
        model.addAttribute("listaCategorias",catdao.listarCategorias());
        System.out.println(carrinhoDao.qtdeItems((long)1)+"---------");
        model.addAttribute("quantidade", carrinhoDao.qtdeItems((long)1));
        return "/index";
        
    }
    //////////////////////////////////////////////////ALTERA CLIENTE///////////////////////////////
    @RequestMapping("/alteraCliente")
    public String altera(HttpServletRequest request, Model model){
        Cliente cliente = new Cliente();
        
        cliente.setCliid(Long.parseLong(request.getParameter("tfId")));
        cliente.setClinome(request.getParameter("tfNome"));
        cliente.setClisenha(request.getParameter("tfSenha"));
        cliente.setCliemail(request.getParameter("tfEmail"));
        cliente.setClifone(request.getParameter("tfFone"));
        

        dao.alteraCliente(cliente);
        model.addAttribute("listaCategorias",catdao.listarCategorias());
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
    public String addMensagem(HttpServletRequest request, Model  model){
        Mensagem m = new Mensagem();
        m.setMennome(request.getParameter("tfNome"));
        m.setMendesc(request.getParameter("tfMensagem"));
        dao.adicionaMensagem(m);
        model.addAttribute("listaCategorias",catdao.listarCategorias());
        return "tarefa/fale_conosco";
    }
    
    
    @RequestMapping("/trabalhe_conosco")
    public String trabalheConosco(Model model){
        model.addAttribute("listaCategorias",catdao.listarCategorias());
        return "tarefa/trabalhe_conosco";
    }
    
    
   @RequestMapping(value="/adicionaCurriculo")
    public String adiciona(HttpServletRequest request, Model model){
        try {
             MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile multipartFile = multipartRequest.getFile("tfCur");
            
            
            String destinyPath = "C:\\Curriculo\\";
            if(!(new File(destinyPath)).exists()){
                (new File(destinyPath)).mkdir();
            }
            
            String photoName = multipartFile.getOriginalFilename();
            String photoPath = destinyPath + photoName;
                       
            File photoFile = new File(photoPath);
            multipartFile.transferTo(photoFile);
            Curriculo cd = new Curriculo(request.getParameter("tfNome"),request.getParameter("tfEmail"),
            photoName);

            curdao.adicionaCurriculo(cd);
            model.addAttribute("listaCategorias",catdao.listarCategorias());
            return "tarefa/trabalhe_conosco";
            
        } catch (IOException ex) {
        } 
        model.addAttribute("listaCategorias",catdao.listarCategorias());
        return "tarefa/trabalhe_conosco";
    }

    @RequestMapping("/carrinho")
    public String carrinho(Model model){
        model.addAttribute("listaCategorias",catdao.listarCategorias());
        return "tarefa/carro_compras";
    }
    
    
}
