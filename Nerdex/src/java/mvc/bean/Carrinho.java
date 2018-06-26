/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.bean;

/**
 *
 * @author 600109
 */
public class Carrinho {
    private Long venid;
    private Long venproid;
    private String venpronome;
    private int venqtde;

    public Carrinho(Long venid, Long venproid, String venpronome, int venqtde) {
        this.venid = venid;
        this.venproid = venproid;
        this.venpronome = venpronome;
        this.venqtde = venqtde;
    }

    public Long getVenid() {
        return venid;
    }

    public void setVenid(Long venid) {
        this.venid = venid;
    }

    public Long getVenproid() {
        return venproid;
    }

    public void setVenproid(Long venproid) {
        this.venproid = venproid;
    }

    public String getVenpronome() {
        return venpronome;
    }

    public void setVenpronome(String venpronome) {
        this.venpronome = venpronome;
    }

    public int getVenqtde() {
        return venqtde;
    }

    public void setVenqtde(int venqtde) {
        this.venqtde = venqtde;
    }
    
    

    
}
