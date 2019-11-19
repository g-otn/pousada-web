package br.com.gotn.pousada.view.web.fachada.impl;

import br.com.gotn.pousada.dao.IDAO;
import br.com.gotn.pousada.dao.impl.CategoriaDAO;
import br.com.gotn.pousada.dao.impl.QuartoDAO;
import br.com.gotn.pousada.dao.impl.ReservaDAO;
import br.com.gotn.pousada.dominio.Categoria;
import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Quarto;
import br.com.gotn.pousada.dominio.Reserva;
import br.com.gotn.pousada.dominio.Resultado;
import br.com.gotn.pousada.negocio.IStrategy;
import br.com.gotn.pousada.view.web.fachada.IFachada;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fachada implements IFachada {
    
    private Map<String, IDAO> daoMap;
    private Map<String, Map<String, List<IStrategy>>> regrasNegocio;
    
    private StringBuilder sb = new StringBuilder();
    private Resultado resultado;

    public Fachada() {
        // Mapeando cada entidade para seu respectivo DAO
        daoMap.put(Reserva.class.getName(), new ReservaDAO());
        daoMap.put(Quarto.class.getName(), new QuartoDAO());
        daoMap.put(Categoria.class.getName(), new CategoriaDAO());
        
        // *****************************************************************************************
        
        // Mapeando cada entidade para suas respectivas regras de negócio de cada operação
        
        // ------------------- Regras de negócio para a entidade Reserva ---------------------
        Map<String, List<IStrategy>> rnsReserva = new HashMap<>();
        
        // Regras de negócio para a operação salvar
        List<IStrategy> rnsReservaSalvar = new ArrayList<>();
        
        // Regras de negócio para a operação alterar
        List<IStrategy> rnsReservaAlterar = new ArrayList<>();
        
        
        // ------------------- Regras de negócio para a entidade Quarto ----------------------
        Map<String, List<IStrategy>> rnsQuarto = new HashMap<>();
        
        // Regras de negócio para a operação salvar
        List<IStrategy> rnsQuartoSalvar = new ArrayList<>();
        
        // Regras de negócio para a operação alterar
        List<IStrategy> rnsQuartoAlterar = new ArrayList<>();
        
        
        // ------------------- Regras de negócio para a entidade Categoria -------------------
        Map<String, List<IStrategy>> rnsCategoria = new HashMap<>();
        
        // Regras de negócio para a operação salvar
        List<IStrategy> rnsCategoriaSalvar = new ArrayList<>();
        
        // Regras de negócio para a operação alterar
        List<IStrategy> rnsCategoriaAlterar = new ArrayList<>();
    }

    @Override
    public Resultado salvar(EntidadeDominio entidade) {
        System.out.println("--> Fachada#salvar");
    }

    @Override
    public Resultado alterar(EntidadeDominio entidade) {
        System.out.println("--> Fachada#alterar");
    }

    @Override
    public Resultado excluir(EntidadeDominio entidade) {
        System.out.println("--> Fachada#excluir");
    }

    @Override
    public Resultado consultar(EntidadeDominio entidade) {
        System.out.println("--> Fachada#consultar");
    }

    private void executarRegras(EntidadeDominio entidade, List<IStrategy> rnsEntidade) {
        for (IStrategy rn : rnsEntidade) {
            String msg = rn.processar(entidade);
            if (msg != null) {
                sb.append(msg);
            }
        }
    }

}
