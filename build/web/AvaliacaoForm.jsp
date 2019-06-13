<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Avalie-nos</title>
        <link rel="stylesheet" href="css/Style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
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

        <div class="container">
            <form method="post" action="CtrNovaAvaliacao" style="margin: 100px 0px;">
                <h1>Avalie-nos!</h1><hr>
                <div class="form-row">
                    <div class="form-group col-md-10">
                        <label for="nomeCompleto">Nome completo</label>
                        <input type="text" class="form-control" id="nomeCompleto" name="nomeCompleto" required>
                    </div>
                    <div class="form-group col-md-2">
                        <label for="matricula">Matrícula</label>
                        <input type="numeric" class="form-control" id="matricula" name="matricula" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-12">
                        <label for="curso">Curso</label>
                        <select class="form-control" id="curso" name="curso">
                            <option value="Administração">Administração</option>
                            <option value="Arquitetura">Arquitetura</option>
                            <option value="Biomedicina">Biomedicina</option>
                            <option value="Ciências Contábeis">Ciências Contábeis</option>
                            <option value="Direito">Direito</option>
                            <option value="Educação Física">Educação Física</option>
                            <option value="Enfermagem">Enfermagem</option>
                            <option value="Eng Ambiental">Eng Ambiental</option>
                            <option value="Eng Elétrica">Eng Elétrica</option>
                            <option value="Eng Produção">Eng Produção</option>
                            <option value="Eng Civil">Eng Civil</option>
                            <option value="Farmácia">Farmácia</option>
                            <option value="Fisioterapia">Fisioterapia</option>
                            <option value="Fonoaudiologia">Fonoaudiologia</option>
                            <option value="Medicina">Medicina</option>
                            <option value="Medicina Veterinária">Medicina Veterinária</option>
                            <option value="Nutrição">Nutrição</option>
                            <option value="Odontologia">Odontologia</option>
                            <option value="Pedagogia">Pedagogia</option>
                            <option value="Psicologia">Psicologia</option>
                            <option value="Química">Química</option>
                            <option value="Serviço Social">Serviço Social</option>
                            <option value="Turismo">Turismo</option>
                            <option value="Hotelaria">Hotelaria</option>
                            <option value="Jornalismo">Jornalismo</option>
                            <option value="Outros">Outros</option>
                        </select>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-12">
                        <label for="opiniao">Sua opinião</label>
                        <textarea class="form-control" id="opiniao" name="opiniao" rows="3" maxlength="250"></textarea>
                    </div>
                </div>
                <button type="submit" class="btn btn-success">Enviar</button>
            </form>
        </div>
        <footer class="page-footer font-small bg-dark fixed-bottom">
            <div class="footer-copyright text-center py-3">Select - Inovatec 2019</div>
        </footer>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
