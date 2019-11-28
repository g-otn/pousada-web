<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="x-ua-compatible" content="ie=edge">

  <title>Pousada | Categorias</title>

  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="<%= request.getContextPath() %>/vendors/admin-lte/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%= request.getContextPath() %>/vendors/admin-lte/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <!-- <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet"> -->
  <!-- DataTables -->
  <link rel="stylesheet" href="<%= request.getContextPath() %>/vendors/admin-lte/plugins/datatables-bs4/css/dataTables.bootstrap4.css">
  <!-- Toastr -->
  <link rel="stylesheet" href="<%= request.getContextPath() %>/vendors/admin-lte/plugins/toastr/toastr.min.css">

  <!-- Estilos da página -->
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/tabelas.css">
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/tabela-categorias.css">
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

      <!-- Main content -->
      <div class="content">
        <div class="container-fluid">
          <h1 class="pt-3 mb-4 text-dark text-center">Categorias</h1>
          <div class="card">
            <div class="card-body">
              <!-- /.card-header -->
              <div class="card-body">
                <table id="tabelaCategorias" class="table table-bordered table-striped table-hover">
                  <thead>
                    <tr>
                      <th>Excluir</th>
                      <th>Descrição</th>
                      <th>Preço da Diária</th>
                      <th>Capacidade</th>
                      <th>Editar</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach items="${resultado.entidades}" var="categoria">
                        <tr>
                          <td class="item_icone">
                            <a href="#modalExcluir" data-id="${categoria.id}" data-toggle="modal" data-target="#modalExcluir"><i
                                class="nav-icon fas fa-trash text-danger text-lg"></i></a>
                          </td>
                          <td>${categoria.descricao}</td>
                          <td>R$ ${categoria.precoDiaria}</td>
                          <td>${categoria.capacidade} pessoas</td>
                          <td class="item_icone">
                            <a href="?operacao=consultar&idCategoria=${categoria.id}"><i class="nav-icon fas fa-edit text-warning text-lg"></i></a>
                          </td>
                        </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
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

  <!-- Modal de Exclusão -->
  <div class="modal fade" id="modalExcluir" tabindex="-1" role="dialog" aria-labelledby="modalExcluirLabel">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title" id="modalExcluirLabel">Confirmar Exclusão</h4>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
              aria-hidden="true">&times;</span></button>
        </div>
        <div class="modal-body">
          Deseja realmente excluir a categoria "<span id="modalExcluirDescricaoEntidade" class="text-bold"></span>"?
        </div>
        <div class="modal-footer">
          <form method="POST">
            <input type="hidden" name="operacao" value="excluir">
            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
            <button id="modalExcluirBotao" name="idCategoria" type="submit" class="btn btn-danger">Excluir</button>
          </form>
        </div>
      </div>
    </div>
  </div>

  <!-- REQUIRED SCRIPTS -->

  <!-- jQuery -->
  <script src="<%= request.getContextPath() %>/vendors/admin-lte/plugins/jquery/jquery.min.js"></script>
  <!-- Bootstrap 4 -->
  <script src="<%= request.getContextPath() %>/vendors/admin-lte/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- DataTables -->
  <script src="<%= request.getContextPath() %>/vendors/admin-lte/plugins/datatables/jquery.dataTables.js"></script>
  <script src="<%= request.getContextPath() %>/vendors/admin-lte/plugins/datatables-bs4/js/dataTables.bootstrap4.js"></script>
  <!-- AdminLTE App -->
  <script src="<%= request.getContextPath() %>/vendors/admin-lte/dist/js/adminlte.min.js"></script>
  <!-- Toastr -->
  <script src="<%= request.getContextPath() %>/vendors/admin-lte/plugins/toastr/toastr.min.js"></script>

  <!-- JavaScripts da Página -->
  <script src="<%= request.getContextPath() %>/js/tabelas.js"></script>

  <!-- Aplicações iniciais dos plugins jQuery -->
  <script>
    $(document).ready(() => {

      $('#tabelaCategorias').DataTable({
        columnDefs: [
          {
            targets: [0, 4], // Colunas de: [Editar, Excluir]
            searchable: false,
            orderable: false
          }
        ],

        // Internacionalização Português-Brasil - https://datatables.net/plug-ins/i18n/Portuguese-Brasil
        language: { "sEmptyTable": "Nenhum registro encontrado", "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros", "sInfoEmpty": "Mostrando 0 até 0 de 0 registros", "sInfoFiltered": "(Filtrados de _MAX_ registros)", "sInfoPostFix": "", "sInfoThousands": ".", "sLengthMenu": "_MENU_ resultados por página", "sLoadingRecords": "Carregando...", "sProcessing": "Processando...", "sZeroRecords": "Nenhum registro encontrado", "sSearch": "Pesquisar", "oPaginate": { "sNext": "Próximo", "sPrevious": "Anterior", "sFirst": "Primeiro", "sLast": "Último" }, "oAria": { "sSortAscending": ": Ordenar colunas de forma ascendente", "sSortDescending": ": Ordenar colunas de forma descendente" }, "select": { "rows": { "0": "Nenhuma linha selecionada", "1": "Selecionado 1 linha", "_": "Selecionado %d linhas" } } }
      });

      // Filtra a tabela pela categoria vinda da URL
      $('input[type=search]').val(new URL(window.location.href).searchParams.get('categoria'))
      $('input[type=search]').trigger('search')

      $('input[type=search]').focus()

      toastr.options = {
        closeButton: true,
        progressBar: true,
        positionClass: "toast-top-center mt-3"
      }
      
      const urlParams = new URLSearchParams(window.location.search)
      const aviso = urlParams.get('aviso')
      if (aviso === 'sucesso') toastr['success']('<h4>Categoria salvo com sucesso!</h4>')
    })
    // $('#precoDiaria').val(2342342322)
  </script>
</body>

</html>