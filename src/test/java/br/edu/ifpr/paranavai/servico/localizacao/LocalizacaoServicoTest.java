/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.paranavai.servico.localizacao;

import br.edu.ifpr.paranavai.armarios.excecoes.LocalizacaoException;
import br.edu.ifpr.paranavai.armarios.modelo.Localizacao;
import br.edu.ifpr.paranavai.armarios.servico.LocalizacaoServico;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public class LocalizacaoServicoTest {
    
    
    private Localizacao localizacao;
    private Localizacao localizacaoAtualizacao;
 
    @BeforeEach
    public void antesCadaTeste(){
        this.localizacao = new Localizacao();
        this.localizacao.setDescricao("Localização teste");
    }
    
    @AfterEach 
    public void aposCadaTeste() throws LocalizacaoException{
     if (this.localizacao != null) {
         if (this.localizacao.getId() != null){
             Localizacao l = LocalizacaoServico.buscarPorId(this.localizacao.getId());
             if(l != null)
                 LocalizacaoServico.excluir(l);
         } else {
             Localizacao l = LocalizacaoServico.buscarPorNomeExato(this.localizacao.getDescricao());
             if(l != null)
                 LocalizacaoServico.excluir(l);
         }
     }
     this.localizacao = null;
}
    
 
    
}
