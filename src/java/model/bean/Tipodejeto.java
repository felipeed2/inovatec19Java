package model.bean;

public class Tipodejeto  implements java.io.Serializable {


     private Integer tipid;
     private String tipdesc;

    public Tipodejeto() {
    }

    public Tipodejeto(String tipdesc) {
       this.tipdesc = tipdesc;
    }
   
    public Integer getTipid() {
        return this.tipid;
    }
    
    public void setTipid(Integer tipid) {
        this.tipid = tipid;
    }
    public String getTipdesc() {
        return this.tipdesc;
    }
    
    public void setTipdesc(String tipdesc) {
        this.tipdesc = tipdesc;
    }

}


