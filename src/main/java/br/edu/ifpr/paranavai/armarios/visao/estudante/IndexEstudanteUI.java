package br.edu.ifpr.paranavai.armarios.visao.estudante;

import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import br.edu.ifpr.paranavai.armarios.controle.EstudanteControle;
import br.edu.ifpr.paranavai.armarios.modelo.Estudante;

/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public class IndexEstudanteUI extends javax.swing.JFrame {
    List<Estudante> listaDeEstudantes;
    
    public IndexEstudanteUI() {
        initComponents();
        init();
    }
    
    public void init(){
        listaDeEstudantes = EstudanteControle.listarTodosEstudantes();
        populaTabela(listaDeEstudantes);
    }

    private void populaTabela(List<Estudante> lista) {
        
        AcoesEventoTabela evento = new AcoesEventoTabelaEstudante();
        
        DefaultTableModel modeloDeColunasDaTabela = (DefaultTableModel) tblEstudante.getModel();
        tblEstudante.getColumnModel().getColumn(7).setCellRenderer(new RenderizadorDasAcoesDaCelulaEstudante());
        tblEstudante.getColumnModel().getColumn(7).setCellEditor(new EditorDasAcoesDaCelulaEstudante(evento, this));
        //  Primeiro limpa a tabela
        while (modeloDeColunasDaTabela.getRowCount() != 0) {
            modeloDeColunasDaTabela.removeRow(0);
        }
        
        for (int i = 0; i < lista.size(); i++) {
            Estudante mostraEstudante = lista.get(i);
            Object[] dadosLinha = new Object[7];
            dadosLinha[0] = mostraEstudante.getId();
            dadosLinha[1] = mostraEstudante.getRa();
            dadosLinha[2] = mostraEstudante.getNomeCompleto();
            dadosLinha[3] = mostraEstudante.getTelefone();
            dadosLinha[4] = mostraEstudante.getEmail();
            dadosLinha[5] = mostraEstudante.getCurso().getNome();
            dadosLinha[6] = mostraEstudante.isAtivo() ? "Ativo" : "Inativo";
            
            modeloDeColunasDaTabela.addRow(dadosLinha);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelGeral = new javax.swing.JPanel();
        painelSuperior = new javax.swing.JPanel();
        panelEscolherFiltro = new javax.swing.JPanel();
        lblTipoFiltro = new javax.swing.JLabel();
        radioRa = new javax.swing.JRadioButton();
        radioNome = new javax.swing.JRadioButton();
        panelBusca = new javax.swing.JPanel();
        lblBusca = new javax.swing.JLabel();
        txtBusca = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        panelNovo = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        painelInferior = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstudante = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento de Estudantes");
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setSize(new java.awt.Dimension(1000, 600));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        painelGeral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        painelGeral.setLayout(new java.awt.BorderLayout(0, 5));

        painelSuperior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0), 6));
        painelSuperior.setLayout(new java.awt.GridLayout(3, 0));

        panelEscolherFiltro.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 0, 10));
        panelEscolherFiltro.setLayout(new javax.swing.BoxLayout(panelEscolherFiltro, javax.swing.BoxLayout.LINE_AXIS));

        lblTipoFiltro.setText("Buscar por:");
        panelEscolherFiltro.add(lblTipoFiltro);

        radioRa.setSelected(true);
        radioRa.setText("Ra");
        radioRa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioRaActionPerformed(evt);
            }
        });
        panelEscolherFiltro.add(radioRa);

        radioNome.setText("Nome");
        radioNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNomeActionPerformed(evt);
            }
        });
        panelEscolherFiltro.add(radioNome);

        painelSuperior.add(panelEscolherFiltro);

        panelBusca.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 0, 10));
        panelBusca.setLayout(new javax.swing.BoxLayout(panelBusca, javax.swing.BoxLayout.LINE_AXIS));

        lblBusca.setText("RA: ");
        panelBusca.add(lblBusca);

        txtBusca.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        panelBusca.add(txtBusca);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        panelBusca.add(btnBuscar);

        painelSuperior.add(panelBusca);

        panelNovo.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelNovo.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

        btnNovo.setText("Novo");
        btnNovo.setMaximumSize(new java.awt.Dimension(72, 72));
        btnNovo.setMinimumSize(new java.awt.Dimension(72, 72));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        panelNovo.add(btnNovo);

        painelSuperior.add(panelNovo);

        painelGeral.add(painelSuperior, java.awt.BorderLayout.PAGE_START);

        painelInferior.setBackground(new java.awt.Color(0, 153, 0));
        painelInferior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0), 6));
        painelInferior.setLayout(new java.awt.BorderLayout());

        tblEstudante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificador", "Matrícula", "Nome", "Telefone", "E-mail", "Curso", "Ativo", "Ações"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEstudante.setRowHeight(30);
        tblEstudante.setSelectionBackground(new java.awt.Color(57, 137, 111));
        tblEstudante.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblEstudante);
        if (tblEstudante.getColumnModel().getColumnCount() > 0) {
            tblEstudante.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblEstudante.getColumnModel().getColumn(0).setMaxWidth(200);
            tblEstudante.getColumnModel().getColumn(1).setMaxWidth(200);
            tblEstudante.getColumnModel().getColumn(3).setMaxWidth(200);
            tblEstudante.getColumnModel().getColumn(5).setMinWidth(150);
            tblEstudante.getColumnModel().getColumn(5).setMaxWidth(300);
            tblEstudante.getColumnModel().getColumn(6).setMinWidth(100);
            tblEstudante.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblEstudante.getColumnModel().getColumn(6).setMaxWidth(100);
            tblEstudante.getColumnModel().getColumn(7).setMinWidth(100);
            tblEstudante.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblEstudante.getColumnModel().getColumn(7).setMaxWidth(200);
        }

        painelInferior.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        painelGeral.add(painelInferior, java.awt.BorderLayout.CENTER);

        getContentPane().add(painelGeral);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        ArrayList<Estudante> filtrado = new ArrayList<>();
        if(radioNome.isSelected()){
        for (Estudante estudante : listaDeEstudantes) {
            if(estudante.getNomeCompleto().toUpperCase().contains(txtBusca.getText().toUpperCase()))
                filtrado.add(estudante);
        }
        } else if(radioRa.isSelected())
        {
            for (Estudante estudante : listaDeEstudantes) {
            if(estudante.getRa().toUpperCase().contains(txtBusca.getText().toUpperCase()))
                filtrado.add(estudante);
        }
        }
        
        populaTabela(filtrado);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        CriacaoEdicaoEstudanteUIModal criacaoEdicaoEstudante = new CriacaoEdicaoEstudanteUIModal(this);
        criacaoEdicaoEstudante.setLocationRelativeTo(this);
        criacaoEdicaoEstudante.setVisible(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void radioRaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioRaActionPerformed
        radioRa.setSelected(true);
        lblBusca.setText("RA:");
        radioNome.setSelected(false);
    }//GEN-LAST:event_radioRaActionPerformed

    private void radioNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNomeActionPerformed
        radioNome.setSelected(true);
        lblBusca.setText("Nome:");
        radioRa.setSelected(false);
    }//GEN-LAST:event_radioNomeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaAlunoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaAlunoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaAlunoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaAlunoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IndexEstudanteUI().setVisible(true);
            }
        });

    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBusca;
    private javax.swing.JLabel lblTipoFiltro;
    private javax.swing.JPanel painelGeral;
    private javax.swing.JPanel painelInferior;
    private javax.swing.JPanel painelSuperior;
    private javax.swing.JPanel panelBusca;
    private javax.swing.JPanel panelEscolherFiltro;
    private javax.swing.JPanel panelNovo;
    private javax.swing.JRadioButton radioNome;
    private javax.swing.JRadioButton radioRa;
    private javax.swing.JTable tblEstudante;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}