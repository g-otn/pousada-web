$(document).ready(() => {

    // Previne de submeter o form ao apertar enter em algum input
    $('form input').on('keypress', e => {
        if (e.keyCode == 13) { // Enter
            return false
        }
    })

    // ****************************************************

    // Eventos da parte de hóspedes do formulário
    $('#hospedesInput').on('keypress', e => {
        if (e.keyCode == 13) { // Enter
            adicionarHospede()
            return false
        }
    })
    $('#hospedesInputButton').click(adicionarHospede)
    $('#hospedesUl li a').click((e) => { removerHospede(e.delegateTarget) })

    function adicionarHospede() {
        const novoHospede = $('#hospedesInput').val().trim()

        if (!novoHospede) return

        // Constrói o <li> e o evento de remoção
        const botaoRemover = $(`<a href="#" class="mr-3"><i class="nav-icon fas fa-minus text-danger text-lg"></i></a>`)
        botaoRemover.click((e) => { removerHospede(e.delegateTarget) })
        const hospedeLi = $(`
            <li class="list-group-item">
                <input type="hidden" name="hospedes" value="${novoHospede}"/>${novoHospede}
            </li>
        `)
        hospedeLi.prepend(botaoRemover)

        // Adiciona o <li>
        $('#hospedesUl').append(hospedeLi)

        $('#hospedesInput').val('')
        $('#hospedesInput').focus()
    }

    function removerHospede(a) {
        // Remove o <li>
        $(a).parent().remove()

        atualizarInputHospedes()
    }

    // ****************************************************
    $('#enderecoEstado').on('input', () => { $('#enderecoEstado').val($('#enderecoEstado').val().toUpperCase()) })
    $('#paganteRG').on('input', () => { $('#paganteRG').val($('#paganteRG').val().toUpperCase()) })
    
    $('#enderecoCEP').on('input', () => { 
        const cep = $('#enderecoCEP').val()

        if (cep && cep.length === 8) {
            // Pesquisar CEP e auto preencher caso encontrado
            $.ajax({
                url: `https://viacep.com.br/ws/${cep}/json/`,
                success: data => {
                    console.log('Dados do CEP recebidos:', data)

                    // if (data.erro) {
                    if (!data.erro) {
                        $('#enderecoCEP').removeClass('is-valid')
                    //     $('#enderecoCEP').addClass('is-invalid')
                    // } else {
                    //     $('#enderecoCEP').removeClass('is-invalid')
                    //     $('#enderecoCEP').addClass('is-valid')
                    } else return
                    
                    $('#enderecoEstado').val(data.uf)
                    $('#enderecoBairro').val(data.bairro)
                    $('#enderecoLogradouro').val(data.logradouro)
                    $('#enderecoCidade').val(data.localidade)
                    $('#enderecoComplemento').val(data.complemento)
                },
                error: (xhr, ajaxOptions, thrownError) => console.log
            })
        }
    })

})