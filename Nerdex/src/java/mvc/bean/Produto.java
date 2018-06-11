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

public class Produto {
    private long proid;
    private long procatid;
    private String pronome;
    private double propreco;
    private String prodes;
    private String procam;
        
    public Produto(long procatid, String pronome, double propreco, String prodes, String procam) {
        this.procatid = procatid;
        this.pronome = pronome;
        this.propreco = propreco;
        this.prodes = prodes;
        this.procam = procam;
    }
    public Produto(long proid, long procatid, String pronome, double propreco, String prodes) {
        this.proid = proid;
        this.procatid = procatid;
        this.pronome = pronome;
        this.propreco = propreco;
        this.prodes = prodes;
    }

    public Produto(long proid, long procatid, String pronome, double propreco, String prodes, String procam) {
        this.proid = proid;
        this.procatid = procatid;
        this.pronome = pronome;
        this.propreco = propreco;
        this.prodes = prodes;
        this.procam = procam;
    }
    
    
    public long getProcatid() {
        return procatid;
    }

    public void setProcatid(long procatid) {
        this.procatid = procatid;
    }



    public Produto() {
    }

    public long getProid() {
        return proid;
    }

    public void setProid(long proid) {
        this.proid = proid;
    }

    public String getPronome() {
        return pronome;
    }

    public void setPronome(String pronome) {
        this.pronome = pronome;
    }

    public double getPropreco() {
        return propreco;
    }

    public void setPropreco(double propreco) {
        this.propreco = propreco;
    }

    public String getProdes() {
        return prodes;
    }

    public void setProdes(String prodes) {
        this.prodes = prodes;
    }

    public String getProcam() {
        return procam;
    }

    public void setProcam(String procam) {
        this.procam = procam;
    }
    
    
}
