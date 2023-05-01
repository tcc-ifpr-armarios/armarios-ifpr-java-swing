/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.dao;

import br.edu.ifpr.paranavai.armarios.modelo.Localizacao;
import java.util.List;

/**
 *
 * @author suporte
 */
public interface LocalizacaoDao {
    public List<Localizacao> buscarTodos();
    
    public List<Localizacao> buscarTodosAtivos(boolean ativo);

    public Localizacao buscarPorId(Integer inteiro);

    public void atualizar(Localizacao localizacao);

    public void excluir(Localizacao localizacao);

    public void inserir(Localizacao localizacao);
    
    public Localizacao buscarPorNomeExato(String descricao);
    
 
    
}

