package br.edu.ifpr.paranavai.armarios.servico;

import br.edu.ifpr.paranavai.armarios.dao.ArmarioDao;
import br.edu.ifpr.paranavai.armarios.dao.EmprestimoDao;
import br.edu.ifpr.paranavai.armarios.dao.EstudanteDao;
import br.edu.ifpr.paranavai.armarios.dao.impl.ArmarioDaoImpl;
import br.edu.ifpr.paranavai.armarios.dao.impl.EmprestimoDaoImpl;
import br.edu.ifpr.paranavai.armarios.dao.impl.EstudanteDaoImpl;

/**
 *
 * @author prof Marcelo Figueiredo Terenciani
 */
public class IndicadorServico {

    private static EstudanteDao daoEstudante = new EstudanteDaoImpl();
    private static ArmarioDao daoArmario = new ArmarioDaoImpl();
    private static EmprestimoDao daoEmprestimo = new EmprestimoDaoImpl();

    public static Long quantidadeEstudantesAtivos() {
        return daoEstudante.quantidadeEstudantesAtivos();
    }

    public static Long quantidadeArmariosLivres() {
        return daoArmario.quantidadeArmariosLivres();
    }

    public static Long quantidadeEmprestimosAtivos() {
        return daoEmprestimo.quantidadeEmprestimosAtivos();

    }

}
