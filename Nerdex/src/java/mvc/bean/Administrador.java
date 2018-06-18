/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.bean;

/**
 *
 * @author hdolz
 */
public class Administrador {
    
    private long admid;
    private String admnome;
    private String admemail;
    private String admsenha;

    public Administrador() {
    }

    
    public long getAdmid() {
        return admid;
    }

    public void setAdmid(long admid) {
        this.admid = admid;
    }

    public String getAdmnome() {
        return admnome;
    }

    public void setAdmnome(String admnome) {
        this.admnome = admnome;
    }

    public String getAdmemail() {
        return admemail;
    }

    public void setAdmemail(String admemail) {
        this.admemail = admemail;
    }

    public String getAdmsenha() {
        return admsenha;
    }

    public void setAdmsenha(String admsenha) {
        this.admsenha = admsenha;
    }
    
}
