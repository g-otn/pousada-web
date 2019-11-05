$(document).ready(() => {

    // Evento do modal de exclusão
    $('a[data-target="#modalExcluir"]').on('click', (e) => {
        const a = $(e.delegateTarget)

        // Especifica o ID da entidade a ser excluida no botão de exclusão
        const id = a.data('id')
        $('#modalExcluirBotao').val(id)

        // Exibe, no texto do modal, o texto contido na segunda coluna na linha a ser excluida
        const descricao = a.parent().next().text()
        $('#modalExcluirDescricaoEntidade').text(descricao)
    })

})