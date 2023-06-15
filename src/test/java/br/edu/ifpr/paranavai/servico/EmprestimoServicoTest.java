package br.edu.ifpr.paranavai.servico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

import br.edu.ifpr.paranavai.armarios.excecoes.ArmarioException;
import br.edu.ifpr.paranavai.armarios.excecoes.CursoException;
import br.edu.ifpr.paranavai.armarios.excecoes.EmprestimoException;
import br.edu.ifpr.paranavai.armarios.excecoes.EstudanteException;
import br.edu.ifpr.paranavai.armarios.excecoes.LocalizacaoException;
import br.edu.ifpr.paranavai.armarios.modelo.Armario;
import br.edu.ifpr.paranavai.armarios.modelo.Curso;
import br.edu.ifpr.paranavai.armarios.modelo.Emprestimo;
import br.edu.ifpr.paranavai.armarios.modelo.Estudante;
import br.edu.ifpr.paranavai.armarios.modelo.Localizacao;
import br.edu.ifpr.paranavai.armarios.modelo.StatusArmario;
import br.edu.ifpr.paranavai.armarios.servico.ArmarioServico;
import br.edu.ifpr.paranavai.armarios.servico.CursoServico;
import br.edu.ifpr.paranavai.armarios.servico.EmprestimoServico;
import br.edu.ifpr.paranavai.armarios.servico.EstudanteServico;
import br.edu.ifpr.paranavai.armarios.servico.LocalizacaoServico;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;

/**
 *
 * @author Professor Marcelo F. Terenciani
 */
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.MethodName.class)
public class EmprestimoServicoTest {

    private static final String NOME_CURSO = "CURSO-TESTE-EMPRESTIMO";
    private static final String NUMERO_ARMARIO = "TESTE-01-EMPRESTIMO";
    private static final String NOME_LOCALIZACAO = "LOCAL-TESTE-EMPRESTIMO";
    private static final String RA_ESTUDANTE = "2023232323";

    private Armario armario;
    private Armario armarioAtualizacao;
    private Estudante estudante;
    private Localizacao localizacao;
    private Emprestimo emprestimo;

    @BeforeAll
    public void antesDeTodosOsTestes()
            throws CursoException, LocalizacaoException, EstudanteException, ArmarioException {
        Curso curso = CursoServico.buscarUnicoPorNomeExato(NOME_CURSO);
        if (curso == null) {
            curso = new Curso();
            curso.setNome(NOME_CURSO);
            CursoServico.inserir(curso);
        }

        Estudante estudante = EstudanteServico.buscarUnicoPorRa(RA_ESTUDANTE);
        if (estudante == null) {
            estudante = new Estudante();
            estudante.setNome("Estudante");
            estudante.setSobrenome("Teste");
            estudante.setEmail("teste@teste.com");
            estudante.setTelefone("(44) 9 9999-9999");
            estudante.setRa(RA_ESTUDANTE);
            estudante.setSenha("123456");
            estudante.setCurso(curso);
            EstudanteServico.inserir(estudante);
        }

        Localizacao localizacao = LocalizacaoServico.buscarUnicoPorDescricaoExata(NOME_LOCALIZACAO);
        if (localizacao == null) {
            localizacao = new Localizacao();
            localizacao.setDescricao(NOME_LOCALIZACAO);
            LocalizacaoServico.inserir(localizacao);
        }

        Armario armario = ArmarioServico.buscarUnicoPorNumeroELocalizacao(localizacao.getId(), NUMERO_ARMARIO);
        if (armario == null) {
            armario = new Armario();
            armario.setNumero(NUMERO_ARMARIO);
            armario.setLocalizacao(localizacao);
            armario.setStatus(StatusArmario.ATIVO);
            ArmarioServico.inserir(armario);
        }
    }

    @BeforeEach
    public void antesDeCadaTeste() {
        if (this.estudante == null) {
            this.estudante = EstudanteServico.buscarUnicoPorRa(RA_ESTUDANTE);
        }
        if (this.localizacao == null) {
            this.localizacao = LocalizacaoServico.buscarUnicoPorDescricaoExata(NOME_LOCALIZACAO);
        }
        if (this.armario == null) {
            this.armario = ArmarioServico.buscarUnicoPorNumeroELocalizacao(localizacao.getId(), NUMERO_ARMARIO);
        }

        this.emprestimo = new Emprestimo();
        this.emprestimo.setArmario(this.armario);
        this.emprestimo.setEstudante(this.estudante);
    }

