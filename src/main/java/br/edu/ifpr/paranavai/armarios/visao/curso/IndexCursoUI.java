package br.edu.ifpr.paranavai.armarios.visao.curso;

import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import br.edu.ifpr.paranavai.armarios.controle.CursoControle;
import br.edu.ifpr.paranavai.armarios.modelo.Curso;

/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public class IndexCursoUI extends javax.swing.JFrame {
    List<Curso> listaDeCursos;
    /**
     * Creates new form EditorCursoUI
     */
    
    public IndexCursoUI() {
        initComponents();
        init();
    }
    
    public void init(){
        listaDeCursos = CursoControle.listarTodosCursos();
        populaTabela(listaDeCursos);
    }

    private void populaTabela(List<Curso> lista) {
        
        AcoesEventoTabela evento = new AcoesEventoTabelaCurso();
        
        DefaultTableModel modeloDeColunasDaTabela = (DefaultTableModel) tblCurso.getModel();
        tblCurso.getColumnModel().getColumn(3).setCellRenderer(new RenderizadorDasAcoesDaCelulaCurso());
        tblCurso.getColumnModel().getColumn(3).setCellEditor(new EditorDasAcoesDaCelulaCurso(evento, this));
        //  Primeiro limpa a tabela
        while (modeloDeColunasDaTabela.getRowCount() != 0) {
            modeloDeColunasDaTabela.removeRow(0);
        }
        
        for (int i = 0; i < lista.size(); i++) {
            Curso mostraCurso = lista.get(i);
            Object[] dadosLinha = new Object[3];
            dadosLinha[0] = mostraCurso.getId();
            dadosLinha[1] = mostraCurso.getNome();
            dadosLinha[2] = mostraCurso.isAtivo() ? "Ativo" : "Inativo";
            
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
        panelBusca = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        panelNovo = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        painelInferior = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCurso = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento de Cursos");
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        painelGeral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        painelGeral.setLayout(new java.awt.BorderLayout(0, 5));

        painelSuperior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0), 6));
        painelSuperior.setLayout(new java.awt.BorderLayout());

        panelBusca.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 0, 10));
        panelBusca.setLayout(new javax.swing.BoxLayout(panelBusca, javax.swing.BoxLayout.LINE_AXIS));

        lblNome.setText("Nome: ");
        panelBusca.add(lblNome);

        txtNome.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        panelBusca.add(txtNome);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        panelBusca.add(btnBuscar);

        painelSuperior.add(panelBusca, java.awt.BorderLayout.PAGE_START);

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

        painelSuperior.add(panelNovo, java.awt.BorderLayout.CENTER);

        painelGeral.add(painelSuperior, java.awt.BorderLayout.PAGE_START);

        painelInferior.setBackground(new java.awt.Color(0, 153, 0));
        painelInferior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0), 6));
        painelInferior.setLayout(new java.awt.BorderLayout());

        tblCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificador", "Nome", "Ativo", "Ações"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCurso.setRowHeight(30);
        tblCurso.setSelectionBackground(new java.awt.Color(57, 137, 111));
        tblCurso.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblCurso);
        if (tblCurso.getColumnModel().getColumnCount() > 0) {
            tblCurso.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblCurso.getColumnModel().getColumn(0).setMaxWidth(200);
            tblCurso.getColumnModel().getColumn(2).setMinWidth(100);
            tblCurso.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblCurso.getColumnModel().getColumn(2).setMaxWidth(100);
            tblCurso.getColumnModel().getColumn(3).setMinWidth(100);
            tblCurso.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblCurso.getColumnModel().getColumn(3).setMaxWidth(200);
        }

        painelInferior.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        painelGeral.add(painelInferior, java.awt.BorderLayout.CENTER);

        getContentPane().add(painelGeral);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        ArrayList<Curso> filtrado = new ArrayList<>();
        
        for (Curso localizacao : listaDeCursos) {
            if(localizacao.getNome().toUpperCase().contains(txtNome.getText().toUpperCase()))
                filtrado.add(localizacao);
        }
        
        populaTabela(filtrado);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        CriacaoEdicaoCursoUIModal criacaoEdicaoCurso = new CriacaoEdicaoCursoUIModal(this);
        criacaoEdicaoCurso.setLocationRelativeTo(this);
        criacaoEdicaoCurso.setVisible(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IndexCursoUI().setVisible(true);
            }
        });

    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JPanel painelGeral;
    private javax.swing.JPanel painelInferior;
    private javax.swing.JPanel painelSuperior;
    private javax.swing.JPanel panelBusca;
    private javax.swing.JPanel panelNovo;
    private javax.swing.JTable tblCurso;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}