package model.bean;

import java.util.Date;

public class Publicacao  implements java.io.Serializable {


     private Integer pubid;
     private Date pubdata;
     private String pubrua;
     private String pubbairro;
     private int pubnum;
     private float pubdejqtde;
     private boolean pubestatus;
     private Integer pubparid;
     private Integer pubcolid;
     private Integer pubdejid;

    public Publicacao() {
    }

	
    public Publicacao(Date pubdata, String pubrua, String pubbairro, int pubnum, float pubdejqtde, boolean pubestatus) {
        this.pubdata = pubdata;
        this.pubrua = pubrua;
        this.pubbairro = pubbairro;
        this.pubnum = pubnum;
        this.pubdejqtde = pubdejqtde;
        this.pubestatus = pubestatus;
    }
    public Publicacao(Date pubdata, String pubrua, String pubbairro, int pubnum, float pubdejqtde, boolean pubestatus, Integer pubparid, Integer pubcolid, Integer pubdejid) {
       this.pubdata = pubdata;
       this.pubrua = pubrua;
       this.pubbairro = pubbairro;
       this.pubnum = pubnum;
       this.pubdejqtde = pubdejqtde;
       this.pubestatus = pubestatus;
       this.pubparid = pubparid;
       this.pubcolid = pubcolid;
       this.pubdejid = pubdejid;
    }
   
    public Integer getPubid() {
        return this.pubid;
    }
    
    public void setPubid(Integer pubid) {
        this.pubid = pubid;
    }
    public Date getPubdata() {
        return this.pubdata;
    }
    
    public void setPubdata(Date pubdata) {
        this.pubdata = pubdata;
    }
    public String getPubrua() {
        return this.pubrua;
    }
    
    public void setPubrua(String pubrua) {
        this.pubrua = pubrua;
    }
    public String getPubbairro() {
        return this.pubbairro;
    }
    
    public void setPubbairro(String pubbairro) {
        this.pubbairro = pubbairro;
    }
    public int getPubnum() {
        return this.pubnum;
    }
    
    public void setPubnum(int pubnum) {
        this.pubnum = pubnum;
    }
    public float getPubdejqtde() {
        return this.pubdejqtde;
    }
    
    public void setPubdejqtde(float pubdejqtde) {
        this.pubdejqtde = pubdejqtde;
    }
    public boolean isPubestatus() {
        return this.pubestatus;
    }
    
    public void setPubestatus(boolean pubestatus) {
        this.pubestatus = pubestatus;
    }
    public Integer getPubparid() {
        return this.pubparid;
    }
    
    public void setPubparid(Integer pubparid) {
        this.pubparid = pubparid;
    }
    public Integer getPubcolid() {
        return this.pubcolid;
    }
    
    public void setPubcolid(Integer pubcolid) {
        this.pubcolid = pubcolid;
    }
    public Integer getPubdejid() {
        return this.pubdejid;
    }
    
    public void setPubdejid(Integer pubdejid) {
        this.pubdejid = pubdejid;
    }




}


