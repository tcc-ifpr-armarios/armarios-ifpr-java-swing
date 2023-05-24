/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.dao.impl;

import br.edu.ifpr.paranavai.armarios.conexao.HibernateUtil;
import br.edu.ifpr.paranavai.armarios.modelo.Reserva;
import java.util.ArrayList;
import org.hibernate.Session;
import java.util.List;
import org.hibernate.query.Query;
import br.edu.ifpr.paranavai.armarios.dao.ArmarioDao;

public class ReservaImpl implements ArmarioDao {

    private Session sessao;

    public ReservaImpl() {
        this.sessao = HibernateUtil.getSession();
    }

    @Override
    public List<Reserva> buscarTodos() {
        List<Reserva> reservas = null;
        try {
            sessao.beginTransaction();
            reservas = (List<Reserva>) this.sessao.createQuery("from Reserva").list();
            sessao.getTransaction().commit();
            sessao.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservas;
    }

    @Override
    public Reserva buscarPorId(Integer id) {
        Reserva reserva = null;
        try {
            sessao.beginTransaction();
            reserva = (Reserva) sessao.get(Reserva.class, id);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reserva;
    }

    @Override
    public void atualizar(Reserva reserva) {
        try {
            sessao.beginTransaction();
            sessao.update(reserva);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Reserva reserva) {
        try {
            sessao.beginTransaction();
            sessao.delete(reserva);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void inserir(Reserva reserva) {
        try {
            sessao.beginTransaction();
            sessao.persist(reserva);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Reserva> buscarTodosAtivos(boolean ativo) {
        List<Reserva> reservas = new ArrayList<>();
        try {
            sessao.beginTransaction();
            Query query = this.sessao.createQuery("from Reserva where ativo = : ativo");
            query.setParameter("ativo", ativo);
            reservas = (List<Reserva>) query.list();
            sessao.getTransaction().commit();
            sessao.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservas;
    }

    @Override
    public void apagaPorNumero(Integer numero) {

        try {
            sessao.beginTransaction();
            Query query = sessao.createQuery("delete Reserva where numero = :numero");
            query.setParameter("numero", numero);
            int result = query.executeUpdate();
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Reserva> buscarPorAluno(Integer estudante_id_pessoa) {
        List<Reserva> reservas = new ArrayList<>();
        try {
            sessao.beginTransaction();
            Query query = this.sessao.createQuery("from Reserva where estudante.id = :idEstudante");
            query.setParameter("idEstudante", estudante_id_pessoa);

            reservas = (List<Reserva>) query.list();
            sessao.getTransaction().commit();
            sessao.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservas;
    }

    /*
    @Override
    public List<ReservaBiblioteca> buscarPorLocalizacao(Integer localizacao) {
        List<ReservaBiblioteca> reservas = new ArrayList<>();
        try {
            sessao.beginTransaction();
            Query query =  this.sessao.createQuery("from ReservaBiblioteca where localizacao_id = : localizacao_id ");
            query.setParameter("localizacao_id", localizacao);
            
            reservas = (List<ReservaBiblioteca>) query.list();
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservas;
    }*/
    @Override
    public List<Reserva> buscarPorLocalizacao(Integer localizacao_id_localizacao) {
        Query<Reserva> query = this.sessao.createQuery("from Reserva where localizacao.id = :idLocalizacao");
        query.setParameter("idLocalizacao", localizacao_id_localizacao);
        List<Reserva> resultado = query.getResultList();
        return resultado;
    }

    @Override
    public Reserva buscarNumeroPorLocalizacao(Integer idLocal, Integer numero) {
        // buscar por nome exato com id difente
        Query<Reserva> query = this.sessao.createQuery("from Reserva where localizacao.id = :idLocalizacao and numero = :numero");
        query.setParameter("idLocalizacao", idLocal);
        query.setParameter("numero", numero);
        Reserva resultado = query.uniqueResult();
        return resultado;
    }

    /*
    @Override
    public List<Reserva> buscarAtivoPorLocalizacao(Integer idLocal, boolean estado) {
        // buscar por estado de cada localização
        // Como funciona: reservas ativas e disponíveis ficam com o ativo=true, ficam false quando reservado. 
        Query<Reserva> query = this.sessao.createQuery("from Reserva where localizacao.id = :idLocalizacao and ativo = :estado");
        query.setParameter("idLocalizacao", idLocal);
        query.setParameter("ativo", estado);
        List<Reserva> resultado = query.getResultList();
        sessao.clear();
        return resultado;
    }*/
    @Override
    public List<Reserva> buscarAtivoPorLocalizacao(Integer idLocal, boolean ativo) {
        List<Reserva> reservas = new ArrayList<>();
        try {
            sessao.beginTransaction();
            Query query = this.sessao.createQuery("from Reserva where localizacao.id = :idLocalizacao and ativo = : ativo order by numero ASC");
            query.setParameter("idLocalizacao", idLocal);
            query.setParameter("ativo", ativo);
            reservas = (List<Reserva>) query.list();
            sessao.getTransaction().commit();
            sessao.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservas;
    }

    @Override
    public void apagaPorNumeroNaLocalizacao(Integer numero, Integer idLocal) {

        try {
            sessao.beginTransaction();
            Query query = sessao.createQuery("delete Reserva where numero = :numero and localizacao.id = :idLocalizacao");
            query.setParameter("numero", numero);
            query.setParameter("idLocalizacao", idLocal);
            int result = query.executeUpdate();
            sessao.getTransaction().commit();
            sessao.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Reserva buscarPorAlunoUnico(Integer id) {
        
        
            sessao.beginTransaction();
            Query<Reserva> query = this.sessao.createQuery("from Reserva where estudante.id = :idEstudante");
            query.setParameter("idEstudante", id);

            Reserva resultado = query.uniqueResult();
            sessao.getTransaction().commit();
            sessao.clear();
        
        return resultado;
       
    }

}