    @AfterEach
    public void aposCadaTeste() throws EmprestimoException {
        if (this.emprestimo != null) {
            if (this.emprestimo.getId() != null) {
                Emprestimo c = EmprestimoServico.buscarUnicoPorId(this.emprestimo.getId());
                if (c != null)
                    EmprestimoServico.excluir(c);
            }
        }
        this.estudante = null;
    }

    @AfterAll
    public void aposTodosOsTestes() throws CursoException, EstudanteException, LocalizacaoException, ArmarioException {
        Estudante estudante = EstudanteServico.buscarUnicoPorRa(RA_ESTUDANTE);

        if (estudante != null) {
            EstudanteServico.excluir(estudante);
        }

        Curso curso = CursoServico.buscarUnicoPorNomeExato(NOME_CURSO);
        if (curso != null) {
            CursoServico.excluir(curso);
        }
        Localizacao localizacao = LocalizacaoServico.buscarUnicoPorDescricaoExata(NOME_LOCALIZACAO);

        Armario armario = ArmarioServico.buscarUnicoPorNumeroELocalizacao(localizacao.getId(), NUMERO_ARMARIO);
        if (armario != null) {
            ArmarioServico.excluir(armario);
        }
        if (localizacao != null) {
            LocalizacaoServico.excluir(localizacao);
        }
    }

    @Test
    public void naoDeveInserirEstudanteNuloOuIdInvalido() {
        System.out.println("Executando teste naoDeveInserirEstudanteNuloOuIdInvalido");

        EmprestimoException emprestimoExceptionNulo = assertThrows(EmprestimoException.class,
                () -> {
                    this.emprestimo.setEstudante(null);
                    this.emprestimo = EmprestimoServico.inserir(this.emprestimo);
                });

        EmprestimoException emprestimoExceptionIdInvalido = assertThrows(EmprestimoException.class,
                () -> {
                    Estudante estudante = new Estudante();
                    estudante.setId(0);
                    this.emprestimo.setEstudante(estudante);
                    this.emprestimo = EmprestimoServico.inserir(this.emprestimo);
                });

        assertEquals(MensagemUtil.EMPRESTIMO_CAMPO_ESTUDANTE_OBRIGATORIO,
                emprestimoExceptionNulo.getMessage());
        assertEquals(MensagemUtil.EMPRESTIMO_CAMPO_ESTUDANTE_OBRIGATORIO,
                emprestimoExceptionIdInvalido.getMessage());
    }

