package model.bean;
// Generated 11/06/2019 14:20:42 by Hibernate Tools 4.3.1



/**
 * Participante generated by hbm2java
 */
public class Participante  implements java.io.Serializable {


     private Integer parid;
     private String partel;
     private String parcpfCnpj;
     private Integer parendid;
     private Integer tipparid;

    public Participante() {
    }

	
    public Participante(String partel, String parcpfCnpj) {
        this.partel = partel;
        this.parcpfCnpj = parcpfCnpj;
    }
    public Participante(String partel, String parcpfCnpj, Integer parendid, Integer tipparid) {
       this.partel = partel;
       this.parcpfCnpj = parcpfCnpj;
       this.parendid = parendid;
       this.tipparid = tipparid;
    }
   
    public Integer getParid() {
        return this.parid;
    }
    
    public void setParid(Integer parid) {
        this.parid = parid;
    }
    public String getPartel() {
        return this.partel;
    }
    
    public void setPartel(String partel) {
        this.partel = partel;
    }
    public String getParcpfCnpj() {
        return this.parcpfCnpj;
    }
    
    public void setParcpfCnpj(String parcpfCnpj) {
        this.parcpfCnpj = parcpfCnpj;
    }
    public Integer getParendid() {
        return this.parendid;
    }
    
    public void setParendid(Integer parendid) {
        this.parendid = parendid;
    }
    public Integer getTipparid() {
        return this.tipparid;
    }
    
    public void setTipparid(Integer tipparid) {
        this.tipparid = tipparid;
    }




}

