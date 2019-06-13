package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Coletor;
import model.bean.Dejeto;
import model.bean.Participante;
import model.bean.Publicacao;
import model.dao.ColetorDao;
import model.dao.DejetoDao;
import model.dao.ParticipanteDao;
import model.dao.PublicacaoDao;

@WebServlet(name = "CtrNovoAnuncio", urlPatterns = {"/CtrNovoAnuncio"})
public class CtrNovoAnuncio extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dejeto d = new Dejeto();
        d.setDejnome(request.getParameter("nomeDejeto"));
        d.setDejtipid(Integer.parseInt(request.getParameter("tipoDejeto")));
        DejetoDao dejdao = new DejetoDao();
        dejdao.salvar(d);
        d = dejdao.buscar(d.getDejnome(), d.getDejtipid());
        if(d==null){
            System.out.println("Erro: Dejeto não encontrado.");
        }else{
            System.out.println("dejeto encontrado");
            Publicacao pub = new Publicacao();
            PublicacaoDao pdao = new PublicacaoDao();
            
            pub.setPubbairro(request.getParameter("bairro"));
            pub.setPubdejid(d.getDejid());
            pub.setPubdejqtde(Float.parseFloat(request.getParameter("qntd")));
            pub.setPubestatus(true);
            pub.setPubnum(Integer.parseInt(request.getParameter("num")));
            pub.setPubrua(request.getParameter("rua"));
            
            Coletor col = new Coletor();
            ColetorDao cdao = new ColetorDao();
            col.setColcpfCnpj(request.getParameter("cpfcnpj"));
            col = cdao.buscarCpf(col.getColcpfCnpj());
            if(col == null){
                System.out.println("Erro coletor não encontrado");
                pub.setPubcolid(null);
                Participante part = new Participante();
                ParticipanteDao pardao = new ParticipanteDao();
                part = pardao.buscarCnpj(request.getParameter("cpfcnpj"));
                pub.setPubparid(null);
                if(part == null){
                    System.out.println("Erro empresa não encontrada");
                    request.getRequestDispatcher("AnuncioNovo.jsp?result=naoEncontrado").forward(request, response);
                }else{
                    System.out.println("Empresa encontrada. cod:"+part.getParid());
                    pub.setPubparid(part.getParid());
                    pdao.salvar(pub);
                    request.getRequestDispatcher("AnuncioNovo.jsp?result=sucesso").forward(request, response);
                }
            }else{
                System.out.println("Pessoa encontrada. cod:"+col.getColid());
                pub.setPubcolid(col.getColid());
                pub.setPubparid(null);
                pdao.salvar(pub);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
