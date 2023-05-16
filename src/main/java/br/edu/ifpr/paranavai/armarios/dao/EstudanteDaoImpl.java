package br.edu.ifpr.paranavai.armarios.dao;

import br.edu.ifpr.paranavai.armarios.conexao.HibernateUtil;
import br.edu.ifpr.paranavai.armarios.modelo.Estudante;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class EstudanteDaoImpl implements EstudanteDao {

    private Session sessao;

    public EstudanteDaoImpl() {
        this.sessao = HibernateUtil.getSession();
    }

    /**
     *
     * @return
     */
    @Override
    public List<Estudante> buscarTodos() {
        List<Estudante> estudantes = null;
        try {
            sessao.beginTransaction();
            estudantes = (List<Estudante>) this.sessao.createQuery("from Estudante").list();
            sessao.getTransaction().commit();
            sessao.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estudantes;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Estudante buscarPorId(Integer id) {
        Estudante estudante = null;
        try {
            sessao.beginTransaction();
            estudante = (Estudante) sessao.get(Estudante.class, id);
            sessao.getTransaction().commit();
            sessao.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estudante;
    }

    @Override
    public void inserir(Estudante estudante) {
        try {
            sessao.beginTransaction();
            sessao.persist(estudante);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Estudante estudante) {
        try {
            sessao.beginTransaction();
            sessao.update(estudante);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Estudante estudante) {
        try {
            sessao.beginTransaction();
            sessao.delete(estudante);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Estudante> buscarPorNome(String nome) {
        List<Estudante> estudantes = new ArrayList<>();
        try {
            sessao.beginTransaction();
            
            Query query = this.sessao.createQuery("from Estudante where nome = :nome");
            query.setParameter("nome", nome);
            estudantes = (List<Estudante>) query.list();
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estudantes;
    }

    @Override
    public List<Estudante> buscarPorRa(String ra) {
        List<Estudante> estudantes = new ArrayList<>();
        try {
            sessao.beginTransaction();
            
            Query query = this.sessao.createQuery("from Estudante where ra = :ra");
            query.setParameter("ra", ra);
            estudantes = (List<Estudante>) query.list();
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return estudantes;
    }

    @Override
    public Estudante buscarPorEmail(String email) {
        
        Estudante estudantes = new Estudante();
        try {
            sessao.beginTransaction();
            
            Query query = this.sessao.createQuery("from Estudante where email = :email");
            query.setParameter("email", email);
            estudantes = (Estudante)query.getSingleResult();
            sessao.getTransaction().commit();
            sessao.clear();
        } catch (Exception e) {
            e.printStackTrace();
            
            sessao.clear();
        }
        return estudantes;
    }
    
    /*
    @Override
    public Estudante buscarPorRaUnico(String ra) {
        Estudante estudante = null;
        try {
            sessao.beginTransaction();
            estudante = (Estudante) sessao.get(Estudante.class, ra);
            sessao.getTransaction().commit();
            sessao.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estudante;
    }*/
    
    @Override
    public Estudante buscarPorRaUnico(String ra) {
        Query<Estudante> query = this.sessao.createQuery("from Estudante where ra = :ra");
        query.setParameter("ra", ra);
        Estudante resultado = query.uniqueResult();
        return resultado;
    }
    
}
    
    
