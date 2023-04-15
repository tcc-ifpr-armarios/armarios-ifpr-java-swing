package br.edu.ifpr.paranavai.servico.curso;

import br.edu.ifpr.paranavai.armarios.excecoes.CursoException;
import br.edu.ifpr.paranavai.armarios.servico.CursoServico;
import br.edu.ifpr.paranavai.armarios.modelo.Curso;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Professor Marcelo F. Terenciani
 */
public class CursoServicoTest {

    @Test
    public void deveSalvarUmNovoCurso() throws CursoException {
        System.out.println("Executando teste deveSalvarUmNovoCurso");
        Curso curso = new Curso();
        curso.setNome("Curso Teste");

        curso = CursoServico.inserir(curso);

        assertTrue(curso.getId() > 0);

        // Apaga o registro
        CursoServico.excluir(curso);
    }

    @Test
    public void naoDeveSalvarNomeDuplicado() {
        System.out.println("Executando teste naoDeveSalvarNomeDuplicado");

        CursoException cursoException = assertThrows(CursoException.class, () -> {
            Curso curso = new Curso();
            curso.setNome("Curso Teste");

            curso = CursoServico.inserir(curso);
            Curso cursoDuplicado = new Curso();
            cursoDuplicado.setNome("Curso Teste");

            try {
                CursoServico.inserir(cursoDuplicado);
            } catch (Exception e) {
                // Apaga o registro
                CursoServico.excluir(curso);
            }

        });
        assertEquals(MensagemUtil.CURSO_NOME_DUPLICADO, cursoException.getMessage());
    }

}
