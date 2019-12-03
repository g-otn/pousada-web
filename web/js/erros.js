// Mapeia as mensagens de erros e as exibe nos campos devidos
// Formato esperado: "idInput: Mensagem de Erro\nidInput2: Mensagem de Erro2\n ..."
function exibirErros(data) {
    if (!data || !data.trim()) return

    $(document).ready(() => {

        data = data.trim().split('\n')
    
        console.log(`Exibindo ${data.length} mensagens de erro`)
        console.log(data)
        
        if (data[0] === 'null') return;
        
        const erros = data.map(linha => {
            if (!linha || !linha.trim()) return

            linha = linha.split(':')
            
            return {
                elementoCampo: `#${linha[0]}`,
                elementoMensagemErro: `#${linha[0]}Erro`,
                mensagem: linha[1].trim()
            }
        })

        console.log('Erros mapeados: ', erros, '\naplicando-os ao DOM')

        erros.forEach(erro => {
            console.log(erro)
            $(erro.elementoCampo).addClass('is-invalid')
            $(erro.elementoMensagemErro).text(erro.mensagem)
        });
    
    })
}