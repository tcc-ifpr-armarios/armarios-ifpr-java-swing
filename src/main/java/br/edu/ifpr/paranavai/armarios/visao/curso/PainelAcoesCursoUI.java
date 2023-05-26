package br.edu.ifpr.paranavai.armarios.visao.curso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;

/**
 *
 * @author professor Marcelo Figueiredo Terenciani
 */
public class PainelAcoesCursoUI extends javax.swing.JPanel {

    /**
     * Creates new form PanelAcoes
     */
    public PainelAcoesCursoUI() {
        initComponents();
    }

    public void iniciarEventos(AcoesEventoTabela evento, JTable tabela, int linha) {
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento.aoEditar(tabela, linha);
            }
        });
        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento.aoExcluir(tabela, linha);
            }
        });
        btnVisualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento.aoVisualizar(tabela, linha);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVisualizar = new br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesDoBotao();
        btnEditar = new br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesDoBotao();
        btnExcluir = new br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesDoBotao();

        btnVisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/visualizar-16.png"))); // NOI18N
        btnVisualizar.setVisible(true);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/editar-16.png"))); // NOI18N

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/excluir-16.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesDoBotao btnEditar;
    private br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesDoBotao btnExcluir;
    private br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesDoBotao btnVisualizar;
    // End of variables declaration//GEN-END:variables
}
