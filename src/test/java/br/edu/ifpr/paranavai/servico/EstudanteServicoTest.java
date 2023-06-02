package br.edu.ifpr.paranavai.servico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

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
public class EstudanteServicoTest {
    private final String NUMERO_ARMARIO = "TESTE-01";
    private final String LOCALIZACAO = "LOCAL-TESTE-ESTUDANTE";
    private final String CURSO = "CURSO-TESTE-ESTUDANTE";
    private Estudante estudante;
    private Estudante estudanteAtualizacao;
    private Curso curso;

    @BeforeAll
    public void antesDeTodosOsTestes() throws CursoException {
        Curso curso = CursoServico.buscarUnicoPorNomeExato(CURSO);
        if (curso == null) {
            curso = new Curso();
            curso.setNome(CURSO);
            CursoServico.inserir(curso);
        }
    }

    @BeforeEach
    public void antesDeCadaTeste() {
        if (this.curso == null) {
            this.curso = CursoServico.buscarUnicoPorNomeExato(CURSO);
        }

        this.estudante = new Estudante();
        this.estudante.setNome("Estudante");
        this.estudante.setSobrenome("Teste");
        this.estudante.setEmail("teste@teste.com");
        this.estudante.setTelefone("(44) 9 9999-9999");
        this.estudante.setRa("2023232323");
        this.estudante.setSenha("123456");
        this.estudante.setCurso(curso);
    }

    @AfterEach
    public void aposCadaTeste() throws EstudanteException {
        if (this.estudante != null) {
            if (this.estudante.getId() != null) {
                Estudante c = EstudanteServico.buscarPorId(this.estudante.getId());
                if (c != null)
                    EstudanteServico.excluir(c);
            } else {
                Estudante c = EstudanteServico.buscarPorEmail(this.estudante.getEmail());
                if (c != null)
                    EstudanteServico.excluir(c);
            }
        }
        this.estudante = null;
    }

    @AfterAll
    public void aposTodosOsTestes() throws CursoException {
        Curso curso = CursoServico.buscarUnicoPorNomeExato(CURSO);
        if(curso != null)
            CursoServico.excluir(curso);
    }

    @Test
    public void deveInserirUmNovoEstudante() throws EstudanteException {
        System.out.println("Executando teste deveInserirUmNovoEstudante");
        this.estudante = EstudanteServico.inserir(this.estudante);

        assertTrue(this.estudante.getId() > 0);
        assertTrue(this.estudante.getNomeCompleto().equals("Estudante Teste"));
        assertTrue(this.estudante.isAtivo());
    }

    @Test
    public void naoDeveInserirNomeVazioOuNulo() {
        System.out.println("Executando teste naoDeveInserirNomeVazioOuNulo");

        EstudanteException ex = assertThrows(EstudanteException.class, () -> {
            this.estudante.setNome("");
            this.estudante = EstudanteServico.inserir(this.estudante);
        });

        assertEquals(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO, ex.getMessage());

        ex = assertThrows(EstudanteException.class, () -> {
            this.estudante.setNome(null);
            this.estudante = EstudanteServico.inserir(this.estudante);
        });
        assertEquals(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO, ex.getMessage());
    }

    @Test
    public void naoDeveInserirSobrenomeVazioOuNulo() {
        System.out.println("Executando teste naoDeveInserirSobrenomeVazioOuNulo");

        EstudanteException ex = assertThrows(EstudanteException.class, () -> {
            this.estudante.setSobrenome("");
            this.estudante = EstudanteServico.inserir(this.estudante);
        });

        assertEquals(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO, ex.getMessage());

        ex = assertThrows(EstudanteException.class, () -> {
            this.estudante.setSobrenome(null);
            this.estudante = EstudanteServico.inserir(this.estudante);
        });
        assertEquals(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO, ex.getMessage());
    }

    @Test
    public void naoDeveInserirEmailVazioOuNulo() {
        System.out.println("Executando teste naoDeveInserirEmailVazioOuNulo");

        EstudanteException ex = assertThrows(EstudanteException.class, () -> {
            this.estudante.setEmail("");
            this.estudante = EstudanteServico.inserir(this.estudante);
        });

        assertEquals(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO, ex.getMessage());

        ex = assertThrows(EstudanteException.class, () -> {
            this.estudante.setEmail(null);
            this.estudante = EstudanteServico.inserir(this.estudante);
        });
        assertEquals(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO, ex.getMessage());
    }

