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
public class Curriculo {
    private long curid;
    private String curnome;
    private String curemail;
    private String curcaminho;

    public Curriculo(String curnome, String curemail, String curcaminho) {
        this.curnome = curnome;
        this.curemail = curemail;
        this.curcaminho = curcaminho;
    }
    public Curriculo(){};

    public String getCurnome() {
        return curnome;
    }

    public void setCurnome(String curnome) {
        this.curnome = curnome;
    }

    public String getCuremail() {
        return curemail;
    }

    public void setCuremail(String curemail) {
        this.curemail = curemail;
    }
    
    
    public long getCurid() {
        return curid;
    }

    public void setCurid(long curid) {
        this.curid = curid;
    }

    public String getCurcaminho() {
        return curcaminho;
    }

    public void setCurcaminho(String curcaminho) {
        this.curcaminho = curcaminho;
    }
    
    
    
}
