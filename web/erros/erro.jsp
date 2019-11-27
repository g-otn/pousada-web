<%@ page isErrorPage="true" import="java.io.*" contentType="text/plain" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Page</title>
</head>

<body>
  <h1>Hello World!</h1>
</body>

</html>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="x-ua-compatible" content="ie=edge">

  <title>Pousada | Categorias</title>

  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="../vendors/admin-lte/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../vendors/admin-lte/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
  <!-- DataTables -->
  <link rel="stylesheet" href="../vendors/admin-lte/plugins/datatables-bs4/css/dataTables.bootstrap4.css">
  <!-- Toastr -->
  <link rel="stylesheet" href="../vendors/admin-lte/plugins/toastr/toastr.min.css">

  <!-- Estilos da página -->
  <link rel="stylesheet" href="../css/tabelas.css">
  <link rel="stylesheet" href="../css/tabela-categorias.css">
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
                  <a href="/reservas/nova" class="nav-link active">
                    <i class="fas fa-plus nav-icon"></i>
                    <p>Nova Reserva</p>
                  </a>
                </li>
                <li class="nav-item">
                  <a href="/reservas" class="nav-link">
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

      <!-- Main content -->
      <section class="content">
        <div class="error-page">
          <h2 class="headline text-danger"><%= response.getStatus() %></h2>

          <div class="error-content">
            <h3><i class="fas fa-exclamation-triangle text-danger"></i> Oops! Algo deu errado.</h3>

            <p>
              Mensagem: <b><%= exception.getMessage() %></b>
              Enquanto isso, retorne a <a href="/reservas">página principal</a> e tente novamente.
            </p>

          </div>

          <div class="m-5">
            <p>
                <%= exception.getCause() %>
            </p>
            <pre>
              <code class="java">
                <% exception.printStackTrace(); %>
              </code>
            </pre>
          </div>

        </div>
        <!-- /.error-page -->

      </section>
      <!-- /.content -->
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
  <!-- DataTables -->
  <script src="../vendors/admin-lte/plugins/datatables/jquery.dataTables.js"></script>
  <script src="../vendors/admin-lte/plugins/datatables-bs4/js/dataTables.bootstrap4.js"></script>
  <!-- AdminLTE App -->
  <script src="../vendors/admin-lte/dist/js/adminlte.min.js"></script>

  <!-- JavaScripts da Página -->
  <script src="../vendors/highlightjs/highlight.pack.js"></script>

  <!-- Aplicações iniciais dos plugins jQuery -->
  <script>
    hljs.initHighlightingOnLoad()
  </script>
</body>

</html>