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
public class ItemProduto {
    private Long iteproid;
    private Long itecliid;
    private Integer iteqtde;

    public ItemProduto(Long iteproid, Long itecliid, Integer iteqtde) {
        this.iteproid = iteproid;
        this.itecliid = itecliid;
        this.iteqtde = iteqtde;
    }

    public ItemProduto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Long getIteproid() {
        return iteproid;
    }

    public void setIteproid(Long iteproid) {
        this.iteproid = iteproid;
    }

    public Long getItecliid() {
        return itecliid;
    }

    public void setItecliid(Long itecliid) {
        this.itecliid = itecliid;
    }

    public Integer getIteqtde() {
        return iteqtde;
    }

    public void setIteqtde(Integer iteqtde) {
        this.iteqtde = iteqtde;
    }

   
}
