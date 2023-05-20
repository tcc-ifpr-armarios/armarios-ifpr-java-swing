package br.edu.ifpr.paranavai.servico;

import br.edu.ifpr.paranavai.armarios.excecoes.CursoException;
import br.edu.ifpr.paranavai.armarios.excecoes.EstudanteException;
import br.edu.ifpr.paranavai.armarios.servico.CursoServico;
import br.edu.ifpr.paranavai.armarios.servico.EstudanteServico;
import br.edu.ifpr.paranavai.armarios.modelo.Curso;
import br.edu.ifpr.paranavai.armarios.modelo.Estudante;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Professor Marcelo F. Terenciani
 */
public class CursoServicoTest {

    private Curso curso;
    private Curso cursoAtualizacao;

    @BeforeEach
    public void antesCadaTeste() {
        this.curso = new Curso();
        this.curso.setNome("Curso Teste");
    }

    @AfterEach
    public void aposCadaTeste() throws CursoException {
        if (this.curso != null) {
            if (this.curso.getId() != null) {
                Curso c = CursoServico.buscarPorId(this.curso.getId());
                if (c != null)
                    CursoServico.excluir(c);
            } else {
                Curso c = CursoServico.buscarPorNomeExato(this.curso.getNome());
                if (c != null)
                    CursoServico.excluir(c);
            }
        }
        this.curso = null;
    }

    @Test
    public void deveInserirUmNovoCurso() throws CursoException {
        System.out.println("Executando teste deveInserirUmNovoCurso");
        this.curso = CursoServico.inserir(this.curso);

        assertTrue(this.curso.getId() > 0);
        assertTrue(this.curso.getNome().equals("Curso Teste"));
        assertTrue(this.curso.isAtivo());
    }
    
    @Test
    public void naoDeveInserirNomeVazioOuNulo() {
        System.out.println("Executando teste naoDeveInserirNomeVazioOuNulo");

        CursoException cursoExceptionVazio = assertThrows(CursoException.class, () -> {
            this.curso.setNome("");
            this.curso = CursoServico.inserir(this.curso);
        });

        CursoException cursoExceptionNulo = assertThrows(CursoException.class, () -> {
            this.curso.setNome(null);
            this.curso = CursoServico.inserir(this.curso);
        });
        assertEquals(MensagemUtil.CURSO_CAMPO_OBRIGATORIO, cursoExceptionVazio.getMessage());
        assertEquals(MensagemUtil.CURSO_CAMPO_OBRIGATORIO, cursoExceptionNulo.getMessage());
    }

    @Test
    public void naoDeveInserirNomeDuplicado() {
        System.out.println("Executando teste naoDeveInserirNomeDuplicado");

        CursoException cursoException = assertThrows(CursoException.class, () -> {
            this.curso = CursoServico.inserir(this.curso);
            Curso cursoDuplicado = new Curso();
            cursoDuplicado.setNome("Curso Teste");
            CursoServico.inserir(cursoDuplicado);
        });
        assertEquals(MensagemUtil.CURSO_NOME_DUPLICADO, cursoException.getMessage());
    }

    @Test
    public void deveListarAoMenosUm() throws CursoException {
        System.out.println("Executando teste deveListarAoMenosUm");

        this.curso = CursoServico.inserir(this.curso);

        List<Curso> listaDeCursos = CursoServico.buscarTodos();
        assertTrue(!listaDeCursos.isEmpty());
    }
    
    @Test
    public void deveListarSomenteAtivos() throws CursoException {
        System.out.println("Executando teste deveListarAoMenosUm");

        this.curso = CursoServico.inserir(this.curso);

        List<Curso> listaDeCursos = CursoServico.buscarTodosAtivos();
        assertTrue(!listaDeCursos.isEmpty());
    }

    @Test
    public void deveEncontrarOCursoComIdInserido() throws CursoException {
        System.out.println("Executando teste deveEncontrarOCursoComIdInserido");

        this.curso = CursoServico.inserir(this.curso);

        Curso cursoEncontrado = CursoServico.buscarPorId(this.curso.getId());
        assertEquals(this.curso.getId(), cursoEncontrado.getId());
    }

    @Test
    public void naoDeveEncontrarOId() throws CursoException {
        System.out.println("Executando teste naoDeveEncontrarOId");

        Curso cursoEncontrado = CursoServico.buscarPorId(-1);
        assertNull(cursoEncontrado);
    }

