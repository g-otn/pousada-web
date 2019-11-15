package br.com.gotn.pousada.negocio.impl.reserva.pagante.endereco;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Reserva;
import br.com.gotn.pousada.negocio.IStrategy;

public class ValidarCEP implements IStrategy {
    
    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarCEP#processar");
        String cep = ((Reserva) entidade).getPagante().getEndereco().getCep();
        StringBuilder sb = new StringBuilder();
        
        if (cep == null || cep.trim().isEmpty()) {
            sb.append("enderecoCEP: O CEP é obrigatório\n");
        } else if (cep.length() != 8) {
            sb.append("enderecoCEP: O CEP é inválido\n");
        } else {
            try {
                Integer.parseInt(cep);
            } catch (NumberFormatException e) {
                sb.append("enderecoCEP: O CEP só pode conter digitos\n");
            }
        }
        
        return sb.toString();
    }
    
}