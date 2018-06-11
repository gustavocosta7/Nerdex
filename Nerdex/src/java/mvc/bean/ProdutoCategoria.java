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
public class ProdutoCategoria {
    private long proid;
    private long procatid;
    private String pronome;
    private String procatdescricao;
    private double propreco;
    private String prodes;
    private String procam;

    public ProdutoCategoria(long proid, long procatid, String pronome, String procatdescricao, double propreco, String prodes, String procam) {
        this.proid = proid;
        this.procatid = procatid;
        this.pronome = pronome;
        this.procatdescricao = procatdescricao;
        this.propreco = propreco;
        this.prodes = prodes;
        this.procam = procam;
    }

    public ProdutoCategoria() {
    }

    
    
    public String getProcam() {
        return procam;
    }

    public void setProcam(String procam) {
        this.procam = procam;
    }

    public String getProdes() {
        return prodes;
    }

    public void setProdes(String prodes) {
        this.prodes = prodes;
    }
    
    
    
    
    public String getPronome() {
        return pronome;
    }

    public void setPronome(String pronome) {
        this.pronome = pronome;
    }

    public ProdutoCategoria(long proid, long procatid, String pronome, String procatdescricao, double propreco) {
        this.proid = proid;
        this.procatid = procatid;
        this.pronome = pronome;
        this.procatdescricao = procatdescricao;
        this.propreco = propreco;
    }

    
    public long getProid() {
        return proid;
    }

    public void setProid(long proid) {
        this.proid = proid;
    }

    public long getProcatid() {
        return procatid;
    }

    public void setProcatid(long procatid) {
        this.procatid = procatid;
    }

    public String getProcatdescricao() {
        return procatdescricao;
    }

    public void setProcatdescricao(String procatdescricao) {
        this.procatdescricao = procatdescricao;
    }

    public double getPropreco() {
        return propreco;
    }

    public void setPropreco(double propreco) {
        this.propreco = propreco;
    }
    
    
    
}
