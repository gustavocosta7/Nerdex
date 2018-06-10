/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.bean;

/**
 *
 * @author Aluno
 */
public class Mensagem {
    private long menid;
    private String mennome;
    private String mendesc;

    public Mensagem() {
    }

    public long getMenid() {
        return menid;
    }

    public void setMenid(long menid) {
        this.menid = menid;
    }

    public String getMennome() {
        return mennome;
    }

    public void setMennome(String mennome) {
        this.mennome = mennome;
    }

    public String getMendesc() {
        return mendesc;
    }

    public void setMendesc(String mendesc) {
        this.mendesc = mendesc;
    }
    
    
}
