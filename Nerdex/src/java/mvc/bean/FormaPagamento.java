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
public class FormaPagamento {
    private long forid;
    private String fordes;

    public FormaPagamento(long forid, String fordes) {
        this.forid = forid;
        this.fordes = fordes;
    }

    public FormaPagamento(String fordes) {
        this.fordes = fordes;
    }

    public long getForid() {
        return forid;
    }

    public void setForid(long forid) {
        this.forid = forid;
    }

    public String getFordes() {
        return fordes;
    }

    public void setFordes(String fordes) {
        this.fordes = fordes;
    }
    
}
