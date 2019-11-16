package br.com.gotn.pousada.negocio.impl.reserva.pagante.endereco;

import br.com.gotn.pousada.dominio.Cidade;
import br.com.gotn.pousada.dominio.Endereco;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Reserva;
import br.com.gotn.pousada.negocio.IStrategy;

public class ValidarDadosEndereco implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarDadosEndereco#processar");
        Endereco endereco = ((Reserva) entidade).getPagante().getEndereco();
        Cidade cidade = endereco.getCidade();
        StringBuilder sb = new StringBuilder();
        
        if (endereco.getComplemento() != null && endereco.getComplemento().length() > 50) {
            sb.append("enderecoComplemento: O complemento é muito extenso\n");
        }
        
        if (endereco.getNumero() == null || endereco.getNumero().trim().isEmpty()) {
            sb.append("enderecoNumero: O número é obrigatório\n");
        } else if (endereco.getNumero().length() > 10) {
            sb.append("enderecoNumero: O número é muito extenso\n");
        }
        
        if (endereco.getBairro()== null || endereco.getBairro().trim().isEmpty()) {
            sb.append("enderecoBairro: O bairro é obrigatório\n");
        } else if (endereco.getBairro().length() > 150) {
            sb.append("enderecoNumero: O nome do bairro é muito extenso\n");
        }
        
        if (endereco.getLogradouro() == null || endereco.getLogradouro().trim().isEmpty()) {
            sb.append("enderecoLogradouro: O logradouro é obrigatório\n");
        } else if (endereco.getLogradouro().length() > 300) {
            sb.append("enderecoLogradouro: O logradouro é muito extenso\n");
        }
        
        if (cidade.getDescricao() == null || cidade.getDescricao().trim().isEmpty()) {
            sb.append("enderecoCidade: A cidade é obrigatória\n");
        } else if (cidade.getDescricao().length() > 150) {
            sb.append("enderecoCidade: O nome da cidade é muito extenso\n");
        }
        
        if (cidade.getEstado().getDescricao() == null || cidade.getEstado().getDescricao().trim().isEmpty()) {
            sb.append("enderecoEstado: A UF é obrigatória\n");
        } else if (cidade.getEstado().getDescricao().length() > 2) {
            sb.append("enderecoNumero: O nome da UF é muito extenso\n");
        }
        
        return sb.toString();
    }

}
   