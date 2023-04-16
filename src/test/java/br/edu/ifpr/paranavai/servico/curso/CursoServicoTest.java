package br.edu.ifpr.paranavai.servico.curso;

import br.edu.ifpr.paranavai.armarios.excecoes.CursoException;
import br.edu.ifpr.paranavai.armarios.servico.CursoServico;
import br.edu.ifpr.paranavai.armarios.modelo.Curso;
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

    @BeforeEach
    public void antesCadaTeste() {
        this.curso = new Curso();
        this.curso.setNome("Curso Teste");
    }

    @AfterEach
    public void aposCadaTeste() throws CursoException{
        CursoServico.excluir(this.curso);
    }

    @Test
    public void deveSalvarUmNovoCurso() throws CursoException {
        System.out.println("Executando teste deveSalvarUmNovoCurso");
        this.curso = CursoServico.inserir(this.curso);

        assertTrue(this.curso.getId() > 0);
        assertTrue(this.curso.getNome().equals("Curso Teste"));
        assertTrue(this.curso.isAtivo());
    }

    @Test
    public void naoDeveSalvarNomeDuplicado() {
        System.out.println("Executando teste naoDeveSalvarNomeDuplicado");

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

        Curso cursoASerExcluido = new Curso();
        cursoASerExcluido.setNome("Curso Exclusão");

        cursoASerExcluido = CursoServico.inserir(cursoASerExcluido);

        CursoServico.excluir(cursoASerExcluido);

        Curso cursoEncontrado = CursoServico.buscarPorId(cursoASerExcluido.getId());
        assertNull(cursoEncontrado);
    }
    /*
    @Test
    public void naoDeveExcluirCursoNaoEncontrado() {
        System.out.println("Executando teste naoDeveExcluirCursoNaoEncontrado");

        CursoException cursoException = assertThrows(CursoException.class, () -> {
            Curso cursoASerExcluido = new Curso();
            cursoASerExcluido.setId(-5);
            cursoASerExcluido.setNome("Curso Não Existente");
            CursoServico.excluir(cursoASerExcluido);
        });
        assertEquals(MensagemUtil.CURSO_NAO_ENCONTRADO, cursoException.getMessage());
    }&/
}
