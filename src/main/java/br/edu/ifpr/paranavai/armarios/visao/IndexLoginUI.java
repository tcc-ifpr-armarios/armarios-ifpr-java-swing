package br.edu.ifpr.paranavai.armarios.visao;

import br.edu.ifpr.paranavai.armarios.conexao.HibernateUtil;
import br.edu.ifpr.paranavai.armarios.excecoes.LoginException;
import br.edu.ifpr.paranavai.armarios.modelo.Servidor;
import br.edu.ifpr.paranavai.armarios.servico.LoginServico;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import br.edu.ifpr.paranavai.armarios.visao.utils.Carregando;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.apache.logging.log4j.core.config.Configurator;

/**
 *
 * @author Marcelo Figueiredo Terenciani
 */
public class IndexLoginUI extends javax.swing.JFrame {

    /**
     * Creates new form IndexLoginUI
     */
    public IndexLoginUI() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelConteudo = new JPanel() {
            public void paintComponent(Graphics g) {
                Image img = Toolkit.getDefaultToolkit().getImage(
                        br.edu.ifpr.paranavai.armarios.visao.IndexLoginUI.class.getResource("/assets/imgindex.png"));
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        lblTituloSistema = new javax.swing.JLabel();
        lblIconeIFPR = new javax.swing.JLabel();
        painelCentral = new javax.swing.JPanel();
        painelBorda = new javax.swing.JPanel();
        painelLogin = new javax.swing.JPanel();
        lblEmailOuSiape = new javax.swing.JLabel();
        txtEmailOuSiape = new javax.swing.JTextField();
        lblErroEmailOuSiape = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        lblErroSenha = new javax.swing.JLabel();
        lblResposta = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(MensagemUtil.TITULO_SISTEMA);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        painelConteudo.setBackground(new java.awt.Color(0, 153, 0));
        painelConteudo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        painelConteudo.setForeground(new java.awt.Color(255, 255, 255));
        painelConteudo.setLayout(new java.awt.BorderLayout());

        lblTituloSistema.setFont(new java.awt.Font("SansSerif", 0, 48)); // NOI18N
        lblTituloSistema.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloSistema.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloSistema.setText(MensagemUtil.TITULO_SISTEMA);
        lblTituloSistema.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 30, 1));
        painelConteudo.add(lblTituloSistema, java.awt.BorderLayout.PAGE_START);

        lblIconeIFPR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconeIFPR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/iflogomenor.png"))); // NOI18N
        painelConteudo.add(lblIconeIFPR, java.awt.BorderLayout.PAGE_END);

        painelCentral.setOpaque(false);
        painelCentral.setLayout(new java.awt.GridBagLayout());

        painelBorda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        painelBorda.setMinimumSize(new java.awt.Dimension(500, 500));
        painelBorda.setOpaque(false);
        painelBorda.setPreferredSize(new java.awt.Dimension(400, 450));
        painelBorda.setLayout(new java.awt.GridLayout(1, 1));

        painelLogin.setBackground(new java.awt.Color(0, 153, 0));
        painelLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        painelLogin.setPreferredSize(new java.awt.Dimension(340, 448));
        painelLogin.setLayout(new java.awt.GridLayout(8, 1, 0, 5));

        lblEmailOuSiape.setFont(new java.awt.Font("Source Sans Pro Black", 0, 24)); // NOI18N
        lblEmailOuSiape.setForeground(new java.awt.Color(255, 255, 255));
        lblEmailOuSiape.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmailOuSiape.setText("E-mail ou SIAPE");
        lblEmailOuSiape.setMaximumSize(new java.awt.Dimension(300, 54));
        lblEmailOuSiape.setMinimumSize(new java.awt.Dimension(300, 54));
        lblEmailOuSiape.setPreferredSize(new java.awt.Dimension(300, 54));
        painelLogin.add(lblEmailOuSiape);

