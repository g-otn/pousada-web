package br.com.gotn.pousada.dao.impl;

import br.com.gotn.pousada.dominio.EntidadeDominio;
import br.com.gotn.pousada.dominio.Pagante;
import br.com.gotn.pousada.dominio.Pessoa;
import br.com.gotn.pousada.dominio.Quarto;
import br.com.gotn.pousada.dominio.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReservaDAO extends AbstractDAO {
    
    public ReservaDAO() {
        super("reservas", "id");
    }
    
    public ReservaDAO(Connection conexao) {
        super(conexao, "reservas", "id");
    }

    public ReservaDAO(String tabela, String colunaId) {
        super(tabela, colunaId);
    }

    @Override
    public long salvar(EntidadeDominio entidade) {
        System.out.println("--> ReservaDAO#salvar " + entidade.toString());
        Reserva reserva = (Reserva) entidade;
        abrirConexao();
        
        PaganteDAO paganteDAO = new PaganteDAO(conexao);

        try {
            ;
            
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO " + tabela
                + " (data_check_in, data_check_out, observacoes, pessoas, pagante_id)"
                + " VALUES (?, ?, ?, ?, ?)"
            );
            ps.setObject(1, reserva.getDataCheckIn());
            ps.setObject(2, reserva.getDataCheckOut());
            ps.setString(3, reserva.getObservacoes());
            ps.setArray(4, conexao.createArrayOf("varchar[]", reserva.getPessoas().toArray()));
            ps.setLong(5, paganteDAO.salvar(reserva.getPagante()));
            
            System.out.println(ps);
            ps.executeUpdate();
            
            // Retorna o ID para ser utilizado em chaves estrangeiras ao salvar em outros DAOs
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        return -1L;
    }

    @Override
    public void alterar(EntidadeDominio entidade) {
        System.out.println("--> ReservaDAO#alterar " + entidade.toString());
        Reserva reserva = (Reserva) entidade;
        abrirConexao();
        
        PaganteDAO paganteDAO = new PaganteDAO(conexao);
        
        try {
            paganteDAO.alterar(reserva.getPagante());
            
            PreparedStatement ps = conexao.prepareStatement("UPDATE " + tabela + " SET "
                + "data_check_in = ?, "
                + "data_check_out = ?, "
                + "observacoes = ?, "
                + "pessoas = ?, "
                + "pagante_id = ? "
                + " WHERE " + colunaId + " = ?"
            );
            ps.setObject(1, reserva.getDataCheckIn());
            ps.setObject(2, reserva.getDataCheckOut());
            ps.setString(3, reserva.getObservacoes());
            ps.setArray(4, conexao.createArrayOf("varchar[]", reserva.getPessoas().toArray()));
            ps.setLong(5, paganteDAO.salvar(reserva.getPagante()));
            
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
        System.out.println("--> ReservaDAO#consultar " + entidade.toString());
        Reserva reserva = (Reserva) entidade;
        abrirConexao();
        
        PaganteDAO paganteDAO = new PaganteDAO(conexao);
        QuartoDAO quartoDAO = new QuartoDAO(conexao);
        
        List<EntidadeDominio> reservasConsultadas = new ArrayList<>();

        try {
            PreparedStatement ps;
            
            if (reserva.getId() != -1L) { // id -> consulta de reserva única
//                if (reserva.getDataCheckIn() != null && 
//                        reserva.getDataCheckOut() != null && 
//                        (reserva.getQuartos() == null || reserva.getQuartos().isEmpty())) {
//                    // datas sem a entidade completamente preenchida -> validar datas
//                    ps = conexao.prepareStatement("SELECT * FROM " + tabela + " WHERE data_emissao");
//                } else { // listar dados de uma reserva
                    ps = conexao.prepareStatement("SELECT * FROM " + tabela + " WHERE id = ? ");
                    ps.setLong(1, reserva.getId());
//                }
            } else { // nada -> listagem
                ps = conexao.prepareStatement("SELECT * FROM " + tabela);
            }
            
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                // Recupera todas as pessoas que pertecem a esta reserva
                List<Pessoa> pessoasReserva = new ArrayList<Pessoa>();
                for (Object object : Arrays.asList(rs.getArray("pessoas"))) {
                    pessoasReserva.add(new Pessoa(((Pessoa) object).getNome()));
                }
                
                
                Reserva reservaConsultada = 
                        new Reserva(
                                rs.getObject("data_check_in", LocalDateTime.class), 
                                rs.getObject("data_check_out", LocalDateTime.class),
                                rs.getString("observacoes"), 
                                pessoasReserva, 
                                (Pagante) paganteDAO.consultar(new Pagante(rs.getLong("pagante_id"))).get(0),
                                null
                        );
                reservaConsultada.getPagante().setId(rs.getLong("pagante_id"));
                reservaConsultada.setId(rs.getLong(colunaId));
                
                reservasConsultadas.add(reservaConsultada);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        
        System.out.println("A consulta retornou " + reservasConsultadas.size() + " resultado(s)" + (reservasConsultadas.size() == 1 ? ": " + reservasConsultadas.get(0).toString() : ""));
        return reservasConsultadas;
    }
    
}
