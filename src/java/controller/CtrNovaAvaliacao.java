package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Avaliacao;
import model.dao.AvaliacaoDao;

@WebServlet(name = "CtrNovaAvaliacao", urlPatterns = {"/CtrNovaAvaliacao"})
public class CtrNovaAvaliacao extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Avaliacao av = new Avaliacao();
        AvaliacaoDao avdao = new AvaliacaoDao();
        
        av.setAvadesc(request.getParameter("opiniao"));
        av.setAvacurso(request.getParameter("curso"));
        av.setAvamat(Integer.parseInt(request.getParameter("matricula")));
        av.setAvanome(request.getParameter("nomeCompleto"));
        
        avdao.salvar(av);
        
        request.getRequestDispatcher("AvaliacaoForm.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
