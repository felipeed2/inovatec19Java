package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Coletor;
import model.bean.Endereco;
import model.bean.Participante;
import model.bean.Tipopessoa;
import model.dao.ColetorDao;
import model.dao.EnderecoDao;
import model.dao.ParticipanteDao;
import model.dao.TippessDao;

@WebServlet(name = "CtrNovoUsuario", urlPatterns = {"/CtrNovoUsuario"})
public class CtrNovoUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Endereco end = new Endereco();
        EnderecoDao enddao = new EnderecoDao();
        Tipopessoa tp = new Tipopessoa();
        TippessDao tpdao = new TippessDao();
        
        end.setEndbai(request.getParameter("bairro"));
        end.setEndnum(Integer.parseInt(request.getParameter("numero")));
        end.setEndrua(request.getParameter("rua"));
        enddao.salvar(end);
        
        end = enddao.buscar(end.getEndrua(), end.getEndnum(), end.getEndbai());
        
        if(request.getParameter("tipoPessoa").equals("fis")){
            tp.setTippdesc("fis");
            tp.setTippnome(request.getParameter("nome"));
            tp.setTipprazao(null);
            tp.setTippnomef(null);
            tpdao.salvar(tp);
            tp = tpdao.buscar(tp.getTippdesc(), tp.getTippnome(), tp.getTippnomef(), tp.getTipprazao());
            
            Coletor c = new Coletor();
            ColetorDao cdao = new ColetorDao();
            c.setColcpfCnpj(request.getParameter("cpfcnpj"));
            c.setColtel(request.getParameter("tel"));
            c.setColendid(end.getEndid());
            c.setTipcolid(tp.getTippid());
            
            if(c.getTipcolid() != null)
                cdao.salvar(c);
            else
                System.out.println("Tipo pessoa está nulo.");
        }else{
            tp.setTippnome(null);
            tp.setTippdesc("jur");
            tp.setTippnomef(request.getParameter("nome"));
            tp.setTipprazao(request.getParameter("razaoSocial"));
            tpdao.salvar(tp);
            tp = tpdao.buscar(tp.getTippdesc(), tp.getTippnome(), tp.getTippnomef(), tp.getTipprazao());
            
            Participante p = new Participante();
            ParticipanteDao pdao = new ParticipanteDao();
            p.setParcpfCnpj(request.getParameter("cpfcnpj"));
            p.setPartel(request.getParameter("tel"));
            p.setParendid(end.getEndid());
            p.setTipparid(tp.getTippid());
            
            if(p.getTipparid() != null)
                pdao.salvar(p);
            else
                System.out.println("Tipo pessoa está nulo.");
        }
        
        request.getRequestDispatcher("Cadastro.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
