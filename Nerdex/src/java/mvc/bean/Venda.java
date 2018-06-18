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
public class Venda {
    private long venid;
    private long cliid;
    private long venproid;
    private long venforid;
    private double venpreco;

    public Venda(long cliid, long venproid, long venforid, double venpreco) {
        this.cliid = cliid;
        this.venproid = venproid;
        this.venforid = venforid;
        this.venpreco = venpreco;
    }

    public Venda(long venid, long cliid, long venproid, long venforid, double venpreco) {
        this.venid = venid;
        this.cliid = cliid;
        this.venproid = venproid;
        this.venforid = venforid;
        this.venpreco = venpreco;
    }

    public long getVenid() {
        return venid;
    }

    public void setVenid(long venid) {
        this.venid = venid;
    }

    public long getCliid() {
        return cliid;
    }

    public void setCliid(long cliid) {
        this.cliid = cliid;
    }

    public long getVenproid() {
        return venproid;
    }

    public void setVenproid(long venproid) {
        this.venproid = venproid;
    }

    public long getVenforid() {
        return venforid;
    }

    public void setVenforid(long venforid) {
        this.venforid = venforid;
    }

    public double getVenpreco() {
        return venpreco;
    }

    public void setVenpreco(double venpreco) {
        this.venpreco = venpreco;
    }
    
    
    

    
}
