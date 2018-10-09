
import bean.FilmeBean;
import dao.FilmeDAO;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Sara Reis
 */
public class FilmeDAOTest {

    @Test
    public void testarAdicionar() {
        FilmeBean filme = new FilmeBean();
        filme.setTitulo("Blade Runner : O Caçador de Andróides");
        filme.setDiretor("Riddley Scott");
        filme.setCategoria("Ficção Científica");
        filme.setAtorPrincipal("Harrison Ford");
        filme.setAno((short) 1982);
        filme.setDuracao((short) 118);
        filme.setClassificacaoIndicativa("14");
        filme.setIdiomaOriginal("Ingles");
        filme.setLegendado(true);
        filme.setDublado(false);
        filme.setOrcamento(28.000000);
        filme.setFaturamento(33.800000);

        FilmeDAO dao = new FilmeDAO();

        int identificador = dao.adicionar(filme);
        assertNotSame(identificador, -1);
        filme.setId(identificador);

        FilmeBean filmeBuscado = dao.obterPeloId(identificador);
        assertNotNull(filmeBuscado);

        assertEquals(filme.getTitulo(), filmeBuscado.getTitulo());
        assertEquals(filme.getDiretor(), filmeBuscado.getDiretor());
        assertEquals(filme.getCategoria(), filmeBuscado.getCategoria());
        assertEquals(filme.getAtorPrincipal(), filmeBuscado.getAtorPrincipal());
        assertEquals(filme.getAno(), filmeBuscado.getAno());
        assertEquals(filme.getDuracao(), filmeBuscado.getDuracao());
        assertEquals(filme.getClassificacaoIndicativa(), filmeBuscado.getClassificacaoIndicativa());
        assertEquals(filme.getIdiomaOriginal(), filmeBuscado.getIdiomaOriginal());
        assertEquals(filme.isLegendado(), filmeBuscado.isLegendado());
        assertEquals(filme.isDublado(), filmeBuscado.isDublado());
        assertEquals(filme.getOrcamento(), filmeBuscado.getOrcamento(), 0);
        assertEquals(filme.getFaturamento(), filmeBuscado.getFaturamento(), 0);

    }

    @Test
    public void testarEditar() {
        FilmeBean filme = new FilmeBean();
        filme.setTitulo("Blade Runner : O Caçador de Andróides");
        filme.setDiretor("Riddley Scott");
        filme.setCategoria("Ficção Científica");
        filme.setAtorPrincipal("Harrison Ford");
        filme.setAno((short) 1982);
        filme.setDuracao((short) 118);
        filme.setClassificacaoIndicativa("14");
        filme.setIdiomaOriginal("Ingles");
        filme.setLegendado(true);
        filme.setDublado(false);
        filme.setOrcamento(28.000000);
        filme.setFaturamento(33.800000);

        FilmeDAO dao = new FilmeDAO();

        int identificador = dao.adicionar(filme);
        filme.setId(identificador);
        assertNotSame(identificador, -1);

        filme.setTitulo("Barbie : A Caçadora de Andróides");
        filme.setDiretor("Quentin Tarantino");
        filme.setCategoria("Drama");
        filme.setAtorPrincipal("Jennifer Aniston");
        filme.setAno((short) 2016);
        filme.setDuracao((short) 110);
        filme.setClassificacaoIndicativa("L");
        filme.setIdiomaOriginal("Ingles");
        filme.setLegendado(false);
        filme.setDublado(true);
        filme.setOrcamento(100.000000);
        filme.setFaturamento(100.0000000);

        Boolean alterado = dao.editar(filme);
        assertTrue(alterado);

        FilmeBean filmeBuscado = dao.obterPeloId(identificador);
        assertNotNull(filmeBuscado);

        assertEquals(filme.getTitulo(), filmeBuscado.getTitulo());
        assertEquals(filme.getDiretor(), filmeBuscado.getDiretor());
        assertEquals(filme.getCategoria(), filmeBuscado.getCategoria());
        assertEquals(filme.getAtorPrincipal(), filmeBuscado.getAtorPrincipal());
        assertEquals(filme.getAno(), filmeBuscado.getAno());
        assertEquals(filme.getDuracao(), filmeBuscado.getDuracao());
        assertEquals(filme.getClassificacaoIndicativa(), filmeBuscado.getClassificacaoIndicativa());
        assertEquals(filme.getIdiomaOriginal(), filmeBuscado.getIdiomaOriginal());
        assertEquals(filme.isLegendado(), filmeBuscado.isLegendado());
        assertEquals(filme.isDublado(), filmeBuscado.isDublado());
        assertEquals(filme.getOrcamento(), filmeBuscado.getOrcamento(), 0);
        assertEquals(filme.getFaturamento(), filmeBuscado.getFaturamento(), 0);

    }

    @Test
    public void testarExcluir() {
        FilmeBean filme = new FilmeBean();
        filme.setTitulo("Blade Runner : O Caçador de Andróides");
        filme.setDiretor("Riddley Scott");
        filme.setCategoria("Ficção Científica");
        filme.setAtorPrincipal("Harrison Ford");
        filme.setAno((short) 1982);
        filme.setDuracao((short) 118);
        filme.setClassificacaoIndicativa("14");
        filme.setIdiomaOriginal("Ingles");
        filme.setLegendado(true);
        filme.setDublado(false);
        filme.setOrcamento(28.000000);
        filme.setFaturamento(33.800000);

        FilmeDAO dao = new FilmeDAO();

        int identificador = dao.adicionar(filme);
        filme.setId(identificador);
        assertNotSame(identificador, -1);

        boolean excluido = dao.excluir(identificador);
        assertTrue(excluido);

        FilmeBean filmeBuscado = dao.obterPeloId(identificador);
        assertNull(filmeBuscado);

    }

}
