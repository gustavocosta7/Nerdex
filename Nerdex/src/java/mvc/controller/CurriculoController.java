/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;


import java.io.IOException;
import java.util.List;
import mvc.bean.Curriculo;
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
public class CurriculoController {

    
    private final CurriculoDao dao;

    @Autowired
    public CurriculoController(CurriculoDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping("/crudCurriculo")
    public String crudCurriculo(Model model) throws IOException{
        List<Curriculo> listaCurriculos = dao.listarCurriculos();
        model.addAttribute("listaCurriculo", listaCurriculos);
        return "tarefa/curriculo/curriculo_principal";
    }
    
    @RequestMapping("/visualizarCurriculo")
    public String visualizarCurriculo(Long id,Model model){
        
//        responseScope.setHeader("Content-Disposition", "attachment; filename=\"" + nomeDoSeuArquivo + ".pdf" + "\";"<img src="http://javafree.uol.com.br/forum/images/smiles/icon_wink.gif">;  
//        responseScope.setContentLength(anexoBytes.length);  
//        //anexoBytes eh o seu arquivo pdf transformado numa array de bytes.  
//        ServletOutputStream ouputStream = responseScope.getOutputStream();  
//        ouputStream.write(anexoBytes, 0, anexoBytes.length);  
//        ouputStream.flush();  
//        ouputStream.close();  
        
        
        
        
        
        
//        model.addAttribute("mens", dao.retornaMensagem(id));
        return "tarefa/curriculo/exibe_curriculo";
    }
    
    @RequestMapping("/excluirCurriculo")
    public String excluirCurriculo(int id){
        dao.removerCurriculo(id);
        return "redirect:/crudCurriculo";
    }

    
}
