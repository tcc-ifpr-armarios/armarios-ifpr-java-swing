package br.edu.ifpr.paranavai.servico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

import br.edu.ifpr.paranavai.armarios.excecoes.ArmarioException;
import br.edu.ifpr.paranavai.armarios.excecoes.LocalizacaoException;
import br.edu.ifpr.paranavai.armarios.modelo.Armario;
import br.edu.ifpr.paranavai.armarios.modelo.Localizacao;
import br.edu.ifpr.paranavai.armarios.modelo.StatusArmario;
import br.edu.ifpr.paranavai.armarios.servico.ArmarioServico;
import br.edu.ifpr.paranavai.armarios.servico.LocalizacaoServico;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;

/**
 *
 * @author Allan Fernando O de Andrade
 */
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.MethodName.class)
public class LocalizacaoServicoTest {

    private final String DESCRICAO = "TESTE-LOCALIZACAO-01";
    private Localizacao localizacao;
    private Localizacao localizacaoAtualizacao;

    @BeforeEach
    public void antesCadaTeste() {
        this.localizacao = new Localizacao();
        this.localizacao.setDescricao(DESCRICAO);
    }

    @AfterEach
    public void aposCadaTeste() throws LocalizacaoException {
        if (this.localizacao != null) {
            if (this.localizacao.getId() != null) {
                Localizacao l = LocalizacaoServico.buscarUnicoPorId(this.localizacao.getId());
                if (l != null) {
                    LocalizacaoServico.excluir(l);
                }
            } else {
                Localizacao l = LocalizacaoServico.buscarUnicoPorDescricaoExata(this.localizacao.getDescricao());
                if (l != null) {
                    LocalizacaoServico.excluir(l);
                }
            }
        }
        this.localizacao = null;
    }

    @Test
    public void deveInserirUmaNovaLocalizacao() throws LocalizacaoException {
        System.out.println("Executando teste deveInserirUmaNovaLocalizacao");
        this.localizacao = LocalizacaoServico.inserir(this.localizacao);

        assertTrue(this.localizacao.getId() > 0);
        assertTrue(this.localizacao.getDescricao().equals(DESCRICAO));
        assertTrue(this.localizacao.isAtivo());
    }

    @Test
    public void naoDeveInserirDescricaoVaziaOuNula() {
        System.out.println("Executando teste naoDeveInserirDescricaoVaziaOuNula");

        LocalizacaoException localizacaoExceptionVazio = assertThrows(LocalizacaoException.class, () -> {
            this.localizacao.setDescricao("");
            this.localizacao = LocalizacaoServico.inserir(this.localizacao);
        });

        LocalizacaoException localizacaoExceptionNulo = assertThrows(LocalizacaoException.class, () -> {
            this.localizacao.setDescricao(null);
            this.localizacao = LocalizacaoServico.inserir(this.localizacao);
        });
        assertEquals(MensagemUtil.LOCALIZACAO_CAMPO_OBRIGATORIO, localizacaoExceptionVazio.getMessage());
        assertEquals(MensagemUtil.LOCALIZACAO_CAMPO_OBRIGATORIO, localizacaoExceptionNulo.getMessage());
    }

    @Test
    public void naoDeveInserirDescricaoDuplicada() {
        System.out.println("Executando teste naoDeveInserirDescricaoDuplicada");

        LocalizacaoException localizacaoException = assertThrows(LocalizacaoException.class, () -> {
            this.localizacao = LocalizacaoServico.inserir(this.localizacao);
            Localizacao localizacaoDuplicado = new Localizacao();
            localizacaoDuplicado.setDescricao(DESCRICAO);
            LocalizacaoServico.inserir(localizacaoDuplicado);
        });
        assertEquals(MensagemUtil.LOCALIZACAO_DESCRICAO_DUPLICADA, localizacaoException.getMessage());
    }

    @Test
    public void deveListarAoMenosUma() throws LocalizacaoException {
        System.out.println("Executando teste deveListarAoMenosUma");

        this.localizacao = LocalizacaoServico.inserir(this.localizacao);

        List<Localizacao> listaDeLocalizacoes = LocalizacaoServico.buscarTodos();
        assertTrue(!listaDeLocalizacoes.isEmpty());
    }

    @Test
    public void deveListarSomenteAtivos() throws LocalizacaoException {
        System.out.println("Executando teste deveListarSomenteAtivos");

        this.localizacao = LocalizacaoServico.inserir(this.localizacao);

        List<Localizacao> listaDeLocalizacoes = LocalizacaoServico.buscarAtivos();
        assertTrue(!listaDeLocalizacoes.isEmpty());
    }

    @Test
    public void deveEncontrarALocalizacaoComIdInserido() throws LocalizacaoException {
        System.out.println("Executando teste deveEncontrarALocalizacaoComIdInserido");

        this.localizacao = LocalizacaoServico.inserir(this.localizacao);

        Localizacao localizacaoEncontrado = LocalizacaoServico.buscarUnicoPorId(this.localizacao.getId());
        assertEquals(this.localizacao.getId(), localizacaoEncontrado.getId());
    }

    @Test
    public void naoDeveEncontrarOId() throws LocalizacaoException {
        System.out.println("Executando teste naoDeveEncontrarOId");

        Localizacao localizacaoEncontrado = LocalizacaoServico.buscarUnicoPorId(-1);
        assertNull(localizacaoEncontrado);
    }

