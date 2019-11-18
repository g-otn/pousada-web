package br.com.gotn.pousada.negocio.impl.reserva;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Pessoa;
import br.com.gotn.pousada.dominio.Reserva;
import br.com.gotn.pousada.negocio.IStrategy;
import java.time.LocalDateTime;
import java.util.List;

public class ValidarPessoas implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        System.out.println("ValidarPessoas#processar");
        List<Pessoa> pessoas = ((Reserva) entidade).getPessoas();
        StringBuilder sb = new StringBuilder();
        
        // Valida lista de hóspedes adicionais apenas se ela foi preenchida
        if (pessoas != null) {
            for (Pessoa pessoa : pessoas) {
                if (pessoa.getNome() == null || pessoa.getNome().trim().isEmpty()) {
                    sb.append("hospedes: A lista de hóspedes adicionais possui nomes inválidos\n");
                }
            }
        }
        
        return sb.toString();
    }
    
}