    @Test
    public void deveExcluirOCursoComIdInserido() throws CursoException {
        System.out.println("Executando teste deveExcluirOCursoComIdInserido");

        this.curso = CursoServico.inserir(this.curso);

        CursoServico.excluir(this.curso);

        Curso cursoEncontrado = CursoServico.buscarPorId(this.curso.getId());
        assertNull(cursoEncontrado);
    }

    @Test
    public void naoDeveExcluirCursoJaRemovido() throws CursoException {
        System.out.println("Executando teste naoDeveExcluirCursoJaRemovido");

        this.curso = CursoServico.inserir(this.curso);

        CursoServico.excluir(this.curso);

        CursoException cursoException = assertThrows(CursoException.class, () -> {
            CursoServico.excluir(this.curso);
        });

        assertTrue(MensagemUtil.CURSO_REMOVIDO.equals(cursoException.getMessage()));
    }

    @Test
    public void deveAtualizarOCursoComIdInserido() throws CursoException {
        System.out.println("Executando teste deveExcluirOCursoComIdInserido");

        this.curso = CursoServico.inserir(this.curso);

        this.curso.setNome("Curso Teste Atualizado");
        this.curso.setAtivo(false);

        Curso cursoAtualizado = CursoServico.atualizar(this.curso);

        assertTrue(this.curso.getNome().equals(cursoAtualizado.getNome()));
        assertTrue(!cursoAtualizado.isAtivo());
    }

    @Test
    public void deveAtualizarMudandoSomenteUmAtributo() throws CursoException {
        System.out.println("Executando teste deveAtualizarMudandoSomenteUmAtributo");

        this.curso = CursoServico.inserir(this.curso);

        this.curso.setNome("Curso Teste");
        this.curso.setAtivo(false);

        Curso cursoAtualizado = CursoServico.atualizar(this.curso);

        assertTrue(this.curso.getNome().equals(cursoAtualizado.getNome()));
        assertTrue(!cursoAtualizado.isAtivo());
    }

    @Test
    public void naoDeveAtualizarParaNomeVazioOuNulo() throws CursoException {
        System.out.println("Executando teste naoDeveAtualizarParaNomeVazioOuNulo");

        this.curso = CursoServico.inserir(this.curso);

        CursoException cursoExceptionVazio = assertThrows(CursoException.class, () -> {
            this.curso.setNome("");
            this.curso = CursoServico.atualizar(this.curso);
        });

        CursoException cursoExceptionNulo = assertThrows(CursoException.class, () -> {
            this.curso.setNome(null);
            this.curso = CursoServico.atualizar(this.curso);
        });
        assertEquals(MensagemUtil.CURSO_CAMPO_OBRIGATORIO, cursoExceptionVazio.getMessage());
        assertEquals(MensagemUtil.CURSO_CAMPO_OBRIGATORIO, cursoExceptionNulo.getMessage());
    }

    @Test
    public void naoDeveAtualizarParaNomeDuplicado() throws CursoException {
        System.out.println("Executando teste naoDeveAtualizarParaNomeDuplicado");

        this.cursoAtualizacao = new Curso();
        this.cursoAtualizacao.setNome("Para atualizar");

        this.curso = CursoServico.inserir(this.curso);
        this.cursoAtualizacao = CursoServico.inserir(this.cursoAtualizacao);

        this.cursoAtualizacao.setNome(this.curso.getNome());

        CursoException cursoException = assertThrows(CursoException.class, () -> {
            CursoServico.atualizar(this.cursoAtualizacao);
        });

        CursoServico.excluir(this.cursoAtualizacao);
        assertEquals(MensagemUtil.CURSO_NOME_DUPLICADO, cursoException.getMessage());
    }

    @Test
    public void naoDeveExcluirCursoVinculadoAUmEstudante() throws CursoException, EstudanteException {
        System.out.println("Executando teste naoDeveExcluirCursoVinculadoAUmEstudante");

        this.curso = CursoServico.inserir(this.curso);

        Estudante estudante = new Estudante();
        estudante.setNome("Estudante");
        estudante.setSobrenome("Teste");
        estudante.setEmail("teste@teste.com");
        estudante.setTelefone("(44) 9 9999-9999");
        estudante.setRa("2023232323");
        estudante.setSenha("123456");
        estudante.setCurso(curso);

        estudante = EstudanteServico.inserir(estudante);

        CursoException cursoException = assertThrows(CursoException.class, () -> {
            CursoServico.excluir(curso);
        });

        EstudanteServico.excluir(estudante);
        assertEquals(MensagemUtil.CURSO_VINCULADO_ESTUDANTE, cursoException.getMessage());
    }
}
