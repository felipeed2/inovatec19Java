package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.bean.Dejeto;
import model.connection.ConnectionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DejetoDao {
    Transaction t;
    Session s;
    
    public void salvar(Dejeto d){
        s = new ConnectionFactory().getSessionFactory();
        t = s.beginTransaction();
        s.save(d);
        t.commit();
        s.close();
    }
    
    public Dejeto buscar(String nome, int tipo){
        List<Dejeto> dejetos = new ArrayList<Dejeto>();
        s = new ConnectionFactory().getSessionFactory();
        Query q = s.createSQLQuery("SELECT * FROM dejeto WHERE dejnome = '"+nome+"' AND dejtipid = "+tipo+" ").addEntity(Dejeto.class);
        dejetos = q.list();
        if(!dejetos.isEmpty())
            return dejetos.get(0);
        else
            return null;
    }
    
    public Dejeto buscarId(int id){
        List<Dejeto> dejetos = new ArrayList<Dejeto>();
        s = new ConnectionFactory().getSessionFactory();
        Query q = s.createSQLQuery("SELECT * FROM dejeto WHERE dejid = "+id+" ").addEntity(Dejeto.class);
        dejetos = q.list();
        if(!dejetos.isEmpty())
            return dejetos.get(0);
        else
            return null;
    }
}
