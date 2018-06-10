/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.bean;

/**
 *
 * @author gustav0
 */


public class Cliente {
    private long cliid;
    private String clinome;
    private String cliemail;
    private String clisenha;    
    private String clifone;

    public Cliente(String clinome, String cliemail,String clisenha, String clifone) {
        this.clinome = clinome;
        this.cliemail = cliemail;
        this.clisenha = clisenha;
        this.clifone = clifone;
    }

    public String getClisenha() {
        return clisenha;
    }

    public void setClisenha(String clisenha) {
        this.clisenha = clisenha;
    }

    public Cliente() {
    }

    
    
    public long getCliid() {
        return cliid;
    }

    public void setCliid(long cliid) {
        this.cliid = cliid;
    }

    public String getClinome() {
        return clinome;
    }

    public void setClinome(String clinome) {
        this.clinome = clinome;
    }

    public String getCliemail() {
        return cliemail;
    }

    public void setCliemail(String cliemail) {
        this.cliemail = cliemail;
    }

    public String getClifone() {
        return clifone;
    }

    public void setClifone(String clifone) {
        this.clifone = clifone;
    }
    
    
}