    @Test
    public void deveExcluirALocalizacaoComIdInserido() throws LocalizacaoException {
        System.out.println("Executando teste deveExcluirALocalizacaoComIdInserido");

        this.localizacao = LocalizacaoServico.inserir(this.localizacao);

        LocalizacaoServico.excluir(this.localizacao);

        Localizacao localizacaoEncontrado = LocalizacaoServico.buscarUnicoPorId(this.localizacao.getId());
        assertNull(localizacaoEncontrado);
    }

    @Test
    public void naoDeveExcluirLocalizacaoJaRemovido() throws LocalizacaoException {
        System.out.println("Executando teste naoDeveExcluirLocalizacaoJaRemovido");

        this.localizacao = LocalizacaoServico.inserir(this.localizacao);

        LocalizacaoServico.excluir(this.localizacao);

        LocalizacaoException localizacaoException = assertThrows(LocalizacaoException.class, () -> {
            LocalizacaoServico.excluir(this.localizacao);
        });

        assertTrue(MensagemUtil.LOCALIZACAO_REMOVIDA.equals(localizacaoException.getMessage()));
    }

    @Test
    public void deveAtualizarALocalizacaoComIdInserido() throws LocalizacaoException {
        System.out.println("Executando teste deveAtualizarALocalizacaoComIdInserido");

        this.localizacao = LocalizacaoServico.inserir(this.localizacao);

        this.localizacao.setDescricao(DESCRICAO + " Atualizada");
        this.localizacao.setAtivo(false);

        Localizacao localizacaoAtualizado = LocalizacaoServico.atualizar(this.localizacao);

        assertTrue(this.localizacao.getDescricao().equals(localizacaoAtualizado.getDescricao()));
        assertTrue(!localizacaoAtualizado.isAtivo());
    }

    @Test
    public void deveAtualizarMudandoSomenteUmAtributo() throws LocalizacaoException {
        System.out.println("Executando teste deveAtualizarMudandoSomenteUmAtributo");

        this.localizacao = LocalizacaoServico.inserir(this.localizacao);

        this.localizacao.setAtivo(false);

        Localizacao localizacaoAtualizado = LocalizacaoServico.atualizar(this.localizacao);

        assertTrue(this.localizacao.getDescricao().equals(localizacaoAtualizado.getDescricao()));
        assertTrue(!localizacaoAtualizado.isAtivo());
    }

    @Test
    public void naoDeveAtualizarParaDescricaoVazioOuNulo() throws LocalizacaoException {
        System.out.println("Executando teste naoDeveAtualizarParaDescricaoVazioOuNulo");

        this.localizacao = LocalizacaoServico.inserir(this.localizacao);

        LocalizacaoException localizacaoExceptionVazio = assertThrows(LocalizacaoException.class, () -> {
            this.localizacao.setDescricao("");
            this.localizacao = LocalizacaoServico.atualizar(this.localizacao);
        });

        LocalizacaoException localizacaoExceptionNulo = assertThrows(LocalizacaoException.class, () -> {
            this.localizacao.setDescricao(null);
            this.localizacao = LocalizacaoServico.atualizar(this.localizacao);
        });
        assertEquals(MensagemUtil.LOCALIZACAO_CAMPO_OBRIGATORIO, localizacaoExceptionVazio.getMessage());
        assertEquals(MensagemUtil.LOCALIZACAO_CAMPO_OBRIGATORIO, localizacaoExceptionNulo.getMessage());
    }

    @Test
    public void naoDeveAtualizarParaDescricaoDuplicada() throws LocalizacaoException {
        System.out.println("Executando teste naoDeveAtualizarParaDescricaoDuplicada");

        this.localizacaoAtualizacao = new Localizacao();
        this.localizacaoAtualizacao.setDescricao(DESCRICAO + " Atualizada");

        this.localizacao = LocalizacaoServico.inserir(this.localizacao);
        this.localizacaoAtualizacao = LocalizacaoServico.inserir(this.localizacaoAtualizacao);

        this.localizacaoAtualizacao.setDescricao(this.localizacao.getDescricao());

        LocalizacaoException localizacaoException = assertThrows(LocalizacaoException.class, () -> {
            LocalizacaoServico.atualizar(this.localizacaoAtualizacao);
        });

        LocalizacaoServico.excluir(this.localizacaoAtualizacao);
        assertEquals(MensagemUtil.LOCALIZACAO_DESCRICAO_DUPLICADA, localizacaoException.getMessage());
    }

    @Test
    public void naoDeveExcluirLocalizacaoVinculadoAUmArmario() throws LocalizacaoException, ArmarioException {
        System.out.println("Executando teste naoDeveExcluirLocalizacaoVinculadoAUmArmario");

        this.localizacao = LocalizacaoServico.inserir(this.localizacao);

        Armario armario = new Armario();
        armario.setNumero("TESTE-LOCALIZACAO");
        armario.setStatus(StatusArmario.ATIVO);
        armario.setLocalizacao(localizacao);

        armario = ArmarioServico.inserir(armario);

        LocalizacaoException localizacaoException = assertThrows(LocalizacaoException.class, () -> {
            LocalizacaoServico.excluir(localizacao);
        });

        ArmarioServico.excluir(armario);
        assertEquals(MensagemUtil.LOCALIZACAO_VINCULADA_ARMARIO, localizacaoException.getMessage());
    }

}