    @Test
    public void naoDeveInserirSenhaVazioOuNulo() {
        System.out.println("Executando teste naoDeveInserirSenhaVazioOuNulo");

        EstudanteException ex = assertThrows(EstudanteException.class, () -> {
            this.estudante.setSenha("");
            this.estudante = EstudanteServico.inserir(this.estudante);
        });

        assertEquals(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO, ex.getMessage());

        ex = assertThrows(EstudanteException.class, () -> {
            this.estudante.setSenha(null);
            this.estudante = EstudanteServico.inserir(this.estudante);
        });
        assertEquals(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO, ex.getMessage());
    }

    @Test
    public void naoDeveInserirTelefoneVazioOuNulo() {
        System.out.println("Executando teste naoDeveInserirTelefoneVazioOuNulo");

        EstudanteException ex = assertThrows(EstudanteException.class, () -> {
            this.estudante.setTelefone("");
            this.estudante = EstudanteServico.inserir(this.estudante);
        });

        assertEquals(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO, ex.getMessage());

        ex = assertThrows(EstudanteException.class, () -> {
            this.estudante.setTelefone(null);
            this.estudante = EstudanteServico.inserir(this.estudante);
        });
        assertEquals(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO, ex.getMessage());
    }

    @Test
    public void naoDeveInserirRaDuplicado() {
        System.out.println("Executando teste naoDeveInserirRaDuplicado");

        EstudanteException estudanteException = assertThrows(EstudanteException.class, () -> {
            Estudante estudanteDuplicado = this.estudante;
            this.estudante = EstudanteServico.inserir(this.estudante);
            estudanteDuplicado.setEmail("teste.telefone@teste.com");
            estudanteDuplicado.setTelefone("(44) 9 9999-9997");
            EstudanteServico.inserir(estudanteDuplicado);
        });
        assertEquals(MensagemUtil.ESTUDANTE_RA_DUPLICADO, estudanteException.getMessage());
    }

    @Test
    public void deveListarAoMenosUm() throws EstudanteException {
        System.out.println("Executando teste deveListarAoMenosUm");

        this.estudante = EstudanteServico.inserir(this.estudante);

        List<Estudante> listaDeEstudantes = EstudanteServico.buscarTodos();
        assertTrue(!listaDeEstudantes.isEmpty());
    }

    @Test
    public void deveEncontrarOEstudanteComIdInserido() throws EstudanteException {
        System.out.println("Executando teste deveEncontrarOEstudanteComIdInserido");

        this.estudante = EstudanteServico.inserir(this.estudante);

        Estudante estudanteEncontrado = EstudanteServico.buscarPorId(this.estudante.getId());
        assertEquals(this.estudante.getId(), estudanteEncontrado.getId());
    }

    @Test
    public void naoDeveEncontrarOId() throws EstudanteException {
        System.out.println("Executando teste naoDeveEncontrarOId");

        Estudante estudanteEncontrado = EstudanteServico.buscarPorId(-1);
        assertNull(estudanteEncontrado);
    }

    @Test
    public void deveExcluirOEstudanteComIdInserido() throws EstudanteException {
        System.out.println("Executando teste deveExcluirOEstudanteComIdInserido");

        this.estudante = EstudanteServico.inserir(this.estudante);

        EstudanteServico.excluir(this.estudante);

        Estudante estudanteEncontrado = EstudanteServico.buscarPorId(this.estudante.getId());
        assertNull(estudanteEncontrado);
    }

    @Test
    public void naoDeveExcluirEstudanteJaRemovido() throws EstudanteException {
        System.out.println("Executando teste naoDeveExcluirEstudanteJaRemovido");

        this.estudante = EstudanteServico.inserir(this.estudante);

        EstudanteServico.excluir(this.estudante);

        EstudanteException estudanteException = assertThrows(EstudanteException.class, () -> {
            EstudanteServico.excluir(this.estudante);
        });

        assertTrue(MensagemUtil.ESTUDANTE_REMOVIDO.equals(estudanteException.getMessage()));
    }

