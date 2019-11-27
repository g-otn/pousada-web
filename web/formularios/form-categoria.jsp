<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="x-ua-compatible" content="ie=edge">

  <title>Pousada | Nova Categoria</title>

  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="../vendors/admin-lte/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../vendors/admin-lte/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
  <!-- Toastr -->
  <link rel="stylesheet" href="../vendors/admin-lte/plugins/toastr/toastr.min.css">

  <!-- Estilos da página -->
  <link href="../css/form-categoria.css" rel="stylesheet">
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
      <a href="../vendors/admin-lte/index3.html" class="brand-link text-center">
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
              <a href="/reservas" class="nav-link active">
                <i class="nav-icon fas fa-book"></i>
                <p>
                  Reservas
                  <i class="right fas fa-angle-left"></i>
                </p>
              </a>
              <ul class="nav nav-treeview">
                <li class="nav-item">
                  <a href="reservas" class="nav-link active">
                    <i class="fas fa-plus nav-icon"></i>
                    <p>Nova Reserva</p>
                  </a>
                </li>
                <li class="nav-item">
                  <a href="reservas" class="nav-link">
                    <i class="fas fa-list nav-icon"></i>
                    <p>Todas as Reservas</p>
                  </a>
                </li>
              </ul>
            </li>
            <li class="nav-item has-treeview">
              <a href="/quartos" class="nav-link">
                <i class="nav-icon fas fa-bed"></i>
                <p>
                  Quartos
                  <i class="right fas fa-angle-left"></i>
                </p>
              </a>
              <ul class="nav nav-treeview">
                <li class="nav-item">
                  <a href="/quartos/novo" class="nav-link">
                    <i class="fas fa-plus nav-icon"></i>
                    <p>Novo Quarto</p>
                  </a>
                </li>
                <li class="nav-item">
                  <a href="/quartos" class="nav-link">
                    <i class="fas fa-list nav-icon"></i>
                    <p>Todas os Quartos</p>
                  </a>
                </li>
              </ul>
            </li>
            <li class="nav-item has-treeview">
              <a href="/categorias" class="nav-link">
                <i class="nav-icon fas fa-tags"></i>
                <p>
                  Categorias
                  <i class="right fas fa-angle-left"></i>
                </p>
              </a>
              <ul class="nav nav-treeview">
                <li class="nav-item">
                  <a href="/categorias/novo" class="nav-link">
                    <i class="fas fa-plus nav-icon"></i>
                    <p>Nova Categoria</p>
                  </a>
                </li>
                <li class="nav-item">
                  <a href="/categorias" class="nav-link">
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
              <form action="salvar" method="POST">
                <label for="descricao" class="mb-0">
                  <h5 class="mt-2 mb-2">Descrição</h5>
                </label><span class="text-danger text-bold"> *</span>

                <div class="input-group mb-3">
                  <div class="input-group-prepend">
                    <span class="input-group-text"><i class="fas fa-tag"></i></span>
                  </div>
                  <input id="descricao" name="descricao" type="text" class="form-control" required>
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
                    </div>
                  </div><!-- /.col -->
                </div><!-- /.row -->

                <div class="row mt-2">
                  <div class="col-sm-6">
                    <button type="submit" formaction="/categorias"
                      class="btn btn-block btn-outline-danger">Voltar</button>
                  </div><!-- /.col -->
                  <div class="col-sm-6">
                    <button type="submit" class="btn btn-block btn-outline-primary">Cadastrar</button>
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
      <strong>Gabriel Otani - <a href="#">GitHub</a></strong>
    </footer>
  </div>
  <!-- ./wrapper -->

  <!-- REQUIRED SCRIPTS -->

  <!-- jQuery -->
  <script src="../vendors/admin-lte/plugins/jquery/jquery.min.js"></script>
  <!-- Bootstrap 4 -->
  <script src="../vendors/admin-lte/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Toastr -->
  <script src="../vendors/admin-lte/plugins/toastr/toastr.min.js"></script>
  <!-- AdminLTE App -->
  <script src="../vendors/admin-lte/dist/js/adminlte.min.js"></script>

  <script src="../vendors/admin-lte/plugins/inputmask/min/jquery.inputmask.bundle.min.js"></script>

  <!-- Aplicações iniciais dos plugins jQuery -->
  <script>
    $(document).ready(() => {

      $('#precoDiaria').inputmask('currency', {
        groupSeparator: '.',
        digits: 2,
        radixPoint: ',',
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
      // $('#precoDiaria').val(2342342322)

    })
  </script>
</body>

</html>