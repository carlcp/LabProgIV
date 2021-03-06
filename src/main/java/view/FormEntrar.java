/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.UsuarioDAO;
import javax.swing.JOptionPane;
import model.Usuario;
public class FormEntrar extends javax.swing.JFrame {

    /**
     * Creates new form FormEntrar
     */
    public FormEntrar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogin = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        lblSenha = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLogin.setFont(new java.awt.Font("Tempus Sans ITC", 0, 36)); // NOI18N
        lblLogin.setText("LOGIN");

        lblUsuario.setFont(new java.awt.Font("Tempus Sans ITC", 0, 20)); // NOI18N
        lblUsuario.setText("USUARIO");

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        txtSenha.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        lblSenha.setFont(new java.awt.Font("Tempus Sans ITC", 0, 20)); // NOI18N
        lblSenha.setText("SENHA");

        btnSair.setFont(new java.awt.Font("Tempus Sans ITC", 0, 20)); // NOI18N
        btnSair.setForeground(new java.awt.Color(12, 35, 195));
        btnSair.setText("SAIR");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnCadastrar.setFont(new java.awt.Font("Tempus Sans ITC", 0, 20)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(12, 35, 195));
        btnCadastrar.setText("CADASTRAR");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnEntrar.setFont(new java.awt.Font("Tempus Sans ITC", 0, 20)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(12, 35, 195));
        btnEntrar.setText("ENTRAR");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario)
                    .addComponent(lblSenha)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(lblLogin))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSair)
                        .addGap(27, 27, 27)
                        .addComponent(btnCadastrar)
                        .addGap(27, 27, 27)
                        .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtSenha, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogin)
                .addGap(37, 37, 37)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnCadastrar)
                    .addComponent(btnEntrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        FormCadastrarUsuario frm = new FormCadastrarUsuario();
        frm.setVisible(true);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        // TODO add your handling code here:
        Usuario u = new Usuario();
        u.setUsuario(txtUsuario.getText());
        u.setSenha(new String(txtSenha.getPassword()));

        if (u.getUsuario().trim().isEmpty() ||
            u.getSenha().trim().isEmpty()){

            JOptionPane.showMessageDialog(
                null,
                "Usu??rio e/ou senha n??o pode ser vazio",
                "Login",
                JOptionPane.ERROR_MESSAGE
            );
        }else{

            if (new UsuarioDAO().login(u)){

                //login realizado com sucesso!
                FormPrincipal f = new FormPrincipal();
                f.setVisible(true);
                this.dispose();

            }else{
                JOptionPane.showMessageDialog(
                    null,
                    "Usu??rio e/ou senha inv??lido",
                    "Login",
                    JOptionPane.ERROR_MESSAGE
                );
            }

        }
    }//GEN-LAST:event_btnEntrarActionPerformed

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
            java.util.logging.Logger.getLogger(FormEntrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormEntrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormEntrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormEntrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormEntrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