    @Test
    public void deveAtualizarOEstudanteComIdInserido() throws EstudanteException {
        System.out.println("Executando teste deveAtualizarOEstudanteComIdInserido");

        this.estudante = EstudanteServico.inserir(this.estudante);

        this.estudante.setNome("Estudante Teste Atualizado");
        this.estudante.setAtivo(false);

        Estudante estudanteAtualizado = EstudanteServico.atualizar(this.estudante);

        assertTrue(this.estudante.getNome().equals(estudanteAtualizado.getNome()));
        assertTrue(!estudanteAtualizado.isAtivo());
    }

    @Test
    public void deveAtualizarMudandoSomenteUmAtributo() throws EstudanteException {
        System.out.println("Executando teste deveAtualizarMudandoSomenteUmAtributo");

        this.estudante = EstudanteServico.inserir(this.estudante);

        this.estudante.setNome("Estudante Teste");
        this.estudante.setAtivo(false);

        Estudante estudanteAtualizado = EstudanteServico.atualizar(this.estudante);

        assertTrue(this.estudante.getNome().equals(estudanteAtualizado.getNome()));
        assertTrue(!estudanteAtualizado.isAtivo());
    }

    @Test
    public void naoDeveAtualizarParaNomeVazioOuNulo() throws EstudanteException {
        System.out.println("Executando teste naoDeveAtualizarParaNomeVazioOuNulo");

        this.estudante = EstudanteServico.inserir(this.estudante);

        EstudanteException estudanteExceptionVazio = assertThrows(EstudanteException.class, () -> {
            this.estudante.setNome("");
            this.estudante = EstudanteServico.atualizar(this.estudante);
        });

        EstudanteException estudanteExceptionNulo = assertThrows(EstudanteException.class, () -> {
            this.estudante.setNome(null);
            this.estudante = EstudanteServico.atualizar(this.estudante);
        });
        assertEquals(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO,
                estudanteExceptionVazio.getMessage());
        assertEquals(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO,
                estudanteExceptionNulo.getMessage());
    }

    @Test
    public void naoDeveAtualizarParaSobrenomeVazioOuNulo() throws EstudanteException {
        System.out.println("Executando teste naoDeveAtualizarParaSobrenomeVazioOuNulo");

        this.estudante = EstudanteServico.inserir(this.estudante);

        EstudanteException estudanteExceptionVazio = assertThrows(EstudanteException.class, () -> {
            this.estudante.setSobrenome("");
            this.estudante = EstudanteServico.atualizar(this.estudante);
        });

        EstudanteException estudanteExceptionNulo = assertThrows(EstudanteException.class, () -> {
            this.estudante.setSobrenome(null);
            this.estudante = EstudanteServico.atualizar(this.estudante);
        });
        assertEquals(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO,
                estudanteExceptionVazio.getMessage());
        assertEquals(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO,
                estudanteExceptionNulo.getMessage());
    }

    @Test
    public void naoDeveAtualizarParaEmailVazioOuNulo() throws EstudanteException {
        System.out.println("Executando teste naoDeveAtualizarParaEmailVazioOuNulo");

        this.estudante = EstudanteServico.inserir(this.estudante);

        EstudanteException estudanteExceptionVazio = assertThrows(EstudanteException.class, () -> {
            this.estudante.setEmail("");
            this.estudante = EstudanteServico.atualizar(this.estudante);
        });

        EstudanteException estudanteExceptionNulo = assertThrows(EstudanteException.class, () -> {
            this.estudante.setEmail(null);
            this.estudante = EstudanteServico.atualizar(this.estudante);
        });
        assertEquals(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO,
                estudanteExceptionVazio.getMessage());
        assertEquals(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO,
                estudanteExceptionNulo.getMessage());
    }