    /*
     * @Test
     * public void naoDeveInserirLocalizacaoNulaOuIdInvalido() {
     * System.out.
     * println("Executando teste naoDeveInserirLocalizacaoNulaOuIdInvalido");
     * 
     * ArmarioException armarioExceptionIdeInvalido =
     * assertThrows(ArmarioException.class, () -> {
     * Localizacao local = new Localizacao();
     * local.setId(0);
     * this.armario.setLocalizacao(local);
     * this.armario = ArmarioServico.inserir(this.armario);
     * });
     * 
     * ArmarioException armarioExceptionNulo = assertThrows(ArmarioException.class,
     * () -> {
     * this.armario.setLocalizacao(null);
     * this.armario = ArmarioServico.inserir(this.armario);
     * });
     * 
     * assertEquals(MensagemUtil.ARMARIO_CAMPO_OBRIGATORIO,
     * armarioExceptionNulo.getMessage());
     * assertEquals(MensagemUtil.ARMARIO_CAMPO_OBRIGATORIO,
     * armarioExceptionIdeInvalido.getMessage());
     * }
     * 
     * @Test
     * public void deveInserirUmNovoArmario() throws ArmarioException {
     * System.out.println("Executando teste deveInserirUmNovoArmario");
     * this.armario = ArmarioServico.inserir(this.armario);
     * 
     * assertTrue(this.armario.getId() > 0);
     * assertTrue(this.armario.getNumero().equals(NUMERO_ARMARIO));
     * assertTrue(this.armario.getStatus().equals(StatusArmario.ATIVO));
     * assertTrue(this.armario.getLocalizacao().getDescricao().equals(this.
     * localizacao.getDescricao()));
     * }
     * 
     * @Test
     * public void deveListarAoMenosUm() throws ArmarioException {
     * System.out.println("Executando teste deveListarAoMenosUm");
     * 
     * this.armario = ArmarioServico.inserir(this.armario);
     * 
     * List<Armario> listaDeArmarios = ArmarioServico.buscarTodos();
     * assertTrue(!listaDeArmarios.isEmpty());
     * }
     * 
     * @Test
     * public void deveListarSomenteAtivos() throws ArmarioException {
     * System.out.println("Executando teste deveListarSomenteAtivos");
     * 
     * this.armario = ArmarioServico.inserir(this.armario);
     * 
     * List<Armario> listaDeArmarios =
     * ArmarioServico.buscarPorStatus(StatusArmario.ATIVO);
     * assertTrue(!listaDeArmarios.isEmpty());
     * }
     * 
     * @Test
     * public void deveEncontrarOArmarioComIdInserido() throws ArmarioException {
     * System.out.println("Executando teste deveEncontrarOArmarioComIdInserido");
     * 
     * this.armario = ArmarioServico.inserir(this.armario);
     * 
     * Armario cursoEncontrado =
     * ArmarioServico.buscarUnicoPorId(this.armario.getId());
     * assertEquals(this.armario.getId(), cursoEncontrado.getId());
     * }
     * 
     * @Test
     * public void naoDeveEncontrarOId() throws ArmarioException {
     * System.out.println("Executando teste naoDeveEncontrarOId");
     * 
     * Armario cursoEncontrado = ArmarioServico.buscarUnicoPorId(-1);
     * assertNull(cursoEncontrado);
     * }
     * 
     * @Test
     * public void deveExcluirOArmarioComIdInserido() throws ArmarioException {
     * System.out.println("Executando teste deveExcluirOArmarioComIdInserido");
     * 
     * this.armario = ArmarioServico.inserir(this.armario);
     * 
     * ArmarioServico.excluir(this.armario);
     * 
     * Armario cursoEncontrado =
     * ArmarioServico.buscarUnicoPorId(this.armario.getId());
     * assertNull(cursoEncontrado);
     * }
     * 
     * @Test
     * public void naoDeveExcluirArmarioJaRemovido() throws ArmarioException {
     * System.out.println("Executando teste naoDeveExcluirArmarioJaRemovido");
     * 
     * this.armario = ArmarioServico.inserir(this.armario);
     * 
     * ArmarioServico.excluir(this.armario);
     * 
     * ArmarioException armarioException = assertThrows(ArmarioException.class, ()
     * -> {
     * ArmarioServico.excluir(this.armario);
     * });
     * 
     * assertTrue(MensagemUtil.ARMARIO_REMOVIDO.equals(armarioException.getMessage()
     * ));
     * }
     * 
     * @Test
     * public void deveAtualizarOArmarioComIdInserido() throws ArmarioException {
     * System.out.println("Executando teste deveAtualizarOArmarioComIdInserido");
     * 
     * this.armario = ArmarioServico.inserir(this.armario);
     * 
     * this.armario.setNumero(NUMERO_ARMARIO + " - Atualizado");
     * this.armario.setStatus(StatusArmario.INATIVO);
     * 
     * Armario armarioAtualizado = ArmarioServico.atualizar(this.armario);
     * 
     * assertTrue(this.armario.getNumero().equals(armarioAtualizado.getNumero()));
     * assertEquals(this.armario.getStatus(), armarioAtualizado.getStatus());
     * }
     * 
     * @Test
     * public void deveAtualizarMudandoSomenteUmAtributo() throws ArmarioException {
     * System.out.println("Executando teste deveAtualizarMudandoSomenteUmAtributo");
     * 
     * this.armario = ArmarioServico.inserir(this.armario);
     * 
     * this.armario.setStatus(StatusArmario.EM_MANUTENCAO);
     * 
     * Armario armarioAtualizado = ArmarioServico.atualizar(this.armario);
     * 
     * assertTrue(this.armario.getNumero().equals(armarioAtualizado.getNumero()));
     * assertEquals(this.armario.getStatus(), armarioAtualizado.getStatus());
     * }
     * 
     * @Test
     * public void naoDeveAtualizarParaNumeroVazioOuNulo() throws ArmarioException {
     * System.out.println("Executando teste naoDeveAtualizarParaNumeroVazioOuNulo");
     * 
     * this.armario = ArmarioServico.inserir(this.armario);
     * 
     * ArmarioException armarioExceptionVazio = assertThrows(ArmarioException.class,
     * () -> {
     * this.armario.setNumero("");
     * this.armario = ArmarioServico.atualizar(this.armario);
     * });
     * 
     * ArmarioException armarioExceptionNulo = assertThrows(ArmarioException.class,
     * () -> {
     * this.armario.setNumero(null);
     * this.armario = ArmarioServico.atualizar(this.armario);
     * });
     * assertEquals(MensagemUtil.CURSO_CAMPO_OBRIGATORIO,
     * armarioExceptionVazio.getMessage());
     * assertEquals(MensagemUtil.CURSO_CAMPO_OBRIGATORIO,
     * armarioExceptionNulo.getMessage());
     * }
     * 
     * @Test
     * public void naoDeveAtualizarParaNumeroDuplicadoNaMesmaLocalizacao() throws
     * ArmarioException {
     * System.out.
     * println("Executando teste naoDeveAtualizarParaNumeroDuplicadoNaMesmaLocalizacao"
     * );
     * 
     * this.armarioAtualizacao = new Armario();
     * this.armarioAtualizacao.setNumero(NUMERO_ARMARIO + "Para atualizar");
     * this.armarioAtualizacao.setLocalizacao(this.localizacao);
     * this.armarioAtualizacao.setStatus(StatusArmario.ATIVO);
     * 
     * this.armario = ArmarioServico.inserir(this.armario);
     * this.armarioAtualizacao = ArmarioServico.inserir(this.armarioAtualizacao);
     * 
     * this.armarioAtualizacao.setNumero(this.armario.getNumero());
     * 
     * ArmarioException armarioException = assertThrows(ArmarioException.class, ()
     * -> {
     * ArmarioServico.atualizar(this.armarioAtualizacao);
     * });
     * 
     * ArmarioServico.excluir(this.armarioAtualizacao);
     * assertEquals(MensagemUtil.ARMARIO_JA_CADASTRADO_NA_LOCALIZACAO,
     * armarioException.getMessage());
     * }
     * 
     * @Test
     * public void naoDeveExcluirArmarioVinculadoAUmEmprestimo()
     * throws ArmarioException, EstudanteException, EmprestimoException,
     * CursoException {
     * System.out.
     * println("Executando teste naoDeveExcluirArmarioVinculadoAUmEmprestimo");
     * 
     * this.armario = ArmarioServico.inserir(this.armario);
     * 
     * Curso curso = new Curso();
     * curso.setNome("Curso Teste");
     * curso = CursoServico.inserir(curso);
     * 
     * Estudante estudante = new Estudante();
     * estudante.setNome("Estudante");
     * estudante.setSobrenome("Teste");
     * estudante.setEmail("teste@teste.com");
     * estudante.setTelefone("(44) 9 9999-9999");
     * estudante.setRa("2023232323");
     * estudante.setSenha("123456");
     * estudante.setCurso(curso);
     * 
     * estudante = EstudanteServico.inserir(estudante);
     * 
     * Emprestimo emprestimo = new Emprestimo();
     * emprestimo.setArmario(armario);
     * emprestimo.setEstudante(estudante);
     * 
     * emprestimo = EmprestimoServico.inserir(emprestimo);
     * 
     * ArmarioException armarioException = assertThrows(ArmarioException.class, ()
     * -> {
     * ArmarioServico.excluir(armario);
     * });
     * 
     * EmprestimoServico.excluir(emprestimo);
     * EstudanteServico.excluir(estudante);
     * CursoServico.excluir(curso);
     * 
     * assertEquals(MensagemUtil.ARMARIO_VINCULADO_EMPRESTIMO,
     * armarioException.getMessage());
     * }
     */
}
