<%@page import="br.com.gotn.pousada.dominio.Categoria"%>
<%@page import="br.com.gotn.pousada.dominio.Resultado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="x-ua-compatible" content="ie=edge">

  <title>Pousada | Nova Categoria</title>

  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="<%= request.getContextPath() %>/vendors/admin-lte/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%= request.getContextPath() %>/vendors/admin-lte/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <!-- <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet"> -->
  <!-- Toastr -->
  <link rel="stylesheet" href="<%= request.getContextPath() %>/vendors/admin-lte/plugins/toastr/toastr.min.css">

  <!-- Estilos da página -->
  <link href="<%= request.getContextPath() %>/css/form-categoria.css" rel="stylesheet">
</head>

<body class="hold-transition sidebar-mini sidebar-collapse">
  <div class="wrapper">

    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
      <!-- Left navbar links -->
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" data-widget="pushmenu" href="#"><i class="fas fa-bars"></i></a>
        </li>
      </ul>
    </nav>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
      <!-- Brand Logo -->
      <a href="<%= request.getContextPath() %>" class="brand-link text-center">
        <span class="brand-text text-xl">
          <i class="fas fa-hotel"></i>&nbsp&nbspPousada
        </span>
      </a>

      <!-- Sidebar -->
      <div class="sidebar">
        <!-- Sidebar Menu -->
        <nav class="mt-2">
          <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
            <!-- Add icons to the links using the .nav-icon class
                 with font-awesome or any other icon font library -->
            <li class="nav-item has-treeview menu-open">
              <a href="#" class="nav-link active">
                <i class="nav-icon fas fa-book"></i>
                <p>
                  Reservas
                  <i class="right fas fa-angle-left"></i>
                </p>
              </a>
              <ul class="nav nav-treeview">
                <li class="nav-item">
                  <a href="<%= request.getContextPath() %>/reservas/novo" class="nav-link active">
                    <i class="fas fa-plus nav-icon"></i>
                    <p>Nova Reserva</p>
                  </a>
                </li>
                <li class="nav-item">
                  <a href="<%= request.getContextPath() %>/reservas" class="nav-link">
                    <i class="fas fa-list nav-icon"></i>
                    <p>Todas as Reservas</p>
                  </a>
                </li>
              </ul>
            </li>
            <li class="nav-item has-treeview">
              <a href="#" class="nav-link">
                <i class="nav-icon fas fa-bed"></i>
                <p>
                  Quartos
                  <i class="right fas fa-angle-left"></i>
                </p>
              </a>
              <ul class="nav nav-treeview">
                <li class="nav-item">
                  <a href="<%= request.getContextPath() %>/quartos/novo" class="nav-link">
                    <i class="fas fa-plus nav-icon"></i>
                    <p>Novo Quarto</p>
                  </a>
                </li>
                <li class="nav-item">
                  <a href="<%= request.getContextPath() %>/quartos" class="nav-link">
                    <i class="fas fa-list nav-icon"></i>
                    <p>Todas os Quartos</p>
                  </a>
                </li>
              </ul>
            </li>
            <li class="nav-item has-treeview">
              <a href="#" class="nav-link">
                <i class="nav-icon fas fa-tags"></i>
                <p>
                  Categorias
                  <i class="right fas fa-angle-left"></i>
                </p>
              </a>
              <ul class="nav nav-treeview">
                <li class="nav-item">
                  <a href="<%= request.getContextPath() %>/categorias/novo" class="nav-link">
                    <i class="fas fa-plus nav-icon"></i>
                    <p>Nova Categoria</p>
                  </a>
                </li>
                <li class="nav-item">
                  <a href="<%= request.getContextPath() %>/categorias" class="nav-link">
                    <i class="fas fa-list nav-icon"></i>
                    <p>Todos as Categorias</p>
                  </a>
                </li>
              </ul>
            </li>
          </ul>
        </nav>
        <!-- /.sidebar-menu -->
      </div>
      <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <div class="content-header">
        <div class="container-fluid">
          <div class="row mb-2">
            <div class="col-sm-6">
            </div><!-- /.col -->
          </div><!-- /.row -->
        </div><!-- /.container-fluid -->
      </div>
      <!-- /.content-header -->

      <!-- Main content -->
      <div class="content">
        <div class="container-fluid">
          <h1 class="mt-5 mb-4 text-dark text-center">Nova Categoria de Quarto</h1>
          <div class="card">
            <div class="card-body">
              <!-- <form action="alterar" method="POST"> -->
              <form action="<%= request.getContextPath() %>/categorias" method="POST">
      <%
          if (request.getAttribute("resultado") != null) {
              %>
              <input type="hidden" name="idCategoria" value="<%= ((Resultado) request.getAttribute("resultado")).getEntidades().get(0).getId() %>">
                <input type="hidden" name="operacao" value="alterar">
              <%
          } else {
              %>
                <input type="hidden" name="operacao" value="salvar">
            <%
          }
      %>
                  
                <label for="descricao" class="mb-0">
                  <h5 class="mt-2 mb-2">Descrição</h5>
                </label><span class="text-danger text-bold"> *</span>

                <div class="input-group mb-3">
                  <div class="input-group-prepend">
                    <span class="input-group-text"><i class="fas fa-tag"></i></span>
                  </div>
                  <input id="descricao" name="descricao" type="text" class="form-control" required>
                  <span id="descricaoErro" class="text-danger"></span>
                </div>


                <div class="row mb-2">

                  <div class="col-sm-6">
                    <label for="precoDiaria" class="mb-0">
                      <h5 class="mt-2 mb-2">Preço da Diária</h5>
                    </label><span class="text-danger text-bold"> *</span>
                    <div class="input-group">
                      <div class="input-group-prepend">
                        <span class="input-group-text">R$</span>
                      </div>
                      <input id="precoDiaria" name="precoDiaria" type="text" class="form-control" required>
                    <span id="precoDiariaErro" class="text-danger"></span>
                    </div>
                  </div><!-- /.col -->

                  <div class="col-sm-6">
                    <label for="capacidade" class="mb-0">
                      <h5 class="mt-2">Capacidade</h5>
                    </label><span class="text-danger text-bold"> *</span>
                    <div class="input-group mb-3">
                      <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-users"></i></span>
                      </div>
                      <input id="capacidade" name="capacidade" type="text" class="form-control" required>
                        <span id="capacidadeErro" class="text-danger"></span>
                    </div>
                  </div><!-- /.col -->
                </div><!-- /.row -->

                <div class="row mt-2">
                  <div class="col-sm-6">
