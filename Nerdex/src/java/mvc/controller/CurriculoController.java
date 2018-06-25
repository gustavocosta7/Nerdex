/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public void visualizarCurriculo(HttpServletRequest request,
			HttpServletResponse response, Long id,Model model){
        try {
            Curriculo cur = dao.getCurriculo(id);
            byte[] arquivo = null;
            File file = new File("C:/Curriculo/" + cur.getCurcaminho());
            arquivo = fileToByte(file);
            System.out.println(" - Conversão de arquivo para array de bytes -");
            //define tipo de resposta
            response.setContentType("application/pdf");
            response.setContentLength(arquivo.length);
            //faz a saida de bytes
            ServletOutputStream ouputStream = response.getOutputStream();
            ouputStream.write(arquivo, 0, arquivo.length);
            ouputStream.flush();
            ouputStream.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    //realiza imput de array de bytes 
//    public static InputStream byteToInputStream(byte[] bytes) throws Exception {
//        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
//        return bais;
//    }
    //converte arquivo em array de bytes
    public static byte[] fileToByte(File arquivo) throws Exception {
        FileInputStream fis = new FileInputStream(arquivo);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[8192];
        int bytesRead = 0;
        while ((bytesRead = fis.read(buffer, 0, 8192)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }
        fis.close();
        return baos.toByteArray();
    }
    
    
    @RequestMapping("/excluirCurriculo")
    public String excluirCurriculo(int id){
        Curriculo cur = dao.getCurriculo(id);
        dao.removerCurriculo(id);
        File file = new File("C:/Curriculo/"+cur.getCurcaminho());
        if(file.delete()) {
            System.out.println("Arquivo '"+cur.getCurcaminho()+"' deletado com sucesso!");
        }else{ 
            System.out.println("Erro ao deletar arquivo!");
        }
        return "redirect:/crudCurriculo";
    }

    
}
