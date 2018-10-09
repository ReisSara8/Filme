package dao;

import bean.FilmeBean;
import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Sara Reis
 */
public class FilmeDAO {

    public int adicionar(FilmeBean filme) {
        Connection conexao = Conexao.conectar();
        if (conexao != null) {
            String sql = "INSERT INTO filmes (titulo, diretor, categoria, ator_principal, ano, duracao, "
                    + "classificao_Indicativa, idioma_original, legendado, dublado, orcamento, faturamento)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                int index = 1;
                ps.setString(index++, filme.getTitulo());
                ps.setString(index++, filme.getDiretor());
                ps.setString(index++, filme.getCategoria());
                ps.setString(index++, filme.getAtorPrincipal());
                ps.setShort(index++, filme.getAno());
                ps.setShort(index++, filme.getDuracao());
                ps.setString(index++, filme.getClassificacaoIndicativa());
                ps.setString(index++, filme.getIdiomaOriginal());
                ps.setBoolean(index++, filme.isLegendado());
                ps.setBoolean(index++, filme.isDublado());
                ps.setDouble(index++, filme.getOrcamento());
                ps.setDouble(index++, filme.getFaturamento());
                ps.execute();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar();
            }

        }
        return - 1;
    }

    public FilmeBean obterPeloId(int identificador) {
        Connection conexao = Conexao.conectar();
        if (conexao != null) {
            String sql = "SELECT * FROM filmes WHERE id=?";
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, identificador);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    FilmeBean filme = new FilmeBean();
                    filme.setId(rs.getInt("id"));
                    filme.setTitulo(rs.getString("titulo"));
                    filme.setDiretor(rs.getString("diretor"));
                    filme.setCategoria(rs.getString("categoria"));
                    filme.setAtorPrincipal(rs.getString("ator_principal"));;
                    filme.setAno(rs.getShort("ano"));
                    filme.setDuracao(rs.getShort("duracao"));
                    filme.setClassificacaoIndicativa(rs.getString("classificao_Indicativa"));
                    filme.setIdiomaOriginal(rs.getString("idioma_original"));
                    filme.setLegendado(rs.getBoolean("legendado"));
                    filme.setDublado(rs.getBoolean("dublado"));
                    filme.setOrcamento(rs.getDouble("orcamento"));
                    filme.setFaturamento(rs.getDouble("faturamento"));
                    return filme;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar();
            }
        }

        return null;
    }

    public Boolean editar(FilmeBean filme) {
        Connection conexao = Conexao.conectar();
        if (conexao != null) {
            String sql = "UPDATE filmes SET titulo = ?, diretor = ?, categoria = ?, ator_principal = ?,"
                    + "ano = ?, duracao = ?, classificao_Indicativa = ?, idioma_original = ?, legendado = ?,"
                    + "dublado = ?, orcamento = ?, faturamento = ? WHERE id = ?";
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, filme.getTitulo());
                ps.setString(2, filme.getDiretor());
                ps.setString(3, filme.getCategoria());
                ps.setString(4, filme.getAtorPrincipal());
                ps.setShort(5, filme.getAno());
                ps.setShort(6, filme.getDuracao());
                ps.setString(7, filme.getClassificacaoIndicativa());
                ps.setString(8, filme.getIdiomaOriginal());
                ps.setBoolean(9, filme.isLegendado());
                ps.setBoolean(10, filme.isDublado());
                ps.setDouble(11, filme.getOrcamento());
                ps.setDouble(12, filme.getFaturamento());
                ps.setInt(13, filme.getId());
                return ps.executeUpdate() == 1;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar();
            }
        }

        return false;
    }

    public boolean excluir(int identificador) {
        Connection conexao = Conexao.conectar();
        if (conexao != null) {
            String sql = "DELETE FROM filmes WHERE id = ?";
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, identificador);
                return ps.executeUpdate() == 1;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar();
            }

        }

        return false;

    }

}
