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
import br.com.gotn.pousada.negocio.impl.categoria.ValidarDadosCategoria;
import br.com.gotn.pousada.negocio.impl.categoria.ValidarDescricaoCategoria;
import br.com.gotn.pousada.negocio.impl.quarto.ValidarCategoriaQuarto;
import br.com.gotn.pousada.negocio.impl.quarto.ValidarNumeroQuarto;
import br.com.gotn.pousada.negocio.impl.reserva.ValidarDataCheckInCheckOut;
import br.com.gotn.pousada.negocio.impl.reserva.ValidarPessoas;
import br.com.gotn.pousada.negocio.impl.reserva.ValidarQuartos;
import br.com.gotn.pousada.negocio.impl.reserva.pagante.ValidarCPF;
import br.com.gotn.pousada.negocio.impl.reserva.pagante.ValidarEmail;
import br.com.gotn.pousada.negocio.impl.reserva.pagante.ValidarRG;
import br.com.gotn.pousada.negocio.impl.reserva.pagante.ValidarTelefone;
import br.com.gotn.pousada.negocio.impl.reserva.pagante.cartao.ValidarCodigoSegurancaCartao;
import br.com.gotn.pousada.negocio.impl.reserva.pagante.cartao.ValidarDatasCartao;
import br.com.gotn.pousada.negocio.impl.reserva.pagante.cartao.ValidarNumeroCartao;
import br.com.gotn.pousada.negocio.impl.reserva.pagante.endereco.ValidarCEP;
import br.com.gotn.pousada.negocio.impl.reserva.pagante.endereco.ValidarDadosEndereco;
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
        daoMap = new HashMap<>();
        regrasNegocio = new HashMap<>();
        
        // Mapeando cada entidade para seu respectivo DAO
        daoMap.put(Reserva.class.getName(), new ReservaDAO());
        daoMap.put(Quarto.class.getName(), new QuartoDAO());
        daoMap.put(Categoria.class.getName(), new CategoriaDAO());
        
        
        
        // Mapeando cada entidade para suas respectivas regras de negócio de cada operação
        
        // ------------------- Regras de negócio para a entidade Reserva ---------------------
        Map<String, List<IStrategy>> rnsReserva = new HashMap<>();
        
        // Regras de negócio para a operação salvar
        List<IStrategy> rnsReservaSalvar = new ArrayList<>();
        rnsReservaSalvar.add(new ValidarDataCheckInCheckOut());
        rnsReservaSalvar.add(new ValidarPessoas());
        rnsReservaSalvar.add(new ValidarQuartos());
        rnsReservaSalvar.add(new ValidarCPF());
        rnsReservaSalvar.add(new ValidarRG());
        rnsReservaSalvar.add(new ValidarEmail());
        rnsReservaSalvar.add(new ValidarTelefone());
        rnsReservaSalvar.add(new ValidarDadosEndereco());
        rnsReservaSalvar.add(new ValidarCEP());
        rnsReservaSalvar.add(new ValidarNumeroCartao());
        rnsReservaSalvar.add(new ValidarDatasCartao());
        rnsReservaSalvar.add(new ValidarCodigoSegurancaCartao());
        
        // Regras de negócio para a operação alterar
        List<IStrategy> rnsReservaAlterar = new ArrayList<>();
        rnsReservaAlterar.add(new ValidarDataCheckInCheckOut());
        rnsReservaAlterar.add(new ValidarPessoas());
        rnsReservaAlterar.add(new ValidarQuartos());
        rnsReservaAlterar.add(new ValidarCPF());
        rnsReservaAlterar.add(new ValidarRG());
        rnsReservaAlterar.add(new ValidarEmail());
        rnsReservaAlterar.add(new ValidarTelefone());
        rnsReservaAlterar.add(new ValidarDadosEndereco());
        rnsReservaAlterar.add(new ValidarCEP());
        rnsReservaAlterar.add(new ValidarNumeroCartao());
        rnsReservaAlterar.add(new ValidarDatasCartao());
        rnsReservaAlterar.add(new ValidarCodigoSegurancaCartao());
        
        // Mapeando cada operação para suas regras de negócio
        rnsReserva.put("salvar", rnsReservaSalvar);
        rnsReserva.put("alterar", rnsReservaAlterar);
        
        // Mapeando a entidade Reserva para suas regras de negócio
        regrasNegocio.put(Reserva.class.getName(), rnsReserva);
        
        
        
        // ------------------- Regras de negócio para a entidade Quarto ----------------------
        Map<String, List<IStrategy>> rnsQuarto = new HashMap<>();
        
        // Regras de negócio para a operação salvar
        List<IStrategy> rnsQuartoSalvar = new ArrayList<>();
        rnsQuartoSalvar.add(new ValidarCategoriaQuarto());
        rnsQuartoSalvar.add(new ValidarNumeroQuarto());
        
        // Regras de negócio para a operação alterar
        List<IStrategy> rnsQuartoAlterar = new ArrayList<>();
        rnsQuartoAlterar.add(new ValidarCategoriaQuarto());
        rnsQuartoAlterar.add(new ValidarNumeroQuarto());
        
        // Mapeando cada operação para suas regras de negócio
        rnsQuarto.put("salvar", rnsQuartoSalvar);
        rnsQuarto.put("alterar", rnsQuartoAlterar);
        
        // Mapeando a entidade Quarto para suas regras de negócio
        regrasNegocio.put(Quarto.class.getName(), rnsQuarto);
        
        
        
        // ------------------- Regras de negócio para a entidade Categoria -------------------
        Map<String, List<IStrategy>> rnsCategoria = new HashMap<>();
        
        // Regras de negócio para a operação salvar
        List<IStrategy> rnsCategoriaSalvar = new ArrayList<>();
        rnsCategoriaSalvar.add(new ValidarDadosCategoria());
        rnsCategoriaSalvar.add(new ValidarDescricaoCategoria());
        
        // Regras de negócio para a operação alterar
        List<IStrategy> rnsCategoriaAlterar = new ArrayList<>();
        rnsCategoriaAlterar.add(new ValidarDadosCategoria());
        rnsCategoriaAlterar.add(new ValidarDescricaoCategoria());
        
        // Mapeando cada operação para suas regras de negócio
        rnsCategoria.put("salvar", rnsCategoriaSalvar);
        rnsCategoria.put("alterar", rnsCategoriaAlterar);
        
        // Mapeando a entidade Categoria para suas regras de negócio
        regrasNegocio.put(Categoria.class.getName(), rnsCategoria);
    }

    private void executarRegras(EntidadeDominio entidade, List<IStrategy> rnsEntidade) {
        sb.setLength(0);
        for (IStrategy rn : rnsEntidade) {
            String msg = rn.processar(entidade);
            if (msg != null) {
                sb.append(msg);
            }
        }
    }

    @Override
    public Resultado salvar(EntidadeDominio entidade) {
        System.out.println("--> Fachada#salvar");
        resultado = new Resultado();
        String nomeClasse = entidade.getClass().getName();
        
        Map<String, List<IStrategy>> regrasNegocioEntidade = regrasNegocio.get(nomeClasse);
        List<IStrategy> regrasNegocioOperacao = regrasNegocioEntidade.get("salvar");
        
        executarRegras(entidade, regrasNegocioOperacao);
        
        if (sb.length() == 0) { // Não há erros de validação
            System.out.println("=== Sem erros de validação!");
            IDAO dao = daoMap.get(nomeClasse);
            dao.salvar(entidade);
        } else {
            System.out.println("=== " + sb.toString().split("\n").length + " erros de validação encontrados!");
            System.out.println(sb.toString());
            resultado.setMensagens(sb.toString());
        }
        
        // Como a operação de salvar do DAO não retorna nada, disponibilizamos a entidade recebida caso seja útil a view
        resultado.addEntidade(entidade);
        
        return resultado;
    }

    @Override
    public Resultado alterar(EntidadeDominio entidade) {
        System.out.println("--> Fachada#alterar");
        resultado = new Resultado();
        String nomeClasse = entidade.getClass().getName();
        
        Map<String, List<IStrategy>> regrasNegocioEntidade = regrasNegocio.get(nomeClasse);
        List<IStrategy> regrasNegocioOperacao = regrasNegocioEntidade.get("alterar");
        
        executarRegras(entidade, regrasNegocioOperacao);
        
        if (sb.length() == 0) { // Não há erros de validação
            System.out.println("=== Sem erros de validação!");
            IDAO dao = daoMap.get(nomeClasse);
            dao.alterar(entidade);
        } else {
            System.out.println("=== " + sb.toString().split("\n").length + " erros de validação encontrados:");
            System.out.println(sb.toString());
            resultado.setMensagens(sb.toString());
        }
        
        // Como a operação de alterar do DAO não retorna nada, disponibilizamos a entidade recebida caso seja útil a view
        resultado.addEntidade(entidade);
        
        return resultado;
    }

    @Override
    public Resultado excluir(EntidadeDominio entidade) {
        System.out.println("--> Fachada#excluir");
        resultado = new Resultado();
        String nomeClasse = entidade.getClass().getName();
        
        IDAO dao = daoMap.get(nomeClasse);
        dao.excluir(entidade);
        
        // Como a operação de excluir do DAO não retorna nada, disponibilizamos a entidade recebida caso seja útil a view
        resultado.addEntidade(entidade);
        
        return resultado;
    }

    @Override
    public Resultado consultar(EntidadeDominio entidade) {
        System.out.println("--> Fachada#consultar");
        resultado = new Resultado();
        String nomeClasse = entidade.getClass().getName();
        
        IDAO dao = daoMap.get(nomeClasse);
        for (EntidadeDominio entidadeConsultada : dao.consultar(entidade)) {
            resultado.addEntidade(entidadeConsultada);
        }
        
        return resultado;
    }

}
