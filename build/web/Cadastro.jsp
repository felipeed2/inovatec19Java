<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Cadastro Usuário</title>
        <link rel="stylesheet" href="css/Style.css">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Heebo:500&display=swap" rel="stylesheet">
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
            <form method="post" action="CtrNovoUsuario" style="margin: 100px 0px;">
                <h1>Cadastrar Usuário</h1><hr>

                <div class="form-row">
                    <div class="form-group col-md-8">
                        <label for="nome">Nome</label>
                        <input type="text" class="form-control" id="nome" name="nome" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="cpfcnpj" id="lbcpfcnpj">CPF</label>
                        <input type="text" class="form-control" id="cpfcnpj" name="cpfcnpj" placeholder="###.###.###-##" required>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-12">
                        <label for="razaoSocial">Razão Social</label>
                        <input type="text" disabled class="form-control" id="razaoSocial" name="razaoSocial" placeholder="Indústria Mecânica Modelo Ltda." required>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="tel">Telefone</label>
                        <input type="text" class="form-control" id="tel" name="tel" placeholder="(##)#####-####" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="tipoPessoa">Tipo Pessoa</label>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="tipoPessoa" id="tipoPessoaFis" value="fis" onClick="toggleRS()" checked>
                            <label class="form-check-label" for="tipoPessoaFis">
                                Física
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="tipoPessoa" id="tipoPessoaJur" value="jur" onClick="toggleRS()">
                            <label class="form-check-label" for="tipoPessoaJur">
                                Jurídica
                            </label>
                        </div>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="rua">Rua</label>
                        <input type="text" class="form-control" id="rua" name="rua" required>
                    </div>
                    <div class="form-group col-md-2">
                        <label for="numero">Número</label>
                        <input type="text" class="form-control" id="numero" name="numero" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="bairro">Bairro</label>
                        <select class="form-control" id="bairro" name="bairro">
                            <option value="Outro" selected>Outro</option>
                            <option value="Adrianópolis">Adrianópolis</option>
                            <option value="Aleixo">Aleixo</option>
                            <option value="Alvorada">Alvorada</option>
                            <option value="Cachoeirinha">Cachoeirinha</option>
                            <option value="Centro">Centro</option>
                            <option value="Cidade Nova">Cidade Nova</option>
                            <option value="Compensa">Compensa</option>
                            <option value="Coroado">Coroado</option>
                            <option value="Educandos">Educandos</option>
                            <option value="Flores">Flores</option>
                            <option value="Japiim">Japiim</option>
                            <option value="Tarumã">Tarumã</option>
                            <option value="Dom Pedro">Dom Pedro</option>
                            <option value="Novo Israel">Novo Israel</option>
                            <option value="São Jorge">São Jorge</option>
                            <option value="Parque 10">Parque 10</option>
                            <option value="Vieralves">Vieralves</option>
                        </select>
                    </div>
                </div>
                <button type="submit" class="btn btn-success">Cadastrar</button>
            </form>
        </div>
        <footer class="page-footer font-small bg-dark fixed-bottom">
            <div class="footer-copyright text-center py-3">Select - Inovatec 2019</div>
        </footer>
        <script>
            var toggle = 0;

            function toggleRS() {
                if (toggle == 0) {
                    document.getElementById('razaoSocial').disabled = null;
                    document.getElementById('cpfcnpj').setAttribute('placeholder', '##.###.###/####-##');
                    document.getElementById('lbcpfcnpj').innerHTML = 'CNPJ';
                    toggle = 1;
                } else {
                    document.getElementById('razaoSocial').disabled = 'disabled';
                    document.getElementById('cpfcnpj').setAttribute('placeholder', '###.###.###-##');
                    document.getElementById('lbcpfcnpj').innerHTML = 'CPF';
                    toggle = 0;
                }
            }
        </script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
