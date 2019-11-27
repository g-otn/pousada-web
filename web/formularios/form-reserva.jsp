<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="x-ua-compatible" content="ie=edge">

  <title>Pousada | Nova Reserva</title>

  <!-- Font Awesome Icons -->
  <link rel="stylesheet"
    href="<%= request.getContextPath() %>/vendors/admin-lte/plugins/fontawesome-free/css/all.min.css">
  <link rel="stylesheet"
    href="<%= request.getContextPath() %>/vendors/admin-lte/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%= request.getContextPath() %>/vendors/admin-lte/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
  <!-- daterange picker -->
  <link rel="stylesheet"
    href="<%= request.getContextPath() %>/vendors/admin-lte/plugins/daterangepicker/daterangepicker.css">
  <!-- Select2 -->
  <link rel="stylesheet" href="<%= request.getContextPath() %>/vendors/admin-lte/plugins/select2/css/select2.min.css">
  <link rel="stylesheet"
    href="<%= request.getContextPath() %>/vendors/admin-lte/plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css">
  <!-- Toastr -->
  <link rel="stylesheet" href="<%= request.getContextPath() %>/vendors/admin-lte/plugins/toastr/toastr.min.css">

  <!-- Estilos da página -->
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/tabelas.css">
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
        <div class="container-fluid mb-4">

          <h1 class="pt-3 mb-4 text-dark text-center">Nova Reserva</h1>
          <div class="card card-light">
            <form action="<%= request.getContextPath() %>?operacao=<%= request.getParameter("operacao") %>" method="POST">
              <div class="card-body">
                <div class="row">

                  <div class="col-md-6">
                    <div class="card card-light">

                      <div class="card-header">
                        <h3 class="card-title">Dados Gerais</h3>
                        <div class="card-tools">
                          <button type="button" class="btn btn-tool" data-card-widget="collapse"><i
                              class="fas fa-minus"></i></button>
                        </div>
                      </div>
                      <!-- /.card-header -->
                      <!-- form start -->
                      <div class="card-body">

                        <div class="form-group">
                          <label for="dataCheckInOut">Data de check-in e check-out</label><span
                            class="text-danger text-bold"> *</span>
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text">
                                <i class="far fa-calendar-alt"></i>
                              </span>
                            </div>
                            <input id="dataCheckInOut" name="dataCheckInOut" type="text"
                              class="form-control float-right" required>
                          </div>
                        </div>

                        <div class="form-group">
                          <label>Observações</label>
                          <textarea name="observacoes" class="form-control" rows="3"
                            placeholder="Adicione observações da reserva aqui..." maxlength="1000"></textarea>
                        </div>

                      </div>
                      <!-- /.card-body -->

                    </div>
                    <!-- /.card -->

                    <div class="card card-light mt-4">
                      <div class="card-header">
                        <h3 class="card-title">Quartos</h3><span class="text-danger text-bold">&nbsp;*</span>
                        <div class="card-tools">
                          <button type="button" class="btn btn-tool" data-card-widget="collapse"><i
                              class="fas fa-minus"></i></button>
                        </div>
                      </div>
                      <!-- /.card-header -->
                      <!-- form start -->
                      <div class="card-body">
                        <div class="form-group">
                          <div class="select2-gray w-100">
                            <select id="quartos" name="quartos" class="select2-blue w-100" multiple="multiple"
                              data-placeholder="Selecione os quartos" required>
                            </select>
                          </div>

                        </div>

                      </div>
                      <!-- /.card-body -->

                    </div>
                    <!-- /.card -->

                    <div class="card card-light mt-4">

                      <div class="card-header">
                        <h3 class="card-title">Hóspedes</h3>
                        <div class="card-tools">
                          <button type="button" class="btn btn-tool" data-card-widget="collapse"><i
                              class="fas fa-minus"></i></button>
                        </div>
                      </div>
                      <!-- /.card-header -->

                      <div class="card-body">
                        <div class="input-group mb-3">
                          <input id="hospedesInput" type="text" class="form-control"
                            placeholder="Insira o nome completo do hóspede" maxlength="100">
                          <div class="input-group-append">
                            <button id="hospedesInputButton" class="btn btn-outline-info"
                              type="button">Adicionar</button>
                          </div>
                        </div>

                        <ul id="hospedesUl" class="list-group">
                        </ul>
                      </div>
                      <!-- /.card-body -->

                    </div>
                    <!-- /.card -->
                  </div>
                  <!-- /.col -->

                  <div class="col-md-6">
                    <div class="card card-light">

                      <div class="card-header">
                        <h3 class="card-title">Dados do Pagante</h3>
                        <div class="card-tools">
                          <button type="button" class="btn btn-tool" data-card-widget="collapse"><i
                              class="fas fa-minus"></i></button>
                        </div>
                      </div>
                      <!-- /.card-header -->

                      <div class="card-body">
                        <div class="row">

                          <div class="col-md-12">
                            <div class="form-group">
                              <label for="paganteNome">Nome completo</label><span class="text-danger text-bold">
                                *</span>
                              <div class="input-group">
                                <input id="paganteNome" name="paganteNome" type="text" class="form-control float-right"
                                  required>
                              </div>
                            </div>
                          </div>
                          <!-- /.col -->

                        </div>
                        <!-- /.row -->

                        <div class="row">

                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="paganteRG">RG</label><span class="text-danger text-bold">
                                *</span>
                              <div class="input-group">
                                <input id="paganteRG" name="paganteRG" type="text" class="form-control float-right"
                                  maxlength="14" required>
                              </div>
                            </div>
                          </div>
                          <!-- /.col -->

                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="paganteCPF">CPF</label><span class="text-danger text-bold">
                                *</span>
                              <div class="input-group">
                                <input id="paganteCPF" name="paganteCPF" type="text" class="form-control float-right"
                                  required>
                              </div>
                            </div>
                          </div>
                          <!-- /.col -->

                        </div>
                        <!-- /.row -->

                        <div class="row">

                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="paganteEmail">Email</label><span class="text-danger text-bold">
                                *</span>
                              <div class="input-group">
                                <input id="paganteEmail" name="paganteEmail" type="text"
                                  class="form-control float-right" required>
                              </div>
                            </div>
                          </div>
                          <!-- /.col -->

                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="paganteTelefone">Telefone</label><span class="text-danger text-bold">
                                *</span>
                              <div class="input-group">
                                <input id="paganteTelefone" name="paganteTelefone" type="text"
                                  class="form-control float-right" required>
                              </div>
                            </div>
                          </div>
                          <!-- /.col -->

                        </div>
                        <!-- /.row -->

                        <hr class="">

                        <h5>Endereço</h5>

                        <div class="row">

                          <div class="col-md-3">
                            <div class="form-group">
                              <label for="enderecoCEP">CEP</label><span class="text-danger text-bold">
                                *</span>
                              <div class="input-group">
                                <input id="enderecoCEP" name="enderecoCEP" type="text" class="form-control float-right"
                                  required>
                              </div>
                            </div>
                          </div>
                          <!-- /.col -->

                          <div class="col-md-2">
                            <div class="form-group">
                              <label for="enderecoEstado">UF</label><span class="text-danger text-bold">
                                *</span>
                              <div class="input-group">
                                <input id="enderecoEstado" name="enderecoEstado" type="text"
                                  class="form-control float-right" maxlength="2" required>
                              </div>
                            </div>
                          </div>
                          <!-- /.col -->

                          <div class="col-md-7">
                            <div class="form-group">
                              <label for="enderecoCidade">Cidade</label><span class="text-danger text-bold">
                                *</span>
                              <div class="input-group">
                                <input id="enderecoCidade" name="enderecoCidade" type="text"
                                  class="form-control float-right" maxlength="150" required>
                              </div>
                            </div>
                          </div>
                          <!-- /.col -->

                        </div>
                        <!-- /.row -->

                        <div class="row">

                          <div class="col-md-4">
                            <div class="form-group">
                              <label for="enderecoBairro">Bairro</label><span class="text-danger text-bold">
                                *</span>
                              <div class="input-group">
                                <input id="enderecoBairro" name="enderecoBairro" type="text"
                                  class="form-control float-right" maxlength="150" required>
                              </div>
                            </div>
                          </div>
                          <!-- /.col -->

                          <div class="col-md-8">
                            <div class="form-group">
                              <label for="enderecoLogradouro">Logradouro</label><span class="text-danger text-bold">
                                *</span>
                              <div class="input-group">
                                <input id="enderecoLogradouro" name="enderecoLogradouro" type="text"
                                  class="form-control float-right" maxlength="300" required>
                              </div>
                            </div>
                          </div>
                          <!-- /.col -->

                          <div class="col-md-3">
                            <div class="form-group">
                              <label for="enderecoNumero">Número</label><span class="text-danger text-bold">
                                *</span>
                              <div class="input-group">
                                <input id="enderecoNumero" name="enderecoNumero" type="text"
                                  class="form-control float-right" maxlength="10" required>
                              </div>
                            </div>
                          </div>
                          <!-- /.col -->

                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="enderecoComplemento">Complemento</label>
                              <div class="input-group">
                                <input id="enderecoComplemento" name="enderecoComplemento" type="text"
                                  class="form-control float-right" maxlength="50">
                              </div>
                            </div>
                          </div>
                          <!-- /.col -->

                        </div>
                        <!-- /.row -->

                      </div>
                      <!-- /.card-body -->

                    </div>
                    <!-- /.card -->

                    <div class="card card-light mt-4">

                      <div class="card-header">
                        <h3 class="card-title">Dados do Cartão</h3>
                        <div class="card-tools">
                          <button type="button" class="btn btn-tool" data-card-widget="collapse"><i
                              class="fas fa-minus"></i></button>
                        </div>
                      </div>
                      <!-- /.card-header -->

                      <div class="card-body">
                        <div class="row">

                          <div class="col-md-12">
                            <div class="form-group">
                              <label for="cartaoNumero">Número</label><span class="text-danger text-bold">
                                *</span>
                              <div class="input-group">
                                <div class="input-group-prepend">
                                  <span class="input-group-text">
                                    <i class="far fa-credit-card"></i>
                                  </span>
                                </div>
                                <input id="cartaoNumero" name="cartaoNumero" type="text"
                                  class="form-control float-right" required>
                              </div>
                            </div>
                          </div>
                          <!-- /.col -->

                        </div>
                        <!-- /.row -->

                        <div class="row">

                          <div class="col-md-4">
                            <div class="form-group">
                              <label for="cartaoDataEmissao">Data de Emissão</label><span class="text-danger text-bold">
                                *</span>
                              <div class="input-group">
                                <input id="cartaoDataEmissao" name="cartaoDataEmissao" type="text"
                                  class="form-control float-right" required>
                              </div>
                            </div>
                          </div>
                          <!-- /.col -->

                          <div class="col-md-4">
                            <div class="form-group">
                              <label for="cartaoDataValidade">Data de Validade</label><span
                                class="text-danger text-bold">
                                *</span>
                              <div class="input-group">
                                <input id="cartaoDataValidade" name="cartaoDataValidade" type="text"
                                  class="form-control float-right" required>
                              </div>
                            </div>
                          </div>
                          <!-- /.col -->

                          <div class="col-md-2">
                          </div>
                          <!-- /.col -->

                          <div class="col-md-2">
                            <div class="form-group">
                              <label for="cartaoCodigoSeguranca">CVV</label><span class="text-danger text-bold">
                                *</span>
                              <div class="input-group">
                                <input id="cartaoCodigoSeguranca" name="cartaoCodigoSeguranca" type="password"
                                  class="form-control float-right" minlength="3" maxlength="3" required>
                              </div>
                            </div>
                          </div>
                          <!-- /.col -->

                        </div>
                        <!-- /.row -->
                      </div>
                      <!-- /.card-body -->

                    </div>
                    <!-- /.card -->
                  </div>
                  <!-- /.col -->

                </div>
                <!-- /.row -->
              </div>
              <!-- /.card-body -->


              <div class="card-footer">
                <div class="row">

                  <div class="col-md-4">
                    <button type="submit" formaction="<%= request.getContextPath() %>" formmethod="GET" class="btn btn-danger w-100">
                      Voltar
                    </button>
                  </div>
                  <div class="col-md-4">
                  </div>

                  <div class="col-md-4 text-right">
                    <button type="submit" class="btn btn-primary w-100">Cadastrar</button>
                  </div>
                  <!-- /.col -->
                </div>
                <!-- /.row -->
              </div>
            </form>

          </div>
          <!-- /.card -->
        </div>
      </div>
    </div><!-- /.container-fluid -->
  </div>
  <!-- /.content -->
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
  <!-- Select2 -->
  <script src="<%= request.getContextPath() %>/vendors/admin-lte/plugins/select2/js/select2.full.min.js"></script>
  <script src="<%= request.getContextPath() %>/vendors/admin-lte/plugins/select2/js/i18n/pt-BR.js"></script>
  <!-- InputMask -->
  <script src="<%= request.getContextPath() %>/vendors/admin-lte/plugins/moment/moment.min.js"></script>
  <script
    src="<%= request.getContextPath() %>/vendors/admin-lte/plugins/inputmask/min/jquery.inputmask.bundle.min.js"></script>
  <!-- date-range-picker -->
  <script src="<%= request.getContextPath() %>/vendors/admin-lte/plugins/daterangepicker/daterangepicker.js"></script>
  <!-- Toastr -->
  <script src="<%= request.getContextPath() %>/vendors/admin-lte/plugins/toastr/toastr.min.js"></script>
  <!-- AdminLTE App -->
  <script src="<%= request.getContextPath() %>/vendors/admin-lte/dist/js/adminlte.min.js"></script>
  <!-- InputMask -->
  <script
    src="<%= request.getContextPath() %>/vendors/admin-lte/plugins/inputmask/min/jquery.inputmask.bundle.min.js"></script>

  <!-- JavaScripts da Página -->
  <script src="<%= request.getContextPath() %>/js/form-reserva.js"></script>

  <!-- Aplicações iniciais dos plugins jQuery -->
  <script>
    $(document).ready(() => {

      // Configuração do Date Range Picker para a data de check-in e check-out
      $('#dataCheckInOut').daterangepicker({
        showDropdowns: true,
        minDate: new Date(),
        minYear: new Date().getFullYear(),
        timePicker: true,
        timePickerIncrement: 30,
        // Locale (Tradução das labels) por João Pedro Raldi: https://stackoverflow.com/a/47271070/11138267
        locale: { format: 'DD/MM/YYYY hh:mm A', separator: ' - ', applyLabel: 'Aplicar', cancelLabel: 'Cancelar', fromLabel: 'De', toLabel: 'Até', customRangeLabel: 'Custom', daysOfWeek: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb'], monthNames: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'], firstDay: 0 }
      })

      // ****************************************************

      // Inicialização dos select de quartos
      $.ajax({
        url: '<%= request.getContextPath() %>/quartos/listar',
        error: () => {
          // Inicializa o select com quartos mockados
          $('#quartos').select2({
            theme: 'bootstrap4',
            language: 'pt-BR',
            data: [
              { id: 1, text: 'nº 1 - Suite de Luxo - 2 pessoas' },
              { id: 2, text: 'nº 2 - Quarto Comum - 1 pessoa' },
            ]
          })
        },
        success: data => {
          // Inicializa os dados com quartos recuperados
          $('#quartos').select2({
            theme: 'bootstrap4',
            language: 'pt-BR',
            data: data
          })
        }
      })

      // ****************************************************

      // $('#paganteRG').inputmask('text', {
      //   mask: '99.999.999-9|X',
      //   rightAlign: false,
      //   autoUnmask: true,
      //   removeMaskOnSubmit: true
      // })

      $('#paganteCPF').inputmask('text', {
        mask: '999.999.999-99',
        rightAlign: false,
        autoUnmask: true,
        removeMaskOnSubmit: true
      })

      $('#paganteEmail').inputmask('email', {
        rightAlign: false
      })

      $('#paganteTelefone').inputmask('text', {
        mask: '(99) 99999-9999',
        rightAlign: false,
        autoUnmask: true,
        removeMaskOnSubmit: true
      })

      $('#enderecoCEP').inputmask('text', {
        mask: '99999-999',
        autoUnmask: true,
        removeMaskOnSubmit: true
      })

      // ****************************************************

      $('#cartaoNumero').inputmask('text', {
        mask: '9999 9999 9999 9999',
        rightAlign: false,
        autoUnmask: true,
        removeMaskOnSubmit: true
      })

      $('#cartaoDataEmissao').inputmask('datetime', {
        mask: "99/99",
        placeholder: "mm/aa"
      })

      $('#cartaoDataValidade').inputmask('datetime', {
        mask: "99/99",
        placeholder: "mm/aa"
      })

      $('#cartaoCodigoSeguranca').inputmask('decimal', {
        mask: '999',
        rightAlign: false,
        autoUnmask: true,
        removeMaskOnSubmit: true
      })

      // ****************************************************

      toastr.options = {
        closeButton: true,
        progressBar: true,
        positionClass: "toast-top-center mt-5"
      }


      toastr['error']('<h4>O formulário contém erros.</h4>Corrija-os e tente novamente.')

      // $('#quartos').val([1, 2])
      // $('#quartos').trigger('change')

    })
  </script>
</body>

</html>