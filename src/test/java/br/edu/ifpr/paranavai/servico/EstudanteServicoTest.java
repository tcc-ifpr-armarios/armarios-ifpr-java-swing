package br.edu.ifpr.paranavai.servico;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ifpr.paranavai.armarios.excecoes.CursoException;
import br.edu.ifpr.paranavai.armarios.excecoes.EstudanteException;
import br.edu.ifpr.paranavai.armarios.modelo.Curso;
import br.edu.ifpr.paranavai.armarios.modelo.Estudante;
import br.edu.ifpr.paranavai.armarios.servico.CursoServico;
import br.edu.ifpr.paranavai.armarios.servico.EstudanteServico;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import java.security.NoSuchAlgorithmException;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author Professor Marcelo F. Terenciani
 */
public class EstudanteServicoTest {

    private Estudante estudante;
    private Curso curso;

    @BeforeAll
    public static void antesDeTodosOsTestes() throws CursoException {
        Curso curso = CursoServico.buscarPorNomeExato("Curso Teste Estudante");
        if (curso == null) {
            curso = new Curso();
            curso.setNome("Curso Teste Estudante");
            CursoServico.inserir(curso);
        }
    }

    @BeforeEach
    public void antesCadaTeste() {
        if (this.curso == null) {
            this.curso = CursoServico.buscarPorNomeExato("Curso Teste Estudante");
        }

        this.estudante = new Estudante();
        this.estudante.setNome("Estudante");
        this.estudante.setSobrenome("Teste");
        this.estudante.setEmail("teste@teste.com");
        this.estudante.setTelefone("44 9 9999-9999");
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
    public static void depoisDeCadaTeste() throws CursoException {
        Curso curso = CursoServico.buscarPorNomeExato("Curso Teste Estudante");
        CursoServico.excluir(curso);
    }

    @Test
    public void deveInserirUmNovoEstudante() throws EstudanteException, NoSuchAlgorithmException {
        System.out.println("Executando teste deveInserirUmNovoEstudante");
        this.estudante = EstudanteServico.inserir(this.estudante);
        
        assertTrue(this.estudante.getId() > 0);
        assertTrue(this.estudante.getNomeCompleto().equals("Estudante Teste"));
        assertTrue(this.estudante.isAtivo());
    }
    
    @Test
    public void naoDeveInserirCamposObritagoriosVazioOuNulo() {
        System.out.println("Executando teste naoDeveInserirNomeVazioOuNulo");

        EstudanteException estudanteExceptionVazio = assertThrows(EstudanteException.class, () -> {
            this.estudante.setNome("");
            this.estudante = EstudanteServico.inserir(this.estudante);
        });

        EstudanteException estudanteExceptionNulo = assertThrows(EstudanteException.class, () -> {
            this.estudante.setNome(null);
            this.estudante = EstudanteServico.inserir(this.estudante);
        });
        assertEquals(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO, estudanteExceptionVazio.getMessage());
        assertEquals(MensagemUtil.ESTUDANTE_CAMPO_OBRIGATORIO, estudanteExceptionNulo.getMessage());
    }
    /*

    @Test
    public void naoDeveInserirNomeDuplicado() {
        System.out.println("Executando teste naoDeveInserirNomeDuplicado");

        EstudanteException estudanteException = assertThrows(EstudanteException.class, () -> {
            this.estudante = EstudanteServico.inserir(this.estudante);
            Estudante estudanteDuplicado = new Estudante();
            estudanteDuplicado.setNome("Estudante Teste");
            EstudanteServico.inserir(estudanteDuplicado);
        });
        assertEquals(MensagemUtil.CURSO_NOME_DUPLICADO, estudanteException.getMessage());
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

        Estudante estudanteASerExcluido = new Estudante();
        estudanteASerExcluido.setNome("Estudante Exclusão");

        estudanteASerExcluido = EstudanteServico.inserir(estudanteASerExcluido);

        EstudanteServico.excluir(estudanteASerExcluido);

        Estudante estudanteEncontrado = EstudanteServico.buscarPorId(estudanteASerExcluido.getId());
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

        assertTrue(MensagemUtil.CURSO_REMOVIDO.equals(estudanteException.getMessage()));
    }

    @Test
    public void deveAtualizarOEstudanteComIdInserido() throws EstudanteException {
        System.out.println("Executando teste deveExcluirOEstudanteComIdInserido");

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
        assertEquals(MensagemUtil.CURSO_CAMPO_OBRIGATORIO, estudanteExceptionVazio.getMessage());
        assertEquals(MensagemUtil.CURSO_CAMPO_OBRIGATORIO, estudanteExceptionNulo.getMessage());
    }

    @Test
    public void naoDeveAtualizarParaNomeDuplicado() throws EstudanteException{
        System.out.println("Executando teste naoDeveAtualizarParaNomeDuplicado");
        
        this.estudanteAtualizacao = new Estudante();
        this.estudanteAtualizacao.setNome("Para atualizar");

        this.estudante = EstudanteServico.inserir(this.estudante);
        this.estudanteAtualizacao = EstudanteServico.inserir(this.estudanteAtualizacao);
        
        this.estudanteAtualizacao.setNome(this.estudante.getNome());
        
        EstudanteException estudanteException = assertThrows(EstudanteException.class, () -> {
            EstudanteServico.atualizar(this.estudanteAtualizacao);
        });
        
        EstudanteServico.excluir(this.estudanteAtualizacao);
        assertEquals(MensagemUtil.CURSO_NOME_DUPLICADO, estudanteException.getMessage());
    }
     */
}
