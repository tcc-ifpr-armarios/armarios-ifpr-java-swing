/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.dao;

import br.edu.ifpr.paranavai.armarios.conexao.HibernateUtil;
import br.edu.ifpr.paranavai.armarios.modelo.HistoricoBiblioteca;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author suporte
 */
public class HistoricoBibliotecaImpl implements HistoricoBibliotecaDao {
    
    private Session sessao;
    
    public HistoricoBibliotecaImpl(){
        this.sessao = HibernateUtil.getSession();
    }
    
    
     @Override
    public void inserir(HistoricoBiblioteca historicoBiblioteca) {
        try {
            sessao.beginTransaction();
            sessao.persist(historicoBiblioteca);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    public List<HistoricoBiblioteca> buscarTodos() {
        List<HistoricoBiblioteca> reservas = null;
        try {
            sessao.beginTransaction();
            reservas = (List<HistoricoBiblioteca>) this.sessao.createQuery("from HistoricoBiblioteca").list();
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservas;
    }
}
