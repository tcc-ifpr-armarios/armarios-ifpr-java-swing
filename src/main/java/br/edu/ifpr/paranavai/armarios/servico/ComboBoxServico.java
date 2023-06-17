package br.edu.ifpr.paranavai.armarios.servico;

import java.util.Arrays;
import java.util.List;

import br.edu.ifpr.paranavai.armarios.modelo.Armario;
import br.edu.ifpr.paranavai.armarios.modelo.Curso;
import br.edu.ifpr.paranavai.armarios.modelo.Estudante;
import br.edu.ifpr.paranavai.armarios.modelo.Localizacao;
import br.edu.ifpr.paranavai.armarios.modelo.StatusArmario;
import br.edu.ifpr.paranavai.armarios.visao.combobox.ArmarioComboBoxModel;
import br.edu.ifpr.paranavai.armarios.visao.combobox.CursoComboBoxModel;
import br.edu.ifpr.paranavai.armarios.visao.combobox.EstudanteComboBoxModel;
import br.edu.ifpr.paranavai.armarios.visao.combobox.LocalizacaoComboBoxModel;
import br.edu.ifpr.paranavai.armarios.visao.combobox.StatusArmarioComboBoxModel;

/**
 *
 * @author professor Marcelo F. Terenciani
 */
public class ComboBoxServico {

    public static CursoComboBoxModel inicializaComboBoxCurso() {
        CursoComboBoxModel cursoComboBoxModel = new CursoComboBoxModel();

        List<Curso> cursos = CursoServico.buscarTodosAtivos();

        for (Curso curso : cursos) {
            cursoComboBoxModel.addCurso(curso);
        }
        return cursoComboBoxModel;
    }

    public static LocalizacaoComboBoxModel inicializaComboBoxLocalizacao() {
        LocalizacaoComboBoxModel localizacaoComboBoxModel = new LocalizacaoComboBoxModel();

        List<Localizacao> localizacoes = LocalizacaoServico.buscarAtivos();

        for (Localizacao localizacao : localizacoes) {
            localizacaoComboBoxModel.addLocalizacao(localizacao);
        }
        return localizacaoComboBoxModel;
    }

    public static ArmarioComboBoxModel inicializaComboBoxArmario(Localizacao localizacao) {
        ArmarioComboBoxModel armarioComboBoxModel = new ArmarioComboBoxModel();

        List<Armario> armarios = ArmarioServico.buscarAtivoPorIdLocalizacao(localizacao.getId());

        for (Armario armario : armarios) {
            armarioComboBoxModel.addArmario(armario);
        }
        return armarioComboBoxModel;
    }
    
     public static ArmarioComboBoxModel inicializaComboBoxArmarioAtivo(Localizacao localizacao) {
        ArmarioComboBoxModel armarioComboBoxModel = new ArmarioComboBoxModel();

        List<Armario> armarios = ArmarioServico.buscarPorStatusIdLocalizacao(localizacao.getId(), StatusArmario.ATIVO);

        for (Armario armario : armarios) {
            armarioComboBoxModel.addArmario(armario);
        }
        return armarioComboBoxModel;
    }

    public static EstudanteComboBoxModel inicializaComboBoxEstudante() {
        EstudanteComboBoxModel armarioComboBoxModel = new EstudanteComboBoxModel();

        List<Estudante> estudantes = EstudanteServico.buscarAtivos();

        for (Estudante estudante : estudantes) {
            armarioComboBoxModel.addEstudante(estudante);
        }
        return armarioComboBoxModel;
    }
    
    public static EstudanteComboBoxModel inicializaComboBoxEstudanteBuscaRa(String ra) {
        EstudanteComboBoxModel armarioComboBoxModel = new EstudanteComboBoxModel();

        List<Estudante> estudantes = EstudanteServico.buscarEstudantesPorRa(ra);

        for (Estudante estudante : estudantes) {
            armarioComboBoxModel.addEstudante(estudante);
        }
        return armarioComboBoxModel;
    }

    public static StatusArmarioComboBoxModel inicializaComboBoxStatus() {
        StatusArmarioComboBoxModel statusArmarioComboBoxModel = new StatusArmarioComboBoxModel();

        List<StatusArmario> statusArmarios = Arrays.asList(StatusArmario.values());

        for (StatusArmario s : statusArmarios) {
            statusArmarioComboBoxModel.addStatusArmario(s);
        }
        return statusArmarioComboBoxModel;
    }
}