<!--                    <button type="submit" formaction="<%= request.getContextPath() %>" formmethod="GET" 
                      class="btn btn-block btn-outline-danger">Voltar</button>-->
                  </div><!-- /.col -->
                  <div class="col-sm-12">
                    <button type="submit" class="btn btn-block btn-outline-primary">Confirmar</button>
                  </div><!-- /.col -->
                </div><!-- /.row -->
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <footer class="main-footer">
      <!-- Default to the left -->
      <strong>Gabriel Otani - <a href="https://github.com/g-otn/pousada-web">GitHub</a></strong>
    </footer>
  </div>
  <!-- ./wrapper -->

  <!-- REQUIRED SCRIPTS -->

  <!-- jQuery -->
  <script src="<%= request.getContextPath() %>/vendors/admin-lte/plugins/jquery/jquery.min.js"></script>
  <!-- Bootstrap 4 -->
  <script src="<%= request.getContextPath() %>/vendors/admin-lte/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Toastr -->
  <script src="<%= request.getContextPath() %>/vendors/admin-lte/plugins/toastr/toastr.min.js"></script>
  <!-- AdminLTE App -->
  <script src="<%= request.getContextPath() %>/vendors/admin-lte/dist/js/adminlte.min.js"></script>

  <script src="<%= request.getContextPath() %>/vendors/admin-lte/plugins/inputmask/min/jquery.inputmask.bundle.min.js"></script>
  
  
  <script src="<%= request.getContextPath() %>/js/erros.js"></script>

  <!-- Aplicações iniciais dos plugins jQuery -->
  <script>
    $(document).ready(() => {

      $('#precoDiaria').inputmask('currency', {
        groupSeparator: ',',
        digits: 2,
        radixPoint: '.',
        prefix: '',
        allowMinus: false,
        autoUnmask: true,
        removeMaskOnSubmit: true
      });
      $('#capacidade').inputmask('decimal', {
        min: 1,
        max: 100,
        suffix: ' pessoa(s)',
        autoUnmask: true,
        removeMaskOnSubmit: true
      });

      toastr.options = {
        closeButton: true,
        progressBar: true,
        positionClass: "toast-top-center mt-3"
      }
      
      <%
          if (request.getAttribute("resultado") != null) {
              Resultado resultado = ((Resultado) request.getAttribute("resultado"));
              %>
                exibirErros(`<%= resultado.getMensagens() %>`)
                $('#precoDiaria').val("<%= ((Categoria)resultado.getEntidades().get(0)).getPrecoDiaria() %>")
                $('#capacidade').val("<%= ((Categoria)resultado.getEntidades().get(0)).getCapacidade()%>")
                $('#descricao').val("<%= ((Categoria)resultado.getEntidades().get(0)).getDescricao()%>")
              <%
             if (resultado.getMensagens() != null && !resultado.getMensagens().trim().isEmpty()) {
                 %> toastr['error']('<h4>O formulário contém erros.</h4>Corrija-os e tente novamente.') <%
             }
          }
      %>

    })
  </script>
</body>

</html>