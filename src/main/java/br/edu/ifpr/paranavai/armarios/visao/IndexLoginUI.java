/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.ifpr.paranavai.armarios.visao;

import br.edu.ifpr.paranavai.armarios.visao.aluno.AlunoReservaUI;
import br.edu.ifpr.paranavai.armarios.conexao.HibernateUtil;
import br.edu.ifpr.paranavai.armarios.controle.LoginControlador;
import br.edu.ifpr.paranavai.armarios.utils.MensagemUtil;
import br.edu.ifpr.paranavai.armarios.visao.aluno.AlunoDevolucaoUI;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.apache.logging.log4j.core.config.Configurator;

/**
 *
 * @author Allan Fernando O de Andrade
 */
public class IndexLoginUI extends javax.swing.JFrame {

    LoginControlador controle = new LoginControlador();

    /**
     * Creates new form IndexloginUI
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jMenu1 = new javax.swing.JMenu();
        jPanel3 = new javax.swing.JPanel();
        indexImg = new JPanel() {  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                    IndexLoginUI.class.getResource("/assets/imgindex.png"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
        }; ;
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtFieldEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        passFieldSenha = new javax.swing.JPasswordField();
        jToggleButton1 = new javax.swing.JToggleButton();
        lblResposta = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel3.setBackground(new java.awt.Color(0, 153, 0));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Source Serif Pro Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Biblioteca IFPR");

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LOGIN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Source Serif Pro Black", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        txtFieldEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFieldEmailMouseClicked(evt);
            }
        });
        txtFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldEmailActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Source Sans Pro Black", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("E-mail");

        jLabel3.setFont(new java.awt.Font("Source Sans Pro Black", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Senha");

        passFieldSenha.setText("jPasswordField1");
        passFieldSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passFieldSenhaMouseClicked(evt);
            }
        });
        passFieldSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFieldSenhaActionPerformed(evt);
            }
        });

        jToggleButton1.setFont(new java.awt.Font("Source Code Pro Black", 0, 12)); // NOI18N
        jToggleButton1.setText("ENTRAR");
        jToggleButton1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 102, 0))); // NOI18N
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtFieldEmail, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel3)))
                .addContainerGap(81, Short.MAX_VALUE))
            .addComponent(passFieldSenha)
            .addComponent(jToggleButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton1)
                .addContainerGap())
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/iflogomenor.png"))); // NOI18N

        javax.swing.GroupLayout indexImgLayout = new javax.swing.GroupLayout(indexImg);
        indexImg.setLayout(indexImgLayout);
        indexImgLayout.setHorizontalGroup(
            indexImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(indexImgLayout.createSequentialGroup()
                .addGroup(indexImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(indexImgLayout.createSequentialGroup()
                        .addGap(299, 299, 299)
                        .addComponent(lblResposta, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, indexImgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, indexImgLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(indexImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
        );
        indexImgLayout.setVerticalGroup(
            indexImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(indexImgLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResposta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(indexImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(indexImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 0);
        getContentPane().add(jPanel3, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldEmailActionPerformed
      lblResposta.setText("");
    }//GEN-LAST:event_txtFieldEmailActionPerformed

    private void passFieldSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passFieldSenhaActionPerformed
        lblResposta.setText("");
    }//GEN-LAST:event_passFieldSenhaActionPerformed

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked

        String email = this.txtFieldEmail.getText();
        String senha = String.copyValueOf(this.passFieldSenha.getPassword());
        String resposta = controle.verificaAdm(email, senha);

        if (controle.verificaAdm(email, senha).equals("Cadastro não encontrado. Tente novamente!")) {

            if (controle.verificaAluno(email, senha).equals("Sucesso no login!!")) {
                lblResposta.setText("Sucesso no login!!");
                passFieldSenha.setText("");
                txtFieldEmail.setText("");
                System.setProperty("email", email);
                //AlunoReservaUI reserva = new AlunoReservaUI();

                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new AlunoReservaUI().setVisible(true);

                    }
                });
            } else if (controle.verificaAluno(email, senha).equals("Sucesso no login!")) {
                System.out.println("Quero devolver");
                passFieldSenha.setText("");
                txtFieldEmail.setText("");
                System.setProperty("email", email);
                java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new AlunoDevolucaoUI().setVisible(true);

                }
            });
            } else if (controle.verificaAluno(email, senha).equals("Senha inválida!")) {
                
                lblResposta.setText("Senha inválida!");

            } else if (controle.verificaAluno(email, senha).equals("Cadastro não encontrado. Tente novamente!")) {
                lblResposta.setText("Cadastro não encontrado. Tente novamente!");
                
            }

        } else if (controle.verificaAdm(email, senha).equals("Senha inválida!")) {
            lblResposta.setText("Senha inválida!");
        } else if (controle.verificaAdm(email, senha).equals("Sucesso no login!")) {
            passFieldSenha.setText("");
            txtFieldEmail.setText("");
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ServidorControleUI().setVisible(true);

                }
            });
        }


    }//GEN-LAST:event_jToggleButton1MouseClicked

    private void passFieldSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passFieldSenhaMouseClicked
        passFieldSenha.setText("");
        lblResposta.setText("");
    }//GEN-LAST:event_passFieldSenhaMouseClicked

    private void txtFieldEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldEmailMouseClicked
        lblResposta.setText("");
        lblResposta.setText("");
    }//GEN-LAST:event_txtFieldEmailMouseClicked

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
            java.util.logging.Logger.getLogger(IndexLoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IndexLoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IndexLoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IndexLoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        Configurator.initialize(null, "log4j2.xml");

        try {
            HibernateUtil.getSession();
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new IndexLoginUI().setVisible(true);
                }

            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel indexImg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblResposta;
    private javax.swing.JPasswordField passFieldSenha;
    private javax.swing.JTextField txtFieldEmail;
    // End of variables declaration//GEN-END:variables
}
