/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;


import java.io.IOException;
import java.util.List;
import mvc.bean.Categoria;
import mvc.bean.Mensagem;
import mvc.dao.AdminDAO;
import mvc.dao.MensagemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Aluno
 */
@Controller
public class MensagemController {

    
    private final MensagemDAO dao;

    @Autowired
    public MensagemController(MensagemDAO dao) {
        this.dao = dao;
    }
    
    @RequestMapping("/crudMensagem")
    public String lista(Model model) throws IOException{
        List<Mensagem> listaMensagens = dao.listarMensagem();
        model.addAttribute("listaMensagem", listaMensagens);
        return "tarefa/mensagem/mensagem_principal";
    }
    
    @RequestMapping("/excluirMensagem")
    public String remove(int id){
        dao.removerMensagem(id);
        return "redirect:/crudMensagem";
    }
    
    
    @RequestMapping("/exibirMensagem")
    public String exibe(Long id,Model model){
        model.addAttribute("mens", dao.retornaMensagem(id));
        return "tarefa/mensagem/exibe_mensagem";
    }

    
}
