package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.registry.infomodel.User;
import model.bean.Publicacao;
import model.connection.ConnectionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PublicacaoDao {
    Transaction t;
    Session s;
    
    public void salvar(Publicacao p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            if(p.getPubcolid() != null){
                stmt = con.prepareStatement("INSERT INTO publicacao (pubdata,pubrua,pubbairro,pubnum,pubdejqtde,pubestatus,pubcolid,pubdejid) VALUES (CURRENT_DATE(),?,?,?,?,1,?,?)");
                stmt.setString(1, p.getPubrua());
                stmt.setString(2, p.getPubbairro());
                stmt.setInt(3, p.getPubnum());
                stmt.setFloat(4, p.getPubdejqtde());
                stmt.setInt(5, p.getPubcolid());
                stmt.setInt(6, p.getPubdejid());
            }else{
                stmt = con.prepareStatement("INSERT INTO publicacao (pubdata,pubrua,pubbairro,pubnum,pubdejqtde,pubestatus,pubparid,pubdejid) VALUES (CURRENT_DATE(),?,?,?,?,1,?,?)");
                stmt.setString(1, p.getPubrua());
                stmt.setString(2, p.getPubbairro());
                stmt.setInt(3, p.getPubnum());
                stmt.setFloat(4, p.getPubdejqtde());
                stmt.setInt(5, p.getPubparid());
                stmt.setInt(6, p.getPubdejid());
            }
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar: "+ex);
        }
    }
    
    public List<Publicacao> listar(){
        List<Publicacao> pubs = new ArrayList<Publicacao>();
        s = new ConnectionFactory().getSessionFactory();
        pubs = s.createCriteria(Publicacao.class).list();
        return pubs;
    }
}
