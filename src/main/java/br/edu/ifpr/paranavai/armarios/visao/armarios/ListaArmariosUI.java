package br.edu.ifpr.paranavai.armarios.visao.armarios;

import java.util.List;
import javax.swing.table.DefaultTableModel;

import br.edu.ifpr.paranavai.armarios.modelo.Armario;
import br.edu.ifpr.paranavai.armarios.servico.ArmarioServico;
import br.edu.ifpr.paranavai.armarios.servico.EmprestimoServico;
import br.edu.ifpr.paranavai.armarios.visao.tabela.acoes.AcoesEventoTabela;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public class ListaArmariosUI extends javax.swing.JFrame {
    List<Armario> listaDeArmarios;
    
    
    //int localId =  Integer.parseInt(System.getProperty("localId"));
    private int localId;

    public int getLocalId() {
        return localId;
    }
    
    /**
     * Creates new form EditorCursoUI
     */
    
    public ListaArmariosUI(IndexArmariosUI indexArmariosUI) {
        
        initComponents();
        init();
        System.out.print(localId);
        setLocationRelativeTo(indexArmariosUI);
    }

    ListaArmariosUI(IndexArmariosUI indexArmariosUI, int identificador) {
        this(indexArmariosUI);
        this.localId = identificador;
        init();
    }
    
    public void init(){
        listaDeArmarios = ArmarioServico.buscarAtivoPorIdLocalizacao(localId);
        populaTabela(listaDeArmarios);
    }

    private void populaTabela(List<Armario> lista) {
        
        AcoesEventoTabela evento = new AcoesEventoTabelaArmariosEmArmariosUI();
        
        DefaultTableModel modeloDeColunasDaTabela = (DefaultTableModel) tblArmarios.getModel();
        tblArmarios.getColumnModel().getColumn(1).setCellRenderer(new RenderizadorDasAcoesDaCelulaArmariosEmArmarios());
        tblArmarios.getColumnModel().getColumn(1).setCellEditor(new EditorDasAcoesDaCelulaArmarioEmArmariosUI(evento, this, localId));
        //  Primeiro limpa a tabela
        while (modeloDeColunasDaTabela.getRowCount() != 0) {
            modeloDeColunasDaTabela.removeRow(0);
        }
        
        for (int i = 0; i < lista.size(); i++) {
            Armario mostraArmario = lista.get(i);
            Object[] dadosLinha = new Object[1];
            dadosLinha[0] = mostraArmario.getNumero();
            
            
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
        painelInferior = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArmarios = new javax.swing.JTable();
        panelNovo = new javax.swing.JPanel();
        novoArmario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento de Cursos");
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        painelGeral.setBackground(new java.awt.Color(0, 153, 0));
        painelGeral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        painelGeral.setLayout(new java.awt.BorderLayout(0, 5));

        painelInferior.setBackground(new java.awt.Color(0, 153, 0));
        painelInferior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0), 6));
        painelInferior.setLayout(new java.awt.BorderLayout());

        tblArmarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Armário Número", "Apagar Armário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblArmarios.setRowHeight(30);
        tblArmarios.setSelectionBackground(new java.awt.Color(57, 137, 111));
        tblArmarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblArmarios);

        painelInferior.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelNovo.setBackground(new java.awt.Color(204, 204, 204));
        panelNovo.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelNovo.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

        novoArmario.setText("Novo Armário");
        novoArmario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoArmarioActionPerformed(evt);
            }
        });
        panelNovo.add(novoArmario);

        painelInferior.add(panelNovo, java.awt.BorderLayout.PAGE_END);

        painelGeral.add(painelInferior, java.awt.BorderLayout.CENTER);

        getContentPane().add(painelGeral);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void novoArmarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoArmarioActionPerformed
        CadastraArmarioEmArmariosUI cadastraArmarioEmArmariosUI = new CadastraArmarioEmArmariosUI(this, localId);
        cadastraArmarioEmArmariosUI.setLocationRelativeTo(this);
        cadastraArmarioEmArmariosUI.setVisible(true);
    }//GEN-LAST:event_novoArmarioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton novoArmario;
    private javax.swing.JPanel painelGeral;
    private javax.swing.JPanel painelInferior;
    private javax.swing.JPanel panelNovo;
    private javax.swing.JTable tblArmarios;
    // End of variables declaration//GEN-END:variables
}