package edu.ub.prog2.CabezasRodrigoNunezJosep.vista;

import edu.ub.prog2.CabezasRodrigoNunezJosep.controlador.Controlador;
import javax.swing.JOptionPane;

public class FrmNouAlbum extends javax.swing.JDialog {
    
    private final Controlador controlador;
    private final AplicacioUB4 parent;
    
    public FrmNouAlbum(AplicacioUB4 parent, Controlador controlador) {
        super(parent);
        this.controlador = controlador;
        this.parent=parent;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAmount = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblNom = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        slider = new javax.swing.JSlider();
        barra = new javax.swing.JProgressBar();
        btnLimit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crea un nou àlbum");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        lblAmount.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblAmount.setText("Capacitat:");

        btnCrear.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.setToolTipText("Crea el nou àlbum");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
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

        lblNom.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNom.setText("Nom:");

        txtNom.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        slider.setMinimum(1);
        slider.setSnapToTicks(true);
        slider.setToolTipText("Llisca per canviar la capacitat de l'àlbum");
        slider.setValue(10);
        slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderStateChanged(evt);
            }
        });
        slider.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                sliderMouseWheelMoved(evt);
            }
        });
        slider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sliderMouseClicked(evt);
            }
        });

        barra.setForeground(new java.awt.Color(0, 0, 255));
        barra.setMaximum(slider.getMaximum());
        barra.setMinimum(slider.getMinimum());
        barra.setToolTipText("Capacitat total de l'àlbum");
        barra.setValue(slider.getValue());
        barra.setString(String.valueOf(slider.getValue() + " fitxers")
        );
        barra.setStringPainted(true);

        btnLimit.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnLimit.setText("Canviar límit màxim");
        btnLimit.setToolTipText("Canvia el límit màxim de la capacitat");
        btnLimit.setBorder(btnCrear.getBorder());
        btnLimit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblNom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNom))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(418, 418, 418)
                                .addComponent(btnLimit))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAmount)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNom)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAmount)
                    .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        if (this.controlador.existeixAlbum(txtNom.getText())){
            JOptionPane.showMessageDialog(rootPane, "Ja existeix un àlbum amb aquest nom!");
        }else if(txtNom.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "S'ha d'escriure un nom!");
        }else{
            this.controlador.afegirAlbum(txtNom.getText(),slider.getValue());
            this.parent.opcionsComboBox();
            JOptionPane.showMessageDialog(rootPane, "Àlbum '"+txtNom.getText()+"' creat.");
            slider.setValue(10);
            this.dispose();
        }
        
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.txtNom.setText("");
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosed

    private void sliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderStateChanged
        barra.setValue(slider.getValue());
        if(slider.getValue() == 1)
            barra.setString(String.valueOf(slider.getValue()) + " fitxer");
        else
            barra.setString(String.valueOf(slider.getValue()) + " fitxers");
    }//GEN-LAST:event_sliderStateChanged

    private void sliderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sliderMouseClicked
        /*int asd = JOptionPane.showConfirmDialog(null, "Canviar límit màxim?", "Configuració",JOptionPane.YES_NO_OPTION);
        String tmp;
        if(asd == 0){
            while(asd <= 0){
            tmp = JOptionPane.showInputDialog("Introdueix nou límit màxim:");
            asd = Integer.parseInt(tmp);
            }
            slider.setMaximum(asd);
            barra.setMaximum(asd);
        }*/
    }//GEN-LAST:event_sliderMouseClicked

    private void sliderMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_sliderMouseWheelMoved
        slider.setValue(slider.getValue() - evt.getUnitsToScroll());
    }//GEN-LAST:event_sliderMouseWheelMoved

    private void btnLimitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimitActionPerformed
        String tmp = JOptionPane.showInputDialog("Introdueix nou límit màxim:");
        int asd = Integer.parseInt(tmp);
        while(asd <= 0){
            tmp = JOptionPane.showInputDialog("Introdueix nou límit màxim:");
            asd = Integer.parseInt(tmp);
        }
        slider.setMaximum(asd);
        barra.setMaximum(asd);
    }//GEN-LAST:event_btnLimitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barra;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnLimit;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblNom;
    private javax.swing.JSlider slider;
    private javax.swing.JTextField txtNom;
    // End of variables declaration//GEN-END:variables
}