<%@page import="model.bean.Endereco"%>
<%@page import="model.dao.EnderecoDao"%>
<%@page import="model.dao.TipodejDao"%>
<%@page import="model.dao.DejetoDao"%>
<%@page import="model.dao.TippessDao"%>
<%@page import="model.bean.Tipopessoa"%>
<%@page import="model.bean.Participante"%>
<%@page import="model.bean.Coletor"%>
<%@page import="model.dao.ParticipanteDao"%>
<%@page import="model.dao.ColetorDao"%>
<%@page import="model.dao.PublicacaoDao"%>
<%@page import="model.bean.Publicacao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Anúncios disponíveis</title>
        <link rel="stylesheet" href="css/Style.css">
        <link rel="stylesheet" href="css/anuncios.css">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <%
        
            List<Publicacao> publicacoes = new ArrayList<Publicacao>();
            PublicacaoDao pubdao = new PublicacaoDao();
            ColetorDao cdao = new ColetorDao();
            ParticipanteDao pardao = new ParticipanteDao();
            TippessDao tpdao = new TippessDao();
            DejetoDao dejdao = new DejetoDao();
            TipodejDao tpdejdao = new TipodejDao();
            EnderecoDao edao = new EnderecoDao();
        %>
        
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="index.jsp">
                <img src="img/LogoIcon.png" width="35" height="35" class="d-inline-block align-top" alt="">Select
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Anúncios</a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="AnuncioNovo.jsp">Novo Anúncio</a>
                            <a class="dropdown-item" href="ListAnuncio.jsp">Disponíveis</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AvaliacaoForm.jsp">Avalie-nos!</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Cadastro.jsp">Cadastrar usuário</a>
                    </li>
                </ul>
            </div>
        </nav>
        <section>
            <h1>Anúncios disponíveis</h1>
            <hr>
            <%
                for(Publicacao p: pubdao.listar()){
                    Coletor c = new Coletor();
                    Participante part = new Participante();
                    Tipopessoa tp = new Tipopessoa();
                    Endereco end = new Endereco();
            %>
            <div class="painel">
                <%if(p.getPubcolid() != null){%>
                <p><%
                    c = cdao.buscarId(p.getPubcolid());
                    end = edao.buscarId(c.getColendid());
                    out.println(tpdao.buscarId(c.getTipcolid()).getTippnome());
                %></p>
                <%}else{%>
                <p><%
                    part = pardao.buscarId(p.getPubparid());
                    end = edao.buscarId(part.getParendid());
                    out.println(tpdao.buscarId(part.getTipparid()).getTippnomef());
                %></p>
                <%}%>
                <p><%=dejdao.buscarId(p.getPubdejid()).getDejnome()%></p>
                <p><%=p.getPubdejqtde()%></p>
                <p><%=tpdejdao.buscarId(dejdao.buscarId(p.getPubdejid()).getDejtipid()).getTipdesc()%></p>
                <p><%=end.getEndbai()+", "+end.getEndrua()+" - "+end.getEndnum()%></p>
            </div>
            <%}%>
        </section>
        <footer class="page-footer font-small bg-dark">
            <div class="footer-copyright text-center py-3">Select - Inovatec 2019</div>
        </footer>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
