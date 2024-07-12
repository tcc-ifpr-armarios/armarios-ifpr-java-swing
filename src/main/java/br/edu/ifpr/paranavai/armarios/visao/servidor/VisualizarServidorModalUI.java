package br.edu.ifpr.paranavai.armarios.visao.servidor;

import br.edu.ifpr.paranavai.armarios.modelo.Servidor;
import br.edu.ifpr.paranavai.armarios.utils.OperacaoUtil;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;


public class VisualizarServidorModalUI extends javax.swing.JDialog {

      
    public VisualizarServidorModalUI(JPanel parent, Servidor servidor) {
        super((JFrame)SwingUtilities.getWindowAncestor(parent), true);
        initComponents();
        preencheDados(servidor);
    }
    
    private void preencheDados(Servidor servidor) {
        campoNome.setText(servidor.getNome());
        campoEmail.setText(servidor.getEmail());
        campoSiape.setText(servidor.getSiape());
        campoTelefone.setText(servidor.getTelefone());
        campoDataRegistro.setText(OperacaoUtil.formatarDataHora(servidor.getDataCriacao()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelSuperior = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        campoNome = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        campoEmail = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        campoTelefone = new javax.swing.JLabel();
        lblSiape = new javax.swing.JLabel();
        campoSiape = new javax.swing.JLabel();
        lblDataRegistro = new javax.swing.JLabel();
        campoDataRegistro = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro Acadêmico");
        setBackground(new java.awt.Color(0, 153, 0));
        setMinimumSize(new java.awt.Dimension(100, 100));
        getContentPane().setLayout(new java.awt.BorderLayout(5, 0));

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));

        panelSuperior.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados de Registro", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        panelSuperior.setMinimumSize(new java.awt.Dimension(100, 100));

        lblNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNome.setText("Nome:");

        campoNome.setText("...");

        lblEmail.setText("E-mail:");

        campoEmail.setText("...");

        lblTelefone.setText("Telefone:");

        campoTelefone.setText("...");

        lblSiape.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSiape.setText("SIAPE:");

        campoSiape.setText("...");

        lblDataRegistro.setText("Data de Registro:");

        campoDataRegistro.setText("...");

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDataRegistro)
                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail)
                    .addComponent(lblTelefone)
                    .addComponent(lblSiape, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSuperiorLayout.createSequentialGroup()
                        .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoSiape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoDataRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelSuperiorLayout.createSequentialGroup()
                                .addComponent(campoEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(318, 318, 318))
                            .addComponent(campoNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(5, 5, 5))
                    .addGroup(panelSuperiorLayout.createSequentialGroup()
                        .addComponent(campoTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(campoNome))
                .addGap(4, 4, 4)
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(campoEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone)
                    .addComponent(campoTelefone))
                .addGap(5, 5, 5)
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSiape)
                    .addComponent(campoSiape))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataRegistro)
                    .addComponent(campoDataRegistro))
                .addGap(5, 5, 5))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/IfLogo_dark.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel campoDataRegistro;
    private javax.swing.JLabel campoEmail;
    private javax.swing.JLabel campoNome;
    private javax.swing.JLabel campoSiape;
    private javax.swing.JLabel campoTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDataRegistro;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSiape;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JPanel panelSuperior;
    // End of variables declaration//GEN-END:variables
}
