package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.bean.Coletor;
import model.connection.ConnectionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ColetorDao {
    Transaction t;
    Session s;
    
    public void salvar(Coletor c){
        s = new ConnectionFactory().getSessionFactory();
        t = s.beginTransaction();
        s.save(c);
        t.commit();
        s.close();
    }

    public Coletor buscarCpf(String cpf){
        List<Coletor> coletores = new ArrayList<Coletor>();
        s = new ConnectionFactory().getSessionFactory();
        Query q = s.createSQLQuery("SELECT * FROM coletor WHERE colcpf_cnpj = '"+cpf+"'").addEntity(Coletor.class);
        coletores = q.list();
        if(!coletores.isEmpty())
            return coletores.get(0);
        else
            return null;
    }

    public Coletor buscarId(int id){
        List<Coletor> coletores = new ArrayList<Coletor>();
        s = new ConnectionFactory().getSessionFactory();
        Query q = s.createSQLQuery("SELECT * FROM coletor WHERE colid = "+id+" ").addEntity(Coletor.class);
        coletores = q.list();
        if(!coletores.isEmpty())
            return coletores.get(0);
        else
            return null;
    }
}
