package br.edu.ifpr.paranavai.armarios.dao.impl;

import br.edu.ifpr.paranavai.armarios.conexao.HibernateUtil;
import br.edu.ifpr.paranavai.armarios.dao.CursoDao;
import br.edu.ifpr.paranavai.armarios.excecoes.CursoException;
import br.edu.ifpr.paranavai.armarios.modelo.Curso;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Professor Marcelo F. Terenciani
 */
public class CursoDaoImpl implements CursoDao {

    private Session sessao;

    public CursoDaoImpl() {
        this.sessao = HibernateUtil.getSession();
    }

    @Override
    public List<Curso> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Curso buscarPorId(Integer inteiro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Curso atualizar(Curso curso) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void excluir(Curso curso) {
        try {
            sessao.beginTransaction();
            sessao.remove(curso);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Curso inserir(Curso curso) throws CursoException {
        try {
            sessao.beginTransaction();
            sessao.persist(curso);
            sessao.getTransaction().commit();
        } catch (ConstraintViolationException e){
            throw new CursoException(MensagemUtil.CURSO_NOME_DUPLICADO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CursoException(MensagemUtil.CURSO_ERRO_PADRAO_DE_INSERCAO);
        }
        return curso;
    }

}
