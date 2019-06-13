package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Avaliacao;
import model.connection.ConnectionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AvaliacaoDao {
    Transaction t;
    Session s;
    List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
    
    public void salvar(Avaliacao a){
        s = new ConnectionFactory().getSessionFactory();
        t = s.beginTransaction();
        s.save(a);
        t.commit();
        s.close();
    }
}
