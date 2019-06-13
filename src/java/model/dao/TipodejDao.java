package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.bean.Tipodejeto;
import model.connection.ConnectionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TipodejDao {
    Transaction t;
    Session s;
    List<Tipodejeto> tipos = new ArrayList<Tipodejeto>();
    
    public List<Tipodejeto> listar(){
        s = new ConnectionFactory().getSessionFactory();
        tipos = s.createCriteria(Tipodejeto.class).list();
        s.close();
        return tipos;
    }
    
    public Tipodejeto buscar(String desc){
        s = new ConnectionFactory().getSessionFactory();
        Query q = s.createSQLQuery("SELECT * FROM tipodejeto WHERE tipdesc = '"+desc+"'").addEntity(Tipodejeto.class);
        tipos = q.list();
        return tipos.get(0);
    }
    
    public Tipodejeto buscarId(int id){
        List<Tipodejeto> tipos = new ArrayList<Tipodejeto>();
        s = new ConnectionFactory().getSessionFactory();
        Query q = s.createSQLQuery("SELECT * FROM tipodejeto WHERE tipid = "+id+" ").addEntity(Tipodejeto.class);
        tipos = q.list();
        if(!tipos.isEmpty())
            return tipos.get(0);
        else
            return null;
    }
}
