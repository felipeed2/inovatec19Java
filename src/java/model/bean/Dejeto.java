package model.bean;
// Generated 11/06/2019 14:20:42 by Hibernate Tools 4.3.1



/**
 * Dejeto generated by hbm2java
 */
public class Dejeto  implements java.io.Serializable {


     private Integer dejid;
     private String dejnome;
     private int dejtipid;

    public Dejeto() {
    }

    public Dejeto(String dejnome, int dejtipid) {
       this.dejnome = dejnome;
       this.dejtipid = dejtipid;
    }
   
    public Integer getDejid() {
        return this.dejid;
    }
    
    public void setDejid(Integer dejid) {
        this.dejid = dejid;
    }
    public String getDejnome() {
        return this.dejnome;
    }
    
    public void setDejnome(String dejnome) {
        this.dejnome = dejnome;
    }
    public int getDejtipid() {
        return this.dejtipid;
    }
    
    public void setDejtipid(int dejtipid) {
        this.dejtipid = dejtipid;
    }




}


