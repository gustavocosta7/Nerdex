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
public class Categoria {
    private Long catid;
    private String catdes;

    public Categoria(Long catid, String catdes) {
        this.catid = catid;
        this.catdes = catdes;
    }

    public Categoria() {
    }

    public long getCatid() {
        return catid;
    }

    public void setCatid(Long catid) {
        this.catid = catid;
    }

    public String getCatdes() {
        return catdes;
    }

    public void setCatdes(String catdes) {
        this.catdes = catdes;
    }
    
    
}
