package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Tipopessoa;
import model.connection.ConnectionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TippessDao {
    Transaction t;
    Session s;
    List<Tipopessoa> tipos = new ArrayList<Tipopessoa>();
    
    public void salvar(Tipopessoa e){
        s = new ConnectionFactory().getSessionFactory();
        t = s.beginTransaction();
        s.save(e);
        t.commit();
        s.close();
    }
    
    public Tipopessoa buscar(String tipo, String nome, String nomef, String razaos){
        s = new ConnectionFactory().getSessionFactory();
        Query q;
        if(tipo.equals("jur"))
            q = s.createSQLQuery("SELECT * FROM tipopessoa WHERE tippdesc = '"+tipo+"' AND tipprazao = '"+razaos+"' AND tippnomef = '"+nomef+"' ").addEntity(Tipopessoa.class);
        else
            q = s.createSQLQuery("SELECT * FROM tipopessoa WHERE tippdesc = '"+tipo+"' AND tippnome= '"+nome+"' ").addEntity(Tipopessoa.class);
        System.out.println("Buscando por tipopessoa: tippdesc:"+tipo+", tippnome:"+nome+", tippnomef:"+nomef+", tipprazao"+razaos+".");
        tipos = q.list();
        if(tipos.isEmpty() == false){
            return tipos.get(0);
        }else{
            System.out.println("lista tipopessoa vazia");
            return null;
        }
    }
    
    public Tipopessoa buscarId(int id){
        s = new ConnectionFactory().getSessionFactory();
        Query q = s.createSQLQuery("SELECT * FROM tipopessoa WHERE tippid = "+id+"").addEntity(Tipopessoa.class);
        tipos = q.list();
        if(!tipos.isEmpty())
            return tipos.get(0);
        else
            return null;
    }
}
