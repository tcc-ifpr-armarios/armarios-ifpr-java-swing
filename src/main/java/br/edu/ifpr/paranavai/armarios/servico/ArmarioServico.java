package br.edu.ifpr.paranavai.armarios.servico;

import br.edu.ifpr.paranavai.armarios.dao.impl.ArmarioDaoImpl;
import br.edu.ifpr.paranavai.armarios.excecoes.ArmarioException;
import br.edu.ifpr.paranavai.armarios.modelo.Armario;
import java.util.List;
import br.edu.ifpr.paranavai.armarios.dao.ArmarioDao;

/**
 *
 * @author suporte
 */
public class ArmarioServico {
    private static ArmarioDao dao = new ArmarioDaoImpl();

    public static List<Armario> buscarTodos() {
        return dao.buscarTodos();
    }
    
    public static List<Armario> buscarTodosAtivos() {
        return dao.buscarTodosAtivos();
    }

    public static Armario buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }
    
    public static String inserir(Armario armario) throws ArmarioException {
        //Verifica se já contem o número do armário com base na localização
        Armario c = dao.buscarNumeroPorLocalizacao(armario.getLocalizacao().getId(), armario.getNumero());
        if (c != null) {
            return "Número de armário já cadastrado";
        } else

        dao.inserir(armario);
    return "Armário cadastrado com sucesso";
    }

    public static void atualizar(Armario armario) {
        dao.atualizar(armario);
    }

    public static void excluir(Armario armario) throws ArmarioException {
        dao.excluir(armario);
    }
    
    public static void apagaPorNumero(Integer numero){
         dao.apagaPorNumero(numero);
    }
    
    
    public static List<Armario> buscarPorLocalizacao(Integer id) {
        return dao.buscarPorLocalizacao(id);
    }
    
    public static Armario buscarNumeroPorLocalizacao(Integer idLocal, Integer numero) {
        return dao.buscarNumeroPorLocalizacao(idLocal, numero);
    }
    
     public static List<Armario> buscarAtivoPorLocalizacao(Integer idLocal, boolean estado) {
        return dao.buscarAtivoPorLocalizacao(idLocal, estado);
    }
     
     public static void apagaPorNumeroNaLocalizacao(Integer numero, Integer idLocal) {
        dao.apagaPorNumeroNaLocalizacao(numero, idLocal);
     }
     
     public static Armario buscarPorAlunoUnico(Integer id) {
        return dao.buscarPorAlunoUnico(id);
    }
}
