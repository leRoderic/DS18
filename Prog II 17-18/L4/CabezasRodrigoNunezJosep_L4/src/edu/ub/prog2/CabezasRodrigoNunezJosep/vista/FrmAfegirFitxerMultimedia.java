package edu.ub.prog2.CabezasRodrigoNunezJosep.vista;

import edu.ub.prog2.CabezasRodrigoNunezJosep.controlador.Controlador;
import edu.ub.prog2.utils.AplicacioException;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FrmAfegirFitxerMultimedia extends javax.swing.JDialog {

    private final Controlador controlador;
    private final AplicacioUB4 parent;
    
    public FrmAfegirFitxerMultimedia(AplicacioUB4 parent, Controlador controlador) {
        super(parent);
        this.controlador = controlador;
        this.parent=parent;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImatge = new javax.swing.JLabel();
        selectImatge = new javax.swing.JButton();
        txtImatge = new javax.swing.JTextField();
        btnAfegir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSelecciona = new javax.swing.JButton();
        selecTipus = new javax.swing.JComboBox<>();
        lblCami = new javax.swing.JLabel();
        txtFitxer = new javax.swing.JTextField();
        lblTipus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Afegeix un nou fitxer multimèdia");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        lblImatge.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblImatge.setText("Camí de la imatge:");
        lblImatge.setEnabled(false);

        selectImatge.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        selectImatge.setText("...");
        selectImatge.setToolTipText("Selecciona...");
        selectImatge.setEnabled(false);
        selectImatge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectImatgeActionPerformed(evt);
            }
        });

        txtImatge.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtImatge.setEnabled(false);

        btnAfegir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAfegir.setText("Afegir");
        btnAfegir.setToolTipText("Afegeix el fitxer a la biblioteca");
        btnAfegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfegirActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancela i tanca la finestra");
        btnCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 0)));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSelecciona.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSelecciona.setText("...");
        btnSelecciona.setToolTipText("Selecciona...");
        btnSelecciona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionaActionPerformed(evt);
            }
        });

        selecTipus.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        selecTipus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vídeo", "Àudio" }));
        selecTipus.setToolTipText("Selecciona el tipus de fitxer...");
        selecTipus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecTipusActionPerformed(evt);
            }
        });

        lblCami.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCami.setText("Camí del fitxer:");

        txtFitxer.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        lblTipus.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTipus.setText("Tipus:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImatge)
                            .addComponent(lblCami)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAfegir, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFitxer)
                            .addComponent(txtImatge))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectImatge)
                            .addComponent(btnSelecciona))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 424, Short.MAX_VALUE)
                        .addComponent(lblTipus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selecTipus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblCami)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSelecciona)
                            .addComponent(txtFitxer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtImatge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImatge)
                    .addComponent(selectImatge))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAfegir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipus)
                    .addComponent(selecTipus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectImatgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectImatgeActionPerformed
        parent.getCercador().setFileSelectionMode(JFileChooser.FILES_ONLY);
        parent.getCercador().setSelectedFile(new File(""));
        parent.getCercador().setCurrentDirectory(new File(System.getProperty("user.home") + System.getProperty("file.separator")+ "Pictures"));
        parent.getCercador().showOpenDialog(this);
        File file = parent.getCercador().getSelectedFile();
        if (file != null && file.isFile()){
            txtImatge.setText(file.getAbsolutePath());        
        }
    }//GEN-LAST:event_selectImatgeActionPerformed

    private void btnAfegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfegirActionPerformed
        switch(this.selecTipus.getSelectedIndex()){
            case 0:
            {
                try {
                    //Vídeo
                    this.controlador.afegirVideo(txtFitxer.getText(), "", "", 3.f, 25, 25, 24.f);
                    this.dispose();
                    break;
                } catch (AplicacioException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                }
            }
            case 1:
            {
                try {
                    //Audio
                    if(this.txtImatge.getText().isEmpty())
                        this.controlador.afegirAudio(txtFitxer.getText(), "", "", "", 3.f, 52);
                    else
                        this.controlador.afegirAudio(txtFitxer.getText(), txtImatge.getText(), "", "", 3.f, 52);
                    this.dispose();
                    break;
                } catch (AplicacioException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                }
            }
        }
        this.parent.ompleBiblio();
    }//GEN-LAST:event_btnAfegirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSeleccionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionaActionPerformed
        parent.getCercador().setFileSelectionMode(JFileChooser.FILES_ONLY);
        parent.getCercador().setSelectedFile(new File(""));
        switch(this.selecTipus.getSelectedIndex()){
            case 0: // Per default a carpeta de vídeos
                parent.getCercador().setCurrentDirectory(new File (System.getProperty("user.home") + System.getProperty("file.separator")+ "Videos"));
                break;
            case 1: // Per default a carpeta de música
                parent.getCercador().setCurrentDirectory(new File (System.getProperty("user.home") + System.getProperty("file.separator")+ "Music"));
        }
        parent.getCercador().showOpenDialog(this);
        File file = parent.getCercador().getSelectedFile();
        if (file != null && file.isFile()){
            txtFitxer.setText(file.getAbsolutePath());        
        }
    }//GEN-LAST:event_btnSeleccionaActionPerformed

    private void selecTipusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecTipusActionPerformed
        switch(this.selecTipus.getSelectedIndex()){
            case 0:
            this.txtImatge.setEnabled(false);
            this.selectImatge.setEnabled(false);
            this.lblImatge.setEnabled(false);
            break;
            case 1:
            this.txtImatge.setEnabled(true);
            this.selectImatge.setEnabled(true);
            this.lblImatge.setEnabled(true);
            break;
        }
    }//GEN-LAST:event_selecTipusActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.txtFitxer.setText("");
        this.txtImatge.setText("");
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAfegir;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSelecciona;
    private javax.swing.JLabel lblCami;
    private javax.swing.JLabel lblImatge;
    private javax.swing.JLabel lblTipus;
    private javax.swing.JComboBox<String> selecTipus;
    private javax.swing.JButton selectImatge;
    private javax.swing.JTextField txtFitxer;
    private javax.swing.JTextField txtImatge;
    // End of variables declaration//GEN-END:variables
}
