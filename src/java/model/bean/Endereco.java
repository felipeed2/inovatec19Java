package model.bean;
// Generated 11/06/2019 14:20:42 by Hibernate Tools 4.3.1



/**
 * Endereco generated by hbm2java
 */
public class Endereco  implements java.io.Serializable {


     private Integer endid;
     private String endrua;
     private int endnum;
     private String endbai;

    public Endereco() {
    }

    public Endereco(String endrua, int endnum, String endbai) {
       this.endrua = endrua;
       this.endnum = endnum;
       this.endbai = endbai;
    }
   
    public Integer getEndid() {
        return this.endid;
    }
    
    public void setEndid(Integer endid) {
        this.endid = endid;
    }
    public String getEndrua() {
        return this.endrua;
    }
    
    public void setEndrua(String endrua) {
        this.endrua = endrua;
    }
    public int getEndnum() {
        return this.endnum;
    }
    
    public void setEndnum(int endnum) {
        this.endnum = endnum;
    }
    public String getEndbai() {
        return this.endbai;
    }
    
    public void setEndbai(String endbai) {
        this.endbai = endbai;
    }




}