        txtEmailOuSiape.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtEmailOuSiape.setMinimumSize(new java.awt.Dimension(100, 54));
        txtEmailOuSiape.setPreferredSize(new java.awt.Dimension(100, 54));
        txtEmailOuSiape.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailOuSiapeFocusLost(evt);
            }
        });
        painelLogin.add(txtEmailOuSiape);

        lblErroEmailOuSiape.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblErroEmailOuSiape.setForeground(new java.awt.Color(204, 0, 0));
        lblErroEmailOuSiape.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        painelLogin.add(lblErroEmailOuSiape);

        lblSenha.setFont(new java.awt.Font("Source Sans Pro Black", 0, 24)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(255, 255, 255));
        lblSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSenha.setText("Senha");
        painelLogin.add(lblSenha);

        txtSenha.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSenhaFocusLost(evt);
            }
        });
        painelLogin.add(txtSenha);

        lblErroSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblErroSenha.setForeground(new java.awt.Color(204, 0, 0));
        lblErroSenha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblErroSenha.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        painelLogin.add(lblErroSenha);

        lblResposta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblResposta.setForeground(new java.awt.Color(204, 0, 51));
        lblResposta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        painelLogin.add(lblResposta);

        btnEntrar.setFont(new java.awt.Font("Source Code Pro Black", 0, 24)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 102, 0))); // NOI18N
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        painelLogin.add(btnEntrar);

        painelBorda.add(painelLogin);

        painelCentral.add(painelBorda, new java.awt.GridBagConstraints());

        painelConteudo.add(painelCentral, java.awt.BorderLayout.CENTER);

        getContentPane().add(painelConteudo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEntrarActionPerformed
        lblResposta.setText("");

        String emailOuSiape = this.txtEmailOuSiape.getText();
        char[] caracteresSenha = this.txtSenha.getPassword();
        String senha = new String(caracteresSenha);

        if (emailOuSiape == null || emailOuSiape.isEmpty()) {
            lblErroEmailOuSiape.setText(MensagemUtil.LOGIN_EMAIL_OU_SIAPE_OBRIGATORIO);
            return;
        }

        if (senha.isEmpty()) {
            lblErroSenha.setText(MensagemUtil.LOGIN_SENHA_OBRIGATORIA);
            return;
        }

        try {
            Servidor servidor = LoginServico.verificaAdm(emailOuSiape, senha);
            lblResposta.setText(MensagemUtil.LOGIN_SUCESSO);
            txtSenha.setText("");
            txtEmailOuSiape.setText("");

            PainelDeControle painelControleUI = new PainelDeControle(servidor);
            painelControleUI.setVisible(true);
            this.setVisible(false);
            this.dispose();
        } catch (LoginException e) {
            lblResposta.setText(e.getMessage());
        }
    }// GEN-LAST:event_btnEntrarActionPerformed

    private void txtEmailOuSiapeFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtEmailOuSiapeFocusLost
        if (txtEmailOuSiape.getText() == null || txtEmailOuSiape.getText().isEmpty()) {
            lblErroEmailOuSiape.setText(MensagemUtil.LOGIN_EMAIL_OU_SIAPE_OBRIGATORIO);
        } else {
            lblErroEmailOuSiape.setText("");
        }
    }// GEN-LAST:event_txtEmailOuSiapeFocusLost

    private void txtSenhaFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtSenhaFocusLost
        char[] caracteresSenha = this.txtSenha.getPassword();
        String senha = new String(caracteresSenha);
        if (senha.isEmpty()) {
            lblErroSenha.setText(MensagemUtil.LOGIN_SENHA_OBRIGATORIA);
        } else {
            lblErroSenha.setText("");
        }
    }// GEN-LAST:event_txtSenhaFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Configurator.initialize(null, "log4j2.xml");
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IndexLoginUI.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        Carregando carregando = new Carregando();
        try {
            carregando.setVisible(true);
            HibernateUtil.getSession();
        } finally {
            new IndexLoginUI().setVisible(true);
            carregando.setVisible(false);
            carregando.dispose();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnEntrar;
    private javax.swing.JLabel lblEmailOuSiape;
    private javax.swing.JLabel lblErroEmailOuSiape;
    private javax.swing.JLabel lblErroSenha;
    private javax.swing.JLabel lblIconeIFPR;
    private javax.swing.JLabel lblResposta;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTituloSistema;
    private javax.swing.JPanel painelBorda;
    private javax.swing.JPanel painelCentral;
    private javax.swing.JPanel painelConteudo;
    private javax.swing.JPanel painelLogin;
    private javax.swing.JTextField txtEmailOuSiape;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
