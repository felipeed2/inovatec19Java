package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.bean.Coletor;
import model.bean.Participante;
import model.connection.ConnectionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ParticipanteDao {
    Transaction t;
    Session s;
    List<Participante> participantes = new ArrayList<Participante>();
    
    public void salvar(Participante p){
        s = new ConnectionFactory().getSessionFactory();
        t = s.beginTransaction();
        s.save(p);
        t.commit();
        s.close();
    }    
    
    public Participante buscarCnpj(String cnpj){
        s = new ConnectionFactory().getSessionFactory();
        Query q = s.createSQLQuery("SELECT * FROM participante WHERE parcpf_cnpj = '"+cnpj+"'").addEntity(Participante.class);
        participantes = q.list();
        if(!participantes.isEmpty())
            return participantes.get(0);
        else
            return null;
    }
    
    public Participante buscarId(int id){
        s = new ConnectionFactory().getSessionFactory();
        Query q = s.createSQLQuery("SELECT * FROM participante WHERE parid = "+id+" ").addEntity(Participante.class);
        participantes = q.list();
        if(!participantes.isEmpty())
            return participantes.get(0);
        else
            return null;
    }
}
