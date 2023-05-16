/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.dao;

import br.edu.ifpr.paranavai.armarios.modelo.Reserva;
import java.util.List;

/**
 *
 * @author suporte
 */
public interface ReservaDao {
    public List<Reserva> buscarTodos();
    
    public List<Reserva> buscarTodosAtivos(boolean ativo);

    public Reserva buscarPorId(Integer inteiro);

    public void atualizar(Reserva reservaBlioteca);

    public void excluir(Reserva reservaBlioteca);

    public void inserir(Reserva reservaBlioteca);
    
    public void apagaPorNumero(Integer numero);
    
    public List<Reserva> buscarPorAluno(Integer id);
    
    public List<Reserva> buscarPorLocalizacao(Integer id);
    
    public Reserva buscarNumeroPorLocalizacao(Integer idLocal, Integer numero);
    
    public List<Reserva> buscarAtivoPorLocalizacao(Integer idLocal, boolean estado);

    public void apagaPorNumeroNaLocalizacao(Integer numero, Integer idLocal);
}

