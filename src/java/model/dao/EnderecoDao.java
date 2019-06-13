package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.bean.Endereco;
import model.connection.ConnectionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EnderecoDao {
    Transaction t;
    Session s;
    List<Endereco> enderecos = new ArrayList<Endereco>();
    
    public void salvar(Endereco e){
        s = new ConnectionFactory().getSessionFactory();
        t = s.beginTransaction();
        s.save(e);
        t.commit();
        s.close();
    }
    
    public Endereco buscar(String rua, int numero, String bairro){
        s = new ConnectionFactory().getSessionFactory();
        Query q = s.createSQLQuery("SELECT endid, endrua, endnum, endbai FROM endereco WHERE endrua = '"+rua+"' AND endnum= "+numero+" AND endbai = '"+bairro+"' ").addEntity(Endereco.class);
        enderecos = q.list();
        return enderecos.get(0);
    }
    
    public Endereco buscarId(int id){
        s = new ConnectionFactory().getSessionFactory();
        Query q = s.createSQLQuery("SELECT * FROM endereco WHERE endid = "+id+"").addEntity(Endereco.class);
        enderecos = q.list();
        if(!enderecos.isEmpty())
            return enderecos.get(0);
        else
            return null;
    }
}
