/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CategoriaDAO;
import controller.CombustivelDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Combustivel;

/**
 *
 * @author ycar2
 */
public class FormCadastrarCombustivel extends javax.swing.JInternalFrame {
    private String id;
    /**
     * Creates new form FormCadastrarCombustivel1
     */
    public FormCadastrarCombustivel() {
        initComponents();
        this.setTitle("Cadastro de Combustivel");
        this.setResizable(false);
        preencherComboCategoria();
    }
    public  FormCadastrarCombustivel(String id){
        this();
        this.id = id;
        
        //Exibir os dados da Produto selecionada
        Combustivel obj = new CombustivelDAO().pesquisarPorId(id);
        if (obj != null){
            txtId1.setText(Integer.toString(obj.getId()));
            txtNomeComb11.setText(obj.getNome());
            
            //selecionar a Categoria
            DefaultComboBoxModel m = (DefaultComboBoxModel)cbxCategoria1.getModel();
            for (int i = 0; i < m.getSize(); i++) {
                Categoria cat = (Categoria)m.getElementAt(i);
                if ( cat.getId() == obj.getId_categoria() ){
                    cbxCategoria1.setSelectedIndex(i);
                    break;
                }
            }
            txtPreco1.setText(Double.toString(obj.getPreco()));
            txtQuantidade2.setText(Integer.toString(obj.getQntl()));
            txtTaxa1.setText(Double.toString(obj.getTaxa()));
            cbxAtivo1.setSelectedIndex(obj.getFg_ativo());
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

        btnCancelar = new javax.swing.JButton();
        txtQuantidade2 = new javax.swing.JTextField();
        txtPreco1 = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        cbxAtivo1 = new javax.swing.JComboBox<>();
        lblNome3 = new javax.swing.JLabel();
        txtNomeComb11 = new javax.swing.JTextField();
        txtId1 = new javax.swing.JTextField();
        lblNome2 = new javax.swing.JLabel();
        lblId1 = new javax.swing.JLabel();
        lblNome1 = new javax.swing.JLabel();
        cbxCategoria1 = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        lblAtivo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        txtTaxa1 = new javax.swing.JTextField();

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnCancelar.setText("cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtQuantidade2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        txtPreco1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        lblId.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblId.setText("Id");

        cbxAtivo1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        cbxAtivo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        cbxAtivo1.setSelectedIndex(1);

        lblNome3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblNome3.setText("Taxa");

        txtNomeComb11.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        txtId1.setEditable(false);
        txtId1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        lblNome2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblNome2.setText("Preço");

        lblId1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblId1.setText("Categoria");

        lblNome1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblNome1.setText("Quantidade Litros");

        cbxCategoria1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        cbxCategoria1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblAtivo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblAtivo.setText("Ativo");

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblNome.setText("Nome");

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnSalvar.setText("salvar");
        btnSalvar.setToolTipText("salvar os dados");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        txtTaxa1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtTaxa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTaxa1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalvar)
                            .addGap(18, 18, 18)
                            .addComponent(btnCancelar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblId)
                                        .addComponent(txtId1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNome)
                                        .addComponent(txtNomeComb11)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cbxCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblId1))
                                            .addGap(104, 104, 104))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cbxAtivo1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblAtivo))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtQuantidade2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(46, 46, 46)
                                                    .addComponent(lblNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTaxa1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPreco1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNome3)
                                        .addComponent(lblNome2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addGap(56, 56, 56))
                    .addComponent(txtNomeComb11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblId1)
                    .addComponent(lblNome2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPreco1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAtivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNome1)
                            .addComponent(lblNome3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxAtivo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtQuantidade2))
                    .addComponent(txtTaxa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        //Recuperar as informações da UI

        Combustivel obj = new Combustivel();
        obj.setNome(txtNomeComb11.getText());

        //Retornar a Categoria selecionada no ComboBox
        Categoria cat = (Categoria)cbxCategoria1.getSelectedItem();
        obj.setId_categoria(cat.getId());

        obj.setNome(txtNomeComb11.getText());
        obj.setPreco(Double.parseDouble(txtPreco1.getText()));
        obj.setQntl(Integer.parseInt(txtQuantidade2.getText()));
        obj.setTaxa(Double.parseDouble(txtTaxa1.getText()));
        obj.setFg_ativo(cbxAtivo1.getSelectedIndex());

        //Executar a operação
        CombustivelDAO dao = new CombustivelDAO();
        int resultado;

        //se o campo Id estiver vazio
        if (txtId1.getText().isEmpty()){
            //inserir
            resultado = dao.inserir(obj);
        }else{
            //atualizar
            obj.setId(Integer.parseInt(txtId1.getText()));
            resultado = dao.atualizar(obj);
        }

        if (resultado >= 1){
            JOptionPane.showMessageDialog(
                null,
                "Operação realizada com sucesso!"
            );
        }else{
            JOptionPane.showMessageDialog(
                null,
                "Ocorreu um erro.",
                "Loja",
                JOptionPane.ERROR_MESSAGE
            );
        }
        this.dispose();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtTaxa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTaxa1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTaxa1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxAtivo1;
    private javax.swing.JComboBox<String> cbxCategoria1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAtivo;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblId1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JLabel lblNome2;
    private javax.swing.JLabel lblNome3;
    private javax.swing.JTextField txtId1;
    private javax.swing.JTextField txtNomeComb11;
    private javax.swing.JTextField txtPreco1;
    private javax.swing.JTextField txtQuantidade2;
    private javax.swing.JTextField txtTaxa1;
    // End of variables declaration//GEN-END:variables

   private void preencherComboCategoria(){
        //recuperar a lista de categorias
        List<Categoria> lista = new CategoriaDAO().listar();
        
        if (lista != null){
            DefaultComboBoxModel m = new DefaultComboBoxModel();
            for(Categoria obj : lista){
                m.addElement(obj); //{id,nome,fg_ativo}
            }
            cbxCategoria1.setModel(m);
        }
    }

}