    @Test
    public void naoDeveAtualizarParaSenhaVazioOuNulo() throws EstudanteException {
        System.out.println("Executando teste naoDeveAtualizarParaSenhaVazioOuNulo");

        this.estudante = EstudanteServico.inserir(this.estudante);

        EstudanteException estudanteExceptionVazio = assertThrows(EstudanteException.class, () -> {
            this.estudante.setSenha("");
            this.estudante = EstudanteServico.atualizar(this.estudante);
        });

        EstudanteException estudanteExceptionNulo = assertThrows(EstudanteException.class, () -> {
            this.estudante.setSenha(null);
            this.estudante = EstudanteServico.atualizar(this.estudante);
        });
        assertEquals(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO,
                estudanteExceptionVazio.getMessage());
        assertEquals(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO,
                estudanteExceptionNulo.getMessage());
    }

    @Test
    public void naoDeveAtualizarParaTelefoneVazioOuNulo() throws EstudanteException {
        System.out.println("Executando teste naoDeveAtualizarParaTelefoneVazioOuNulo");

        this.estudante = EstudanteServico.inserir(this.estudante);

        EstudanteException estudanteExceptionVazio = assertThrows(EstudanteException.class, () -> {
            this.estudante.setTelefone("");
            this.estudante = EstudanteServico.atualizar(this.estudante);
        });

        EstudanteException estudanteExceptionNulo = assertThrows(EstudanteException.class, () -> {
            this.estudante.setTelefone(null);
            this.estudante = EstudanteServico.atualizar(this.estudante);
        });
        assertEquals(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO,
                estudanteExceptionVazio.getMessage());
        assertEquals(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO,
                estudanteExceptionNulo.getMessage());
    }

    @Test
    public void naoDeveAtualizarParaRaDuplicado() throws EstudanteException {
        System.out.println("Executando teste naoDeveAtualizarParaRaDuplicado");

        this.estudanteAtualizacao = new Estudante();
        this.estudanteAtualizacao.setNome("Estudante");
        this.estudanteAtualizacao.setSobrenome("Teste");
        this.estudanteAtualizacao.setEmail("teste.atualizacao@teste.com");
        this.estudanteAtualizacao.setTelefone("(44) 9 9999-9998");
        this.estudanteAtualizacao.setRa("20232323233");
        this.estudanteAtualizacao.setSenha("123456");
        this.estudanteAtualizacao.setCurso(curso);

        this.estudante = EstudanteServico.inserir(this.estudante);
        this.estudanteAtualizacao = EstudanteServico.inserir(this.estudanteAtualizacao);

        this.estudanteAtualizacao.setRa(this.estudante.getRa());

        EstudanteException estudanteException = assertThrows(EstudanteException.class, () -> {
            EstudanteServico.atualizar(this.estudanteAtualizacao);
        });

        EstudanteServico.excluir(this.estudanteAtualizacao);
        assertEquals(MensagemUtil.ESTUDANTE_RA_DUPLICADO,
                estudanteException.getMessage());
    }

    @Test
    public void naoDeveExcluirEstudanteVinculadoAUmEmprestimo()
            throws ArmarioException, EstudanteException, EmprestimoException, LocalizacaoException {
        System.out.println("Executando teste naoDeveExcluirEstudanteVinculadoAUmEmprestimo");

        this.estudante = EstudanteServico.inserir(this.estudante);

        Localizacao localizacao = new Localizacao();
        localizacao.setDescricao(LOCALIZACAO);
        localizacao = LocalizacaoServico.inserir(localizacao);

        Armario armario = new Armario();
        armario.setNumero(NUMERO_ARMARIO);
        armario.setLocalizacao(localizacao);
        armario.setStatus(StatusArmario.ATIVO);

        armario = ArmarioServico.inserir(armario);

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setArmario(armario);
        emprestimo.setEstudante(this.estudante);

        emprestimo = EmprestimoServico.inserir(emprestimo);

        EstudanteException estudanteException = assertThrows(EstudanteException.class, () -> {
            EstudanteServico.excluir(estudante);
        });

        EmprestimoServico.excluir(emprestimo);
        ArmarioServico.excluir(armario);
        LocalizacaoServico.excluir(localizacao);

        assertEquals(MensagemUtil.ESTUDANTE_VINCULADO_EMPRESTIMO, estudanteException.getMessage());
    }
}