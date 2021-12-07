/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CategoriaDAO;
import javax.swing.JOptionPane;
import model.Categoria;

/**
 *
 * @author ycar2
 */
public class FormCategoriaCadastro extends javax.swing.JInternalFrame {

    private String id;
    public FormCategoriaCadastro() {
        initComponents();
        
        this.setTitle("Cadastro de Categoria");
        this.setResizable(false);
    }
    
    public FormCategoriaCadastro(String id) {
      this();
        this.id = id;
        
        //Exibir os dados da Categoria selecionada
        Categoria cat = new CategoriaDAO().pesquisarPorId(id);
        if (cat!= null){
            txtId.setText(Integer.toString(cat.getId()));
            txtNomeCat.setText(cat.getNome());
            cbxFg_Ativo.setSelectedIndex(cat.getFg_ativo());
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

        jLabel2 = new javax.swing.JLabel();
        btnVoltar2 = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNomeCat = new javax.swing.JTextField();
        cbxFg_Ativo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel2.setText("Ativo");

        btnVoltar2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnVoltar2.setText("Voltar");
        btnVoltar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar2ActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel1.setText("   ID ");

        txtNomeCat.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtNomeCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeCatActionPerformed(evt);
            }
        });

        cbxFg_Ativo.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cbxFg_Ativo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        cbxFg_Ativo.setSelectedIndex(1);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel3.setText("Nome ");

        txtId.setEditable(false);
        txtId.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNomeCat, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbxFg_Ativo, javax.swing.GroupLayout.Alignment.LEADING, 0, 1, Short.MAX_VALUE)
                            .addComponent(btnVoltar2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalvar)
                                .addContainerGap(60, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeCat, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxFg_Ativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar2)
                    .addComponent(btnSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnVoltar2ActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        //Recuperar as informacoes da UI
        Categoria obj = new Categoria();
        //retornar a categoria selecionada no comboBox
        obj.setNome(txtNomeCat.getText());
        obj.setFg_ativo(cbxFg_Ativo.getSelectedIndex());

        //executar a operacao
        CategoriaDAO dao = new CategoriaDAO();
        int resultado;

        //se o campo Id estiver vazio
        if (txtId.getText().isEmpty()){
            //inserir
            resultado = dao.inserir(obj);
        }else{
            obj.setId(Integer.parseInt(txtId.getText()));
            resultado = dao.atualizar(obj);
        }

        if (resultado == 1){
            JOptionPane.showMessageDialog(
                null,
                "Operacao realizada com sucesso!"
            );

        }else{
            JOptionPane.showMessageDialog(
                null,
                "Ocorreu um erro.",
                "Posto",
                JOptionPane.ERROR_MESSAGE
            );
        }

        this.dispose();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtNomeCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeCatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeCatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar2;
    private javax.swing.JComboBox<String> cbxFg_Ativo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNomeCat;
    // End of variables declaration//GEN-END:variables
}
